from flask_wtf import FlaskForm
from wtforms import StringField, BooleanField,SubmitField,PasswordField,SelectField
from wtforms.fields.html5 import EmailField
from wtforms.validators import DataRequired

class formEstudiante(FlaskForm):
    documento=StringField('Documento',validators=[DataRequired(message='no dejar vacio')],render_kw={'placeholder':'Identificacion'})
    nombre=StringField('Nombre',validators=[DataRequired(message='no dejar vacio')],render_kw={'placeholder':'Nombres'})
    ciclo=SelectField('Ciclo',choices=[('Python'),('Java'),('Web')])
    sexo=StringField('Sexo',validators=[DataRequired(message='no dejar vacio')],render_kw={'placeholder':'M/F'})
    estado=BooleanField('Estado')
    enviar=SubmitField('Enviar',render_kw={'class':'form_boton','onmouseover':'guardarEst()'})
    consultar=SubmitField('Consultar',render_kw={'class':'form_boton','onmouseover':'consultarEst()'})
    listar=SubmitField('Listar',render_kw={'class':'form_boton','onmouseover':'listarEst()'})
    actualizar=SubmitField('Actualizar',render_kw={'class':'form_boton','onmouseover':'actualizarEst()'})
    eliminar=SubmitField('Eliminar',render_kw={'class':'form_boton','onmouseover':'eliminarEst()'})
    
class formLogin(FlaskForm):

    usuario=StringField('Usuario',validators=[DataRequired(message='no dejar vacio')],render_kw={'placeholder':'Usuario', 'class':'form_control'})

    clave=PasswordField('Clave',validators=[DataRequired(message='no dejar vacio')],render_kw={'placeholder':'Contraseña', 'class':'form_control',"id":'password'})

    enviar=SubmitField('Login',render_kw={'class':'form_botonL','onmouseover':'ConsultarLogin()'})

    crear=SubmitField('Insertar',render_kw={'class':'form_botonL','onmouseover':'encriptarLogin()'})

    
    
