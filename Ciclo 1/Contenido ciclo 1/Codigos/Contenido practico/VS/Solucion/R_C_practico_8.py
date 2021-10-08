def ej1():
    num = int(input("\nDigite un número: "))
    i = 2

    while i <= num and i <=10:
        if i%2 == 0:
            print(i)
        i +=1

def ej2():
    num = int(input("\nDigite un número: "))
    c = 0
    while True:
        if num == 0:
            break
        elif num%10 != 4:
            c +=1
        num //=10
    print(f"El número tiene {c} digitos sin contar los '4'")

def menu():
    print("\n    Bienvenido")
    print("1. Imprimir todos los números pares hasta n pero parar si es 10")
    print("2. Obtener el número de dígitos de un número ingresado pero saltarse el 4")
    
    while True:
        try:
            r = int(input("\nDigite una pción del menú: "))
            break
        except ValueError:
            print("\nError, verifique la entrada e intente nuevamente")

    if r == 1:
        ej1()
    elif r == 2:
        ej2()
    else:
        print("Error, opción de menú no valida")

menu()