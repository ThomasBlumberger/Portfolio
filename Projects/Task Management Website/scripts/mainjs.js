
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

var header = document.getElementById("myDIV");
var btns = header.getElementsByClassName("but");
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function() {
  var current = document.getElementsByClassName("active");
  current[0].className = current[0].className.replace(" active", "");
  this.className += " active";
  });
}



function jCompletedFilterUpcoming() {
    $('#upcoming').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#upcoming').children().filter(function () {
        return !this.firstChild.checked;
    }).hide();
	document.getElementById("UpcomingLabel").innerHTML = '<font size="5"> Filtered By: Completed </font>';
}
function jCompletedFilterUpcomingSchool() {
    $('#upcomingSchool').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#upcomingSchool').children().filter(function () {
        return !this.firstChild.checked;
    }).hide();
	document.getElementById("UpcomingLabelSchool").innerHTML = '<font size="5"> Filtered By: Completed </font>';
}
function jCompletedFilterUpcomingWork() {
    $('#upcomingWork').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#upcomingWork').children().filter(function () {
        return !this.firstChild.checked;
    }).hide();
	document.getElementById("UpcomingLabelWork").innerHTML = '<font size="5"> Filtered By: Completed </font>';
}
function jNotCompletedFilterUpcoming() {
    $('#upcoming').children().filter(function () {
        return this.firstChild.checked;
    }).hide();
	$('#upcoming').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("UpcomingLabel").innerHTML = '<font size="5"> Filtered By: Not Completed </font>';
}
function jNotCompletedFilterUpcomingSchool() {
    $('#upcomingSchool').children().filter(function () {
        return this.firstChild.checked;
    }).hide();
	$('#upcomingSchool').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("UpcomingLabelSchool").innerHTML = '<font size="5"> Filtered By: Not Completed </font>';
}
function jNotCompletedFilterUpcomingWork() {
    $('#upcomingWork').children().filter(function () {
        return this.firstChild.checked;
    }).hide();
	$('#upcomingWork').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("UpcomingLabelWork").innerHTML = '<font size="5"> Filtered By: Not Completed </font>';
}
function jShowAllFilterUpcoming() {
    $('#upcoming').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#upcoming').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("UpcomingLabel").innerHTML = '<font size="5"> Filtered By: Show All </font>';
}
function jShowAllFilterUpcomingSchool() {
    $('#upcomingSchool').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#upcomingSchool').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("UpcomingLabelSchool").innerHTML = '<font size="5"> Filtered By: Show All </font>';
}
function jShowAllFilterUpcomingWork() {
    $('#upcomingWork').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#upcomingWork').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("UpcomingLabelWork").innerHTML = '<font size="5"> Filtered By: Show All </font>';
}
function jCompletedFilterAssigned() {
    $('#assigned').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#assigned').children().filter(function () {
        return !this.firstChild.checked;
    }).hide();
	document.getElementById("AssignedLabel").innerHTML = '<font size="5"> Filtered By: Completed </font>';
}
function jCompletedFilterAssignedSchool() {
    $('#assignedSchool').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#assignedSchool').children().filter(function () {
        return !this.firstChild.checked;
    }).hide();
	document.getElementById("AssignedLabelSchool").innerHTML = '<font size="5"> Filtered By: Completed </font>';
}
function jCompletedFilterAssignedWork() {
    $('#assignedWork').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#assignedWork').children().filter(function () {
        return !this.firstChild.checked;
    }).hide();
	document.getElementById("AssignedLabelWork").innerHTML = '<font size="5"> Filtered By: Completed </font>';
}
function jNotCompletedFilterAssigned() {
    $('#assigned').children().filter(function () {
        return this.firstChild.checked;
    }).hide();
	$('#assigned').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("AssignedLabel").innerHTML = '<font size="5"> Filtered By: Not Completed </font>';
}
function jNotCompletedFilterAssignedSchool() {
    $('#assignedSchool').children().filter(function () {
        return this.firstChild.checked;
    }).hide();
	$('#assignedSchool').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("AssignedLabelSchool").innerHTML = '<font size="5"> Filtered By: Not Completed </font>';
}
function jNotCompletedFilterAssignedWork() {
    $('#assignedWork').children().filter(function () {
        return this.firstChild.checked;
    }).hide();
	$('#assignedWork').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("AssignedLabelWork").innerHTML = '<font size="5"> Filtered By: Not Completed </font>';
}
function jShowAllFilterAssigned() {
    $('#assigned').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#assigned').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("AssignedLabel").innerHTML = '<font size="5"> Filtered By: Show All </font>';
}
function jShowAllFilterAssignedSchool() {
    $('#assignedSchool').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#assignedSchool').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("AssignedLabelSchool").innerHTML = '<font size="5"> Filtered By: Show All </font>';
}
function jShowAllFilterAssignedWork() {
    $('#assignedWork').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#assignedWork').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("AssignedLabelWork").innerHTML = '<font size="5"> Filtered By: Show All </font>';
}
function jCompletedFilterNotes() {
    $('#notes').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#notes').children().filter(function () {
        return !this.firstChild.checked;
    }).hide();
	document.getElementById("NotesLabel").innerHTML = '<font size="5"> Filtered By: Completed </font>';
}
function jCompletedFilterNotesSchool() {
    $('#notesSchool').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#notesSchool').children().filter(function () {
        return !this.firstChild.checked;
    }).hide();
	document.getElementById("NotesLabelSchool").innerHTML = '<font size="5"> Filtered By: Completed </font>';
}
function jCompletedFilterNotesWork() {
    $('#notesWork').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#notesWork').children().filter(function () {
        return !this.firstChild.checked;
    }).hide();
	document.getElementById("NotesLabelWork").innerHTML = '<font size="5"> Filtered By: Completed </font>';
}
function jNotCompletedFilterNotes() {
    $('#notes').children().filter(function () {
        return this.firstChild.checked;
    }).hide();
	$('#notes').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("NotesLabel").innerHTML = '<font size="5"> Filtered By: Not Completed </font>';
}
function jNotCompletedFilterNotesSchool() {
    $('#notesWork').children().filter(function () {
        return this.firstChild.checked;
    }).hide();
	$('#notesWork').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("NotesLabelSchool").innerHTML = '<font size="5"> Filtered By: Not Completed </font>';
}
function jNotCompletedFilterNotesWork() {
    $('#notesWork').children().filter(function () {
        return this.firstChild.checked;
    }).hide();
	$('#notesWork').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("NotesLabelWork").innerHTML = '<font size="5"> Filtered By: Not Completed </font>';
}
function jShowAllFilterNotes() {
    $('#notes').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#notes').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("NotesLabel").innerHTML = '<font size="5"> Filtered By: Show All </font>';
}
function jShowAllFilterNotesSchool() {
    $('#notesWork').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#notesWork').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("NotesLabelSchool").innerHTML = '<font size="5"> Filtered By: Show All </font>';
}
function jShowAllFilterNotesWork() {
    $('#notesWork').children().filter(function () {
        return this.firstChild.checked;
    }).show();
	$('#notesWork').children().filter(function () {
        return !this.firstChild.checked;
    }).show();
	document.getElementById("NotesLabelWork").innerHTML = '<font size="5"> Filtered By: Show All </font>';
}
function jCompletedFilterMonday(){
$('#mondayDayView').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#mondayDayView').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("mondayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jCompletedFilterMondayWork(){
$('#mondayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#mondayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("mondayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jCompletedFilterMondaySchool(){
$('#mondayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#mondayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("mondayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jNotCompletedFilterMonday(){
$('#mondayDayView').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#mondayDayView').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("mondayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jNotCompletedFilterMondayWork(){
$('#mondayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#mondayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("mondayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jNotCompletedFilterMondaySchool(){
$('#mondayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#mondayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("mondayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jShowAllFilterMonday(){
$('#mondayDayView').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#mondayDayView').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("mondayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jShowAllFilterMondayWork(){
$('#mondayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#mondayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("mondayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jShowAllFilterMondaySchool(){
$('#mondayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#mondayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("mondayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jCompletedFilterTuesday(){
$('#tuesdayDayView').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#tuesdayDayView').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("tuesdayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jCompletedFilterTuesdayWork(){
$('#tuesdayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#tuesdayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("tuesdayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jCompletedFilterTuesdaySchool(){
$('#tuesdayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#tuesdayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("tuesdayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jNotCompletedFilterTuesday(){
$('#tuesdayDayView').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#tuesdayDayView').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("tuesdayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jNotCompletedFilterTuesdayWork(){
$('#tuesdayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#tuesdayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("tuesdayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jNotCompletedFilterTuesdaySchool(){
$('#tuesdayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#tuesdayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("tuesdayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jShowAllFilterTuesday(){
$('#tuesdayDayView').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#tuesdayDayView').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("tuesdayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jShowAllFilterTuesdayWork(){
$('#tuesdayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#tuesdayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("tuesdayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jShowAllFilterTuesdaySchool(){
$('#tuesdayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#tuesdayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("tuesdayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jCompletedFilterWednesday(){
$('#wednesdayDayView').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#wednesdayDayView').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("wednesdayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jCompletedFilterWednesdayWork(){
$('#wednesdayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#wednesdayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("wednesdayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jCompletedFilterWednesdaySchool(){
$('#wednesdayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#wednesdayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("wednesdayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jNotCompletedFilterWednesday(){
$('#wednesdayDayView').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#wednesdayDayView').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("wednesdayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jNotCompletedFilterWednesdayWork(){
$('#wednesdayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#wednesdayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("wednesdayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jNotCompletedFilterWednesdaySchool(){
$('#wednesdayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#wednesdayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("wednesdayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jShowAllFilterWednesday(){
$('#wednesdayDayView').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#wednesdayDayView').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("wednesdayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jShowAllFilterWednesdayWork(){
$('#wednesdayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#wednesdayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("wednesdayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jShowAllFilterWednesdaySchool(){
$('#wednesdayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#wednesdayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("wednesdayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jCompletedFilterThursday(){
$('#thursdayDayView').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#thursdayDayView').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("thursdayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jCompletedFilterThursdayWork(){
$('#thursdayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#thursdayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("thursdayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jCompletedFilterThursdaySchool(){
$('#thursdayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#thursdayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("thursdayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jNotCompletedFilterThursday(){
$('#thursdayDayView').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#thursdayDayView').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("thursdayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jNotCompletedFilterThursdayWork(){
$('#thursdayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#thursdayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("thursdayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jNotCompletedFilterThursdaySchool(){
$('#thursdayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#thursdayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("thursdayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jShowAllFilterThursday(){
$('#thursdayDayView').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#thursdayDayView').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("thursdayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jShowAllFilterThursdayWork(){
$('#thursdayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#thursdayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("thursdayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jShowAllFilterThursdaySchool(){
$('#thursdayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#thursdayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("thursdayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jCompletedFilterFriday(){
$('#fridayDayView').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#fridayDayView').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("fridayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jCompletedFilterFridayWork(){
$('#fridayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#fridayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("fridayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}function jCompletedFilterFridaySchool(){
$('#fridayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#fridayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("fridayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jNotCompletedFilterFriday(){
$('#fridayDayView').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#fridayDayView').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("fridayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jNotCompletedFilterFridayWork(){
$('#fridayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#fridayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("fridayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jNotCompletedFilterFridaySchool(){
$('#fridayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#fridayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("fridayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jShowAllFilterFriday(){
$('#fridayDayView').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#fridayDayView').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("fridayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jShowAllFilterFridayWork(){
$('#fridayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#fridayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("fridayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jShowAllFilterFridaySchool(){
$('#fridayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#fridayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("fridayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jCompletedFilterSaturday(){
$('#saturdayDayView').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#saturdayDayView').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("saturdayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jCompletedFilterSaturdayWork(){
$('#saturdayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#saturdayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("saturdayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jCompletedFilterSaturdaySchool(){
$('#saturdayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#saturdayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("saturdayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jNotCompletedFilterSaturday(){
$('#saturdayDayView').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#saturdayDayView').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("saturdayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jNotCompletedFilterSaturdayWork(){
$('#saturdayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#saturdayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("saturdayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jNotCompletedFilterSaturdaySchool(){
$('#saturdayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#saturdayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("saturdayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jShowAllFilterSaturday(){
$('#saturdayDayView').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#saturdayDayView').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("saturdayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jShowAllFilterSaturdayWork(){
$('#saturdayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#saturdayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("saturdayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jShowAllFilterSaturdaySchool(){
$('#saturdayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#saturdayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("saturdayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jCompletedFilterSunday(){
$('#sundayDayView').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#sundayDayView').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("sundayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jCompletedFilterSundayWork(){
$('#sundayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#sundayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("sundayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jCompletedFilterSundaySchool(){
$('#sundayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#sundayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).hide();
document.getElementById("sundayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Completed </font>';
}
function jNotCompletedFilterSunday(){
$('#sundayDayView').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#sundayDayView').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("sundayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jNotCompletedFilterSundayWork(){
$('#sundayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#sundayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("sundayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jNotCompletedFilterSundaySchool(){
$('#sundayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).hide();
$('#sundayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("sundayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Not Completed </font>';
}
function jShowAllFilterSunday(){
$('#sundayDayView').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#sundayDayView').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("sundayDayViewLabel").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jShowAllFilterSundayWork(){
$('#sundayDayViewWork').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#sundayDayViewWork').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("sundayDayViewLabelWork").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}
function jShowAllFilterSundaySchool(){
$('#sundayDayViewSchool').children().filter(function () {
return this.firstChild.checked;
}).show();
$('#sundayDayViewSchool').children().filter(function () {
return !this.firstChild.checked;
}).show();
document.getElementById("sundayDayViewLabelSchool").innerHTML = '<font-size="3"> Filtered By : Show All </font>';
}



function myFunctionUpcoming() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchUpcoming');
  filter = input.value.toUpperCase();
  ul = document.getElementById("upcoming");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionUpcomingSchool() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchUpcomingSchool');
  filter = input.value.toUpperCase();
  ul = document.getElementById("upcomingSchool");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionUpcomingWork() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchUpcomingWork');
  filter = input.value.toUpperCase();
  ul = document.getElementById("upcomingWork");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionAssigned() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchAssigned');
  filter = input.value.toUpperCase();
  ul = document.getElementById("assigned");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionAssignedSchool() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchAssignedSchool');
  filter = input.value.toUpperCase();
  ul = document.getElementById("assignedSchool");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionAssignedWork() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchAssignedWork');
  filter = input.value.toUpperCase();
  ul = document.getElementById("assignedWork");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}

function myFunctionNotes() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchNotes');
  filter = input.value.toUpperCase();
  ul = document.getElementById("notes");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionNotesSchool() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchNotesSchool');
  filter = input.value.toUpperCase();
  ul = document.getElementById("notesSchool");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionNotesWork() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchNotesWork');
  filter = input.value.toUpperCase();
  ul = document.getElementById("notesWork");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}

function myFunctionMonday() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchMonday');
  filter = input.value.toUpperCase();
  ul = document.getElementById("mondayDayView");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionTuesday() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchTuesday');
  filter = input.value.toUpperCase();
  ul = document.getElementById("tuesdayDayView");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionWednesday() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchWednesday');
  filter = input.value.toUpperCase();
  ul = document.getElementById("wednesdayDayView");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionThursday() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchThursday');
  filter = input.value.toUpperCase();
  ul = document.getElementById("thursdayDayView");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionFriday() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchFriday');
  filter = input.value.toUpperCase();
  ul = document.getElementById("fridayDayView");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionSaturday() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchSaturday');
  filter = input.value.toUpperCase();
  ul = document.getElementById("saturdayDayView");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionSunday() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchSunday');
  filter = input.value.toUpperCase();
  ul = document.getElementById("sundayDayView");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}


function myFunctionMondaySchool() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchMondaySchool');
  filter = input.value.toUpperCase();
  ul = document.getElementById("mondayDayViewSchool");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionTuesdaySchool() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchTuesdaySchool');
  filter = input.value.toUpperCase();
  ul = document.getElementById("tuesdayDayViewSchool");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionWednesdaySchool() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchWednesdaySchool');
  filter = input.value.toUpperCase();
  ul = document.getElementById("wednesdayDayViewSchool");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionThursdaySchool() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchThursdaySchool');
  filter = input.value.toUpperCase();
  ul = document.getElementById("thursdayDayViewSchool");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionFridaySchool() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchFridaySchool');
  filter = input.value.toUpperCase();
  ul = document.getElementById("fridayDayViewSchool");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionSaturdaySchool() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchSaturdaySchool');
  filter = input.value.toUpperCase();
  ul = document.getElementById("saturdayDayViewSchool");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionSundaySchool() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchSundaySchool');
  filter = input.value.toUpperCase();
  ul = document.getElementById("sundayDayViewSchool");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}


function myFunctionMondayWork() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchMondayWork');
  filter = input.value.toUpperCase();
  ul = document.getElementById("mondayDayViewWork");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionTuesdayWork() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchTuesdayWork');
  filter = input.value.toUpperCase();
  ul = document.getElementById("tuesdayDayViewWork");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionWednesdayWork() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchWednesdayWork');
  filter = input.value.toUpperCase();
  ul = document.getElementById("wednesdayDayViewWork");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionThursdayWork() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchThursdayWork');
  filter = input.value.toUpperCase();
  ul = document.getElementById("thursdayDayViewWork");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionFridayWork() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchFridayWork');
  filter = input.value.toUpperCase();
  ul = document.getElementById("fridayDayViewWork");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionSaturdayWork() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchSaturdayWork');
  filter = input.value.toUpperCase();
  ul = document.getElementById("saturdayDayViewWork");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
function myFunctionSundayWork() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchSundayWork');
  filter = input.value.toUpperCase();
  ul = document.getElementById("sundayDayViewWork");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}


// function sortListDirUpcoming() {
    // $($('ul.upcoming>li').get().reverse()).each(function(outer) {
        // var sorting = this;
        // $($('ul.upcoming>li').get().reverse()).each(function(inner) {
            // if($('label.TaskLabel', this).text().localeCompare($('label.TaskLabel', sorting).text()) < 0) {
                // this.parentNode.insertBefore(sorting.parentNode.removeChild(sorting), this);
			// }
        // });
    // });
// }
function sortListDirUpcoming() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("upcoming");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirUpcomingWork() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("upcomingWork");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirUpcomingSchool() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("upcomingSchool");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}


function sortListDirAssigned() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("assigned");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirAssignedWork() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("assignedWork");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirAssignedSchool() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("assignedSchool");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}


function sortListDirNotes() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("notes");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirNotesWork() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("notesWork");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirNotesSchool() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("notesSchool");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirMonday() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("mondayDayView");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}

function sortListDirTuesday() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("tuesdayDayView");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirWednesday() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("wednesdayDayView");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirThursday() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("thursdayDayView");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirFriday() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("fridayDayView");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirSaturday() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("saturdayDayView");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirSunday() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("sundayDayView");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
// var span = document.getElementsByClassName("close")[0];
var modal = document.getElementById("myModal");
// var modalcontent = document.getElementsByClassName("modal-content");
// var btn = document.getElementsByClassName("modal-btn");
// var modals = document.querySelectorAll(".modal");
// function openmodal(){
  // modal.style.display = "block";
// }
// function openmodal(self){
	// if (btn.id == $(".modal").id){
		// modals[index].style.display = "block";
	// }
// }

// function onspanClick() {
  // modal.style.display = "none";
// }

// window.onclick = function(event) {
  // if (event.target == modal) {
    // modal.style.display = "none";
  // }
// }


function sortListDirMondayWork() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("mondayDayViewWork");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}

function sortListDirTuesdayWork() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("tuesdayDayViewWork");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirWednesdayWork() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("wednesdayDayViewWork");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirThursdayWork() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("thursdayDayViewWork");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirFridayWork() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("fridayDayViewWork");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirSaturdayWork() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("saturdayDayViewWork");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirSundayWork() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("sundayDayViewWork");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}


function sortListDirMondaySchool() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("mondayDayViewSchool");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}

function sortListDirTuesdaySchool() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("tuesdayDayViewSchool");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirWednesdaySchool() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("wednesdayDayViewSchool");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirThursdaySchool() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("thursdayDayViewSchool");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirFridaySchool() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("fridayDayViewSchool");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirSaturdaySchool() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("saturdayDayViewSchool");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
function sortListDirSundaySchool() {
  var list, i, switching, b, shouldSwitch, dir, switchcount = 0;
  list = document.getElementById("sundayDayViewSchool");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  // Make a loop that will continue until no switching has been done:
  while (switching) {
    // start by saying: no switching is done:
    switching = false;
    b = list.getElementsByTagName("LI");
    // Loop through all list-items:
    for (i = 0; i < (b.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /* check if the next item should switch place with the current item,
      based on the sorting direction (asc or desc): */
      if (dir == "asc") {
        if (b[i].innerHTML.toLowerCase() > b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically lower than current item,
          mark as a switch and break the loop: */
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (b[i].innerHTML.toLowerCase() < b[i + 1].innerHTML.toLowerCase()) {
          /* if next item is alphabetically higher than current item,
          mark as a switch and break the loop: */
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      b[i].parentNode.insertBefore(b[i + 1], b[i]);
      switching = true;
      // Each time a switch is done, increase switchcount by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
// var span = document.getElementsByClassName("close")[0];
// var modal = document.getElementById("v0fncjqnvzdwjotdlpoap");

// When the user clicks the button, open the modal 
// function openmodal(){
  // modal.style.display = "block";
// }

// When the user clicks on <span> (x), close the modal
// function onspanClick() {
  // modal.style.display = "none";
// }

// window.onclick = function(event) {
  // if (event.target == modal) {
    // modal.style.display = "none";
  // }
// }

// var openModalContent = function(self){
	// if (modal.id !== self.id){
		// modal.style.display="block";
	// }
// }




var myList = document.getElementById("upcoming");
var formValues = []
var retrievedScores = JSON.parse(localStorage.getItem("formValues"));
var deleteById = function ( self ){
  retrievedScores = retrievedScores.filter(function(elem) {
      return elem.id !== self.id;
  });
  localStorage.setItem("formValues",JSON.stringify(retrievedScores));
  self.parentNode.parentNode.removeChild(self.parentNode);
  window.location.reload();
}

var span = document.getElementsByClassName("close")[0];

function closeModal() {
  modal.style.display = "none";
}
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
var modal = document.getElementById("myModal");
window.onload = function loadPage() {

var now = moment();

document.getElementById("weekHeader").innerHTML += "WEEK " + moment().isoWeek() + " - " + now.clone().isoWeekday(1).format('dddd Do MMMM YYYY') + " - " + now.clone().isoWeekday(7).format('dddd Do MMMM YYYY');
var now = moment();
var monday = now.clone().isoWeekday(1).format('dddd Do MMMM yyyy');
var tuesday = now.clone().isoWeekday(2).format('dddd Do MMMM yyyy');
var wednesday = now.clone().isoWeekday(3).format('dddd Do MMMM yyyy');
var thursday = now.clone().isoWeekday(4).format('dddd Do MMMM yyyy');
var friday = now.clone().isoWeekday(5).format('dddd Do MMMM yyyy');
var saturday = now.clone().isoWeekday(6).format('dddd Do MMMM yyyy');
var sunday = now.clone().isoWeekday(7).format('dddd Do MMMM yyyy');


document.getElementById("MondayTask").innerHTML += monday
document.getElementById("TuesdayTask").innerHTML += tuesday
document.getElementById("WednesdayTask").innerHTML += wednesday
document.getElementById("ThursdayTask").innerHTML += thursday
document.getElementById("FridayTask").innerHTML += friday
document.getElementById("SaturdayTask").innerHTML += saturday
document.getElementById("SundayTask").innerHTML += sunday

document.getElementById("MondayTaskWork").innerHTML += monday
document.getElementById("TuesdayTaskWork").innerHTML += tuesday
document.getElementById("WednesdayTaskWork").innerHTML += wednesday
document.getElementById("ThursdayTaskWork").innerHTML += thursday
document.getElementById("FridayTaskWork").innerHTML += friday
document.getElementById("SaturdayTaskWork").innerHTML += saturday
document.getElementById("SundayTaskWork").innerHTML += sunday

document.getElementById("MondayTaskSchool").innerHTML += monday
document.getElementById("TuesdayTaskSchool").innerHTML += tuesday
document.getElementById("WednesdayTaskSchool").innerHTML += wednesday
document.getElementById("ThursdayTaskSchool").innerHTML += thursday
document.getElementById("FridayTaskSchool").innerHTML += friday
document.getElementById("SaturdayTaskSchool").innerHTML += saturday
document.getElementById("SundayTaskSchool").innerHTML += sunday


var tasks = JSON.stringify(formValues);
var formValues = JSON.parse(localStorage.formValues);
var assignList = document.getElementById("assigned");
var notesList = document.getElementById("notes");
var now = moment();
var mondayList = document.getElementById("mondayDayView");
var tuesdayList = document.getElementById("tuesdayDayView");
var wednesdayList = document.getElementById("wednesdayDayView");
var thursdayList = document.getElementById("thursdayDayView");
var fridayList = document.getElementById("fridayDayView");
var saturdayList = document.getElementById("saturdayDayView");
var sundayList = document.getElementById("sundayDayView");
var myList = document.getElementById("upcoming");
var retrievedForm = JSON.parse(localStorage.getItem("formValues"));
var myListWork = document.getElementById("upcomingWork");
var myListSchool = document.getElementById("upcomingSchool");

for (var i = 0; i < retrievedForm.length; i++){
var input = moment(retrievedForm[i].deadline);
if(now.isoWeek() == input.isoWeek() && retrievedForm[i].type == "Home"){
	var liTask = document.createElement('li');
	liTask.innerHTML = "<input type='checkbox' class='myCheckbox' id="+retrievedForm[i].id+"><label class='TaskLabel' id='TaskLabel'>" + retrievedForm[i].name + " (" + retrievedForm[i].priority + ") " + "</label>" + "<a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
// myList.innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedForm[i].name + " (" + retrievedForm[i].priority + ") " + "</label>" + "<a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
document.getElementById("modalHolder").innerHTML += "<div id="+retrievedForm[i].modalID+" class='modal'><div class='modal-content'><div class='modal-header'><span class='close' onclick='closeModal()'>&times;</span><h2>"+retrievedForm[i].name+"</h2></div><div class='modal-body'><p>" + "Priority: " + retrievedForm[i].priority + " <br> Deadline: " + retrievedForm[i].deadline + "<br> Assigned to: " + retrievedForm[i].assign + "<br> Length (minutes): " + retrievedForm[i].length + "<br> Task type: " + retrievedForm[i].type + "<br> Notes: " + retrievedForm[i].notes + "</p></div><div class='modal-footer'><h3></h3></div></div></div> "
var modalButn = document.createElement("button");
modalButn.textContent = "Open Modal";
modalButn.className = "modal-btn";
modalButn.innerHTML = "<i class='bi bi-info-circle-fill' aria-hidden='true'></i>";
modalButn.title = "Information icon";
modalButn.id = "#"+retrievedForm[i].modalID;
modalButn.addEventListener("click", function(e) {
      e.preventDefault();
	  modal = document.querySelector(this.getAttribute("id"));
	  modal.style.display = "block";
    });
liTask.appendChild(modalButn);
myList.appendChild(liTask);
}if(now.isoWeek() == input.isoWeek() && retrievedForm[i].assign != "No One" && retrievedForm[i].type == "Home"){
assignList.innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedForm[i].name + " (" + retrievedForm[i].priority + ") " + " - " + retrievedForm[i].assign + " </label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(retrievedForm[i].notes != '' && now.isoWeek() == input.isoWeek() && retrievedForm[i].type == "Home"){
notesList.innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedForm[i].name + " (" + retrievedForm[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a><br><small>" + retrievedForm[i].notes +  "</small>" + " " + "</li>"
}if(now.isoWeek() > input.isoWeek() && retrievedForm[i].type == "Home"){
	var liTaskLate = document.createElement('li');
	var modalButnLate = document.createElement('button');
modalButnLate.className = "modal-btn";
modalButnLate.innerHTML = "<i class='bi bi-info-circle-fill' aria-hidden='true'></i>";
modalButnLate.id = "#"+retrievedForm[i].modalID;
modalButnLate.title = "Information icon";
modalButnLate.addEventListener("click", function(e) {
      e.preventDefault();
	  modal = document.querySelector(this.getAttribute("id"));
	  modal.style.display = "block";
    });
liTaskLate.innerHTML = "<input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel' style='color:red;'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a>"
document.getElementById("modalHolder").innerHTML += "<div id="+retrievedForm[i].modalID+" class='modal'><div class='modal-content'><div class='modal-header'><span class='close' onclick='closeModal()'>&times;</span><h2>"+retrievedForm[i].name+"</h2></div><div class='modal-body'><p>" + "Priority: " + retrievedForm[i].priority + " <br> Deadline: " + retrievedForm[i].deadline + "<br> Assigned to: " + retrievedForm[i].assign + "<br> Length (minutes): " + retrievedForm[i].length + "<br> Task type: " + retrievedForm[i].type + "<br> Notes: " + retrievedForm[i].notes + "</p></div><div class='modal-footer'><h3></h3></div></div></div> "
liTaskLate.appendChild(modalButnLate);
myList.appendChild(liTaskLate);
mondayList.innerHTML += "<li class='box' style='color:#FF3333;'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel style='color:red;'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(1).isSame(retrievedForm[i].deadline, 'day') && retrievedForm[i].type == "Home"){
mondayList.innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(2).isSame(retrievedForm[i].deadline, 'day') && retrievedForm[i].type == "Home"){
tuesdayList.innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(3).isSame(retrievedForm[i].deadline, 'day')&& retrievedForm[i].type == "Home"){
wednesdayList.innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(4).isSame(retrievedForm[i].deadline, 'day')&& retrievedForm[i].type == "Home"){
thursdayList.innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(5).isSame(retrievedForm[i].deadline,'day')&& retrievedForm[i].type == "Home"){
fridayList.innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(6).isSame(retrievedForm[i].deadline, 'day')&& retrievedForm[i].type == "Home"){
saturdayList.innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(7).isSame(retrievedForm[i].deadline, 'day')&& retrievedForm[i].type == "Home"){
sundayList.innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(now.isoWeek() == input.isoWeek() && retrievedForm[i].type == "Work"){
var liTaskWork = document.createElement('li');
liTaskWork.innerHTML = "<input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedForm[i].name + " (" + retrievedForm[i].priority + ") " + "</label>" + "<a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a>"
document.getElementById("modalHolder").innerHTML += "<div id="+retrievedForm[i].modalID+" class='modal'><div class='modal-content'><div class='modal-header'><span class='close' onclick='closeModal()'>&times;</span><h2>"+retrievedForm[i].name+"</h2></div><div class='modal-body'><p>" + "Priority: " + retrievedForm[i].priority + " <br> Deadline: " + retrievedForm[i].deadline + "<br> Assigned to: " + retrievedForm[i].assign + "<br> Length (minutes): " + retrievedForm[i].length + "<br> Task type: " + retrievedForm[i].type + "<br> Notes: " + retrievedForm[i].notes + "</p></div><div class='modal-footer'><h3></h3></div></div></div> "
var modalButnWork = document.createElement('button');
modalButnWork.className = "modal-btn";
modalButnWork.innerHTML = "<i class='bi bi-info-circle-fill' aria-hidden='true'></i>";
modalButnWork.title = "Information icon";
modalButnWork.id = "#"+retrievedForm[i].modalID;
modalButnWork.addEventListener("click", function(e) {
      e.preventDefault();
	  modal = document.querySelector(this.getAttribute("id"));
	  modal.style.display = "block";
    });
liTaskWork.appendChild(modalButnWork);
myListWork.appendChild(liTaskWork);
}if(now.isoWeek() == input.isoWeek() && retrievedForm[i].assign != "No One" && retrievedForm[i].type == "Work"){
document.getElementById("assignedWork").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedForm[i].name + " (" + retrievedForm[i].priority + ") " + " - " + retrievedForm[i].assign + " </label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(retrievedForm[i].notes != '' && now.isoWeek() == input.isoWeek() && retrievedForm[i].type == "Work"){
document.getElementById("notesWork").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedForm[i].name + " (" + retrievedForm[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a><br><small>" + retrievedForm[i].notes +  "</small>" + " " + "</li>"
}if(now.isoWeek() > input.isoWeek() && retrievedForm[i].type == "Work"){
document.getElementById("upcomingWork").innerHTML += "<li class='box' style='color:#FF3333;'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel' style='color:red;'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
document.getElementById("mondayDayViewWork").innerHTML += "<li class='box' style='color:#FF3333;'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel style='color:red;'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(1).isSame(retrievedForm[i].deadline, 'day') && retrievedForm[i].type == "Work"){
document.getElementById("mondayDayViewWork").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(2).isSame(retrievedForm[i].deadline, 'day') && retrievedForm[i].type == "Work"){
document.getElementById("tuesdayDayViewWork").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(3).isSame(retrievedForm[i].deadline, 'day')&& retrievedForm[i].type == "Work"){
document.getElementById("wednesdayDayViewWork").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(4).isSame(retrievedForm[i].deadline, 'day')&& retrievedForm[i].type == "Work"){
document.getElementById("thursdayDayViewWork").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(5).isSame(retrievedForm[i].deadline,'day')&& retrievedForm[i].type == "Work"){
document.getElementById("fridayDayViewWork").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(6).isSame(retrievedForm[i].deadline, 'day')&& retrievedForm[i].type == "Work"){
document.getElementById("saturdayDayViewWork").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(7).isSame(retrievedForm[i].deadline, 'day')&& retrievedForm[i].type == "Work"){
document.getElementById("sundayDayViewWork").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(now.isoWeek() == input.isoWeek() && retrievedForm[i].type == "School"){
	var liTaskSchool = document.createElement('li');
	liTaskSchool.innerHTML = "<input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedForm[i].name + " (" + retrievedForm[i].priority + ") " + "</label>" + "<a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a>"
	document.getElementById("modalHolder").innerHTML += "<div id="+retrievedForm[i].modalID+" class='modal'><div class='modal-content'><div class='modal-header'><span class='close' onclick='closeModal()'>&times;</span><h2>"+retrievedForm[i].name+"</h2></div><div class='modal-body'><p>" + "Priority: " + retrievedForm[i].priority + " <br> Deadline: " + retrievedForm[i].deadline + "<br> Assigned to: " + retrievedForm[i].assign + "<br> Length (minutes): " + retrievedForm[i].length + "<br> Task type: " + retrievedForm[i].type + "<br> Notes: " + retrievedForm[i].notes + "</p></div><div class='modal-footer'><h3></h3></div></div></div> "
var modalButnSchool = document.createElement('button');
modalButnSchool.className = "modal-btn";
modalButnSchool.innerHTML = "<i class='bi bi-info-circle-fill' aria-hidden='true'></i>";
modalButnSchool.title = "Information icon";
modalButnSchool.id = "#"+retrievedForm[i].modalID;
modalButnSchool.addEventListener("click", function(e) {
      e.preventDefault();
	  modal = document.querySelector(this.getAttribute("id"));
	  modal.style.display = "block";
    });
liTaskSchool.appendChild(modalButnSchool);
myListSchool.appendChild(liTaskSchool);
}if(now.isoWeek() == input.isoWeek() && retrievedForm[i].assign != "No One" && retrievedForm[i].type == "School"){
document.getElementById("assignedSchool").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedForm[i].name + " (" + retrievedForm[i].priority + ") " + " - " + retrievedForm[i].assign + " </label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(retrievedForm[i].notes != '' && now.isoWeek() == input.isoWeek() && retrievedForm[i].type == "School"){
document.getElementById("notesSchool").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedForm[i].name + " (" + retrievedForm[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a><br><small>" + retrievedForm[i].notes +  "</small>" + " " + "</li>"
}if(now.isoWeek() > input.isoWeek() && retrievedForm[i].type == "School"){
document.getElementById("upcomingSchool").innerHTML += "<li class='box' style='color:#FF3333;'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel' style='color:red;'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
document.getElementById("mondayDayViewSchool").innerHTML += "<li class='box' style='color:#FF3333;'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel style='color:red;'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(1).isSame(retrievedForm[i].deadline, 'day') && retrievedForm[i].type == "School"){
document.getElementById("mondayDayViewSchool").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(2).isSame(retrievedForm[i].deadline, 'day') && retrievedForm[i].type == "School"){
document.getElementById("tuesdayDayViewSchool").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(3).isSame(retrievedForm[i].deadline, 'day')&& retrievedForm[i].type == "School"){
document.getElementById("wednesdayDayViewSchool").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(4).isSame(retrievedForm[i].deadline, 'day')&& retrievedForm[i].type == "School"){
document.getElementById("thursdayDayViewSchool").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(5).isSame(retrievedForm[i].deadline,'day')&& retrievedForm[i].type == "School"){
document.getElementById("fridayDayViewSchool").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(6).isSame(retrievedForm[i].deadline, 'day')&& retrievedForm[i].type == "School"){
document.getElementById("saturdayDayViewSchool").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}if(moment().isoWeekday(7).isSame(retrievedForm[i].deadline, 'day')&& retrievedForm[i].type == "School"){
document.getElementById("sundayDayViewSchool").innerHTML += "<li class='box'><input type='checkbox' class='myCheckbox' id='myCheckbox'/><label class='TaskLabel' id='TaskLabel'>" + retrievedScores[i].name + " (" + retrievedScores[i].priority + ") " + "</label><a title='Delete Task' class='closeTask' id="+retrievedScores[i].id + " href='#' onclick='deleteById(this)'><i class='bi bi-x-circle'></i></a></li>"
}
}
<!-- document.getElementById("myModal").innerHTML += "<div class='modal-content'><span class='close' onclick='onspanClick()'>&times;</span><p>" + item.name + "<br>" + item.deadline + "</p></div>"; <button id='modalbtn' onclick='openmodal();'>Open Modal</button> -->



}



function newTask() {
window.open('addtask.html', '_self'	);
}

function signOut() {
if (confirm('Are you sure you want to logout?')) {
  window.open('../index.html', '_self'	);
} else {
}
}

function signOutColor() {
if (confirm('Are you sure you want to logout?')) {
  window.open('../index.html', '_self'	);
} else {
}
}

function deleteAcc() {
if (confirm('Are you sure you want to delete your account? You will lose all data and will have to register for a new account if you change your mind')) {
  window.open('../index.html', '_self'	);
} else {
}
}

function deleteAccColor() {
if (confirm('Are you sure you want to delete your account? You will lose all data and will have to register for a new account if you change your mind')) {
  window.open('../index.html', '_self'	);
} else {
}
}

function clearStorage() {
if (confirm('Are you sure you want to clear all tasks from the system?')){
	localStorage.clear();
	window.open('dashboard.html', '_self'); 
	}else {}
	}
var homeView = document.getElementById("homeDashboard");
$(document).ready(function(){
  $(".switch input").on("change", function(e) {
    const isOn = e.currentTarget.checked;
	const isOff = !e.currentTarget.checked;

    if (isOn && $(".WeekTaskView").css('display')=='block') {
        $(".WeekTaskView").hide();
		$(".DayTaskView").show();
		$(".workView").hide();
		$(".workDayView").hide();
		$(".schoolDayView").hide();
		$(".schoolView").hide();
    } else if ($(".DayTaskView").css('display')=='block'){
        $(".WeekTaskView").show();
		$(".DayTaskView").hide();
		$(".workView").hide();
		$(".workDayView").hide();
		$(".schoolDayView").hide();
		$(".schoolView").hide();
    }else if($(".workView").css('display')=='block'){
		$(".DayTaskView").hide();
		$(".workView").hide();
		$(".WeekTaskView").hide();
		$(".workDayView").show();
		$(".schoolDayView").hide();
		$(".schoolView").hide();
		}else if ($(".workDayView").css('display')=='block'){
		$(".DayTaskView").hide();
		$(".workView").show();
		$(".WeekTaskView").hide();
		$(".workDayView").hide();
		$(".schoolDayView").hide();
		$(".schoolView").hide();
		}else if ($(".schoolView").css('display')=='block'){
		$(".DayTaskView").hide();
		$(".workView").hide();
		$(".WeekTaskView").hide();
		$(".workDayView").hide();
		$(".schoolDayView").show();
		$(".schoolView").hide();
		}else if ($(".schoolDayView").css('display')=='block'){
		$(".DayTaskView").hide();
		$(".workView").hide();
		$(".WeekTaskView").hide();
		$(".workDayView").hide();
		$(".schoolDayView").hide();
		$(".schoolView").show();
  }
  });
});

function showWork() {
   $('.workView').show();
   $('.WeekTaskView').hide();
   $(".DayTaskView").hide();
   $(".workDayView").hide();
   $('.schoolView').hide();
   $(".schoolDayView").hide();
   $('#toggleSwitch').prop('checked', false);
}

function showHome() {
   $('.workView').hide();
   $('.schoolView').hide();
   $('.WeekTaskView').show();
   $(".DayTaskView").hide();
   $(".workDayView").hide();
   $(".schoolDayView").hide();
   $('#toggleSwitch').prop('checked', false);
}

function showSchool() {
   $('.schoolView').show();
   $('.workView').hide();
   $('.WeekTaskView').hide();
   $(".DayTaskView").hide();
   $(".workDayView").hide();
   $(".schoolDayView").hide();
   $('#toggleSwitch').prop('checked', false);
   }
   
function addGroup() {
window.open('addgroup.html', '_self'	);
}
function newTaskColor() {
window.open('addtask.html', '_self'	);
}
function addGroupColor() {
window.open('addgroup.html', '_self'	);
}

function editTask() {
window.open('edittask.html', '_self'	);
}
function editTaskColor() {
window.open('edittask.html', '_self'	);
}

function openCalendar() {
window.open('calendar.html', '_self'	);
}
function openCalendarColor() {
window.open('calendar.html', '_self'	);
}

function openMyAcc() {
window.open('myaccount.html', '_self'	);
}


function openMyAccColor() {
window.open('myaccount.html', '_self'	);
}

function openMygroupColor() {
window.open('mygroup.html', '_self'	);
}

function openMygroup() {
window.open('mygroup.html', '_self'	);
}

function colorSelected (element) {
    document.getElementById("columnBelow").style.background = element.value
}

function openColour() {
window.open('colorcustom.html', '_self'	);
}

function openColourSelf() {
window.open('colorcustom.html', '_self'	);
}

function backHome() {
window.open('dashboard.html', '_self'	);
}
document.getElementById("printOver").addEventListener("click", function() {
     var printContents = document.getElementById('col1').innerHTML;
     var printContents1 = document.getElementById('col2').innerHTML;
     var printContents2 = document.getElementById('col3').innerHTML;
     var originalContents = document.body.innerHTML;
     document.body.innerHTML = printContents + printContents1 + printContents2;
     window.print();
     document.body.innerHTML = originalContents;
	 window.open("dashboard.html", "_self");
});

function printOverview() {
alert("You cannot print this page");
}

function openNotifications() {
window.open('notification.html', '_self'	);
}

function openNotificationsColor() {
window.open('notification.html', '_self'	);
}