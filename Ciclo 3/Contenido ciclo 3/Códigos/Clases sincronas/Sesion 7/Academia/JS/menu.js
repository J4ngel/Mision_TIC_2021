function Mostrar(){
    Nav.classList.toggle("Clase_mostrar"); //Agrega la clase si no existe, y si no, la remueve
}

let btn_menu = document.getElementById("btn_menu");
let Nav = document.getElementById("Nav");

btn_menu.addEventListener("click",Mostrar);