/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(initialize);

function initialize() {
    $("#search-symptom").autocomplete({
        source: "search.php",
        minLength: 2,
        select: function(event, ui) {
            log(ui.item ?
                    "Selected: " + ui.item.value + " aka " + ui.item.id :
                    "Nothing selected, input was " + this.value);
        }
    });

}

