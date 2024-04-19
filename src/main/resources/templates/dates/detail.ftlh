[#ftl]
<!DOCTYPE html>
<html lang="cz">
[#include "../_common/header.ftlh"]
<body>
<h1>Ninja Akademie pro děti</h1>
<h3>Obsazenost kurzu ${termin.nameCourse.title}:</h3>
<table class="table table-sm">
    <thead>
    <tr>
        <th></th>
        <th>Jméno</th>
        <th>Příjmení</th>
    </tr>
    </thead>
    <tbody>

    [#list kadeti as kadet]
        <tr>
            <td>${kadet?counter}</td>
            <td>${kadet.firstName}</td>
            <td>${kadet.secondName}</td>
        </tr>
    [/#list]

    </tbody>
</table>
<a class="btn btn-warning" href="/kurz/${termin.course.id}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 16 16">
        <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8"/>
    </svg></a>
</body>
</html>