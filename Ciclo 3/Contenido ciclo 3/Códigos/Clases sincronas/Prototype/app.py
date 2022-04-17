from flask import Flask,render_template,request, session, redirect
from markupsafe import escape
import os
import sqlite3
from sqlite3 import Error
#librerias hash
import hashlib
from werkzeug.security import check_password_hash, generate_password_hash

app=Flask(__name__)
app.secret_key=os.urandom(24)

@app.route('/',methods=['GET','POST'])
def login():
    if request.method == 'POST':
        user = escape(request.form['username'])
        password = escape(request.form['password'])
        
        try:
            with sqlite3.connect("Prototype\DB_prototype.db") as con:
                cur = con.cursor()
                query=cur.execute("SELECT Contraseña FROM Usuarios WHERE Nombre_usuario=?",[user]).fetchone()
                if query!=None:
                    if check_password_hash(query[0],password):
                        session['user']=user
                        return redirect("/home") #Redireccionar a otra ruta
                        #return rendert_template("home.html") #Renderiza la vista pero no te cambia la ruta
                    else:
                        return "Credenciales incorrectas"
                else:
                    return "El usuario NO existe"
        except Error:
            print(Error)

    if 'user' in session:
        return redirect('/home')
    else:
        return render_template('index.html')

@app.route('/register',methods=['GET','POST'])
def register():
    if request.method == 'POST':
        email = escape(request.form['email'])
        name = escape(request.form['name'])
        user = escape(request.form['username'])
        pass_1 = escape(request.form['pass1'])
        pass_2 = escape(request.form['pass2'])
        gen = escape(request.form['gen'])

        if pass_1 != pass_2:
            return "Las contraseñas no coinciden"
        else:
            hash_clave=generate_password_hash(pass_1)
            try:
                with sqlite3.connect("Prototype\DB_prototype.db") as con:
                    cur = con.cursor()
                    """ existe=cur.execute("SELECT Nombre_usuario FROM Usuarios WHERE Nombre_usuario=?",(user))
                    con.commit()
                    if existe[0]!=None:
                        return "El Usuario ya existe, por favor intente de nuevo"
                    else:
                        cur.execute("INSERT INTO Usuarios(Nombre_usuario,Contraseña,Nombre,Email,Genero) VALUES (?,?,?,?,?)",(user,hash_clave,name,email,gen))
                        con.commit()
                        return "Guardado con exito" """
                    
                    cur.execute("INSERT INTO Usuarios(Nombre_usuario,Contraseña,Nombre,Email,Genero) VALUES (?,?,?,?,?)",(user,hash_clave,name,email,gen))
                    con.commit()
                    return "Guardado con exito" 
                
            except Error:
                print(Error)
                return "Registro no completado"

    return render_template('register.html')

@app.route('/home',methods=['GET'])
def home():
    if 'user' in session:
        try:
            with sqlite3.connect("Prototype\DB_prototype.db") as con:
                con.row_factory = sqlite3.Row
                cur = con.cursor()
                query=cur.execute("SELECT Nombre, Email, Genero FROM Usuarios WHERE Nombre_usuario=?",[session['user']]).fetchone()
                
                if query is None:
                    return("El usuario no existe")

        except Error:
            print(Error)
        
        return render_template('home.html',name=query[0],email=query[1],gen=query[2])
    else:
        return "<a href='/'>Por favor inicie sesión</a>"

@app.route('/logout',methods=['GET'])
def logout():
    if 'user' in session:
        session.clear()
        return redirect('/')
    else:
        return "<a href='/'>Inicie sesion</a>"
    

if __name__=='__main__':
    app.run(debug=True,port=8000)