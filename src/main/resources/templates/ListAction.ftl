<!DOCTYPE html PUBLIC "-//W4C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<#assign rcPath =(springMacroRequestContext.getContextPath())>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
    <title>内容列表页面</title>
    <link href="/css/all.css" rel="stylesheet" type="text/css" />
    <script src="/Js/common/jquery-1.8.0.min.js" type="text/javascript"></script>
    <script src="/Js/ListAction.js" type="text/javascript"></script>
</head>
<body style="background: #e1e9eb;">
<h1>${rcPath}</h1>
<form action="/ListAction" id="mainForm" method="post">
    <div class="right">
        <div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容列表</div>
        <div class="rightCont">
            <p class="g_title fix">内容列表 <a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03" href="javascript:DeleteBatch();">删 除</a></p>
            <table class="tab1">
                <tbody>
                <tr>
                    <td width="90" align="right">指令名称：</td>
                    <td>
                        <input name="command" type="text" class="allInput" value="${command!}"/>
                    </td>
                    <td width="90" align="right">描述：</td>
                    <td>
                        <input name="description" type="text" class="allInput" value="${description!}"/>
                    </td>
                    <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
                </tr>
                </tbody>
            </table>
            <div class="zixun fix">
                <table class="tab2" width="100%">
                    <tbody>
                    <tr>
                        <th><input type="checkbox" id="all" onclick="#"/></th>
                        <th>序号</th>
                        <th>指令名称</th>
                        <th>描述</th>
                        <th>操作</th>
                    </tr>
                    <#list ListMessage as mes>
                        <#if mes_index%2==1>
                    <tr style="background-color:#ECF6EE;">
                        <#else>
                    <tr>
                        </#if>

                        <td><input type="checkbox" name="Id" value="${mes.id}"/></td>
                        <td>${mes_index}</td>
                        <td>${mes.command}</td>
                        <td>${mes.description}</td>
                        <td>
                            <a href="#">修改</a>&nbsp;&nbsp;&nbsp;
                            <a href="/DeleteOneAction?Id=${mes.id}">删除</a>
                        </td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
                <div class='page fix'>
                    共 <b>${ListSize}</b> 条
                    <a href='###' class='first'>首页</a>
                    <a href='###' class='pre'>上一页</a>
                    当前第<span>1/1</span>页
                    <a href='###' class='next'>下一页</a>
                    <a href='###' class='last'>末页</a>
                    跳至&nbsp;<input type='text' value='1' class='allInput w28' />&nbsp;页&nbsp;
                    <a href='###' class='go'>GO</a>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>