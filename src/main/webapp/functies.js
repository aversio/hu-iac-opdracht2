$.ajax({
	type: 'GET',
	url: "/rest/koffieautomaten",
	data: { get_param: 'value' },
    dataType: 'json',
    success: function (data) {

		$.each(data, function(index, koffieautomaat) {
			$("#lijstKoffies").append(
				"<p>"+
                	"<b>Code: </b>" + koffieautomaat.id + "</br>" +
					"<b>Merk: </b>" + koffieautomaat.brand + "</br>" +
					"<b>Model: </b>" + koffieautomaat.model + "</br>" +
					"<b>Prijs: </b>" + koffieautomaat.price + "</br>" +
				"</p>"
			);
		})

    }
});

$.ajax({
    type: 'GET',
    url: "/rest/koffieautomaten/prijzigste",
    data: { get_param: 'value' },
    dataType: 'json',
    success: function (data) {
        $.each(data, function(index, koffieautomaat) {
            $("#top3").append(
                "<p>"+
                "<b>Merk: </b>" + koffieautomaat.brand + "</br>" +
                "<b>Model: </b>" + koffieautomaat.model + "</br>" +
                "<b>Prijs: </b>" + koffieautomaat.prijs + "</br>" +
                "</p>"
            );
        })
    }
});

$("#send").click(function() {
    var code = $("#vindKoffie").val();
	$.ajax({
		type: 'GET',
		url: "/rest/koffieautomaten/"+code,
		data: { get_param: 'value' },
		dataType: 'json',
		success: function (data) {
			if (!code) {
				alert("Mag niet leeg zijn!")
			} else {
				$("#toonKoffie").html(
					"<p>"+
						"<b>Code: </b>" + data.code + "</br>" +
						"<b>Model: </b>" + data.brand + "</br>" +
						"<b>Prijs: </b>" + data.prijs + "</br>" +
					"</p>"
				);
			}
		},
		error: function() {
			alert("Onjuiste code!");
		}
	});
});