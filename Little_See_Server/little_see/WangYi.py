# !/usr/bin/python3
# -*- coding: UTF-8 -*-


from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
import time

wangyilist = []


def getIndexInfo(driver ,index):
    #print(index)
    xpath = "/html/body/div[2]/div[1]/div[" + str(index) + "]/a"
    # xpath = "/html/body/div[2]/div[1]/div[" + str(index) + "]/a/div[1]/div/img"
    test = driver.find_element_by_xpath(xpath)
    print(test.get_attribute("href"))
    print("||||")
    xpath = xpath + "/div[1]/div/img"
    test = driver.find_element_by_xpath(xpath)
    print(test.get_attribute("data-src"))
    print("||||")
    print(test.get_attribute("alt"))
    print("@@@@")

def main():
    #driver = webdriver.PhantomJS(executable_path="/Users/haizhi/Desktop/Little_See/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")
    driver = webdriver.PhantomJS(executable_path="/Users/yszsyf/Desktop/android/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")
    driver.get("http://news.163.com/")


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




main()