$(document).ready(function(){ //herbie fully loaded fn

// var newButton = function(){

// 	$("button").remove();

// 	$("ul").append("<li><input type=\"email\" name=\"staff\" class=\"staff\"><button class=\"add_staff\">+</button></li>");
// 	$("button").click(newButton);
// });

// $("button").click(newButton

	$(function() {
        var scntDiv = $('#p_scents');
        var i = $('#p_scents p').size() + 1;
        
        $('#addScnt').live('click', function() {
                $('<p><label for="p_scnts"><input type="text" id="p_scnt" size="15" name="p_scnt_' + i +'" value="" placeholder="Staff" /></label> <a href="#" id="remScnt">Remove</a></p>').appendTo(scntDiv);
                i++;
                return false;
        });
        
        $('#remScnt').live('click', function() { 
                if( i > 2 ) {
                        $(this).parents('p').remove();
                        i--;
                }
                return false;
        });
});

});