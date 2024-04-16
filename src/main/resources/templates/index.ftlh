[#ftl]
<!DOCTYPE html>
<html lang="cz">
[#include "_common/header.ftlh"]
<body>
<h1>Ninja Akademie pro děti</h1>
<menu>
[#list kurzy as kurz]
    <a class="btn btn-outline-success" href="kurz/${kurz.id}">${kurz.nameCourse.title} </a>
[/#list]
</menu>

<img src="/img/ninja_turtles.jpg" alt="ninja_turtles">
<hr>
<footer class="paticka">
    @2024 ninja academy
</footer>
</body>
</html>