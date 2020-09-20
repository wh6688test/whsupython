files = {'Input.txt': 'Randy', 'Code.py': 'Stan', 'Output.txt': 'Randy'}

#the group_by_owners function should return {'Randy': ['Input.txt', 'Output.txt'], 'Stan': ['Code.py']}

result = {}

for mykey,myvalue in files.items():
  if files[mykey] not in result.keys():
       #result[myvalue]=result[myvalue].append(mykey)
       result.setdefault(myvalue, [])
  result[myvalue].append(mykey)
print(result)
