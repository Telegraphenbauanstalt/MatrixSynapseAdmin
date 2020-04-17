<#import "utils.ftl" as u>
<#-- @ftlvariable name="" type="nl.donkeysbreakfast.matrixsynapseadmin.resources.UserAdminUserlistView" -->
<#macro is_true p>
    <#if p == "1">
        WAHR
    <#else>
        FALSCH
    </#if>
</#macro>

<@u.page title="User Liste">
        <table class="table table-striped"><!-- Bootstrap Table opt-in + Zebra-->
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Gast</th>
                <th scope="col">Admin</th>
                <th scope="col">Deaktiviert</th>
                <th scope="col"></th>
            </tr>
        <#list users.users as u>
            <tr>
                <th scope="row">${u.name}</th>
                <td><@is_true p="${u.guest}"/></td>
                <td><@is_true p="${u.admin}"/></td>
                <td><@is_true p="${u.deactivated}"/></td>
                <td><a href="users/${u.name}" class="btn btn-primary btn-sm" role="button">Details</a></td>
            </tr>
        </#list>
        </table>

        <a href="../newuser.html" class="btn btn-primary btn-lg" role="button">Neu</a>
</@u.page>
