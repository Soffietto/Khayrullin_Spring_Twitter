<#list messages as m>
<fieldset>
    <p>Author: ${m.author.firstName} ${m.author.lastName}</p>
    <p>Text: ${m.text}</p>
    <p>Date: ${m.createdAt}</p>
</fieldset>
</#list>
<#include "new_message.ftl">
<a href="/home">Back</a>
