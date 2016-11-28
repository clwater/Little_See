
import time,datetime



def getBetweenDate():
    base_time = '2016-11-01'
    local_time = time.strftime('%Y-%m-%d', time.localtime(time.time()))
    _base_time = datetime.datetime.strptime(base_time, '%Y-%M-%d')
    _local_time = datetime.datetime.strptime(local_time, '%Y-%M-%d')
    betweendate = _local_time - _base_time
    return betweendate.days

def getBetweenDate_image():
    d1 = datetime.date(2016, 4, 30)
    year = time.strftime('%Y', time.localtime(time.time()))
    mouth = time.strftime('%m', time.localtime(time.time()))
    day = time.strftime('%d', time.localtime(time.time()))
    d2 = datetime.date(int(year) , int(mouth) , int(day) )

    return ((d2 - d1).days)
