$(document).ready(initialize);

function initialize() {
    $(function() {
        var url = "PassTree.do";
        var jsonData;
        $.get(url, function(data) {
//            localStorage.setItem("json", data);
            //jsonData = data;
            console.log("Load was performed: " + data);
            $('#ontology-tree').jstree({
                'plugins': ["checkbox", "search"], 'core': {
                    'data': eval(data)//[{"parent":"#","icon":"glyphicon glyphicon-user","id":"HP:0000001","text":"All","state":{"opened":true,"disabled":false,"selected":false}}]
                }});

            var to = false;
            $('#search-symptome').keyup(function() {
                if (to) {
                    clearTimeout(to);
                }
                to = setTimeout(function() {
                    var v = $('#search-symptome').val();
                    $('#ontology-tree').jstree(true).search(v);
                }, 250);
            });

        });

    });
}