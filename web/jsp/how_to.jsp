<%-- 
    Document   : how_to.jsp
    Created on : Feb 5, 2015, 9:10:34 AM
    Author     : aroeters
    css:        mksloftra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="${initParam.base_url}">
        <script src="js_plugins/jquery.min.js" type="text/javascript"></script>
        <script src="js_plugins/bootstrap.min.js" type="text/javascript"></script>
        <link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/disease_matcher_layout.css" rel="stylesheet" type="text/css"/>
        <script src="js/resizePics.js" type="text/javascript"></script>
        <script src="js/autoSize.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phenotype to disease converter</title>       

    </head>
    <body>
        <div id="container">
            <%@include file="../includes/header.jsp" %>
            <div id="wrapper" class ="col-md-10 col-xs-10 col-sm-10 col-lg-10">
                <div class="col-md-12 col-xs-12 col-sm-12 col-lg-12" id="extraPage">
                    <h2>How to use</h2>
                    <p class="text"><b>Step 1:</b> Select the symptoms that a patient has from the Human Phenotype Ontology tree on the left side of the screen. 
                        If you don't know where the symptom is, put the name of the symptom in the search bar.</p>
                    <a class="image" data-toggle="tooltip" data-placement="right" title="Click on the image to change image size."><img src="img/step1.png" alt="step1" class="examplePic" /></a><br/>
                    <p class="text"><b>Step 2:</b> If you selected all the symptoms, click on "Search for diseases". </p>
                    <a class="image"><img src="img/step2.png" alt="step2" class="pic" /></a><br/>
                    <p class="text"><b>Step 3:</b> When you clicked on "search for diseases" a list of diseases 
                        that match the given symptoms best shows up on the right side of the screen. By clicking on the X in the button with the
                        name of a symptom, the symptom gets deselected.</p>
                    <img src="img/step3.png" alt="step3" class="examplePic1" />
                    <p class="text"><b>Step 4:</b> You can now select the diseases by clicking on them. in the current screen a new tab opens with the information
                        of the disease on it.</p>
                    <p class="text"><b>Step 5:</b> To go back to the other diseases click on back to results.</p>
                    <p class="text"><b>Step 6:</b> To highlight matches, click on "Highlight matches". The matches will only highlight when the found matches are found literally in 
                        the disease description. </p>
                </div>
                <%@include file="../includes/footer.jsp" %>
            </div>

        </div>
    </body>
</html>
