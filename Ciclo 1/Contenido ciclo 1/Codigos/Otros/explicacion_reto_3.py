sucursales = []      # Listado vacio de sucusales
med_entregados = []  #Listado vacio de medicamentos entregados
n = 0       # n = numero de sucursales
pacientes = 0 
while n < 1:
    # Lectura en una sola linea de numero de sucursales y pacientes
    n, pacientes = map(int,input("Ingrese #sucursales y #pacientes separado por espacios: ").split())

print(n,pacientes)  #Imprime el valor por separado de sucursales y de pacientes  

for i in range(n):
    sucursales.append(0)
    med_entregados.append(0)
print("Inicializar sucursales",sucursales)  #Me crea el numero de sucursales con valor en 0

for i in range(n):
    while sucursales[i] < 1:
        sucursales[i] = int(input(f"# existencias medicamento, sucursal {i+1}: ")) #Asigna un valor de existencias a cada sucursal

print("Sucursales con sus respectivas existencias",sucursales)

restar = 4    # ESTO NO VA solo para el ejemplo, simula el valor a restar segun los ifs
for i in range(pacientes):
    #Toma de datos de una sola linea ubicación y presiones
    u,ps,pd = map(int,input("ubicación, p.sistolica,p.diastolica separado por espacios: ").split())
    print(f"u = {u}, ps = {ps} y pd = {pd}")
    if u <= n and u>=1:
        u = u - 1                 # u -= 1 lo mismo que u = u-1 se resta porque el usuario ingresa un valor como pseudocodigo
        sucursales[u] = sucursales[u] - restar  #Se resta el valor de los ifs a las existencias de la ubicación/sucursal digitada
        med_entregados[u] = med_entregados[u] + restar # Se acumula el valor restado ya que son los medicamentos entregados

print("Sucursales despues de las diferentes entregas",sucursales)
minimo = sucursales[0] 
maximo = sucursales[0]
pos_min = 1
pos_max = 1
for i in range(n):
    if minimo > sucursales[i]:
        minimo = sucursales[i]
        pos_min = i +1              #se suma 1 a i ára que el usuario entienda la ubicación como pseudo codigo

    if maximo < sucursales[i]:
        maximo = sucursales[i]
        pos_max = i + 1             #lo mismo pero para la posicion de maximo

print(f"La sucursal con menor existencias es {pos_min} con un valor de existencias {minimo}")
print(f"La sucursal con mayor existencias es {pos_max} con un valor de existencias {maximo}")
for i in range(n):
    porcentaje = (med_entregados[i]/(med_entregados[i]+sucursales[i]))*100
    porcentaje = "{:.2f}".format(porcentaje)
    print(f"Sucursal {i+1},porcentaje {porcentaje}%")

