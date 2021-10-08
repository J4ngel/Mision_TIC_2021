#Escribamos un programa que nos permita crear con una lista de 6 números aleatorios
#entre 1 y 20, y luego creemos tres funciones que reciban la lista como parámetro de la 
#siguiente forma:
# > mayor(x) - Una función que imprima el número mayor valor de una lista x
# > primos(x) - Una función que imprima los números de la lista que son números primos
# > orden(x) - Una función que ordene los datos de una lista x ascendentemente y la imprima
#              en orden
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

        if divisores < 3 and divisores > 1:
            n_primos.append(i)
    print(f"Los números primos de la lista son {n_primos}")

def orden(lista):

    lista.sort()
    print(f"La lista ordenada de forma acendente es: {lista}")
    input("\nPresione enter para salir...")

def act():
    import random
    numeros = [random.randint(1, 20) for i in range(6)]
    print(f"\nLos números aleatorios registrados son: {numeros}")
    mayor(numeros)
    primos(numeros)
    orden(numeros)
    
act()