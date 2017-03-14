# !/usr/bin/python3
# -*- coding: UTF-8 -*-

from server.server import runServer

import time, threading
from colorama import init,Fore

def getInfoDate():
    print(Fore.GREEN + 'getInfoDate is running')

    while True:
        local_time = time.strftime('%Y-%m-%d %H:%M',time.localtime(time.time()))
        local_hours = time.strftime('%H',time.localtime(time.time()))
        local_minute = time.strftime('%M',time.localtime(time.time()))
        print("time : " , local_time)
        print("" , local_hours , ":" , local_minute)


        # # if local_hours == 6 and local_minute < 51:
        # if False:
        #     #每天6点 更新所有知乎日报 好奇心日报 图片 数据
        #     from getdate.ZhiHu import getZhihu
        #     getZhihu()
        #     from getdate.HaoQiXin import getHaoQiXin
        #     getHaoQiXin()
        #     from getdate.Image_me import getImageBing
        #     getImageBing()
        #
        #


        time.sleep(60 * 50)

def startServer():
    print(Fore.GREEN + 'startServer is running')
    runServer()



if __name__ == '__main__':
    init(autoreset=True)
    print(Fore.RED + 'Server is running')

    thread_getInfoDate = threading.Thread(target=getInfoDate, name='getInfoDate')
    thread_startServer = threading.Thread(target=startServer, name='startServer')
    thread_getInfoDate.start()
    thread_startServer.start()
    thread_getInfoDate.join()
    thread_startServer.join()

