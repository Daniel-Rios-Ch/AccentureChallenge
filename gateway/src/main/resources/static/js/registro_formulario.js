


$('#register').submit(function(e) {

    console.log("Hacer el Submit");
    e.preventDefault();
    var parametros = "placeName="+"Daniel";
    registrarNegocio(parametros);
});

function registraNegocio() {

    var success = false;
    var parametros = "placeName=" + $('#nombre').val() == "" ? 'El Cabrito X' : $('#nombre').val();

    $.ajax({
        url: 'http://localhost:4567/create',
        datatype: 'json',
        type: 'get',
        data: parametros,
        contentType: "application/json",
        success: function(data) {
            console.log(data);
            success = true;
            alert("Ok")
        },
        error: function(e) {
            alert("Ocurrio un error al guardar");
            console.log(e);
        }
    })
}