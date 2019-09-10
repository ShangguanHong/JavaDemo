#!/usr/bin/python
# -*- coding: UTF-8 -*-

from sys import argv

def func(value):
    print("print the value %s" %(value))

if __name__ == "__main__":
    value = argv[1]
    func(value)