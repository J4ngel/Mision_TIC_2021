import random

"""Escribe una función actividad1(x) que imprima la diagonal principal de una matriz x.
Asegúrate de validar si la matriz es cuadrada, sino devuelve un mensaje, "La matriz no es
cuadrada"""
def llenar_matriz():
    filas = int(input("\nDigite el número de filas de la matriz: "))
    columnas = int(input("Digite el número de columnas de la matriz: "))
    matriz = [[random.randint(1, 100) for j in range(columnas)] for i in range(filas)]
    print(f"\nLa matriz de {filas}x{columnas} será llenada con números aleatoreos del 1 al 100:")
    return matriz
    
def act1(matriz):  
    if len(matriz) != len(matriz[0]):
        print("\nError, la matriz no escuadrada")
    else:
        print("\nLa diagonal de la mariz la componen los números: ")
        for i in range(len(matriz)):
            print(matriz[i][i],end="  ")
    input("\nPresione enter para continuar...")
    
"""Creemos ahora una función actividad2() que reciba los elementos de una matriz 3x3
    e imprima:
        - La primera fila
        - La primera columna
        - Accede al elemento en la fila 1, columna 1.
    Los valores son ingresados por filas [0][1], [0][2], [0][3], [1][0], etc"""        
def act2():
    print()
    matriz = [[random.randint(50,100) for j in range(3)]for i in range(3)]
    print("\nSu matriz es:")
    for i in matriz:
        print(i)
    input("Presione enter para continuar...")
    print(f"\nLa primera fila de la matriz es: {matriz[0]}")

    print("La primera columna de la matriz es: ")
    for i in matriz:
        print(i[0])

    print(f"\nEl elemento en la fila 1 columna 1 de la matriz es: {matriz[0][0]}")
    input("Presione enter para continuar...")

def menu():
    op = int(input("\n---------------->BIENVENIDO\n"
                    "\n1. Imprima la diagonal principal de una matriz."
                    "\n2. Imprimir la primera fila, columna y elemento de una matriz 3x3"
                    "\n3. Salir"
                    "\nDigite una opción del menú: "))
    if op == 1:
        M1 = llenar_matriz()
        for i in M1:
            print(i)
        input("Presione enter para continuar...")
        act1(M1)
        menu()
    elif op == 2:
        act2()
        menu()
    elif op == 3:
        input("\nGracias por usar nuestro software\npresione enter para salir...")
    else:
        input("Error, opción no valida, presione enter para continuar...")
        menu()
menu()
