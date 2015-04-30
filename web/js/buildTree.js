$(document).ready(initialize);

function initialize() {

    $(function() {

//    var data = 
//            [{"children":[{"children":[{"children":[],"id":"HP:0000119","text":"Abnormality of the genitourinary system","state":{"opened":"false","selected":"false"}}],"id":"HP:0000118","text":"Phenotypic abnormality","state":{"opened":"false","selected":"false"}},{"children":[],"id":"HP:0000005","text":"Mode of inheritance","state":{"opened":"false","selected":"false"}}],"id":"HP:0000001","text":"All","state":{"opened":"true","selected":"false"}}];
//        $('#ontology-tree').jstree(
//                {'plugins': ["checkbox", "search"],
//                    'core': {'data': data}
//                });
//        var to = false;
//        $('#search-symptome').keyup(function() {
//            if (to) {
//                clearTimeout(to);
//            }
//            to = setTimeout(function() {
//                var v = $('#search-symptome').val();
//                $('#ontology-tree').jstree(true).search(v);
//            }, 250);

        var url = "PassTree.do";
        var jsonData;
        $.get(url, function(data) {
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
//
    });
}
