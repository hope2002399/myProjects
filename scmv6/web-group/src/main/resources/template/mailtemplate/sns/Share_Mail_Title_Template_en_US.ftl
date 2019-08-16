<#assign total=total?number/>
<#if (mailContext?exists)>
<#if (psnName?exists)>${psnName}</#if> has shared<#if total==1> ${enShareTitle} to you.<#else> ${enShareTitle} and ${total?eval-1} <#switch type><#case '2'>more references<#break><#case '3'>more files<#break><#case '4'>more projects<#break><#case '1'>more references<#break><#default>more resources</#switch> to you.</#if>
<#else>
<#if (psnName?exists)>${psnName}</#if> has shared<#if total==1> <#if (minEnShareTitle?length gt 100) >
	${minEnShareTitle?substring(0,100)} ...
	<#else> ${minEnShareTitle}
	</#if> to you.<#else> <#if (minEnShareTitle?length gt 100) >
	${minEnShareTitle?substring(0,100)} ...
	<#else> ${minEnShareTitle}
	</#if> and ${total?eval-1} <#switch type><#case '2'>more references<#break><#case '3'>more files<#break><#case '4'>more projects<#break><#case '1'>more references<#break><#default>more resources</#switch> to you.</#if>
</#if>