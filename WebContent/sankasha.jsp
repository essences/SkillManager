<%@page import="vo.Shainmaster_wo_retire_viewVo"%>
<%@ page language="java" import="java.util.*"
  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <jsp:useBean id="bean" class="bean.SankashaListBean" scope="request" />
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
</head>

<body>
    <!-- 会社ロゴ -->
    <a href="/"><img src="./images/common/logo01.gif"></a>
    <form method="GET" name="searchForm" id="searchForm" action="KenshuList">

        <div class="searchTypeLine"></div>
        <div class="searchJoken-box">
                <br>
               <div class="searchJoken-input-box">
                <strong>実施研修ごと社員リスト</strong>
             </div>
            <hr>
            <div class="searchJoken-input-box">
             研修名<%=bean.getTitle() %>：開催日程:<%=bean.getKaisaidate() %>
             ：研修日数：<%=bean.getNumdays() %>日間
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
                    <th class="searchResult-table-no-header">社員ID</th>
                    <th class="searchResult-table-name-header">氏名</th>

                    <th class="searchResult-table-name-header">ふりがな</th>
                    <th class="searchResult-table-email-header">e-mail</th>
                     <th class="searchResult-table-telno-header">tell</th>

                    <th class="searchResult-table-busho-header">
                            出欠<br>
                            <%=bean.getKaisaidate() %><br>
                            <%=(bean.getKaisaidate2()==null)?"":bean.getKaisaidate2() %><br>
                            <%=(bean.getKaisaidate3()==null)?"":bean.getKaisaidate3() %>
                    </th>
                    <th class="searchResult-table-keiyakusaki-header">受講時年次</th>
                    <th class="searchResult-table-keiyakusaki-header">みなし年次</th>
                    <th class="searchResult-table-email-header">欠席理由</th>

                    <th class="searchResult-table-name-header">現場上長氏名</th>
                    <th class="searchResult-table-email-header">現場上長e-mail</th>

                </tr>
                <%int i=1; for(vo.Kenshu_jukou_viewVo line: bean ){ %>
                    <tr class="">
                        <td><%= i++  %></td>
                        <td class="searchResult-table-detail-body">
                            <input type="button" class="detail-button" data-key="<%=line.getEmployee_no()  %>"></td>
                        <td> <%=line.getEmployee_no() %></td>
                        <td> <%=line.getEmployee_family_name() %><%=line.getEmployee_first_name() %> </td>
                        <td> <%=line.getEmployee_family_name_kana() %><%=line.getEmployee_first_name_kana() %> </td>
                        <td> <%=line.getEmail() %></td>
                        <td> '<%=line.getCell_tel_no() %></td>
                        <td>
                            <%=(line.getIs_shusseki()==1)?"◯":"☓" %><br>
                            <%=(bean.getKaisaidate2()==null)?"":(line.getIs_shusseki2()==1)?"◯":"☓" %><br>
                            <%=(bean.getKaisaidate3()==null)?"":(line.getIs_shusseki3()==1)?"◯":"☓" %>
                        </td>
                        <td><%=line.getToujitu_nenji() %></td>
                        <td><%=line.getChuto_ninasinenji() %></td>
                        <td><%=(line.getKessekiriyu()==null)?"":line.getKessekiriyu() %></td>
                        <td> <%=line.getEmployee_family_name_j() %><%=line.getEmployee_first_name_j() %> </td>
                        <td><%=line.getEmail_j() %></td>
                    </tr>
                <%} %>
            </table>
        </div>
    </form>
</body>
</html>