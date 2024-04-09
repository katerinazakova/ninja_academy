[#ftl]
<!DOCTYPE html>
<html lang="cz">
[#include "../_common/header.ftlh"]
<body>
<h1>Ninja Akademie pro děti</h1>
<h2>${kurz.nameCourse}</h2>
<div>${kurz.characteristic?no_esc}</div>
<div><strong>Trenér: ${kurz.coach}</strong></div>
<h4>Vypsané termíny v roce 2024:</h4>
<table>
    <thead>
    <tr>
        <th>Kurz</th>
        <th></th>
        <th>Den</th>
        <th>Čas</th>
        <th>Věková kategorie</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    [#list terminy as termin]
    <tr>
        <th>${kurz.nameCourse.title}</th>
        <th>${termin.dayCourse.title}</th>
        <th>${termin.timeCourseFrom} - ${termin.timeCourseTo}</th>
        <th>${termin.ageFrom} - ${termin.ageTo}</th>
        <th></th>
        <th><a href="/termin/${termin.id}">obsazenost kurzu</a></th>
    </tr>
    [/#list]
    </tbody>
</table>
<a href="/kadet">Registrace na kurz</a>
</body>
</html>