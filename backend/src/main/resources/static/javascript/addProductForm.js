//Get hold of the main category select
const mainCat = document.getElementById("mainCategory");

//Get hold of the subcategory select
const subCat = document.getElementById("subCategory");

//Add onChange event listener to mainCategory select tag
mainCat.addEventListener("change", ()=> {

    /* On change I want to compare the selected cat id with the parent
        cat id in subCat select tag.
        - When changing mainCat tag remove disable from sub-cat select tag
        - If the the parent cat exists on the select tag then show it in the drop-down meny.
    */
    subCat.disabled = false;

    const selectedMainCat = mainCat.value;
    const subCatOptions = subCat.options;

    for (let i = 0; i < subCatOptions.length; i++ ){
        if (selectedMainCat === subCatOptions[i].getAttribute("fk-data")){
           subCatOptions[i].style.display="";
        } else {
           subCatOptions[i].style.display="none";
    }
    }
})


