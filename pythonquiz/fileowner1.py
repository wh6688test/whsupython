#some of my answers:

#    https://www.testdome.com/d/python-interview-questions/9

def group_by_owners(files):
   result = {}

   for mykey,myvalue in files.items():
     if files[mykey] not in result.keys():
       result.setdefault(myvalue, [])
     result[myvalue].append(mykey)
   return result


if __name__ == "__main__":
    files = {
        'Input.txt': 'Randy',
        'Code.py': 'Stan',
        'Output.txt': 'Randy'
    }
    print(group_by_owners(files))
