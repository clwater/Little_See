
import mysql.connector


def re_data_news(indexclass):
    print(indexclass)
    conn = mysql.connector.connect(user='root', password='root', database='littlesee')
    cursor = conn.cursor()
    from utils.timeUtils import getBetweenDateWithGet
    betweendate = getBetweenDateWithGet()
    sql = 'select * from news where indexclass in %s and dateid > %s order by `id` desc LIMIT 100'%(indexclass ,  betweendate)

    # print(sql)
    cursor.execute(sql)
    newslist = cursor.fetchall()

    if len(newslist) == 0:
        json ='{"statu" : "1" , "date" : ""}'
    else :
        json = '{"statu":"0","date":['


        for news in newslist:

            title = str(news[1], encoding='utf-8')
            image = str(news[2], encoding='utf-8')
            address = str(news[3], encoding='utf-8')
            indexclass = str(news[4], encoding='utf-8')

            #json = json + '{ "title":"%s" , "image" : "%s" , "address" : "%s" , "indexclass" : "%s"},'%(news[1] , news[2] , news[3] , news[4])

            json = json + '{ "title":"'+title+'" , "image" : "'+image+'" , "address" : "'+address+'" , "indexclass" : "'+indexclass+'"},'

        json = json[0:len(json) - 1]

        json = json + "]}"


    print(json)

    cursor.close()
    conn.close()


    return json

    # return indexclass
