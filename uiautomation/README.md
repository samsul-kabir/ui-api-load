# Web App Automation 

## Overview
This folder contains scripts which perform automation testing on a web application. For automation, a locally hosted web application has been used for automation. The web application is attached as part of the repository and it can be accessed [here](https://git.toptal.com/screening/md-samsul-kabir/tree/master/uiautomation/TestApplication)

## Technology
For scripting, following technology and framework has been used:
* JAVA  (_Scripting language_)
* Cucumber  (_Test written in BDD Style_)
* Maven  (_Build automation tool for JAVA_)

## Framework Architecture
		
	  uiautomation
		|
		|_src/main/java
		|	|_base          Extends supports of page object design pattern
		|	|_manager       Extends supports of page-object model
		|	|_pages         Page Object Manger is to create the page’s object
    	|	|_util          Common method which will be used throughout the project
		|		
		|_src/test/java/
		|	|_runner        Entry point to the project
    	| 	|_setup         Setting up the project by initiating driver and all other component required
		|	|_steps         Contains all the step defination files   
    	|
		|_src/test/resource
		|	|_feature       Tests written in BDD style

## Instruction to execute test
The instruction will explain how to execute test on MAC OS X or linux platform.

### Pre-requirement
>
> * JDK 8 (preferred version )
> * Maven
> * Homebrew (for MAC OS X or linux)
> * Latest version of chrome and firefox browser
> 
> #### Required installation
> 
> * Install chromedriver for running the test on chrome browser
> ```sh
> brew install chromedriver
> ```
> * Install geckodriver for running the test on firefox browser
> ```sh
> brew install geckodriver
> ```

### Time to execute test
>
> #### To run the test
>
> * Clone the project
> * Go to project directory.
> * Then run one of the following command according to your required browser:
>```
>mvn clean test -Dbrowser=chrome    // to run test on chrome browser
>mvn clean test -Dbrowser=firefox   // to run test on firefox browser
>mvn clean test -Dbrowser=headless  // to run test on headless chrome
>```

### Where can I see report

Once you run the test successfully, go to project directory and open directory named "target". You will find report.html
