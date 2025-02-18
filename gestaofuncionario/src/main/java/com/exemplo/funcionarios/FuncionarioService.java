package com.exemplo.funcionarios;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class FuncionarioService {

    private Map<Long, Funcionario> funcionarioDB = new HashMap<>();
    private Long currentId = 1L;

    public Funcionario adicionarFuncionario(Funcionario funcionario) {
        funcionario.setId(currentId++);
        funcionarioDB.put(funcionario.getId(), funcionario);
        return funcionario;
    }

    public Optional<Funcionario> obterFuncionario(Long id) {
        return Optional.ofNullable(funcionarioDB.get(id));
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionario) {
        if (funcionarioDB.containsKey(id)) {
            funcionario.setId(id);
            funcionarioDB.put(id, funcionario);
            return funcionario;
        }
        return null;
    }

    public boolean excluirFuncionario(Long id) {
        if (funcionarioDB.containsKey(id)) {
            funcionarioDB.remove(id);
            return true;
        }
        return false;
    }

    public Map<Long, Funcionario> obterTodosFuncionarios() {
        return funcionarioDB;
    }
}
