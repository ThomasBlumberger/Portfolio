function header_dropdown() {
	document.getElementById("dropdown").classList.toggle("show");
}

window.onclick = function(event) {
  if (!event.target.matches('.dropbutton')) {
    var dropdowns = document.getElementsByClassName("dropdown_contents");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}

function hideQuestionWarning(event) {
  if (!confirm("This will hide the question from all residents. Are you sure?")) {
  	event.preventDefault();
  	}
}

function showQuestionWarning(event) {
  if (!confirm("This will show the question to all residents. Are you sure?")) {
  	event.preventDefault();
  	}
}

let autocomplete;
let address1Field;
let address2Field;
let postalField;

function initAutocomplete() {
  address1Field = document.querySelector("#ship-address");
  address2Field = document.querySelector("#address2");
  postalField = document.querySelector("#postcode");
  latitudeField = document.querySelector("#latitude");
  longitudeField = document.querySelector("#longitude");

  autocomplete = new google.maps.places.Autocomplete(postalField, {
    componentRestrictions: { country: ["uk"] },
    fields: ["address_components", "geometry"],
    types: ["(regions)"],
  });

  autocomplete.addListener("place_changed", fillInAddress);
}

function fillInAddress() {
  // Get the place details from the autocomplete object.
  var place = autocomplete.getPlace();
  let address1 = "";
  let postcode = "";
  let latlong = "";

  for (const component of place.address_components) {
    const componentType = component.types[0];

    switch (componentType) {
      case "street_number": {
        address1 = `${component.long_name} ${address1}`;
        break;
      }

      case "route": {
        postcode += component.long_name;
        break;
      }
      case "postal_code": {
        address1 = `${component.long_name}${postcode}`;
        break;
      }

      case "postal_code_suffix": {
        postcode = `${postcode}-${component.long_name}`;
        break;
      }
      case "postal_town":
        document.querySelector("#postal_town").value = component.long_name;
        break;
      case "country":
        document.querySelector("#country").value = component.long_name;
        break;
    }
  }

  postalField.value = address1;
  address1Field.value = postcode;
  latitudeField.value = place.geometry.location.lat();
  longitudeField.value = place.geometry.location.lng()
  address2Field.focus();
}

