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

function formulateGroupsWarning(event) {
  if (!confirm("This will overwrite current group allocations! Are you sure?")) {
  	event.preventDefault();
  	}
}

function releaseGroupsWarning(event) {
  if (!confirm("This will allow students to see their groups and cannot be undone! Are you sure?")) {
  	event.preventDefault();
  	}
}

function removeGroupworkWarning(event) {
  if (!confirm("This will delete the groupwork! Are you sure?")) {
  	event.preventDefault();
  	}
}

function submitPreferenceWarning(event) {
  if (!confirm("Warning: You can only submit preferences once and cannot change your mind! Are you sure?")) {
  	event.preventDefault();
  	}
}
