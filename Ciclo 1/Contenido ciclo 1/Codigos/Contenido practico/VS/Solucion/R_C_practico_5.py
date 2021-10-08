def actividad_1():
    semaforo = input("\nDigite el color del semaforo: ")

    if semaforo == "Verde" or semaforo == "verde":
        print("Siga")
    elif semaforo == "Amarillo" or semaforo == "amarillo":
        print("Precaución")
    elif semaforo == "Rojo" or semaforo == "rojo":
        print("Pare")

def actividad_2():
    semaforo = input("\nDigite el color del semaforo: ")
    peaton = input("¿Hay peatón? (Y/N): ")

    if semaforo == "Verde" or semaforo == "verde":
        if peaton == "Y" or peaton =="y":
            print("Pare")
        else:
            print("Siga")

    elif semaforo == "Amarillo" or semaforo == "amarillo":
        if peaton == "Y" or peaton == "y":
            print("Pare")
        else:
            print("Precaución")
    elif semaforo == "Rojo" or semaforo == "rojo":
        print("Pare")
        
def actividad_3():
    print("\n1)Sumar dos números (a + b)\n2)Multiplicar dos números (a * b)\n3)Restar dos números (a - b)\n4)Dividir dos números (a / b)")

    r = int(input("Digite la opción deseada: "))
    a = int(input("Digite el primer número (a): "))
    b = int(input("Digite el segundo número (b): "))

    if r == 1:
        c = a + b
        print(f"{a} + {b} = {c}")
    elif r == 2:
        c = a * b
        print(f"{a} * {b} = {c}")
    elif r == 3:
        c = a - b
        print(f"{a} - {b} = {c}")
    elif r == 4:
        if b != 0:
            c = a / b
            print(f"{a} / {b} = {c}")
        else:
            print("Error, el segundo número (b) siendo el denominador es 0, no se puede dividir entre 0")
    else:
        print("Opción no valida")

# CODIGO PRINCIPAL
print("Bienvenido\n1)Actividad 1 (Semaforo)\n2)Actividad 2 (Semaforo con peaton)\n3)Actividad 3 (+,-,*,/ de 2 números)")
o = int(input("Digite la opcion a ejecutar: "))

if o == 1:
    actividad_1()
elif o == 2:
    actividad_2()
elif o == 3:
    actividad_3()
else:
    print("Opcion no valida")