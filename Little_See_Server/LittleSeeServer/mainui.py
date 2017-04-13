
def buttonActioon_1():
    print('更新咨询')
    # from getDate.diary.HaoQiXin import getHaoQiXin
    # getHaoQiXin()
    from getDate.diary.ZhiHu import getZhihu
    getZhihu()

def buttonActioon_2():
    print('更新新闻')
    from getDate.news.ChinaNews import getChinaNews
    getChinaNews()

def starctmain():
    from main import main
    main()

def starctmain_step():
    import threading
    thread_servermain = threading.Thread(target=starctmain, name='servermain')
    thread_servermain.start()
    # thread_servermain.join()


def ins(ip):

    import tkinter
    root = tkinter.Tk()
    root.geometry('600x400')

    label = tkinter.Label(root,text='真难')
    label.pack()


    tkinter.Label(root , text = ip).pack()

    tkinter.Button(root, text='开启服务器', command=starctmain_step).pack()

    tkinter.Button(root , text ='更新咨询' , command = buttonActioon_1).pack()

    tkinter.Button(root , text ='更新新闻' , command = buttonActioon_2).pack()

    tkinter.mainloop()

def startui():

    import socket
    localIP = socket.gethostbyname(socket.gethostname())
    ins(localIP)



startui()

