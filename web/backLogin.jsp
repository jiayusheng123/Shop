<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <% String path = request.getContextPath();
    	String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="css/loginstyle.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		$(window).resize(function(){  
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
   		 })  
   		 
   		 
   		 $("#flushCode").click(function(){
   			 $("#png").attr("src","ValidateCodeServlet?action=getCode&xxxx="+new Date());
   		 });
		
		$("#backLoginFrom").submit(function(){
			var flag = false;
			// 1.先验证验证码
			var code = $("#code").val(); // 获取用户输入的验证码
			var param = new Object();
			param.code = code;
// 			$.getJSON("ValidateCodeServlet?action=validateCode",param,function(data){
// 				debugger
// 				if(data.flag){
// 					return true;
// 				}else{
// 					return false;
// 				}
// 			});

		$.ajax({
			   type: "get",
			   url: "ValidateCodeServlet?action=validateCode",
			   data: param,
			   dataType:'JSON',// 服务端返回类型是json
			   async: false,
			   success: function(msg){
				   if(msg.flag){
					   flag = true;
				   }
			   }
		});

			return flag;
		});
   		 
});  
</script> 

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    <form action="UserServlet?action=backLogin" method="post" id = "backLoginFrom">  
    <ul>
    <li><input name="name" type="text" class="loginuser" /></li>
    <li><input name="password" type="text" class="loginpwd" /></li>
    <li>
    	<input name="password" type="text" class="logincode" id="code" />&nbsp;&nbsp;
    	<img src="ValidateCodeServlet?action=getCode" id="png"/>
    	<a id = "flushCode">看不清，换一张</a>
    </li>
    <li><input name="" type="submit" class="loginbtn" value="登录" /><label>
    <input name="remember" type="checkbox"/>记住密码</label><label><a href="#">忘记密码？</a></label></li>
    </ul>
    </form>
    
    </div>
    
    </div>

    <div class="loginbm">版权所有  2013  <a href="http://www.uimaker.com">uimaker.com</a>  仅供学习交流，勿用于任何商业用途</div>
	
    
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
