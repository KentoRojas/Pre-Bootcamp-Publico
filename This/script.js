// Obtenemos el botón por su id
var botonCambiar = document.getElementById("botonCambiar");

// Agregamos un evento 'click' al botón
botonCambiar.addEventListener("click", function() {
    // Cambiamos el contenido del botón utilizando this y innerText
    this.innerText = "¡Texto cambiado!";
});