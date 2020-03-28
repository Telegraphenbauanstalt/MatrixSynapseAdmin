<#-- @ftlvariable name="" type="nl.donkeysbreakfast.matrixsynapseadmin.resources.UserAdminView" -->
<!DOCTYPE html>
<html>
    <body>
        <#-- ruft getUsers() auf -->
        <h1>User Liste</h1>
        <ul>
        <#list users.users as u>
            <li>${u.name}</li>
        </#list>
        </ul>
    </body>
</html>
