document.querySelectorAll(".menuItem").forEach(item => {
  item.addEventListener("click", event => {
    event.stopPropagation(); // Stop the event from bubbling up the DOM tree
    alert(item.innerHTML);
  });
});