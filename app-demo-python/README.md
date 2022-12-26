
Install poetry
```sh
pip install poetry
```

```sh
poetry init 
```

Install FastAPI and uvicorn(ASGI Web Server)
```sh
poetry add fastapi uvicorn[standard]
```

Activate virtual env
```sh
poetry shell
```

Luanch web server
```
$ uvicorn main:app --reload

INFO:     Will watch for changes in these directories: ['D:\\ELK\\APM\\app-demo-python']
INFO:     Uvicorn running on http://127.0.0.1:8000 (Press CTRL+C to quit)
INFO:     Started reloader process [8396] using WatchFiles
INFO:     Started server process [26348]
INFO:     Waiting for application startup.
INFO:     Application startup complete.
```

Integrate FlasAPI with ElasticAPM
https://www.elastic.co/guide/en/apm/agent/python/master/starlette-support.html


Install Elastic APM agent
```sh
poetry add elastic-apm
```

If see the log message 
```
Could not register elasticapm.metrics.sets.cpu.CPUMetricSet metricset: psutil not found. Install it to get system and process metrics
```
We could install `psutil` to help collect CPU metrics
```sh
poetry add psutil
```

Afer checking out the repo from github, execute below command.
```
poetry shell
poetry install
```

```
$ uvicorn main:app --reload
```
