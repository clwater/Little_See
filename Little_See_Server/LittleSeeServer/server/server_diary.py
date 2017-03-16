
import mysql.connector


def re_data_diary(indexclass):
    print(indexclass)
    conn = mysql.connector.connect(user='root', password='root', database='littlesee')
    cursor = conn.cursor()
    from LittleSeeServer.utils.timeUtils import getBetweenDateWithGet
    betweendate = getBetweenDateWithGet()
    sql = 'select * from diary where indexclass in %s and dateid > %s'%(indexclass ,  betweendate)

    print(sql)
    cursor.execute(sql)
    diarylist = cursor.fetchall()
    json = '{"statu":"diary","date":['


    for diary in diarylist:
        # print(diary)
        json = json + '{ "title":"%s" , "image" : "%s" , "address" : "%s" , "indexclass" : "%s"},'%(diary[1] , diary[2] , diary[3] , diary[4])

    json = json[0:len(json) - 1]

    json = json + "]}"


    cursor.close()
    conn.close()


    return json

    # return indexclass
