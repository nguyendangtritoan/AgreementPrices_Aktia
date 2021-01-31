# **Agreement Service**

## `What is it ?`

   This application is both Frontend built with React and Backend built with Springboot 
   
   Backend contains API endpoint service for Customer agreement.
   Frontend contains user interface service for Customer agreement.

## `Build with`

* Java
* SpringBoot
* Maven
* React

## `Usage`
#### Backend side
*   You can download the zip file to run the application rest api [Link](https://drive.google.com/drive/folders/1yon4KaTzI1KiMijN6gSLIs9EVayaxjfU?usp=sharing).
*   In order to run this application, you need to have Java sdk (Recommend use 1.8) [Link to download](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
*   In your terminal, navigate to the folder [target](target).
*   Please provide your database information at 

        /src/main/resources/application.properties
*   Change username and password
*   Execute below command in your terminal
    * #### `java -jar agreement-0.0.1-SNAPSHOT.jar`

*   Now you can use the application. The application is running at:
    * #### `http://localhost:8080/`
#### Frontend side
*   After cloning this repository, navigate to **src/main/frontend** then run:
    
    #### `npm install`
    
    #### `npm start`     
      
## `Functionality`
#### Read (get)

    http://localhost:8080/customer/list => list all customers  
    http://localhost:8080/service/list => list all services   
    http://localhost:8080/agreement/list => list all agreements
    
#### Add (post method)

    http://localhost:8080/customer/save
    http://localhost:8080/service/save
    http://localhost:8080/agreement/save
    
#### Update (put method)

    http://localhost:8080/customer/update
    http://localhost:8080/service/update
    http://localhost:8080/agreement/update
    
#### Delete (Delete method)

    http://localhost:8080/customer/delete/{id}    
    http://localhost:8080/service/delete/{id}   
    http://localhost:8080/agreement/delete/{id}
    
#### Other
    http://localhost:8080/customerById/{id}   
    http://localhost:8080/customerByName/{name}    
    http://localhost:8080/agreementById/{id}   
    http://localhost:8080/agreementByCusId/{id}
    http://localhost:8080/serviceById/{id}
    

## `Source code`

 Source code place under /src folder

## `Test`

 Unit test also integration test place under /test folder
 
 To test, we could open Eclipse IDE or IntelliJ and run the test. Make sure you already have JUnit in maven dependency folder. 
  
 What simple it is !!

## `Author`
   * [Nguyen Dang Toan](https://www.linkedin.com/in/nguyendangtoan/)
   * Email: [nguyendangtritoan2305@gmail.com]()

