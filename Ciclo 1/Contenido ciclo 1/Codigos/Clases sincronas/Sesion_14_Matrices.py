import random

def llenar_matriz(filas, columnas, a = 1):
    if a == 1:
        matriz = [[random.randint(1,10) for j in range(columnas)] for i in range(filas)]
    elif a == 2:
        matriz = [[0 for j in range(columnas)] for i in range(filas)]
    else:
        matriz = [[int(input(f"Valor en [{i+1}][{j+1}]: ")) for j in range(columnas)] for i in range(filas)]
    
    return matriz

def mostrar_matriz(matriz, nombre = "con valores"):
    print(f"\nMatriz {nombre}:")
    for i in matriz:
        print(i)

# Multiplicacion de matrices
def mult_matrices(): #Numero de filas = numero de columnas
    filas_1     = int(input("Digite el número de filas de la primera matriz: "))
    columnas_1  = int(input("Digite el número de columnas de la primera matriz: "))
    filas_2     = int(input("Digite el número de filas de la segunda matriz: "))
    columnas_2  = int(input("Digite el número de columnas de la segunda matriz: "))

    filas = [filas_1, filas_2]
    columnas = [columnas_1, columnas_2]

    M1 = llenar_matriz(filas_1, columnas_1, 0)
    M2 = llenar_matriz(filas_2, columnas_2, 0)
    M_resultado = [[0 for j in range(max(columnas))] for i in range(max(filas))]
    mostrar_matriz(M1,"M1")
    mostrar_matriz(M2,"M2")
    if columnas_1 == filas_2 or columnas_2 == filas_1:
        for i in range(filas_1):
            for j in range(columnas_2):
                for k in range(columnas_1):
                    M_resultado[i][j] += M1[i][k] * M2[k][j]
        mostrar_matriz(M_resultado,"M_resultado")
    else:
        print("Error, el numero de columnas de la primera matriz es diferente del numero de filas de la segunda matriz...")   

#Dada una matriz cuadrada A, construya un algoritmo que permita determinar si dicha matriz es simétrica.
#Se considera a una matriz simétrica si A[i,j] = A[j,i] y esto se cumple para todos los elementos i,j de la matriz
def matriz_simetrica():
    n = int(input("Digite el numero de filas: "))
    m = int(input("Digite el número de columnas: "))
    M = llenar_matriz(n, m, 0)
    M_cuadrada = llenar_matriz(n,m,2)
    simetria = False
    mostrar_matriz(M,"M")

    for i in range(n):
        for j in range(m):
            M_cuadrada[j][i] = M[i][j]

    mostrar_matriz(M_cuadrada,"M_res")

    for i in range(n):
        for j in range(m):
            if M[i][j] == M_cuadrada[i][j]:
                simetria = True
            else:
                simetria = False
                break
    if simetria:
        print("La matriz es simétrica!!")
    else:
        print("La matriz NO es simetrica")

# Calcular el producto escalar y vectorial (matrices 3x3)
def escalar_vectorial():
    A = [int(input(f"A[{i+1}]: ")) for i in range(3)]
    B = [int(input(f"B[{i+1}]: ")) for i in range(3)]
    mostrar_matriz(A,"A")
    mostrar_matriz(B,"B")
    suma =0
    for i in range(3):
        suma += (A[i]*B[i])
    print(f"El producto escalar es: {suma}")  
    x = A[1]*B[2] - A[2]*B[1]
    y = A[0]*B[2] - A[2]*B[0]
    z = A[0]*B[1] - A[1]*B[0]
    print(f"El producto vectorial es: i = {x}, j = {y}, k = {z}") 

#Escribe una función actividad1(x) que imprima la diagonal principal de una matriz x.
#Asegúrate de validar si la matriz es cuadrada, sino devuelve un mensaje, "La matriz no es
#cuadrada
def diagonal():
    n = int(input("\nFilas: "))
    m = int(input("Columnas: "))
    Matriz = llenar_matriz(n,m,1)
    Matriz_id = llenar_matriz(n,m,2)
    mostrar_matriz(Matriz)
    if n == m:
        for i in range(n):
            for j in range(m):
                if i == j:
                    Matriz_id[i][j] = 1
                Matriz_id[i][j] *= Matriz[i][j]
        mostrar_matriz(Matriz_id,"solo con sus valores diagonales")
    else:
        print("Error, la matriz no es cuadrada")
    print()

"""Creemos ahora una función actividad2() que reciba los elementos de una matriz 3x3
    e imprima:
        - La primera fila
        - La primera columna
        - Accede al elemento en la fila 1, columna 1.
    Los valores son ingresados por filas [0][1], [0][2], [0][3], [1][0], etc"""
def fila_columna_elemento():
    Matriz = llenar_matriz(3,3)
    mostrar_matriz(Matriz)
    print(f"La primera fila es: {Matriz[0]}")
    print("La primera colunma es: ", end="[")
    for i in range(3):
        if i <2:
            print(Matriz[i][0],end=", ")
        else:
            print(Matriz[i][0],end="]")         
    print(f"\nEl primer elemento en la fila 1, columna 1 es: {Matriz[0][0]}")

def menu():
    o = int(input("""
            Bienvenido
    1. Multiplicacion de 2 matrices
    2. ¿La matriz 'x' es simetrica?
    3. Calcular el porducto escalar y vectorial entre 2 vectores
    4. Verificar que una matriz sea cuadrada y presente la diagonal de la misma
    5. Dada una matriz de 3x3, presentar: la primera fila, la primera columna, el primer elemento
    6. Salir
    Digite una opción del menú: """))
    
    if o == 1:
        mult_matrices()
        input("Presione enter para continuar...")
        menu()
    elif o == 2:
        matriz_simetrica()
        input("Presione enter para continuar...")
        menu()
    elif o == 3:
        escalar_vectorial()
        input("Presione enter para continuar...")
        menu()
    elif o == 4:
        diagonal()
        input("Presione enter para continuar...")
        menu()
    elif o == 5:
        fila_columna_elemento()
        input("Presione enter para continuar...")
        menu()
    elif o == 6:
        input("Gracias por usar nuestro software!!"
        "Presione enter para salir...")
    else:
        input("Error, digite una opcion valida del menú"
        "Presione enter para continuar...")
        menu()
menu()
