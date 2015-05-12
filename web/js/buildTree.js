//$(document).ready(initialize);
//
//function initialize() {
//
//    $(function() {
//
////    var data = 
////            [{"children":[{"children":[{"children":[],"id":"HP:0000119","text":"Abnormality of the genitourinary system","state":{"opened":"false","selected":"false"}}],"id":"HP:0000118","text":"Phenotypic abnormality","state":{"opened":"false","selected":"false"}},{"children":[],"id":"HP:0000005","text":"Mode of inheritance","state":{"opened":"false","selected":"false"}}],"id":"HP:0000001","text":"All","state":{"opened":"true","selected":"false"}}];
////        $('#ontology-tree').jstree(
////                {'plugins': ["checkbox", "search"],
////                    'core': {'data': data}
////                });
////        var to = false;
////        $('#search-symptome').keyup(function() {
////            if (to) {
////                clearTimeout(to);
////            }
////            to = setTimeout(function() {
////                var v = $('#search-symptome').val();
////                $('#ontology-tree').jstree(true).search(v);
////            }, 250);
//
//        var url = "PassTree.do";
//        var jsonData;
//        $.get(url, function(data) {
//            console.log("Load was performed: " + data);
//            $('#ontology-tree').jstree({
//                'plugins': ["checkbox", "search"], 'core': {
//                    'data': eval(data)//[{"parent":"#","icon":"glyphicon glyphicon-user","id":"HP:0000001","text":"All","state":{"opened":true,"disabled":false,"selected":false}}]
//                }});
//
//            var to = false;
//            $('#search-symptome').keyup(function() {
//                if (to) {
//                    clearTimeout(to);
//                }
//                to = setTimeout(function() {
//                    var v = $('#search-symptome').val();
//                    $('#ontology-tree').jstree(true).search(v);
//                }, 250);
//            });
//
//        });
////
//    });
//}

$(document).ready(initialize);

function initialize() {

    var data = 
            [
                    {
                        "text": "Phenotypic abnormality",
                        "icon": "glyphicon glyphicon-user",
                        "children": [
                            {"text": "Abnormality of the nervous system", "state": {"selected": true}, "icon": "glyphicon glyphicon-user"},
                            {"text": "Abnormality of the skeletal system", "icon": "glyphicon glyphicon-user"},
                            {"text": "Abnormality of the head or neck", "state": {"opened": true}, "children": [
                                    {"text": "Abnormality of the head", "icon": "glyphicon glyphicon-user",
                                        "children": [{"text": "face", "icon": "glyphicon glyphicon-user",
                                                "children": [{"text": "big nose", "icon": "glyphicon glyphicon-user"},
                                                    {"text": "big mouth", "icon": "glyphicon glyphicon-user"},
                                                    {"text": "ptosis", "icon": "glyphicon glyphicon-user"}]},
                                            {"text": "headache", "icon": "glyphicon glyphicon-user", "children": []}]},
                                    {"text": "Abnormality of the neck", "icon": "glyphicon glyphicon-user"}],
                                "icon": "glyphicon glyphicon-user"}
                        ]
                    }
                ];


//        var url = "PassTree.do";
//        var jsonData;
//        $.get(url, function(data) {
//            console.log("Load was performed: " + data);
            $('#ontology-tree').jstree({
                'plugins': ["checkbox", "search"], 'core': {
                    'data':  data
                }});
//
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
//
//        });

}