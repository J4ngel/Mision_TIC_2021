def ej1():
    #Nota promedio de n numero de estudiantes
    num = int(input("\nDigite la cantidad de estudiantes: "))
    suma = 0

    for i in range(num):
        nota = float(input(f"Digite la nota {i+1}: "))
        suma += nota
    prom = suma/num

    print("\nEl promedio es:",prom)

def ej2():
    #Leer N números e imprimir cuántos son positivos, negativos y neutros
    n = int(input("\nDigite cuantos números va a digitar: "))
    pos = 0
    neg = 0
    neu = 0
    for i in range(n):
        num = float(input("Digite un numero: "))
        if num > 0:
            pos += 1
        elif num < 0:
            neg += 1
        else:
            neu += 1
    print(f"\nUsted digitó {pos} números positivos")
    print(f"Usted digitó {neg} números negativos")
    print(f"Usted digitó {neu} números neutro")

def ej3():
    #Elaborar un algoritmo que permita mostrar el sueldo promedio de un grupo de empleados
    empleados = int(input("Digite la cantidad de empleados: "))
    suma = 0

    for i in range(empleados):
        salario = int(input(f"Digite el sueldo del empleado {i+1}: "))
        suma += salario
    prom = suma/empleados
    print(f"El sueldo promedio es de ${prom}")

def ej4():
    #Dado un rango de números enteros, obtener la cantidad de números pares que contiene. 
    vi = int(input("Digite el valor inicial del rango: "))
    vf = int(input("Digite el valor final del rango: "))
    pares = 0
    for i in range(vi,vf+1):
        k = i
        if i < 0:
            k = -k

        if k%2 == 0:
            pares += 1
    print(f"La cantidad de números pares que hay entre {vi} y {vf} son {pares}")
            
def ej5():
    #Algoritmo para calcular el factorial de n
    n = int(input("\nDigite un número: "))
    factorial = 1
    for i in range(1,n+1):
        factorial *= i
    print(f"{n}! = {factorial}\n")

def ej6():
    #Determine cuantos numeros primos hay en los primeros N núneros enteros positivos.
    n = int(input("\nDigite un número: "))
    primos = 0
    for i in range(1,n+1):
        c=0
        for j in range(1,i+1):
            if i%j == 0:
                c += 1
        if c < 3:
            primos += 1
    print(f"Hay {primos} números primos en los {n} primeros números\n")

def ej7():
    r = int(input("\nDigite hasta que termios quiere ver de la serie de fibonacci: "))
    n1 = 0
    n2 = 1
    suma = 0
    if r <= 0:
        print("Error el número digitado deve ser mayor que 0")
    elif r == 1:
        print(n1)
    elif r == 2:
        print(n1)
        print(n2)
    else:
        suma = n1 + n2
        print(n1)
        print(n2)
        print(suma)
        for i in range(r-3):
            n1, n2 = n2, suma
            suma = n1 + n2
            print(suma)    

def menu():
    print("\n        Bienvenido")
    print("1. Nota promedio de un grupo de estudiantes")
    print("2. Leer N números e imprimir cuántos son positivos, negativos y neutros")
    print("3. Sueldo promedio de un grupo de empleados")
    print("4. Dado un rango de números enteros, obtener la cantidad de números pares que contiene")
    print("5. Calcular el factorial de n")
    print("6. Números primos hay en los primeros N núneros enteros positivos")
    print("7. Mostrar los primeros N terminos de la serie de Fibonacci")

    r = int(input("Digite una opción del menú: "))

    if r == 1:
        ej1()
    elif r == 2:
        ej2()
    elif r == 3:
        ej3()
    elif r == 4:
        ej4()
    elif r == 5:
        ej5()
    elif r == 6:
        ej6()
    elif r == 7:
        ej7()
    else:
        print("Error, opción de menú no valida")

#principal
menu()
input("Presione enter para salir...")