
import mysql.connector


def re_data_image(betweendate ,statu):
    conn = mysql.connector.connect(user='root', password='', database='little_see')
    cursor = conn.cursor()
    sql = 'select * from image where dateid = %s and statu = \'%s\''%(betweendate,statu)
    #sql = 'select * from image where statu = \'%s\'' % (statu)
    cursor.execute(sql)
    imagelist = cursor.fetchall()
    json = '{"statu":"image","date":['
    for image in imagelist:
        json = json + '{ "href":"%s" , "dateid" : "%s" },'%(image[1].replace('\n','') , image[3])
    json = json[0:len(json) - 1]
    json = json + "]}"
    cursor.close()
    conn.close()
    return json


def re_data_image_old(betweendate ,statu):
    conn = mysql.connector.connect(user='root', password='', database='little_see')
    cursor = conn.cursor()
    #betweendate = int(betweendate) -50
    #sql = 'select * from image where dateid = %s and statu = \'%s\''%(betweendate,statu)
    sql = 'select * from image where dateid > %s and statu = \'%s\'' % (betweendate , statu)
    cursor.execute(sql)
    imagelist = cursor.fetchall()
    json = '{"statu":"image","date":['
    for image in imagelist:
        json = json + '{ "href":"%s" , "dateid" : "%s" },'%(image[1].replace('\n','') , image[3])
    json = json[0:len(json) - 1]
    json = json + "]}"
    cursor.close()
    conn.close()
    return json