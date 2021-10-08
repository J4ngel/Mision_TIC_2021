#----------->Estilo de formato
FORMATO = "{:.2f}"
#---------->Funciones
def obtener_datos(ruta):
    try:
        archivo = open(ruta,mode='r',encoding='utf-8')
    except FileNotFoundError:
        print("Error, el archivo no existe")
        return
    filas = archivo.readlines()
    archivo.close()

    claves = filas[0]
    
    claves = claves.strip('\n').split(',')
    
    datos = {}
    
    for i in claves:
        datos[i] = []
    
    for fila in filas[1:]:
        fila = fila.strip('\n').split(',')

        for columna in range(len(datos)):
            datos[claves[columna]].append(fila[columna])
    
    info = [claves, datos]
    
    return info
    
def entregado(ps,pd):
    entrega = False
    ps = int(ps)
    pd = int(pd)

    if ps < 72 and pd <65:
        entrega = True

    elif ps >=124 and ps <138 and pd>=81 and pd<93:
        entrega = True
        
    elif ps >=138 and ps <156 and pd >=93 and pd <102:
        entrega = True
        
    elif ps >=156 and ps <175 and pd >=102 and pd <114:
        entrega = True
        
    elif ps >=175 and pd >=114:
        entrega = True
        
    elif ps >=136 and pd <92:
        entrega = True

    return entrega

def procesamiento(id,claves,datos):
    #--------->Inicialización de variables
    id = str(id)
    T_hombres = T_mujeres = Total_p = 0
    entrega_h = entrega_m = 0
    med_solicitada = []
    med_entregada = [[],[]]
    suma1 = suma2 = 0      
    p_entregados = 0
    s1 = s2 =0                 
    
    #------------->Recorrido de los datos
    for i in range(len(datos[claves[0]])):
        #--------->verificación del id ingresado con los de la base de datos
        if id == datos[claves[5]][i]:
            #------>Capturar nombre de la ciudad y el departamento
            nombre_ciudad= datos[claves[3]][i]
            departamento = datos[claves[4]][i]
            #------>Obtener el número total de pacientes, solo hombres y solo mujeres
            Total_p += 1
            if 'm' == datos[claves[2]][i]:
                T_hombres += 1
            elif 'f' == datos[claves[2]][i]:
                T_mujeres += 1
            #------>Obtener la sumatoria de medicina solicitada y una lista con dichos valores
            suma1 += int(datos[claves[-3]][i])
            med_solicitada.append(int(datos[claves[-3]][i]))
            #------>Saber si la persona le entregaron medicamento, sumatoria de los medicamentos
            #       entregados y el total de pacientes que les entregaron medicina tanto solo hombres como
            #        solo mujeres
            if entregado(datos[claves[-2]][i], datos[claves[-1]][i]):
                suma2 += int(datos[claves[-3]][i])
                p_entregados += 1
                med_entregada[0].append(int(datos[claves[-3]][i]))
                med_entregada[1].append(i)
                if 'm' == datos[claves[2]][i]:
                    entrega_h += 1
                elif 'f' == datos[claves[2]][i]:
                    entrega_m += 1
    #--------->Calculo de promedios y desviaciones
    if Total_p == 0:
        prom1 = 0
    else:
        prom1 = suma1/Total_p
    
    if p_entregados == 0:
        prom2 = 0
    else:
        prom2 = suma2/p_entregados
    
    for cantidad in med_solicitada:      
        s1 += (cantidad - prom1)**2
    
    s1 = (s1/(Total_p - 1))**(1/2)

    for cantidad in med_entregada[0]:      
        s2 += (cantidad - prom2)**2
    
    s2 = (s2/(p_entregados - 1))**(1/2)
    #----------->Establecer posición de los maximos y minimos referente a pacientes que se les entregó medicina
    pos_min = med_entregada[0].index(min(med_entregada[0]))
    pos_min = med_entregada[1][pos_min]

    pos_max = med_entregada[0].index(max(med_entregada[0]))
    pos_max = med_entregada[1][pos_max]
    #------------>Aplicación del formato a dos decimales
    prom1 = FORMATO.format(prom1)
    prom2 = FORMATO.format(prom2)
    s1    = FORMATO.format(s1)
    s2    = FORMATO.format(s2)
    #--------->Presentación de los datos
    print(id, nombre_ciudad, departamento)
    print("patients")        
    print(f"male: {T_hombres}")
    print(f"female: {T_mujeres}")
    print(f"total: {Total_p}")
    print("medicine quantity")
    print(f"mean {prom1}")
    print(f"std {s1}")                       
    print(f"min {min(med_solicitada)}")
    print(f"max {max(med_solicitada)}")
    print(f"total {suma1}")
    print("scheduled patients")
    print(f"male {entrega_h}")
    print(f"female {entrega_m}")
    print(f"total {p_entregados}")
    print("scheduled medicine quantity")
    print(f"mean {prom2}")
    print(f"std {s2}")
    print(f"min {min(med_entregada[0])} {datos[claves[0]][pos_min]} {datos[claves[1]][pos_min]} {datos[claves[2]][pos_min]} {datos[claves[6]][pos_min]}")         
    print(f"max {max(med_entregada[0])} {datos[claves[0]][pos_max]} {datos[claves[1]][pos_max]} {datos[claves[2]][pos_max]} {datos[claves[6]][pos_max]}")         
    print(f"total {suma2}")

#---------->Código principal
ruta = "C:\\Users\\Jaime Andres Angel M\\Desktop\\MisiónTIC_2021\\Ciclo 1\\Programacion\\Codigos\\Retos\\data.csv"
#ruta = "data.csv" # probar asi o ../sata.csv
info = obtener_datos(ruta)
claves = info[0]
datos  = info[1]

consulta = input().split()
for i in range(len(consulta)): consulta[i] = int(consulta[i])
consulta.sort()

for i in consulta:
    procesamiento(i,claves,datos)
