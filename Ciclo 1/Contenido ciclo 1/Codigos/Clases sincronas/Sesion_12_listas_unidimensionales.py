def cambio_desordenado():
    v = [89, 23, 0, 15, 90]
    print(f"\n{v}")
    pos = int(input("Digite la posición a insertar: "))

    if (pos-1) <= (len(v)-1) and (pos-1) >= 0:
        num = int(input("Número a insertar: "))
        i = 0
        while i <= len(v)-1:
            if i == pos-1:
                v[i] = num
                break
            i += 1
        print(v)
    else:
        print("Error, fuera de rango")
#cambio_desordenado()
def insercion_desordenado():
    v = [89, 23, 0, 15, 90]
    print(f"\n{v}")
    pos = int(input("Digite la posición a insertar: "))
    if (pos-1) <= (len(v)-1) and (pos-1) >= 0:
        num = int(input("Número a insertar: "))
        v.insert(pos-1, num)
        print(v)
    else:
        print("Error, fuera de rango")
#insercion_desordenado()

import os
nombres = []

def limpiar_pantalla():
    os.system("cls")
    print(f"La cantidad de datos en la lista son {len(nombres)}")
    print(nombres)
def agregar():
    nom = input("digite el nombre: ")
    nombres.append(nom)
    menu()
def mostrar():
    print("\n",nombres,sep="")
    input("\nPresione enter para continuar...")
    menu()
def removerXnombre():
    nom = input("Digite el nombre a remover: ")
    nombres.remove(nom)
    menu()
def removerXposicion():
    pos = int(input("Ingrese la posición de la persona: "))
    nombres.pop(pos)
    menu()
def mostrarXposicion():
    pos = int(input("Ingrese la posición de la persona: "))
    print(f"En la posición {pos} se encuentra el nombre {nombres[pos]}")
    input("Presione enter...")
    menu()
def menu():
    limpiar_pantalla()
    opcion = int(input("1. Agregar\n2. Mostrar\n3. RemoverXnombre\n4. RemoverXposicion"
                        "\n5. Tamaño de la lista\n6. Orden acendente\n7. Orden desendente"
                            "\n8. ConsultarXposicion\n9. Salir\nSeleccione una opción: "))
    if opcion == 1:
        agregar()
    elif opcion == 2:
        mostrar()
    elif opcion == 3:
        removerXnombre()
    elif opcion == 4:
        removerXposicion()
    elif opcion == 5:
        print(f"La cantidad de datos en la lista son {len(nombres)}")
        input("\nPresione enter para continuar...")
        menu()
    elif opcion == 6:
        nombres.sort()
        menu()
    elif opcion == 7:
        nombres.sort(reverse=True)
        menu()
    elif opcion == 8:
        mostrarXposicion()
    elif opcion == 9:
        print("\nGracias por utilizar el sistema")
    else:
        print("\nError, opcion no valida intente de nuevo")
        input("Presione enter para continuar...")
        menu()
menu()