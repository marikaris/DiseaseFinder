$(document).ready(initialize);

function initialize() {

    $(function() {

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
                                            {"text": "headache", "icon": "glyphicon glyphicon-user"}]},
                                    {"text": "Abnormality of the neck", "icon": "glyphicon glyphicon-user"}],
                                "icon": "glyphicon glyphicon-user"}
                        ]
                    }
                ];
        $('#ontology-tree').jstree(
                {'plugins': ["checkbox", "search"],
                    'core': {'data': data}
                });
        var to = false;
        $('#search-symptome').keyup(function() {
            if (to) {
                clearTimeout(to);
            }
            to = setTimeout(function() {
                var v = $('#search-symptome').val();
                $('#ontology-tree').jstree(true).search(v);
            }, 250);

//        var url = "PassTree.do";
//        var jsonData;
//        $.get(url, function(data) {
////            localStorage.setItem("json", data);
//            //jsonData = data;
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
        });
//
    });
}
