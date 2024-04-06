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
    <div class="input">[@spring.formInput path="kadet.firstName" /]</div>
    <div class="error">[@spring.showErrors "<br>"/]</div>

    <label for="secondName" class="radek">Příjmení:</label>
    <div class="input">[@spring.formInput path = "kadet.secondName" /]</div>
    <div class="error">[@spring.showErrors "<br>" /]</div>

    <label class="radek" for="birthDay">Datum narození:</label>
    <div class="input">[@spring.formInput path="kadet.birthDay" fieldType = "date" /]</div>
    <div class="error">[@spring.showErrors "<br>" /]</div>
    <div> Název a termín kurzu:</div>
    <div class="radio">

        <label for="nameCourse1">taekwon-do</label>
        <input id="nameCourse1" type="radio" name="nameCourse" value="TAEKWONDO">

        <label for="nameCourse2">kickbox</label>
        <input id="nameCourse2" type="radio" name="nameCourse" value="KICKBOX">

        <label for="nameCourse3">gymnastika</label>
        <input id="nameCourse3" type="radio" name="nameCourse" value="GYMNASTIKA">

        <label for="nameCourse4">krav maga</label>
        <input id="nameCourse4" type="radio" name="nameCourse" value="KRAVMAGA">

        [@spring.bind "kadet.nameCourse"/]
        <div class="error">[@spring.showErrors "<br>"/]</div>
    </div>
    <div class="radio"> den kurzu:
        <label for="dayCourse1">po</label>
        <input id="dayCourse1" type="radio" name="dayCourse" value="PO"/>
        <label for="dayCourse2">út</label>
        <input id="dayCourse2" type="radio" name="dayCourse" value="ÚT"/>
        <label for="dayCourse3">st</label>
        <input id="dayCourse3" type="radio" name="dayCourse" value="ST"/>
        <label for="dayCourse4">čt</label>
        <input id="dayCourse4" type="radio" name="dayCourse" value="CT"/>
        <label for="dayCourse5">pá</label>
        <input id="dayCourse5" type="radio" name="dayCourse" value="PA"/>
        [@spring.bind "kadet.dayCourse"/]
        <div class="error">[@spring.showErrors "<br" /]</div>
    </div>

    <div class="radio"> začátek kurzu v:
        <label for="time1">15:00</label>
        <input id="time1" type="radio" name="startTimeCourse" value="15:00" />
        <label for="time2">16:00</label>
        <input id="time2" type="radio" name="startTimeCourse" value="16:00" />
        <label for="time3">17:00</label>
        <input id="time3" type="radio" name="startTimeCourse" value="17:00" />
        <label for="time4">18:00</label>
        <input id="time4" type="radio" name="startTimeCourse" value="18:00" />

        [@spring.bind "kadet.startTimeCourse"/]
        <div class="error">[@spring.showErrors "<br" /]</div>
    </div>




    <label class="row" for="nameParent">Jméno rodiče:</label>
    <div class="input">[@spring.formInput path="kadet.nameParent" /]</div>
    <div class="error">[@spring.showErrors "<br" /]</div>

    <label class="row" for="email">E-mail:</label>
    <div class="input">[@spring.formInput path="kadet.email" /]</div>
    <div class="error">[@spring.showErrors "<br" /]</div>

    <label class="row" for="phoneNumber">Telefon:</label>
    <div class="input">[@spring.formInput path="kadet.phoneNumber" /]</div>
    <div class="error">[@spring.showErrors "<br" /]</div>

    <label class="row" for="parentEscort">Doprovod rodičů při odchodu z kurzu:</label>
    <div class="input">[@spring.formCheckbox path="kadet.parentEscort" /]</div>
    <div class="error">[@spring.showErrors "<br" /]</div>

    <button type="submit">odeslat</button>
</form>

</body>
</html>