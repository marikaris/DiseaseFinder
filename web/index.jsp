<%-- 
    Document   : index
    Created on : Feb 5, 2015, 9:10:34 AM
    Author     : mkslofstra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="jsTree-style/jsTree-style.css" rel="stylesheet" type="text/css"/>
        <link href="css/disease_matcher_layout.css" rel="stylesheet" type="text/css"/>
        <script src="js_plugins/jquery.min.js" type="text/javascript"></script>
        <script src="js_plugins/bootstrap.min.js" type="text/javascript"></script>
        <script src="js_plugins/jstree.min.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disease Phenotype Matcher</title>       

    </head>
    <body>
        <div id="container">
            <div id="logo" class="jumbotron"><h1>Disease phenotype matcher</h1></div>
            <div class="col-md-6 col-xs-6 col-sm-6 col-lg-6" id = "search">
                <h2>Select symptoms</h2>
                <div id="search-bar">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                    <input type="text" id="search-symptome" value="" class="input"/>
                </div>
                <div id="ontology-tree" class="demo" style="margin-top:2em;"></div>

                <script>
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
                </script>
            </div>
            <div class="col-md-6 col-xs-6 col-sm-6 col-lg-6" id ="result">
                <h2>Results</h2>
                <table class="results">
                    <tr>
                        <td class="title" colspan="3"><a href=""#><b>DEAFNESS, CONDUCTIVE, WITH PTOSIS AND SKELETAL ANOMALIES</b></a></td>
                    </tr>
                    <tr>
                        <td class="label">Mim mumber:</td><td class="value"><a href="#">221320</a></td>
                    </tr>
                    <tr>
                        <td class="label">Matches:</td><td class="value">ptosi</td>
                    </tr>
                    <tr>
                        <td class="label">Score:</td><td class="value">8</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="divider">
                            <br>
                        </td>
                    </tr>
                    <tr>
                        <td class="title" colspan="3"><a href=""#><b>PTOSIS, HEREDITARY CONGENITAL 2</b></a></td>
                    </tr>
                    <tr>
                        <td class="label">Mim mumber:</td><td class="value"><a href="#">300245</a></td>
                    </tr>
                    <tr>
                        <td class="label">Matches:</td><td class="value">ptosi</td>
                    </tr>
                    <tr>
                        <td class="label">Score:</td><td class="value">6</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="divider">
                            <br>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
