package br.com.zup.Cadastros.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;

    @PutMapping
    public void cadastrarPessoa(@RequestBody Cadastro novoCadastro){
        cadastroService.cadastrarPessoa(novoCadastro);
    }

    /*
    1 - crie um metodo para cadastrar uma pessoa.
      Para um cadastro todos os campos são obrigatórios EXCETO o campo dataDoCadastro que deve ser preenchido
      pelo proprio sistema e o client não deve saber da existencia desse campo
     2 - Faça um metodo que retorna a lista inteira de cadastros ou filtrado por cadastros que moram
     sozinhos, que tem pet ou por idade.
     nessa lista deve ser retornado apenas os campos ID, NOME e SOBRENOME.
     3 - faça um metodo para DELETAR um cadastro por id.
     4 - faça um metodo que retorna TODOS os dados de um usuario pesquisado pelo ID.
     */

}
