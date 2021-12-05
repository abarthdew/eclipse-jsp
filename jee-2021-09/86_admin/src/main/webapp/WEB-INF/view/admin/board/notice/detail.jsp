<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
    <title>�ڵ� �������� ����� ���� �¶��� ���� �ý���</title>
    <meta charset="UTF-8">
    <title>�������׸��</title>

    <link href="/css/customer/layout.css" type="text/css" rel="stylesheet" />
    <style>
        #visual .content-container {
            height: inherit;
            display: flex;
            align-items: center;

            background: url("/images/mypage/visual.png") no-repeat center;
        }
    </style>
</head>

<body>
    <!-- header �κ� -->

    <header id="header">

        <div class="content-container">
            <!-- ---------------------------<header>--------------------------------------- -->

            <h1 id="logo">
                <a href="/index.html">
                    <img src="/images/logo.png" alt="����ó �¶���" />

                </a>
            </h1>

            <section>
                <h1 class="hidden">���</h1>

                <nav id="main-menu">
                    <h1>���θ޴�</h1>
                    <ul>
                        <li><a href="/guide">�н����̵�</a></li>

                        <li><a href="/course">���¼���</a></li>
                        <li><a href="/answeris/index">AnswerIs</a></li>
                    </ul>
                </nav>

                <div class="sub-menu">

                    <section id="search-form">
                        <h1>���°˻� ��</h1>
                        <form action="/course">
                            <fieldset>
                                <legend>�����˻��ʵ�</legend>
                                <label>�����˻�</label>
                                <input type="text" name="q" value="" />
                                <input type="submit" value="�˻�" />
                            </fieldset>
                        </form>
                    </section>

                    <nav id="acount-menu">
                        <h1 class="hidden">ȸ���޴�</h1>
                        <ul>
                            <li><a href="/index.html">HOME</a></li>



                            <li>
                                <form action="/logout" method="post">
                                    <input type="hidden" name="" value="" />
                                    <input type="submit" value="�α׾ƿ�"
                                        style="border:none;background: none;vertical-align: middle;font-size: 10px;color:#979797;font-weight: bold;" />

                                </form>
                            </li>

                            <li><a href="/member/agree">ȸ������</a></li>
                        </ul>
                    </nav>

                    <nav id="member-menu" class="linear-layout">
                        <h1 class="hidden">���޴�</h1>
                        <ul class="linear-layout">
                            <li><a href="/member/home"><img src="/images/txt-mypage.png" alt="����������" /></a></li>
                            <li><a href="/notice/list.html"><img src="/images/txt-customer.png" alt="������" /></a></li>
                        </ul>
                    </nav>

                </div>
            </section>

        </div>

    </header>

    <!-- --------------------------- <visual> --------------------------------------- -->
    <!-- visual �κ� -->

    <div id="visual">
        <div class="content-container"></div>
    </div>
    <!-- --------------------------- <body> --------------------------------------- -->
    <div id="body">
        <div class="content-container clearfix">

            <!-- --------------------------- aside --------------------------------------- -->
            <!-- aside �κ� -->


            <aside class="aside">
                <h1>ADMIN PAGE</h1>

                <nav class="menu text-menu first margin-top">
                    <h1>����������</h1>
                    <ul>
                        <li><a href="/admin/index.html">������Ȩ</a></li>
                        <li><a href="/teacher/index.html">������������</a></li>
                        <li><a href="/student/index.html">������������</a></li>
                    </ul>
                </nav>

                <nav class="menu text-menu">
                    <h1>�˸�����</h1>
                    <ul>
                        <li><a href="/admin/board/notice/list.html">��������</a></li>
                    </ul>
                </nav>

            </aside>
            <!-- --------------------------- main --------------------------------------- -->




            <main>
                <h2 class="main title">��������</h2>

                <div class="breadcrumb">
                    <h3 class="hidden">breadlet</h3>
                    <ul>
                        <li>home</li>
                        <li>������</li>
                        <li>��������</li>
                    </ul>
                </div>

                <div class="margin-top first">
                    <h3 class="hidden">�������� ����</h3>
                    <table class="table">
                        <tbody>
							<tr>
								<th>����</th>
								<td class="text-align-left text-indent text-strong text-orange" colspan="3">${ notice.title }</td>
							</tr>
							<tr>
								<th>�ۼ���</th>
								<td class="text-align-left text-indent" colspan="3">
									<fmt:formatDate pattern="YYYY-MM-DD hh:mm:ss" value="${ notice.regdate }"></fmt:formatDate>
								</td>
							</tr>
							<tr>
								<th>�ۼ���</th>
								<td>${ notice.writer }</td>
								<th>��ȸ��</th>
								<td>
									<fmt:formatNumber value="${ notice.hit }" /><br/>
									<fmt:formatNumber type="number" pattern="##,####$" value="${ notice.hit }" />
								</td>
							</tr>
							<tr>
								<th>÷������</th>
								<td colspan="3">
									<c:forTokens var="fileName" items="${notice.files }" delims="," varStatus="st">
										<a href="${fileName }">${fileName }</a>
										<c:if test="${!st.last }">/</c:if>
									</c:forTokens>
								</td>
							</tr>
							<tr class="content">
								<td colspan="4"><div><br></div><div>${ notice.content }</div><div><br></div><div><a href="http://www.newlecture.com/resource/spring2.zip"><b><u><font size="5" color="#dd8a00">���� �ٿ�ε��ϱ�</font></u></b></a></div><div><br></div><div><br></div></td>
							</tr>
                        </tbody>
                    </table>
                </div>

                <div class="margin-top text-align-center">
                    <a class="btn-text btn-cancel" href="list">���</a>
                    <a class="btn-text btn-default" href="edit">����</a>
                    <a class="btn-text btn-default" href="del">����</a>
                </div>

                <div class="margin-top">
                    <table class="table border-top-default">
                        <tbody>
                            <tr>
                                <th>������</th>
                                <td colspan="3" class="text-align-left text-indent">�������� �����ϴ�.</td>
                            </tr>
                            <tr>
                                <th>������</th>
                                <td colspan="3" class="text-align-left text-indent"><a class="text-blue text-strong"
                                        href="">������ DI ���� �ڵ�</a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </main>

        </div>
    </div>

    <!-- ------------------- <footer> --------------------------------------- -->



    <footer id="footer">
        <div class="content-container">
            <h2 id="footer-logo"><img src="/images/logo-footer.png" alt="ȸ������"></h2>

            <div id="company-info">
                <dl>
                    <dt>�ּ�:</dt>
                    <dd>����Ư���� </dd>
                    <dt>�����ڸ���:</dt>
                    <dd>admin@newlecture.com</dd>
                </dl>
                <dl>
                    <dt>����� ��Ϲ�ȣ:</dt>
                    <dd>111-11-11111</dd>
                    <dt>��� �Ǹž�:</dt>
                    <dd>�Ű��� 1111 ȣ</dd>
                </dl>
                <dl>
                    <dt>��ȣ:</dt>
                    <dd>����ó</dd>
                    <dt>��ǥ:</dt>
                    <dd>ȫ�浿</dd>
                    <dt>��ȭ��ȣ:</dt>
                    <dd>111-1111-1111</dd>
                </dl>
                <div id="copyright" class="margin-top">Copyright �� newlecture.com 2012-2014 All Right Reserved.
                    Contact admin@newlecture.com for more information</div>
            </div>
        </div>
    </footer>
</body>

</html>