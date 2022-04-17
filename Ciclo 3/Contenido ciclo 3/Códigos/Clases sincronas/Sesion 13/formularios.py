from flask_wtf import Flaskform
from wtforms import StringField, BooleanField, SubmitField, PasswordField, SelectField
from wtforms.fields.html5 import EmailField
from wtforms.validators import Datarequired

class formEstudiante(FlaskForm):
    documento = StringField('Documento',validators=[Datarequired(message="No dejar vacio")], render_kw={'placeholder':'Identificacion'})