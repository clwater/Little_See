# !/usr/bin/python3
# -*- coding: UTF-8 -*-


from selenium import webdriver
haoqixinlist = []



def main():
    driver = webdriver.PhantomJS(executable_path="/Users/haizhi/Desktop/Little_See/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")
    #driver = webdriver.PhantomJS(executable_path="/Users/yszsyf/Desktop/android/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")
    driver.get("http://www.qdaily.com/tags/29.html")
    # print(driver.page_source)
    storelist = driver.find_elements_by_class_name("packery-item")
 #   linklist = driver.find_elements_by_class_name("com-grid-article")
    #imagelist = driver.find_elements_by_class_name(" lazyloaded")

    haoqixin_length = len(storelist)

    for index  in range(haoqixin_length):
        haoqixin = []
        haoqixin.insert(0, storelist[index].text)
 #       haoqixin.insert(1, linklist[index].get_attribute("href"))
     #   haoqixin.insert(2, imagelist[index].get_attribute("src"))
        haoqixinlist.append(haoqixin)

    for haoqixin in haoqixinlist:
        print(haoqixin)


main()