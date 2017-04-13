# !/usr/bin/python3
# -*- coding: UTF-8 -*-
import time

from colorama import Fore
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains

haoqixinlist = []


def getIndexInfo(driver ,index):
    haoqixin = []
    #print(index)
    xpath = "/html/body/div[2]/div[1]/div[" + str(index) + "]/a"
    # xpath = "/html/body/div[2]/div[1]/div[" + str(index) + "]/a/div[1]/div/img"
    test = driver.find_element_by_xpath(xpath)
    text_href = test.get_attribute("href")
    haoqixin.insert(1 , text_href)
    xpath = xpath + "/div[1]/div/img"
    test = driver.find_element_by_xpath(xpath)
    text_src = test.get_attribute("data-src")
    haoqixin.insert(2 , text_src)
    text_text = test.get_attribute("alt")
    haoqixin.insert(0 , text_text)
    haoqixin.insert(3 , '好奇心日报')

    import re
    pd = re.findall('大公司头条' ,  text_text)
    if len(pd) < 1:
        haoqixinlist.append(haoqixin)


def getHaoQiXin():
    print(Fore.GREEN + 'getHaoQiXin')

    # chrome_driver = os.path.abspath(r"C:\ftp\chromedriver\chromedriver.exe")
    # os.environ["webdriver.chrome.driver"] = chrome_driver
    #
    # driver = webdriver.Chrome(chrome_driver)

    driver = webdriver.PhantomJS(executable_path="/Users/yszsyf/Desktop/github_me/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")
    #driver = webdriver.PhantomJS(executable_path="/Users/yszsyf/Desktop/android/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")
    driver.get("http://www.qdaily.com/tags/29.html")


    index = 1
    testindex = 1
    while testindex < 11:
        temp_index = index + 20
        while index < temp_index:
            getIndexInfo(driver, index)
            index = index + 1
        _path = "/html/body/div[2]/div[1]/div["+str(index - 1)+"]/a"
        ele = driver.find_element_by_xpath(_path)
        ActionChains(driver).move_to_element(ele).perform()
        testindex = testindex + 1
        if  testindex != 6:
            time.sleep(3)
        else:
            time.sleep(10)


    driver.close()
    driver.quit()

    # print(haoqixinlist)

    from SQLControl.diary.haoqixin_sql import save_sql
    save_sql(haoqixinlist)
