$(document).ready(initialize);

function initialize() {
    $(function () {
        $('#ontology-tree').jstree({'plugins': ["checkbox", "search"], 'core': {
                'data': [
                    {
                        "text": "Phenotypic abnormality",
                        "icon": "glyphicon glyphicon-heart-empty",
                        "children": [
                            {"text": "Abnormality of the nervous system", "state": {"selected": true}, "icon": "glyphicon glyphicon-heart-empty"},
                            {"text": "Abnormality of the skeletal system", "icon": "glyphicon glyphicon-heart-empty"},
                            {"text": "Abnormality of the head or neck", "state": {"opened": true}, "children": [
                                    {"text": "Abnormality of the head", "icon": "glyphicon glyphicon-heart-empty"},
                                    {"text": "Abnormality of the neck", "icon": "glyphicon glyphicon-heart-empty"}],
                                "icon": "glyphicon glyphicon-heart-empty"},
                            {"text": "Etc", "icon": "glyphicon glyphicon-heart-empty"}
                        ]
                    }
                ]
            }});
        var to = false;
        $('#search-symptome').keyup(function () {
            if (to) {
                clearTimeout(to);
            }
            to = setTimeout(function () {
                var v = $('#search-symptome').val();
                $('#ontology-tree').jstree(true).search(v);
            }, 250);
        });
    });
}