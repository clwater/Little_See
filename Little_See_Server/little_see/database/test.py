# !/usr/bin/python3
# -*- coding: UTF-8 -*-

import mysql.connector
# 注意把password设为你的root口令:
conn = mysql.connector.connect(user='root', password='', database='little_see')
cursor = conn.cursor()
# # 创建user表:
# cursor.execute('create table user (id varchar(20) primary key, name varchar(20))')
# 插入一行记录，注意MySQL的占位符是%s:
# cursor.execute('insert into user (id, name) values (%s, %s)', ['3', 'Mich3ael2'])
# cursor.rowcount
#
# 提交事务:
conn.commit()
cursor.close()
# 运行查询:
cursor = conn.cursor()
cursor.execute('select * from user')
values = cursor.fetchall()
for va in values:
    print(va)
# 关闭Cursor和Connection:
cursor.close()
conn.close()