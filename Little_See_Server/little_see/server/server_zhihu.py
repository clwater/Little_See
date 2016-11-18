
import mysql.connector


def re_data_zhihu(betweendate):
    conn = mysql.connector.connect(user='root', password='', database='little_see')
    cursor = conn.cursor()

    sql = 'select * from zhihu where dateid = %s'%(betweendate)

    cursor.execute(sql)
    zhihulist = cursor.fetchall()
    json = '{"statu":"zhihu","date":['


    for zhihu in zhihulist:
        json = json + '{ "title":"%s" , "title_image" : "%s" , "address" : "%s"},'%(zhihu[1] , zhihu[2] , zhihu[3])

    json = json[0:len(json) - 1]

    json = json + "]}"


    cursor.close()
    conn.close()


    return json
