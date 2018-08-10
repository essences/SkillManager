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

</head>

<body onload="init();">
    <!-- 会社ロゴ -->
    <a href="/"><img src="./images/common/logo01.gif"></a>
       <form method="POST"" name="KenshuListForm" id="KenshuListForm" action="KenshuList">
       </form>
       <form method="POST" name="searchForm" id="searchForm" action="List">

        <div class="searchTypeLine"></div>
        <div class="searchJoken-box">
            <input type="button" value="研修リストへ" onClick="document.KenshuListForm.submit()"><br>

            <p style="text-align: right">
            <strong> 入力欄表示 ：</strong><input name="check_type" type="checkbox" onclick="changeCell('noneLine');">
           <strong> 年度：</strong>
           <select name="searchNendo" id="searchNendo-name" class="searchNendo-name" onchange="submit(this.form)">
                <option value="ALL"   <%=(bean.getPrevSearchNendo().equals("ALL" ))? "selected":"" %>>すべて</option>
                <option value="2015"  <%=(bean.getPrevSearchNendo().equals("2015" ))? "selected":"" %>>2015</option>
                <option value="2016"  <%=(bean.getPrevSearchNendo().equals("2016" ))? "selected":"" %>>2016</option>
                <option value="2017"  <%=(bean.getPrevSearchNendo().equals("2017" ))? "selected":"" %>>2017</option>
                <option value="2018"  <%=(bean.getPrevSearchNendo().equals("2018" ))? "selected":"" %>>2018</option>
                <option value="2019"  <%=(bean.getPrevSearchNendo().equals("2019" ))? "selected":"" %>>2019</option>
                <option value="2020"  <%=(bean.getPrevSearchNendo().equals("2020" ))? "selected":"" %>>2020</option>
            </select>
            <select name="kenshuList" id="kenshuList" class="kenshuList" onChange="">
                <% for( vo.Kenshujisseki_viewVo vo: bean.getKenshuList() ){ %>
                        <option value="<%=vo.getKenshujisseki() %>"  > <%=vo.getTitle() %>（<%=vo.getYoteidate() %>,<%=vo.getNumdays() %>日間）  </option>
                <%} %>
            </select>
                     <input type="button" class="sankashalist-button" data-key="" value="参加者リストを表示"
                         onclick='this.dataset.key=getSelected();'>
                    <input type="submit" name="regist_shain_to_kenshu" class="regist_shain_to_kenshu" id="regist_shain_to_kenshu_button"
                        value="研修に参加者を登録"   onclick='return confirm("このリストを本当に研修参加者に登録しますか？");'>
            </p>
            <hr>
             <div class="searchJoken-input-box">
             <select name="searchType" id="searchType-name" class="searchType-name">
                <option value=<%=SearchType.年次.name() %>  <%if(bean.getPrevSearchType()==SearchType.年次){ %> selected <% }%>>年次で検索する</option>
                <option value=<%=SearchType.役職.name() %>   <%if(bean.getPrevSearchType()==SearchType.役職){ %> selected <% }%>>役職で検索する</option>
            </select>


                <label>検索条件</label>
                <input
                    type="text" name="searchJoken" class="searchJoken-input-joken"
                    id="searchJoken-input-text" value="<%=(bean.getPrevsearchJoken()==null)?"":bean.getPrevsearchJoken() %>" autofocus>
                <label>並び順</label>
                <select name="searchSort" class="searchJoken-input-sort">
                    <option value= <%=SearchSort.みなし年次 %>  <%if(bean.getPrevSearchSort()==SearchSort.みなし年次){ %> selected <% }%>>みなし年次</option>
                    <option value=<%=SearchSort.名前.name() %>   <%if(bean.getPrevSearchSort()==SearchSort.名前){ %> selected <% }%>>名前</option>
                    <option value= <%=SearchSort.年次.name() %>  <%if(bean.getPrevSearchSort()==SearchSort.年次){ %> selected <% }%>>年次</option>
                </select>
                <br>
            </div>
            <div class="searchJoken-button-box">
                <input type="submit" name="shiborikomi" class="search-button" id="searchButton" value="絞り込み" >
                <input type="submit" name="kaijo" class="search-button" id="searchButton" value="絞り込み解除" >
                <input type="button" name="clear" class="search-button" id="searchButton" value="チェックボックスクリア"  onclick="allcheckfalse();">
                <input type="button" name="allcheck" class="search-button" id="searchButton" value="オールチェック"  onclick="allchecktrue();">
                <input type="submit" name="csv" class="search-button" id="searchButton" value="CSVダウンロード"  >
            </div>
        </div>


        <div class="searchResult-box">
            <div class="searchResult-count-box">
                検索結果<label id="searchResult-count"><%=bean.getList().size() %></label>件です
            </div>
            <table class="searchResult-table">
                <tr>
                    <th class="searchResult-table-no-header">No.</th>
                    <th class="searchResult-table-detail-header">チェック</th>
                    <th class="searchResult-table-detail-header">参加研修リスト</th>
                    <th class="noneLine">事前出席確認</th>
                    <th class="noneLine">当日出席</th>
                    <th class="noneLine">欠席事由、備考</th>
                    <th class="searchResult-table-no-header">社員ID</th>
                    <th class="searchResult-table-name-header">名前</th>
                    <th class="altnoneLine">ふりがな</th>
                    <th class="noneLine">上長社員No.</th>
                    <th class="searchResult-table-busho-header">部署</th>
                    <th class="searchResult-table-yakushoku-header">役職</th>
                    <th class="altnoneLine">年次</th>
                    <th class="searchResult-table-detail-header">中途入社社員みなし年次</th>
                    <th class="altnoneLine">メールアドレス</th>
                    <th class="altnoneLine">電話番号</th>
                    <th class="noneLine">中途入社対応</th>


                </tr>
                <%int i =1; for(vo.Shainmaster_wo_retire_viewVo line: bean.getList() ){ %>
                    <tr class="">
                        <td>
                            <%=i++ %>
                            <input type="hidden" name="hidden_employee_no" value="<%=line.getEmployee_no() %>"  >
                        </td>
                        <td>
                            <input type="checkbox" name="employee_no" value="<%=line.getEmployee_no() %>" <%if( bean.get(line.getEmployee_no() )!=null ){ %> checked="checked"  <%}%>  >
                        </td>
                        <td class="searchResult-table-detail-body">
                            <input type="button" class="detail-button" data-key="<%=line.getEmployee_no() %>"></td>
                        <td class="noneLine">
                            <input type="checkbox" name="jizen_shusseki1" value="<%=line.getEmployee_no() %>" <%if( bean.getJizenShusseki1(line.getEmployee_no() )!=null ){ %> checked="checked"  <%}%>  >
                            <input type="checkbox" name="jizen_shusseki2" value="<%=line.getEmployee_no() %>" <%if( bean.getJizenShusseki2(line.getEmployee_no() )!=null ){ %> checked="checked"  <%}%>  >
                            <input type="checkbox" name="jizen_shusseki3" value="<%=line.getEmployee_no() %>" <%if( bean.getJizenShusseki3(line.getEmployee_no() )!=null ){ %> checked="checked"  <%}%>  >
                        </td>
                        <td class="noneLine">
                            <input type="checkbox" name="toujitu_shusseki1" value="<%=line.getEmployee_no() %>" <%if( bean.getToujitsuShusseki1(line.getEmployee_no() )!=null ){ %> checked="checked"  <%}%>  >
                            <input type="checkbox" name="toujitu_shusseki2" value="<%=line.getEmployee_no() %>" <%if( bean.getToujitsuShusseki2(line.getEmployee_no() )!=null ){ %> checked="checked"  <%}%>  >
                            <input type="checkbox" name="toujitu_shusseki3" value="<%=line.getEmployee_no() %>" <%if( bean.getToujitsuShusseki3(line.getEmployee_no() )!=null ){ %> checked="checked"  <%}%>  >
                        </td>
                        <td class="noneLine">
                            <textarea  name="kesseki_jiyu" ></textarea>
                        </td>
                        <td><%=line.getEmployee_no() %></td>
                        <td><%=line.getEmployee_family_name() %> <%=line.getEmployee_first_name() %> </td>
                        <td class="altnoneLine"><%=line.getEmployee_family_name_kana() %> <%=line.getEmployee_first_name_kana() %> </td>
                        <td class="noneLine"><input type="text" name="genba_joucho_emp_no"> </td>
                        <td><%=line.getDept_name() %></td>
                        <td><%=(line.getPosition()==null)?"":line.getPosition() %></td>
                        <td class="altnoneLine"><%=line.getNenji() %></td>
                        <td><%=(line.getChuto_ninasinenji()==0)?"": line.getChuto_ninasinenji() %></td>
                        <td class="altnoneLine"><%=line.getEmail() %></td>
                        <td class="altnoneLine">'<%=line.getTel_no() %></td>
                        <td class="noneLine"><%=(line.getBiko()==null)?"":line.getBiko() %></td>
                    </tr>
                <%} %>
            </table>
        </div>
    </form>

</body>

</html>