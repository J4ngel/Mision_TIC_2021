def ej1():
    # Ingresar un numero de 1 a 7 para saber que día es (1 = Lunes, 7 = Viernes)
    dia = int(input("\nIngrese el día: "))

    if dia == 1:
        print("El día es Lunes")
    elif dia == 2:
        print("El día es Martes")
    elif dia == 3:
        print("El día es Miercoles")
    elif dia == 4:
        print("El día es Jueves")
    elif dia == 5:
        print("El día es viernes")
    elif dia == 6:
        print("El día es Sabado")
    elif dia == 7:
        print("El día es Domingo")
    else:
        print("Error, intente nuevamente")
    
def ej2():
    # Ingresar la temperatura e imprimir en pantalla la sensacion termica
    temp = float(input("\nIngrese la temperatura (°C): "))
    # Condicional anidado
    if temp < 10:
        print("Mucho frío")
    else:
        if temp < 15:
            print("Poco frío")
        else:
            if temp < 25:
                print("Temperatura normal")
            else:
                if temp < 30:
                    print("Poco calor")
                else:
                    print("Mucho calor")
    # Condicional multiple
    if temp < 10 and temp >= -10:
        print("\nMucho frío")
    elif temp >= 10 and temp < 15:
        print("\nPoco frío")
    elif temp >= 15 and temp < 25:
        print("\nTemperatura normal")
    elif temp >= 25 and temp < 30:
        print("\nPoco calor")
    elif temp >= 30 and temp < 45:
        print("\nMucho calor")

    else:
        print(f"\nLa temperatura de {temp}°C no es apta para el ser humano") 

def ej3(): 
    '''Diseñe un algoritmo que lea un número entero de 3 cifras, y 
    forme el mayor número posible con las cifras del número ingresado. 
    El número formado debe tener el mismo signo que el número ingresado.'''
    num = int(input("\nDigite un número de 3 cifras: "))
    
    if (num < 100 or num >999) and (num < -999 or num > -100):
        print("Error, el número digitado no es de tres (3) cifras")
    else:
        k = num
        if num<0:
            num = -num
        c=num//100
        d=(num%100)//10
        u=(num%100)%10

        if c > d and c > u:
            max = c
            if d > u:
                med = d
                min =u
            elif d < u:
                med = u
                min = d
            else:
                min = med = u

        elif d > c and d > u:
            max = d
            if c > u:
                med = c
                min =u
            elif c < u:
                med = u
                min = c
            else:
                min = med = u

        elif u > d and u > c:
            max = u
            if c > d:
                med = c
                min =d
            elif c < d:
                med = d
                min = c
            else:
                min = med = d

        elif c == d and c != u:
            if c > u:
                max = med = c
                min = u
            else:
                max = u
                med = min = c

        elif c == u and c != d:
            if c > d:
                max = med = c
                min = d
            else:
                max = d
                med = min = c

        elif d == u and d != c:
            if d > c:
                max = med = d
                min = c
            else:
                max = c
                med = min = d

        else:
            max = med = min = u
        
        if k < 0:
            num = -1*(min*100+med*10+max)
            print(num)
        else:
            num = max*100+med*10+min
            print(num)

def ej4():
    #Calcular la utilidad que un trabajador recibe en el reparto anual de utilidades si éste se le asigna como un porcentaje de su salario mensual, que depende de su antigüedad en la empresa, de acuerdo con lo siguiente: 
    #							Tiempo		     	   Utilidad
    #			Menos de 1 año		 		        5% del salario
    #			1 año o más y menos de 2 años		7% del salario
    #			2 años o más y menos de 5 años		10% del salario
    #			5 años o más y menos de 10 años		15% del salario
    #			10 años o más				        20% del salario
    salario = float(input("\nSalario: $"))
    antig = int(input("Antiguedad(meses): $"))

    if antig < 12:
        utilidad = salario * 0.05
    elif antig >= 12 and antig <24:
        utilidad =salario * 0.07
    elif antig >=24 and antig <60:
        utilidad = salario * 0.1
    elif antig >= 60 and antig < 120:
        utilidad = salario * 0.15
    else:
        utilidad = salario*0.2
    print("Utilidad:",utilidad)

# Principal
#ej1()
#ej2()
#ej3()
ej4()