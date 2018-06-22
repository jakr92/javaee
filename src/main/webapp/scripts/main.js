
$(function(){

    $.ajax({
        type: 'GET',
        url: '/api/dishes',
        success: function(data){
           $.each(JSON.parse(data), function(i, dish){
            $("#sumArea").append(
                '<li>Dish name: '+dish.name+' Dish price: '+dish.price+' Dish type: '+dish.type+'   </li>')
           
           })
        
           
        }
    })

$("#submitbtn").on('click',function(){
    let $name = $("#name")
    let $price = $("#price")
    let $type = $("#type")
console.log($name)
var $obj = {
    id:0,
    name: $name.val(),
    price: parseFloat($price.val()),
    type: $type.val()
}


$.ajax({
    type: 'POST',
    url: '/api/dishes',
    dataTypa: 'json',
    data: JSON.stringify($obj),  
    contentType:'application/json',
    success: function(data){
        console.log("Wszystko git",data)
        $("#sumArea").append(
            '<li>Dish name: '+$name.val()+' Dish price: '+parseFloat($price.val())+' Dish type: '+$type.val()+'   </li>')
        
        
    }
})
})
})
