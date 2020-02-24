
<@%page import="java.time.localDate"%>
<html>
<head>
<title>Home page</title>
<link rol="stylesheet" href="css/site.css" />

</head>
<body>
	<header>
		<h3 style="text .align: right">
			<%=localDate.now()%>
		</h3>
		<nav>
		<a href="home">HOME</a>
		<a href="hello">HELLO</a>
		</nav>
		<h1 style="border-bottom: 1px solid block">${appTitle}</h1>
	</header>
</body>
</html>