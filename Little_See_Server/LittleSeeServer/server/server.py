import tornado.web
import tornado.ioloop
import socket

ip = "0.0.0.0"

class ParentRequesyHandler(tornado.web.RequestHandler):
    def showInfo(self):
        if ip != self.request.remote_ip:
            print("source ip :" , self.request.remote_ip)

class Main(ParentRequesyHandler):
    def get(self, *args, **kwargs):
        ParentRequesyHandler.showInfo(self)
        self.write("hello")

class Handler_Diary(ParentRequesyHandler):
    def get(self):
        ParentRequesyHandler.showInfo(self)
        indexclass = self.get_argument("indexclass" , None)

        from server.server_diary import re_data_diary
        json = re_data_diary(indexclass)
        self.write(json)

class Handler_News(ParentRequesyHandler):
    def get(self):
        ParentRequesyHandler.showInfo(self)
        indexclass = self.get_argument("indexclass" , None)

        from server.server_news import re_data_news
        json = re_data_news(indexclass)
        self.write(json)

class Handler_DiaryClass(ParentRequesyHandler):
    def get(self):
        ParentRequesyHandler.showInfo(self)
        json = "{\"statu\":\"success\" , \"dirayClass\" : [\"好奇心日报\" , \"知乎日报\"]}"
        self.write(json)


class Handler_Image(ParentRequesyHandler):
    def get(self):
        ParentRequesyHandler.showInfo(self)
        indexclass = self.get_argument("indexclass" , None)

        from server.server_image import re_data_image
        json = re_data_image(indexclass)

        self.write(json)
        # self.write(indexclass)


application = tornado.web.Application([
    (r"/" , Main ),
    (r"/diary" , Handler_Diary),
    (r"/dirayClass" , Handler_DiaryClass),
    (r"/news" , Handler_News),
    (r"/image" , Handler_Image),


])

def runServer():
    port = 9008
    application.listen(port)

    localIP = socket.gethostbyname(socket.gethostname())
    print("run in %s:%s"%(localIP,port))
    tornado.ioloop.IOLoop.instance().start()