<%@ page import="java.io.File,java.io.FileReader,java.io.BufferedReader,java.util.Arrays" %>
<%
String zip = request.getParameter("zip");
if(zip == null) {
	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	out.println("zip parameter required");
}
else {
	boolean first = true;
	for(String path : new File("bakesales").list()) {
		BufferedReader r = new BufferedReader(new FileReader(path));
		String temp = r.readLine();
		if(temp.equals(zip)) {
			String[] menu = r.readLine().split(",");
			String email = r.readLine(), address = r.readLine(), desc = r.readLine();
			if(first)
				out.println("{\"results\" : [{");
			else
				out.println(",");
			out.println("\"menu\" : " + Arrays.toString(menu) + ",");
			out.println("\"email\" : \"" + email + "\",");
			out.println("\"address\" : \"" + address + "\",");
			out.println("\"desc\" : \"" + desc + "\"");
			out.println("}");
		}
	}
	if(!first)
		out.println("}");
}
%>