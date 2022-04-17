function guardarEst(){
    document.getElementById('formulario').action="/estudiante/save";
}

function consultarEst(){
    document.getElementById('formulario').action="/estudiantes/get";
}

function listarEst(){
    document.getElementById('formulario').action="/estudiante/list";
}

function actualizarEst(){
    document.getElementById('formulario').action="/estudiante/update";
}
function eliminarEst(){
    document.getElementById('formulario').action="/estudiante/delete";
}

function mostrarContrasena(){
    var tipo=document.getElementById("password");
    if(tipo.type == "password"){
        tipo.type="text"
    }else{
        tipo.type="password"
    }
}

function encriptarLogin(){
    document.getElementById('formulariologin').action="login/save";
}

function ConsultarLogin(){
    document.getElementById('formulariologin').action="login/get";
}