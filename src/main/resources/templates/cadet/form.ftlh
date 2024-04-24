[#ftl]
<!DOCTYPE html>
<html lang="cz">
[#import "/spring.ftl" as spring]
[#include "../_common/header.ftlh"]
<body>
<h1>Ninja Akademie pro děti</h1>

<form class="cadet" method="post">
    <h2>Registrace na kurz</h2>
    <div class="row">
        <div class="col">
            <label class="form-label" for="firstName">Jméno:</label>
            <div>[@spring.formInput path="kadet.firstName"/]</div>
            <div class="error">[@spring.showErrors "<br>"/]</div>
        </div>
    </div>


    <div class="row">
        <label class="form-label" for="secondName" class="radek">Příjmení:</label>
        <div>[@spring.formInput path = "kadet.secondName" /]</div>
        <div class="error">[@spring.showErrors "<br>" /]</div>
    </div>

    <div class="row">
        <label class="form-label" for="birthDay">Datum narození:</label>
        <div class="input">[@spring.formInput path="kadet.birthDay" fieldType = "date" /]</div>
        <div class="error">[@spring.showErrors "<br>" /]</div>
    </div>

    <div class="kurz">
        <label class="form-label">Zvolený kurz: </label> <strong>${termin.nameCourse} ${termin.dayCourse} ${termin.timeCourseFrom}</strong>
    </div>


    <div class="row">
        <label class="form-label" for="nameParent">Jméno rodiče:</label>
        <div class="input">[@spring.formInput path="kadet.nameParent" /]</div>
        <div class="error">[@spring.showErrors "<br>" /]</div>
    </div>

    <div class="row">
        <label class="form-label" for="email">E-mail:</label>
        <div class="input">[@spring.formInput path="kadet.email" /]</div>
        <div class="error">[@spring.showErrors "<br>" /]</div>
    </div>
    <div class="row">
        <label class="form-label" for="phoneNumber">Telefon:</label>
        <div class="input">[@spring.formInput path="kadet.phoneNumber" /]</div>
        <div class="error">[@spring.showErrors "<br>" /]</div>

    </div>

    <div class="kurz">
        <label class="form-label" for="parentEscort">Doprovod rodičů při odchodu z kurzu:</label>
        <div class="doprovod">[@spring.formCheckbox path="kadet.parentEscort" /]</div>
        <div class="error">[@spring.showErrors "<br>" /]</div>
    </div>
    <button type="submit" class="btn btn-primary odeslat">odeslat</button>
</form>

</body>
</html>