[#ftl]
<!DOCTYPE html>
<html lang="cz">
[#include "../_common/header.ftlh"]
<body>
<h1>Ninja Akademie pro děti</h1>
<h3>Obsazenost kurzu</h3>
<table>
    <thead>
    <tr>
        <th>Jméno</th>
        <th>Příjmení</th>
    </tr>
    </thead>
    <tbody>

    [#list kadeti as kadet]
        <tr>
        <td>${kadet.firstName}</td>
        <td>${kadet.secondName}</td>
        </tr>
    [/#list]

    </tbody>
</table>


</body>
</html>