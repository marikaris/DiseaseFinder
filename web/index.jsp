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
        <script src="js/getSymptoms.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phenotype to disease converter</title>       

    </head>
    <body>
        <div id="container">
            <div id="logo" class="jumbotron"><h1>Phenotype to Disease Converter</h1></div>
            <div id="wrapper" class ="col-md-10 col-xs-10 col-sm-10 col-lg-10">
                <div class="col-md-6 col-xs-6 col-sm-6 col-lg-6" id = "search">                
                    <h2>Select symptoms</h2>
                    <div id="search-bar" class="inner-addon right-addon">
                        <input type="text" id="search-symptome" value="Search symptoms" class="input form-control" />
                        <i id = "glyph" class="glyphicon glyphicon-search" aria-hidden="true"></i>
                    </div>
                    <div id="ontology-tree" class="demo" style="margin-top:2em;"></div>

                </div>
                <div class="col-md-6 col-xs-6 col-sm-6 col-lg-6" id ="result">        
                    <div role="tabpanel">

                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active"><a href="#searchTab" aria-controls="searchTab" role="tab" data-toggle="tab">Search</a></li>
                            <li role="presentation"><a href="#resultTab" aria-controls="resultTab" role="tab" data-toggle="tab">Results</a></li>
                        </ul>

                        <!-- Tab panes -->
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="searchTab">
                                <br/><br/>
                                <div id="event_result">Select symptoms on the right side of the page.</div>
                                <button id="search-button" class="button btn btn-info">Search for diseases</button>
                            </div>
                            <div role="tabpanel" class="tab-pane" id="resultTab">
                                <br/><br/>
                                Click in the search-tab on the search button to get results here.
                            </div>
                        </div>

                    </div>
                </div>
                <div id="footer" class="col-md-12 col-xs-12 col-sm-12 col-lg-12">
                    <a href="jsp/about.jsp" class="clickUp">About</a><span id="pipe"> | </span><a class="clickUp" href="jsp/how_to.jsp">How to</a><p id="copyright">&copy;2015-2025 Phenotype to Disease Converter</p><br/> 
                    <small id="warning">ATTENTION: This tool is not a doctor, when you have certain symptoms, it is always recommended to visit a doctor.</small><br/> 
                </div>            

            </div>

        </div>
    </body>
</html>
