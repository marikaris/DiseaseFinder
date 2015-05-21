$(document).ready(initialize);
function initialize() {
    $(".examplePic").click(function() {
        $(this).toggleClass("bigger");
    });
    $('[data-toggle="tooltip"]').tooltip();
}