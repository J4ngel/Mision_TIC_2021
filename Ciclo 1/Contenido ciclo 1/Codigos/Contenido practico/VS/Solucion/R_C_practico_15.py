import random
"""Escribe una función actividad1(x, n) que reciba una frase x y un número entero n e
imprima una lista con las palabras cuya longitud sea mayor a n de entrada."""
def act1(x,n):
    ninguna = True
    y = x.split()
    print(f"\nA continuancion un listado de palabras cuya longitud es mayor a {n}:")
    for i in y:
        if len(i) > n:
            print(i)
            ninguna = False
    if ninguna:
        print("Ninguna palabra tiene una logitud mayor a la digitada!!")

    input("\nPresione enter para continuar...")
    menu()

"""Creemos ahora una función crearMatriz(m,n) que genere una matriz de M * N con
números aleatorios entre 0 y 9 y la retorne. Creemos también una función calcularPromedio(T)
que, dada una matriz T, genere un promedio de todos sus elementos y lo retorne. Finalmente una
función actividad2(m,n) que llame a crearMatriz, pase esa matriz a calcularPromedio(T) y que
genere una matriz que tenga el valor 1 en aquellas posiciones donde el valor sea mayor o igual al
promedio en T y cero (0) donde el valor de la posición en T sea menor que el promedio.
Imprimir ambas matrices"""
def crearMatriz(m,n):
    matriz = [[random.randint(0,9) for j in range(n)] for i in range(m)]
    return matriz

def calcularPromedio(T):
    prom = 0
    m = len(T)
    n = len(T[0])
    for i in T:
        for j in i:
            prom += j
    prom /= m*n
    return prom

def act2(m,n):
    M = crearMatriz(m,n)
    promedio = calcularPromedio(M)
    print("\nLa Matriz es: ")
    for i in M:
        print(i)
    
    print(f"\nEl promedio de los elementos en la matriz es: {promedio}")
    
    for i in range(m):
        for j in range(n):
            if M[i][j] >= promedio:
                M[i][j] = 1
            else:
                M[i][j] = 0
        
    print("\nLa Matriz despues del proceso es: ")
    for i in M:
        print(i)

def menu():
    print("      Bienvenido"
        "\n1. Según x frase, imprimir las palabras con una longitud mayor a n"
        "\n2. Según una matriz[mxn] con números aleatoreos, promediar los valores"
         "\n   y presentar 0 en las posiciones menores al promedio y 1 en caso contrario"
        "\n3. Salir")
    o = int(input("Digite una opción del menú: "))

    if o == 1:
        frase = input("\nDigite una frase: ")
        longitud = int(input("Digite una longitud: "))
        act1(frase, longitud)
    elif o == 2:
        m = int(input("\n# filas: "))
        n = int(input("# Columnas"))
        act2(m,n)
    elif o == 3:
        input("Gracias por usar nuestro software, presione enter para salir...")
    else:
        print("Error, opción no valida")
        input("Presione enter para continuar...")
        menu()
menu()