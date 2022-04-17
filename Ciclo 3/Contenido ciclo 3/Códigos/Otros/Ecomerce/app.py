from flask import Flask , redirect , render_template, request, flash
from flask.helpers import url_for
from flask_sqlalchemy import SQLAlchemy
from flask_login import LoginManager , UserMixin , login_required ,login_user, logout_user,current_user
from werkzeug.security import generate_password_hash as genph
from werkzeug.security import check_password_hash as checkph


app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///database/ecomerce.db'


db = SQLAlchemy(app)
login_manager = LoginManager()
login_manager.init_app(app)

class Comentario(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    descripcion = db.Column(db.String(200))

class Calificacion(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    cuanto = db.Column(db.Integer)

class Deseo(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    nombre = db.Column(db.String(200))

class Producto(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    nombre = db.Column(db.String(200))
    precio = db.Column(db.String(200))
    caracteristicas = db.Column(db.String(500))

class Usuario(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    nombre = db.Column(db.String(200))
    apellido = db.Column(db.String(200))
    correo = db.Column(db.String(200))
    contrasena = db.Column(db.String(200))

    def __repr__(self):
        return '<Usuario {}>'.format(self.correo)

    def def_clave(self, clave):
        self.contrasena = genph(clave)
    
    def verif_clave(self, clave):
        return checkph(self.contrasena, clave)

class Admin(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    nombre = db.Column(db.String(200))
    apellido = db.Column(db.String(200))
    correo = db.Column(db.String(200))
    contrasena = db.Column(db.String(200))

    def __repr__(self):
        return '<Admin {}>'.format(self.correo)

    def def_clave_admin(self, clave):
        self.contrasena = genph(clave)
    
    def verif_clave_admin(self, clave):
        return checkph(self.contrasena, clave)

class Super(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    nombre = db.Column(db.String(200))
    apellido = db.Column(db.String(200))
    correo = db.Column(db.String(200))
    contrasena = db.Column(db.String(200))

    def __repr__(self):
        return '<Super {}>'.format(self.correo)

    def def_clave_super(self, clave):
        self.contrasena = genph(clave)
    
    def verif_clave_super(self, clave):
        return checkph(self.contrasena, clave)

@login_manager.user_loader
def get(id):
    return Usuario.query.get(id) or Super.query.get(id) or Admin.query.get(id)


@app.route('/',methods=['GET'])
def get_home():
    return render_template('index.html')
    
@app.route('/contacts',methods=['GET'])
def get_contactos():
    return render_template('contactos.html')

@app.route('/preguntas',methods=['GET'])
def get_preguntas():
    return render_template('p_Frecuentes.html')
    
@app.route('/singnup',methods=['GET'])
def get_singnup():
    return render_template('registro_Persona.html')
    
#logins
@app.route('/login',methods=['GET'])
def get_login():
    return render_template('logins/login_Persona.html')

@app.route('/loginAd',methods=['GET'])
def get_loginad():
    return render_template('logins/login_Persona_admin.html')

@app.route('/loginSu',methods=['GET'])
def get_loginsu():
    return render_template('logins/login_Persona_super.html')

#productos
@app.route('/productosIn',methods=['GET'])
def get_productosin():
    return render_template('productos/productos_invitado.html')

@app.route('/productslog',methods=['GET'])
@login_required
def get_prodlog():
    return render_template('productos/productos_login.html')

@app.route('/productsadmin',methods=['GET'])
@login_required
def get_prodadmin():
    return render_template('productos/productos_admin.html')

@app.route('/productssuper',methods=['GET'])
@login_required
def get_prodsuper():
    return render_template('productos/productos_super.html')

@app.route('/detalleproductolog',methods=['GET'])
@login_required
def get_detprodlog():
    calificaciones = Calificacion.query.all()
    comentarios = Comentario.query.all()
    return render_template('productos/detalle_Productos_login.html', comentarios = comentarios, calificaciones = calificaciones)

@app.route('/detalleproductoadmin',methods=['GET'])
@login_required
def get_detproddadmin():
    calificaciones = Calificacion.query.all()
    comentarios = Comentario.query.all()
    return render_template('productos/detalle_Productos_admin.html', comentarios = comentarios, calificaciones = calificaciones)

@app.route('/detalleproductosuper',methods=['GET'])
@login_required
def get_detprodsuper():
    calificaciones = Calificacion.query.all()
    comentarios = Comentario.query.all()
    return render_template('productos/detalle_Productos_super.html', comentarios = comentarios, calificaciones = calificaciones)

#menus
@app.route('/menuadmin',methods=['GET'])
@login_required
def get_menuadmin():
    return render_template('menus/menu_admin.html')

@app.route('/menusuper',methods=['GET'])
@login_required
def get_menusuper():
    return render_template('menus/menu_super.html')

@app.route('/menulogin',methods=['GET'])
@login_required
def get_menulogin():
    return render_template('menus/menu_login.html')

@app.route('/contactslog',methods=['GET'])
@login_required
def get_contactoslog():
    return render_template('menus/contactos_login.html')

@app.route('/contactssuper',methods=['GET'])
@login_required
def get_contactossuper():
    return render_template('menus/contactos_super.html')

@app.route('/preguntaslog',methods=['GET'])
@login_required
def get_preguntaslog():
    return render_template('menus/p_Frecuentes_login.html')

@app.route('/preguntassuper',methods=['GET'])
@login_required
def get_preguntassuper():
    return render_template('menus/p_Frecuentes_super.html')

@app.route('/lista_personas',methods=['GET'])
@login_required
def lista_personas():
    usuarios = Usuario.query.all()
    return render_template('gestor_Personas/listar_Persona.html', usuarios=usuarios)

@app.route('/agregar_persona',methods=['GET'])
@login_required
def agregar_persona():
    return render_template('gestor_Personas/agregar_Persona.html')

@app.route('/lista_personas_admin',methods=['GET'])
@login_required
def lista_personas_admin():
    usuarios = Usuario.query.all()
    return render_template('gestor_Personas/listar_Persona_admin.html', usuarios=usuarios)

@app.route('/agregar_persona_admin',methods=['GET'])
@login_required
def agregar_persona_admin():
    return render_template('gestor_Personas/agregar_Persona_admin.html')

@app.route('/lista_productos',methods=['GET'])
@login_required
def lista_productos():
    productos = Producto.query.all()
    return render_template('gestor_Productos/listar_Producto.html', productos=productos)

@app.route('/agregar_producto',methods=['GET'])
@login_required
def agregar_producto():
    return render_template('gestor_Productos/agregar_Producto.html')

@app.route('/lista_productos_admin',methods=['GET'])
@login_required
def lista_productos_admin():
    productos = Producto.query.all()
    return render_template('gestor_Productos/listar_Producto_admin.html', producto=productos)

@app.route('/agregar_producto_admin',methods=['GET'])
@login_required
def agregar_producto_admin():
    return render_template('gestor_Producto/agregar_Producto_admin.html')

#comentarios login
@app.route('/comentar')
@login_required
def comentar():
    comentarios = Comentario.query.all()
    return render_template('gestor_Comentarios/agregar_Comentario.html', comentarios = comentarios)

@app.route('/create_comentario', methods=['POST'])
@login_required
def create_comentario():
    new_comentario = Comentario(descripcion=request.form['descripcion'])
    db.session.add(new_comentario)
    db.session.commit()
    return redirect('detalleproductolog')

#calificar login
@app.route('/calificar')
@login_required
def calificar():
    calificaciones = Calificacion.query.all()
    return render_template('gestor_Calificaciones/agregar_Calificacion.html', calificaciones = calificaciones)

@app.route('/create_calificacion', methods=['POST'])
@login_required
def create_calificacion():
    new_calificacion = Calificacion(cuanto=request.form['cuanto'])
    db.session.add(new_calificacion)
    db.session.commit()
    return redirect('detalleproductolog')



'''
#desear login
@app.route('/desear')
def desear():
    deseos = Deseo.query.all()
    return render_template('gestor_Deseos/listar_Deseo.html', deseos = deseos)

@app.route('/create_deseo', methods=['POST'])
def create_deseo():
    new_deseo = Deseo(content=request.form['content'])
    db.session.add(new_deseo)
    db.session.commit()
    return redirect('detalleproductolog')
'''

#comentarios super
@app.route('/comentar_super')
def comentar_super():
    comentarios = Comentario.query.all()
    return render_template('gestor_Comentarios/agregar_Comentario_super.html', comentarios = comentarios)

@app.route('/create_comentario_super', methods=['POST'])
def create_comentario_super():
    new_comentario = Comentario(descripcion=request.form['descripcion'])
    db.session.add(new_comentario)
    db.session.commit()
    return redirect('detalleproductosuper')

@app.route('/delete_comentario/<id>')
def delete_comentario_super(id):
    Comentario.query.filter_by(id=int(id)).delete()
    db.session.commit()
    return redirect(url_for('get_detprodsuper'))

#calificar super
@app.route('/calificar_super')
@login_required
def calificar_super():
    calificaciones = Calificacion.query.all()
    return render_template('gestor_Calificaciones/agregar_Calificacion_super.html', calificaciones = calificaciones)

@app.route('/create_calificacion_super', methods=['POST'])
@login_required
def create_calificacion_super():
    new_calificacion = Calificacion(cuanto=request.form['cuanto'])
    db.session.add(new_calificacion)
    db.session.commit()
    return redirect('detalleproductosuper')

@app.route('/delete_calificacion_super/<id>')
def delete_calificacion_super(id):
    Calificacion.query.filter_by(id=int(id)).delete()
    db.session.commit()
    return redirect(url_for('get_detprodsuper'))

#comentarios admin
@app.route('/comentar_admin')
@login_required
def comentar_admin():
    comentarios = Comentario.query.all()
    return render_template('gestor_Comentarios/agregar_Comentario_admin.html', comentarios = comentarios)

@app.route('/create_comentario_admin', methods=['POST'])
@login_required
def create_comentario_admin():
    new_comentario = Comentario(descripcion=request.form['descripcion'])
    db.session.add(new_comentario)
    db.session.commit()
    return redirect('detalleproductoadmin')

#calificar admin
@app.route('/calificar_admin')
@login_required
def calificar_admin():
    calificaciones = Calificacion.query.all()
    return render_template('gestor_Calificaciones/agregar_Calificacion_admin.html', calificaciones = calificaciones)

@app.route('/create_calificacion_admin', methods=['POST'])
@login_required
def create_calificacion_admin():
    new_calificacion = Calificacion(cuanto=request.form['cuanto'])
    db.session.add(new_calificacion)
    db.session.commit()
    return redirect('detalleproductoadmin')


'''
#desear super
@app.route('/desear_super')
def desear_super():
    deseos = Deseo.query.all()
    return render_template('gestor_Deseos/listar_Deseo.html', deseos = deseos)

@app.route('/create_deseo_super', methods=['POST'])
def create_deseo_super():
    new_deseo = Deseo(content=request.form['content'])
    db.session.add(new_deseo)
    db.session.commit()
    return redirect('detalleproductosuper')

@app.route('/editar_deseo_super/<int: id>', methods=['GET', 'POST'])
def editar_deseo_super(id):
    deseo = Deseo.query.get_or_404(id)
    deseobj = Deseo(content=request.form['content'])
    if request.method == 'POST':
        if deseobj.validate_on_submit():
            deseobj.populate_obj(deseo)
    db.session.commit()
    return redirect('detalleproductosuper', deseobj = deseo)

@app.route('/eliminar_deseo/<int: id>')
def eliminar_deseo_super(id):
    deseo = Deseo.query.get_or_404(id)
    db.session.delete(deseo)
    db.session.commit()
    return redirect('detalleproductosuper')

#productos super_admin
@app.route('/producto')
def producto():
    productos = producto.query.all()
    return render_template('gestor_Productos/listar_Producto.html', productos=productos)

@app.route('/create_producto', methods=['POST'])
def create_producto():
    new_producto = producto(content=request.form['nombre', 'precio', 'caracteristicas'])
    db.session.add(new_producto)
    db.session.commit()
    return redirect('producto')

@app.route('/editar_producto/<int: id>', methods=['GET', 'POST'])
def editar_producto(id):
    producto = Producto.query.get_or_404(id)
    productobj = Producto(content=request.form['nombre', 'precio', 'caracteristicas'])
    if request.method == 'POST':
        if productobj.validate_on_submit():
            productobj.populate_obj(producto)
    db.session.commit()
    return redirect('producto', productobj = producto)

@app.route('/eliminar_producto/<int: id>')
def eliminar_producto(id):
    producto = Producto.query.get_or_404(id)
    db.session.delete(producto)
    db.session.commit()
    return redirect('producto')
'''
#gestor personas super
@app.route('/registro_super', methods=['POST'])
def registro_super():
    nombre = request.form['nombre']
    apellido = request.form['apellido']
    correo = request.form['correo']
    usuario = Usuario(nombre=nombre,apellido=apellido, correo=correo)
    usuario.def_clave(request.form['contrasena'])
    db.session.add(usuario)
    db.session.commit()
    usuario = Usuario.query.filter_by(correo=correo).first()
    return redirect('lista_personas')

@app.route('/delete_usuario_super/<id>')
def delete_usuario_super(id):
    Usuario.query.filter_by(id=int(id)).delete()
    db.session.commit()
    return redirect(url_for('lista_personas'))

#gestor productos super
@app.route('/registro_productos_super', methods=['POST'])
def registro_productos_super():
    nombre = request.form['nombre']
    precio = request.form['precio']
    caracteristicas = request.form['caracteristicas']
    producto = Producto(nombre=nombre, precio=precio, caracteristicas=caracteristicas)
    db.session.add(producto)
    db.session.commit()
    return redirect('lista_productos')

@app.route('/delete_producto_super/<id>')
def delete_producto_super(id):
    Producto.query.filter_by(id=int(id)).delete()
    db.session.commit()
    return redirect(url_for('lista_productos'))

#gestor personas admin
@app.route('/registro_admin', methods=['POST'])
def registro_admin():
    nombre = request.form['nombre']
    apellido = request.form['apellido']
    correo = request.form['correo']
    usuario = Usuario(nombre=nombre,apellido=apellido, correo=correo)
    usuario.def_clave(request.form['contrasena'])
    db.session.add(usuario)
    db.session.commit()
    usuario = Usuario.query.filter_by(correo=correo).first()
    return redirect('lista_personas_admin')

@app.route('/delete_usuario_admin/<id>')
def delete_usuario_admin(id):
    Usuario.query.filter_by(id=int(id)).delete()
    db.session.commit()
    return redirect(url_for('lista_personas_admin'))

#gestor productos admin
@app.route('/registro_producto_admin', methods=['POST'])
def registro_producto_admin():
    nombre = request.form['nombre']
    precio = request.form['precio']
    caracteristicas = request.form['caracteristicas']
    producto = Producto(nombre=nombre, precio=precio, caracteristicas=caracteristicas)
    db.session.add(producto)
    db.session.commit()
    return redirect('lista_productos_admin')

@app.route('/delete_producto_admin/<id>')
def delete_producto_admin(id):
    Producto.query.filter_by(id=int(id)).delete()
    db.session.commit()
    return redirect(url_for('lista_productos_admin'))


#logins y registro

#usuario
@app.route('/signup',methods=['POST'])
def signup():
    nombre = request.form['nombre']
    apellido = request.form['apellido']
    correo = request.form['correo']
    usuario = Usuario(nombre=nombre,apellido=apellido, correo=correo)
    usuario.def_clave(request.form['contrasena'])
    db.session.add(usuario)
    db.session.commit()
    usuario = Usuario.query.filter_by(correo=correo).first()
    return redirect('login')

@app.route('/login_usuario',methods=['POST'])
def login():
    correo = request.form['correo']
    usuario = Usuario.query.filter_by(correo=correo).first()
    if usuario.verif_clave(request.form['contrasena'])==True:
        login_user(usuario)
        return redirect('menulogin')
    else:
        flash("CREDENCIALES INVALIDAS")
        return redirect('/')
    

#admin
@app.route('/login_admin',methods=['POST'])
def login_admin():
    contrasena = request.form['contrasena']
    correo = request.form['correo']
    admin = Admin.query.filter_by(correo=correo).first()
    login_user(admin)
    return redirect('menuadmin')

#super
@app.route('/login_super',methods=['POST'])
def login_super():
    contrasena = request.form['contrasena']
    correo = request.form['correo']
    super = Super.query.filter_by(correo=correo).first()
    login_user(super)
    return redirect('menusuper')
    
#cerrar sesion
@app.route('/logout',methods=['GET'])
def logout():
    if current_user.is_authenticated==True:
        logout_user()
        return redirect('/')
    else:
        flash("Para ejecutar esta acción usted debe loguearse")
        return redirect('/')



if __name__ == "__main__":
    app.secret_key = 'super secret key'
    app.config['SESSION_TYPE'] = 'filesystem'
    app.debug = True
    app.run()