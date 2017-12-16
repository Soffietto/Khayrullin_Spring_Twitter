<#list comments as c>
<fieldset>
    <p>Author: ${c.author.firstName} ${c.author.lastName}</p>
    <p id="comment_text">Text: ${c.text}</p>
    <p>Date: ${c.createdAt}</p>
</fieldset>
</#list>
<#include "new_comments.ftl">
<a href="/users/${user_id}">Back</a>