<%@page import="vo.KenshumasterVo"%>
<%@page import="vo.Shainmaster_wo_retire_viewVo"%>
<%@ page language="java" import="java.util.*"
  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <jsp:useBean id="bean" class="bean.KenshuJissekiListBean" scope="request" />
  <!DOCTYPE html>
<html>
<head>
    <title>
    一覧画面
    </title>
    <link rel="stylesheet" type="text/css" href="./stylesheets/umi_search_list.css">
    <script type="text/javascript" src="./javascripts/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="./javascripts/umi_jukou_list.js"></script>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

    <script type="text/javascript" >
    $(function() {
        $('#yotei1').datepicker({dateFormat: 'yy-mm-dd'});
        $('#yotei2').datepicker({dateFormat: 'yy-mm-dd'});
        $('#yotei3').datepicker({dateFormat: 'yy-mm-dd'});

    });
    </script>

    <meta charset="UTF-8">
</head>

<body>
    <!-- 会社ロゴ -->
    <a href="/"><img src="./images/common/logo01.gif"></a>
            <form method="POST" name="searchForm1" id="searchForm" action="List">
            </form>
           <form method="POST" name="registForm" id="searchForm" action="RegistKenshu">

        <div class="searchTypeLine"></div>
        <div class="searchJoken-box">
            <input type="button" value="社員リストへ" onClick="document.searchForm1.submit()"><br>
            <strong>研修実績リスト</strong>
          <strong> 年度：</strong>
          <select name="searchNendo" id="searchNendo-name" class="searchNendo-name" onchange="submit(this.form)">
                <option value="ALL"   <%=(bean.getPrevSearchNendo().equals("ALL" ))? "selected":"" %>>すべて</option>
                <option value="2015"  <%=(bean.getPrevSearchNendo().equals("2015" ))? "selected":"" %> >2015</option>
                <option value="2016"   <%=(bean.getPrevSearchNendo().equals("2016" ))? "selected":"" %>>2016</option>
                <option value="2017"   <%=(bean.getPrevSearchNendo().equals("2017" ))? "selected":"" %>>2017</option>
                <option value="2018"   <%=(bean.getPrevSearchNendo().equals("2018" ))? "selected":"" %> >2018</option>
                <option value="2019"   <%=(bean.getPrevSearchNendo().equals("2019" ))? "selected":"" %>>2019</option>
                <option value="2020"   <%=(bean.getPrevSearchNendo().equals("2020" ))? "selected":"" %>>2020</option>
                <option value="2021"   <%=(bean.getPrevSearchNendo().equals("2021" ))? "selected":"" %>>2021</option>
                <option value="2022"   <%=(bean.getPrevSearchNendo().equals("2022" ))? "selected":"" %>>2022</option>
            </select>

            <hr>
            <table class="searchResult-table">
                <tr>
                    <td>研修タイプ</td>
                    <td>予定日付1</td>
                    <td>予定日付2</td>
                    <td>予定日付3</td>
                    <td>実施意図</td>
                    <td></td>
                </tr>
                <tr>
                    <td>
                        <div class="searchJoken-input-box">
                            <select name="kenshuMaster" id="kenshuMaster-name"  >
                            <%for( KenshumasterVo vo: bean.getKenshuMasterList()){ %>
                                <option value="<%=vo.getKenshumaster_id() %>"  > <%=vo.getTitle() %></option>
                            <%} %>
                            </select>
                        </div>
                    </td>
                    <td>
                              <input type="text"  name="yotei1" id="yotei1">
                    </td>
                    <td>
                              <input type="text"  name="yotei2" id="yotei2">
                    </td>
                    <td>
                              <input type="text"  name="yotei3" id="yotei3">
                    </td>
                    <td>
                              <input type="textarea	"  name="jisshi_ito" >
                    </td>
                    <td>
                        <input type="submit" name="toroku" class="search-button" id="searchButton" value="研修予定の登録"  >
                    </td>

                </tr>
        </table>
        </div>


        <div class="searchResult-box">
            <div class="searchResult-count-box">

                  検索結果<label id="searchResult-count"><%=bean.size() %></label>件です
            </div>
            <table class="searchResult-table">
                <tr>
                    <th class="searchResult-table-no-header">No.</th>
                    <th class="searchResult-table-detail-header">詳細</th>
                    <th class="searchResult-table-email-header">研修名</th>
                    <th class="searchResult-table-email-header">実施意図</th>
                    <th class="searchResult-table-name-header">予定日付</th>
                    <th class="searchResult-table-busho-header">実績日付</th>
                    <th class="searchResult-table-yakushoku-header">研修日数</th>
                    <th class="searchResult-table-busho-header">登録人数</th>
                    <th class="searchResult-table-keiyakusaki-header">講師名</th>
                    <th class="searchResult-table-email-header">研修会社</th>

                </tr>
                <%int i=1; for(vo.Kenshujisseki_viewVo line: bean ){ %>
                    <tr class="">
                        <td><%= i++  %></td>
                        <td class="searchResult-table-detail-body">
                            <input type="button" class="detail-button" data-key="<%=line.getKenshujisseki()  %>">

                        </td>
                        <td><%=line.getTitle() %></td>
                        <td><%=(line.getJisshi_ito()==null)?"":line.getJisshi_ito() %></td>
                        <td>
                            <%=line.getYoteidate() %><br>
                            <%=( line.getYoteidate2()==null)? "":line.getYoteidate2() %><br>
                            <%=( line.getYoteidate3()==null)? "":line.getYoteidate3() %>
                        </td>
                        <td>
                            <%=line.getKaisaidate() %><br>
                            <%=( line.getKaisaidate2()==null)? "":line.getKaisaidate2() %><br>
                            <%=( line.getKaisaidate3()==null)? "":line.getKaisaidate3() %>
                        </td>
                        <td><%=line.getNumdays() %></td>
                        <td><%=line.getCount() %></td>
                        <td><%=line.getKoushiname() %></td>
                        <td><%=line.getKoushicompany() %></td>
                    </tr>
                <%} %>
            </table>
        </div>
    </form>
</body>
</html>