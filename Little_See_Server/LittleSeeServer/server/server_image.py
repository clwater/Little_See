
import mysql.connector


def re_data_image(indexclass):
    print(indexclass)
    conn = mysql.connector.connect(user='root', password='root', database='littlesee')
    cursor = conn.cursor()
    from utils.timeUtils import getBetweenDateWithGet
    betweendate = getBetweenDateWithGet()
    sql = 'select * from image where indexclass in %s  order by `dateid` desc LIMIT 100'%(indexclass)

    print(sql)
    cursor.execute(sql)
    imagelist = cursor.fetchall()

    if len(imagelist) == 0:
        json ='{"statu" : "1" , "date" : ""}'
    else :
        json = '{"statu":"0","date":['


        for image in imagelist:

            # print(image)

            address = str(image[1], encoding='utf-8')
            indexclass = str(image[2], encoding='utf-8')
            # dateid = str(image[3], encoding='utf-8')
            text = str(image[4], encoding='utf-8')

            #json = json + '{ "title":"%s" , "image" : "%s" , "address" : "%s" , "indexclass" : "%s"},'%(image[1] , image[2] , image[3] , image[4])

            json = json + '{ "address":"'+address+'" , "text" : "'+text+'" , "indexclass" : "'+indexclass+'"},'

        json = json[0:len(json) - 1]

        json = json + "]}"


    # print(json)

    cursor.close()
    conn.close()

    return json
