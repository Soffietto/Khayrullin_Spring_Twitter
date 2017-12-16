<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<@sf.form action="/new_message/${sender_id}/${getter_id}" method="post" modelAttribute="message">
<fieldset>
    <div>
        <@sf.label path="text">Text</@sf.label>
        <@sf.input path="text" type="text"/>
        <@sf.errors path="text"/>
    </div>
    <div>
        <input type="submit" value="Apply">
    </div>
</fieldset>
</@sf.form>