def ej_clase():
    n1 = int(input("\nDigite un número: "))
    n2 = int(input("Digite un número: "))
    n3 = int(input("Digite un número: "))

    if n1 == n2 and n1 == n3:
        print(f"\nLos numeros son iguales")
    elif n1 == n2 or n1 == n3 or n2 == n3:
        print(f"\nHay dos iguales")
    else:
        print(f"\nLos números son diferentes")
    
    a = int(input("\nDigite el año: "))

    if a%400 == 0:
        print("Año bisiesto")
    elif a%4 == 0 and a%100 !=0:
        print("Año bisiesto")
    else:
        print("Año común")
# -------------------->Maraton de programacion 6<----------------------------------
def ejm1():
    precio = int(input("\nDigite el precio de su compra: $"))
    if precio > 200000:
        pago = precio-(precio*0.2)
    else:
        pago = precio
    print(f"El valor a pagar es ${pago}")

def ejm2():
    mes = int(input("\nDigite el número del mes: "))
    if mes < 0 or mes > 12:
        print("Error, mes no valido")
    elif mes == 2:
        print("El mes digitado tiene 28 o 29 días")
    elif (mes%2 == 0 or mes == 9 or mes == 11) and mes != 8 and mes != 10 and mes != 12:
        print("El mes digitado tiene 30 días")
    elif mes%2 != 0 or mes == 8 or mes == 10 or mes ==12:
        print("El mes digitado tiene 31 días")

def ejm3():
    print("\nPrecio de manzana $1000 por kilo ")
    cantidad = float(input("Digite el peso de compra: "))

    if cantidad >= 0 and cantidad < 2:
        p = 1000*cantidad
        print(f"El precio por su compra es {p}$")
    elif cantidad < 5:
        p = 1000*cantidad
        p = p - (p*0.1)
        print(f"El precio por su compra es {p}$")
    elif cantidad < 10:
        p = 1000*cantidad
        p = p - (p*0.15)
        print(f"El precio por su compra es {p}$")
    elif cantidad >= 10:
        p = 1000*cantidad
        p = p - (p*0.2)
        print(f"El precio por su compra es {p}$")
    else:
        print("Error, no se puede calcular, revise la entrada digitada!!")
    
def ejm4():
    peso = float(input("\nDigite su peso (Kg): "))
    altura = float(input("Digite su altura (m): "))
    IMC = round(peso/(altura**2),1)
    
    if IMC>=18.5 and IMC <= 24.9:
        print(f"IMC: {IMC}  Riesgo: promedio")
    elif IMC >= 25 and IMC <= 29.9:
        print(f"IMC: {IMC}  Riesgo: Aumentado")
    elif IMC >= 30 and IMC <= 34.9:
        print(f"IMC: {IMC}  Riesgo: Moderado")
    elif IMC >= 35 and IMC <= 39.9:
        print(f"IMC: {IMC}  Riesgo: Severo")
    elif IMC >= 40:
        print(f"IMC: {IMC}  Riesgo: Muy severo")
    else:
        print("Error, no se puede calcular")

def ejm5():
    ki = int(input("\nDigite el kilometraje con que recibió el coche: "))
    kf = int(input("Digite el kilometraje con el que entregó el coche: "))
    kr = kf-ki

    if kr <= 3000 and kr > 0:
        print("Debe pagar 300000$")
    elif kr <= 10000:
        pagar = 300000 + (kr-3000)*150
        print(f"Debe pagar {pagar}$")
    elif kr > 10000:
        pagar = 300000 + (kr-10000)*200 + (10000-3000)*150
        print(f"Debe pagar {pagar}$")
    else:
        print("Error, no se puede calcular")

def ejm6():
    precio = int(input("\nDigite el precio de su copra: $"))

    if precio > 1000000:
        pago = precio - (precio*0.2)
        print(f"El valor a pagar es {pago}")
    elif precio < 0:
        print("Error datos invalidos")
    else:
        pago = precio
        print(f"El valor a pagar es {pago}")

def ejm7():
    temp = int(input("\nDigite la temperatura (°C): "))
    
    if temp >= -10 and temp <10:
        print("Sensacion termica: Mucho frío")
    elif temp < 15:
        print("Sensacion termica: Poco frío")
    elif temp < 25:
        print("Sensacion termica: Temperatura normal")
    elif temp < 30:
        print("Sensacion termica: Poco calor")
    elif temp < 45:
        print("Sensacion termica: Mucho calor")
    else:
        print("Temperatura fuera de rango")

def ejm8():
    dia = int(input("\nDigite el número de día (1-7): "))

    if dia == 1:
        print("Lunes")
    elif dia == 2:
        print("Martes")
    elif dia == 3:
        print("Miercoles")   
    elif dia == 4:
        print("Jueves")
    elif dia == 5:
        print("Viernes")
    elif dia == 6:
        print("Sabado")
    elif dia == 7:
        print("Domingo")
    else:
        print("Error")  

