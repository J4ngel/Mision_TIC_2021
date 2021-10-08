def ej1():
    #Calcular todos los número pares desde el 2 hasta n y termine el proceso si llega al final o a 10

    n = int(input("\nDigite un número: "))
    i = 2
    while i <= 10 and i <= n:
        print(i)
        i += 2 

def ej2():
    num = int(input("\nDigite un número: "))
    c = 0
    while True:
        if num == 0:
            break
        elif num%10 != 4:
            c +=1
        num //=10
    print(f"El número tiene {c} digitos sin contar los '4'")

def ej3():
    #Dado el valor de E^x se puede calcular por aproximación de la siguiente suma:
    # E = 1 +x + x^2/2! + x^3/3!+......+x^n/(n!)
    #tome un valor para x y calcule E^x hasta que x^n/n! (error o aproximación) sea menor a 0.00001
    x = int(input("Digite un valor: "))
    e = 1.0
    num = 1
    den = 1 
    i = 1
    num = x**i
    den *= i
    i += 1
    e += (num/den)

    while not (num/den < 0.00001):
        num = x**i
        den *= i
        i +=1
        e += (num/den)
    print(f"e elevado a {x} es {e}")

def ej4():   
    #Crear un algoritmo que indique si un número es cubo perfecto (amstrong) o no
    #Cubo perfecto si al sumar los cubos de sus digitos dan el mismo número
    # ej: 153, 1^3 + 5^3 + 3^3 = 1+125+27 = 153 
    # Ojo solo para 3 digitos
    num = int(input("\nDigite un número: "))
    k = num
    cubo = 0
    while num != 0:
        digito = num%10
        num //=10
        cubo +=(digito**3)
    
    if cubo == k:
        print(f"{k} es un cubo perfecto")
    else:
        print(f"{k} NO es un cubo perfecto") 

def ej5():
    #Dado un número, determine si un número primo, recuerde que un número primo es aquel que solo es 
    #divisible por 1 y por sí mismo.
    num = int(input("\nDigite un numero: "))
    i = 1
    c = 0
    while i <= num and c <= 2:
        if num%i == 0:
            c += 1
        i += 1
    if c == 2:
        print(f"{num} es un número primo")
    else:
        print(f"{num} NO es un numero primo")

def ej6():
    num = int(input("\nDigite un número: "))
    i = 1
    print(f"\nLas tablas de multiplicar del {num} comenzando en 1 hasta 10 son:")
    while i <= 10:
        print(f"{num} x {i} = {num*i}")
        i += 1


#Principal
#ej1()
#ej2()
#ej3()

#ej4()
#ej5()
ej6()