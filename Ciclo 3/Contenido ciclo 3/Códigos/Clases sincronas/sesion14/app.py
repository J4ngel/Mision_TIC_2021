from flask import Flask,render_template,request, session
from markupsafe import escape
import os
import sqlite3
from sqlite3 import Error
from flask.helpers import flash
from flask_wtf import form
from formularios import formEstudiante
from formularios import formLogin
#librerias hash
import hashlib
from werkzeug.security import check_password_hash, generate_password_hash

app=Flask(__name__)
app.secret_key=os.urandom(24)

@app.route('/',methods=['GET','POST'])
def home():
    form = formEstudiante()
    return render_template('estudiantes.html',form=form)
#Guardar en la Bd
@app.route("/estudiante/save",methods=['POST'])
def estudiante_save():
    if 'usuario' in session:
        form = formEstudiante()
        if request.method == 'POST':
            documento = form.documento.data
            nombre =form.nombre.data
            sexo = form.sexo.data
            ciclo= form.ciclo.data
            estado= form.estado.data

            try:
                with sqlite3.connect('/home/carlosortega/Documentos/ciclo 3/Desarrollo de software/flask/sesion12/estudiantes.db') as con:
                    cur = con.cursor()#manipula la conexion
                    cur.execute("INSERT INTO Estudiantes (documento,nombre,sexo,ciclo,estado) VALUES (?,?,?,?,?)",(documento,nombre,sexo,ciclo,estado))
                    con.commit()#confirmar los datos enviados o actualiza los cambios en la bd
                    return "Guardado con exito"
            except Error:
                print(Error)
        return "No se puede guardar"
    else:
        flash('Accion no permitida')
        return render_template('error.html')
#Consultar en la Bd
@app.route("/estudiantes/get",methods=['GET','POST'])
def estudiante_get():
    if 'usuario' in session:
        form=formEstudiante()
        if request.method == 'POST':
            documento = form.documento.data
            try:
                with sqlite3.connect('/home/carlosortega/Documentos/ciclo 3/Desarrollo de software/flask/sesion12/estudiantes.db') as con:
                    con.row_factory =sqlite3.Row #convierte la respuesta de la Bd en un diccionario
                    cur = con.cursor()
                    cur.execute("SELECT * FROM Estudiantes WHERE documento=?",[documento])
                    row =cur.fetchone() # me devuelve una fila de la busqueda
                    if row is None:
                        flash("Estudiante no se encuentra en la Bd")
                    return render_template('vista_estudiante.html',row=row)
            except Error:
                print(Error)
        return "Error no entro por post"
    else:
        flash('Accion no permitida')
        return render_template('error.html')
@app.route("/estudiante/list",methods=["GET","POST"])
def estudiante_list():
    if 'usuario' in session:
        try:
            with sqlite3.connect('/home/carlosortega/Documentos/ciclo 3/Desarrollo de software/flask/sesion12/estudiantes.db') as con:
                con.row_factory =sqlite3.Row #convierte la respuesta de la Bd en un diccionario
                cur = con.cursor()
                cur.execute("SELECT * FROM Estudiantes")
                row = cur.fetchall()
                if row is None:
                    flash("Estudiante no se encuentra en la Bd")
                return render_template("lista_estudiante.html",row=row)
        except Error:
            print(Error)
    else:
        flash('Accion no permitida')
        return render_template('error.html')

@app.route("/estudiante/update",methods=["POST"])
def estudiante_update():
    if 'usuario' in session:
        form = formEstudiante()
        if request.method == 'POST':
            documento = form.documento.data
            nombre =form.nombre.data
            sexo = form.sexo.data
            ciclo= form.ciclo.data
            estado= form.estado.data

            try:
                with sqlite3.connect('/home/carlosortega/Documentos/ciclo 3/Desarrollo de software/flask/sesion12/estudiantes.db') as con:
                    cur = con.cursor()#manipula la conexion
                    cur.execute("UPDATE Estudiantes SET nombre=?, ciclo=?,sexo=?,estado=? WHERE documento=?",[nombre,ciclo,sexo,estado,documento])
                    con.commit()
                    if con.total_changes > 0:
                        mensaje="EStudiante modificado"
                    else:
                        mensaje="EStudiante no se pudo modificar"
            except Error:
                print(Error)
            finally:
                return mensaje
    else:
        flash('Accion no permitida')
        return render_template('error.html')


