$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/ninjaInvoice.feature");
formatter.feature({
  "line": 1,
  "name": "Ninja Invoice Testes",
  "description": "",
  "id": "ninja-invoice-testes",
  "keyword": "Feature"
});
formatter.before({
  "duration": 984888594,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Login with success",
  "description": "",
  "id": "ninja-invoice-testes;login-with-success",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I have an user with email \"souza.jonathan@outlook.com\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "an password \"Jso1605jso\"",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "i click in the login button",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the home private page is opened",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "souza.jonathan@outlook.com",
      "offset": 27
    }
  ],
  "location": "NinjaInvoiceSteps.iHaveAnUserWithEmail(String)"
});
formatter.result({
  "duration": 2421803423,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jso1605jso",
      "offset": 13
    }
  ],
  "location": "NinjaInvoiceSteps.anPassword(String)"
});
formatter.result({
  "duration": 88476873,
  "status": "passed"
});
formatter.match({
  "location": "NinjaInvoiceSteps.iClickInTheLoginButton()"
});
formatter.result({
  "duration": 95966131,
  "status": "passed"
});
formatter.match({
  "location": "NinjaInvoiceSteps.theHomePrivatePageIsOpened()"
});
formatter.result({
  "duration": 82599,
  "status": "passed"
});
formatter.after({
  "duration": 151824,
  "status": "passed"
});
});