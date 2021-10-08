# Entradas:
# lista con valores: Si va a reservar o a comprar, Destino, Precio

# Proceso
# lista transacciones del día con un conteo de reservas, compras y valor total de pagos
# Ciclo mientras para saber si desea agregar un cliente mas o desea salir
# Toma de datos del cliente
# Agregar los valores de precio a la variable transacciones del día
# preguntar si deséa salir 
# Mostrar la variable transacciones con la cantidad de reservas de
# la cantidad de compras
# y el valor de la suma de todas las transacciones

reserva  = False
destino  = ""
fecha    = ""
pago     = ""

T_totales = [0,0,0]     # Total[Reservas, compras, pagos]
salir = False

while not salir:
    print("Bienvenido")
    print("\nSi no desea reservar su desición será compra")
    reserva  = input("¿Desea reservar? (S/N): ")

    if reserva == "S" or reserva == "s": 
        reserva = True
    else:  
        reserva = False

    destino  = input("Digite su destino: ")
    fecha    = input("Digite la fecha: ")
    pago     = int(input("Digite el pago: $"))

    if reserva:
        T_totales[0] += 1
    else:   
        T_totales[1] += 1

    T_totales[2] += pago

    print("Cliente registrado con exito!")

    r = input("¿Desea salir? (S/N): ")
    
    if r == "S" or r == "s":
        salir = True

print(f"\nCantidad total de reservas: {T_totales[0]}"
      f"\n Cantidad total de compras: {T_totales[1]}"
      f"\nValor total de transacciones: ${T_totales[2]}")