def mostrar_datos(matriz):
    for fila in matriz:
        print(fila)

M = []
n = k = 0
while n < 1 or k < 1:
    n,k,m = map(int,input("Numero de sucursales, tipos de medicamento, cantidad de pacientes (separado por espacios): ").split())

print(f"Sucursales: {n}, Tipos de medicamento: {k}, Pacientes a atender: {m}")

for i in range(n):
    M.append(input("Valores de existencias para cada tipo de medicamento separado por espacios: ").split())

#Mostrarme la matriz con los datos recien añadidos ojo que son cadenas
mostrar_datos(M)

#Convirtiendo las cadenas en enteros 
for i in range(n):
    for j in range(k):
        M[i][j] = int(M[i][j])

#Mostrando la Matriz con los datos ya convertidos a enteros 
print()
mostrar_datos(M)

pacientes = []

for i in range(n):
    pacientes.append(0)

entregas = []

for i in range(n):
    entregas.append([])
    for j in range(k):
        entregas[i].append(0)

print(f"\nPacientes por sucursal: {pacientes}")
print("\nMatriz de entregas")
mostrar_datos(entregas)

for i in range(m):
    u,tipo,existencias,ps,pd = map(int,input("sucursal,tipomed,existencia a llevar, ps y pd: ").split())
    print(f"\nSucursal: {u}, tipo de medicamento: {tipo}, existencias a llevar: {existencias}, Ps: {ps}, Pd: {pd}")
    if u <= n and u > 0 and tipo > 0 and tipo <= k and existencias >= 0:
        #Entra a los if y se debe entregar se tienen que restar las existencias que pidio el paciente a la matriz que ya teniamos
        if ps >= 72 and ps < 107 and pd >= 65 and pd <73:
            M[u-1][tipo-1] = M[u-1][tipo-1] - 0
            entregas[u-1][tipo-1] =entregas[u-1][tipo-1] + 0

        elif ps >= 124 and ps < 138 and pd >= 81 and pd <93:
            M[u-1][tipo-1] = M[u-1][tipo-1] - existencias
            entregas[u-1][tipo-1] =entregas[u-1][tipo-1] + existencias
        
        pacientes[u-1] = pacientes[u-1] + 1

print()
mostrar_datos(M)
print(f"\nPacientes por sucursal: {pacientes}")

#Mostrar info

for i in range(n):
    print(i+1)
    #Codigo de minimo
    #Codigo de Maximo
    min_entregada = min(entregas[i])
    max_entregada = max(entregas[i])
    suma =0
    for j in range(k):
        suma = suma + entregas[i][j]
    prom1 = suma/k
    
    if pacientes[i] == 0:
        prom2 = 0
    else: 
        prom2 = suma/pacientes[i]
    #Se pone formato a todo
    print(min_entregada, prom1, max_entregada)
    print(prom2)
    print() #este prin NO va

#AQUI VAN LAS ULTIMAS DOS SALIDAS