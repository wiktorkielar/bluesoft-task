<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pl">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
        <tiles:getAsString name="title"/>
    </title>
    <link href="/resources/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/datatables/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet">
    <link href="/resources/css/style.css" rel="stylesheet">
</head>
<body class="fill">
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="menu"/>
    <tiles:insertAttribute name="body"/>
    <tiles:insertAttribute name="footer"/>





    <script src="/resources/jquery/3.3.1/jquery.min.js"></script>
    <script src="/resources/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="/resources/datatables/1.10.19/js/jquery.dataTables.min.js"></script>
    <script src="/resources/datatables/1.10.19/js/dataTables.bootstrap4.min.js"></script>
    <script src="/resources/js/script.js"></script>
</body>
</html>