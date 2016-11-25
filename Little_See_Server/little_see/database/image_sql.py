# !/usr/bin/python3
# -*- coding: UTF-8 -*-

import mysql.connector
from colorama import Fore


def save_sql(zhihulist):
    print(Fore.GREEN + 'save_sql')

    conn = mysql.connector.connect(user='root', password='', database='little_see')
    cursor = conn.cursor()


    from utils.timeUtils import getBetweenDate
    betweendate = getBetweenDate()


    for zhihu in zhihulist:
        cursor_search  = conn.cursor()
        sql = 'select * from zhihu where address = \'%s\' and dateid   BETWEEN  %d and %d'%(zhihu[1] , betweendate - 5 , betweendate)
        cursor_search.execute(sql)
        statu = cursor_search.fetchall()

        if len(statu) == 0:
             cursor.execute('insert into zhihu(title , title_image , address , dateid) values (%s,%s,%s,%s)',
                           [zhihu[0], zhihu[2], zhihu[1], betweendate])
        # else:
        #     print(zhihu[0], 'is also')


    conn.commit()
    cursor.close()

    print('zhihu sql run ok')



def im_local():
    conn = mysql.connector.connect(user='root', password='', database='little_see')
    cursor = conn.cursor()
    betweendate = 0
    f = open("bing.txt", "r")
    lines = f.readlines()
    for line in lines:
        print (line)


        #cursor_search = conn.cursor()
       # sql = 'select * from zhihu where address = \'%s\' and dateid   BETWEEN  %d and %d' % (zhihu[1], betweendate - 5, betweendate)
        #cursor_search.execute(sql)
        #statu = cursor_search.fetchall()

        #if len(statu) == 0:
        cursor = conn.cursor()
        cursor.execute('insert into image(href , statu , dateid ) values (%s,%s,%s)', [line, "bing",  betweendate])



        betweendate = betweendate + 1

    conn.commit()
    cursor.close()


def test2():
    from utils.timeUtils import getBetweenDate_image
    betweendate = getBetweenDate_image()
    print(betweendate)
    #
    # from utils.timeUtils import getBetweenDate
    # betweendate = getBetweenDate()
    # print(betweendate)

    # import datetime
    #
    # d1 = datetime.date(2016, 10, 7)
    # d2 = datetime.date(2015, 8, 15)
    # print((d1 - d2).days)

test2()
#im_local()