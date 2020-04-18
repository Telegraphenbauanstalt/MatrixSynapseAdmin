<#import "utils.ftl" as u>
<#-- @ftlvariable name="" type="nl.donkeysbreakfast.matrixsynapseadmin.resources.ErrorView" -->

<@u.page title="MatrixSynapseAdmin Error">

        <b>${errorMessage.code} - ${errorMessage.message}</b><br>
        ${errorMessage.details!}

        <!-- basePath: ${basePath} -->
</@u.page>
