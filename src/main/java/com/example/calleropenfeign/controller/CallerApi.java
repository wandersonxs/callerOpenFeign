package com.example.calleropenfeign.controller;


import com.example.calleropenfeign.feign.client.AlunosApi;
import com.example.calleropenfeign.feign.client.request.AlunoRequest;
import com.example.calleropenfeign.feign.client.response.AlunoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CallerApi {

    @Autowired
    private AlunosApi alunosApi;


    @GetMapping(value = "/chamadorAlunos")
    public List<AlunoResponse> getAlunosCaller() {
        List<AlunoResponse>  alunos = alunosApi.getAlunos();
         alunos.forEach( n -> n.setNome(n.getNome() + " CHAMADOR "));
         return alunos;
    }

    @GetMapping(value = "/chamadorAlunosById/{id}")
    public AlunoResponse getAlunosByIdCaller(@PathVariable Long id) {
        AlunoResponse aluno = alunosApi.getAlunosById(id);
        return aluno;
    }

    @GetMapping(value = "/chamadorAlunosByFilter")
    public AlunoResponse getAlunosByFilterCaller(@RequestParam Long id) {
        AlunoResponse aluno = alunosApi.getAlunosByFilter(id);
        return aluno;
    }

    @PostMapping(value = "/chamadorAlunos")
    public AlunoResponse addAluno(@RequestBody AlunoRequest alunoRequest) {
        AlunoResponse aluno = alunosApi.addAluno(alunoRequest);
        return aluno;
    }

}
