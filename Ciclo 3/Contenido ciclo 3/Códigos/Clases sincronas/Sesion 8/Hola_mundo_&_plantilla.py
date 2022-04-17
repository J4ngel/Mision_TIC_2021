""" from flask import Flask
app = Flask(__name__)
@app.route('/')
def index():
    return '<h1>Hola mundo</h1>'
app.run()
 """
 
#Plantilla a usar
from flask import Flask
app = Flask(__name__)
@app.route('/')
def index():
    return '<h1>Hola mundo</h1>'

if __name__ == '__main__':
    app.run(debug=True, port=8000) #Se le agrega el atrubuto debug a true y se cambia el puerto al 8000