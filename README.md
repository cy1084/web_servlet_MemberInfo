web010_MemberInfo

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

#아이디중복검사
url: ./duplicateId.do
class:  com.min.edu.controller.DuplicateServlet
parameter: id


#회원가입(입력)
url:  /registServlet.do (post)
class:  com.min.edu.controller.RegistServlet
parameter: id, password, name, address, phone, email=>DTO


#회원상태 전체조회
url: ./userListState.do (get)
class: com.min.edu.controller.UserListStateServlet


#회원 사용자 전체조회
url: ./userListServlet.do (get)
class: com.min.edu.controller.UserListServlet


#권한 수정(폼,화면)
url: ./authUpdate.do (get)
class: com.min.edu.controller.AuthUpdateServlet


#권한 수정(입력)
url: ./authUpdate.do (post)
class: com.min.edu.controller.AuthUpdateServlet
