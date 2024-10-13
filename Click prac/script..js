document.getElementById("colorButton").addEventListener("click", function() {
    cambiarColor();
});

function cambiarColor() {
    var colores = ["#FF6347", "#66CDAA", "#9370DB", "#FFD700", "#4682B4", "#FFA07A"];
    var colorAleatorio = colores[Math.floor(Math.random() * colores.length)];
    document.body.style.backgroundColor = colorAleatorio;
}