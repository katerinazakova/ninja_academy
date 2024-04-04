[#ftl]
<!DOCTYPE html>
<html lang="cz">
[#include "../_common/header.ftlh"]
<body>
<h1>Ninja Akademie pro děti</h1>
[#list seznam as polozka]
    <ul>
        <li>${polozka.nameCourse.title} <a href="/detail/${polozka.id}">detail</a></li>
    </ul>
[/#list]

<img class= "uvodniFotoNinjaTurtles" src="/img/ninja_turtles.jpg" alt="ninja turtles">




</body>
</html>