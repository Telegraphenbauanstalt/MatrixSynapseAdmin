<#import "utils.ftl" as u>
<#-- @ftlvariable name="" type="nl.donkeysbreakfast.matrixsynapseadmin.resources.UserAdminUserView" -->
<#macro is_true p>
    <#if p == "1">
        WAHR
    <#else>
        FALSCH
    </#if>
</#macro>

<#assign endscript in u>
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
</#assign>

<@u.page title="User details ${userDetails.name}">
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
            <!-- basePath: ${basePath} -->

        </form>

</@u.page>
