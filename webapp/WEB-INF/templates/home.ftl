<h1>Welcome, ${firstName} ${lastName}</h1>
<a href="/logout">Logout</a>
<div>
    <p id="login_data">${email}</p>
    <p>Sex: ${sex}</p>
</div>
<#list posts as p>
<fieldset>
    <p>${p.author.firstName} ${p.author.lastName}</p>
    <p id="post_text">${p.text}</p>
    <p>${p.createdAt}</p>
    <a href="/comments/${p.id}">Comments</a>
</fieldset>
</#list>
<#include "new_post.ftl">
<a href="/users">All users</a>