def archivos_python():         #Para tomar todo el texto de tope
    archivo = open("C:/Users/Jaime Andres Angel M/Desktop/MisiónTIC_2021/Ciclo 1/Programacion/Codigos/Clases sincronas/archivos/mi_archivo.txt",'r')
    texto = archivo.read()
    print(texto)

def archivos_python2():        #Para tomar una linea de teto del código
    archivo = open("C:/Users/Jaime Andres Angel M/Desktop/MisiónTIC_2021/Ciclo 1/Programacion/Codigos/Clases sincronas/archivos/mi_archivo.txt",'r')
    linea = archivo.readline()
    print(linea)
    print("Leí la primera linea, vamos por la segunda \n")
    linea = archivo.readline()
    print(linea)

def leer_M_asignacion():
    M_asignacion = []
    archivomatriz = open("C:/Users/Jaime Andres Angel M/Desktop/Temporal/sesion18/matrizAsignacion.txt",'r')

    datosmatriz = archivomatriz.readline()
    fila = datosmatriz.rstrip('\n').split(',')
    M_asignacion.append(fila)

    while datosmatriz:
        datosmatriz = archivomatriz.readline()
        fila = datosmatriz.rstrip('\n').split(',')
        M_asignacion.append(fila)
     

    print(M_asignacion,"\n")   #Me imprime la matriz
    
    for i in M_asignacion:     #Me imprime la matriz de forma grafica
        print(i)

#Escribir un programa para gestionar un listín telefónico con los nombres y los teléfonos de los 
#clientes de una empresa. El programa incorporar funciones crear el fichero con el listín si no 
#existe, para consultar el teléfono de un cliente, añadir el teléfono de un nuevo cliente y eliminar 
#el teléfono de un cliente. El listín debe estar guardado en el fichero de texto `listin.txt` donde 
#el nombre del cliente y su teléfono deben aparecer separados por comas y cada cliente en una línea 

def leer_telefonos(arch, cliente):
    """
    Función que devuelve el teléfono de un cliente de un fichero o archivo dado.
    Parametros:
        arch: Fichero con los nombres y telefonos de clientes
        cliente: Es una cadena con el nombre del cliente
    Devuelve: 
        El telefono del cliente guardado en el fichero o un mensaje de error si el fichero no existe 
    """
    try:
        f = open(arch,'r')
    except FileNotFoundError:
        return "El archivo "+arch+" NO existe!\n"
    
    directorio = f.readlines()
    f.close()
    directorio = dict([tuple(line.split(',')) for line in directorio])

    if cliente in directorio:
        return directorio[cliente]

    else:
        return "El cliente "+cliente+" NO existe!\n"

def agregar_telefono(arch,cliente,tel):         
    """
    Función que añade el telefono de un cliente de un Fichero
    Parametros:
        arch: Es un fichero con los nombres y telefonos de los clientes
        cliente: Es una cadena con el nombre del cliente
        tel: Es una cadena con el telefono del cliente
    Devuelve: 
        Un mensaje informando sobre si el teefono se ha agregado o ha habido algun problema
    """
    try:
        f = open(arch,'a')
    except FileNotFoundError:
        return"El archivo "+arch+" NO existe!\n"
    
    f.write(cliente+","+tel+'\n')
    f.close()
    return "El telefono se ha añadido.\n"

def eliminar_telefono(arch,cliente):
    """
    Funcion que elimina el telefono de un cliente en un fichero dado
    Parametros:
        arch: Es un fichero con los nombres y telefonos de los clientes
        cliente: Es una cadena con el nombre del cliente
    Devuelve:
        Un mensaje informando sobre si el telefono se ha borrado o hubo algun problema
    """

    try:
        f = open(arch,'r')
    except FileNotFoundError:
        return "El archivo "+arch+" NO existe!\n"
    
    directorio = f.readlines()
    f.close()
    directorio = dict([tuple(line.split(",")) for line in directorio])

    if cliente in directorio:
        del directorio[cliente]
        f = open(arch,'w')
        for nombre,telefono in directorio.items():         
            f.write(nombre+","+telefono)
            f.close()
            return "El cliente se ha borrado!\n"
    else:
        return "El cliente "+cliente+" NO existe\n"

def crear_directorio(arch):
    """
    Función que crea un fichero vacio para guardar un listado telefonico 
    Parametros: 
        arch: Es un fichero
    Devuelve: Esun mensaje informando sobre si el fichero se ha creado correctamente o no
    """
    import os
    if os.path.isfile(arch):
        respuesta = input(f"El archivo {arch} ya existe. ¿Desea vaciarlo?(S/N): ")
        if respuesta == 'N':
            return "No se ha creado el archivo porque ya existe!!\n"
    f = open(arch,'w')
    f.close()
    return "Se ha creado el archivo\n"

def menu():
    print("D.Telefonico")
    print("1 - Consultar un telefono")
    print("2 - Añadir añadir un telefono")
    print("3 - Eliminar un telefono")
    print("4 - crear el listado")
    print("0 - Terminar el listado")
    o = input("Opción: ")
    return o

def directorio():       
    arch = "C:/Users/Jaime Andres Angel M/Desktop/MisiónTIC_2021/Ciclo 1/Programacion/Codigos/Clases sincronas/archivos/directorio.txt"
    
    while True:
        o = menu()
        if o =='1':
            nombre = input("Nombre del cliente a consultar: ")
            print(leer_telefonos(arch,nombre))
        elif o =='2':
            nombre = input("Nombre del cliente a añadir: ")
            telefono = input("Telefono del cliente a añadir: ")
            print(agregar_telefono(arch,nombre, telefono)) 
        elif o=='3':
            nombre = input("Nombre del cliente a consultar: ")
            print(eliminar_telefono(arch,nombre))
        elif o=='4':
            print(crear_directorio(arch))
        elif o =='0':
            break
        else:
            print("\nOpción no valida!!")

directorio()