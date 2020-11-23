## Requirments
* Java 11 or higher
* Maven

## Build
To build run the command: `mvn clean package` 

## Usage
The program takes the following parameter
* `-a`, `--amount`: Amount of the loan, without minor units
* `-i`, `--interest`    the annual interest rate in percent, e.g. 2.5
* `-r`, `--redemption`   the initial redemption rate, e.g. 2.21
* `-s`, `--start`    the start date in format YYYY-MM-dd, e.g. 2020-12-24
* `-t`, `--term`    the term in months
* `--help` shows usage

Example for a command: 
`java -jar ./target/redemption-0.0.1-SNAPSHOT-jar-with-dependencies.jar -a 1000000 -s 2020-11-30 -t 24 -i 2 -r 2.5`

## Known issues
* The date shown is not the correct last day of the month.