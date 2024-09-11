let loginBtn = document.getElementById('login-btn');

loginBtn.addEventListener('click', () => {
  if (loginBtn.textContent === 'Iniciar sesión') {
    loginBtn.textContent = 'Cerrar sesión';
  } else {
    loginBtn.textContent = 'Iniciar sesión';
  }
});

let addDefBtn = document.getElementById('add-def-btn');

addDefBtn.addEventListener('click', () => {
  addDefBtn.style.display = 'none';
});

let definitions = document.querySelectorAll('.definition');
let likesArray = [];

definitions.forEach((definition, index) => {
  let likeElement = definition.querySelector('.likes');
  let likes = parseInt(likeElement.getAttribute('data-likes')); 
  if (isNaN(likes)) {
    likes = 0; // Inicializa el valor de likes a 0 si es NaN
  }
  likesArray[index] = likes; 

  likeElement.addEventListener('click', function() {
    let currentLikes = likesArray[index]; 
    if (isNaN(currentLikes)) {
      currentLikes = 0; // Inicializa el valor de likes a 0 si es NaN
    }
    let newLikes = currentLikes + 1; 
  
    likesArray[index] = newLikes; 
    likeElement.textContent = `${newLikes} me gusta`; 
    likeElement.setAttribute('data-likes', newLikes);
  
    let definitionTitle = definition.querySelector('h2').textContent;
    alert(`Te gusta la definición: ${definitionTitle}`);
  });
});