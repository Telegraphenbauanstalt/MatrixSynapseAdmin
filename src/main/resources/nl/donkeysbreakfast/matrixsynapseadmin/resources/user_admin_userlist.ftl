<#-- @ftlvariable name="" type="nl.donkeysbreakfast.matrixsynapseadmin.resources.UserAdminView" -->
<#macro is_true p>
    <#if p == "1">
        WAHR
    <#else>
        FALSCH
    </#if>
</#macro>
<!DOCTYPE html>
<html>
    <body>
        <#-- ruft getUsers() auf -->
        <h1>User Liste</h1>
        <table>
            <tr><th>Name</th><th>Gast</th><th>Admin</th><th>Deaktiviert</th></tr>
        <#list users.users as u>
            <tr><td>${u.name}</td><td><@is_true p="${u.guest}"/></td><td><@is_true p="${u.admin}"/></td><td><@is_true p="${u.deactivated}"/></td></tr>
        </#list>
        </table>
    </body>
</html>
