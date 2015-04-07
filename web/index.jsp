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
        <script src="js/autoSize.js" type="text/javascript"></script>
        <script src="js/buildTree.js" type="text/javascript"></script>
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
                    <input type="text" id="search-symptome" value="Search symptoms" class="input" />
                </div>
                <div id="ontology-tree" class="demo" style="margin-top:2em;"></div>
            </div>
            <div class="col-md-6 col-xs-6 col-sm-6 col-lg-6" id ="result">        
                <h2>Results</h2>
                <table class="results">
                    <tr>
                        <td class="title" colspan="3"><a href="#"><b>DEAFNESS, CONDUCTIVE, WITH PTOSIS AND SKELETAL ANOMALIES</b></a></td>
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
            <div id="footer" class="col-md-12 col-xs-12 col-sm-12 col-lg-12">
                <a href="#" class="clickUp">About</a><span id="pipe"> | </span><a class="clickUp" href="#">How to</a><p id="copyright">&copy;2015-2025 Disease Phenotype Matcher</p>
            </div>
        </div>
    </body>
</html>
