function saveUser(){

    var email   = $.trim($("#email").val());
    var password = $.trim($("#password").val());
    var name    = $.trim($("#userName").val());

    $.ajax ({
        url:'http://129.151.110.174:8080/api/user/new',
        
        data:JSON.stringify({
            "email":email,
            "password":password,
            "name":name
        }),

        type:'POST',
        contentType:'application/json',
        dataType:'JSON',

        error : function(result){


var myModal = new bootstrap.Modal(document.getElementById('basiceModal'), options)

            alert("usuario no registrado");
            console.log(result);
        },
        success: function(result){
            
                    alert("usuario registrado");
                    window.location.assign("login.html")
                    $("#form_id").trigger("reset");

            
        }
    });
        
}

function login(){
    var email   = $.trim($("#email").val());
    var password = $.trim($("#password").val());
    if(email != "" && password != ""){
        $.ajax({
            url:'http://129.151.110.174:8080/api/user/'+email+'/'+password,
            
            type: 'GET',
            contentType: 'application/json',
            dataType : 'JSON',
            error : function(result){
                alert("Usuario No existe..!");
                console.log(result);
            },
            success: function(respuesta){
                console.log(respuesta);
                if(respuesta.id == null){
                    alert("No exite usuario con estos datos...!");
                }else{
                    alert("Bienvenido...!"+respuesta.name);
                }
                $(':input').val('');
                $('#email').focus();
            }
        });
        return false;
    }
}

