[#ftl]
<!DOCTYPE html>
<html lang="cz">
[#include "_common/header.ftlh"]
<body>
<h1>Ninja Akademie pro děti</h1>
[#list kurzy as kurz]
    <ul>
        <li>${kurz.nameCourse.title} <a href="kurz/${kurz.id}">detail</a></li>
    </ul>
[/#list]
<a href="/kadet">Registrace na kurz</a>

<img class= "uvodniFotoNinjaTurtles" src="/img/ninja_turtles.jpg" alt="ninja turtles">




</body>
</html>