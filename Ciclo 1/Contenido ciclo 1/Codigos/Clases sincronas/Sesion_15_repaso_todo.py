import random
import os
def areacirculo(r):
    A = round(3.1416*(r**2),2)
    print(f"El area del circulo con radio {r} es {A}")
    input("Presione enter para continuar...")

def distancia(A,B):
    c_diferencia = [0,0]
    dist = 0
    for i in range(2):
        A[i]    = int(A[i])
        B[i]    = int(B[i])

        if A[i] < 0:
            A[i] = -A[i]
        if B[i] < 0:
            B[i] = -B[i]
        
        c_diferencia[i] = (A[i]+B[i])

    dist = ((c_diferencia[0]**2) + (c_diferencia[1]**2))**(1/2)
    dist = round(dist,2)
    print(f"La distancia entre los puntos digitados es {dist}")
    input("Presione enter para continuar...")

def suma_n(n):
    suma = (n*(n+1))/2
    print(f"\nLa suma de todos los números hasta {n} es {suma}")
    input("Presione enter para continuar...")

def descuento(val): 
    descuento = val*0.15
    compras = val-descuento
    print(f"\nEl precio de su compra con descuento del 15% es {compras}")
    input("Presione enter para continuar...")

def pulgadas(cm): 
    pul = round(cm * 0.39737, 2)
    print(f'\n{cm}cm -----> {pul}"')
    input("\nPresione enter para continuar...")

def menu1():
    os.system("cls")
    o = int(input("\n----->>EJERCICIOS ESTRUCTURA SECUENCIAL"
        "\n1) Hallar el area de un circulo"
        "\n2) Calcular la distancia entre dos puntos"
        "\n3) Suma de todos los enteros desde 1 hasta N"
        "\n4) Saber el 15% de su compra"
        "\n5) Convertidor de cm a pulgadas"
        "\n6) Volver al menú principal"
        "\nDigite una opción del menú: "))
    if o == 1:
        radio = int(input("\nDigite el valor del radio del circulo: "))
        areacirculo(radio)
        menu1()
    elif o == 2:
        A = input("\nDigite el par de coordenanas de A separado por una coma: ").split(",")
        B   = input("Digite el par de coordenanas de B separado por una coma: ").split(",")
        distancia(A,B)
        menu1()
    elif o == 3:
        n = -1
        print()
        while n < 0:
            n = int(input("Digite un número positivo: "))
        suma_n(n)
        menu1()
    elif o == 4:
        val = int(input("Digite el valor de su compra: $"))
        descuento(val)
        menu1()
    elif o == 5:
        cm = float(input("\nDigite la medida en cm: "))
        pulgadas(cm)
        menu1()
    elif o == 6:
        menu_pp()
    else:
        input("\nError opción no valida!!"
                "\nPresione enter para continuar...")
        menu1()

def calculoF(A,B):
    F = 0
    if ((A**2)-(B**2)) < 0:
        F = 2*A+B
    elif ((A**2)-(B**2)) > 0:
        F = A+B
    else:
        F = (A**2)-(2*B)
    print(f"Según A y B, F = {F}")
    input("Presione enter para continuar...")

def des_aparatos(precio,marca):
    IVA = 1.19
    dto1 = 0
    dto2 = 0
    if precio >= 2000:
        dto1 = precio * 0.1
    if marca == "NOSY":
        dto2 = precio * 0.05
    precio -= (dto1 + dto2)
    total = precio*IVA

    print(f"\nEl total a pagar es ${total}")
    input("Presione enter para continuar...")

def menu2():
    os.system("cls")
    print("\n--------->>EJERCICIOS ESTRUCTURAS CONDICIONALES")
    print("1) Calcular F según A y B de entrada")
    print("2) Calcular el valor de la compra")
    print("3) Volver al menú principal")
    o = int(input("Digite una opción del menú: "))

    if o == 1:
        A = int(input("Digite el valor de A: "))
        B = int(input("Digite el valor de B: "))
        calculoF(A,B)
        menu2()
    elif o == 2:
        precio = int(input("Digite el precio del producto: $"))
        marca  = input("Digite la marca del producto: ")
        des_aparatos(precio,marca)
        menu2()
    elif o == 3:
        menu_pp()
    else:
        input("\nError, digite una opción valida del menú"
                "\nPresione enter para salir...")
        menu2()

