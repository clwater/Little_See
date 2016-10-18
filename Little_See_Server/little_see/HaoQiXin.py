# !/usr/bin/python3
# -*- coding: UTF-8 -*-


from selenium import webdriver
haoqixinlist = []



def main():
    #driver = webdriver.PhantomJS(executable_path="/Users/haizhi/Desktop/Little_See/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")
    driver = webdriver.PhantomJS(executable_path="/Users/yszsyf/Desktop/android/Little_See/Little_See_Server/phantomjs-2.1.1-macosx/bin/phantomjs")
    driver.get("http://www.qdaily.com/tags/29.html")
    # print(driver.page_source)
    #storelist = driver.find_elements_by_class_name("packery-item")
    #linklist = driver.find_elements_by_class_name("com-grid-article")
   # imagelist = driver.find_elements_by_class_name(" lazyloaded")

    index = 1 ;
    while index < 21:
        print (index)
        print ("")
      #  text = ""
        xpath = "/html/body/div[2]/div[1]/div[" + str(index) + "]/a"
        #xpath = "/html/body/div[2]/div[1]/div[" + str(index) + "]/a/div[1]/div/img"
        #print (xpath)
        test = driver.find_element_by_xpath(xpath)
        print (test.get_attribute("href"))
       # text = test.get_attribute("href") + "|||"
        xpath = xpath + "/div[1]/div/img"
        test = driver.find_element_by_xpath(xpath)
        #text = text + test.get_attribute("src") + "|||" + test.get_attribute("alt") + "@@@"
        print (test.get_attribute("src"))
        print (test.get_attribute("alt"))
        #print (text)
        index = index + 1
   # while test


    # print (test.get_attribute("alt"))
    # print (test.get_attribute("src"))




    #l1 = len(imagelist)
    #l2 = len(linklist)

    #print (l1)
    #print (l2)

    # haoqixin_length = len(storelist)
    #
    # for index  in range(haoqixin_length):
    #     haoqixin = []
    #     haoqixin.insert(0, storelist[index].text)
    #     #haoqixin.insert(1, linklist[index].text)
    #     haoqixin.insert(1, linklist[index].get_attribute("href"))
    #  #   haoqixin.insert(2, imagelist[index].get_attribute("src"))
    #     haoqixinlist.append(haoqixin)
    #
    # for haoqixin in haoqixinlist:
    #     print(haoqixin)


main()