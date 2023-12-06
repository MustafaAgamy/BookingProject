import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.CustomMethods;

import java.net.CookieStore;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class TestCookies {
    private WebDriver driver;
    private final By loginBtn = By.xpath("//button[@class='ms-3.5 flex items-center rounded-lg border px-3 py-2']");
    private final By emailField = By.xpath("//input[@id='email']");
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By signInBtn = By.xpath("//button[@type='submit']");
    private final By discoverPageBtn = By.xpath("//a[@href='/discover']");
    private final By expandFilterButtons = By.xpath("//button[contains(@class,'rounded-md p-4')]");


    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();

        Cookie cookie = new Cookie("__Secure-next-auth.session-token","eyJhbGciOiJkaXIiLCJlbmMiOiJBMjU2R0NNIn0..cQOG3Jp7jbAjMtw5.q8KmFd_g2j3GZwwZMvQFfXz7btp84IRnJRHSazddhzs32_dBl3OArhc1LHaefiSsxzEN7KPCE8LrP00zSaPnjSuznX22CMKgFoIBMIYowjya--v0ms9kwaZi_PEdCUqjQ64mMCXyUk4Opr7xSJ7fRiB-pzNWOGgFKL4Xw53yMv5tRpIOmz-Kcs0iRzO1Es9xGFzA_tyS10mx27rITXHW-wenr0NA1JxKhvjelh5_t_bxfYEaaETNEeCfahJRWzlbsq0dr8V4dbJpLtni4OqrkaXbuiCu_S6D82h3E5AK-nU-Ls-v2_I5x1SmyluR3h3F4xJ0oJ1VjyJD39ermnSJ5uQ-n9iK99JnjinmO8M0rL9BsJuj67_1AKdOQDwp7jotNRb-TIUXR42NiFk9lNm3cMPS2_c6TlEdBv3WnrjAW6A3UsudoYIsU8UjRmlm-iAOTdaMAUR4HCoegluWxO5ClNX9pzo0C-YXlZTpGGfvBZqAAWL7vHXvagSoDhr2AIA1WFDhMBXAR4NunHnoGLH51QkX-CEOrkEdRolYFaQ7W2yWunOiDUjAU13p0DS9a62PhLW_MpOBHVjyjWiY9dRNtne_TKf5QXc9dPhPLjEzwsxn44f9D-yJeJvsj8STz-2RkLwq9sgKLeK7pA-ofrtjqOUm3eqZ5MGkJhQV25qkFIRP8nkfm97vjsPA8fbsJIwxUyETas1JLEws7xHiAzd5XVinDoAmnehg-cYGsxFBkEc1mL-RiQPTNQo45BLoKSUvbrE7JRZ57iElXInI-Y0WNbEaMWjb2faGGYvf8vkvSTHDnuL-C9CBfp5u8HbhWxcQUlPRTNFWOd85bqDqI0VNXDTZSxXEsKtR8jjNFxebesNwj4gtTZ-3rQ9u-7raX2HeUBC7ULU6H09-SjEYpPlF1wKB99WXzLSmWa-OoCkUnL4WO0snc17gYlnOUezJy-KoetSdRffd7PDD5fsYLu-FNpLFJB990asDZzJmo2UZ7bRlJqrUTsCHPPs05-6WrbQBDndSNuiCR4iP_Xps9qt44_45awytq5FCR_pRFzPoCb9V6Tz4OUSFFAz2Ig353PyYka4Zo4BiRiHpYEzVyMC1OZlGJwxKn0nRkZm3nS2wsa8t-VM3WKxv90TCVJqyvzMpB8aAH2WTxFXyfA5qdV1MB8mCsk-rdC3hvIEEP9LS4dBPQ5jWJBMhaJz7YNJjLUpq9Nw3gEABvJECW6Nv09xp8Fqziq4-q_93DZtss3A-gfFzVT184SX7x3e2UwpK6Soste6VQ83YyZ967INGfmbPF4VcYWnwp7wALddFTW9HuXuuKcKX33LH_EQ5c_pUBibqDY5OY9ALWIbusruQld152RYGsGpAdrk3yQvxOJbuIXvLKiROEp3uNTedkU4Kj-RAl3Sj9QqM9RRfU_e5xILegY0ewdnBl-Q3sWLn9lXp9Q2LPw1H5IyJ5tFHK7tG6ngs0mzQT8EqHdoX_oIbWsrphiZG5K5c6gW6iVBLvOS4TGI4uK87qPQeQLzjepdi3-KQ9u_H-nUOM5pYINhokQgOPLQCr_oBKGMvs0Jkf3l0uTrI6fdo7gf2U8Vkz3ZU61s8J9VRgoBrMQ5Cv5EKArzodCJuH5yY1gVbQTwvVG9yxFGM73ZR4llSPoX0IZ7ZF2pPSCx5Y8wU2g-FuImMMVzMen6Wo028e1CV65fBmlLV2rw26aH1UI88H98jx4f-XEzNypFCeAwIxKtueAAPwK-dPe8_5OOynbgEQTty8dke7YOqzud-yPafZPjDtIOs3LENtq5IMwIJhWRYr9LwxFT4KkIHrPquEpIcMal9PQbi-FFK08BzOQOSROemvRPuwB9W9DrlhIMlOt3viutlCc54A7wRY-lk9yzmPZCvCXyP_yQSnAxbT8xK45Tg_3V1RMPIo2E9RQjkAaH1vg2wk03EH-tBhQb9tBDKL9gjDMBatYP7QIZJIv0Ap8Vn2NUjMiitZr_MD3lOBgDIyzABWGf_ijqYepj7LbcOtegNQ5BULiV1V3IxvsudeUug-LToxY8MVTr4jS4QyFwux_PprAeIECYLTDk3xehrkXKl4IEuFOTEZlbNLFPpOQ85vWo5mgyYrpghAgCaVSoGdf8IgpU-Y2ddCicYAtxypDDwQNu4P4gprerLfFA-5aZRaWdAcNOJVyINbUkrgDWRnam1VXgv-m4yaqIHz9mSA5WCdA.CyTC84hsJN3Pv_tjIO7U4A; expires=Sun, 31 Dec 2023 10:36:53 EET; path=/; domain=estatebook.com;secure;; sameSite=Lax\n" +
                "_ga=GA1.1.380247797.1701463012");
//        Cookie loginToken = driver.manage().getCookieNamed("__Host-next-auth.csrf-token");

//            Cookie loginCookie = new Cookie.Builder("__Secure-next-auth.session-token", tokenValue)
//                    .domain("estatebook.com")  // Replace with the actual domain
//                    .path("/")
//                    .isSecure(true)
//                    .isHttpOnly(true)
//                    .build();
        driver.manage().window().maximize();
        driver.navigate().to("https://estatebook.com/en");
        driver.manage().addCookie(cookie);
//        System.out.println(loginToken);
//        Cookie tokenCookie = driver.manage().getCookieNamed("_Secure-next-auth.session-token");
//        Cookie tokenCookie = driver.manage().getCookieNamed("_token");

//        System.out.println(tokenCookie);
    }

    @Test
    public void loginToSite(){
//        CustomMethods.findElementPresence(driver, loginBtn).click();
//        CustomMethods.findElementPresence(driver, emailField).sendKeys("nasomaadel05@gmail.com");
//        CustomMethods.findElementPresence(driver, passwordField).sendKeys("12345678");
//        CustomMethods.findElementPresence(driver, signInBtn).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        CustomMethods.findElementPresence(driver, discoverPageBtn).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        CustomMethods.findDuplicationIndex(driver, expandFilterButtons, 0).click();
        List<Cookie> cookieList = driver.manage().getCookies().stream().toList();
        cookieList.forEach(
                System.out::println
        );
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null) {
            driver.quit();
        }
    }
}
