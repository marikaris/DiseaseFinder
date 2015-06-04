// made by aroeters
$(document).ready(initialize);

function initialize() {
    var url = "SearchBarAutocomplete.do";
    $("#search-symptom").autocomplete({
        width: 150,
        max: 10,
        minLength: 1,
        autoFocus: true,
        cacheLength: 1,
        scroll: true,
        highlight: false,
        source: function(request, response) {
            $.ajax({
                url: url,
                dataType: "json",
                data: request,
                success: function(data, textStatus, jqXHR) {
                    var items = data;
                    response(items);
                }
            });
        }
    });
}


