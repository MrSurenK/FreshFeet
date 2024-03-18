// Javascript for sidebar navigation

// Task 1: When clicked on a menuItem show drop down if submenus exist

  // Get the div tag of a main menu item
const inventoryMenu = document.getElementById("inventoryManagement");

  /* Assign a click event listener that will hide or show the
     submenus within the menu items if it exists.
  */

function showHideSubMenu(e) {
    // Prevent clicks on child elements from closing the submenu
    if(e.target.closest(".dropdown")){
        return;
    }

    const submenus = inventoryMenu.querySelectorAll(".dropdown");

    for(const menu of submenus){
        if(menu.style.display === "" || menu.style.display === "none"){
            menu.style.display ="block";
        } else {
            menu.style.display = "none";
        }
    }

 }


inventoryMenu.addEventListener("click",showHideSubMenu);

/* Task 2: Add event listener to keep hover effect active
    when clicked.
*/
//Get the a tags from the menuItem classes
const menuItems = document.querySelectorAll(".menuItem > a");


/*Add event listener to check if clicked on and if so add active
class. If active class exists then remove active class.
*/
function toggleActive(e){
    console.log(e.currentTarget);
    if (e.currentTarget.classList.contains("active")){
        e.currentTarget.classList.remove("active");
    } else{
        e.currentTarget.classList.add("active");
    }
}

for (const eachMenu of menuItems){
    eachMenu.addEventListener("click",toggleActive);
}

/*ToDo: Modify above javascript logic such that only one
        a tag can have the active classname at one time.
*/
