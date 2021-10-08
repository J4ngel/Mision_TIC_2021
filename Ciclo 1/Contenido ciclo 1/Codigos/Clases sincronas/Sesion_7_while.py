def ej1():
    #Obtener la suma de los N primeros números naturales positivos
    num = int(input("Digite el número hasta el cual se debe sumar: "))
    suma = 0
    i = 1

    while  i <= num:
        suma +=i
        i +=1
    print(suma)

def ej2():
    #Calcular independientemente la suma de los números pares e impares entre 1 y N

    num = int(input("Digite un número: "))
    s_impares = 0
    s_pares = 0
    i = 1

    while i <= num:
        if i%2 == 0:
            s_pares +=i
        else:
            s_impares +=i
        i +=1
    print(f"La suma de los pares hasta {num} es: {s_pares}")
    print(f"La suma de los impares hasta {num} es: {s_impares}")

def ej3():
    #Muestre los números del 1 al N(ambos incluidos) divisibles entre 4 y 5

    num = int(input("\nDigite un número: "))
    i = 1

    while i<=num:
        if i%4 == 0 and i%5 == 0:
            print(f"{i} es divisible entre 4 y 5")
        elif i%4 == 0:
            print(f"{i} es divisible entre 4")
        elif i%5 == 0:
            print(f"{i} es divisible entre 5")
        else:
            print(f"{i} NO es divisible ni entre 4 o 5")
        i +=1

def ej4():
    #Escribir un algoritmo que imprima los 10 primeros números pares comenzando en 2
    #e imprima tambien sus respectivos cubos

    i = 2

    while i<=20:
        if i%2 == 0:
            print(f"{i} es par, {i}^3 = {i**3}")
        i +=1

def ej5():

    #Elabore un algoritmo que muestre los términos de la serie de Fibonacci que sean menores a 100
    #Serie = 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,...

    num1 = 0
    num2 = 1
    serie = num1 + num2
    print("\nSerie de fibonacci:",num1, sep="\n",end=" ")
    print(num2, end=" ")
    while serie < 100:
        print(serie, end=" ")
        num1 = num2
        num2 = serie
        serie = num1 + num2

def menu():
    print("""
    Bienvenido
1. Obtener la suma de los N primeros números naturales positivos
2. Calcular independientemente la suma de los números pares e impares entre 1 y N
3. Muestre los números del 1 al N(ambos incluidos) divisibles entre 4 y 5
4. Escribir un algoritmo que imprima los 10 primeros números pares comenzando en 2 con sus cubos
5. Muestre los términos de la serie de Fibonacci que sean menores a 100
    """)
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
    else:
        print("Opción no valida")

menu()