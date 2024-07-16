package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends BasePage {

    public LoginPage() {
        this.driver = new ChromeDriver();
        this.driver.get("https://homero.app.br/login");
        this.driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(2))
                .pageLoadTimeout(Duration.ofSeconds(10));
    }

    public void preencherCampoXPath(String xpath, String texto) {
        driver.findElement(By.xpath(xpath)).sendKeys(texto);
    }

    public void clicarBotaoEntrar(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public boolean verficarTextoPorXpath(String xpath, String string) {
        return driver.findElement(By.xpath(xpath)).getText().equals(string);
    }
}