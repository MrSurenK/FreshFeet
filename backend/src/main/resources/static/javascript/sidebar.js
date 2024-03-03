// Javascript for sidebar navigation

// Task 1: When clicked on a menuItem show drop down if submenus exist

  // Get the div tag of a main menu item
  const menuItems = document.getElementsByClassName("menuItem");

  /* Assign a click event listener that will hide or show the
     submenus within the menu items if it exists.
  */
  menuItems.addEventListener("click",()=>{
    for(const item of menuItems){
        if (item.children){
            const dropdownItems = item.getElementsByClassName("dropdown");
            for(const each of dropdownItems){
                if(each.style.display == "none"){
                    each.style.display == "block"
                } else {
                    each.style.display =="none"
                }
            }
        }
    }
  })
