
import mysql.connector
from colorama import Fore
# from utils.timeUtils import getBetweenDate_image

# conn = mysql.connector.connect(user='root', password='root', database='littlesee')
# cursor = conn.cursor()



def check():
    conn = mysql.connector.connect(user='root', password='root', database='littlesee')
    from utils.timeUtils import getBetweenDate_image
    betweendate = getBetweenDate_image()
    cursor_search  = conn.cursor()
    # print(chinanews)
    sql = 'select * from image where dateid = \'%s\'' %(betweendate)
    # print(sql)
    # print(chinanews)
    cursor_search.execute(sql)
    statu = cursor_search.fetchall()
    if len(statu) == 0:
        return  True
    else:
        return False



def saveToday(bingimage):
    conn = mysql.connector.connect(user='root', password='root', database='littlesee')
    cursor = conn.cursor()
    print(Fore.GREEN + 'bingimage_save_sql')
    from utils.timeUtils import getBetweenDate_image

    betweendate = getBetweenDate_image()


    _sql = 'insert into image(address , text , indexclass , dateid) values (\'%s\',\'%s\',\'%s\',%s)' % (bingimage[0], bingimage[1], bingimage[3], betweendate)

    print(_sql)

    cursor.execute(_sql)

    conn.commit()
    cursor.close()

    print('bingnews sql run ok')


def save_sql(bingimagelist):
    conn = mysql.connector.connect(user='root', password='root', database='littlesee')
    cursor = conn.cursor()
    # global cursor
    print(Fore.GREEN + 'bingimage_save_sql')
    from utils.timeUtils import getBetweenDate_image



    betweendate = getBetweenDate_image()


    for bingnews in bingimagelist:
        # 'address	indexclass	dateid	text'
        _betweendate = betweendate -  bingnews[2]

        _sql = 'insert into image(address , text , indexclass , dateid) values (\'%s\',\'%s\',\'%s\',%s)' %(bingnews[0],bingnews[1], bingnews[3], _betweendate)

        print(_sql)

        cursor.execute(_sql)



    conn.commit()
    cursor.close()

    print('bingnews sql run ok')

