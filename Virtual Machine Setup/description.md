I'm hosting a Spring Boot Web Application on a Linux Virtual Machine in Azure. Its a Movie Website that uses the MYSQL database to hold the users information and its using the Movie Db API for all the movie information.



**Features of the movie website:**



* Users must login to view the movie website
* Users can register and create an account
* Users can view the current most popular movies
* Users can view movies by any selected genre
* Users can Search for any movie
* Users can watch videos about any movie. This can be trailers, behind the scenes, interviews,  cut scenes etc





**How I'm hosting the website:**



* I'm using the setup.ps1 file to have all the Azure resources created at once, so there is no need to manually create these resources



**What's in the setup.ps1 file:**



* Creating a resource group to hold all the necessary Azure resources. Resource Group wont be created if already exist and user will be notified of this.
* Creating a Linux Virtual Machine because it acts as a place to run my application on the cloud for public access.
* Using a Virtual Network for connecting the virtual machine to a network and in the case I want to deploy another Virtual Machine that's Windows, it will support both Virtual Machines and allow effective communication with each of them.
* Opening port 8080 for the Virtual Machine to allow public access.





**The use of the vm\_init file:**



* Im using the vm\_init.yml file to avoid the need for manually setting up the Virtual Machine environment. It runs only once and that's when the Virtual Machine runs for the first time.
* Its downloading the packages for MySQL server and MySQL Client for the use of MYSQL Database on the Virtual Machine. Its also downloading openjdk-17-jdk so it can run the Spring Boot Web Application on the Virtual machine
* The file called movieDatabase.sql will create  movie\_project database with the with tables for users and genre. And create the user and password for MySQL database and give it permission to use it.
* The file movieDatabaseDataSet.sql is used to create inserts for the database table
* The file database.properties is used for database connection
* Runcmd will be used to run commands to start and enable MySQL, creation of folder with permissions to hold the Spring Boot Web Application jar file, run movieDatabase.sql and movieDatabaseDataSet.sql files for database creation, inserts for tables and creation of users/password for MYSQL while also granting permissions.





**How I will use SFTP:**



* Will be used to transfer the Spring Boot Application jar file to the Virtual Machine folder holdJar





**How I'm using the teardown.ps1 file:**



* Will check if the resource group exist to be deleted and if not a response will be given to the user
* If resource group exist, it will use a command to delete the resource group
