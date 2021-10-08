# Ejercicio número |Maratón de programación 6 Sesión 5|
dia = int(input("Digite el día: "))

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