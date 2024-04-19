[#ftl]
<!DOCTYPE html>
<html lang="cz">
[#include "../_common/header.ftlh"]
<body>
<h1>Ninja Akademie pro děti</h1>
<h2 class="text-success">${kurz.nameCourse}</h2>
<div>${kurz.characteristic?no_esc}</div>
<div><strong>Trenér: ${kurz.coach}</strong></div>

<h4 class="text-success">Vypsané termíny v roce 2024:</h4>

<table class="table table-sm">
    <thead>
    <tr class ="tabulka_radek">
        <th>Kurz</th>
        <th>Den</th>
        <th>Čas</th>
        <th>Věková kategorie</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    [#list terminy as termin]
    <tr class = "tabulka_radek">
        <td>${termin.nameCourse.title}</td>
        <td>${termin.dayCourse.title}</td>
        <td>${termin.timeCourseFrom} - ${termin.timeCourseTo}</td>
        <td>${termin.ageFrom} - ${termin.ageTo}</td>
        <td><a class="link-success link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover" href="/obsazenost/${termin.id}">obsazenost kurzu</a></td>
        <td><a class="btn btn-success" href="/termin/${termin.id}">Registrace na kurz</a></td>
    </tr>
    [/#list]
    </tbody>
</table>
<a class="btn btn-danger" href="/"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
        <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5"/>
    </svg></a>

</body>
</html>