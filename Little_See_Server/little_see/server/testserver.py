from sanic import Sanic
from sanic.response import json

app = Sanic(__name__)

@app.route("/")
async def test(request):
    return json({ "hello": "world1" })

app.run(host="127.0.0.1", port=8000)