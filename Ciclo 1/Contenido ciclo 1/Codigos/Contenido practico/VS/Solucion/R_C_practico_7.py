def ej1():
    num = int(input("\nDigite un número: "))
    i=1
    if num < 2:
        print("Error, digite un número entero mayor o igual a 2")
    else:
        print(f"Los números pares que hay desde 2 hasta {num} son:")
        while i != (num + 1):
            if i % 2 == 0:
                print(i)
            i = i + 1

def ej2():
    x = int(input("\nDigite un número: "))
    n = x
    d = 0

    if x == 0:
        d = d+1
    elif x < 0:
        n = -n

    while n != 0:
        n = n//10
        d = d+1 

    print(f"{x} tiene {d} digitos")

def ej3():
    print("")
    num = 0
    n = 0       #Numerador
    d = 0       #Denominador

    while num != -1:
        num = float(input("Digite un número: "))
        
        if num != -1:
            n = n + num
            d = d+1

    if n == 0:
        print("El promedio de todos los números ingresados (sin contar el -1) es: 0")
    else:
        prom = "{:.3f}".format(n/d)
        print("El promedio de todos los números ingresados (sin contar el -1) es:",prom)



def menu():
    print("\n------------------>BIENVENIDO<-------------------")
    print("1) Imprimir todos los numeros pares desde 2 hasta n")
    print("2) Obtener el número de dijitos de 'x' número")
    print("3) Calculo de promedio hasta que se ingrese -1")
    o = int(input("Digite una opción: "))

    if o == 1:
        ej1()
    elif o == 2:
        ej2()
    elif o == 3:
        ej3()
    else:
        print("Opción no valida!!")

menu()