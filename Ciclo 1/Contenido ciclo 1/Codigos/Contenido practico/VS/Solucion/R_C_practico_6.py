def ej1():
    num = int(input("\nDigite un número entero de 4 digitos: "))
    
    if num < 0:
        num = -num

    if num > 9999 or num < 1000:
        print("Error, por favor digite un número de cuatro (4) digitos: ")
    else:
        u = num % 10
        m = num // 10

        d = m % 10
        m = m // 10

        c = m % 10
        m = m // 10

        if u > d and u > c and u > m:
            print(f"{u} es el digito mayor")

            if (u%2) == 0:
                print(f"{u} es un número par")
            else:
                print(f"{u} es un número impar")

        elif d > u and d > c and d > m:
            print(f"{d} es el digito mayor")

            if (d%2) == 0:
                print(f"{d} es un número par")
            else:
                print(f"{d} es un número impar")

        elif c > u and c > d and c > m:
            print(f"{c} es el digito mayor")

            if (c%2) == 0:
                print(f"{c} es un número par")
            else:
                print(f"{c} es un número impar")

        elif m > u and m > d and m > c:
            print(f"{m} es el digito mayor")

            if (m%2) == 0:
                print(f"{m} es un número par")
            else:
                print(f"{m} es un número impar")

        else:
            print("Los cuatro digitos son iguales")

            if (u%2) == 0:
                print(f"{u} es un número par")
            else:
                print(f"{u} es un número impar")

def ej2():
    num1 = int(input("\nDigite el primer número: "))
    num2 = int(input("Digite el segundo número: "))

    if num1 < 0:
        num1 = -num1
    if num2 <0:
        num2 = -num2

    if num1 > 999 or num1 < 100 or num2 > 999 or num2 < 100:
        print("Error, Por favor digite números enteros de tres (3) digitos")
    else:
        u1 = num1 % 10
        c1 = num1 // 10
        d1 = c1 % 10
        c1 = c1 // 10

        if u1 > d1 and u1 > c1:
            mayor = u1
        elif d1 > u1 and d1 > c1:
            mayor = d1
        elif c1 > u1 and c1 > d1:
            mayor = c1
        else: # Cuando los digitos del numero 1 son iguales
            mayor = u1
        
        u2 = num2 % 10
        c2 = num2 // 10
        d2 = c2 % 10
        c2 = c2 // 10

        if u2 < d2 and u2 < c2:
            menor = u2
        elif d2 < u2 and d2 < c2:
            menor = d2
        elif c2 < u2 and c2 < d2:
            menor = c2
        else: # Cuando los digitos del numero 2 son iguales
            menor = u2
        
        mayor = str(mayor)
        menor = str(menor)
        r = mayor+menor
      
        print("El número resultante de formar un tercer número con el mayor del primero y el menor del segundo es:",r)
            
def ej3():
    num = int(input("\nDigite un número: "))
    
    if num < 0:
        num = -num
    
    if num > 999 or num < 100:
        print("Error, Por favor digite un número entero de tres (3) digitos")
    else:
        u = num % 10
        c = num // 10
        d = c % 10
        c = c // 10

        if u > d and u > c:
            c1 = u

            if d > c:
                d1 = d
                u1 = c
            else:
                d1 = c
                u1 = d

        elif d > u and d > c:
            c1 = d

            if c > u:
                d1 = c
                u1 = u
            else:
                d1 = u
                u1 = c

        elif c > u and c > d:
            c1 = c

            if d > u:
                d1 = d
                u1 = u
            else:
                d1 = u
                u1 = d

        else: # Cuando los digitos del numero 1 son iguales
            print("Todos los digitos del número ingresado son iguales")
            c1 = d1 = u1 = u

        c1 = str(c1)
        d1 = str(d1)
        u1 = str(u1)
        r  =  c1+d1+u1

        print(f"El número resultante de formar el mayor número posible con las cifras de {num} es: {r}")
            
def menu():
    print("\n--------------------------BIENVENIDO------------------------------")
    print("1) Mostrar el digito mayor de un número de 4 digitos")
    print("2) Crear un numero a base de dos números")
    print("3) Formar el mayor numero posible a base de un número de tres digitos")
    r = int(input("Digite una opción: "))

    if r == 1:
        ej1()
    elif r == 2:
        ej2()
    elif r == 3:
        ej3()
    else:
        print("Opción no valida")

menu()