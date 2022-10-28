package implementation;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    private TakesScreenshot camera;

    public Screenshot(WebDriver driver) {
        camera = (TakesScreenshot) driver;
    }

    public void saveScreenshot(String screenshotFileName) throws IOException {
        File file = camera.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(screenshotFileName);
        FileUtils.copyFile(file,destinationFile);
    }
}
