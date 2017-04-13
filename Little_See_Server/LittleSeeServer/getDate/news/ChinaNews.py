
import requests , re

_newsList = []


def getImage(address):
    reponse = requests.get(address)
    reponse.encoding = 'gb2312'
    html = reponse.text
    html = html.replace('\r' , '')
    html = html.replace('\t', '')
    html = html.replace('\n', '')
    html = html.replace(' ', '')

    body = re.findall('<!--图片start-->.*<!--图片说明-->' , html)

    if len(body) > 0:
        # print(body[0])
        # print(body[0])
        image = re.findall('imgsrc.*?alt' , body[0])

        # print(image)

        image = image[0]
        image = image.replace('"alt' , '')
        image = image.replace('imgsrc="' , '')

        # print(image)

        if 'http' not in image:
            basesrc = re.findall('http://.*/' , address)
            image = basesrc[0] + image
            # print(image)
        return  image


    else:
        return ''

    # print(html)

# getImage('http://www.chinanews.com/gn/2017/03-29/8186541.shtml')
# getImage('http://www.chinanews.com/gn/2017/03-29/8186461.shtml')

def getNews(news):
    _news = []
    address = re.findall('href=".*?shtml' , news)
    address = address[0]
    if 'http'  in address:
        return
    address = address.replace('href="' , 'http://www.chinanews.com')
    # print(address)
    title = re.findall('shtml">.*?</a>' , news)
    title = title[0]
    title = title.replace('</a>' , '')
    title = title.replace('shtml">' , '')
    # print(title)

    # _news.insert(1, '')



    from SQLControl.news.chinanews_sql import check
    if check(address , '中国新闻网'):
        imageaddress = getImage(address)
        _news.insert(0, title)
        _news.insert(1 , address)
        _news.insert(2, imageaddress)
        _news.insert(3, '中国新闻网')
        _newsList.append(_news)







def getChinaNews():

    reponse = requests.get('http://www.chinanews.com/china.shtml')
    reponse.encoding = 'gb2312'
    html = reponse.text

    # print(html)
    html = html.replace('\t' , '')
    html = html.replace('\n', '')
    html = html.replace('\r', '')
    html = html.replace(' ', '')

    newsList = re.findall('<divclass=\"content_list\">.*</div>' , html)
    newsList = re.findall('<li><div.*?</li>' , newsList[0])
    #
    # from SQLControl.news.chinanews_sql import sql_c
    # sql_c().inssome()

    # ind = 0
    # while ind < 10:
    #     ind = ind + 1
    for news in newsList:
        # news = newsList[ind]
        # print(news)
        getNews(news)

    _newsList.reverse()
    from SQLControl.news.chinanews_sql import save_sql
    save_sql(_newsList)



# getChinaNews()