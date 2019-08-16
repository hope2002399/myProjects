/*
 * Style File - jQuery plugin for styling file input elements
 *  
 * Copyright (c) 2007-2008 Mika Tuupola
 *
 * Licensed under the MIT license:
 *   http://www.opensource.org/licenses/mit-license.php
 *
 * Based on work by Shaun Inman
 *   http://www.shauninman.com/archive/2007/09/10/styling_file_inputs_with_css_and_the_dom
 *
 * Revision: $Id: jquery.filestyle.js 303 2008-01-30 13:53:24Z tuupola $
 *
 */

(function($) {
	$.smate = $.smate ? $.smate : {};
	$.smate.filestyle = $.smate.filestyle ? $.smate.filestyle : {};
    $.fn.filestyle = function(options) {
                
        /* TODO: This should not override CSS. */
        var settings = {
            width : 250,
            display:"inline",
            position:"absolute"
        };
                
        if(options) {
            $.extend(settings, options);
        };
                        
        return this.each(function() {
            
            var self = this;
            var wrapper = $("<div>")
                            .css({
                                "width": settings.imagewidth + "px",
                                "height": settings.position=="absolute"?"":(settings.imageheight+2) + "px",
                                "background": "url(" + settings.image + ") 0 0 no-repeat",
                                "background-position": "right",
                                "display": "inline",
                                "position": settings.position,
                                "overflow": "hidden",
                                "padding":  settings.position=="absolute"?"":"5px 0px"
                            });
                       
            var filename = $('<input class="file inp_text '+$(self).attr("id")+'" readonly="readonly">')
                             .addClass($(self).attr("class"))
                             .css({
                                 "display": settings.display,
                                 "width": settings.width + "px",
                                 "padding": "1px 0 1px 18px"
                              });

            $(self).before(filename);
            $(self).wrap(wrapper);

            $(self).css({
                        "position": "relative",
                        "height": settings.imageheight + "px",
                        "width": settings.width + "px",
                        "display": "inline",
                        "cursor": "pointer",
                        "opacity": "0.0"
                    });

            if ($.browser.mozilla) {
                if (/Win/.test(navigator.platform)) {
                    $(self).css("margin-left", "-116px");                    
                } else {
                    $(self).css("margin-left", "-168px");                    
                };
            } else {
                $(self).css("margin-left", settings.imagewidth - settings.width + "px");                
            };
      
        });
        

    };
    
})(jQuery);
