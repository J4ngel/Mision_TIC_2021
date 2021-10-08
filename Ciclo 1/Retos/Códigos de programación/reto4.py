#----------->Constantes
FORMATO = "{:.2f}"
#----------->Definición de funciones
def casteo(M, tipo = 0):
    if tipo == 0:
        for i in range(len(M)):
            for j in range(len(M[i])):
                M[i][j] = int(M[i][j])
    else:
        for i in range(len(M)):
            M[i] = int(M[i])

def mostrar_info_por_sucursal(sucursal, entrega):
    pos_min = pos_max = 1
    val_min = val_max = sucursal[0]

    for i in range(len(sucursal)):
        if val_max < sucursal[i]:
            val_max = sucursal[i]
            pos_max = i+1

        if val_min > sucursal[i]:
            val_min = sucursal[i]
            pos_min = i+1

    print(f"{pos_min} {val_min}")
    print(f"{pos_max} {val_max}")
    
    val_max = val_min = entrega[0]
    prom_1 = 0
    for i in range(len(entrega)-1):
        prom_1 += entrega[i]
        if val_max < entrega[i]:
            val_max = entrega[i]

        if val_min > entrega[i]:
            val_min = entrega[i]

    val_min = FORMATO.format(val_min)
    val_max = FORMATO.format(val_max)
    
    prom_1 /= len(sucursal)
    prom_1  = FORMATO.format(prom_1)
    print(f"{val_min} {prom_1} {val_max}")
    

    prom_2 = 0
    for i in range(len(entrega)-1):
        prom_2 += entrega[i]
    
    if entrega[-1] == 0:
        prom_2 = FORMATO.format(0)
    else:
        prom_2 /= entrega[-1]
        prom_2 = FORMATO.format(prom_2)
    print(prom_2)

#----------->Código principal
n = k = 0
while n < 1 or k < 1: 
    n,k,m = map(int,input().split())

sucursales = [input().split() for i in range(n)]
casteo(sucursales)
entregas = [[0 for j in range(k+1)] for i in range(n)]    #Se le agrega una columna mas para llevar el conteo de entregas

for i in range(m):
    datos = input().split()
    casteo(datos,1)
    
    if datos[0] > 0 and datos[0] <= n and datos[1] > 0 and datos[1] <= k and datos[2] >= 0:
        datos[0] -= 1
        datos[1] -= 1

        if datos[3] < 72 and datos[4] <65:
            sucursales[datos[0]][datos[1]]  -= datos[2]
            entregas[datos[0]][datos[1]]    += datos[2]

        elif datos[3] >=124 and datos[3] <138 and datos[4]>=81 and datos[4]<93:
            sucursales[datos[0]][datos[1]] -= datos[2]
            entregas[datos[0]][datos[1]]   += datos[2]
            

        elif datos[3] >=138 and datos[3] <156 and datos[4] >=93 and datos[4] <102:
            sucursales[datos[0]][datos[1]] -= datos[2]
            entregas[datos[0]][datos[1]]   += datos[2]
            

        elif datos[3] >=156 and datos[3] <175 and datos[4] >=102 and datos[4] <114:
            sucursales[datos[0]][datos[1]] -= datos[2]
            entregas[datos[0]][datos[1]]   += datos[2]
            

        elif datos[3] >=175 and datos[4] >=114:
            sucursales[datos[0]][datos[1]] -= datos[2]
            entregas[datos[0]][datos[1]]   += datos[2]
            

        elif datos[3] >=136 and datos[4] <92:
            sucursales[datos[0]][datos[1]] -= datos[2]
            entregas[datos[0]][datos[1]]   += datos[2]
        
        entregas[datos[0]][-1] += 1

for i in range(n):
    print(i+1)
    mostrar_info_por_sucursal(sucursales[i], entregas[i])

val_min = val_max = entregas[0][0]
pos_min = pos_max = 1

for i in range(n):
    if val_min > entregas[i][0]:
        val_min = entregas[i][0]
        pos_min = i+1

    if val_max < entregas[i][0]:
        val_max = entregas[i][0]
        pos_max = i+1

print(f"{pos_min} {val_min}")
print(f"{pos_max} {val_max}")
