package restservice;

public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
/*
Explicação da classe ---> interacoes de serviço
> O servico manipulara solicitacoes GET para Greeting (com opcional de um parametro 'name')
> A solicitacao GET deve retornar uma resposta 200 OK com JSON no corpo que representa uma saudação/Greeting
> Deve-se parecer com a seguinte saida:
{
    "id": 1,
    "content": "Hello, World!"
}
> O campo id eh um identificador exclusivo para o greeting e o content eh a representacao textual do greeting
> Este aplicativo usa a biblioteca Jackson JSON para organizar automaticamente instâncias do tipo Greeting em JSON.
> Jackson eh incluido por padrao pelo web starter.
*/