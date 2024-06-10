<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.min.edu.dto.UserDto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보조회(사용계정)</title>
</head>
<%
List<UserDto> lists = (List<UserDto>) request.getAttribute("lists");
%>
<body>
	<%-- 	<%=lists%> --%>
	<%@include file="adminHeader.jsp"%>
	<hr size="3">
	<h2>회원정보 조회</h2>
	<table>
		<thead>
			<tr>
				<th>SEQ(시퀀스)</th>
				<th>ID(아이디)</th>
				<th>NAME(성명)</th>
				<th>EMAIL(이메일)</th>
				<th>AUTH</th>
				<th>권한변경</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (UserDto dto : lists) {
			%>
			<tr>
				<td><%=dto.getSeq()%></td>
				<td><%=dto.getId()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getEmail()%></td>
				<td><%=dto.getAuth()%></td>
				<td>
					<button>
						변경<%=dto.getSeq()%></button>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<script type="text/javascript">
		var btns = document.querySelectorAll("button");
		console.log(btns.length);
		for (let i = 0; i < btns.length; i++) {
			btns[i].onclick = function() {
				console.log(this.textContent);
				var seq=this.parentNode.parentNode.children[0].textContent;
				console.log(seq);
				location.href="./authUpdate.do?seq="+seq;
			}
		}
	</script>

</body>

</html>