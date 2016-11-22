import tornado.web
import tornado.ioloop
import socket

class ParentRequesyHandler(tornado.web.RequestHandler):
    def showInfo(self):
        print("source ip :" , self.request.remote_ip)

class Handler_ZhiHu(ParentRequesyHandler):
    def get(self):
        ParentRequesyHandler.showInfo(self)
        message = self.get_argument("date", None)
        from server.server_zhihu import re_data_zhihu
        json = re_data_zhihu(message)
        self.write(json)

class Handler_HaoQiXin(ParentRequesyHandler):
    def get(self):
        ParentRequesyHandler.showInfo(self)
        message = self.get_argument("date", None)
        from server.server_haoqixin import re_data_haoqixin
        json = re_data_haoqixin(message)
        self.write(json)

class Main(ParentRequesyHandler):
    def get(self, *args, **kwargs):
        ParentRequesyHandler.showInfo(self)
        self.write("hello")


application = tornado.web.Application([
    (r"/" , Main ),
    (r"/zhihu" , Handler_ZhiHu),
    (r"/haoqixin" , Handler_HaoQiXin)

])

def runServer():
    port = 9006
    application.listen(port)

    localIP = socket.gethostbyname(socket.gethostname())
    print("run in %s:%s"%(localIP,port))
    tornado.ioloop.IOLoop.instance().start()