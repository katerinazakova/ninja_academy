[#ftl]
<!DOCTYPE html>
<html lang="cz">
[#include "../_common/header.ftlh"]
<body>
<h1>Ninja Akademie pro děti</h1>
<h2>${kurz.nameCourse}</h2>
<div>${kurz.characteristic?no_esc}</div>
<div>Trenér: ${kurz.coach}</div>
<h3>Vypsané termíny kurzů na rok 2024:</h3>
<table>
    <thead>
    <tr>
        <th>Kurz</th>
        <th>Den</th>
        <th>Čas</th>
        <th>Věková skupina od</th>
    </tr>
    </thead>
    <tbody>
    [#list terminy as termin]
    <tr>
        <th>${kurz.nameCourse.title}</th>
        <th>${termin.dayCourse.title}</th>
        <th>${termin.timeCourseFrom} - ${termin.timeCourseTo}</th>
        <th>${termin.ageFrom} - ${termin.ageTo}</th>
        <th><a href="">Seznam kadetů</a></th>
    </tr>
    [/#list]
    </tbody>
</table>

</body>
</html>