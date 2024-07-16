package resources;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import io.cucumber.java.gl.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Então;
import pages.LoginPage;

public class StepDefinitions {
    private LoginPage loginPage;
    private Random rand;

    @Dado("que o usuário está na tela de Login")
    public void que_o_usuário_está_na_tela_de_login() {
        this.loginPage = new LoginPage();
    }

    @Quando("o usuário preencher o campo de email")
    public void o_usuário_preencha_o_campo_de_email() {
        rand = new Random();
        int randomNum = rand.nextInt(10000) + 1;
        loginPage.preencherCampoXPath("//*[@id=\"username-input\"]", "teste" + randomNum + "@email.com");
    }

    @Quando("o usuário não preencher o campo de senha")
    public void não_preencha_o_campo_de_senha() {
        loginPage.preencherCampoXPath("//*[@id=\"password-input\"]/input", "");
    }

    @Quando("o usuário clicar no botão de entrar")
    public void o_usuário_clicar_no_botão_de_entrar() {
        loginPage.clicarBotaoEntrar("//*[@id=\"app\"]/main/section/div/section[1]/div/form/div[2]/button");
    }

    @Então("o usuário deverá ver uma mensagem de obrigatoriedade do campo senha")
    public void o_usuário_deverá_ver_uma_mensagem_de_obrigatoriedade_do_campo_senha() {
        assertTrue(loginPage.verficarTextoPorXpath("//*[@id=\"error-msg\"]", "Esse campo é obrigatório"));
    }
}