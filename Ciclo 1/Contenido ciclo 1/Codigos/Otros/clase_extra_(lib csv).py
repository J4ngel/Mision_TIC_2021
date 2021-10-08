import csv
#Como leer archivo csv
archivo = open('ruta',mode='r',encoding='utf-8')
registro = csv.reader(archivo)     #Para archivos csv la función csv.reader() devuelve una matriz

for filas in registro:
    print(filas)
archivo.close()

#Como escribir un archivo
archivo = open('ruta',mode='w',encoding='utf-8')
nuevo_arch = open('ruta',mode='w',encoding='utf-8')

registro = csv.reader(archivo)
nuevo_registro = csv.writer(nuevo_arch)

for fila in registro:
    fila.append(input("Agregar: "))
    nuevo_registro.writerow(fila)

archivo.close()
nuevo_arch.close()