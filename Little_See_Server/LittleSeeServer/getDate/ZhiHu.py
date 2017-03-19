# !/usr/bin/python3
# -*- coding: UTF-8 -*-
from colorama import Fore

from selenium import webdriver
import os



zhihulist = []

def getZhihu():
    print(Fore.GREEN + 'getZhihu')

    chrome_driver = os.path.abspath(r"C:\ftp\chromedriver\chromedriver.exe")
    os.environ["webdriver.chrome.driver"] = chrome_driver

    #driver = webdriver.Chrome(chrome_driver)
    driver = webdriver.PhantomJS(executable_path="/Users/yszsyf/Desktop/github_me/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")

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
        zhihu.insert(3 , '知乎日报')
        zhihulist.append(zhihu)
        #print(zhihu)


    driver.close()
    driver.quit()
    from LittleSeeServer.SQLControl.zhihu_sql import save_sql
    save_sql(zhihulist)


