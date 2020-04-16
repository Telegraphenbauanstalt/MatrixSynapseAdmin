<#-- @ftlvariable name="" type="nl.donkeysbreakfast.matrixsynapseadmin.resources.UserAdminUserlistView" -->
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
        <title>User Liste</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="/admin/bootstrap-4.4.1-dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">

        <#-- ruft getUsers() auf -->
        <h1>User Liste</h1>
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

        </div>

        <script src="/admin/jquery/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="/admin/popper.js-1.16.0/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="/admin/bootstrap-4.4.1-dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
