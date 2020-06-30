package restservice;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}

/*
> No spring web restful, as solicitacoes HTTP são tratadas por um controlador (controller), como @RestController
> A classe GreetingController manipula as solicitacoes GET para a classe greeting, retornando uma nova instancia de Greeting
> A anotacao @GetMapping assegura que as solicitaçoes HTTP GET para "/greeting" sejam mapeadas para o metodo greeting()
> O @RequestParam cria um vinculo entre o parametro value="name" e o parametro String name do metodo greeting()
Se o parametro name estiver ausente na solicitacao, o Valor padrão "World" sera usado
> A implementacao do corpo do metodo cria e retorna um novo Greeting object com atributos de ID e content com base no
proximo valor do 'counter' e formata o 'name' fornecido usando o modelo (template) de greeting

@RestController: eh uma anotacao usada ao nivel de classe e combina @Controller e @ResponseBody
Esta anotacao marca a classe como um controller que seus metodos retornam objetos do tipo domain (e nao exibicoes de tela)
Em resumo, envia-se um objeto domain como resposta HTTP no formato que eh entendido pelos consumers, como JSON

@GetMapping: Essa anotacao eh usada para mapear solicitacoes HTTP GET para metodos de manipulador (handler) especificos
Eh uma anotacao composta que atua como um atalho para @RequestMapping (method = RequestMethod.GET)

@RequestParam: essa anotacao eh usada para anotar argumentos do metodo request handler.
Junto com a anotacao @RequestMapping, voce pode usar a anotacao @RequestParam para recuperar o parametro URL e mapea-lo
para o argumento do metodo. A anotacao @RequestParam eh usada para ligar parametros de solicitacao a um parametro de metodo
no seu controller
*/