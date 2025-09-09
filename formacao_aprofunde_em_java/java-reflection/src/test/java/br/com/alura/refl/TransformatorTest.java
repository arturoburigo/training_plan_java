package br.com.alura.refl;

import br.com.alura.Endereco;
import br.com.alura.Pessoa;
import br.com.alura.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class TransformatorTest {

    Pessoa pessoa = new Pessoa(1, "Steve Jobs", "1234");
    Endereco endereco = new Endereco("Rua 10", 20);
    @Test
    public void ShouldTransformPessoaToPessoaDTO() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformator transformator = new Transformator();
        PessoaDTO pessoaDTO = transformator.transform(pessoa);

        Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO);
        Assertions.assertEquals(pessoa.getNome(), pessoaDTO.getNome());
        Assertions.assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());
    }

    @Test
    public void ShouldNotTransformPessoaToPessoaDTO() {
        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            Transformator transformator = new Transformator();
            transformator.transform(endereco);
        });
    }

    @Test
    public void ShouldTransformWhenSomeFieldIsNull() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pessoa pessoaSemCPF = new Pessoa("Steve Jobs");
        Transformator transformator = new Transformator();
        PessoaDTO pessoaDTOsemCPF = transformator.transform(pessoaSemCPF);

        Assertions.assertEquals(pessoa.getNome(), pessoaDTOsemCPF.getNome());
        Assertions.assertNull(pessoaDTOsemCPF.getCpf());
    }
}