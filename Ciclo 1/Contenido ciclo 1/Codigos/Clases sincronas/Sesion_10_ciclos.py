def Factorial(num):
    k = num
    if k < 0:
        num = -num

    factorial = 1
    for i in range(1,num+1):
        factorial *= i
    if k < 0:
        factorial = -factorial

    return factorial
def principal_factorial():
    """Las combinaciones o coeficientes binomiales son una serie de números que indican la cantidad de
     formas en que se pueden extraer subconjuntos a partir de un conjunto dado. Para calcular combinaciones 
     se debe utilizar la siguiente fórmula:
                                            C = n!/(m! x (n-m)!)"""
    
    c = nf = mf = nmf = 0

    n = int(input("Digite el termino n: "))
    m = int(input("Digite el termino m: "))

    nf = Factorial(n)
    mf = Factorial(m)
    nmf = Factorial(n-m)

    c = nf/(mf * nmf)

    print(f"""
     {n}!
----------- = {c}
{m}! x ({n}-{m})!""")
#principal_factorial()

#Sacar 10 numeros aleatorios entre 100 y 130 que no sean 110,115,120 y presentarlos intercalados entre par e impar
#comenzando por par
import random

def numAleatorio():
    num = 110
    while num == 110 or num == 115 or num == 120:
        num = random.randint(100,130)

    return num   

def numeros():
    i = 0
    print()
    while True:
        a = numAleatorio()
        
        if i == 10:
            break
        elif i%2 == 0 and a%2 == 0:
            print(f"Número aleatorio   par: {a}")
            i +=1
        elif i%2 != 0 and a%2 != 0:
            print(f"Número aleatorio impar: {a}")
            i +=1
#numeros()

#Solicitar al usuario que ingrese su dirección email. Imprimir un mensaje indicando si la dirección 
#es válida o no, valiéndose de una función para decidirlo. Una dirección se considerará válida si 
#contiene el símbolo "@".
def validacion_correo(correo):
    if "@" in correo:
        v = True
    else:
        v = False

    return v
def crear_correo():
    correo = input("Digite su correo electrónico: ")
    validacion = validacion_correo(correo)
    
    if validacion:
        print("Correo valido")
    else:
        print("Correo NO valido")
#crear_correo()

#Escribir una función que, dado un número de DNI, retorne True si el número es válido y False 
#si no lo es. Para que un número de DNI sea válido debe tener entre 7 y 8 dígitos.
def validacion_dni(dni):
    if dni > 999999 and dni < 100000000:
        v = True
    else:
        v = False
    return v

def creacion_dni(): 
    dni = int(input("Digite su DNI: "))
    validacion = validacion_dni(dni)
    if validacion:
        print("DNI Valido")
    else:
        print("DNI NO valido")
creacion_dni()
