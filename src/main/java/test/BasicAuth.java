package test;

import browser.Browser;
import forms.Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAuth {

    @BeforeMethod
    public void start() {
        Browser.getBrowser();
        Browser.goToUrlAndLogin();
        Browser.maximize();
    }

    @Test
    public void baseAuthorization() {
        Assert.assertTrue(Page.isPageOpened());
    }

    @AfterMethod
    public void close() {
        Browser.close();
    }
}