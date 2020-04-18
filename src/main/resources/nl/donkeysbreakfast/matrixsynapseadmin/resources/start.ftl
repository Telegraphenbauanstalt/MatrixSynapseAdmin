<#import "utils.ftl" as u>
<#-- @ftlvariable name="" type="nl.donkeysbreakfast.matrixsynapseadmin.resources.StartView" -->
<#macro is_true p>
    <#if p == "1">
        WAHR
    <#else>
        FALSCH
    </#if>
</#macro>

<@u.page title="MatrixSynapseAdmin Start">

        <p>Hallo, ${loginUser.name!Benutzer}</p>
        
        <ul class="list-group">
            <li class="list-group-item"><a href="${basePath!}/api/server_version">Serverversion</a></li>
            <li class="list-group-item"><a href="${basePath!}/api/users">User List</a></li>
            <li class="list-group-item"><a href="${basePath!}/newuser.html">New user</a></li>
            <li class="list-group-item"><form class="form-inline" action="${basePath!}/api/logout" method="POST">
                <button type="submit" name="logout" value="true" class="btn btn-link" style="padding: 0;">Logout</button></form></li>
        </ul>

        <!-- basePath: ${basePath} -->
</@u.page>
