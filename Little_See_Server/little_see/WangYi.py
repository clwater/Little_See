# !/usr/bin/python3
# -*- coding: UTF-8 -*-


from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
import time

wangyilist = []


def getIndexInfo(driver ,index):
    #print(index)
    xpath = "//*[@id=\"index2016_wrap\"]/div[2]/div[2]/div[3]/div[2]/div[5]/div/ul/li[1]/div/div[" + str(index) + "]/a"
    #xpath = "//*[@id=\"index2016_wrap\"]/div[2]/div[2]/div[3]/div[2]/div[5]/div/ul/li[1]/div/div[1]/a"
    test = driver.find_element_by_xpath(xpath)
    print(test.get_attribute("href"))
    print("||||")
    xpath = xpath + "/img"
    test = driver.find_element_by_xpath(xpath)
    print(test.get_attribute("src"))
    print("||||")
    print(test.get_attribute("alt"))
    print("@@@@")

def main():
    #driver = webdriver.PhantomJS(executable_path="/Users/haizhi/Desktop/Little_See/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")
    driver = webdriver.PhantomJS(executable_path="/Users/yszsyf/Desktop/android/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")
    driver.get("http://news.163.com/")
    time.sleep(5)

    index = 1
    index_length = 20
    while index < index_length:
        getIndexInfo(driver , index)
        index = index + 1




        # except Exception :
        #     index = index - 1
        #     _path = "//*[@id=\"index2016_wrap\"]/div[2]/div[2]/div[3]/div[2]/div[5]/div/ul/li[1]/div/div[" + str(index) + "]/a"
        #     ele = driver.find_element_by_xpath(_path)
        #     ActionChains(driver).move_to_element(ele).perform()
        #     time.sleep(5)
        #     index = index + 1







    # xpath = "//*[@id=\"index2016_wrap\"]/div[2]/div[2]/div[3]/div[2]/div[5]/div/ul/li[1]/div/div[1]/div/div[1]"
    # ele = driver.find_element_by_xpath(xpath)
    # print(ele.text)

   # print(driver.page_source)





main()