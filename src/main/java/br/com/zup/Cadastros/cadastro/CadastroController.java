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
    public List<CadastroResumoDTO> exibirTodosCadastros(@RequestParam(required = false) Integer idade,
                                                        @RequestParam(required = false) Boolean moraSo,
                                                        @RequestParam(required = false) Boolean temPet){
        List<CadastroResumoDTO> cadastroResumoDTOS = new ArrayList<>();
        for (Cadastro cadastroReferencia : cadastroService.retornarTodosCadastros(idade, moraSo, temPet)){
            cadastroResumoDTOS.add(new CadastroResumoDTO(cadastroReferencia.getCpf(), cadastroReferencia.getNome(),
                    cadastroReferencia.getSobrenome()));
        }
        return cadastroResumoDTOS;
    }


    /*
     3 - faça um metodo para DELETAR um cadastro por id.
     4 - faça um metodo que retorna TODOS os dados de um usuario pesquisado pelo ID.
     */

}
