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
                success: function(data) {
                    var items = data;
                    response(items);
                }
            });
        },
        select: function(e, ui) {
            $.ajax({
                url: "SearchTree.do",
                dataType: "text",
                data: {"autoCompleteResult": ui.item.value},
                success: function(data) {
                    data = data.replace(/\[|\]/g, "");
                    var newData = data.replace(/\"|\n/g, "").split(",");
                    console.log(newData);
                }
            });

        }
    });
}


