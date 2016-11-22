# !/usr/bin/python3
# -*- coding: UTF-8 -*-

import mysql.connector
from colorama import Fore


def save_sql(haoqixinlist):
    print(Fore.GREEN + 'save_sql')

    conn = mysql.connector.connect(user='root', password='', database='little_see')
    cursor = conn.cursor()


    from utils.timeUtils import getBetweenDate
    betweendate = getBetweenDate()


    for haoqixin in haoqixinlist:
        cursor_search  = conn.cursor()
        sql = 'select * from haoqixin where address = \'%s\' and dateid   BETWEEN  %d and %d'%(haoqixin[1] , betweendate - 5 , betweendate)
        cursor_search.execute(sql)
        statu = cursor_search.fetchall()

        if len(statu) == 0:
             cursor.execute('insert into haoqixin(title , title_image , address , dateid) values (%s,%s,%s,%s)',
                           [haoqixin[0], haoqixin[2], haoqixin[1], betweendate])


    conn.commit()
    cursor.close()

    print('haoqixin sql run ok')

