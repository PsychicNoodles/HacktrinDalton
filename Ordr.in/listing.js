function getURLParameters(url) {
    var result = {};
    var searchIndex = url.indexOf("?");
    if (searchIndex == -1 ) return result;
    var sPageURL = url.substring(searchIndex +1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++)
    {       
        var sParameterName = sURLVariables[i].split('=');      
        result[sParameterName[0]] = sParameterName[1];
    }
    return result;
}

$(document).ready(function(){
	$("#loading").button("loading").on("reset", function(){
		$("#loading").button("reset");
	});
	var params = getURLParameters(window.location);
	if(params["zip"] !== undefined) {
		//search by zip
	}
	else if(navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(pos){
			//search by position
		})
	}
	else {

	}
});