package br.com.zup.Cadastros.cadastro;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

//moram sozinhos, que tem pet ou por idade
public interface CadastroRepository extends CrudRepository<Cadastro, String> {
    List<Cadastro> findAllByMoraSozinho(boolean opcaoMora);
    List<Cadastro> findAllByTemPet(boolean opcaoPet);
    List<Cadastro> findAllByIdade(int idade);
}
