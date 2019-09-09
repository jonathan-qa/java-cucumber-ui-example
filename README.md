# test-e2e-foundation

### IntelliJ plugin

- [IntelliJ plugin](https://plugins.jetbrains.com/plugin/8527-google-java-format)
- [Lombok](https://plugins.jetbrains.com/plugin/6317-lombok-plugin)
- [Gherkin](https://plugins.jetbrains.com/plugin/7211-gherkin)
- [Cucumber](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java)

### How to run 2e2 test

- mvn test
- mvn test -Dcucumber.options="src/test/resources/features/checkoutMasterPricer.feature"

# Remove existing downloads and binaries so we can start from scratch.
 - sudo apt-get remove google-chrome-stable
 - rm ~/selenium-server-standalone-*.jar
 - rm ~/chromedriver_linux64.zip
 - sudo rm /usr/local/bin/chromedriver
 - sudo rm /usr/local/bin/selenium-server-standalone.jar

# Install dependencies.
 - sudo apt-get update
 - sudo apt-get install -y unzip openjdk-8-jre-headless xvfb libxi6 libgconf-2-4

# Install Chrome.
 - sudo curl -sS -o - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add
 - sudo echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list
 - sudo apt-get -y update
 - sudo apt-get -y install google-chrome-stable

# Install ChromeDriver.
 - wget -N http://chromedriver.storage.googleapis.com/76.0.3809.126/chromedriver_linux64.zip -P ~/
 - unzip ~/chromedriver_linux64.zip -d ~/
 - rm ~/chromedriver_linux64.zip
 - sudo mv -f ~/chromedriver /usr/local/bin/chromedriver
 - sudo chown root:root /usr/local/bin/chromedriver
 - sudo chmod 0755 /usr/local/bin/chromedriver
