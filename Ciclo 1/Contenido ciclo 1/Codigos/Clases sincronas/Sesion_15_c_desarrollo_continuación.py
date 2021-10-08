def crear_asignacion(): 
    datos = []
    datos.append(input("\nPunto de distribución: "))
    datos.append(input("ID del camión: "))
    datos.append(int(input("Tiempo de despacho asignado: ")))
    datos.append(int(input("Cantidad de litros asignados: ")))
    return datos

def crear_registro():
    datos = []
    datos.append(input("\nPunto de distribución: "))
    datos.append(input("ID del camión: "))
    datos.append(int(input("Tiempo de despacho registrado: ")))
    datos.append(int(input("Cantidad de litros despachados: ")))
    return datos

def mostrar_info(M):   
    for i in range(len(M)):
        print(f"\nCamion {i+1}:")

        if M[i][0] == "N":
            print(M[i])
        else:
            for j in range(len(M[i])):
                if j == 0:   print(f"\nEficiencia en tienpo de despacho: {M[i][j]}")
                elif j == 1: print(f"Tasa de entrega: {M[i][j]}")
                elif j == 2: print(f"Nivel de cumplimiento de los despachos: {M[i][j]}")
        print()

def E_T_despacho(datos_iniciales, datos_finales):
    
    eficiencia = (datos_iniciales[2] - datos_finales[2])/datos_iniciales[2]
    eficiencia *=100
    return round(eficiencia, 2)

def T_entrega(datos_iniciales, datos_finales):
    
    tasa_entrega = datos_finales[3]/datos_finales[2]
    tasa_entrega *=100
    return round(tasa_entrega,2)

def nivel_cumplimiento(datos_iniciales, datos_finales):
    
    lvl_cumplimiento = datos_finales[3]/datos_iniciales[3]
    lvl_cumplimiento *=100
    return round(lvl_cumplimiento)

def entregas_a_tiempo(datos_iniciales, datos_finales):
    
    if datos_finales[2] < datos_iniciales[2]:
        e_tiempo = 1
        e_tiempo *=100
        return round(e_tiempo,2)
    else:
        return 0

def indicadores(M_asignacion, M_registro):
    d_analisis = "No se puede calcular"
    if M_asignacion[2] > 0 and M_asignacion[3] > 0 and M_registro[2] > 0 and M_registro[3] > 0:
        d_analisis = []

        d_analisis.append(E_T_despacho(M_asignacion, M_registro)) 
        d_analisis.append(T_entrega(M_asignacion, M_registro)) 
        d_analisis.append(nivel_cumplimiento(M_asignacion, M_registro))

    return d_analisis

def menu():
    M_asignacion = []
    M_registro   = []
    M_analisis   = []

    salir = False
    while not salir:
        #print(f"Tam datos asig: {len(M_asignacion)}; Tam datos reg: {len(M_registro)}; Tam analisis: {len(M_analisis)}")
        print("\n------>Bienvenido")
        print("1. Asignar datos de asignación")
        print("2. Asignar datos de registro")
        print("3. Analisis de datos")
        print("4. Salir")
        o = input("Digite una opción del menú: ")

        if o == "1":
            M_asignacion.append(crear_asignacion())
            print("\nDatos agregados con exito")
    
        elif o == "2":
            M_registro.append(crear_registro())
            print("\nDatos agregados con exito")

        elif o == "3":
            M_analisis   = []

            if len(M_asignacion) != len(M_registro):
                print("\nFaltan datos de registro o asignación de un/os camion/es")
            elif len(M_asignacion) == 0 and len(M_registro) == 0:
                print("No se han asignado o registrado valores")
            else:
                for i in range(len(M_asignacion)):
                    temp = indicadores(M_asignacion[i], M_registro[i])
                    if temp != 0:
                        M_analisis.append(temp)
                mostrar_info(M_analisis)

        elif o == "4":
            salir = True
        else:
            input("Error, opción de menú no valida, intente de nuevo"
                 "\nPresione enter para continuar...")
                 
#--------------------->Principal 
menu()
