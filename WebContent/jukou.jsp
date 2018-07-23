<%@page import="vo.Shainmaster_wo_retire_viewVo"%>
<%@ page language="java" import="java.util.*"
  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <jsp:useBean id="bean" class="bean.JukouListBean" scope="request" />
  <!DOCTYPE html>
<html>
<head>
    <title>
    一覧画面
    </title>
    <link rel="stylesheet" type="text/css" href="./stylesheets/umi_search_list.css">
    <script type="text/javascript" src="./javascripts/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="./javascripts/umi_jukou_list.js"></script>
    <meta charset="UTF-8">
</head>

<body>
    <!-- 会社ロゴ -->
    <a href="/"><img src="./images/common/logo01.gif"></a>
    <form method="GET" name="searchForm" id="searchForm" action="KenshuList">

        <div class="searchTypeLine"></div>
        <div class="searchJoken-box">
                <br>
               <div class="searchJoken-input-box">
                <strong>社員ごと受講実績リスト</strong>
             </div>
            <hr>
            <div class="searchJoken-input-box">
             No.<%=bean.getEmployee_no() %>:<%=bean.getEmployee_family_name() %><%=bean.getEmployee_first_name() %>:
                <%=bean.getNenji() %>年次
                <%if (bean.getChuto_ninasinenji() !=0){%> ( 中途みなし年次<%=bean.getChuto_ninasinenji() %>) <%} %>
            </div>
        </div>


        <div class="searchResult-box">
            <div class="searchResult-count-box">

                  検索結果<label id="searchResult-count"><%=bean.size() %></label>件です
            </div>
            <table class="searchResult-table">
                <tr>
                    <th class="searchResult-table-no-header">No.</th>
                    <th class="searchResult-table-detail-header">詳細</th>
                    <th class="searchResult-table-keiyakusaki-header">研修名</th>
                    <th class="searchResult-table-name-header">日付</th>
                    <th class="searchResult-table-busho-header">出欠</th>
                    <th class="searchResult-table-yakushoku-header">研修日数</th>

                    <th class="searchResult-table-keiyakusaki-header">受講時年次</th>
                    <th class="searchResult-table-email-header">欠席理由</th>

                </tr>
                <%int i=1; for(vo.Kenshu_jukou_viewVo line: bean ){ %>
                    <tr class="">
                        <td><%= i++  %></td>
                        <td class="searchResult-table-detail-body">
                            <input type="button" class="detail-button" data-key="<%=line.getKenshujissekiid()  %>"></td>
                        <td><%=line.getTitle() %></td>
                        <td>
                            <%=line.getKaisaidate() %><br>
                            <%=( line.getKaisaidate2()==null)? "":line.getKaisaidate2() %><br>
                            <%=( line.getKaisaidate3()==null)? "":line.getKaisaidate3() %>
                        </td>
                        <td>
                            <%=(line.getIs_shusseki()==1)?"◯":"☓" %><br>
                            <%=( line.getKaisaidate2()==null)? "":(line.getIs_shusseki2()==1)?"◯":"☓" %><br>
                            <%=( line.getKaisaidate3()==null)? "":(line.getIs_shusseki3()==1)?"◯":"☓" %>
                        </td>
                        <td><%=line.getNumdays() %></td>
                        <td><%=line.getToujitu_nenji() %></td>
                        <td><%=line.getKessekiriyu() %></td>
                    </tr>
                <%} %>
            </table>
        </div>
    </form>
</body>
</html>