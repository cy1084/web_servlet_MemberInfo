<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 결과</title>
<script type="text/javascript">
	window.onload = function() {
		var id = opener.document.getElementsByName("id");
		document.getElementById("inputId").textContent = id.value;
	}
</script>
</head>
<%
Object obj = request.getAttribute("isc");
boolean isc = (Boolean) obj;
%>
<body>
	<table>
		<tr>
			<td>
				<div id="inputId"></div>
			</td>
		</tr>
		<tr>
			<td>
				<%=isc?"사용할 수 있습니당":"사용할 수 없습니당" %>
			</td>
		</tr>
		<tr>
			<%
				if(isc){
					%>
						<td>
							<input type="button" value="사용하기" onclick="confirm()">
						</td>
					<% 
				}else{
					%>
						<td>
							<input type="button" value="창닫기" onclick="cancel()">
						</td>
					<% 
					
				}
			%>
			<td>
				
			</td>
		</tr>
	</table>
</body>
</html>