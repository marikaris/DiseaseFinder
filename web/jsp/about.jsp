<%-- 
    Document   : about
    Created on : May 21, 2015, 1:12:19 PM
    Author     : aroeters
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
        <title>Phenotype to disease converter - about</title>       

    </head>
    <body>
        <div id="container">
            <%@include file="../includes/header.jsp" %>
            <div id="wrapper" class ="col-md-10 col-xs-10 col-sm-10 col-lg-10">
                <div class="col-md-12 col-xs-12 col-sm-12 col-lg-12" id="extraPage">
                    <div class="col-md-3 col-xs-3 col-sm-3 col-lg-3"></div>
                    <div class="col-md-6 col-xs-6 col-sm-6 col-lg-6">
                        <h2>About</h2>
                        <div class="centerAlignment">
                            This page is about the Phenotype to Disease Converter application.
                            It will tell you more about why the application was made, 
                            what everything on the page is, how we got to the scoring of 
                            the diseases and who made the application.
                            <br/><br/>
                        </div>
                        <h4>Why was the application made</h4>
                        <div class="centerAlignment">
                            This application was commisioned by M. Noback for Alife. <br/>
                            They wanted an application that would match symptoms, selected from the Human Phenotype 
                            Ontology database, to diseases collected from the OMIM database.
                            <br/><br/>

                        </div>
                        <h4>The application</h4>
                        <div class="centerAlignment">
                            The application is divided into two sides. On the left side the user can search for diseases and  
                            on the right side the user will see the results and the selected symptoms. 
                            When the user has selected symptoms from the Human Phenotype Ontology tree,  
                            the application searches for diseases in the OMIM database that match the symptoms given by the user.  
                            Then the results will be shown with the highest scoring disease, scoring will be discussed later,  
                            on top, the second highest scoring disease will be on the second place and so on.  
                            The user now has the option to select a disease and that will open another screen on the right side  
                            of the application that will show the information that the OMIM database contains of that disease, with  
                            a link to the actual OMIM entry. Than the user can also select back to results to show the list with the  
                            results again.  
                            <br/><br/>
                        </div>
                        <h4>The scoring</h4>
                        <div class="centerAlignment">
                            The score was calculated by adding the score per symptom to the total score.  
                            The score per symptom was calculated by counting the total number of hits the symptom had with different 
                            diseases within the results and dividing one by that number. 
                            For example: a certain symptom has hits with 8 different diseases, then the score for that symptom is 1/8. 
                            This score is then added to the total score of the disease that has a hit with this symptom.
                            This scoring is based on the fact that a  common symptom is less specific for a disease,
                            and thus it should produce a lower score than a symptom which is more rare. 
                            When a symptom is rare, then the symptom is more likely to be specific for a certain disease.
                            Based on this score the sorting is done to see which disease is most likely. The higher the score, the better
                            the found match. 
                            <br/><br/>
                        </div>
                        <h4 class="caution">Caution</h4>
                        <div class="centerAlignment caution">
                            This application does not replace a doctor in any way. <br/> 
                            This application is solely used to give an indication and not a diagnosis. <br/>
                            When you are ill it is still recommended to see a doctor.
                            <br/><br/>
                        </div>
                    </div>
                </div>
                <%@include file="../includes/footer.jsp" %>
            </div>

        </div>

    </body>
</html>

