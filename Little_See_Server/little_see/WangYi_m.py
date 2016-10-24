# !/usr/bin/python3
# -*- coding: UTF-8 -*-


from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
import time

wangyilist = []


def getIndexInfo(driver ,index):
    #print(index)

    xpath =  "//*[@id=\"channel_news\"]/div[2]/section[" + str(index) + "]/a"
    test1 = driver.find_element_by_xpath(xpath)

    _xpath1 = xpath + "/div[1]/img"
    test2 = driver.find_element_by_xpath(_xpath1)

    _xpath2 = xpath + "/div[2]/div[1]"
    test3 = driver.find_element_by_xpath(_xpath2)
    #
    # print(test1.get_attribute("href"))
    # print("||||")
    # print(test2.get_attribute("src"))
    # print("||||")
    # print(test3.text)
    # print("@@@@")

    if test1.get_attribute("href")!=None :
        if test2.get_attribute("src")!=None :
            if test3.text.strip()!='':
                print(test1.get_attribute("href"))
                print("||||")
                print(test2.get_attribute("src"))
                print("||||")
                print(test3.text)
                print("@@@@")

def main():
    driver = webdriver.PhantomJS(executable_path="/Users/haizhi/Desktop/Little_See/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")
    #driver = webdriver.PhantomJS(executable_path="/Users/yszsyf/Desktop/android/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")
    driver.get("http://3g.163.com/touch/news/subchannel/all?nav=2&version=v_standard")
    time.sleep(5)

    #getIndexInfo(driver, 1)
    index = 1

    while True:
        index_length = index + 10
        while index < index_length:
            try :
                getIndexInfo(driver , index)
            except Exception :
                ...
            index = index + 1



        _path = "//*[@id=\"channel_news\"]/div[2]/section[" + str(index) + "]/a"
        ele = driver.find_element_by_xpath(_path)
        ActionChains(driver).move_to_element(ele).perform()
        time.sleep(10)









main()