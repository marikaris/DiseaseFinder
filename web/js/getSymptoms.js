//Created by mkslofstra and aroeters
$(document).ready(initialize);
function initialize() {
    $("#search-symptome").click(function() {
        $("#search-symptome").val("");
    });
    var symptoms;
    $("#ontology-tree").on('changed.jstree', function(e, data) {
        var i, j, selectedNodes = [];
        //run through all selected nodes
        for (i = 0, j = data.selected.length; i < j; i++) {
            //get the selected node
            var selected = data.instance.get_node(data.selected[i]);
            if ($.inArray(selected.id, selectedNodes) === -1) {
                selectedNodes.push(selected.text);
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
                        if ($.inArray(thisNode.text, selectedNodes) === -1) {
//                        console.log(thisNode.text);
                            selectedNodes.push(thisNode.text);
                        }
                    }
                }
                );
            } else {
                //if the list of parents consist of one parent, check if that
                //parent is in the list of selected items, if not, add it to
                //the list
                if ($.inArray(parents[0], selectedNodes) === -1) {
                    selectedNodes.push(parents[0]);
                }
                ;
            }
            localStorage.setItem("symptoms", selectedNodes);
        }
        $("#search-button").click(function() {
            sendSymptoms();
        });
        //add the selected nodes (and their parents) to the page, below the tree
        $('#event_result').html('<br/>Selected:<br/>' + selectedNodes.join(', '));
    });
}
//this function will send data to the servlet and get diseases back
function sendSymptoms(symptoms) {
//the name of the servlet
    var servlet = "getDisease.do";
    //use the servlet
    $.get(servlet, {"symptoms[]": localStorage.getItem("symptoms")}, function(diseases) {
        $("#result").text("");
        $("#result").append("<h2>Results</h2>");
        $("#result").append("<ul>");
        $("#result").append(diseases);
        $("#result").append("</ul>");
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
        $("#result").text("");
        //put the disease data in the results div
        $("#result").append(disease);
        //set the bootstrap styling on the tooltip 
        $("body").tooltip({selector: '[data-toggle=tooltip]'});
        //load results again
        $("#back2results").click(function() {
            sendSymptoms();
        });
    });
}
;
//from Ravi Kumar Raman on Stack overflow
function uiGetParents(loSelectedNode) {
    try {
//the length of the list of parents
        var lnLevel = loSelectedNode.parents.length;
        //the id of the selected node
        var lsSelectedID = loSelectedNode.id;
        //select the node 
        var loParent = $("#" + lsSelectedID);
        var parents = [];
        //as long as there are more parents, do this
        for (var ln = 0; ln <= lnLevel - 1; ln++) {
//check for new parent
            var loParent = loParent.parent().parent();
            //if parent has no children (and is last)
            if (loParent.children()[1] !== undefined) {
//push parent to parents
                parents.push(loParent.children()[1].text);
            }
        }
        return(parents);
    }
    catch (err) {
//log if there is an error in this code (hope not)
        console.log('Error in uiGetParents');
    }
}