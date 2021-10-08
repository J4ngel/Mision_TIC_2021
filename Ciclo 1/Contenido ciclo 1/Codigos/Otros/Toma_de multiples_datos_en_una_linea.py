ubicacion, p_s, p_d = map(float,input().split("-"))   #Trabaja con posiciones variable por dato
print(f"ubicacion: {ubicacion}, presion: {p_s}, presion 2: {p_d}")

x = input()
y = x.split(",")   #Trabaja como lista argumento de split es el caracter que divide
u = int(y[0])
ps = int(y[1])
pb = int(y[2])
print(y)
print(f"\nEsto es u: {u}, esto es ps {ps}, esto es pb {pb}")