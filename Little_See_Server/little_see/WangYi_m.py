# !/usr/bin/python3
# -*- coding: UTF-8 -*-


from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
import time

wangyilist = []


def getIndexInfo(driver ,index):
    #print(index)


    xpath ="//*[@id=\"channel_all\"]/div[3]/section[" + str(index) + "]/a"
    _path = xpath + "/div[2]/div[2]/div[1]/span[1]"
    type = driver.find_element_by_xpath(_path)
    print (type.text)

    text = driver.find_element_by_xpath(xpath)
    print(text.get_attribute("href"))
    print("||||")


    _xpath = xpath + "/div[1]/img"
    text = driver.find_element_by_xpath(_xpath)
    print(text.get_attribute("src"))
    print("||||")
    _xpath = xpath + "/div[2]/div[1]/span"
    text = driver.find_element_by_xpath(_xpath)
    print(text.text)
    print("@@@@")




def main():
    #driver = webdriver.PhantomJS(executable_path="/Users/haizhi/Desktop/Little_See/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")
    driver = webdriver.PhantomJS(executable_path="/Users/yszsyf/Desktop/android/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")
    #driver.get("http://3g.163.com/touch/news/subchannel/all?nav=2&version=v_standard")
    driver.get("http://3g.163.com/touch/all?nav=2&version=v_standard")
    time.sleep(5)

    # getIndexInfo(driver, 1)
    index = 1

    while True:
        index_length = index + 10
        while index < index_length:
            try :
                getIndexInfo(driver , index)
            except Exception :
                print ("error")
            index = index + 1

        #
        #
        # _path = "//*[@id=\"channel_all\"]/div[3]/section[" + str(index) + "]/a"
        # ele = driver.find_element_by_xpath(_path)
        # ActionChains(driver).move_to_element(ele).perform()
        # time.sleep(10)









main()