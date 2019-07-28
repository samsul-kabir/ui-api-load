# REST API Automation

## Overview
This folder contains scripts which perform automation testing of REST API. For api automation testing, an open source REST Api from [reqres](https://reqres.in/) has been used.

## Technology
For scripting, following technology and framework has been used:
* JAVA  (_Scripting language_)
* Serenity  (_Test written in BDD Style_)
* Maven  (_Build automation tool for JAVA_)

## Framework Architecture
		
	  Project
		|
		|_src/main/java
		|	|_facilities          // Initializations of request and response
		|	|_model               // JAVA objects from JsonNode
		|	|_serenity.steps      // Serenity steps
		|		
		|_src/test/java/
		|	|_runner              // Entry point to the project
		|	|_stepDefinations     // Contains all the step defination files   
            |	
		|_src/test/resource
		|	|_feature             // Tests written in BDD style
  
  

## Instruction to execute test

### Pre-requirement
* JDK 8 (preferred version )
* Maven

### Run the test
>* Clone the project
>* Then open terminal and go to project directory. 
>* Then run the following command
>```sh
>mvn failsafe:integration-test serenity:aggregate
>```

### Where can I see report
Once you run the test successfully, go to project directory and open directory following "target/site/serenity/". You will find some index.html as a report