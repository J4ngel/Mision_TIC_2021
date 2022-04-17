from flask import Flask
from flask import request

app = Flask(__name__)

@app.route('/')
def index():
    return '<h1>Hola a todos</h1>'

@app.route('/pmts/')
@app.route('/pmts/<Nombre>')
#@app.route('/pmts/<Nombre>/<Apellido>')

#Estructura:
    #/pmts/Nombre/
    #/pmts/Nombre/Apellido
#Ejemplo:
    #/pmts/Daniela/
    #/pmts/Daniela/Paez

def parametros(Nombre='No tiene nombre',Apellido='No tiene apellido'):
    return 'Su nombre es: {} {}'.format(Nombre, Apellido)

@app.route('/def_tipo_dato/<string:Nombre>/<int:Edad>') #De esta forma se definen previamente que tipo de datos se debe poner en la URL si se pone un dato erroneo muestra una pagina de NOT FOUND
def tipo_dato(Nombre='No tiene nombre',Edad='No tiene edad'):
    return 'Su nombre es {} y tiene {} años'.format(Nombre, Edad)

if __name__ == '__main__':
    app.run(debug=True, port=8000) #Se le agrega el atrubuto debug a true y se cambia el puerto al 8000
