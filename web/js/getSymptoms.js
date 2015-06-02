//Created by mkslofstra and aroeters
$(document).ready(initialize);
function initialize() {
    var symptoms;
    localStorage.setItem("ids", "");
    //by aroeters (lists made by mkslofstra)
    $("#ontology-tree").on('changed.jstree', function(e, data) {
        var i, j, selectedNodes = [], selectedIds = [];

        //run through all selected nodes
        for (i = 0, j = data.selected.length; i < j; i++) {
            //get the selected node
            var selected = data.instance.get_node(data.selected[i]);
            if ($.inArray(selected.id, selectedNodes) === -1 && selected.text !== "All") {
                selectedNodes.push(selected.text);
                selectedIds.push(selected.id);
            }
            //get all parents
            parents = selected.parents;
            //The if makes sure that the parents are more than one, so if it
            //is one word, it will not be divided in characters
            if (parents.length !== 1) {
                //check for each parent, if the parent is in the array of 
                //selected nodes
                $.each(parents, function(index, value) {
                    if ($.inArray(value, selectedNodes) === -1 && value !== "#") {
                        var thisNode = $("#ontology-tree").jstree("get_node", value);
                        if ($.inArray(thisNode.text, selectedNodes) === -1 && thisNode.text !== "All") {
                            selectedNodes.push(thisNode.text);
                            selectedIds.push(value);
                        }
                    }
                }
                );
            } else {
                //checks if the parent is #, this should not be added to the list.
                if (parents[0] !== "#") {
                    selectedNodes.push(parents[0]);
                }
                ;
            }
            localStorage.setItem("symptoms", selectedNodes);
            localStorage.setItem("selectedIds", selectedIds);
        }
        // by mkslofstra make buttons of the selected symptoms which on click deselect the symptoms
        $('#event_result').html('Selected symptoms:<br/>');
        for (i = 0; i < selectedIds.length; i++) {
            $("#event_result").append("<button class=\"btn btn-default\">"
                    + selectedNodes[i] + " <span class=\"closeSymptom\" data-close=\"" + selectedIds[i] + "\"> X </span></button>");
        }
        $(".closeSymptom").click(function() {
            $("#ontology-tree").jstree("deselect_node", $(this).data("close"));
        });
        //make sure that when a node opens, it it closed (otherwise the children will not be loaded in the search)
        $("#ontology-tree").on('open_node.jstree', function(e, data) {
            var node = data.node;
            var children = node.children;
            $("#ontology-tree").jstree("check_node", node);
            $.each(children, function(index, child) {
                $("#ontology-tree").jstree("deselect_node", child);
            });

        });
    });
    $("#search-button").click(function() {
        sendSymptoms();
    });
}
//by mkslofstra: this function will send data to the servlet and get diseases back
function sendSymptoms(symptoms) {
    $('.nav-tabs a[href="#resultTab"]').tab('show');
//the name of the servlet
    var servlet = "getDisease.do";
    //use the servlet
    $.get(servlet, {"symptoms[]": localStorage.getItem("symptoms")}, function(diseases) {
        $("#resultTab").text("");
        $("#resultTab").append("<br/><br/><ul>");
        $("#resultTab").append(diseases);
        $("#resultTab").append("</ul>");
        $("body").tooltip({selector: '[data-toggle=tooltip]'});
        $(".clickTitle").click(function() {
            localStorage.setItem("omimNumber", $(this).attr("id"));
            loadDisease();
        });
    });
}
//by mkslofstra
function loadDisease() {
    var diseaseServlet = "RetrieveDisease.do";
    $.get(diseaseServlet, {"omimNumber": localStorage.getItem("omimNumber"),
        "symptoms[]": localStorage.getItem("symptoms")}, function(disease) {
        var pattern = /<h2>([\w 1234567890,;.-]+)<\/h2>/;
        var title = disease.match(pattern)[1];
        var id = title.replace(/[ ,;.-]* /g, "");
        var idPat = new RegExp(id);
        var matchId = localStorage.getItem("ids").match(idPat);
        //make sure, the tab is only created one time
        if (matchId === null) {
            localStorage.setItem("ids", localStorage.getItem("ids") + id);
            title = title.charAt(0) + title.substring(1, title.length).toLowerCase();
            if (title.length > 15) {
                title = title.substring(0, 12) + "...";
            }
            //put the data in an extra tab
            $("#tablist").append("<li role=\"presentation\"><a href=\"#" + id + "\" aria-controls=\"" + id
                    + "\" role=\"tab\" data-toggle=\"tab\" id=\"" + id + "Tab\" class=\"tab\">" + title + " <button class=\"closeDiseaseTab\" data-close=\"" + id + "\">X</button></a></li>");
            $("#tabcontent").append("<div role=\"tabpanel\" class=\"tab-pane\" id=\"" + id + "\"></div>");
            $("#" + id).append("<br/><br/>");
            $("#" + id).append(disease);
        }
        $(".closeDiseaseTab").click(function() {
            matchId = localStorage.getItem("ids").match(idPat);
            var close_id = $(this).data("close");
            var elem = document.getElementById(close_id);
            elem.parentNode.removeChild(elem);
            var tab = document.getElementById(close_id + "Tab");
            tab.parentNode.removeChild(tab);
            $('.nav-tabs a[href="#resultTab"]').tab('show');
            //remove string from id list, so that it can be opened again
            var idString = localStorage.getItem("ids");
            var firstPart = idString.substring(0, matchId.index);
            var lastPart = idString.substring(matchId.index+id.length, idString.length);
            localStorage.setItem("ids", firstPart+lastPart);
        });
        //go to the disease tab
        $('.nav-tabs a[href="#' + id + '"]').tab('show');
        //set the bootstrap styling on the tooltip 
        $("body").tooltip({selector: '[data-toggle=tooltip]'});
        $("#highlightButton").click(function() {
            $(".highlight").toggleClass("highlighted");
        });
        //load results again
        $(".back2results").click(function() {
            $('.nav-tabs a[href="#resultTab"]').tab('show');
        });

    });
}
;
