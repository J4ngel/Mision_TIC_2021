"""Actividad 1: Vamos a escribir una función que llene una matriz de 5 filas y 10 columnas con
números enteros entre 1 y 100 aleatorios, imprima los valores máximo y mínimo y sus posiciones
dentro de la matriz"""
def extremos(x):
    valores = [x[0][0], x[0][0]]
    posiciones = [[], [], False]

    for i in x:
        for j in i:
            if valores[0] < j:
                valores[0] = j
            if valores[1] > j:
                valores[1] = j

    for i in range(len(x)):
        for j in range(len(x[i])):
            if valores[0] == x[i][j] and not posiciones[2]:
                posiciones[0].append(j)
                posiciones[0].append(i)
                posiciones[2] = True
            if valores[1] == x[i][j] and posiciones[2]:
                posiciones[1].append(j)
                posiciones[1].append(i)
                break
    
    print(f"\nEl valor maximo es {valores[0]} y está en la posición {posiciones[0]} dentro de la matriz")
    print(f"El valor minimo es {valores[1]} y está en la posición {posiciones[1]} dentro de la matriz")
def act1():
    import random
    matriz = [[random.randint(1, 100) for i in range(10)] for j in range(5)]
    print(matriz)
    print()
    for i in matriz:
        print(i)
    print()
    for i in matriz:
        for j in i:
            print(j, end=" ")
        print()
    extremos(matriz)
    input("\nPresione enter para continuar...")

"""Actividad 2: El producto escalar de un número real, x, y una matriz A es la matriz xA. Cada
elemento de la matriz xA es x veces su elemento correspondiente en A. Diseñemos una función
escala (matriz, escalar) que dada matriz[n][m] y un escalar, imprima el producto escalar de la
matriz."""
def act2():
    filas = int(input("\nDigite el número de filas de la matriz: "))
    columnas = int(input("Digite el número de columnas de la matriz: "))
    escalar = int(input("\nDigite un número como escalar a multiplicar: "))
    print("\nIngreso de datos a la matriz: ")
    matriz = [[int(input(f"Digite un número a almacenar en la posición {j},{i}: ")) for i in range(columnas)] for j in range(filas)]
    p_escalar = [[escalar for i in range(columnas)] for j in range(filas)]
    print("\nLa matriz digitada es: ")
    for i in matriz:
        print(i)
    print(f"\nEl producto escalar entre la matiz digitada y {escalar} es: ")
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            p_escalar[i][j] *= matriz[i][j]
        print(p_escalar[i])
    input("Presione enter para continuar...")

def menu():
    import os
    os.system("cls")
    print("\n           //////////////////////////Bienvenido\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\")
    print("1. Creador de matriz 5x10 con números aleatorios entre 1 y 100 en su interior")
    print("2. Calcular en producto escalar entre una matriz nxm y un escalar x")
    print("3. Salir")
    r = int(input("Digite una opción del menú: "))

    if r == 1:
        act1()
        menu()
    elif r == 2:
        act2()
        menu()
    elif r == 3:
        input("\nGracias por usar nuestro software, presione enter para salir...")
    else:
        input("\nOpcion no valida, presione enter para continuar...")
        menu()
menu()