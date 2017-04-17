
import mysql.connector
from colorama import Fore
# from utils.timeUtils import getBetweenDate_image

# conn = mysql.connector.connect(user='root', password='root', database='littlesee')
# cursor = conn.cursor()



def save_sql(bingimagelist):
    conn = mysql.connector.connect(user='root', password='root', database='littlesee')
    cursor = conn.cursor()
    global cursor
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

