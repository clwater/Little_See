#!/usr/bin/python3
# -*- coding: UTF-8 -*-

#import MySQLdb

#import pymysql

from selenium import webdriver
zhihulist = []

#def save():
   #db = pymysql.connect("localhost", "root", "123456", "little_see")
    # 使用cursor()方法获取操作游标
   # cursor = db.cursor()
    # SQL 插入语句

    # for zhihu in zhihulist:
    #     sql = "INSERT INTO zhihu values('1' , '1' , '1')"
    #     cursor.execute(sql)
    #     db.commit()


    # sql = "INSERT INTO zhihu (`id`, `titile`, `address`, `image_address`) VALUES ('', '2', '2', '2')"
    # cursor.execute(sql)
    # db.commit()

    # try:
    #     # 执行sql语句
    #
    #     # 提交到数据库执行
    #
    # except:
    #     # 如果发生错误则回滚
    #     db.rollback()

def main():
    driver = webdriver.PhantomJS(executable_path="/Users/yszsyf/Desktop/android/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")
    driver.get("http://daily.zhihu.com/")
    #print(driver.page_source)
    storelist = driver.find_elements_by_class_name("wrap")
    linklist = driver.find_elements_by_class_name("link-button")
    imagelist = driver.find_elements_by_class_name("preview-image")

    zhihu_length = len(storelist)

    for index  in range(zhihu_length):
        zhihu = []
        zhihu.insert(0, storelist[index].text)
        zhihu.insert(1, linklist[index].get_attribute("href"))
        zhihu.insert(2, imagelist[index].get_attribute("src"))
        zhihulist.append(zhihu)

    for zhihu in zhihulist:
        print(zhihu)

    #save()





main()