$(document).ready(function(evtObj){ //herbie fully loaded fn
	$.getJSON("http://compsci.dalton.org:8080/grot/trinity/restaurantOrder.jsp?id=" + 147).done(function(data){
		var html = "<ol id=\"stores\">"
		var stores = new Array(); 

	//makes sure cuisine matches with whatever the search term was
		for(int i = 0; i < res.length; i++){
			for (int ii = 0; ii< res.cuisine.length; ii++) {
			if(res.get(cuisine) == cuisine) {
				html += "<li>" + res[i] + "</li>";
			}
		}
		}

		html += "</ol>"; 
		document.getElementById("stores").innerHTML = html;​ //fuck the children

		$("#stores").children().click(function(storeID) {
			// find the items
			var html = "<ol id=\"item\">"
			var menu = {} 
			for (int j = 0; j < res.menu.length j++) {
				for(int k = 0; k < res.menu[j].children.length; k++) {
					var itemName = res.menu[j].children[k].name
					var itemDesc = res.menu[j].children[k].descrip 
					menu[itemName] = itemDesc;
				}
			}

			for (var m in menu){
				html += "<li>" +m+ "</li>";
				html += "<li>" +menu[m]+ "</li>";
			};
		});
	});	
})
