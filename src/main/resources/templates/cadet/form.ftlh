[#ftl]
<!DOCTYPE html>
<html lang="cz">
[#import "/spring.ftl" as spring]
[#include "../_common/header.ftlh"]
<body>
<h1>Ninja Akademie pro děti</h1>
<h2>Registrace na kurz</h2>

<form method="post">

    <label class="radek" for="firstName">Jméno:</label>
    <div class="input">[@spring.formInput path="kadet.firstName" /]</div>
    <div class="error">[@spring.showErrors "<br>"/]</div>

     <label for="secondName" class="radek">Příjmení:</label>
    <div class="input">[@spring.formInput path = "kadet.secondName" /]</div>
    <div class="error">[@spring.showErrors "<br>" /]</div>


    <label class="radek" for="birthDay">Datum narození:</label>
    <div class="input">[@spring.formInput path="kadet.birthDay" fieldType = "date" /]</div>
    <div class="error">[@spring.showErrors "<br>" /]</div>

    <div>
    <label for="nameCourse" class="radek">Jméno vybraného kurzu:</label>
    <input class="input" id="nameCourse" name="nameCourse" value="${termin.nameCourse}" readonly="readonly"/>

    <label for="dayCourse" class="radek">Den kurzu:</label>
    <input class="input" id="dayCourse" name="dayCourse" value="${termin.dayCourse}" readonly="readonly"/>

    <label for="startTimeCourse" class="radek">Začátek kurzu v:</label>
    <input class="input" id="startTimeCourse" name="startTimeCourse" type="time" value="${termin.timeCourseFrom}" readonly="readonly"/>
    </div>

    <label class="row" for="nameParent">Jméno rodiče:</label>
    <div class="input">[@spring.formInput path="kadet.nameParent" /]</div>
    <div class="error">[@spring.showErrors "<br>" /]</div>

    <label class="row" for="email">E-mail:</label>
    <div class="input">[@spring.formInput path="kadet.email" /]</div>
    <div class="error">[@spring.showErrors "<br>" /]</div>

    <label class="row" for="phoneNumber">Telefon:</label>
    <div class="input">[@spring.formInput path="kadet.phoneNumber" /]</div>
    <div class="error">[@spring.showErrors "<br>" /]</div>

    <label class="row" for="parentEscort">Doprovod rodičů při odchodu z kurzu:</label>
    <div class="input">[@spring.formCheckbox path="kadet.parentEscort" /]</div>
    <div class="error">[@spring.showErrors "<br>" /]</div>

    <button type="submit">odeslat</button>
</form>

</body>
</html>