# !/usr/bin/python3
# -*- coding: UTF-8 -*-

import mysql.connector
from colorama import Fore


def save_sql(haoqixinlist):
    print(Fore.GREEN + 'save_sql')

    conn = mysql.connector.connect(user='root', password='root', database='littlesee')
    cursor = conn.cursor()

    from utils.timeUtils import getBetweenDate
    betweendate = getBetweenDate()


    for haoqixin in haoqixinlist:
        cursor_search  = conn.cursor()
        sql = 'select * from diary where indexclass = \'%s\' and address = \'%s\' and dateid BETWEEN %d and %d' % ( haoqixin[3], haoqixin[1], betweendate - 5, betweendate)

        cursor_search.execute(sql)
        statu = cursor_search.fetchall()

        if len(statu) == 0:
            _sql = 'insert into diary(title , image , address , indexclass ,dateid) values (\'%s\',\'%s\',\'%s\',\'%s\',%s)' % (haoqixin[0], haoqixin[2], haoqixin[1], haoqixin[3], betweendate)
            #print(_sql)
            cursor.execute(_sql)


    conn.commit()
    cursor.close()

    print('haoqixin sql run ok')


