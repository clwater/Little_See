
import mysql.connector


def test1():
    conn = mysql.connector.connect(user='root', password='root', database='littlesee')
    cursor = conn.cursor()

    sql = 'select title from news'

    # print(sql)
    cursor.execute(sql)
    diarylist = cursor.fetchall()

    for diary in diarylist:
        print(str(diary[0], encoding='utf-8'))

    cursor.close()
    conn.close()

test1()
