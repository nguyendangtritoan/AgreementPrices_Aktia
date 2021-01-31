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
      
## Functionality
#### Read (get)

    http://localhost:8080/customers => list all customers  
    http://localhost:8080/services => list all services   
    http://localhost:8080/agreements => list all agreements
    
#### Add (post method)

    http://localhost:8080/addCustomer   
    http://localhost:8080/addAgreement   
    http://localhost:8080/addService
    
#### Update (put method)

    http://localhost:8080/updateCustomer    
    http://localhost:8080/updateAgreement  
    http://localhost:8080/updateService
    
#### Delete (Delete method)

    http://localhost:8080/deleteCustomer/{id}    
    http://localhost:8080/deleteAgreement/{id}   
    http://localhost:8080/deleteService/{id}
    
#### Other
    http://localhost:8080/customerById/{id}   
    http://localhost:8080/customer/{name}    
    http://localhost:8080/agreementById/{id}   
    http://localhost:8080/agreementByCusId/{id}
    http://localhost:8080/getServiceById/{id}
    

## `Source code`

 Source code place under /src folder

## `Test`

 Unit test also integration test place under /test folder
 
 To test, we could open Eclipse IDE or IntelliJ and run the test. Make sure you already have JUnit in maven dependency folder. 
  
 What simple it is !!

## `Author`
   * [Nguyen Dang Toan](https://www.linkedin.com/in/nguyendangtoan/)
   * Email: [nguyendangtritoan2305@gmail.com]()

