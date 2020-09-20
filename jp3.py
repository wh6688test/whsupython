#https://www.geeksforgeeks.org/opencv-overview/

import csv
from enum import Enum

def write_csv(filename):
    with open(filename, 'w') as mycsv:
          in1=csv.writer(mycsv)
          in1.writerow(["1234", "austin", "shoe", "2", "adidas"])
          in1.writerow(["1235", "dallas", "shoe",  "3",  "nike"])
          in1.writerow(["1236", "austin", "dress", "1",  "jcrew"])
          in1.writerow(["1237", "austin", "dress", "2",  "jcrew"])
          in1.writerow(["1238", "austin", "shoe",  "2",  "nike"])
          in1.writerow(["1239", "austin", "dress",  "2",  "jjill"])


def getAllOrders(filename):
    """
      get list representation of all products in the input file
    """
    result=[]
    with open(filename, 'r') as mycsv:
        in1=csv.reader(mycsv, delimiter=",")
        for row in in1:
            result.append(row)
        return result 

#def writeTo(filename, rows):
#    with open(filename, 'w') as mycsv:
#       in1=csv.writer(mycsv, delimiter=",")
#       for row in rows: 
#          in1.writrow(row)

def writePopularBrand(rows, filename):
    """write popular brand to cvs file""" 

    #dict :  brand:purchased times
    brandcount={}
    #dict : brand:product
    brandproduct={}

    for row in rows:
        #product name
        product=row[2]
        #brand name
        brand=row[4]

        #numbers of the brands purchased brand:purchased times
        brandcount[brand]=brandcount.get(brand, 0)+1

        #brand:product 
        if brand not in brandproduct:
            brandproduct[brand]=product

    #dict : product : max purchased times per brand `
    result={}
    for k, v in brandproduct.items():
        result.setdefault(v, 0)
        result[v]=max(brandcount[k], result[v])

    #output file name
    filename="1_"+filename 

    #write result to file
    with open(filename, 'w') as mycsv:
      in1=csv.writer(mycsv, delimiter=",")

      for k, v in brandproduct.items():
           if v in result and brandcount[k]==result[v]:
                in1.writerow([v, k])


def writeProductAverage(rows, filename):
    """ write product, average order numer for product """

    #product:ordered quantities for the product
    dicq={}
    #product:ordered times for the product
    dicc={}

    for row in rows:
        #product name
        product=row[2]
        #ordered numbers
        quant=row[3]

        dicq[product]=int(dicq.get(product, 0))+int(quant)
        dicc[product]=int(dicc.get(product, 0))+1

    for k,v in dicq.items():
        #round the average to 2 decimal points
        dicq[k]=round(float(v/dicc[k]), 2)

    #output file name
    filename="0_"+filename 
    #write to the output file
    with open(filename, 'w') as mycsv:
      in1=csv.writer(mycsv, delimiter=",")
      for k, v in dicq.items():
           in1.writerow([k,v])


#write_csv("input_file_name.csv")

filename="input_file_name.csv"

allp=getAllOrders(filename)

writeProductAverage(allp, filename)

writePopularBrand(allp, filename)

