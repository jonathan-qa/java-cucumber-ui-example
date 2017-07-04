package com.e2e.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.e2e.SetupWebDriver;

@Component
@Scope("singleton")
@Slf4j
public class TakeScreenshot {

  @Autowired
  private SetupWebDriver setupWebDriver;

  private static Integer scenarioIndex = 0;

  private static Integer stepIndex = 0;

  @Value("${screenshots.path}")
  private String evidencesPath;

  private static String suiteFolderName;

  public void initializeTestSuite() {
    if (suiteFolderName == null) {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
      Date currentDate = new Date();
      suiteFolderName = "test_suites" + format.format(currentDate);
    }
  }

  public void initializeTest() {
    scenarioIndex = scenarioIndex + 1;
    stepIndex = 0;
  }

  public void execute() {
    stepIndex = stepIndex + 1;
    File screenshot = ((TakesScreenshot) setupWebDriver.getWebDriver()).getScreenshotAs(OutputType.FILE);
    Path path = Paths.get(evidencesPath + "/" + suiteFolderName + "/" + "scenario_" + scenarioIndex + "_step_"
        + stepIndex + ".png");
    try {
      FileUtils.copyFile(screenshot, new File(path.toString()), true);
    } catch (IOException e) {
      log.info("Problem saving screenshot");
    }
  }
}
