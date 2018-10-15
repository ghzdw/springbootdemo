<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>添加雇员页面</title>
    <script src="/webjars/jquery/3.3.1/jquery.js"></script>
</head>
<body>
    <div>
        <#include "common/left.ftl">
        <div id="right">
              <form action="emp" method="post">
                  <section>
                      姓名:<input type="text" name="emp_name">
                  </section>
                  <section>
                      入职日期:<input type="text" name="join_date">
                  </section>
                  <section>
                      薪水:<input type="text" name="salary">
                  </section>
            <input type="submit" value="提交">
              </form>
        </div>
    </div>
</body>
</html>