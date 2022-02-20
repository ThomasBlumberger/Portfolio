    const loginForm = document.getElementById("login");
	const loginButton = document.getElementById("log");
	const loginErrorMsg = document.getElementById("login-error-msg");

loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    const username = loginForm.Uname.value;
    const password = loginForm.Pass.value;

	if (username === "User" && password === "password"){
	window.open('html/dashboard.html', '_self')
}	else if (username === "user" && password === "password") {
        window.open('html/dashboard.html', '_self'	)
    } else {
        loginErrorMsg.style.opacity = 1;
    }
})

function backLogin() {
window.open('../index.html', '_self'	);
}

function createAccount() {
window.open('html/createaccount.html', '_self'	);
}

function forgotUser() {
alert("Username reminder sent");
}

function forgotUserNav() {
window.open('html/forgotuser.html', '_self'	);
}

function forgotPassNav() {
window.open('html/forgotpassword.html', '_self'	);
}

function forgotPass() {
alert("Password reset link sent");
}

 function checkPassword(form) {
                password1 = document.getElementById("createAcc").password1.value;
                password2 = document.getElementById("createAcc").password2.value;
				
				if (password1 != password2) {
                    alert ("\nPassword did not match: Please try again...")
                    return false;
                }
  
                // If same return True.
                else{
                    window.open('dashboard.html', '_self'	);
                    return true;
                }
            }