//Created by mkslofstra and aroeters
$(document).ready(initialize);
function initialize() {
    $("#search-symptome").click(function() {
        $("#search-symptome").val("");
    });
    var symptoms;
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
                    console.log(parents[0]);
                }
                ;
            }
            localStorage.setItem("symptoms", selectedNodes);
            console.log(selectedIds);
        }
        //add the selected nodes (and their parents) to the page, below the tree
//        $('#event_result').html('Selected symptoms:<br/>' + selectedNodes.join(', '));
        $('#event_result').html('Selected symptoms:<br/>');
        for (i = 0; i < selectedIds.length; i++) {
            $("#event_result").append("<button class=\"btn btn-default\">"
                    + selectedNodes[i] + " <span class=\"closeSymptom\" data-close=\"" + selectedIds[i] + "\"> X </span></button>");
        }
        $(".closeSymptom").click(function() {
            $("#ontology-tree").jstree("deselect_node", $(this).data("close"));
        });
    });
    $("#search-button").click(function() {
        sendSymptoms();
    });
}
//this function will send data to the servlet and get diseases back
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
function loadDisease() {
    var diseaseServlet = "RetrieveDisease.do";
    $.get(diseaseServlet, {"omimNumber": localStorage.getItem("omimNumber"),
        "symptoms[]": localStorage.getItem("symptoms")}, function(disease) {
        $("#resultTab").text("");
        //put the disease data in the results div
        $("#resultTab").append(disease);
        //set the bootstrap styling on the tooltip 
        $("body").tooltip({selector: '[data-toggle=tooltip]'});
        $("#highlightButton").click(function() {
            $(".highlight").toggleClass("highlighted");
        });
        //load results again
        $("#back2results").click(function() {
            sendSymptoms();
        });
    });
}
;
