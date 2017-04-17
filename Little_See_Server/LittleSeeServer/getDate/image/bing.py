


import os

from colorama import Fore
import requests
import re


bingimageList = []


def getBingImage_Today():
    print(Fore.GREEN + 'getBing')
    reponse = requests.get('https://bing.ioliu.cn/')
    html = reponse.text

    divList = re.findall('<div class="card progressive">.*?</div>.*?</div>.*?</div>', html)

    imageaddress = re.findall('<a class="ctrl download".*?</a>', divList[0])
    imageaddress = imageaddress[0]

    imageaddress = re.findall('href=".*?\"', imageaddress)
    imageaddress = imageaddress[0]
    imageaddress = imageaddress.replace('href="', '')
    imageaddress = imageaddress.replace('"', '')
    imageaddress = imageaddress.replace('/photo/', '')
    imageaddress = imageaddress.replace('?force=download', '')
    imageaddress = 'https://static.ioliu.cn/bing/' + imageaddress


    text = re.findall('<h3>.*?</h3>', divList[0])
    text = text[0]
    text = text.replace('<h3>', '')
    text = text.replace('</h3>', '')
    # print(text)
    if '\'' in text:
        strinfo = re.compile('\'')
        text = strinfo.sub('`', text)

    bingimage = []
    bingimage.append(imageaddress)
    bingimage.append(text)
    bingimage.append(0)
    bingimage.append('Bing')

    from SQLControl.image.bingimage_sql import check
    if check():
        from SQLControl.image.bingimage_sql import saveToday
        saveToday(bingimage)






def getBingImage_ALL():
    print(Fore.GREEN + 'getBing_all')

    index = 0
    _index = 0

    while index < 35:
        print(index)
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


            # print(imageaddress)


            text = re.findall('<h3>.*?</h3>' , div)
            text = text[0]
            text = text.replace('<h3>' , '')
            text = text.replace('</h3>' , '')
            # print(text)
            if '\'' in text:
                strinfo = re.compile('\'')
                text = strinfo.sub('`', text)
            # print(text)

            # print(text)

            bingimage = []
            bingimage.append(imageaddress)
            bingimage.append(text)
            bingimage.append(_index)
            bingimage.append('Bing')

            # print(bingimage)

            bingimageList.append(bingimage)

            _index = _index + 1


        index = index + 1

        from SQLControl.image.bingimage_sql import save_sql
        save_sql(bingimageList)

        bingimageList.clear()

# getBingImage_ALL()

# getBingImage_Today()

