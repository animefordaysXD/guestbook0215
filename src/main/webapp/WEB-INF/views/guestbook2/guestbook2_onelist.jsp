<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a { text-decoration: none;}
	table{width: 500px; border-collapse:collapse; }
	table,tr,td{border: 1px solid black; padding: 3px}
	
</style>
<script type="text/javascript">
	function update_go(f) {
		f.action="gb2_update.do?idx="+${g2vo.idx};
		f.submit();
	}
	function delete_go(f) {
		f.action="gb2_delete.do?idx="+${g2vo.idx};
		f.submit();
	}
</script>
</head>
<body>
	<div align="center">
	 <h1>a is : "${g2vo.pwd}"</h1>
		<h2>방명록 : 내용화면</h2>
		<hr />
		<p>[<a href="gb2_list.do">목록으로 이동</a>]</p>
		<form method="post">
			<table>
				<tr align="center">
					<td bgcolor="#99ccff">작성자</td>
					<td>${g2vo.name }</td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">제  목</td>
					<td>${g2vo.subject }</td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">email</td>
					<td>${g2vo.email }</td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">첨부파일</td>
					<%-- 첨부파일이 있는 경우와  없는 경우로 나눈다.--%>
					<c:choose>
						<c:when test="${empty g2vo.f_name}">
						<td>
							<b>첨부파일 없음</b>
						</td>	
						</c:when>
						<c:otherwise>
						<td>
							<img src="<c:url value='/resources/upload/${g2vo.f_name}'/>" 
							width="200px"><br>
							<a href="down.do?file_name=${g2vo.f_name}">${g2vo.f_name}</a>
						</td>	
						</c:otherwise>
					</c:choose>	
				</tr>
				<tr>
					<td colspan="2"><pre>${g2vo.content}</pre></td>
				</tr>
				<tfoot>
					<tr align="center">
						<td colspan="2">
							<input type="button" value="수정" onclick="update_go(this.form)" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" value="삭제" onclick="delete_go(this.form)" />
						<input type="hidden" name ="g2vo"  value= "${g2vo}">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>