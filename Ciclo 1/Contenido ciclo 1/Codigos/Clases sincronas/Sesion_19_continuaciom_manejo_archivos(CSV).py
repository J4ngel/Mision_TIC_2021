#------------>Librerias
import csv
def leer_archivos_csv(ruta): 
    ruta = ruta+"matrizAsignacion.csv"
    archivo = open(ruta,mode='r',encoding="UTF-8")
    registro = csv.reader(archivo)

    for fila in registro:
        print(fila)

    archivo.close()

def apertura_I_O_CSV(ruta):
    ruta = ruta+"matrizAsignacion.csv"
    nueva_ruta = ruta+"RESULTADO_MA.csv"
    archivo = open(ruta, mode='r', encoding='UTF-8')
    nuevo = open(nueva_ruta, mode='w', encoding='UTF-8')

    registro =csv.reader(archivo)
    nuevo_registro = csv.writer(nuevo)

    for fila in registro:
        fila.append("NUEVO")
        nuevo_registro.writerow(fila)

    archivo.close()
    nuevo.close()

def leerClentes(ruta):
    archivo = open(ruta+"archivoClientesEntrega.csv",mode='r',encoding='UTF-8')
    nuevo = open(ruta+"archivosClientes.csv",mode='w',encoding='UTF-8')

    registro = csv.reader(archivo)
    n_registro = csv.writer(nuevo)

    clientes = {}
    cont = 0
    camiones = []
    encabezados = ["Clientes","Número de camiones"]
    n_registro.writerow(encabezados)

    for fila in registro:
        if cont > 0:
            if fila[0] in clientes:
                clientes[fila[0]].append(fila[1])
            else:
                clientes[fila[0]] = [fila[1]]
        else:
            cont = 1  

    for key in clientes:
        numCamiones = list(dict.fromkeys(clientes[key]))
        clientes[key] = len(numCamiones)
        fila = [key,str(len(numCamiones))]
        n_registro.writerow(fila)
    archivo.close()
    nuevo.close()

def ej1(ruta):
    archivo = open(ruta+"personas.txt", mode="r",encoding="utf-8")
    filas = archivo.readlines()
    archivo.close()

    id = {"ID":[]}
    nombre ={"NOMBRE":[]}
    apellido = {"APELLIDO":[]}
    nacimiento= {"FECHA DE NACIMIENTO":[]}

    for fila in filas:
        fila = fila.split(";")
    
        id["ID"].append(fila[0])
        nombre["NOMBRE"].append(fila[1])
        apellido["APELLIDO"].append(fila[2])
        nacimiento["FECHA DE NACIMIENTO"].append(fila[3])
    
    personas = [id,nombre,apellido,nacimiento]
    claves = ["ID","NOMBRE","APELLIDO","FECHA DE NACIMIENTO"]
    #print(personas[0]["ID"][0])
    
    for persona in range(len(personas[0]["ID"])):
        for datos in range(len(personas)):
            print(f"{claves[datos]}: {personas[datos][claves[datos]][persona]}")
        print()
        
def ej2(ruta):
    while True:
        try: 
            archivo = open(ruta+"contador.txt", mode="r",encoding="utf-8")
            archivo.close()
            break
        except FileNotFoundError:
            archivo = open(ruta+"contador.txt", mode="w",encoding="utf-8")
            archivo.write("0")
            archivo.close()
    argumento = ""
    while argumento!="salir":
        argumento = input("ingrese un argumento (inc= +1, dec =-1, salir): ")
        archivo = open(ruta+"contador.txt", mode="r",encoding="utf-8") 
            
        if argumento == "inc":
            numero = int(archivo.read())
            numero += 1
            archivo.close()
            archivo = open(ruta+"contador.txt", mode="w",encoding="utf-8")
            archivo.write(str(numero))
            archivo.close()
        elif argumento == "dec":
            numero = int(archivo.read())
            numero -= 1
            archivo.close()
            archivo = open(ruta+"contador.txt", mode="w",encoding="utf-8")
            archivo.write(str(numero))
            archivo.close()
        else:
            print(f"Contador = {archivo.read()}")
    
    


#------------->Código principal
ruta = "C:\\Users\\Jaime Andres Angel M\\Desktop\\MisiónTIC_2021\\Ciclo 1\\Programacion\\Codigos\\Clases sincronas\\archivos\\"
#leer_archivos_csv(ruta)
#apertura_I_O_CSV(ruta)
#leerClentes(ruta)
#ej1(ruta)
ej2(ruta)