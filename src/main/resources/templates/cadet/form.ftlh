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
    <div> Název kurzu:</div>
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

    <div class="form-group">
        <label for="dateCourse" class="radek">Termín kurzu</label>
        <div class="input">[@spring.formSingleSelect path="kadet.dateCourse" options={
            "1": "taekwon-do pondělí 15:00 - 16:00",
            "2": "taekwon-do pondělí 16:00 - 17:00",
            "3": "taekwon-do pondělí 17:00 - 18:00",
            "4":"taekwon-do středa 17:00 - 18:00",
            "5":"kickbox úterý 16:00 - 17:00",
            "6": "kickbox úterý 17:00 - 18:00",
            "7": "kickbox čtvrtek 18:00 - 19:00",
            "8": "krav maga středa 16:00 - 17:00",
            "9": "krav maga čtvrtek 17:00 - 18:00",
            "10": "krav maga pátek 17:00 - 18:00",
            "11": "gymnastika pátek 15:00 - 16:00",
            "12": "gymnastika středa 15:00 - 16:00",
            "13": "gymnastika pátek 16:00 - 17:00",
            "14": "gymnastika středa 16:00 - 17:00"
            }
            /]</div>

    </div>
    <div class="error">[@spring.showErrors "<br>"/]</div>

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