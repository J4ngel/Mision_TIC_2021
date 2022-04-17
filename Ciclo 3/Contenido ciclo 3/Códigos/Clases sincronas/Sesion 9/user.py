from flask import Flask
from flask import render_template

#app = Flask(__name__, template_folder='nombre de la carpeta') de esta forma en el segundo argumento ponemos el nombre de la carpeta donde se encuentran nuestros templates llegado el caso tenga un nombre distinto al por defecto
app = Flask(__name__) #De esta forma busca los templates en la carpeta llamada templates

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/user/')
@app.route('/user/<int:age>')
def usuario(age=-1):
    #la variable nombre se le pasa al html, esta variable se debe llamar igual en el otro archivo
    #en HTML para hacer referencia a un valor mandado por python se debe poner entre llames dobles {{}} el nombre de la variable como se envió desde al archivo .py
    name = "Daniela"
    lista = [1,2,3,4]
    return render_template('user.html', nombre=name, edad=age, lst=lista)


if __name__ == '__main__':
    app.run(debug=True, port=8000) #Se le agrega el atrubuto debug a true y se cambia el puerto al 8000
