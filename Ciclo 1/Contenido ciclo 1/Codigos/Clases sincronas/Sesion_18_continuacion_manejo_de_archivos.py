#Ejemplo para escribir dentro de un archivo
def ej_escribir_en_un_archivo():
    nuevoArchivo = open("C:/Users/Jaime Andres Angel M/Desktop/MisiónTIC_2021/Ciclo 1/Programacion/Codigos/Clases sincronas/archivos/ej 2.txt", mode='w', encoding="UTF-8") #UTF-8 para poder escribir con caracteres especiales (ñ, á, etc)
    nuevoArchivo.write("YO python generé una linea\n")
    nuevoArchivo.write("AlV ahora generé otra, ya son 2!!")

#Ejemplo para crear un diccionario e imprimir todos los valores pareja
def ej_diccionarios():    
    dias = {1:"Lunes",
            2:"Martes",
            3:"Miercoes",
            4:"Jueves",
            5:"viernes",
            6:"Sabado",
            7:"Domingo"}
    print(dias)
    print(dias[2])

#------------->Actividades
#Ejercicio 1.
#Escribir un programa que pregunte al usuario su nombre, edad, dirección y teléfono, y lo guarde
#en un diccionario. Después debe mostrar por pantalla el mensaje <nombre> tiene <edad> años, vive en
#<direccion> y su número de teléfono es <teléfono>.
def ac1():
    info = {}
    info["Nombre"] = input("Digite su nombre: ")
    info["Edad"] = input("Digite su edad: ")
    info["Direccion"] = input("Digite su direccion: ")
    info["Telefono"] = input("Digite su telefono: ")
    
    print(f"\n{info['Nombre']} tiene {info['Edad']} años, vive en {info['Direccion']} y su número de telefono es {info['Telefono']}")

#ac1()

#Ejercicio 2.
#Escribir un programa que almacene el diccionario con los créditos de las asignaturas de un curso
#{'Matemáticas':6,'Física':4,'Química':5} y después muestre por pantalla los créditos de cada asignatura
#en el formato <asignatura> tiene <créditos> créditos, donde <asignatura> es cada una de las asignaturas
#del curso, y <créditos> son sus créditos. AL final debe mostrar también el número total de créditos
#del curso.
def ac2():
    creditos = {'Matemáticas':6,'Física':4,'Química':5}
    total = 0
    for i in creditos.keys():
        print(f"{i} tiene {creditos[i]} creditos")
        total += creditos[i]
    print(f"El número total de creditos del curso es {total}")
    
#ac2()

#Ejercicio 3.
#Escribir un programa que guarde en un diccionario los precios de las frutas de la tabla, pregunte al 
#usuario por una fruta, un número de kilos y muestre por pantalla el precio de ese número de kilos de fruta.
#Si la fruta no está en el diccionario debe mostrar un mensaje informando de ello.
#Fruta    Precio
#------   -------- 
#Platano  1.35
#Manzana  0.80
#Pera     0.85
#Naranja  0.70
def ac3():
    while True:
        precios_fruta = {"Platano": 1.35,"Manzana": 0.80,"Pera": 0.85,"Naranja": 0.70}
    
        fruta = input("\nFruta: ").title()
 
        if fruta in precios_fruta.keys():
            kilos = int(input("Peso (Kg): "))
            print(f"{kilos} de {fruta} tiene un valor de ${kilos * precios_fruta[fruta]}")
            break
        else:
            print("\nNo vendemos esa fruta, pregunte por otra")
#ac3()
#-----------------------------------------
# Actividad 1
#
# Vamos a elaborar un algoritmo que permita ingresar un número entero (1 a 10), y muestre su equivalente en 
# romano usando un diccionario como lo definimos anteriormente. 
def num_romanos():
    romanos = {1:"I",2:"II",3:"III",4:"IV",5:"V",6:"VI",7:"VII",8:"VIII",9:"IX",10:"X"}
    num = 0
    while num < 1 or num > 10:
        num = int(input("\nDigite un número entre el 1 y 10: "))
        if num < 1 or num > 10:
            print("Error, digite un número entre el 1 y el 10")

    print(f"\n{num} en números romanos es {romanos[num]}")
#num_romanos()

