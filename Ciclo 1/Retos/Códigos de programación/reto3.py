FORMATO = "{:.2f}"
def mostrar_info(matriz):
            # posicion, valor
    minimo = [0,matriz[0][-1]] 
    maximo = [0,matriz[0][-1]]

    for i in range(len(matriz)):
        if maximo[1] < matriz[i][-1]:
            maximo[1] = matriz[i][-1]
            maximo[0] = i

        elif minimo[1] > matriz[i][-1]:
            minimo[1] = matriz[i][-1]
            minimo[0] = i

    print(f"{minimo[0]+1} {minimo[1]}")        
    print(f"{maximo[0]+1} {maximo[1]}")

    porcentaje = 0
    for i in range(len(matriz)):
        porcentaje = (matriz[i][0]/matriz[i][1])*100
        porcentaje = FORMATO.format(porcentaje)
        print(f"{i+1} {porcentaje}%")
# ------------->Principal
sucursales = 0
pacientes  = 0
while sucursales < 1:
    sucursales, pacientes = map(int,input().split())

matriz = [[0 for j in range(3)] for i in range(sucursales)]  # [Dosis entregadas, Existencias iniciales, existencias finales] x sucursales

for i in matriz:
    while i[-2] < 1:
        i[-2] = int(input())
        i[-1] = i[-2]

for i in range(pacientes):
    ubicacion, p_s, p_d = map(int,input().split())
    if ubicacion <= sucursales and ubicacion > 0:
        if p_s < 72 and p_d <65:
            matriz[ubicacion-1][-1] -= 4
            matriz[ubicacion-1][0]  += 4
        elif p_s >=124 and p_s <138 and p_d>=81 and p_d<93:
            matriz[ubicacion-1][-1] -= 2
            matriz[ubicacion-1][0]  += 2
        elif p_s>=138 and p_s<156 and p_d>=93 and p_d<102:
            matriz[ubicacion-1][-1] -= 4
            matriz[ubicacion-1][0]  += 4
        elif p_s>=156 and p_s<175 and p_d>=102 and p_d<114:
            matriz[ubicacion-1][-1] -= 8
            matriz[ubicacion-1][0]  += 8
        elif p_s>=175 and p_d>=114:
            matriz[ubicacion-1][-1] -= 16
            matriz[ubicacion-1][0]  += 16
        elif p_s>=136 and p_d<92:
            matriz[ubicacion-1][-1] -= 12
            matriz[ubicacion-1][0]  += 12

mostrar_info(matriz)