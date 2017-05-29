window.onload = function() {
	var myLatLng = {lat: 42.674698, lng: 23.289389};
	
	var map = new google.maps.Map(document.getElementById('map'), {
		zoom: 20,
	    center: myLatLng
	});
	
	var marker = new google.maps.Marker({
		position: myLatLng,
	    map: map
	});
}