#Actividad 2 
#Recordemos una de las actividades que hicimos en sesiones anteriores.
#
#Diseña un programa con las siguiente características:
#
#    Que tenga una función caja que 
#       a. Cree un archivo recibo.txt
#       b. Solicite al usuario nombre y precio de cada producto.
#       c. Una función adicional llamada guardaProducto(nombre, precio, archivo) que reciba el nombre y el precio de 
#          cada producto y los escriba en el archivo recibo.txt.
#       d. Que después de llamar a guardaProducto le pregunte al usuario si tiene o no más artículos a ingresar. 
#          Si no tiene, el programa debe detenerse.
#    Al final de tus funciones, puedes simplemente llamar a la función caja para probar
def guardaProducto(nombre,precio,archivo):
    archivo.writelines(f"Producto: {nombre}, Precio: ${precio}\r")   

def caja():
    ruta = "C:/Users/Jaime Andres Angel M/Desktop/MisiónTIC_2021/Ciclo 1/Programacion/Codigos/Clases sincronas/archivos/recibo.txt"
    archivo = open(ruta, mode='w', encoding="UTF-8")
    agregar = 'S'
    while agregar == 'S' or agregar == 's':
        nombre = input("Nombre del producto: ")
        precio = input("Precio del producto: $")

        guardaProducto(nombre, precio, archivo)

        agregar = input("Desea agregar mas articulos (S/N): ")

    archivo.close()

    input("Gracias por usar nuestro software!!"
          "\nPresione enter para salir...")
#caja()

#Ejercicio propuesto utilizando el formato CSV(Valores separados por coma)
#El fichero cotizacion.csv contiene las cotizaciones de las empresas del IBEX35 con las siguientes columnas: 
#Nombre (nombre de la empresa), Final (precio de la acción al cierre de bolsa), 
#Máximo (precio máximo de la acción durante la jornada), Mínimo (precio mínimo de la acción durante la jornada), 
#Volumen (Volumen al cierre de bolsa), Efectivo (capitalización al cierre en miles de euros).
#
#Construir una función reciba el fichero de cotizaciones y devuelva un diccionario con los datos del fichero por columnas.
#
#Construir una función que reciba el diccionario devuelto por la función anterior y cree un fichero en formato csv con el 
#mínimo, el máximo y la media de dada columna.

def limpiar(cifra):
    cifra = cifra.replace('.','')
    cifra = cifra.replace(',','.')
    return float(cifra)

def pre_procesado(ruta):
    try:
        f = open(ruta, 'r')

    except FileNotFoundError:
        print("El archivo no existe")
        return
    
    lineas = f.readlines()
    f.close()

    claves = lineas[0]
    claves = claves[:-1].split(';')

    cotizaciones = {}
    for i in claves:
        cotizaciones[i] =[]

    for linea in lineas[1:]:
        linea = linea[:-1].split(';')
        cotizaciones[claves[0]].append(linea[0])
        for i in range(1, len(cotizaciones)):
            cotizaciones[claves[i]].append(limpiar(linea[i]))
        
        return cotizaciones

def resumen_cotizaciones(cotizaciones, ruta):
    del(cotizaciones['Nombre'])
    f = open(ruta,'w')
    f.write('Nombre')
    for clave in cotizaciones.keys():
        f.write(';'+clave)
    f.write('\nMinimo')
    for valores in cotizaciones.values():
        f.write(';'+str(min(valores)))
    f.write('\nMaximo')
    for valores in cotizaciones.values():
        f.write(';'+str(max(valores)))
    f.write('\nPromedio')
    for valores in cotizaciones.values():
        f.write(';'+str(sum(valores)/len(valores)))
    f.close()
    return

ruta = "C:\\Users\\Jaime Andres Angel M\\Desktop\\MisiónTIC_2021\\Ciclo 1\\Programacion\\Codigos\\Clases sincronas\\archivos\\cotizacion.csv" 
ruta_destino = "C:\\Users\\Jaime Andres Angel M\\Desktop\\MisiónTIC_2021\\Ciclo 1\\Programacion\\Codigos\\Clases sincronas\\archivos\\resume_cotizaciones.csv"
cotizaciones = pre_procesado(ruta)
resumen_cotizaciones(cotizaciones, ruta_destino)