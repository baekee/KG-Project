<%@page import="meminfoVO.Review_VO"%>
<%@page import="meminfoVO.MemInfoVo"%>
<%@page import="meminfoDAO.Review_DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<% 
		request.setCharacterEncoding("UTF-8");
	%>
	
	<!--데이터를 한번에 받아오는 빈클래스를 사용하도록  -->
	<jsp:useBean id = "Review_VO" class= "meminfoVO.Review_VO">
		<jsp:setProperty name="Review_VO" property = "*" />
	</jsp:useBean>
	
	<% 
		//데이터 베이스에 연결 
		Review_DAO rdao = new Review_DAO();
		Review_VO rvo = new Review_VO();
		MemInfoVo vo = new MemInfoVo();
		
		String id = (String) session.getAttribute("mname");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int num = Integer.parseInt(request.getParameter("num").trim());
		
		String password = request.getParameter("password");
		
		//해당 게시글의 패스워드 값을 얻어옴
		String pass = rdao.getPass(id);
		
		//기존 패스워드 값과 update시 작성했던 pass값이 같은지 비교 
		if(pass.equals(password)){
		//데이터 수정하는 메소드 호출
		
		rvo.setTitle(title);
		rvo.setContent2(content);
		rvo.setNum(num);
			//데이터 수정하는 메소드 호출
			rdao.updateBoard(rvo);
			//수정이 완료되면 전체 게시글 보기 
			response.sendRedirect("Review_D_Listform.jsp");
		}else{//패스워드가 틀리다면 
	%>			
		<script type="text/javascript">	
			alert("패스워드가 일치하지 않습니다. 다시 확인후 수정해 주세요.");
			history.go(-1);
		</script>
	<% 		
		}
	%>
</body>
</html>