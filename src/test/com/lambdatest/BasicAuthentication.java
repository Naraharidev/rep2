package com.lambdatest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicAuthentication {
  /*   public static String hubURL = "https://hub.lambdatest.com/wd/hub";
    private WebDriver driver;

    public void setup() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "95");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("user", System.getenv("LT_USERNAME"));
        ltOptions.put("accessKey", System.getenv("LT_ACCESS_KEY"));
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", this.getClass().getName());
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.0.0");
        capabilities.setCapability("LT:Options", ltOptions);

        driver = new RemoteWebDriver(new URL(hubURL), capabilities);
        System.out.println(driver);
    }

    public void authentication() {
        Augmenter augmenter = new Augmenter();
        driver = augmenter.augment(driver);

        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();

        driver = augmenter.addDriverAugmentation("chrome", HasAuthentication.class,
                (caps, exec) -> (whenThisMatches, useTheseCredentials) -> devTools.getDomains().network()
                        .addAuthHandler(whenThisMatches, useTheseCredentials))
                .augment(driver);

        ((HasAuthentication) driver).register(UsernameAndPassword.of("foo", "bar"));

        driver.get("http://httpbin.org/basic-auth/foo/bar");

        String text = driver.findElement(By.tagName("body")).getText();
        System.out.println(text);
        if (text.contains("authenticated")) {
            markStatus("passed", "Authentication Successful", driver);
        } else {
            markStatus("failed", "Authentication Failure", driver);
        }

    }

    public void tearDown() {
        try {
            driver.quit();
        } catch (

        Exception e) {
            markStatus("failed", "Got exception!", driver);
            e.printStackTrace();
            driver.quit();
        }
    }

    public static void markStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jsExecute = (JavascriptExecutor) driver;
        jsExecute.executeScript("lambda-status=" + status);
        System.out.println(reason);
    }*/

    String username = "naraharidevarapu";
	String accesskey = "NUT4CPjAcd0dDmNpPlqceCBlJJIJzCaCHapsJ2AaFEsLghb949";
	public static RemoteWebDriver driver = null;
	public String gridURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;

	public void setUp(String browser, String version, String platform) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("version", version);
		capabilities.setCapability("platform", platform); // If this cap isn't specified, it will just get the any
															// available one
		capabilities.setCapability("build", "Test Scenario 1");
		capabilities.setCapability("name", "Simple Form Demo");
		capabilities.setCapability("network", true); // To enable network logs
		capabilities.setCapability("visual", true); // To enable step by step screenshot
		capabilities.setCapability("video", true); // To enable video recording
		capabilities.setCapability("console", true); // To capture console logs
		
		

		try {
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
			driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_nxqtetlae_e&adgrpid=60571832564&hvpone=&hvptwo=&hvadid=486387378181&hvpos=&hvnetw=g&hvrand=16986360475431660608&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=20453&hvtargid=kwd-296458789801&hydadcr=14452_2154371&gclid=Cj0KCQjwteOaBhDuARIsADBqRegDUeoiqc5kXoh1RV2nqWGtF8phs9N3FmXYim54C5-XJCwMyJMdcRkaAuhzEALw_wcB");
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}




    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        BasicAuthentication test = new BasicAuthentication();
       System.out.println("Welcome to github");
       try{
       test.setUp("browser", "version", "platform");
       }
       catch(Exception e){
        System.out.print(e.getMessage);
       }
    }
}
