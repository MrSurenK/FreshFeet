// Select the main and subcategory select tags wrapping the options

const mainCat = document.getElementById("mainCategory");
const subCat = document.getElementById("subCategory");

mainCat.addEventListener("change", function() {
    const selectedMainCat = this.value;
    const subCatOptions = subCat.options;

    //Enable sub category select
    subCat.disabled = false;

    //Based on what is selected in main category show the valid options in subcategory


})