import random
import os

def iniciar_matriz():
    matriz = [[0 for j in range(3)]for i in range(3)]
    valor = 1
    for i in range(3):
        for j in range(3):
            matriz[i][j] = valor
            valor +=1
    return matriz

# la función acepta un parámetro el cual contiene el estado actual del tablero
# y lo muestra en la consola
def dibujar_tablero(t, j2):
    j = ["Jugador 1: 'X'","Jugador 2: 'O'","+--------------------+--------------------+","|                    |                    |"]
    if j2 == 1:
        j[0] = "CPU: 'X'"
        j[1] = "Jugador: 'O'"
        j[2] = "+--------------+------------------+"
        j[3] = "|              |                  |"

    os.system("cls")
    print("\n\n")
    print(f"        +-------+-------+-------+     {j[2]}"
        f"\n        |       |       |       |     {j[3]}"
        f"\n        |   {t[0][0]}   |   {t[0][1]}   |   {t[0][2]}   |     |   {j[0]}   |   {j[1]}   |"
        f"\n        |       |       |       |     {j[3]}"
        f"\n        +-------+-------+-------+     {j[2]}"
        "\n        |       |       |       |"
        f"\n        |   {t[1][0]}   |   {t[1][1]}   |   {t[1][2]}   |"
        "\n        |       |       |       |"
        "\n        +-------+-------+-------+"
        "\n        |       |       |       |"
        f"\n        |   {t[2][0]}   |   {t[2][1]}   |   {t[2][2]}   |"
        "\n        |       |       |       |"
        "\n        +-------+-------+-------+")

# la función acepta el estado actual del tablero y pregunta al usuario acerca de su movimiento, 
# verifica la entrada y actualiza el tablero acorde a la decisión del usuario
def mov_jugador1(t, j2):
    m_valido = False
    while not m_valido:
        if j2 == 1:
            mov = int(input("        Ingresa tu movimiento: "))
        else:
            mov = int(input("        Ingresa tu movimiento jugador 2: "))

        for i in range(3):
            for j in range(3):
                if mov == t[i][j]:
                    t[i][j] = "O"
                    m_valido = True
                    break
                else:
                    m_valido = False
            if m_valido: break
        if not m_valido: print("        Error, digite una posición válida")
    dibujar_tablero(t,j2)
    
# la función examina el tablero y construye una lista de todos los cuadros vacíos 
# la lista esta compuesta por tuplas, cada tupla es un par de números que indican la fila y columna
def lista_de_campos_vacios(t):
    lista = []
    for i in range(3):
        for j in range(3):
            if t[i][j] != 'O' and t[i][j] != 'X':
                lista.append((i,j))
    return lista

# la función analiza el estatus del tablero para verificar si
# el jugador que utiliza las 'O's o las 'X's ha ganado el juego
def victoriapara(t, signo): 
    victoria = False 
    continua  = False
    diagonal = 0
    
    if t[0][2] == t[1][1] and t[0][2] == t[2][0]:
        victoria = True

    while not victoria and not continua:
        for i in range(3):
            columnas = 0

            if t[i].count(signo) == 3:
                victoria = True
            elif t[i][i] == signo:
                diagonal += 1

            if diagonal == 3:   victoria = True
            

            for j in range(3):
                if t[j][i] == signo:
                    columnas +=1
            if columnas == 3:   victoria = True

        if not victoria:
            continua = True

    return victoria

# la función dibuja el movimiento de la maquina y actualiza el tablero
def mov_maquina(t, j2):
    if j2 == 1: 
        mov_disponibles = lista_de_campos_vacios(t)
        mov = random.choice(mov_disponibles)
        t[mov[0]][mov[1]] = 'X'

    else:
        m_valido = False
        while not m_valido:
            mov = int(input("        Ingresa tu movimiento jugador 1: "))
        
            for i in range(3):
                for j in range(3):
                    if mov == t[i][j]:
                        t[i][j] = "X"
                        m_valido = True
                        break
                    else:
                        m_valido = False
                if m_valido: break
            if not m_valido: print("        Error, digite una posición válida")
    
    dibujar_tablero(t,j2)

def menu():
    opcion = 0
    while opcion > 2 or opcion <1:
        os.system("cls")
        print("\n\n"
        "        *----------------------------------*"
        "\n        |+--------------------------------+|"
        "\n        ||                                ||"
        "\n        ||        JUGUEMOS TRIQUI :D      ||"
        "\n        ||                                ||"
        "\n        |+--------------------------------+|"
        "\n        ||                                ||"
        "\n        ||   1> vs CPU       2> PvP       ||"
        "\n        ||                                ||"
        "\n        |+--------------------------------+|"
        "\n        *----------------------------------*")
        opcion = int(input("        Digite una opción del menú: "))

        if opcion > 2 or opcion <1:
            input("\n        Error, digite una opción valida del menú!!"
                    "\n        Presione enter para continuar...")
    return opcion

j2 = menu()
tablero = iniciar_matriz()
if j2 == 1:
    tablero[1][1] = 'X'     # Movimiento inicial de la maquina
else:
    dibujar_tablero(tablero,j2)
    mov_maquina(tablero,j2)

dibujar_tablero(tablero,j2)

while len(lista_de_campos_vacios(tablero)):
    mov_jugador1(tablero,j2)
    if victoriapara(tablero,"O"):
        if j2 == 1: print("        Ganaste :D !!")
        else:       print("        Ganó el jugador 2!!!")
        break
    mov_maquina(tablero, j2)
    if victoriapara(tablero,"X"):
        if j2 == 1: print("        Ganó la CPU!!!")
        else:       print("        Ganó el jugador 1!!!")
        break
if len(lista_de_campos_vacios(tablero)) == 0 and not victoriapara(tablero,"X") and not victoriapara(tablero,"O"):
    print("        Empate !!!")
input("\nPresione enter para salir...")
