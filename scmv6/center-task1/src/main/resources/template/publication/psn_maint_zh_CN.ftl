<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="Keywords" content="科研之友，科研社交网络，科研创新生态环境，学术推广，科研推广，学者推广，科研合作，成果推广，论文引用，基金机会，科研项目，科研成果，科研诚信，同行专家，科研系统，科研项目申请书，ISIS系统。"/>
<meta name="description" content="科研之友：科研社交网络，成就科研梦想。学术推广，科研推广，学者推广，科研合作，成果推广，论文引用，基金机会，科研项目，科研成果，科研系统。" />
<title>
		科研人员列表|科研之友
</title>
<link href="/resscmwebsns/css_v5/public.css" rel="stylesheet" type="text/css" />
<link href="/resscmwebsns/css_v5/index.css" rel="stylesheet" type="text/css" />
<link href="/resscmwebsns/css_v5/header.css" rel="stylesheet" type="text/css" />
<link href="/resscmwebsns/css_v5/home/home.css" rel="stylesheet" type="text/css" />
<link href="/resscmwebsns/css_v5/login.css" rel="stylesheet" type="text/css" />
<link href="/resscmwebsns/css_v5/agency.css" rel="stylesheet" type="text/css" />
<script src="/resscmwebsns/js_v5/jquery.js"></script>
<script type="text/javascript">
//设置选中字母.
function selectTip(_this){
	//设置已选中的字母并赋值给隐藏参数.
	var codeNum=$(_this).attr("id");
	$(_this).attr("class","abc_hover");
	var alist=$(_this).parent().parent().find("li").find("a");
	//清除其他已选中的字母.
	alist.each(function(){
		var iCode=$(this).attr("id");
		if(iCode!=codeNum){
			$(this).removeAttr("class");
		}
	});
	$(".div_psn").each(function(){
		var div_Code=$(this).attr("id");
		if(div_Code!=codeNum){
			if(div_Code=='other'){
				$(this).attr("class","div_psn clear").css("display","none");
			}else{
				$(this).attr("class","div_psn").css("display","none");
			}
		}else{
			if(div_Code=='other'){
				$(this).attr("class","person_list div_psn clear").css("display","block");
			}else{
				$(this).attr("class","person_list div_psn").css("display","block");
			}
		}
	});
}

var ctxpath =  "/scmwebsns";
	function searchPub(num){
		$.ajax({
			        url: ctxpath + '/indexSearch/ajaxSearchPsn',
			        type: 'post',
			        dataType: 'json',
					data: {
			            "keyword": document.getElementById("keyword").value,
			            "pageNum":num
			        },
			        success: function(data){
			        	if(data&&data.result=='success'){
			        		$("#searchContent").html(data.object);
			        	}else{
			        		$("#searchContent").html("");
			        	}
			        	var alist=$('#searchResult').find("li").find("a");
			        	//清除其他已选中的字母.
						alist.each(function(){
							var iCode=$(this).attr("id");
							if(iCode!=codeNum){
								$(this).removeAttr("class");
							}
						});
						$(".div_psn").each(function(){
							var div_Code=$(this).attr("id");
							if(div_Code=='other'){
								$(this).attr("class","div_psn clear").css("display","none");
							}else{
								$(this).attr("class","div_psn").css("display","none");
							}
						});
						$("#searchContent").attr("class","person_list div_psn clear").css("display","block");
			        }
			        ,
			        error:function(e){
			        	$("[class='person_list div_psn']").html("");
			        }
			    });
	}
</script>
</head>
<body>
	<div id="scholarmate_hearder">
		<div class="scholarmate_top">
			<div class="sm_logo_zh_CN">
				<a href="/" title="首页"
					alt="首页"></a>
			</div>
			<div class="sm_top_nav">
				<span id="back_span">
					<a href="/" rel="nofollow">
						返回首页
					</a> 
					|
				</span> 
					<a href="/help" target="_blank" rel="nofollow"> 帮助中心 </a> | 
					<a href="psn_maint_en_US.html">&nbsp;English&nbsp;</a>
			</div>
		</div>
	</div>
