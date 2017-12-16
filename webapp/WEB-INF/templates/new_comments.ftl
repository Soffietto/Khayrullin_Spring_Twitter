<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<@sf.form action="/new_comment/${post_id}" method="post" modelAttribute="comment">
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