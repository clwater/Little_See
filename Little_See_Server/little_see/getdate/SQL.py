#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import pymysql

def test():
    conn = pymysql.connect(host='127.0.0.1', port=3307, user='little', passwd='see',db='little_see')
    cur = conn.cursor()
    cur.execute("SELECT * FROM zhihuTest")
    for r in cur.fetchall():
        print(r)
        # cur.close()
    conn.close()


test()