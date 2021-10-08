def Nota_final():
    c1=float(input("Digite la nota del primer corte: "))
    c2=float(input("Digite la nota del segundo corte: "))
    c3=float(input("Digite la nota del tercer corte: "))

    NC=0.3*(c1+c2)+0.4*c3

    print("La nota final es:",NC)

def Nota_faltante(a):
    a=float(a)
    c1=float(input("Digite la nota del primer corte: "))
    c2=float(input("Digite la nota del segundo corte: "))
    c3=round((a-0.3*(c1+c2))/0.4,2)

    print(f"La rota que necesita para sacar {a} como calificación final es: {c3}")

def menu():
    o=0
    while o!=1 and o!=2 and o!=3:
        print("Bienvenido, con este software podrá calcular su nota final")
        print("Corte 1 (30%), Corte 2 (30%), Corte 3 (40%)\n\n")
        print("-----------------------Menú-----------------------------------")
        print("1) Calcular la nota final")
        print("2) Calcular la nota que necesita en el ultimo corte para pasar")
        print("3) Salir")

        o=int(input("Digite la opcion que desea: "))
        
        if o != 1 and o!=2 and o!=3:
            print("Digite una opcion valida")
    return(o)
N = 1
while N==1:

    o=menu()
    if o==1:
        Nota_final()
    elif o==2:
        a=float(input("Digite el valor de nota aprobatoria: "))
        Nota_faltante(a)
    
    r=str(input("¿Desea salir? (Y/N): "))

    if r=='Y' or r=='y':
        N=0
        print("Gracias por usar nuestro software!")