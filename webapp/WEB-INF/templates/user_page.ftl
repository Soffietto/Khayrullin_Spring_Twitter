<h1>${firstName} ${lastName}</h1>
<div>
    <p>Email: ${email}</p>
    <p>Sex: ${sex}</p>
</div>
<#list posts as p>
<fieldset>
    <p>Author: ${p.author.firstName} ${p.author.lastName}</p>
    <p>Text: ${p.text}</p>
    <p>Date: ${p.createdAt}</p>
    <a href="/comments/${p.id}">Comments</a>
</fieldset>
</#list>
<#include "new_post.ftl">
<#include "new_dialog.ftl">
<a href="/users">All users</a>
<a href="/home">Back</a>
