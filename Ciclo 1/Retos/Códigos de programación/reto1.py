a = float(input("Digite el valor de la presión sistólica: "))
b = float(input("Digite el valor de la presión diastólica: "))

if a<72 and b <65:
	print("Hipotension Alerta Amarilla")
elif a>=72 and a<107 and b>=65 and b<73:
	print("Optima Alerta Verde")
elif a>=107 and a<124 and b>=73 and b<81:
	print("Normal Alerta Verde")
elif a>=124 and a<138 and b>=81 and b<93:
	print("1ipertension Alerta Amarilla")
elif a>=138 and a<156 and b>=93 and b<102:
	print("HTA Grado 1 Alerta Naranja")
elif a>=156 and a<175 and b>=102 and b<114:
	print("HTA Grado 2 Alerta Roja")
elif a>=175 and b>=114:
	print("HTA Grado 3 Alerta Roja")
elif a>=136 and b<92:
	print("Hipertension Sistolica Aislada Alerta Naranja")
else:
	print("No se puede determinar la categoria Alerta Gris")
