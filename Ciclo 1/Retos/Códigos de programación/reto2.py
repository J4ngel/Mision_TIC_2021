FORMATO = "{:.2f}"
T1 = int(input())
T2 = int(input())
pacientes = 0
ET1 = 0
ET2 = 0

while T1 > 0 and T2 > 0:
    a = float(input())
    b = float(input())
    pacientes +=1

    if a<72 and b <65:
        T2 -= 4
        ET2 +=1
    elif a>=124 and a<138 and b>=81 and b<93:
        T1 -= 2
        ET1 +=1
    elif a>=138 and a<156 and b>=93 and b<102:
        T1 -= 4
        ET1 +=1
    elif a>=156 and a<175 and b>=102 and b<114:
        T1 -= 8
        ET1 +=1
    elif a>=175 and b>=114:
        T1 -= 16
        ET1 +=1
    elif a>=136 and b<92:
        T1 -= 12
        ET1 +=1
    
if pacientes == 0:
    ET1f = FORMATO.format(ET1)
    ET2f = FORMATO.format(ET2)
    print(pacientes)
    print(f"{ET1} {ET1f}%")
    print(f"{ET2} {ET2f}%")
else:
    ET1f = FORMATO.format((ET1/pacientes)*100,2)
    ET2f = FORMATO.format((ET2/pacientes)*100,2)
    print(pacientes)
    print(f"{ET1} {ET1f}%")
    print(f"{ET2} {ET2f}%")