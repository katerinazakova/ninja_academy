[#ftl]
<!DOCTYPE html>
<html lang="cz">
[#include "_common/header.ftlh"]
<body>
<h1>Ninja Akademie pro děti</h1>
[#list kurzy as kurz]
    <ul>
        <li>${kurz.nameCourse.title} <a class="link-warning link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover" href="kurz/${kurz.id}"> <strong>detail</strong></a></li>
    </ul>
[/#list]
<a href="/kadet"><button type="button" class="btn btn-success">Registrace na kurz</button></a>

<img src="/img/ninja_turtles.jpg" alt="ninja_turtles">

</body>
</html>