


import os

from colorama import Fore
import requests
import re

def getBingImage_ALL():
    print(Fore.GREEN + 'getZhihu')

    index = 0

    while index < 1:
        # print(index)
        url = 'https://bing.ioliu.cn/?p=' + str(index)
        reponse = requests.get(url)
        html = reponse.text

        # print(html)
        divList = re.findall('<div class="card progressive">.*?</div>.*?</div>.*?</div>' , html)


        for div in divList:
            # print(div)
            imageaddress = re.findall('<a class="ctrl download".*?</a>' , div)
            imageaddress = imageaddress[0]

            imageaddress = re.findall('href=".*?\"' , imageaddress)
            imageaddress = imageaddress[0]
            imageaddress = imageaddress.replace('href="' , '')
            imageaddress = imageaddress.replace('"' , '')
            imageaddress = imageaddress.replace('/photo/' , '')
            imageaddress = imageaddress.replace('?force=download' , '')
            imageaddress = 'https://static.ioliu.cn/bing/' + imageaddress


            print(imageaddress)


            text = re.findall('<h3>.*?</h3>' , div)
            text = text[0]
            text = text.replace('<h3>' , '')
            text = text.replace('</h3>' , '')

            print(text)
        index = index + 1

getBingImage_ALL()