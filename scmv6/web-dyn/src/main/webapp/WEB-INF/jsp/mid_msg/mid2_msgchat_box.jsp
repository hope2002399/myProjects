<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 站内信 会话聊天框 -->
<div class="state-content__box">
  <div class="state-content__commit">
    <div code="${des3ChatPsnId}" class="main-list__list item_no-padding" list-main="mobile_msg_chatbox__list"
      style="overflow: auto; padding-top: 0px; position: fixed; top: 62px; bottom: 102px; background: #fff; width: 100vw; left: 0px;">
      <!-- 消息列表 -->
    </div>
  </div>
</div>
<div class="state-footer" id="id_chatbox_footer"
  style="height: auto; position: fixed; bottom: 0px; left: 0px; width: 100%">
  <textarea class="state-footer__input" placeholder="输入你想说的话" maxlength="500" style="width: 100%;" id="mid_msg_content"></textarea>
  <div class="state-footer__selector">
    <div>
      <img onclick="midmsg.showfilesUI()" class="state-footer__selector-tip"
        src="/resmod/smate-pc/img/acquiescence-add-file1.png"> <img onclick="midmsg.showpubsUI()"
        class="state-footer__selector-tip1" src="/resmod/smate-pc/img/add-Achievements2.png">
    </div>
    <div class="state-footer__selector-save" onclick="midmsg.sendtextmsg(event)">发送</div>
  </div>
</div>