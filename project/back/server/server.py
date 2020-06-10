from flask import Flask, request

UPLOAD_DIR = '..'

app = Flask(__name__)

@app.route('/')
def hello():
	return 'Hello world!'

@app.route('/upload', methods=['POST'])
def upload_file():
	f = request.files['file']
	if not f:
		return 'error', 500

	f.save(UPLOAD_DIR + f.filename)
	return 'uploaded', 200


if __name__ == '__main__':
	app.run(host = '0.0.0.0')
