<#-- @ftlvariable name="" type="nl.donkeysbreakfast.matrixsynapseadmin.resources.UserAdminUserView" -->
<#macro is_true p>
    <#if p == "1">
        WAHR
    <#else>
        FALSCH
    </#if>
</#macro>
<!DOCTYPE html>
<html>
    <head>
        <title>User ${userDetails.name}</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="/admin/bootstrap-4.4.1-dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="/admin/momentjs/moment-with-locales.min.js"></script>
    </head>
    <body>
        <div class="container">

        <#-- ruft getUser() auf -->
        <h1>User ${userDetails.name}</h1>

        <form>
            <div class="form-group">
                <label for="userName">User ID</label>
                <input type="text" class="form-control" id="userName" value="${userDetails.name}" readonly="readonly"/>
            </div>
            <div class="form-group"> <!-- UserDetails -->
                <label for="userDisplayname">Anzeigename</label>
                <input type="text" class="form-control" id="userDisplayname" value="${userDetails.displayname}" readonly="readonly"/>
            </div>
            <div class="form-group">
                <label for="userPasswordHash">Password Hash</label>
                <input type="text" class="form-control" id="userPasswordHash" value="${userDetails.passwordHash}" readonly="readonly"/>
            </div>
            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="userGuest" <#if userDetails.guest == 1>checked="checked"</#if> disabled="disabled">
                <label for="userGuest">Gast</label>
            </div>
            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="userAdmin" <#if userDetails.admin == 1>checked="checked"</#if> disabled="disabled">
                <label for="userAdmin">Admin</label>
            </div>
            <div class="form-group form-check">
                <input type="checkbox" class="form-check-input" id="userDeactivated" <#if userDetails.deactivated == 1>checked="checked"</#if> disabled="disabled">
                <label for="userDeactivated">Deaktiviert</label>
            </div>

            <div class="form-group"> <!-- UserDetails -->
                <label for="userConsentVersion">consentVersion</label>
                <#-- Default Leerstring für Nullwerte! siehe https://freemarker.apache.org/docs/dgui_template_exp.html#dgui_template_exp_missing -->
                <input type="text" class="form-control" id="userConsentVersion" value="${userDetails.consentVersion!}" readonly="readonly"/>
            </div>
            <div class="form-group"> <!-- UserDetails -->
                <label for="userConsentServerNoticeSent">consentServerNoticeSent</label>
                <input type="text" class="form-control" id="userConsentServerNoticeSent" value="${userDetails.consentServerNoticeSent!}" readonly="readonly"/>
            </div>
            <div class="form-group"> <!-- UserDetails -->
                <label for="userAppserviceId">appserviceId</label>
                <input type="text" class="form-control" id="userAppserviceId" value="${userDetails.appserviceId!}" readonly="readonly"/>
            </div>
            <div class="form-group"> <!-- UserDetails -->
                <label for="userCreationTs">creationTs</label>
                <input type="text" class="form-control" id="userCreationTs" value="${userDetails.creationTs}" readonly="readonly"/>
            </div>
            <div class="form-group"> <!-- UserDetails -->
                <label for="userAvatarUrl">avatarUrl</label>
                <input type="text" class="form-control" id="userAvatarUrl" value="${userDetails.avatarUrl!}" readonly="readonly"/>
            </div>

            <!-- TODO: if INPUT - submit Button -->

        </form>

        </div>

        <script src="/admin/jquery/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="/admin/popper.js-1.16.0/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="/admin/bootstrap-4.4.1-dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

        <script>
$(document).ready(function(){
    //console.log('language: ' + navigator.language);
    //console.log('locale: ' + moment.locale());
    moment.locale(navigator.language);
    //console.log('locale: ' + moment.locale());
    //console.log("${userDetails.creationTs?c}"); <#-- built-in number for computers -->
    //console.log(moment((${userDetails.creationTs?c} * 1000)).format());
    $("#userCreationTs").val(moment((${userDetails.creationTs?c} * 1000)).fromNow() + ' (' + moment((${userDetails.creationTs?c} * 1000)).format() + ')');
});
        </script>
    </body>
</html>
