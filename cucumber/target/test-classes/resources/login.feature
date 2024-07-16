# language: pt
Funcionalidade: Login

  Cenário: Login com campo senha em branco
    Dado que o usuário está na tela de Login
    Quando o usuário preencher o campo de email
    E o usuário não preencher o campo de senha
    Quando o usuário clicar no botão de entrar
    Então o usuário deverá ver uma mensagem de obrigatoriedade do campo senha
