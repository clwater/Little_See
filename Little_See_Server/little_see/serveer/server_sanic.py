from sanic import Sanic
from sanic.response import json

app = Sanic(__name__)

@app.route("/json")
def post_json(request):
    return json({ "received": True, "message": request.json })

@app.route("/form")
def post_json(request):
    return json({ "received": True, "form_data": request.form, "test": request.form.get('test') })

@app.route("/files")
def post_json(request):
    test_file = request.files.get('test')

    file_parameters = {
        'body': test_file.body,
        'name': test_file.name,
        'type': test_file.type,
    }

    return json({ "received": True, "file_names": request.files.keys(), "test_file_parameters": file_parameters })

@app.route("/query_string")
def query_string(request):
    return json({ "parsed": True, "args": request.args, "url": request.url, "query_string": request.query_string })

@app.route('/tag/<tag>')
async def person_handler(request, tag):
    return text('Tag - {}'.format(tag))

@app.route('/number/<integer_arg:int>')
async def person_handler(request, integer_arg):
    return text('Integer - {}'.format(integer_arg))

@app.route('/number/<number_arg:number>')
async def person_handler(request, number_arg):
    return text('Number - {}'.format(number))

@app.route('/person/<name:[A-z]>')
async def person_handler(request, name):
    return text('Person - {}'.format(name))

@app.route('/folder/<folder_id:[A-z0-9]{0,4}>')
async def folder_handler(request, folder_id):
    return text('Folder - {}'.format(folder_id))
app.run(host="0.0.0.0", port=8001)