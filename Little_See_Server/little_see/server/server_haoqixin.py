
import mysql.connector


def re_data_haoqixin(betweendate):
    conn = mysql.connector.connect(user='root', password='', database='little_see')
    cursor = conn.cursor()

    sql = 'select * from haoqixin where dateid = %s'%(betweendate)

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
