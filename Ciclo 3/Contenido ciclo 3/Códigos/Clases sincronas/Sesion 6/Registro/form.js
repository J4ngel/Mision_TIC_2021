function validar_form(){
    let user = document.formulario.usuario
    let email = document.formulario.email
    let pass = document.formulario.pass

    let user_len = user.value.length
    if(user_len == 0 || user_len < 8){
        alert("El usuario debe contener minimo 8 caracteres")
    }

    let format_email = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i

    if(!format_email.test(email.value)){
        alert("Ingrese un correo valido")
    }

    let pass_len = pass.value.length
    if(pass_len == 0 || pass_len < 8){
        alert("La contraseña debe contener minimo 8 caracteres")
    }
}