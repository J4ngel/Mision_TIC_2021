try:
    archivo = open("data.csv", mode = 'r', encoding="UTF-8")
except:
    print("No se encuentra el archivo")

lineas = archivo.readlines()
archivo.close()

""""print("Ya leí el archivo")
print()
for linea in range(5):
    print(lineas[linea])"""

columnas = ["NOMBRE","APELLIDO","GENERO","CIUDAD","DEPARTAMENTO","ID","TIPO","CANTIDAD","PS","PD"]

datos = {}

for i in columnas:
    datos[i] = []

for linea in lineas[1:]:
    linea = linea[:-1].split(',')
    for i in range(len(columnas)):
        datos[columnas[i]].append(linea[i])

"""for i in range(5):
    print(datos["NOMBRE"][i], end=" ")
    print(datos["APELLIDO"][i], end=" ")
    print(datos["GENERO"][i], end=" ")
    print(datos["CIUDAD"][i], end=" ")
    print(datos["DEPARTAMENTO"][i], end=" ")
    print(datos["ID"][i], end=" ")
    print(datos["TIPO"][i], end=" ")
    print(datos["CANTIDAD"][i], end=" ")
    print(datos["PS"][i], end=" ")
    print(datos["PD"][i])"""

consulta = input().split()
#print(consulta)
for i in range(len(consulta)):
    consulta[i] = int(consulta[i])

consulta.sort()
#print(consulta)
for sucursal in consulta:
    # Inicialización de variables para calculos
    hombres_total   = 0
    hombres_entrega = 0
    med_solicitada  = 0
    total_pacientes = 0
    des_estandar_1  = 0
    #Recorrido de todos los pacientes
    for i in range(len(datos["NOMBRE"])):
        #Filtro comparación de  id ingresado por el usuario y el de la base de datos
        if sucursal == int(datos["ID"][i]):
            nombre_ciudad = datos['CIUDAD'][i]
            departamento = datos['DEPARTAMENTO'][i]
            
            if 'm' == datos["GENERO"][i]:
                hombres_total += 1
                
                if int(datos["PS"][i]) < 72  and int(datos["PD"][i]) < 65:
                    hombres_entrega += 1 
                # continuará.....
            med_solicitada += int(datos["CANTIDAD"][i])
            total_pacientes += 1

    #calculo del promedio para la medicina solicitada
    prom =med_solicitada/total_pacientes

    # Calculo de la desviación estandar par el caso de la medicina solicitada
    for i in range(len(datos["NOMBRE"])):
        if sucursal == int(datos["ID"][i]):
            des_estandar_1 += ((int(datos["CANTIDAD"][i])-prom))**2

    des_estandar_1 = (des_estandar_1/(total_pacientes-1))**(1/2)
    des_estandar_1 = "{:.2f}".format(des_estandar_1)
    #      SALIDAS
    print(f"{sucursal} {nombre_ciudad} {departamento}")
    print("patients")
    print(f"male {hombres_total}")
    print("medicine quantity")
    print(f"mean {prom}")
    print(f"std {des_estandar_1}")
    print(f"Total {med_solicitada}")