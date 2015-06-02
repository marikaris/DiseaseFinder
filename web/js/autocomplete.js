/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(initialize);

function initialize() {
    var url = "SearchBarAutocomplete.do";
    var suggestions;
    $.get(url, function(data) {
        suggestions = data;
    });
    $('#search-symptom').devbridgeAutocomplete({
        lookup: suggestions,
        onSelect: function(suggestion) {
            alert('You selected: ' + suggestion.value + ', ' + suggestion.data);
        }
    });
}


