
<%@page import="domain.SearchType"%>
<%@page import="domain.SearchType"%>
<%@page import="domain.SearchSort"%>
<%@page import="vo.Shainmaster_wo_retire_viewVo"%>

<%@ page language="java" import="java.util.*"
  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <jsp:useBean id="bean" class="bean.ListBean" scope="request" />
  <!DOCTYPE html>
<html>
<head>
    <title>
    一覧画面
    </title>
    <link rel="stylesheet" type="text/css" href="./stylesheets/umi_search_list.css">
    <script type="text/javascript" src="./javascripts/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="./javascripts/umi_search_list.js"></script>
    <meta charset="UTF-8">
       <script type="text/javascript">
    function allcheck( tf ) {
           var ElementsCount = document.searchForm.elements.length;
           for( i=0 ; i<ElementsCount ; i++ ) {
          document.searchForm.elements[i].checked = tf;
           }
    }
    </script>
</head>

<body>
    <!-- 会社ロゴ -->
    <a href="/"><img src="./images/common/logo01.gif"></a>
    <form method="GET" name="searchForm" id="searchForm" action="List">

        <div class="searchTypeLine"></div>

        <div class="searchJoken-box">
            ログインしてください
            <hr>
            <div class="searchJoken-input-box">
                <input
                    type="text" name="loginname"  autofocus >
                <br>
                <input type="submit"  name="login" value="ログイン" >
            </div>
        </div>

    </form>
</body>
</html>