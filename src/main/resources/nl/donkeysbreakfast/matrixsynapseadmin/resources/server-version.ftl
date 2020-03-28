<#-- @ftlvariable name="" type="nl.donkeysbreakfast.matrixsynapseadmin.resources.ServerVersionView" -->
<!DOCTYPE html>
<html>
    <body>
        <#-- ruft getServerVersion().getServerVersion() bzw. getServerVersion().getPythonVersion() auf -->
        <b>Server version:</b> ${serverVersion.serverVersion}<br />
        <b>Python version:</b> ${serverVersion.pythonVersion}<br />
    </body>
</html>
