<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Scholarmate - Invites you to join ScholarMate</title>
</head>

<body>
<table width="620" border="0" align="center" cellpadding="0" cellspacing="0" style="font-family:Arial, Helvetica, 'Microsoft YaHei' ; font-size:14px; color:#999999; background:#f7f7f4;">
  <tr>
    <td height="50" align="left" valign="middle" style="background:#666666;"><a href="${domainUrl!''}"  target="_blank"><img src="http://www.scholarmate.com/resscmwebsns/images_v5/scm_email_logo.png"  style="border:none; padding-left:20px;"></a></td>
  </tr>
  <tr>
    <td style="padding:30px;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0" style="font-family:Arial, Helvetica, 'Microsoft YaHei'  ; font-size:14px; color:#333333;">
          <tr>
            <td style="font-size:14px; font-weight:bold; line-height:150%;">
                <p style="margin:0; padding:0;">Hi，<span ><a href="${psnShortUrl!''}"  target="_blank"  style=" color:#55b1f5;text-decoration:none; ">${psnName}</a></span>  invites you to join ScholarMate.</p>
            </td>
          </tr>
          <tr>
            <td height="15">&nbsp;</td>
          </tr>
          <tr>
            <td>
                <table border="0" cellspacing="0" cellpadding="0" style=" width:100%; font-family:Arial, Helvetica, 'Microsoft YaHei' ; font-size:14px; color:#333333; background:#fff; padding:20px; border:1px solid #eaeaea; line-height:150%;">
                  <tr>
                    <td rowspan="4" valign="top"><a href="${psnShortUrl}"  target="_blank" style="border:none; padding:0; margin:0; float:left; margin-right:20px;"><img src="${avatars!'http://www.scholarmate.com/resscmwebsns/images_v5/fulltextImg/nofulltext_img.jpg'}" width="66" height="66" style="border:1px solid #e2e2e2;border-radius:50%;"></a>
                    <p style=" margin:0; padding:0; margin-left:84px;"><a  href="${psnShortUrl}"   target="_blank" style="text-decoration:none;color:#333333;font-weight:bold;">${psnName}</a></p>
                    <p style="color:#999999; margin:0; padding:0; margin-left:84px;">${titolo!''}</p>
                    <p style="color:#999999; margin:0; padding:0; margin-left:84px;">${regions!''}</p>
                    <p style=" margin:15px 0 0 84px;font-weight:bold;">
                    <a href="${inviteUrl}" target="_blank" style=" height:26px; padding:0 20px; margin:0; margin-right:10px; line-height:26px; color:#fff; text-decoration:none; background:#55b1f5; border:1px solid #49a0e0; display:inline-block;">Join</a>
                    </p>
                    </td>
                  </tr>
                </table>
            </td>
          </tr>
          <tr>
            <td valign="bottom" style=" height:30px; font-size:14px; text-align:center; color:#999999;font-style:italic;">Upload full-text and share to peers to increase citation</td>
          </tr>
        </table>
	</td>
  </tr>
</table>
 <#include "/scm_base_foot_en_US.ftl" encoding= "UTF-8">      	
</body>
</html>
