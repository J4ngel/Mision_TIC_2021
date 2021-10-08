def ej1():
    #Crea un array o arreglo unidimensional donde le indiques el tamaño por teclado y crear una función que rellene el array 
    # o arreglo con los múltiplos de un número pedido por teclado. Por ejemplo, si defino un array de tamaño 5 y elijo un 3 
    # en la función, el array contendrá 3, 6, 9, 12, 15. Muestralos por pantalla usando otra función distinta.

    espacio = int(input("\nDigite el tamaño del arreglo: "))
    multiplo = int(input("Digite el multiplo: "))
    arreglo = []

    for i in range(1, espacio+1):
        arreglo.append(i*multiplo)
    print("\n",arreglo, sep="")
#ej1()

def ej2():
    #Dado el siguiente arreglo de números:
    #[1, 5, 8, 3, 30, 9, 13]
    #Imprimir en pantalla programáticamente los números impares mayores a 3
    a = [1, 5, 8, 3, 30, 9, 13]
    for i in a:
        if i%2!=0 and i>3:
            print(i)
#ej2()

def ej3():
    #Crea dos arrays o arreglos unidimensional es que tengan el mismo tamaño (lo pedirá por teclado), 
    # en uno de ellos almacenarás nombres de personas como cadenas, en el otro array o arreglo 
    # ira almacenando la longitud de los nombres.
    espacio = int(input("\nDigite el tamaño de los arreglos: "))
    a = []
    b = []
    for i in range(espacio):
        a.append(input("Digite un nombre: "))
        b.append(len(a[i]))
    print(f"\nLos nombres digitados fueron: {a}")
    print(f"La cantidad de cada nombre es de: {b}")        
#ej3()

def ej4():
    #Dada las siguientes notas almacenadas en un arreglo:
#[20, 15, 12, 11, 8, 4, 1]
#Elimine la nota más baja programáticamente sin usar la función (min) y escriba en pantalla. 
#Luego programáticamente calcule el promedio de notas descontando la nota eliminada.
    notas = [20, 15, 12, 11, 8, 4, 1]
    minimo = 9999
    suma = 0
    for i in notas:
        if minimo > i:
            minimo = i
    notas.remove(minimo)
    for i in notas:
        suma += i
    prom = round(suma/len(notas),2)
    print(f"\nEl promedio de notas sin contar la minima es {prom}")  
#ej4()

def ej5():
    pares = []
    for i in range(2,11,2):
        pares.append(i)
    print(pares)
#ej5()

def mayor(x):
    mayor = -99999999999999
    for i in x:
        if mayor < i:
            mayor = i
    print(f"\nEl numero mayor es {mayor}")
def primo(x):
    primos = []
    for i in x:
        c = 0
        for j in range(1,i):
            if i%j == 0:
                c +=1
        if c < 3:
            primos.append(i)
    print(f"Los numeros primos en la lista son: {primos}")
def ej6():
    import random
    numeros = []
    for i in range(6):
        numeros.append((random.randint(1,20)))
    print(f"\nLos numero en la lista son: {numeros}")
    mayor(numeros)
    primo(numeros)
#ej6()

def ej7():
    n = 10
    lista = []
    print("Ejercicio 1:")
    print()
    for i in range(n):
        lista.append(input("Digite un elemento: "))
    print(lista)
    
    print("\nEjercicio 2:")
    suma = 0
    n = int(input("\nDigite el numero de elementos: "))
    lista_2 = []
    for i in range(n):
        lista_2.append(int(input("Digite un numero: ")))
        suma += lista_2[i] 
    print(f"\nLa suma de los elementos es {suma}")

ej7()