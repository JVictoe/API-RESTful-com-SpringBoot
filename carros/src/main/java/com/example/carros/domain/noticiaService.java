package com.example.carros.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class noticiaService {

    @Autowired
    private noticiaRepository rep;

    public Iterable<noticia> getNoticia() {
        return rep.findAll();
    }

    public Optional<noticia> getNoticiaById(Long id) {
        return rep.findById(id);
    }


    public List<noticia> getNoticiaFake() {
        List<noticia> noticias = new ArrayList<>();

        noticias.add(new noticia(1L, "Escola param em ribeirão", "Escolas param os funcionamentos após covid e alastrar", "https://g1.globo.com/sp/ribeirao-preto-franca/noticia/2020/10/20/regiao-de-ribeirao-preto-sp-tem-40-cursos-universitarios-com-notas-baixas-no-enade-2019.ghtml"));
        noticias.add(new noticia(2L, "Escola param em ribeirão", "Escolas param os funcionamentos após covid e alastrar", "https://g1.globo.com/sp/ribeirao-preto-franca/noticia/2020/10/20/regiao-de-ribeirao-preto-sp-tem-40-cursos-universitarios-com-notas-baixas-no-enade-2019.ghtml"));
        noticias.add(new noticia(3L, "Escola param em ribeirão", "Escolas param os funcionamentos após covid e alastrar", "https://g1.globo.com/sp/ribeirao-preto-franca/noticia/2020/10/20/regiao-de-ribeirao-preto-sp-tem-40-cursos-universitarios-com-notas-baixas-no-enade-2019.ghtml"));

        return noticias;
    }


    public noticia save(noticia noticias) {
        return rep.save(noticias);
    }

    public noticia update(noticia noticias, Long id) {
        Assert.notNull(id, "Não foi possivel atualizar o resgistro");

        //busca a noticia no banco de dados
        Optional<noticia> optional = getNoticiaById(id);
        if(optional.isPresent()) {
            noticia db = optional.get();
            //copia as propriedades da noticia a ser atualizada
            db.setTitulo(noticias.getTitulo());
            db.setResumo(noticias.getResumo());
            db.setNoticiaCompleta(noticias.getNoticiaCompleta());
            System.out.println("Noticia id " + db.getId());

            //Atualiza a noticia no banco de dados
            rep.save(db);

            return db;
        } else {
            throw new RuntimeException("Não foi possivél atualizar a noticia, tente novamente!");
        }
    }

    public void delete(Long id) {
        Optional<noticia> noticias = getNoticiaById(id);
        if (noticias.isPresent()) {
            rep.deleteById(id);
        }
    }
}
