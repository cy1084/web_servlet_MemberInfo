<!-- 
web010_MemberInfo 매핑
서버사이드는 /(슬러쉬) 유알엘은 ./(점 슬러쉬) 

첫페이지(로그인)
/WEB-INF/views/index.jsp


#로그인
url:  ./loginServlet.do (post)
class:  com.min.edu.controller.LoginServlet
parameter:  id, password


#로그아웃 
url:  ./loginServlet.do (get)
class:  com.min.edu.controller.LoginServlet

#회원상세(FBS)
  마이페이지(WBS)
url: ./userInfo.do (get)
class:  com.min.edu.controller.UserInfoServlet

#회원정보수정(폼)
url:  ./userModifyServlet.do(get)
class:  com.min.edu.controller.UserModifyServlet

#회원정보수정(입력)
url:  ./userModifyServlet.do(get)
class:  com.min.edu.controller.UserModifyServlet
parameter:  address, phone, email, seq

#회원탈퇴
url: ./delUserServlet.do(get)
class:  com.min.edu.controller.DelUserServlet

#회원가입(폼)
url:  /registServlet.do (get)
class:  com.min.edu.controller.RegistServlet
parameter: id, password, name, address, phone, emai=>DTO

#회원가입(입력)


#아이디중복검사
url: ./duplicateId.do
class:  com.min.edu.controller.DuplicateServlet
parameter: id

 -->

<html>
<body>
<h2>Hello World!</h2>
</body>
</html>
