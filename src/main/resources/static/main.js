$(document).ready(function(){
    $("#registerCard").hide();
    $("#registerLink").click(function(){
      $("#loginCard").toggle();
      $("#registerCard").toggle();
    });

    $("#loginLink").click(function(){
      $("#loginCard").toggle();
      $("#registerCard").toggle();
    });
});