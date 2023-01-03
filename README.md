# jupiter-toys-serenity-cucumber
Sample Test automation using [Serenity Screenplay + Cucumber](https://serenity-bdd.github.io/docs/screenplay/screenplay_fundamentals).

Data-driven using Excel or CSV file.

[Github actions](https://github.com/kentdomaoal/jupiter-toys-serenity-cucumber/actions) were setup for its CI/CD Pipeline.

---
## How to run in local machine

## 💻 *Pre-requisites*
- [Git](https://git-scm.com/downloads)
- [Java 8](https://www.oracle.com/ph/java/technologies/downloads) or higher
- [Maven](https://maven.apache.org/download.cgi)

### 1. Clone the project
```
git clone https://github.com/kentdomaoal/jupiter-toys-serenity-cucumber.git
```
``` 
cd jupiter-toys-serenity-cucumber
```

### 2. Run the test
``` 
mvn clean verify
``` 

### 3. View html report
After test execution, SERENITY REPORTS can be found on the following:
  - Full Report:

        /target/site/serenity/index.html

  - Single Page HTML Summary: 

        /target/site/serenity/serenity-summary.html


  - Full Report As React Based Single Page Application: 

        /target/site/serenity/navigator/index.html



