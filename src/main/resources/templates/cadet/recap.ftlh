[#ftl]
<!DOCTYPE html>
<html lang="cz">
[#import "/spring.ftl" as spring]
[#include "../_common/header.ftlh"]
<body>
<h1>Ninja Akademie pro děti</h1>
<h2>Seznam kurzů</h2>

<form class="formular" method="post" action="/kadet">

    <label class="radek" for="firstName">Jméno:</label>
    <input id="firstName" name="firstName" type="text" value="${kadet.firstName}" readonly="readonly"/>

    <label for="secondName" class="radek">Příjmení:</label>
    <input id="secondName" name="secondName" type="text" value="${kadet.secondName}" readonly="readonly"/>

    <label class="radek" for="birthDay">Datum narození:</label>
    <input id="birthDay" name="birthDay" type="date" value="${kadet.birthDay}" readonly="readonly"/>
    <div> Název kurzu:</div>
    <div class="form-group">
        <div class="skupina"><label>${kadet.nameCourse}</label></div>
    </div>

    <div class="form-group">Termín kurzu:</div>
    <div>
        [#if kadet.dateCourse == "1"]
            taekwon-do pondělí 15:00 - 16:00
        [#elseif kadet.dateCourse == "2"]
            taekwon-do pondělí 16:00 - 17:00
        [#elseif kadet.dateCourse == "3"]
            taekwon-do pondělí 17:00 - 18:00
        [#elseif kadet.dateCourse == "4"]
            taekwon-do středa 17:00 - 18:00
        [#elseif kadet.dateCourse == "5"]
            kickbox úterý 16:00 - 17:00
        [#elseif kadet.dateCourse == "6"]
            kickbox úterý 17:00 - 18:00
        [#elseif kadet.dateCourse == "7"]
            kickbox čtvrtek 18:00 - 19:00
        [#elseif kadet.dateCourse == "8"]
            krav maga středa 16:00 - 17:00
        [#elseif kadet.dateCourse == "9"]
            krav maga čtvrtek 17:00 - 18:00
        [#elseif kadet.dateCourse == "10"]
            krav maga pátek 17:00 - 18:00
        [#elseif kadet.dateCourse == "11"]
            gymnastika pátek 15:00 - 16:00
        [#elseif kadet.dateCourse == "12"]
            gymnastika středa 15:00 - 16:00
        [#elseif kadet.dateCourse == "13"]
            gymnastika pátek 16:00 - 17:00
        [#elseif kadet.dateCourse == "14"]
            gymnastika středa 16:00 - 17:00
        [/#if]
    </div>


    <label class="row" for="nameParent">Jméno rodiče:</label>
    <input id="nameParent" name="nameParent" type="text" value="${kadet.nameParent}" readonly="readonly"/>

    <label class="row" for="email">E-mail:</label>
    <input id="email" name="email" type="email" value="${kadet.email}" readonly="readonly"/>

    <label class="row" for="phoneNumber">Telefon:</label>
    <input id="phoneNumber" name="phoneNumber" type="tel" value="${kadet.phoneNumber}" readonly="readonly"/>

</form>

</body>
</html>