<%
	if(request.getParameter("name") == null)
		response.sendRedirect(request.getRequestURL().toString());
	else {
		//load info
	}
%>

<!DOCTYPE html>
<html>
	<head>
		<title><%=info.getName()%></title>
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	</head>
	<body>
		<div id="popup">
			<%=if(info.hasImage()) {"<div><img src=\"" + info.getImage() + "\"></div>"}%>
			<h1 id="name"><%=info.getName()%></h1>
			<h2 id="type"><%=info.getType()%></h2>
			<p id="desc"><%=info.getDesc()%></p>
			<ol id="food">
				<%
				for(String rest : info.getRestaurants()) {
					out.println("\t\t\t\t<li>" + rest + "<ol>")
					for(String food : info.getFoodItem(rest))
						out.println("\t\t\t\t\t<li>" + food + "</li>");
					out.println("\t\t\t\t</li>");
				}
				%>
			</ol>
		</div>
	</body>
</html>