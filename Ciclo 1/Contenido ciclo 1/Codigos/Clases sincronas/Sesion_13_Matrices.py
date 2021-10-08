# Ejercicio para llenar matriz con 0's
def ej1():
    n = int(input("Filas: "))
    m = int(input("Columnas: "))
    matriz = []
    for i in range(n):
        matriz.append([0]*m)
        print(matriz[i])
#ej1()
# Llenar una matriz con x valor
def ej2():
    filas = int(input("Filas: "))
    columnas = int(input("Columnas: "))
    matriz = []
    for i in range(filas):
        matriz.append([])
        for j in range(columnas):
            matriz[i].append(int(input(f"Matriz[{i}][{j}]: ")))
    
    for i in matriz:
        print(i)
#ej2()
# Presentar una matriz
def ej3():
    matriz = [[1,2,3,4,5], [6,7,8,9,0]]
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            print(matriz[i][j], end=" ")
        print()         
    print("\nSin usar el rango:")
    for i in matriz:
        for j in i:
            print(j,end=" ")
        print()
#ej3()

#Minimo y maximo con sus posiciones
import random
def act1():
    matriz = []
    for i in range(5):
        matriz.append([])
        for j in range(10):
            matriz[i].append(random.randint(1,100))

    for i in matriz:
        print(i)

    minimo = [matriz[0][0],0,0]
    maximo = [matriz[0][0],0,0]

    for i in range(5):
        for j in range(10):
            if minimo[0] > matriz[i][j]:
                minimo[0] = matriz[i][j]
                minimo[1] = j+1
                minimo[2] = i+1
            if maximo[0] < matriz[i][j]:
                maximo[0] = matriz[i][j]
                maximo[1] = j+1
                maximo[2] = i+1
    print(f"\nEl valor minimo es {minimo[0]} en la posición [{minimo[1]},{minimo[2]}]")
    print(f"El valor maximo es {maximo[0]} en la posición [{maximo[1]},{maximo[2]}]")
#act1()
def act2(matriz,escalar):
    for i in range(len(matriz)):
        for j in range(len(matriz[i])):
            matriz[i][j] *= escalar 
    return matriz
def matriz_escalar():
    flias = int(input("\nFilas: "))
    columnas = int(input("Columnas: "))
    escalar = int(input("Escalar: "))
    matriz = []

    for i in range(flias):
        matriz.append([])
        for j in range(columnas):
            matriz[i].append(random.randint(1,10))

    print("\nSu matriz es: ")
    for i in matriz:
        print(i)

    print("\nLa matriz escalar es: ")
    m_escalar = act2(matriz, escalar)
    for i in m_escalar:
        print(i)
#matriz_escalar()

#Suma de matrices de 3x3
def act3():
    f = 3  #Filas
    c = 3  #Columnas

    matriz_a = [[random.randint(1,9) for j in range(c)] for i in range(f)]
    matriz_b = [[random.randint(1,9) for j in range(c)] for i in range(f)]
    matriz_c = [[matriz_a[i][j]+matriz_b[i][j] for j in range(c)] for i in range(f)]

    print("\n Matriz A X Matriz B = Matriz C:")
    for i in range(f):
        if i == 1:
            print(f"{matriz_a[i]} X {matriz_b[i]} = {matriz_c[i]}")
        else:
            print(f"{matriz_a[i]}   {matriz_b[i]}   {matriz_c[i]}")
act3()