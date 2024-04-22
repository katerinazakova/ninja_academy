[#ftl]
<!DOCTYPE html>
<html lang="cz">
[#import "/spring.ftl" as spring]
[#include "../_common/header.ftlh"]
<body>
<h1>Ninja Akademie pro děti</h1>
<h2>Seznam kurzů</h2>

<form class="formular" method="post" action="/kadet/${kadet.date.id}">

    <label class="radek" for="firstName">Jméno:</label>
    <input id="firstName" name="firstName" type="text" value="${kadet.firstName}" readonly="readonly"/>

    <label for="secondName" class="radek">Příjmení:</label>
    <input id="secondName" name="secondName" type="text" value="${kadet.secondName}" readonly="readonly"/>

    <label class="radek" for="birthDay">Datum narození:</label>
    <input id="birthDay" name="birthDay" type="date" value="${kadet.birthDay}" readonly="readonly"/>
    <div> Název a termín kurzu:</div>
    <div class="form-group">
        <div class="skupina"><label>${kadet.nameCourse}${kadet.dayCourse}${kadet.startTimeCourse}</label></div>
    </div>
    
    <label class="row" for="nameParent">Jméno rodiče:</label>
    <input id="nameParent" name="nameParent" type="text" value="${kadet.nameParent}" readonly="readonly"/>

    <label class="row" for="email">E-mail:</label>
    <input id="email" name="email" type="email" value="${kadet.email}" readonly="readonly"/>

    <label class="row" for="phoneNumber">Telefon:</label>
    <input id="phoneNumber" name="phoneNumber" type="tel" value="${kadet.phoneNumber}" readonly="readonly"/>

<div>Doprovod rodičů po zkončení kurzu:
    [#if kadet.parentEscort]
        <p>Ano</p>
    [#else]
        <p>Ne</p>
    [/#if]
</div>

</form>

</body>
</html>