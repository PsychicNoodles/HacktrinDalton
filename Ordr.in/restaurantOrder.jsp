<%@ page import="java.net.URL,java.net.URLConnection,java.io.BufferedReader,java.io.InputStreamReader,java.io.FileNotFoundException" %>
<%
if(request.getParameter("id") == null) {
	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	out.println("id parameter required");
}
else {
	try {
		String id = request.getParameter("id");
		Long last = (Long) application.getAttribute("restaurantOrder:last:" + id);
		if(last == null || last + 300000 < System.currentTimeMillis()) { //if last hasn't been set or last time happened less than now minus 5 minutes
			URLConnection conn = new URL("https://r.ordr.in/rd/" + request.getParameter("id")).openConnection();
			conn.setRequestProperty("X-NAAMA-CLIENT-AUTHENTICATION", "id=\"Ht3zQjCa9aTZQpIRJgtjxsVXatrJlV1fGR0IttHOZK0\", version=\"1\"");
			BufferedReader r = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String buf, data = "";
			while((buf = r.readLine()) != null)
				data += buf;
			r.close();
			out.println(data);
			application.setAttribute("restaurantOrder:last" + id, System.currentTimeMillis());
			application.setAttribute("restaurantOrder:json" + id, data);
		}
		else {
			out.println(application.getAttribute("restaurantOrder:json" + id));
		}
	}
	catch(FileNotFoundException fnfe) {
		out.println("id parameter invalid");
	}
}
%>
