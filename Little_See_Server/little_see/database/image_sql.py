# !/usr/bin/python3
# -*- coding: UTF-8 -*-

import mysql.connector
from colorama import Fore


def save_sql(image_url , image_statu):
    print(Fore.GREEN + 'save_sql for image')

    conn = mysql.connector.connect(user='root', password='', database='little_see')
    cursor = conn.cursor()

    from utils.timeUtils import getBetweenDate_image
    betweendate = getBetweenDate_image()

    cursor_search  = conn.cursor()
    sql = 'select * from image where href = \'%s\' and dateid   BETWEEN  %d and %d'%(image_url , betweendate - 5 , betweendate)
    cursor_search.execute(sql)
    statu = cursor_search.fetchall()
    if len(statu) == 0:
        cursor.execute('insert into image(href , statu , dateid ) values (%s,%s,%s)', [image_url, image_statu, betweendate])

    conn.commit()
    cursor.close()

    print('image sql run ok')



# def im_local():
#     conn = mysql.connector.connect(user='root', password='', database='little_see')
#     cursor = conn.cursor()
#     betweendate = 0
#     f = open("bing.txt", "r")
#     lines = f.readlines()
#     for line in lines:
#         print (line)
#
#         cursor = conn.cursor()
#         cursor.execute('insert into image(href , statu , dateid ) values (%s,%s,%s)', [line, "bing",  betweendate])
#         betweendate = betweendate + 1
#
#     conn.commit()
#     cursor.close()

#
# def test2():
#     from utils.timeUtils import getBetweenDate_image
#     betweendate = getBetweenDate_image()
#     print(betweendate)
#
# test2()
#im_local()