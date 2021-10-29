$('#register').submit(function(e) {

    console.log("Hacer el Submit");
    e.preventDefault();
    var parametros = "placeName="+"Daniel";
    registrarNegocio(parametros);
});

function registrarNegocio(parametros) {

	var success = false;

	$.ajax({
		url: 'http://localhost:4567/create',
		datatype: 'json',
		type: 'post',
		//headers: {'Authorization': 'Basic YnJvd3Nlcjo='},
		async: false,
		data: parametros,
		success: function (data) {
			console.log(data);
			success = true;
		},
		error: function (error) {
			console.log(error);
		}
	});

	return success;
}