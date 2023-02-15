<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="spreadsheet" href="$/css/summernote-lite.css">
<style type="text/css">
	a { text-decoration: none;}
	table{width: 800px; border-collapse:collapse; text-align : center; }
	table,th,td{border: 1px solid black; padding: 3px;}
	div{ text-align: center;}
	#wrap{width:800px; margin: auto;}.bg{background-color: #99ccff;}
</style>
<script type="text/javascript">
	function save_go(f) {
		var k = "${g2vo.pwd}";
		var k2 = "${g2vo.idx}";
		if(f.pwd.value == k){
			f.action="update_ok.do?idx="+${g2vo.idx};
			f.submit();
		} else {
			alert("비밀번호 틀림");
			f.pwd.value="";
			f.pwd.focus();
			return;
		}
	}
</script>
</head>
<body>
	<div>
		<h2>방명록 : 수정화면</h2>
		<hr />
		<p>[<a href="gb2_list.do">목록으로 이동</a>]</p>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tr align="center">
					<td bgcolor="#99ccff">작성자</td>
					<td><input type="text" name="name" size ="20" value="${g2vo.name }"></td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">제  목</td>
					<td><input type="text" name="subject" size ="20" value="${g2vo.subject }"/></td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">email</td>
					<td><input type="text" name="email" size ="20" value="${g2vo.email }"/></td>
					<tr align="center">
				</tr>
				<tr>
				<td class="bg">첨부파일</td>
				<td>
				<c:choose>
				<c:when test="${empty g2vo.f_name }">
				<input type ="file" name="f_name"><b>이전 파일 없음</b>
				<input type="hidden" name="old_f_name" value="">
				</c:when>
				<c:otherwise>
				<input type="file" name="f_name"><b>이전 파일명(${g2vo.f_name })</b>
			    <input type="hidden" name="old_f_name" value=${g2vo.f_name }>
			    </c:otherwise>
			    </c:choose>
			    </td>
			    </tr>
				<tr>
					<td bgcolor="#99ccff">비밀번호</td>
					<td><input type="password" name="pwd" size ="20" /></td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<textarea rows="10" cols="60" name="content">${g2vo.content }</textarea>
					</td>
				</tr>
				<tfoot>
					<tr align="center">
						<td colspan="2">
						<%-- <input type="hidden" value="update_ok" name="cmd">
						<input type="hidden" value="${vo.idx}" name="idx"> --%>
							<input type="button" value="저장" onclick="save_go(this.form)" />
							<input type="hidden" name="g2vo" value="${g2vo }">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="취소" />
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	<script src = "https://code.jquery.com/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
    <script src="/js/summernote-lite.js"></script>
    <script src="/js/lang/summernote-ko-kr.js"></script>
    <script type="text/javascript"> 
    $(function(){
    	$("#content").summernote({
    		lang: "kr-KR",
    		height : 300,
    		focus : true,
    		callbacks : {
    			onImageUpload : function(files, editor){
    				for(var i=0; i<files.length;i++){
    					sendImage(files[i],editor)
    				}
    			}
    		}
    	});
    });
    function sendImage(file, editor){
    	var frm = new FormData();
    	frm.append("upload",file);
    	
    	//비동기 통신
    	$.ajax({
    		url:"saveImage.do",
    		data: frm,//전달하고자 하는 파라미터 값
    		type: "post",
    		contentType : false,
    		processData : false,
    		dataType : "json",
    		
    	}).done(function(data){
    		$("#content").summernote("editor.insertImage", data.img_url);
    	});
    }
    
    </script>
</body>
</html>