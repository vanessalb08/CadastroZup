package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.cadastro.dtos.CadastroResumoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
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

    @GetMapping ("/{cpf}")
    public Cadastro buscarCadastroId(@PathVariable String cpf){
        return cadastroService.pesquisarId(cpf);
    }

    @DeleteMapping ("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCadastro (@PathVariable String cpf){
        cadastroService.removerCadastro(cpf);
    }

    /*
     3 - faça um metodo para DELETAR um cadastro por id.
     */

}
