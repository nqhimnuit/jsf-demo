Project setup:
- download wildfly container at: https://www.wildfly.org
- install wildfly and start `standalone` instance
- clone this repository and checkout the branch you want to play with
- build and deploy steps:
```
$ cd jsf-demo

$ gw assemble

start container: $ <path_to>/wildfly-17.0.1.Final/bin/standalone.sh

deploy your application: $ cp build/libs/jsf-demo.war <path_to>/wildfly-17.0.1.Final/standalone/deployments/
```
checkout application at: http://localhost:8080/jsf-demo/demo.xhtml

Branch usage:
there are 3 branches for you to play with:
- `simple-jsf`: this branch is the minimal requirement of a jsf application, it shows you what is needed for a JSF app to run properly.
- `jsf-lifecycle-corner-cases`: this branch is built for you to play around with JSF lifecycle, including AJAX and a lifecycle listener which output in log file.
- `bootstrap`: this branch is built to show you how to integrate `bootstrap` into JSF.
