<#list userList as u>
<div>
    <a href="/users/${u.id}">${u.getFirstName()} ${u.getLastName()}</a>
</div>
</#list>

<a href="/home">Back</a>