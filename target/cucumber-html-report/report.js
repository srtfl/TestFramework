$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("basic/journey_planner.feature");
formatter.feature({
  "line": 1,
  "name": "Check basic functionality of journey planner is working",
  "description": "",
  "id": "check-basic-functionality-of-journey-planner-is-working",
  "keyword": "Feature"
});
formatter.before({
  "duration": 6514123318,
  "status": "passed"
});
formatter.before({
  "duration": 6316611510,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 3,
      "value": "#Search for a journey"
    }
  ],
  "line": 4,
  "name": "If I enter valid From and To stations than I should be taken to results page",
  "description": "",
  "id": "check-basic-functionality-of-journey-planner-is-working;if-i-enter-valid-from-and-to-stations-than-i-should-be-taken-to-results-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I am on Plan A Journey page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter From \"St. James\u0027s Park Underground Station\" and To \"Waterloo Underground Station\" and click on Plan A Journey button",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I should see the journey planner results page",
  "keyword": "Then "
});
formatter.match({
  "location": "JourneyPlannerSteps.iAmOnJourneyPage()"
});
formatter.result({
  "duration": 1639598573,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"class name\",\"selector\":\".plan-journey-button\"}\nCommand duration or timeout: 1.39 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1cd5757287168e54b817830adce9b0158d\u0027, time: \u00272016-06-30 19:26:09\u0027\nSystem info: host: \u0027hp-PC\u0027, ip: \u0027192.168.56.1\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_101\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, pageLoadStrategy\u003dfast, handlesAlerts\u003dtrue, databaseEnabled\u003dtrue, version\u003d47.0.1, platform\u003dWINDOWS, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webStorageEnabled\u003dtrue, locationContextEnabled\u003dtrue, browserName\u003dfirefox, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, pageLoadingStrategy\u003dfast, cssSelectorsEnabled\u003dtrue}]\nSession ID: 6a08f27c-0c0d-4679-9c88-79d00afec92b\n*** Element info: {Using\u003dclass name, value\u003d.plan-journey-button}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByClassName(RemoteWebDriver.java:477)\r\n\tat org.openqa.selenium.By$ByClassName.findElement(By.java:391)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat com.tfl.test.pages.jp.PlanAJourneyPage.clickOnPlan(PlanAJourneyPage.java:88)\r\n\tat com.tfl.test.steps.jp.JourneyPlannerSteps.iAmOnJourneyPage(JourneyPlannerSteps.java:38)\r\n\tat ✽.Given I am on Plan A Journey page(basic/journey_planner.feature:5)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"class name\",\"selector\":\".plan-journey-button\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.1\u0027, revision: \u0027a36b8b1cd5757287168e54b817830adce9b0158d\u0027, time: \u00272016-06-30 19:26:09\u0027\nSystem info: host: \u0027hp-PC\u0027, ip: \u0027192.168.56.1\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_101\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementInternal_(file:///C:/Users/hp/AppData/Local/Temp/anonymous1901023987122640219webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10770)\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElement(file:///C:/Users/hp/AppData/Local/Temp/anonymous1901023987122640219webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10779)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_/h(file:///C:/Users/hp/AppData/Local/Temp/anonymous1901023987122640219webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12661)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_(file:///C:/Users/hp/AppData/Local/Temp/anonymous1901023987122640219webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12666)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.execute/\u003c(file:///C:/Users/hp/AppData/Local/Temp/anonymous1901023987122640219webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12608)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "\"St. James\u0027s Park Underground Station\"",
      "offset": 13
    },
    {
      "val": "\"Waterloo Underground Station\"",
      "offset": 59
    }
  ],
  "location": "JourneyPlannerSteps.enterStationDetails(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "JourneyPlannerSteps.iSeeResultPage()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 1495479949,
  "status": "passed"
});
});