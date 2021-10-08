def llenar_matriz(M, a = 0):
    
    if a == 0:  
        a = "asignado"
        b = a  
    else:       
        a = "registrado"
        b = "despachados"

    for i in range(len(M)):
        print(f"Información camión {i+1}:")
        for j in range(len(M[i])):
            
            if j == 0:
                M[i][j] = input("Punto de distribución: ")

            elif j == 1:
                M[i][j] = input("Identificación del camión: ")

            elif j == 2:
                while True:
                    M[i][j] = int(input(f"Tiempo de despacho {a}: "))
                    
                    if M[i][j] > 0:
                        break
                    else:
                        print("Error, el tiempo de despacho debe ser mayor a 0, intente de nuevo")

            elif j == 3:
                while True:
                    M[i][j] = int(input(f"Cantidad de litros {b}: "))

                    if M[i][j] > 0:
                        break
                    else:
                        print("Error, la cantidad de litros debe ser mayor a 0, intente de nuevo")
  
        print()

def ver_datos(M, a=0):
    
    if a == 0:  
        a = "asignado"
        b = a  
    else:       
        a = "registrado"
        b = "despachados"

    for i in range(len(M)):
        print(f"Información camión {i+1}:")
        for j in range(len(M[i])):
            
            if j == 0:
                print(f"Punto de distribución: {M[i][j]}")

            elif j == 1:
                print(f"Identificación del camión: {M[i][j]}")

            elif j == 2:
                print(f"Tiempo de despacho {a}: {M[i][j]}")

            elif j == 3:
                print(f"Cantidad de litros {b}: {M[i][j]}")
        print()


def eficiencia_tiempo_despacho(datos_camion_i, d_camion_f):
    
    eficiencia = (datos_camion_i[2] - d_camion_f[2])/d_camion_f[2]
    eficiencia *= 100
    return eficiencia

def tasa_de_entrega(d_camion_i, d_camion_f):
    pass

def lvl_cumplimiento_despachos(d_camion_i, d_camion_f):
    pass

M_asignacion = [[0 for j in range(4)]for i in range(5)]
M_registro   = [[0 for j in range(4)]for i in range(5)]
Datos        = [[0 for j in range(4)] for i in range(5)]  

llenar_matriz(M_asignacion)
llenar_matriz(M_registro, 1)

ver_datos(M_asignacion)
ver_datos(M_registro, 1)