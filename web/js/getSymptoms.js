$(document).ready(initialize);

function initialize() {

    $("#ontology-tree").on('changed.jstree', function(e, data) {
        var i, j, r = [];
        var parents = [];
        for (i = 0, j = data.selected.length; i < j; i++) {
            var selected = data.instance.get_node(data.selected[i]);
            r.push(selected.text);
//            console.log(selected.parents("li"));
            
        }
        $('#event_result').html('Selected: ' + r.join(', '));
        $("#search-button").click(function() {
//            console.log("***" + r);
        });
//        console.log($("input:checked").id);
        var parents = [];
        selected.parents("li").each(function() {
            parents.push({id: $(this).attr("id"), description: $(this).children("a").text()});
        });
        console.log(parents);
    })
            // create the instance
            ;

}
function sendSymptoms() {
    var servlet = "getDisease.do";
    $.get(servlet, function(selected) {

    });
}