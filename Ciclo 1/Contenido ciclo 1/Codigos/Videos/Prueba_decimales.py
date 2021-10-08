import math
a = float(5.0)
b = float(6.3)
c = float(a - b)
c = "{:.2f}".format(c)
d = c*2
print(f"\na = {a}, b = {b}, c = {a} - {b}")
print("a =",type(a),"b =",type(b),"c =",type(c))
print("\nc*2 sin el casteo =",d)
c = float(c)
d = c*2
print("\nc*2 con el casteo =",d)
print("a =",type(a),"b =",type(b),"c =",type(c),"\n")