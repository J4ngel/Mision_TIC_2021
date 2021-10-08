def f1():
    edad = int(input("Edad: "))
    if edad < 0:
        print("Error la edad digitada es negativa")
    elif edad < 18:
        print("Usted es menor de edad")
    else:
        print("Usted es mayor de edad")

def f2():
    print("Este programa mezcla dos colores")
    print(" r. Rojo     a. Azul")
    c1 = input("Elija un color (r o a): ")

    if c1 == "r" or c1 == "R":
        print(" a. Azul     v. Verde")
        c2 = input("Elija otro color ( a o v): ")

        if c2 == "a" or c2 == "A":
            print("El color es Magenta")
        else:
            print("El color es Amarillo")

    else:
        print(" v. Verde    r. Rojo")
        c2 = input("Elija otro color ( v o r): ")

        if c2 == "v" or c2 == "V":
            print("El color es Cian")
        else:
            print("El color es Magenta")
    print("\nGracias por usar nuestro software")

def ej1():
    #Ejercicio 1. Estructura secuancial, x = (a+b)^2/3
    a = int(input("Valor de A: "))
    b = int(input("Valor de B: "))
    x = ((a + b)**2)/3
    print("Resultado:",x)

def ej2():
    #Ejercicio 2. estructura secuancial
    #Hallar el cociente y el residuo de dos números enteros
    n1=int(input("Número 1: "))
    n2=int(input("Número 2: "))
    cociente = n1//n2
    residuo = n1%n2
    print("El cociente es:",cociente)
    print("El residuo es:",residuo)

def ej3():
    #Ejercicio 3. condicional simple
    #Dados dos números diferentes devolver el número mayor
    n1 = int(input("Número 1: "))
    n2 = int(input("Número 2: "))

    if n1 > n2:
        mayor = n1
    else:
        mayor = n2
    print(f"El número mayor es {mayor}")


# ------------->CODIGO PRINCIPAL<-------------------
# Seleccionar un bloque de código Alt + shift + a y lo comentarea todo
#f1()
#f2()
#ej1()
#ej2()
ej3()