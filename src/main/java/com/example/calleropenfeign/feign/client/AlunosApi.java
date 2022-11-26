package com.example.calleropenfeign.feign.client;


import com.example.calleropenfeign.feign.client.request.AlunoRequest;
import com.example.calleropenfeign.feign.client.response.AlunoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "alunoApi", url = "http://localhost:8080/")
public interface AlunosApi {

    @GetMapping(value = "/alunos")
    List<AlunoResponse> getAlunos();

    @GetMapping(value = "/alunos/{id}")
    AlunoResponse getAlunosById(@PathVariable Long id);

    @GetMapping(value = "/alunos/filter")
    AlunoResponse getAlunosByFilter(@RequestParam Long id);

    @PostMapping(value = "/alunos")
    AlunoResponse addAluno(@RequestBody AlunoRequest aluno);

}
