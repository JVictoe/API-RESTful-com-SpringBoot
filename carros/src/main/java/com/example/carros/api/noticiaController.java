package com.example.carros.api;

import com.example.carros.domain.noticia;
import com.example.carros.domain.noticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping ("/api/noticias")
public class noticiaController {

    @Autowired
    private noticiaService service;

    @GetMapping()
    public Iterable<noticia> get () {
        return service.getNoticia();
    }

    @GetMapping("/{id}")
    public Optional<noticia> get(@PathVariable("id") Long id) {
        return service.getNoticiaById(id);
    }

    @PostMapping
    public String post(@RequestBody noticia noticias) {
        noticia n = service.save(noticias);

        return "Noticia salva com sucesso: " + n.getId();
    }

    @PutMapping("/{id}")
    public String put(@PathVariable("id") Long id, @RequestBody noticia noticias) {
        noticia n = service.update(noticias, id);

        return "Noticia atualizada com sucesso: " + n.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);

        return "Noticia deletada com sucesso: ";
    }



}
