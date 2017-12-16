<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<h1>Sign in</h1>
<#if error??>
Bad creds
</#if>
<@sf.form role="form" action='/login/process' method="post" modelAttribute="signInForm">
<fieldset>
    <div class="field">
        <@sf.label path="email">Email</@sf.label>
        <@sf.input path="email" cssClass="form-control" type="email"/>
        <@sf.errors path="email" cssClass="help-block"/>
    </div>
    <div class="field">
        <@sf.label path="password">Password</@sf.label>
        <@sf.input path="password" cssClass="form-control" type="password"/>
        <@sf.errors path="password" cssClass="help-block"/>
    </div>
    <div class="form-group">
        <input class="btn btn-info btn-outline" type="submit" value="Sing in">
    </div>
</fieldset>
<a href="/sign_up">Sign up</a>
</@sf.form>