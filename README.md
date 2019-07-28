# Overview
This repository comprises of three project in three folder. The folders are as following-
* uiautomation - _Script to automate web application and bug report_
* apiautomation - _Script to automate rest api and bug report_
* loadtest - _Reports and performance analysis of load test of a web application_
<br>

## 1. uiautomation (Web Application Automation)
> uiautomation is divided into three section -
> * TestApplication - _A web application which will be used for automation testing_
> * Bug report - _A folder that contains bug report_
> * Automation framework - _Rest of the folder and files is used for automation_
> 
> ### TestApplication
> For more information, please follow the link [here](https://git.toptal.com/screening/md-samsul-kabir/tree/master/uiautomation/TestApplication)
> 
> ### Bug report
> To access bug report, please [visit](https://git.toptal.com/screening/md-samsul-kabir/tree/master/uiautomation/Bug%20report)
> 
> ### Automation framework
> Things has been covered:
> * Script
> * CI/CD using Jenkins
> * Executing from cloud
> 
> #### Script
> Script for automation has been uploaded [here](https://git.toptal.com/screening/md-samsul-kabir/tree/master/uiautomation)
> 
> #### CI/CD of uiautomation using Jenkins
> Script can be executed locally using jenkins. Steps to follow for running tests using jenkins are as following:
> * Make sure jenkins up and running on local machine.
> * Go to http://localhost:8080
> * Click on "toptalUI" from right list.
> * Then click on "Build with parameters".
> * Select the browser where you want to execute your test.
> * Then click on "Build" button.
> * Once test execution is completed, then click on "Cucumber reports" from left hand side to see reports.
> 
> #### Executing from cloud
> An AWS EC2 machine with linux has been used to deploy and execute the script. In order to access jenkins running on EC2 instance, please follow this link
>```sh
> http://52.59.226.112:8080/
> 
> username: puma
> password: TestUser!@#$
>```
> 
> **Steps to run test:**
> * Please go to http://52.59.226.112:8080/ and login with credentials given above.
> * Then follow the steps explained in previous steps titled **CI/CD of uiautomation using Jenkins** excepts first steps. 
<br>

## 2. apiautomation (REST API Automation)
> apiautomation is divided into two section -
> * Automation framework - _Rest of the folder and files is used for automation_
> * No bug has been found.
>
> ### Automation framework
> Script for REST API automation has been uploaded [here](https://git.toptal.com/screening/md-samsul-kabir/tree/master/apiautomation)
<br>

## 3. loadtest
> loadtest has following items:
> * Load Test Report.pdf -_A summarized report of load testing can be found [here](https://git.toptal.com/screening/md-samsul-kabir/blob/master/loadtest/Load%20Test%20Report.pdf)
> * reports - Detailed report
> * jamahook.jmx - Script to perform load testing
