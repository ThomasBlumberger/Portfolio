<h1>Installation instructions (To run on localhost):</h1>

<h2>Prerequisites:</h2>

* Spring Tool Suite 4
* Java SE development kit 11
* MySQL Workbench 8

<h2>mySQL Setup:</h2>

* Click the plus icon next to “MySQL Connections”
* Enter the following details into the connection
    * Connection name: (Any)
    * Username: root
    * Password: *any*
    * Hostname: localhost
    * Port: 3306
* Click the connection to open it
* Open the schemas tab in the navigator
* Right click in schemas menu, and click “create schema”
* Name the schema co2101db
<h2>Install Application:</h2>

* On the git page, click the download icon, and download as zip.
* Find the folder called “scrum-06” (the one containing the src and gradle folders) and copy it to any desired location.
* Open spring tool suite 4
* Click file, import, and select import as “existing gradle project”.
* For the project root directory, browse and select the folder named “scrum-06” you copied earlier.
* Click finish.
* Wait for the project to be loaded, right-click the project file in the project explorer, and click refresh.
* Go onto application.properties in src/main/resources and enter the  sql connection username (root) and password you set earlier into the appropriate places
* Right-click the project, then click “Spring Boot App” under “Run As”.
* Wait for the application to compile.
* To test, open a browser, and enter “https://localhost:8443”.
* Select proceed to site if warning appear.
* If running correctly, you should see a login menu.

<h2>Admin setup:</h2>

* As username, enter “admin1”
* As password, enter “GiveUs100%”
* To add convenors, click add convenors in the left pane, and fill in the form.
* Convenors can then login with their username and the password “1234”, they should login and change their email, then reset their password asap.
