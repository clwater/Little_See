# !/usr/bin/python3


import mysql.connector
from colorama import Fore


def save_sql(zhihulist):
    print(Fore.GREEN + 'save_sql')

    conn = mysql.connector.connect(user='root', password='root', database='littlesee')
    cursor = conn.cursor()

    from LittleSeeServer.utils.timeUtils import getBetweenDate
    betweendate = getBetweenDate()


    for zhihu in zhihulist:
        cursor_search  = conn.cursor()
        sql = 'select * from diary where indexclass = \'%s\' and address = \'%s\' and dateid BETWEEN %d and %d' %( zhihu[3] , zhihu[1] , betweendate - 5 , betweendate)
        #sql = 'select * from diary where address = \'%s\' and dateid  BETWEEN  %d and %d' % (zhihu[1], betweendate - 5, betweendate)
        #print(sql)
        cursor_search.execute(sql)
        statu = cursor_search.fetchall()

        if len(statu) == 0:
            _sql = 'insert into diary(title , image , address , indexclass ,dateid) values (\'%s\',\'%s\',\'%s\',\'%s\',%s)' %(zhihu[0],zhihu[2], zhihu[1], zhihu[3], betweendate)
            #print(_sql)
            cursor.execute(_sql)
             #cursor.execute('insert into diary(title , image , address , indexclass ,dateid) values (%s,%s,%s,%s,%s)', [zhihu[0], zhihu[2], zhihu[1], zhihu[3], betweendate])
        # else:
        #     print(zhihu[0], 'is also')


    conn.commit()
    cursor.close()

    print('zhihu sql run ok')

        #print(zhihu[0])
        #print(zhihu)
