$(document).ready(initialize);

function initialize() {
    function autoResizeDiv(search)
    {
        document.getElementById(search).style.height = window.innerHeight + 'px';
    }
    window.onresize = autoResizeDiv;
    autoResizeDiv('search');
    autoResizeDiv('result');
}
