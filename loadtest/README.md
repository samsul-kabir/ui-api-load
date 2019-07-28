# Load Testing on web application

## Overview
This folder contains the result of load testing of a web application named [jamahook](https://app.jamahook.com/). Basically load testing performed on the homepage. Everytime a user visits the homepage of jamahook, a list of web services has been called. In order to perform load test on hompage, we will hit server with heavy traffic using Jmeter and monitor the perform.

This folder contains following items:
* Script(jamahook.jmx) - A script used for load load testing
* Load Test Report - A summarized report
* Report - A detailed report which has been generated after performing the load testing of jamahook application. This detailed report has been used and analysed to write the summarized report. 

## Tools
Jmeter - An open source tools designed to perform load testing

## Pre-requirement
* JDK 8 (preferred version )
* Jmeter (preferred version apache-jmeter-5.1.1) - Download from [here](https://jmeter.apache.org/download_jmeter.cgi)

## How to execute
* Go to apache-jmeter-5.1.1/bin
* Download the jamahook.jmx attached to the folder.
* Copy jamahook.jmx file and paste into apache-jmeter-5.1.1/bin
* Then go to apache-jmeter-5.1.1/bin from terminal
* In order to perform load test in non-UI mode, run the following command:
```sh
sh jmeter -n -t jamahook.jmx -l jamahook.jtl -e -o reports
```

## Where can I find report
Once execution is done, then open reports/index.html for detailed report.