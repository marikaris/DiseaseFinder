//var url = "PassTree.do";
//var jsonData;
//$.get(url, function(data) {
//    console.log("Load was performed: " + data);
//    $('#ontology-tree').jstree({
//        'plugins': ["checkbox", "search"], 'core': {
//            'data': eval(data)
//        }});
//
//    var to = false;
//    $('#search-symptome').keyup(function() {
//        if (to) {
//            clearTimeout(to);
//        }
//        to = setTimeout(function() {
//            var v = $('#search-symptome').val();
//            $('#ontology-tree').jstree(true).search(v);
//        }, 250);
//    });
//});

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
        'plugins': ["checkbox", "search"]
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
    });
}