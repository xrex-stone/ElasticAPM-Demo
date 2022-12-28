
This project is a python application. Using FastAPI as web server. Tech stack includes `FastAPI`, `uvicorn` and `elastic-apm` (Elastic APM library for python)

## Prepare Dev Environment
```
poetry shell
poetry install
```

## Luanch Web Server
```
uvicorn main:app --reload
```
The default port is `8000`


## Appedix : 

### The step of building the FastAPI application with poetry
Install poetry
```sh
pip install poetry
```

```sh
poetry init 
```

Install FastAPI and libraries
```sh
poetry add fastapi uvicorn[standard] psutil elastic-apm
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