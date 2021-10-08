#Actividad 1: Usando el conocimiento de ciclos, crea una función números 
#que tenga una lista con
#los números pares del 1 al 10 y usa un ciclo para que los imprima.
def act1():
    lista = []
    for i in range(2, 11, 2):
        lista.append(i)
    print(f"\nLos números pares del 1 al 10 son {lista}")
    input("\nPresione enter para continuar...")

#Actividad 2: Escribamos un programa que nos permita crear una lista de 6 números aleatorios
#entre 1 y 20 en Python, y creemos dos funciones que reciban la lista como parámetro de la
#siguiente forma:
# > mayor(x) - Una función que imprima el número mayor valor de una lista x
# > primos(x) - Una función que imprima los números de la lista que son números primos
def mayor(lista):
    mayor = -9999999
    for i in lista:
        if mayor < i:
            mayor = i
    print(f"\nEl número mayor de la lista es {mayor}")
def primos(lista):
    n_primos = []
    for i in lista:
        divisores = 0
        for j in range(1,i+1):
            if i%j == 0:
                divisores += 1

        if divisores < 3:
            n_primos.append(i)
    print(f"\nLos números primos de la lista son {n_primos}")
    input("\nPresione enter para continuar...")
def act2():
    import random
    numeros = [random.randint(1, 20) for i in range(6)]
    print(f"\nLos números aleatorios registrados son: {numeros}")
    mayor(numeros)
    primos(numeros)

def menu():
    salir = False
    while not salir:
        print("\n----------->Bienvenido<------------")
        print("1. Los números pares del 1 al 10")
        print("2. Generar 6 números aleatorios al azar, imprimir el numero mayor y los números primos")
        print("3. Salir")
        r = int(input("\nDigite una opción del menú: "))

        if r == 1:
            act1()
        elif r == 2:
            act2()
        elif r == 3:
            salir = True
        else:
            print("\nError, opción de menú no valido, por favor intente de nuevo")
            input("Presione enter para continuar...")

menu()