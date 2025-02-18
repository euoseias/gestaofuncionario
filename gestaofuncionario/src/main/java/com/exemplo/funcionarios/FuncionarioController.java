package com.exemplo.funcionarios;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Operation(summary = "Adicionar um novo funcionário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Funcionário adicionado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario adicionarFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.adicionarFuncionario(funcionario);
    }

    @Operation(summary = "Obter os detalhes de um funcionário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário encontrado"),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado")
    })
    @GetMapping("/{id}")
    public Funcionario obterFuncionario(@PathVariable Long id) {
        return funcionarioService.obterFuncionario(id)
                .orElseThrow(() -> new FuncionarioException("Funcionário não encontrado"));
    }

    @Operation(summary = "Atualizar os dados de um funcionário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado")
    })
    @PutMapping("/{id}")
    public Funcionario atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        Funcionario updatedFuncionario = funcionarioService.atualizarFuncionario(id, funcionario);
        if (updatedFuncionario == null) {
            throw new FuncionarioException("Funcionário não encontrado");
        }
        return updatedFuncionario;
    }

    @Operation(summary = "Excluir um funcionário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado")
    })
    @DeleteMapping("/{id}")
    public void excluirFuncionario(@PathVariable Long id) {
        if (!funcionarioService.excluirFuncionario(id)) {
            throw new FuncionarioException("Funcionário não encontrado");
        }
    }

    @Operation(summary = "Obter todos os funcionários")
    @GetMapping
    public Map<Long, Funcionario> obterTodosFuncionarios() {
        return funcionarioService.obterTodosFuncionarios();
    }
}
