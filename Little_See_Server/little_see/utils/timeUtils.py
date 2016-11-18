
import time,datetime



def getBetweenDate():
    base_time = '2016-11-01'
    local_time = time.strftime('%Y-%m-%d', time.localtime(time.time()))
    _base_time = datetime.datetime.strptime(base_time, '%Y-%M-%d')
    _local_time = datetime.datetime.strptime(local_time, '%Y-%M-%d')
    betweendate = _local_time - _base_time
    return betweendate.days
