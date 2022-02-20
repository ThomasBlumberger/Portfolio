var now = moment();
document.getElementById("weekHeader").innerHTML += "WEEK " + moment().isoWeek() + " - " + now.clone().isoWeekday(1).format('dddd Do MMMM YYYY') + " - " + now.clone().isoWeekday(7).format('dddd Do MMMM YYYY');

function $() { return document.querySelector.apply(document, arguments); }

const randcharset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

const randchars = (function (R,M) {
    var L = R.length,r=M.random, f= M.floor;
    return function (len) {
        var i,s="";
        for (i=0;i<len;i++) s += R[f(r() * L)];
        return s;
    };
})(randcharset.split(''),Math);

if (!localStorage.formValues) localStorage.formValues = "[]";

var formValues = JSON.parse(localStorage.formValues);

$("#AddTask").addEventListener("submit", function(e) {
    e.preventDefault();
	var id = Math.random().toString();
    var name = $("#Taskname").value;
    var priority = $("#priorities").value;
	var deadline = $("#deadline").value;
	var length = $("#taskLength").value;
	var assign = $("#groupMember").value;
	var notes = $("#taskNotes").value;
    var taskType = $("#taskType").value;
	var modalID = randchars(12);
	
    formValues.push({
		id: id,
		modalID: modalID,
        name: name,
        priority: priority,
		deadline: deadline,
		length: length,
		assign: assign,
		notes: notes,
		type: taskType
    });
    localStorage.formValues = JSON.stringify(formValues);
	window.open('dashboard.html', '_self'	)
});

function clearStorage() {
if (confirm('Are you sure you want to clear all tasks from the system?')){
	localStorage.clear();
	window.open('dashboard.html', '_self'); 
	}else {}
	}
function backHome() {
window.open('dashboard.html', '_self'	);
}

function signOut() {
if (confirm('Are you sure you want to logout?')) {
  window.open('../index.html', '_self'	);
} else {
}
}

function newTask() {
window.open('addtask.html', '_self'	);
}

function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}

function openNavSetting() {
  document.getElementById("mySidenavSettings").style.width = "250px";
}


function closeNavSetting() {
  document.getElementById("mySidenavSettings").style.width = "0";
}

$('#dashboardPage').click(function(event) {
  if ($(event.target).closest('div#mySidenavSettings').length === 0 && $(event.target).closest('#settingIcon').length === 0) {
    closeNavSetting()
  }
  if ($(event.target).closest('div#mySidenav').length === 0 && $(event.target).closest('.btn').length === 0) {
    closeNav()
  }
})

function myFunction() {
  document.getElementById("slider").disabled = true;
}

var header = document.getElementById("myDIV");
var btns = header.getElementsByClassName("but");
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function() {
  var current = document.getElementsByClassName("active");
  current[0].className = current[0].className.replace(" active", "");
  this.className += " active";
  });
}

var today = new Date().toISOString().split('T')[0];
document.getElementsByName("deadline")[0].setAttribute('min', today);

function addGroup() {
window.open('addgroup.html', '_self'	);
}

function deleteAcc() {
if (confirm('Are you sure you want to delete your account? You will lose all data and will have to register for a new account if you change your mind')) {
  window.open('../index.html', '_self'	);
} else {
}
}

function editTask() {
window.open('edittask.html', '_self'	);
}

function openCalendar() {
window.open('calendar.html', '_self'	);
}

function openMyAcc() {
window.open('myaccount.html', '_self'	);
}

function openMygroup() {
window.open('mygroup.html', '_self'	);
}

function openColour() {
window.open('colorcustom.html', '_self'	);
}

function printOverview() {
alert("You cannot print this page");
}

function openNotifications() {
window.open('notification.html', '_self'	);
}