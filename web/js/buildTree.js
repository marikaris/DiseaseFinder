$(document).ready(initialize);

function initialize() {
    var url = "PassTree.do";
    $('#ontology-tree').jstree({
        'core': {
            'data': {
                'url': url,
                'data': function(node) {
                    return {'id': node.id};
                }
            }
        },
        'plugins': ["checkbox"]
    });
}
//    $(function() {
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
//    });
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

//    });

