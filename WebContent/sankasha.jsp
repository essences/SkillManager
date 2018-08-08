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
    <form method="POST" name="searchForm" id="searchForm" action="KenshuList">

        <div class="searchTypeLine"></div>
        <div class="searchJoken-box">
                <br>
               <div class="searchJoken-input-box">
                <strong>実施研修ごと社員リスト</strong>
             </div>
             <p style="text-align: right">
                 <strong> 入力欄表示 ：</strong><input name="check_type" type="checkbox" onclick="changeCell('noneLine');">
                 <input type="submit" name="regist_shain_to_kenshu"
                     class="regist_shain_to_kenshu" id="regist_shain_to_kenshu_button" value="情報を更新"  >
            </p>
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

                    <th  class="altnoneLine">ふりがな</th>
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
                    <th class="searchResult-table-keiyakusaki-header">みなし年次</th>
                    <th class="searchResult-table-email-header">欠席理由</th>
                    <th class="noneLine">現場上長社員No.</th>
                    <th class="searchResult-table-name-header">現場上長氏名</th>
                    <th  class="altnoneLine">現場上長e-mail</th>
                    <th class="noneLine">中途入社対応</th>

                </tr>
                <%int i=1; for(vo.Kenshu_jukou_viewVo line: bean ){ %>
                    <tr class="">
                        <td><%= i++  %></td>
                        <td class="searchResult-table-detail-body">
                            <input type="button" class="detail-button" data-key="<%=line.getEmployee_no()  %>"></td>
                        <td> <%=line.getEmployee_no() %></td>
                        <td> <%=line.getEmployee_family_name() %><%=line.getEmployee_first_name() %> </td>
                        <td  class="altnoneLine"> <%=line.getEmployee_family_name_kana() %><%=line.getEmployee_first_name_kana() %> </td>
                        <td  class="altnoneLine"> <%=line.getEmail() %></td>
                        <td  class="altnoneLine"> '<%=line.getCell_tel_no() %></td>
                        <td  class="noneLine">
                            <input type="checkbox" name="is_kakunin1" value="<%=line.getEmployee_no() %>"
                                 <%if(line.getIs_kakunin1()==1 ){ %> checked="checked"  <%}%>  >
                            <%if(bean.getKaisaidate2()!=null){ %>
                                <input type="checkbox" name="is_kakunin2" value="<%=line.getEmployee_no() %>"
                                     <%if(line.getIs_kakunin2()==1 ){ %> checked="checked"  <%}%>  >
                            <%} %>
                            <%if(bean.getKaisaidate3()!=null){ %>
                                <input type="checkbox" name="is_kakunin3" value="<%=line.getEmployee_no() %>"
                                 <%if(line.getIs_kakunin3()==1 ){ %> checked="checked"  <%}%>  >
                            <%} %>
                        </td>
                        <td  class="noneLine">
                            <input type="checkbox" name="is_shusseki1" value="<%=line.getEmployee_no() %>"
                                 <%if(line.getIs_shusseki()==1 ){ %> checked="checked"  <%}%>  >
                            <%if(bean.getKaisaidate2()!=null){ %>
                                <input type="checkbox" name="is_shusseki2" value="<%=line.getEmployee_no() %>"
                                     <%if(line.getIs_shusseki2()==1 ){ %> checked="checked"  <%}%>  >
                            <%} %>
                            <%if(bean.getKaisaidate3()!=null){ %>
                                <input type="checkbox" name="is_shusseki3" value="<%=line.getEmployee_no() %>"
                                 <%if(line.getIs_shusseki3()==1 ){ %> checked="checked"  <%}%>  >
                            <%} %>
                        </td>
                        <td  class="altnoneLine">
                            <%=(line.getIs_shusseki()==1)?"◯":"☓" %><br>
                            <%=(bean.getKaisaidate2()==null)?"":(line.getIs_shusseki2()==1)?"◯":"☓" %><br>
                            <%=(bean.getKaisaidate3()==null)?"":(line.getIs_shusseki3()==1)?"◯":"☓" %>
                        </td>
                        <td  class="noneLine">
                            <input type="checkbox" name="is_shusseki" value="<%=line.getEmployee_no() %>"
                                 <%if(line.getIs_shusseki()==1 ){ %> checked="checked"  <%}%>  >
                            <%if(bean.getKaisaidate2()!=null){ %>
                                <input type="checkbox" name="is_shusseki" value="<%=line.getEmployee_no() %>"
                                     <%if(line.getIs_shusseki2()==1 ){ %> checked="checked"  <%}%>  >
                            <%} %>
                            <%if(bean.getKaisaidate3()!=null){ %>
                                <input type="checkbox" name="is_shusseki" value="<%=line.getEmployee_no() %>"
                                 <%if(line.getIs_shusseki3()==1 ){ %> checked="checked"  <%}%>  >
                            <%} %>
                        </td>
                        <td><%=line.getToujitu_nenji() %></td>
                        <td><%=line.getChuto_ninasinenji() %></td>

                        <td class="noneLine">
                            <textarea name="kessekiriyu">
                                <%=(line.getKessekiriyu()==null)?"":line.getKessekiriyu() %>
                            </textarea>
                        </td>
                        <td class="altnoneLine"><%=(line.getKessekiriyu()==null)?"":line.getKessekiriyu() %></td>
                        <td class="noneLine">
                           <input type="text"  name="genba_joucho_emp_no"
                              value ="<%=(line.getGenba_joucho_emp_no()==null)?"":line.getGenba_joucho_emp_no() %>" >
                        </td>
                        <td> <%=line.getEmployee_family_name_j() %><%=line.getEmployee_first_name_j() %> </td>
                        <td  class="altnoneLine"><%=line.getEmail_j() %></td>
                        <td  class="noneLine"><%=line.getBiko() %></td>

                    </tr>
                <%} %>
            </table>
        </div>
    </form>
</body>
</html>