const likeButtons = document.querySelectorAll('.like-button');

likeButtons.forEach((button) => {
  const counter = button.parentNode.querySelector('p');

  button.addEventListener('click', () => {
    let currentLikes = parseInt(counter.textContent.match(/\d+/)[0]) || 0;

    currentLikes++;
    
    counter.textContent = `${currentLikes} like(s)`;
  });
});

