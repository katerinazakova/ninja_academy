[#ftl]
<!DOCTYPE html>
<html lang="cz">
[#import "/spring.ftl" as spring]
[#include "../_common/header.ftlh"]
<body>
<h1>Ninja Akademie pro děti</h1>
<h2>Rekapitulace přihlášky</h2>

<form class="formular" method="post">

    <table class="table table-bordered border-success" >
        <tbody>
        <tr>
            <th>Jméno:</th>
            <td>${kadet.firstName}</td>
        </tr>
        <tr>
            <th>Příjmení:</th>
            <td>${kadet.secondName}</td>
        </tr>
        <tr>
            <th>Datum narození:</th>
            <td>${kadet.birthDay}</td>
        </tr>

        <tr>
            <th>Název a termín kurzu:</th>
            <td>${kadet.nameCourse} dne ${kadet.dayCourse} v ${kadet.startTimeCourse} hod</td>
        </tr>
        <tr>
            <th>Jméno rodiče:</th>
            <td>${kadet.nameParent}</td>
        </tr>

        <tr>
            <th>E-mail:</th>
            <td>${kadet.email}</td>
        </tr>

        <tr>
            <th>Telefon:</th>
            <td>${kadet.phoneNumber}</td>
        </tr>

        <tr>
            <th>Doprovod rodiče:</th>
            <td> [#if kadet.parentEscort]
                    Ano
                [#else]
                    Ne
                [/#if]</td>
        </tr>

        </tbody>
    </table>
</form>
<form method="get" action="/editCadet/${kadet.id}">
    <button type="submit"  class="btn btn-success">upravit údaje</button>
</form>

</body>
</html>