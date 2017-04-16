


import os

from colorama import Fore
import requests
import re

def getBingImage_ALL():
    print(Fore.GREEN + 'getZhihu')

    index = 0

    while index < 35:
        # print(index)
        url = 'https://bing.ioliu.cn/?p=' + str(index)
        reponse = requests.get(url)
        html = reponse.text

        # print(html)
        divList = re.findall('<div class="item">.*?</div>' , html)


        for div in divList:
            # print(div)
            imageaddress = re.findall('data-progressive=".*?"' , div)
            imageaddress = imageaddress[0]

            imageaddress = imageaddress.replace('data-progressive="' , '')
            imageaddress = imageaddress.replace('"' , '')
            print(imageaddress)

            text = re.findall('<h3>.*?</h3>' , div)
            text = text[0]
            text = text.replace('<h3>' , '')
            text = text.replace('(©' , '')

            print(text)
        index = index + 1

getBingImage_ALL()