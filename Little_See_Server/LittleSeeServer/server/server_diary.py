
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
    haoqixinlist = cursor.fetchall()
    json = '{"statu":"haoqixin","date":['


    for haoqixin in haoqixinlist:
        json = json + '{ "title":"%s" , "title_image" : "%s" , "address" : "%s"},'%(haoqixin[4] , haoqixin[1] , haoqixin[2])

    json = json[0:len(json) - 1]

    json = json + "]}"


    cursor.close()
    conn.close()


    return json

    # return indexclass
