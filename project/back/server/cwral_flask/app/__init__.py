# file name : __init__.py
from flask import Flask

app = Flask(__name__)

# 추가할 모듈이 있다면 추가
from app.main.index import main as main
from app.main.app_login import app_login_blueprint
# config 파일이 있다면 추가


# 추가한 파일을 연동해주는 역활
app.register_blueprint(main)
app.register_blueprint(app_login_blueprint)

