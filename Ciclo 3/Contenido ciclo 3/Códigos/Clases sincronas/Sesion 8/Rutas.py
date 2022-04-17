from flask import Flask
from flask import request

app = Flask(__name__)

@app.route('/')
def index():
    return '<h1>Hola a todos</h1>'

@app.route('/saludar')
def bienvenida():
    return '<h2>Estamos en la sesión 8</h2>'

@app.route('/saludar/otra_ruta')
def Actividad():
    return '<h3>configurando flask</h3>'


@app.route('/pmts')
#/pmts?para1=MisionTIC
#/pmts?para1=MisionTIC&para2=2021
def parametros():
    param1 = request.args.get('para1','No contiene parametro 1')
    param2 = request.args.get('para2','No contiene parametro 2')

    #return 'El parametro es: {}'.format(param1)
    return 'Los parametros son: {} y {}'.format(param1, param2)

if __name__ == '__main__':
    app.run(debug=True, port=8000) #Se le agrega el atrubuto debug a true y se cambia el puerto al 8000
