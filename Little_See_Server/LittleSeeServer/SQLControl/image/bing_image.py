
import mysql.connector
from colorama import Fore
from utils.timeUtils import getBetweenDate

conn = mysql.connector.connect(user='root', password='root', database='littlesee')
cursor = conn.cursor()



def save_sql(bingnewslist):
    global cursor
    print(Fore.GREEN + 'save_sql')
    betweendate = getBetweenDate()
    # _conn = mysql.connector.connect(user='root', password='root', database='littlesee')

    for bingnews in bingnewslist:

        # print(bingnews)

        # cursor_search  = conn.cursor()
        # sql = 'select * from diary where indexclass = \'%s\' and address = \'%s\' and dateid BETWEEN %d and %d' %( bingnews[3] , bingnews[1] , betweendate - 5 , betweendate)
        # #sql = 'select * from diary where address = \'%s\' and dateid  BETWEEN  %d and %d' % (bingnews[1], betweendate - 5, betweendate)
        # #print(sql)
        # cursor_search.execute(sql)
        # statu = cursor_search.fetchall()
        #
        # if len(statu) == 0:
        _sql = 'insert into image(title , image , address , indexclass ,dateid) values (\'%s\',\'%s\',\'%s\',\'%s\',%s)' %(bingnews[0],bingnews[2], bingnews[1], bingnews[3], betweendate)
        # print(_sql)
        _sql = _sql.replace('"' , '!@!#!')
        # _sql = _sql.replace('“' , '!@!#!')

        # print(_sql)

        cursor.execute(_sql)
             #cursor.execute('insert i nto diary(title , image , address , indexclass ,dateid) values (%s,%s,%s,%s,%s)', [bingnews[0], bingnews[2], bingnews[1], bingnews[3], betweendate])
        # else:
        #     print(bingnews[0], 'is also')


    conn.commit()
    cursor.close()

    print('bingnews sql run ok')

        #print(bingnews[0])
        #print(bingnews)
