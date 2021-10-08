def ej1():
    r = int(input("\nDigite hasta que termios quiere ver de la serie de fibonacci: "))
    n1 = 0
    n2 = 1
    suma = 0
    if r <= 0:
        print("Error el número digitado deve ser mayor que 0")
    elif r == 1:
        print(n1)
    elif r == 2:
        print(n1)
        print(n2)
    else:
        suma = n1 + n2
        print(n1)
        print(n2)
        print(suma)
        for i in range(r-3):
            n1, n2 = n2, suma
            suma = n1 + n2
            print(suma)
        
def ej2():
    palabra = input("\nDigite una palabra: ")
    
    for i in range(len(palabra)):
        if palabra[i] == "a" or palabra[i] == "A":
            i -= 1
            break
    print(f"la palabra {palabra} tiene {i+1} letras antes de toparse con una a")

def ej3():
    pos = 0
    neg = 0
    neu = 0
    print()
    for i in range(10):
        x = int(input("Digite un número: "))
        if x > 0:
            pos +=1
        elif x < 0:
            neg +=1
        else:
            neu +=1

    print(f"Usted digitó {pos} números positivos, {neg} números negativos y {neu} números neutros")

def ej4():
    k = 0
    print()
    while k != -1:
        num = int(input("Digite un número para calcular su factorial (si desea salir digite -1): "))
        k = num

        if k == -1:
            continue
        elif num < 0:
            num = -num
        f = 1
        for i in range(num):
            f *= (i+1)
        if k < 0:
            f = -f
        
        print(f"El factorial de {k} es {f}")

def menu():
    print("""
    Bienvenido
1. Serie de fibonacci
2. Número de letras hasta a
3. Clasificación en positivos, negativos y neutros
4. Factorial""")

    while True:
        try:
            r = int(input("\nDigite una opción del menú: "))
            break
        except ValueError:
            print("\nError, verifique la entrada e intente de nuevo")
    
    if r == 1:
        ej1()
    elif r == 2:
        ej2()
    elif r == 3:
        ej3()
    elif r == 4:
        ej4()
    else:
        print("Error, digite una opción valida del menú")

menu()