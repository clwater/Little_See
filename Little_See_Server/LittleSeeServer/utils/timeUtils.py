
import time,datetime



def getBetweenDate():
    d1 = datetime.date(2016, 11, 1)
    year = time.strftime('%Y', time.localtime(time.time()))
    mouth = time.strftime('%m', time.localtime(time.time()))
    day = time.strftime('%d', time.localtime(time.time()))
    d2 = datetime.date(int(year), int(mouth), int(day))
    return ((d2 - d1).days)

def getBetweenDate_image():
    d1 = datetime.date(2016, 4, 30)
    year = time.strftime('%Y', time.localtime(time.time()))
    mouth = time.strftime('%m', time.localtime(time.time()))
    day = time.strftime('%d', time.localtime(time.time()))
    d2 = datetime.date(int(year) , int(mouth) , int(day) )
    return ((d2 - d1).days)


getBetweenDate()