@app.route("/estudiante/delete",methods=["GET","POST"])
def estudiante_delete():
    if 'usuario' in session:
        form = formEstudiante()
        documento= form.documento.data
        try:
            with sqlite3.connect('/home/carlosortega/Documentos/ciclo 3/Desarrollo de software/flask/sesion12/estudiantes.db') as con:
                cur = con.cursor()#manipula la conexion
                cur.execute("DELETE FROM Estudiantes WHERE documento=?",[documento])
                con.commit()
                if con.total_changes > 0:
                    mensaje="Estudiante eliminado"
                else:
                    mensaje="Estudiante no eliminado"
        except Error:
            print(Error)
        finally:
            return mensaje
    else:
        flash('Accion no permitida')
        return render_template('error.html')
#-----------------------------------------****------------------------------------------
#inyeccion sql
# @app.route("/login",methods=["GET","POST"])
# def login():
#     form=formLogin()
#     if request.method == "GET":
#         return render_template("login.html",form=form)

#     if request.method=="POST":
#         user = form.usuario.data
#         password= form.clave.data
#         try:
#             with sqlite3.connect('/home/carlosortega/Documentos/ciclo 3/Desarrollo de software/flask/sesion12/estudiantes.db') as con:
#                 cur = con.cursor()#manipula la conexion
#                 #cur.execute("SELECT * FROM usuarios WHERE usuario='"+user+"'AND clave='"+password+"' ")
#                 cur.execute("SELECT * FROM usuarios WHERE usuario=? AND clave=?",[user,password])
#                 if cur.fetchone():
#                     return "usuario logueado"
#                 return "Usuario no permitido"
#         except Error:
#             print(Error)

#------------------------------inyecciones con scripts----------------------------------
@app.route('/inyeccion_xss',methods=['GET','POST'])
def inye():
    form=formLogin()

    if request.method == 'GET':
        return render_template('xss.html',form=form)

    if request.method == 'POST':
        usuario= escape(form.usuario.data)#proteger campo de scripts
        return usuario

#----------------------------------uso de la funcion hash------------------------------
@app.route('/login',methods=['GET','POST'])
def login():
    form=formLogin()
    if request.method == 'GET':
        return render_template('login.html',form=form)

@app.route('/login/save',methods=['POST'])
def encriptar():
    form=formLogin()
    if request.method == 'POST':
        usuario=escape(form.usuario.data)
        clave=escape(form.clave.data)
        hash_clave=generate_password_hash(clave) #la clave que recibimos la estamos pasando a PBKDF2
        try:
            with sqlite3.connect('/home/carlosortega/Documentos/ciclo 3/Desarrollo de software/flask/sesion12/estudiantes.db') as con:
                cur = con.cursor()
                cur.execute("INSERT INTO usuarios(usuario,clave) VALUES (?,?)",(usuario,hash_clave))
                con.commit()#confirmar los datos enviados o actualiza los cambios en la bd
                return "Guardado con exito"
        except Error:
            print(Error)
    return "No has ingresado por POST"
#creamos otra ruta para consultar clave hash generada
@app.route('/login/get',methods=['POST'])
def consultarLogin():
    form=formLogin()
    if request.method == 'POST':
        usuario= escape(form.usuario.data)
        clave= escape(form.clave.data)
        try:
            with sqlite3.connect('/home/carlosortega/Documentos/ciclo 3/Desarrollo de software/flask/sesion12/estudiantes.db') as con:
                cur = con.cursor()#manipula la conexion
                consulta=cur.execute("SELECT clave FROM usuarios WHERE usuario=?",[usuario]).fetchone() #a la variable consulta le asigna el registro o coincidencia del registro encontrado (1 solo campo que es clave)
                if consulta != None:
                    clave_hash= consulta[0]
                    
                    if check_password_hash(clave_hash,clave):
                        #crear la varible sesion
                        session['usuario']=usuario
                        form=formEstudiante()
                        flash(f"Ingreso del usuario {usuario}")
                        return render_template('estudiantes.html',form=form)
                        #return "Usuario logueado"
                    else:
                        return "Contraseña incorrecta"
                else:
                    return "El usuario no existe"
        except Error:
            print(Error)
#---------------------------metodo de autenticacion de sesiones------------------------
#las sesiones de encriptan



if __name__=='__main__':
    app.run(debug=True,port=8000)