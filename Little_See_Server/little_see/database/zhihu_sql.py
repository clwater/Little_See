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

        #print(zhihu[0])
        #print(zhihu)


# # # 创建user表:
# # cursor.execute('create table user (id varchar(20) primary key, name varchar(20))')
# # 插入一行记录，注意MySQL的占位符是%s:
# # cursor.execute('insert into user (id, name) values (%s, %s)', ['3', 'Mich3ael2'])
# # cursor.rowcount
# #
# # 提交事务:
# # conn.commit()
# # cursor.close()
# # 运行查询:
# cursor = conn.cursor()
# cursor.execute('select * from zhihu')
# values = cursor.fetchall()
# for va in values:
#     print(va)
# # 关闭Cursor和Connection:
# cursor.close()
# conn.close()
#
#
# def datebasetest():
#     print("datebasetest")