def cant_ceros(cantidad):
    x = [int(input(f"Digite en numero {i+1}: ")) for i in range(cantidad)]
    os.system("cls")
    print("\nLos números digitados fueron:")
    for i in x:
        print(i,end=" ")
    print(f"\n\nEl algoritmo arroja que hay {x.count(0)} ceros.")
    input("\nDigite enter para continuar...")

def pares(numeros):
    os.system("cls")
    print("\nLos numeros digitados fueron: ")
    print(numeros)
    contador = 0
    for i in numeros:
        if i%2 == 0:
            contador += 1
    print(f"\nHay {contador} números pares en los 100 digitados")
    input("Presione enter para continuar...")

def menu3():
    os.system("cls")
    print("\n------>>EJERCICIOS CICLOS REPETITIVOS")
    print("1) Contador de 0's")
    print("2) Cuantos pares hay entre 100 números ingresados")
    print("3) volver al menú principal")
    o = int(input("Digite una opción del menú: "))

    if o == 1:
        n = int(input("\nDigite la cantidad de números a ingresar: "))
        cant_ceros(n)
        menu3()
    elif o == 2:
        print()
        n = [int(input(f"Número {i+1}: ")) for i in range(100)]
        pares(n)
        menu3()
    elif o == 3:
        menu_pp()
    else:
        input("\nError, digite una opción valida del menú"
                "\nPresione enter para salir...")
        menu3() 

def par_impar():
    vector = [random.randint(0,9) for i in range(100)]
    par = []
    impar = []
    print("\nLos 100 números generados de forma aleatoria entre 0 y 9 son:")
    print(vector)
    for i in vector:
        if i%2 == 0:
            par.append(i)
        else:
            impar.append(i)
    print()
    if len(par) > len(impar):
        print("La cantidad de numeros pares es mayor que los impares")

    elif len(par) < len(impar):
        print("La cantidad de numeros impares es mayor que los pares")

    else:
        print("La cantidad de numeros pares e impares son iguales")

    print(f"\nHay {len(par)} números pares y hay {len(impar)} números impares")
    input("\nPresone enter para continuar...")
    menu_pp()

def ej_matrices():
    m = int(input("\nDigite cuantos años se van a analizar: "))
    n = int(input("Digite la cantidad de sucursales: "))
    monto = [[random.randint(100,1000) for j in range(n)] for i in range(m)]
    m_vendido   = [0,0,0]
    m_promedio  = [0,0]
    prom_tiempo = [0 for i in range(m)]
    
    os.system("cls")

    print("\nTabla de montos (año x sucursal):")
    for i in range(m):
        print(monto[i])
        for j in range(n):
            prom_tiempo[i] += monto[i][j]

            if m_vendido[0] < monto[i][j]:
                m_vendido[0] = monto[i][j]
                m_vendido[1] = j + 1
                m_vendido[2] = i + 1

        prom_tiempo[i] /= n      
    
    print(f"\nLa sucursal que más vendió en los {m} años analizados fue la sucursal {m_vendido[1]} con ${m_vendido[0]} ventas en el año {m_vendido[2]}")
    print()

    for i in range(m):
        print(f"El promedio de ventas en el año {i+1} fue de: ${round(prom_tiempo[i],2)}")
        if m_promedio[0] < prom_tiempo[i]:
            m_promedio[0] = prom_tiempo[i]
            m_promedio[1] = i +1


    print(f"\nEl año {m_promedio[1]} obtuvo el mayor promedio en ventas con un valor de ${round(m_promedio[0],2)}")
    input("\nPresione enter para continuar...")
    menu_pp()

def menu_pp():
    os.system("cls")
    print("                          BIENVENIDO")
    print("----------------------->MENÚ PRINCIPAL<--------------------------")
    print("1. Ejercicios estructura secuencial")
    print("2. Ejercicios estructuras condicionales")
    print("3. Ejercicios ciclos repetitivos")
    print("4. Entre 100 numeros, cual cantidad de pares o impares es mayor")
    print("5. Información de ventas")
    print("6. Salir")
    o = int(input("Digite una opción del menú: "))

    if o == 1:
        menu1()
    elif o == 2:
        menu2()
    elif o == 3:
        menu3()
    elif o == 4:
        par_impar()
    elif o == 5:
        ej_matrices()
    elif o == 6:
        input("\nGracias por usar nuestro software"
              "\nPresione enter para salir...")
    else:
        input("\nError, opción de menú no valida"
              "\nPresione enter para cotinar...")
        menu_pp()

menu_pp()