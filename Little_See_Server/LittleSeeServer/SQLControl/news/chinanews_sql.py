# !/usr/bin/python3


import mysql.connector
from colorama import Fore
from LittleSeeServer.utils.timeUtils import getBetweenDate

conn = mysql.connector.connect(user='root', password='root', database='littlesee')
cursor = conn.cursor()



def check(address , indexclass):
    betweendate = getBetweenDate()
    cursor_search  = conn.cursor()
    # print(chinanews)
    sql = 'select * from news where indexclass = \'%s\' and address = \'%s\' and dateid BETWEEN %d and %d' %( indexclass , address , betweendate - 5 , betweendate)
    # print(sql)
    # print(chinanews)
    cursor_search.execute(sql)
    statu = cursor_search.fetchall()
    if len(statu) == 0:
        return  True
    else:
        return False



def save_sql(chinanewslist):
    global cursor
    print(Fore.GREEN + 'save_sql')
    betweendate = getBetweenDate()
    # _conn = mysql.connector.connect(user='root', password='root', database='littlesee')

    for chinanews in chinanewslist:

        # print(chinanews)

        # cursor_search  = conn.cursor()
        # sql = 'select * from diary where indexclass = \'%s\' and address = \'%s\' and dateid BETWEEN %d and %d' %( chinanews[3] , chinanews[1] , betweendate - 5 , betweendate)
        # #sql = 'select * from diary where address = \'%s\' and dateid  BETWEEN  %d and %d' % (chinanews[1], betweendate - 5, betweendate)
        # #print(sql)
        # cursor_search.execute(sql)
        # statu = cursor_search.fetchall()
        #
        # if len(statu) == 0:
        _sql = 'insert into news(title , image , address , indexclass ,dateid) values (\'%s\',\'%s\',\'%s\',\'%s\',%s)' %(chinanews[0],chinanews[2], chinanews[1], chinanews[3], betweendate)
        # print(_sql)
        _sql = _sql.replace('"' , '!@!#!')
        # _sql = _sql.replace('“' , '!@!#!')

        # print(_sql)

        cursor.execute(_sql)
             #cursor.execute('insert i nto diary(title , image , address , indexclass ,dateid) values (%s,%s,%s,%s,%s)', [chinanews[0], chinanews[2], chinanews[1], chinanews[3], betweendate])
        # else:
        #     print(chinanews[0], 'is also')


    conn.commit()
    cursor.close()

    print('chinanews sql run ok')

        #print(chinanews[0])
        #print(chinanews)