def ejm9():
    t_empleado = float(input("\nDigite el tiempo (en años) que tiene en la empresa: "))
    utilidad    =   int(input("Digite la utilidad: $"))

    if t_empleado < 1 and t_empleado > 0:
        r_utilidades = utilidad*0.05

    elif t_empleado < 2:
        r_utilidades = utilidad*0.07

    elif t_empleado < 5:
        r_utilidades = utilidad*0.1
    
    elif t_empleado <= 10:
        r_utilidades = utilidad*0.15

    elif t_empleado >10:
        r_utilidades = utilidad*0.25
    
    else:
        print("Error, revise las entradas")
        r_utilidades = "ERROR NO SE PUFO CALCULAR"

    print(f"Su reparto de utilidad es de ${r_utilidades}")

def ejm10():
    ingresos = int(input("\nDigite sus ingresos: $"))
    v_casa = int(input("Digite el valor de la casa: $"))
    
    if ingresos < 1500000 and ingresos >= 0:
        cuota_i = round(v_casa*0.15,1)
        cuotas = round((v_casa - cuota_i)/(10*12),1)
        print(f"Su cuota inicial será de {cuota_i}$ y las cuotas mensuales tendran un valor de {cuotas}$ por 10 años")
    elif ingresos >= 1500000:
        cuota_i = round(v_casa*0.3,1)
        cuotas = round((v_casa - cuota_i)/(7*12),1)
        print(f"Su cuota inicial será de {cuota_i}$ y las cuotas mensuales tendran un valor de {cuotas}$ por 7 años")
    else:
        print("Error, los ingresos deben ser positivos")

def ejm11():
    cantidad = int(input("\nDigite la cantidad de docenas que desea llevar: "))
    pun = int(input("Digite el precio del producto: $"))

    if cantidad > 3:
        p_sin = pun*cantidad
        descuento = p_sin*0.15
        cortesia = cantidad-3
        p_con = p_sin - descuento
        print(f"Valor total: {p_sin}$, Descuento: {descuento}$, Cortesías {cortesia}, Valor a pagar: {p_con}$")
    elif cantidad <=3 and cantidad >= 0:
        p_sin = pun*cantidad
        descuento = p_sin*0.1
        cortesia = 0
        p_con = p_sin - descuento
        print(f"Valor total: {p_sin}$, Descuento: {descuento}$, Cortesías {cortesia}, Valor a pagar: {p_con}$")
    else:
        print("Error, los ingresos deben ser positivos")

def ejm12():
    print("\nEl dia 1 comienza en lunes")
    dia = int(input("Digite el día: "))

    if dia<=31 and dia>0:
        cedula = int(input("Digite su cédula: "))
        excepcion = input("¿Tiene excepción? (Y/N): ")

        if excepcion == "Y" or excepcion == "y":
            print("Puede salir")
        elif cedula%2 == 0 and dia%2 == 0 and dia%7 != 0:
            print("Puede salir")
        elif cedula%2 != 0 and dia%2 != 0 and dia%7 != 0:
            print("Puede salir")
        else:
            print("No puede salir")
    else:
        print("Error, Datos no validos")

def ejm13():
    dia = int(input("\nDigite el día: "))

    if dia<=31 and dia>0:
        cedula = int(input("Digite su cédula: "))

        if cedula > 0:

            if cedula%2 == 0 and dia%2 == 0:
                print("Puede salir")
            elif cedula%2 != 0 and dia%2 != 0:
                print("Puede salir")
            else:
                print("No puede salir")

        else:
            print("La cedula no puede ser negativa")
    else:
        print("Error, Datos no validos")

def menu():
    print("""
+------------------------------------------------------+
|  -----------------> Bienvenido <------------------   |
|                                                      |
| 1. Calcular el 20% de una compra si pasa de 200000   |
| 2. Días que tiene un mes                             |
| 3. Descuento por peso de compra                      |
| 4. IMC                                               |
| 5. Alquiler de vehiculos                             |
| 6. 20% de la compra si pasa de 1000000 la compra     |
| 7. Sensación termica                                 |
| 8. Saber el dia (1-7)                                |
| 9. Calcular el reparto de utilidad de un empleado    |
|10. Cuotas de vivienda                                |
|11. Docenas y cortesias                               |
|12. Pico y cedula por covid-19 (par/impar y excepcion)|
|13. Pico y cedula por covid-19 (par/impar)            |
+------------------------------------------------------+""")
    r = int(input("\nDigite una opcion del menú: "))

    if r == 1:
        ejm1()
    elif r == 2:
        ejm2()
    elif r == 3:
        ejm3()
    elif r == 4:
        ejm4()
    elif r == 5:
        ejm5()
    elif r == 6:
        ejm6()
    elif r == 7:
        ejm7()
    elif r == 8:
        ejm8()
    elif r == 9:
        ejm9()
    elif r == 10:
        ejm10()
    elif r == 11:
        ejm11()
    elif r == 12:
        ejm12()
    elif r == 13:
        ejm13()
    else:
        print("Error, opcion no valida")
    #input("Presione enter para salir...")

# Principal
menu()