$(document).ready(initialize);

function initialize() {

    $("#ontology-tree").on('changed.jstree', function(e, data) {
        var i, j, r = [];
        for (i = 0, j = data.selected.length; i < j; i++) {
            r.push(data.instance.get_node(data.selected[i]).text);
        }
        $('#event_result').html('Selected: ' + r.join(', '));
        $("#search-button").click(function() {
            console.log("***" + r);
        });
    })
            // create the instance
            ;

}
function sendSymptoms() {
    var servlet = "getDisease.do";
    $.get(servlet, function(selected) {

    });
}