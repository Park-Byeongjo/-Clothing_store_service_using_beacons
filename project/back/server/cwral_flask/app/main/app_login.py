from flask import Blueprint, request, render_template, flash, redirect, url_for, jsonify
from flask import current_app as app
from app.module import dbModule

app_login_blueprint = Blueprint('app_login', __name__, url_prefix='/')


@app_login_blueprint.route('/app_login', methods=["POST"])
def app_login():
    if request.methods == "POST":
        print("리퀘스트 로그" + str(request.body))
        id = request.POST.get('userid', '')
        pw = request.POST.get('userpw', '')
        print('id : ' + id + " pw : " + pw)

        db_class = dbModule.Database()

        sql = "SELECT id, pw FROM test_table WHERE " + id + " AND " + pw + ";"
        result = db_class.executeAll(sql)

        if result:
            print("로그인 성공")
            return jsonify({'code': '0000', 'msg': '로그인 성공'}, status=200)
        else:
            print("로그인 실패")
            return jsonify({'code': '1001', 'msg': '로그인 실패'}, status=200)
