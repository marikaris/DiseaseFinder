<%-- 
    Document   : index
    Created on : Feb 5, 2015, 9:10:34 AM
    Author     : mkslofstra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="../js_plugins/jquery.min.js" type="text/javascript"></script>
        <script src="../js_plugins/bootstrap.min.js" type="text/javascript"></script>
        <link href="../css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/disease_matcher_layout.css" rel="stylesheet" type="text/css"/>
        <script src="../js/resizePics.js" type="text/javascript"></script>
        <script src="../js/autoSize.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phenotype to disease converter</title>       

    </head>
    <body>
        <div id="container">
            <div id="logo" class="jumbotron"><h1>Phenotype to Disease Converter</h1></div>
            <div id="wrapper" class ="col-md-10 col-xs-10 col-sm-10 col-lg-10">
                <div class="col-md-12 col-xs-12 col-sm-12 col-lg-12" id="extraPage">
                    <h2>How to use</h2>
                    <a class="image" data-toggle="tooltip" data-placement="top" title="Click here to make the image bigger."><img src="../img/step1.png" alt="step1" class="examplePic" /></a><br/>
                    <p class="text"><b>Step 1:</b>Select symptoms a patient has in the left column of the page. The symptoms are in a tree. To see the more detailed levels, click on the general levels. </p>
                    <a class="image"><img src="../img/step2.png" alt="step2" class="pic" /></a><br/>
                    <p class="text"><b>Step 2:</b>Click on "Search for diseases". </p>
                    <p class="text"><b>Step 3:</b>A list of diseases which matched the disease show up on the left side of the page.
                        By clicking on the title, the information about the disease shows on a new screen. </p>
                </div>
                <div id="footer" class="col-md-12 col-xs-12 col-sm-12 col-lg-12">
                    <a href="#" class="clickUp">About</a><span id="pipe"> | </span><a class="clickUp" href="#">How to</a><span id="pipe"> | </span><a class="clickUp" href="../index.jsp">Home</a><p id="copyright">
                        &copy;2015-2025 Phenotype to Disease Converter</p>
                </div>
            </div>

        </div>
    </body>
</html>
