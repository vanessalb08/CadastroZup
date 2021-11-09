package br.com.zup.Cadastros.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public List<Cadastro> retornarTodosCadastros(Integer idade, Boolean moraSo, Boolean temPet){
        if (idade != null){
            return cadastroRepository.findAllByIdade(idade);
        }
        if (moraSo != null){
            return cadastroRepository.findAllByMoraSozinho(moraSo);
        }
        if(temPet != null){
            return cadastroRepository.findAllByTemPet(temPet);
        }
        Iterable<Cadastro> cadastros = cadastroRepository.findAll();
        return (List<Cadastro>) cadastros;
    }

    public Cadastro pesquisarId(String cpf){
        for (Cadastro cadastro : cadastroRepository.findAll()){
            if (cadastro.getCpf().equals(cpf)){
                return cadastro;
            }
        }
        throw new RuntimeException("Cpf não cadastrado!");
    }

}
