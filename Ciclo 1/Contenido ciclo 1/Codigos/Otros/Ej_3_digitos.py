num = int(input("\nDigite un número de 3 cifras: "))
    
if (num < 100 or num >999) and (num < -999 or num > -100):
    print("Error, el número digitado no es de tres (3) cifras")
else:
    k = num
    if num<0:
        num = -num
    c=num//100
    d=(num%100)//10
    u=(num%100)%10

    if c > d and c > u:
        max = c
        if d > u:
            med = d
            min =u
        elif d < u:
            med = u
            min = d
        else:
            min = med = u

    elif d > c and d > u:
        max = d
        if c > u:
            med = c
            min =u
        elif c < u:
            med = u
            min = c
        else:
            min = med = u

    elif u > d and u > c:
        max = u
        if c > d:
            med = c
            min =d
        elif c < d:
            med = d
            min = c
        else:
            min = med = d

    elif c == d and c != u:
        if c > u:
            max = med = c
            min = u
        else:
            max = u
            med = min = c

    elif c == u and c != d:
        if c > d:
            max = med = c
            min = d
        else:
            max = d
            med = min = c

    elif d == u and d != c:
        if d > c:
            max = med = d
            min = c
        else:
            max = c
            med = min = d

    else:
        max = med = min = u
    
    if k < 0:
        num = -1*(min*100+med*10+max)
        print(num)
    else:
        num = max*100+med*10+min
        print(num)
input("Presione enter para salir...")

