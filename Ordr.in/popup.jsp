<%
	if(request.getParameter("name") == null)
		response.sendRedirect(request.getRequestURL().toString());
	else
	{
		String name = request.getParameter("name");
		//load info
	}
%>

<!DOCTYPE html>
<html>
	<head>
		<title><%=name%></title>
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	</head>
	<body>
		