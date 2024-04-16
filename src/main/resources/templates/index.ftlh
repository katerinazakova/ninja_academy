[#ftl]
<!DOCTYPE html>
<html lang="cz">
[#include "_common/header.ftlh"]
<body>
<h1>Ninja Akademie pro děti</h1>
<menu>
[#list kurzy as kurz]
    <a class="btn btn-outline-success" href="kurz/${kurz.id}"><strong>${kurz.nameCourse.title}</strong></a>
[/#list]
</menu>

<img src="/img/ninja_turtles.jpg" alt="ninja_turtles">
<hr>
<footer class="text-success">
    <strong>@2024 ninja academy</strong>
</footer>
</body>
</html>