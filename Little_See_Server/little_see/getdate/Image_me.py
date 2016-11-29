# !/usr/bin/python3
# -*- coding: UTF-8 -*-
import re

from colorama import Fore

from selenium import webdriver
from database.zhihu_sql import save_sql
import os




def getImageBing():
    print(Fore.GREEN + 'getBingImage')

    chrome_driver = os.path.abspath(r"C:\ftp\chromedriver\chromedriver.exe")
    os.environ["webdriver.chrome.driver"] = chrome_driver

    # driver = webdriver.Chrome(chrome_driver)
    driver = webdriver.PhantomJS(
        executable_path="/Users/haizhi/Desktop/Little_See/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")
    # driver = webdriver.PhantomJS(executable_path="/Users/yszsyf/Desktop/android/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")
    url = "https://www.bing.com/"
    driver.get(url)

    #print(driver.page_source)
    text = driver.page_source


    _url = re.findall(r"g_img=.*?.jpg", text, re.I)
    print(_url)
    image_url = _url[0].replace("g_img={url: \"/az/hprichbg/rb/", "http://images.ioliu.cn/bing/")
    print(image_url)

    if "videocontent" in image_url:
        # _text = re.findall(r"g_img=.*?//.*?/.*?/", image_url, re.I)
        # print(image_url.replace(_text , ))
        image_url = image_url.replace("g_img={url: \"//" , "http://")
        print(image_url)

    #from database.image_sql import save_sql
    #save_sql(image_url , "bing")
    #"http://images.ioliu.cn/bing/GrizzlyPeakSFVideo_ZH-CN11282703590_1920x1080.jpg"

getImageBing()




