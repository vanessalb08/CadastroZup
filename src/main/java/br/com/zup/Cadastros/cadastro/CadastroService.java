package br.com.zup.Cadastros.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository cadastroRepository;

    public void cadastrarPessoa(Cadastro cadastro){

        Cadastro novoCadastro = new Cadastro();
        novoCadastro.setCpf(cadastro.getCpf());
        novoCadastro.setNome(cadastro.getNome());
        novoCadastro.setSobrenome(cadastro.getSobrenome());
        novoCadastro.setCidade(cadastro.getCidade());
        novoCadastro.setBairro(cadastro.getBairro());
        novoCadastro.setNomeDoParenteProximo(cadastro.getNomeDoParenteProximo());
        novoCadastro.setMoraSozinho(cadastro.isMoraSozinho());
        novoCadastro.setTemPet(cadastro.isTemPet());
        novoCadastro.setIdade(cadastro.getIdade());
        novoCadastro.setDataDoCadastro(retornarDataAtual());

        cadastroRepository.save(novoCadastro);

    }

    public LocalDate retornarDataAtual(){
        LocalDate data = LocalDate.now();
        return data;
    }
}
