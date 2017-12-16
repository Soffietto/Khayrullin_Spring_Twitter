<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<@sf.form action="/new_message/${current_user_id}/${id}" method="post" modelAttribute="message">
<input type="submit" value="New message">
</@sf.form>