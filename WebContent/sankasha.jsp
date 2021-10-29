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

<body onload="init();">
    <!-- 会社ロゴ -->
    <a href="/"><img src="./images/common/logo01.gif"></a>
    <form method="POST"" name="KenshuListForm" id="KenshuListForm" action="KenshuList">
    </form>

    <form method="POST" name="searchForm" id="searchForm" action="Sankasha">
    <input type="hidden"  name="KENSHUJISSEKIID"  value="<%=bean.getKenshujissekiid() %>" >
        <div class="searchTypeLine"></div>
        <div class="searchJoken-box">
            <input type="button" value="研修リストへ" onClick="document.KenshuListForm.submit()"><br>

                <br>
               <div class="searchJoken-input-box">
                <strong>実施研修ごと社員リスト</strong>
             </div>
            <div class="searchJoken-button-box">
                <input type="button" name="clear" id="searchButton" value="チェックボックスクリア"  onclick="allcheckfalse();">
                <input type="button" name="allcheck" id="searchButton" value="オールチェック"  onclick="allchecktrue2();">
             <p style="text-align: right">
                 <strong> 入力欄表示 ：</strong><input name="check_type" type="checkbox" onclick="changeCell('noneLine');">
                 <input type="submit" name="regist_shain_to_kenshu"
                     class="regist_shain_to_kenshu" id="regist_shain_to_kenshu_button" value="情報を更新"
                     onclick='return confirm("このリストを本当に更新しますか？");' >
            </p>
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
                    <th   class="altnoneLine">詳細</th>
                    <th  class="noneLine">削除チェック</th>
                    <th class="searchResult-table-no-header">社員ID</th>
                    <th class="searchResult-table-name-header">氏名</th>

                    <th  class="altnoneLine">ふりがな</th>
                    <th  class="altnoneLine">事業本部</th>
                    <th  class="altnoneLine">役職</th>
                    <th  class="altnoneLine">中途</th>                    
                    <th  class="altnoneLine">e-mail</th>
                     <th  class="altnoneLine">tell</th>
                    <th class="noneLine">
                            事前出欠確認<br>
                            <%=bean.getKaisaidate() %><br>
                            <%=(bean.getKaisaidate2()==null)?"":bean.getKaisaidate2() %><br>
                            <%=(bean.getKaisaidate3()==null)?"":bean.getKaisaidate3() %>
                    </th>
                    <th class="searchResult-table-busho-header">
                            出欠実績<br>
                            <%=bean.getKaisaidate() %><br>
                            <%=(bean.getKaisaidate2()==null)?"":bean.getKaisaidate2() %><br>
                            <%=(bean.getKaisaidate3()==null)?"":bean.getKaisaidate3() %>
                    </th>
                    <th class="searchResult-table-keiyakusaki-header">受講時年次</th>
                    <th class="searchResult-table-email-header">欠席理由</th>
                    <th class="noneLine">中途入社対応</th>

                </tr>
                <%int i=1; for(vo.Kenshu_jukou_viewVo line: bean ){ %>
                    <tr class="">
                        <td><%= i++  %>
                         <input type="hidden" name="hidden_kenshujukouid" value="<%=line.getKenshujukouid() %>">
                        </td>
                        <td  class="altnoneLine">
                            <input type="button" class="detail-button" data-key="<%=line.getEmployee_no()  %>">
                        </td>
                        <td  class="noneLine">
                            <input type="checkbox"   name="deleleCkecbox"  value="<%=line.getKenshujukouid() %>">
                        </td>

                        <td> <%=line.getEmployee_no() %></td>

                        <td> <%=line.getEmployee_family_name() %><%=line.getEmployee_first_name() %> </td>
                        <td  class="altnoneLine"> <%=line.getEmployee_family_name_kana() %><%=line.getEmployee_first_name_kana() %> </td>
                        <td  class="altnoneLine"> <%=( line.getGroup_name()==null || line.getGroup_name().equals(""))?line.getDept_name():line.getGroup_name()  %></td>
                        <td  class="altnoneLine"> <%=(line.getPosition()==null)?"":line.getPosition() %></td>
                        <td  class="altnoneLine"> <%=(line.getMid_career_flg().equals("0"))?"":"中途" %></td> 
                        <td  class="altnoneLine"> <%=line.getEmail() %></td>
                        <td  class="altnoneLine"> '<%=line.getCell_tel_no() %></td>
                        <td  class="noneLine">
                            <input type="checkbox" name="is_kakunin1" value="<%=line.getKenshujukouid() %>"
                                 <%if(line.getIs_kakunin1()==1 ){ %> checked="checked"  <%}%>  >
                            <%if(bean.getKaisaidate2()!=null){ %>
                                <input type="checkbox" name="is_kakunin2" value="<%=line.getKenshujukouid() %>"
                                     <%if(line.getIs_kakunin2()==1 ){ %> checked="checked"  <%}%>  >
                            <%} %>
                            <%if(bean.getKaisaidate3()!=null){ %>
                                <input type="checkbox" name="is_kakunin3" value="<%=line.getKenshujukouid() %>"
                                 <%if(line.getIs_kakunin3()==1 ){ %> checked="checked"  <%}%>  >
                            <%} %>
                        </td>

                        <td  class="altnoneLine">
                            <%=(line.getIs_shusseki()==1)?"◯":"☓" %>
                            <%=(bean.getKaisaidate2()==null)?"":(line.getIs_shusseki2()==1)?"◯":"☓" %>
                            <%=(bean.getKaisaidate3()==null)?"":(line.getIs_shusseki3()==1)?"◯":"☓" %>
                        </td>
                        <td  class="noneLine">
                            <input type="checkbox" name="is_shusseki" value="<%=line.getKenshujukouid() %>"
                                 <%if(line.getIs_shusseki()==1 ){ %> checked="checked"  <%}%>  >
                            <%if(bean.getKaisaidate2()!=null){ %>
                                <input type="checkbox" name="is_shusseki2" value="<%=line.getKenshujukouid() %>"
                                     <%if(line.getIs_shusseki2()==1 ){ %> checked="checked"  <%}%>  >
                            <%} %>
                            <%if(bean.getKaisaidate3()!=null){ %>
                                <input type="checkbox" name="is_shusseki3" value="<%=line.getKenshujukouid() %>"
                                 <%if(line.getIs_shusseki3()==1 ){ %> checked="checked"  <%}%>  >
                            <%} %>
                        </td>
                        <td><%=line.getToujitu_nenji() %></td>

                        <td class="noneLine">
                            <textarea name="kessekiriyu"><%=(line.getKessekiriyu()==null)?"":line.getKessekiriyu() %></textarea>
                        </td>
                        <td class="altnoneLine"><%=(line.getKessekiriyu()==null)?"":line.getKessekiriyu() %></td>
                        <td  class="noneLine"><%=(line.getBiko()==null)?"":line.getBiko() %></td>

                    </tr>
                <%} %>
            </table>
        </div>
    </form>
</body>
</html>