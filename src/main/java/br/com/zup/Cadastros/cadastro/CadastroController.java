package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.cadastro.dtos.CadastroResumoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;

    @PostMapping
    public void cadastrarPessoa(@RequestBody Cadastro novoCadastro){
        cadastroService.cadastrarPessoa(novoCadastro);
    }

    @GetMapping
    public List<CadastroResumoDTO> exibirTodosCadastros(@RequestParam(required = false) Integer idade){
        List<CadastroResumoDTO> cadastroResumoDTOS = new ArrayList<>();
        for (Cadastro cadastroReferencia : cadastroService.retornarTodosCadastros(idade)){
            cadastroResumoDTOS.add(new CadastroResumoDTO(cadastroReferencia.getCpf(), cadastroReferencia.getNome(),
                    cadastroReferencia.getSobrenome()));
        }
        return cadastroResumoDTOS;
    }


    /*
     2 - Faça um metodo que retorna a lista inteira de cadastros ou filtrado por cadastros que:
            *moram sozinhos,
            *tem pet
            *por idade.ok
        ->nessa lista deve ser retornado apenas os campos ID, NOME e SOBRENOME.

     3 - faça um metodo para DELETAR um cadastro por id.
     4 - faça um metodo que retorna TODOS os dados de um usuario pesquisado pelo ID.
     */

}
