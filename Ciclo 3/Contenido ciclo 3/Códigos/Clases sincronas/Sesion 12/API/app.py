from flask import Flask, json, jsonify, request
from articulos import articulos

app = Flask(__name__)

@app.route('/')
def datos():
    return jsonify({"Mensaje":"Buenos dias"})

@app.route('/art')
def get_art():      #La función va a ser para mostrar los json
    return jsonify({"Mensaje":"Listado de articulos","articulos":articulos})

@app.route('/art/<string:nom_art>')
def get_art_unico(nom_art):      #La función va a buscar entre los articulos y va a presentar el encontrado
    #Forma clasica
    """ art_existentes = []
    for art in articulos:
        if art["Nombre"] == nom_art:
            art_existentes.append(art) """ 
    
    #Lista comprimida
    art_existentes = [art for art in articulos if art['Nombre']== nom_art]

    if len(art_existentes) == 0:
        art_existentes.append("No se encontro articulo")

    return jsonify({"Mensaje":"Busqueda de articulo","articulos":art_existentes})

@app.route('/art', methods=['POST'])
def add_art():      # Crear un nuevo articulo
    new_art = {"Nombre":request.json["Nombre"],
               "Precio":request.json["Precio"],
               "Cantidad":request.json["Cantidad"]}
    articulos.append(new_art)
    return jsonify({"Mensaje":"Producto agregado","articulos":articulos})

@app.route('/art/<string:nom_art>', methods=['PUT'])
def update_art(nom_art):      #La función va a actualizar un articulo ya existente
    art_existentes = [art for art in articulos if art['Nombre']== nom_art]

    if len(art_existentes) == 0:
        return jsonify({"Mensaje":"Busqueda de articulo NO encontrado"})
    else:
        art_existentes[0]["Nombre"] = request.json["Nombre"]
        art_existentes[0]["Precio"] = request.json["Precio"]
        art_existentes[0]["Cantidad"] = request.json["Cantidad"]
        return jsonify({"Mensaje":"Articulo actualizado", "Articulo":art_existentes})

@app.route('/art/<string:nom_art>', methods=['DELETE'])
def delete_art(nom_art):      #La función va a eliminar un articulo
    art_existentes = [art for art in articulos if art['Nombre']== nom_art]

    if len(art_existentes) == 0:
        return jsonify({"Mensaje":"Busqueda de articulo NO encontrado"})
    else:
        articulos.remove(art_existentes[0])
        return jsonify({"Mensaje":"Articulo eliminado", "Articulos":articulos})    

if (__name__) == '__main__':
    app.run(debug=True, port=8000)