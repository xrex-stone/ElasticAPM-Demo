package com.example.appdemo.controller;

import com.example.appdemo.dao.TodoRepository;
import com.example.appdemo.entity.Todo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value="/todo")
public class TodoController {
    Logger logger = LoggerFactory.getLogger(TodoController.class);

    private TodoRepository todoRepository;
    private StringRedisTemplate redisTemplate;

    public TodoController(TodoRepository todoRepository, StringRedisTemplate stringRedisTemplate) {
        this.todoRepository = todoRepository;
        this.redisTemplate = stringRedisTemplate;
    }

    @GetMapping("/")
    public @ResponseBody List<Todo> queryAll() {
        return todoRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Todo queryById(@PathVariable("id")Long id) throws JsonProcessingException {
       return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    @PostMapping("/")
    public @ResponseBody Todo create(@RequestBody CreateTodoDto requestDto) {
        return todoRepository.save(requestDto.toTodo());
    }


    @GetMapping("/complex_operation")
    public @ResponseBody List<Todo> complexOp() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        // query from DB
        List<Todo> allTodo = todoRepository.findAll();

        // cache data to Redis
        String cachedKey = "all_data";
        redisTemplate.opsForValue().set(cachedKey, mapper.writeValueAsString(allTodo));
        redisTemplate.expire(cachedKey, 10, TimeUnit.SECONDS);
        logger.info("cache todo size : {}", allTodo.size());

        // query external service
        Map user = new RestTemplateBuilder().build().getForObject("http://127.0.0.1:8000/user", Map.class);
        logger.info("query user data : {}", user);

        return allTodo;
    }

    public static class CreateTodoDto {
        private String memo;

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public Todo toTodo() {
            Todo todo = new Todo();
            todo.setMemo(memo);
            return todo;
        }
    }

}
