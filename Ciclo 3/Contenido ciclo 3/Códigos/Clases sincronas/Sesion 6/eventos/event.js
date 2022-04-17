function clic(){
    alert("Alerta de eventos")
}

document.getElementById("btnID").addEventListener("click", clic_listener)//El primer argumento dice que tipo de evento es

function clic_listener(){
    alert("Alerta Listener")
}