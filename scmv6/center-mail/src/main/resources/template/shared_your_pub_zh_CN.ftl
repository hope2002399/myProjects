<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>${sharedPsnName}分享了您的论文:${pubTitle}</title>
</head>

<body>
<table width="620" border="0" align="center" cellpadding="0" cellspacing="0" style="font-family:Arial, Helvetica, 'Microsoft YaHei'; font-size:14px; color:#999999; background:#f7f7f4;">
  <tr>
    <td height="50" align="left" valign="middle" style="background:#666666;"><a href="${domainUrl!''}"  target="_blank"><img src="http://www.scholarmate.com/resscmwebsns/images_v5/scm_email_logo.png"  style="border:none; padding-left:20px;"></a></td>
  </tr>
  <tr>
    <td style="padding:30px;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0" style="font-family:Arial, Helvetica, 'Microsoft YaHei'; font-size:14px; color:#333333;">
          <tr>
            <td style="font-size:14px; font-weight:bold; line-height:150%;">
                <p style="margin:0; padding:0;">${psnName!''}，<span ><a href="${sharedPsnUrl!''}"  target="_blank"  style=" color:#55b1f5;text-decoration:none; ">${sharedPsnName}</a></span>分享了你的论文。</p>
            </td>
          </tr>
          <tr>
            <td height="15">&nbsp;</td>
          </tr>
          <tr>
            <td>
              <table border="0" cellspacing="0" cellpadding="0" style=" width:100%; font-family:Arial, Helvetica, 'Microsoft YaHei' ; font-size:14px; color:#333333; background:#fff; padding:20px; border:1px solid #eaeaea; line-height:150%;">
                  <tr align="left">
                    <td align="left" valign="top"  style="width: 20%; display: block;  float: left;">
                      <a href="${pubDetailUrl!'#'}"  target="_blank" style=" padding:0; margin:0; float:left; margin-right:20px; border:1px solid #e2e2e2;">
                        <img src="${fullTextUrl!'http://www.scholarmate.com/resscmwebsns/images_v5/fulltextImg/nofulltext_img.jpg'}" width="66" height="78" style=" border: none; vertical-align:middle;">
                      </a>
                    </td>
                    <td align="left" style=" width:100%;">
                      <p style=" margin:0; padding:0; font-weight:bold; margin-left: 0px;"><a  href="${pubDetailUrl!'#'}" target="_blank" style="text-decoration:none;color:#333333;">${pubTitle}</a></p>
                      <p  style="color:#999999; margin:0; padding:0; margin-left:0px;">${pubAuthors!''}</p>
                      <p style="color:#999999; margin:0; padding:0; margin-left: 0px; ">${pubBrief!''}</p>
                      <p style=" margin:15px 0 0 0px;">
                      <a  href="${impactsUrl!''}"   target="_blank"  style=" height:26px; padding:0 20px; margin:0; margin-right:10px; line-height:26px; color:#fff; text-decoration:none; background:#55b1f5; border:1px solid #c9cdd1; display:inline-block;">&nbsp;&nbsp;&nbsp;&nbsp;查看我的影响力&nbsp;&nbsp;&nbsp;&nbsp;</a>
                      </p>
                    </td>
                  </tr>
                </table>
            </td>
          </tr>
          <tr>
            <td valign="bottom" style=" height:30px; font-size:14px; text-align:center; color:#999999;font-style:italic;">赞与分享成果，提高论文引用</td>
          </tr>
        </table>
	</td>
  </tr>
</table>
 <#include "/scm_base_foot_zh_CN.ftl" encoding= "UTF-8">              	
</body>
</html>
