"""Reto Semana 3
El aplicativo debe cumplir los siguientes requerimientos: 
1. Solicitar usuario y contraseña validando que las credenciales sean correctas y permitiendo 4 intentos máximos.
Luego de los 4 intentos fallidos se debe cerrar el aplicativo; el usuario predefinido es admin y la contraseña será MisionTic2021. 
2. Si el ingreso es exitoso, se debe mostrar un menú con las siguientes opciones: 
-1. Registrar ingreso de empleado.
-2. Ver empleados ingresados.
-3. Registrar ingreso de visitantes. 
-4. Ver visitantes ingresados.
-0. Salir.
3.El menú debe mostrarse hasta que el usuario digite una opción válida o determine salir. 
4. Al seleccionar las opciones 1 y 3, se deben guardar el registro de quién ingresa de manera iterativa,
es decir, el usuario podrá registrar tantos empleados y visitantes como se requieran, sin necesidad de ingresar 
cada vez al menú. Se dejará de ingresar empleados o visitantes cuando el usuario no incluya ninguno y oprima la tecla enter.
5. Al seleccionar las opciones 2 y 4, se debe visualizar los empleados y visitantes según corresponda, separados por comas (,)."""

def verificador_credenciales():
    datos_validacion = ["admin","MisionTic2021", 0]

    while datos_validacion[2] != 4:
        usuario = input("\nUsuario: ")
        contraseña = input("Contraseña: ")
        if usuario == datos_validacion[0] and contraseña == datos_validacion[1]:
            break
        else:
            datos_validacion[2] += 1
            print("\nError, credenciales no validas, verifique su usuario y contraseña")
        
    if datos_validacion[2] < 4:
        return True
    else:
        return False

def reg_empleado(empleados, primer_dato):
    print()
    while True:
        datos = input("Digite el nombre del empleado: ")
        if datos == "":
            break
        elif primer_dato:
            empleados = datos
            primer_dato = False
        else:
            empleados = empleados+", "+datos

    return empleados

def ver_empleados_ingresados(empleados):
    print("\nEmpleados registrados:")
    if empleados == "":
        print("Ninguno")
    else:
        print(empleados)

    input("\nPresione enter para continuar...")

def reg_visitante(visitantes, primer_dato):
    print()
    while True:
        datos = input("Digite el nombre del visitante: ")
        if datos == "":
            break
        elif primer_dato:
            visitantes = datos
            primer_dato = False
        else:
            visitantes = visitantes+", "+datos

    return visitantes

def ver_visitante_ingresado(visitantes):
    print("\nVisitantes registrados:")
    if visitantes == "":
        print("Ninguno")
    else:
        print(visitantes)

    input("\nPresione enter para continuar...")

def menu ():
    
    salir = False
    empleados = ""
    visitantes = ""
    primer_dato_e = True
    primer_dato_v = True

    while not salir:
        print("\n+------------>BIENVENIDO<-----------+")
        print("|                                   |")
        print("|1. Registrar ingreso de empleado   |")
        print("|2. Ver empleados ingresados        |")
        print("|3. Registrar ingreso de visitantes |")
        print("|4. ver visitantes ingresados       |")
        print("|0. Salir                           |")
        print("+-----------------------------------+")
        opcion = int(input("Digite una opción del menú: "))

        if opcion == 0:
            salir = True
        elif opcion == 1:
            empleados = reg_empleado(empleados,primer_dato_e)
            primer_dato_e = False
        elif opcion == 2:
            ver_empleados_ingresados(empleados)
        elif opcion == 3:
            visitantes = reg_visitante(visitantes, primer_dato_v)
            primer_dato_v = False
        elif opcion == 4:
            ver_visitante_ingresado(visitantes)
        else:
            print("\nError, Opción no valida, intente de nuevo...")
            input("Presione enter para continuar...")
        
def principal():
    acceso = False
    acceso = verificador_credenciales()
    if acceso:
        menu()
        print("\nGracias por usar nuestro software!!")
        input("Presione enter para salir...")

principal()
