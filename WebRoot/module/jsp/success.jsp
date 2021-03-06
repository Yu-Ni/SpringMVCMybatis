<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
session = request.getSession();
String username=(String)session.getAttribute("name2");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="./module/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="./module/css/success.css" rel="stylesheet" type="text/css" />
	<link href="./module/css/bootstrap-dialog.min.css" rel="stylesheet" type="text/css" />
	
	<script src="./module/frame/jquery.min.js"></script>
	<script src="./module/frame/bootstrap.min.js"></script>
	<script src="./module/frame/bootstrap-dialog.min.js"></script>
  </head>
  
  <body>
    <div id="container">
    	<form method="post" action="userController/query" class="fm">
	    	Username:<input type="text" name="input"/>
	    	<input type="submit" value="Search" class="search"/>
	    </form>
	    
	    <div class="table-responsive">
	    	<table class="table table-hover" width="400" height="50" border="1">
		    	<caption>用户基本信息</caption>
		   		<tr align="center" class="tb_header">
		   			<td>用户名</td>
		   			<td>真实姓名</td>
		   			<td colspan="2">操作</td>
		   		</tr>
		    	<c:forEach items="${list }" var="userinfo">
		    		<tr align="center">
		    			<td>${userinfo.username }</td>
		    			<td>${userinfo.realname }</td>
		    			<td><input type="button" value="Delete" onclick="deleteUser('${userinfo.userid}')" class="opBtn"/></td>
		    			<td><input type="button" value="Edit" onclick="edit('${userinfo.userid}')" class="opBtn"/></td>
		    		</tr>
		    	</c:forEach>
	   		</table>
	    </div>
    </div>
    
    <script type="text/javascript">
		function edit(userid){
			 BootstrapDialog.show({
			 	title:"Edit",
            	message: $('<div></div>').load('userController/queryById/'+userid)
        	 });
		}
		
		function deleteUser(userid){
			BootstrapDialog.show({
			 	title:"Delete",
            	message: "Are you sure to delete this account?",
            	buttons: [{
	                label: 'Yes',
	                hotkey: 65, 
	                action: function() {
	                   window.location.href="userController/delete/"+userid;
	                }
	            }, {
	                label: 'No',
	                hotkey: 66,
	                action: function(dialogItself) {
	                    dialogItself.close();
	                }
	            }]
        	 });
		}
  	</script>
  </body>
</html>
