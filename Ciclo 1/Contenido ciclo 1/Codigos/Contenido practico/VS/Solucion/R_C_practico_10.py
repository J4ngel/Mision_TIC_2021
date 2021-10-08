import random
    
def imprimaproducto(nom, pre):
    print(f"\nProducto: {nom}, precio: ${pre}")
    while True:
        r = input("\n¿Desea ingresar mas artículos? (S/N): ")
        if r != "S" and r != "s" and r != "N" and r != "n":
            print("\nError, digite solamente S o N")
        else:
            if r == "S" or r == "s":
                a = False
            else:
                a = True
            break
    return a
        
def caja():
    salir = False
    total = 0
    
    while not salir:
        nombre = input("\nDigite el nombre del producto: ")
        precio = int(input("Digite el precio del producto: $"))
        total += precio
        salir = imprimaproducto(nombre, precio)

    print(f"\nEl total de su compra es ${total}")

def numAleatorio():
    num = 110
    while num == 110 or num == 115 or num == 120:
        num = random.randint(100,130)

    return num    

def numeros():
    i = 0
    print()
    while True:
        a = numAleatorio()
        
        if i == 10:
            break
        elif i%2 == 0 and a%2 == 0:
            print(f"Número aleatorio   par: {a}")
            i +=1
        elif i%2 != 0 and a%2 != 0:
            print(f"Número aleatorio impar: {a}")
            i +=1

def menu():
    print("\n            Bienvenido")
    print("1. Total de la compra (Cajero)")
    print("2. Presente 10 números aleatorios entre 100 y 130 (110,115,120 no son validos)")

    while True:
        try:
            r = int(input("\nDigite una opción del menú: "))
            if r < 1 or r > 2:
                print("\nError, digite una opción valida del menú")
            else:
                break
        except ValueError:
            print("\nError, digite una opción valida del menú")
    
    if r == 1:
        caja()
    elif r == 2:
        numeros()
    else:
        print("\nError desconocido, trate nuevamente")

menu()