from flask import Flask
from flask import render_template

#app = Flask(__name__, template_folder='nombre de la carpeta') de esta forma en el segundo argumento ponemos el nombre de la carpeta donde se encuentran nuestros templates llegado el caso tenga un nombre distinto al por defecto
app = Flask(__name__) #De esta forma busca los templates en la carpeta llamada templates

@app.route('/')
@app.route('/saluda/')
@app.route('/saluda/<name>')
def index(name=None):
    return render_template('index_base.html', nombre=name)

#Estructura
#projects
    #templates (carpeta)
        #base (carpeta)
            #archivos base
        #archivos html que son hijos
    #Static (carpeta)
        #css (carpeta)
            #archivos css
        #img (carpeta)
            #imagenes a usar
        #js (carpeta)
            #archivos js
    #main.py

if __name__ == '__main__':
    app.run(debug=True, port=8000) #Se le agrega el atrubuto debug a true y se cambia el puerto al 8000
