<%@page import="com.min.edu.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<%
UserDto dto = (UserDto) request.getAttribute("info");
%>
<body>
	<table>
		<thead>
			<tr>
				<td>시퀀스</td>
				<td>아이디</td>
				<td>이름</td>
				<td>주소</td>
				<td>전화번호</td>
				<td>이메일</td>
				<td>사용여부</td>
				<td>권한</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=dto.getSeq() %></td>
				<td><%=dto.getId() %></td>
				<td><%=dto.getName() %></td>
				<td><%=dto.getAddress() %></td>
				<td><%=dto.getPhone() %></td>
				<td><%=dto.getEmail() %></td>
				<td><%=dto.getEnable() %></td>
				<td><%=dto.getAuth().equals("ADMIN")?"관리자":"사용자" %></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="8">
					<input type="button" value="수정" onclick=""> 
					<input type="button" value="탈퇴" onclick=""> 
				</td>
			</tr>
		</tfoot>
	</table>

</body>
</html>