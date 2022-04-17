from flask import Flask
from flask import render_template, abort

app = Flask(__name__) 
@app.route('/')
@app.route('/saluda/')
@app.route('/saluda/<name>')
def index(name=None):
    return render_template('plantilla_1.html', nombre=name)

@app.route('/suma/<n1>/<n2>')
def sumar(n1,n2):
    try:
        resultado = int(n1)+int(n2)
    except:
        abort(404)

    return render_template('plantilla_2.html',n1=n1,n2=n2, resultado=resultado)

@app.errorhandler(404)
def page_not_found(error):
    return render_template('error.html',error="Pagina NO encontrada..."),404

if __name__ == '__main__':
    app.run(debug=True, port=8000)
