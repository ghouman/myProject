function loadContent(_targetKey,obj){
    $(obj).attr("class","active");

    $.ajax({
        url:'../WEB-INF/jsp/pages/'+_targetKey+'.jsp',
        cache:false,
        success:function(data){
            $('#Main').empty();
            $('#Main').html(data);
        }
    });
}