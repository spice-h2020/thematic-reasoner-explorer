$('.theme-button').on('click', function(event) {
  console.log($(this).attr('theme'));

  $.get("getTopicallyAssociatedStories?theme=" + $(this).attr('theme'), function(data) {

    $('#results').empty();

    for(story in data){
      storyn = story + 1
      $("#results").append(`<div class="row"><div class="col"><h5>Story #${parseInt(story)+1}</h5><p>${data[story]}</p></div></div>`)
    }

    console.log(data)

  }, "json");

});


$(document).ready(function(){
  $("#themeFilter").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $(".theme-button").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
