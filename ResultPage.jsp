<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>

header{
    padding: 1em;
    color: white;
    background-color: STEELBLUE;
    clear: left;
    text-align: center;
   
}

.no-js #loader { display: none;  }
.js #loader { display: block; position: absolute; left: 100px; top: 0; }
.se-pre-con {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url(Preloader_3.gif) center no-repeat #fff;
}
.images ul li img {
	width: 400px;
	height: 266px;
}
.images ul li {
	display: inline-block;
}
</style>
<title>BEM Logs</title>
<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js'></script>
<script type='text/javascript' src='loadImg.js'></script>
<script type='text/javascript'>
    $(function(){
        $('data').imgPreload()
    })
</script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.2/modernizr.js"></script>
<script type='text/javascript'>
//paste this code under the head tag or in a separate js file.
	// Wait for window load
	$(window).load(function() {
		// Animate loader off screen
		$(".se-pre-con").fadeOut("slow");;
	});
	
</script>
</head>

<body>

 <header><h1 style="text-align: center;">BEM Log Utility!</h1></header>
 	<div class="data">
 	<table style="width:100%" border="1">
  <tr>
    <th width=20%>Log_Type</th>
    <th width=20%>Log_subtype</th> 
    <th width=20%>log_datetime</th>
    <th width=50%>log_payload</th>
  </tr>
  
   <c:forEach items="${articles}" var="article">
    <tr>
    <td width=20%><c:out value="${article.getLog_type()}"/></td>
    <td width=20%><c:out value="${article.getLog_subtype()}"/></td> 
    <td width=20%><c:out value="${article.getLog_subtype()}"/></td>
    <td width=50%><pre lang="xml"><textarea  readonly="readonly" style="border:none; overflow:hidden"><c:out value="${article.getLog_pay()}"/></textarea></pre></td>
  </tr>
    
  </c:forEach>
 	</table>
 	</div>
 	
<p><div class="se-pre-con"></div>



</body>

</html>