<div class="agency_box">
	<div class="menu">
		<div class="menu-bjleft"></div>
		<div class="menu-bjcenter">
			<div class="m-text">
				<span class="fcu14">浏览站内人员</span>
			</div>
		</div>
		<div class="menu-bjright"></div>
	</div>
	<div class="agency_bg01"></div>
	<div class="agency_bg02">
		<div class="agency_search" style="margin:0px 20px;display:none;">
            	<div class="ag_search_box">
                	<span class="cuti Fleft">站内人员搜索：</span>
                    <input id="keyword" name="keyword" type="text" class="inp_text" style="width:270px; height:22px; line-height:22px;"/>
                    <a href="javascript:searchPub(1);" class="uiButton uiButtonConfirm mleft5" title="搜索" style="padding:3px 25px;">搜索</a>
                </div>
                <div class="clear" style="height:0px; overflow:hidden;"></div>
        </div>
		<div class="abc_list">
			<input type="hidden" id="codeNum" name="codeNum" />
			<div id="searchResult">
			<ul>
				<li><a id="A" onclick="selectTip(this);" class="abc_hover">A</a>
				</li>
				<li><a id="B" onclick="selectTip(this);" >B</a>
				</li>
				<li><a id="C" onclick="selectTip(this);" >C</a>
				</li>
				<li><a id="D" onclick="selectTip(this);" >D</a>
				</li>
				<li><a id="E" onclick="selectTip(this);" >E</a>
				</li>
				<li><a id="F" onclick="selectTip(this);" >F</a>
				</li>
				<li><a id="G" onclick="selectTip(this);" >G</a>
				</li>
				<li><a id="H" onclick="selectTip(this);" >H</a>
				</li>
				<li><a id="I" onclick="selectTip(this);" >I</a>
				</li>
				<li><a id="J" onclick="selectTip(this);" >J</a>
				</li>
				<li><a id="K" onclick="selectTip(this);" >K</a>
				</li>
				<li><a id="L" onclick="selectTip(this);" >L</a>
				</li>
				<li><a id="M" onclick="selectTip(this);" >M</a>
				</li>
				<li><a id="N" onclick="selectTip(this);" >N</a>
				</li>
				<li><a id="O" onclick="selectTip(this);" >O</a>
				</li>
				<li><a id="P" onclick="selectTip(this);" >P</a>
				</li>
				<li><a id="Q" onclick="selectTip(this);" >Q</a>
				</li>
				<li><a id="R" onclick="selectTip(this);" >R</a>
				</li>
				<li><a id="S" onclick="selectTip(this);" >S</a>
				</li>
				<li><a id="T" onclick="selectTip(this);" >T</a>
				</li>
				<li><a id="U" onclick="selectTip(this);" >U</a>
				</li>
				<li><a id="V" onclick="selectTip(this);" >V</a>
				</li>
				<li><a id="W" onclick="selectTip(this);" >W</a>
				</li>
				<li><a id="X" onclick="selectTip(this);" >X</a>
				</li>
				<li><a id="Y" onclick="selectTip(this);" >Y</a>
				</li>
				<li><a id="Z" onclick="selectTip(this);" >Z</a>
				</li>
				<li style="border-right: 1px solid #cbd9e1;"><a id="other" onclick="selectTip(this);">other</a>
				</li>
			</ul>
			</div>
			<div class="clear" style="height: 1px; overflow: hidden;"></div>
		</div>
		<div class="person_list div_psn" id="A">${A}</div>
		<div class="div_psn" style="display:none;" id="B">${B}</div>
		<div class="div_psn" style="display:none;" id="C">${C}</div>
		<div class="div_psn" style="display:none;" id="D">${D}</div>
		<div class="div_psn" style="display:none;" id="E">${E}</div>
		<div class="div_psn" style="display:none;" id="F">${F}</div>
		<div class="div_psn" style="display:none;" id="G">${G}</div>
		<div class="div_psn" style="display:none;" id="H">${H}</div>
		<div class="div_psn" style="display:none;" id="I">${I}</div>
		<div class="div_psn" style="display:none;" id="J">${J}</div>
		<div class="div_psn" style="display:none;" id="K">${K}</div>
		<div class="div_psn" style="display:none;" id="L">${L}</div>
		<div class="div_psn" style="display:none;" id="M">${M}</div>
		<div class="div_psn" style="display:none;" id="N">${N}</div>
		<div class="div_psn" style="display:none;" id="O">${O}</div>
		<div class="div_psn" style="display:none;" id="P">${P}</div>
		<div class="div_psn" style="display:none;" id="Q">${Q}</div>
		<div class="div_psn" style="display:none;" id="R">${R}</div>
		<div class="div_psn" style="display:none;" id="S">${S}</div>
		<div class="div_psn" style="display:none;" id="T">${T}</div>
		<div class="div_psn" style="display:none;" id="U">${U}</div>
		<div class="div_psn" style="display:none;" id="V">${V}</div>
		<div class="div_psn" style="display:none;" id="W">${W}</div>
		<div class="div_psn" style="display:none;" id="X">${X}</div>
		<div class="div_psn" style="display:none;" id="Y">${Y}</div>
		<div class="div_psn" style="display:none;" id="Z">${Z}</div>
		<div class="div_psn" style="display:none;" id="other">${other}</div>
		<div class="div_psn" style="display:none;" id="searchContent"></div>
		<div class="clear" style="height: 1px; overflow: hidden;"></div>
	</div>
	<div class="agency_bg03"></div>
</div>
<div id="footer">
	<div class="box_footer">
				<div class="footer-left">
					&copy;2019
					<a href="http://www.irissz.com" class="Blue" target="_blank">深圳市科研之友网络服务有限公司</a> 
					<a class="Blue" style="color:#333;" href="http://www.miitbeian.gov.cn" target="_blank">粤ICP备16046710号-1</a>
					<img src="/resmod/images_v5/beian/beian.png" style="width: 12px;"/>
					<a class="Blue" style="color:#333;"  href="http://www.miitbeian.gov.cn" target="_blank">粤公网安备 4403052000213</a>
				</div>
				<div class="footer-right">
					<a href="/resscmwebsns/html/policy_zh_CN.html" class="Blue" target="_blank">
						隐私政策
					</a> | 
					<a href="/resscmwebsns/html/condition_zh_CN.html" class="Blue" target="_blank">
						服务条款
					</a> | 
					<a href="/resscmwebsns/html/contact_zh_CN.html" class="Blue" target="_blank">
						联系我们
					</a> | 
		     		<a href="/resscmwebsns/html/res_download_zh_CN.html" class="Blue" target="_blank">
		     			下载 
		     		</a>
				</div>
	</div>
</div>
</body>
</html>
