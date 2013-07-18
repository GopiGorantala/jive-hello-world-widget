<style type="text/css">
    .jive-widget .jive-widget-body p.gobig {
        font: 16px verdana, helvetica, sans-serif;
    }
    .jive-widget .jive-widget-body p.getsmall {
        font: 10px verdana, helvetica, sans-serif;
    }
</style>

<#-- Use the widget's greetUser property to define the greeting style. -->
<#if greetUser>
    <#assign greeting = "Hello " + userName + "!">
<#else>
    <#assign greeting = "Hello World!">
</#if>

<#-- Render for display in a small area. -->
<#if containerSize == enums['com.jivesoftware.community.widget.Widget$ContainerSize'].SMALL>
<p class="getsmall">${greeting} Welcome to the ${communityName} community!</p>
<#-- Render for display in a large area. -->
<#else>
<p class="gobig">${greeting} Welcome to the ${communityName} community!</p>
</#if>