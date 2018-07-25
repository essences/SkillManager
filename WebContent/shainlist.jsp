<%@page import="domain.SearchSort"%>
<%@page import="domain.SearchType"%>
<%@page import="domain.SearchType"%>
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


        <div class="searchTypeLine"></div>
        <div class="searchJoken-box">
            <form method="GET" name="KenshuListForm" id="KenshuListForm" action="KenshuList">
            <input type="submit" value="研修リストへ">
            </form>

            <form method="GET" name="searchForm" id="searchForm" action="List">

            <select name="searchType" id="searchType-name" class="searchType-name">
                <option value=<%=SearchType.年次.name() %>   <%if(bean.getPrevSearchType()==SearchType.年次){ %> selected <% }%>>年次で検索する</option>
                <option value=<%=SearchType.役職.name() %>   <%if(bean.getPrevSearchType()==SearchType.役職){ %> selected <% }%>>役職で検索する</option>
            </select>
            <hr>
            <div class="searchJoken-input-box">
                <label>検索条件</label>
                <input
                    type="text" name="searchJoken" class="searchJoken-input-joken"
                    id="searchJoken-input-text" value="<%=(bean.getPrevsearchJoken()==null)?"":bean.getPrevsearchJoken() %>" autofocus>
                <label>並び順</label>
                <select name="searchSort" class="searchJoken-input-sort">
                    <option value= <%=SearchSort.年次.name() %>  <%if(bean.getPrevSearchSort()==SearchSort.年次){ %> selected <% }%>>年次</option>
                    <option value=<%=SearchSort.名前.name() %>   <%if(bean.getPrevSearchSort()==SearchSort.名前){ %> selected <% }%>>名前</option>
                </select>
                <br>
            </div>
            <div class="searchJoken-button-box">
                <input type="submit" name="shiborikomi" class="search-button" id="searchButton" value="絞り込み" >
                <input type="submit" name="kaijo" class="search-button" id="searchButton" value="絞り込み解除" >
                <input type="button" name="clear" class="search-button" id="searchButton" value="チェックボックスクリア"  onclick="allcheck(false);">
                <input type="button" name="allcheck" class="search-button" id="searchButton" value="オールチェック"  onclick="allcheck(true);">
                <input type="submit" name="csv" class="search-button" id="searchButton" value="CSVダウンロード"  >
            </div>
        </div>


        <div class="searchResult-box">
            <div class="searchResult-count-box">
                検索結果<label id="searchResult-count"><%=bean.size() %></label>件です
            </div>
            <table class="searchResult-table">
                <tr>
                    <th class="searchResult-table-no-header">No.</th>
                    <th class="searchResult-table-detail-header">チェック</th>
                    <th class="searchResult-table-detail-header">詳細</th>
                    <th class="searchResult-table-no-header">社員ID</th>
                    <th class="searchResult-table-name-header">名前</th>
                    <th class="searchResult-table-name-header">ふりがな</th>
                    <th class="searchResult-table-busho-header">部署</th>
                    <th class="searchResult-table-yakushoku-header">役職</th>
                    <th class="searchResult-table-detail-header">年次</th>
                    <th class="searchResult-table-email-header">メールアドレス</th>
                    <th class="searchResult-table-telno-header">電話番号</th>
                    <th class="searchResult-table-detail-header">中途入社社員みなし年次</th>

                </tr>
                <%int i =1; for(vo.Shainmaster_wo_retire_viewVo line: bean ){ %>
                    <tr class="">
                        <td><%=i++ %></td>
                        <td><input type="checkbox" name="employee_no" value="<%=line.getEmployee_no() %>" <%if( bean.get(line.getEmployee_no() )!=null ){ %> checked="checked"  <%}%>  ></td>
                        <td class="searchResult-table-detail-body">
                            <input type="button" class="detail-button" data-key="<%=line.getEmployee_no() %>"></td>
                        <td><%=line.getEmployee_no() %></td>
                        <td><%=line.getEmployee_family_name() %> <%=line.getEmployee_first_name() %> </td>
                        <td><%=line.getEmployee_family_name_kana() %> <%=line.getEmployee_first_name_kana() %> </td>
                        <td><%=line.getDept_name() %></td>
                        <td><%=(line.getPosition()==null)?"":line.getPosition() %></td>
                        <td><%=line.getNenji() %></td>
                        <td><%=line.getEmail() %></td>
                        <td>'<%=line.getTel_no() %></td>
                        <td><%=(line.getChuto_ninasinenji()==0)?"": line.getChuto_ninasinenji() %></td>
                    </tr>
                <%} %>
            </table>
        </div>
    </form>
</body>
</html>