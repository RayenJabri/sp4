package com.rayen.boisson.service;
import java.util.List;

import org.springframework.data.domain.Page;

import com.rayen.boisson.entities.Boisson;

import com.rayen.boisson.entities.Type;

public interface BoissonService {

        Boisson saveBoisson(Boisson b);
    Boisson updateBoisson(Boisson b);
    void deleteBoisson(Boisson b);
    void deleteBoissonById(Long id);
    Boisson getBoisson(Long id);
    List<Boisson> getAllBoisson();
    Page<Boisson> getAllBoissonsParPage(int page, int size);
    List<Boisson> findByNomBoisson(String nom);
    List<Boisson> findByNomBoissonContains(String nom);
    List<Boisson> findByNomPrix (String nom, Double prix);
    List<Boisson> findByType (Type type);
    List<Boisson> findByTypeIdType(Long id);
    List<Boisson> findByOrderByNomBoissonAsc();
    List<Boisson> trierBoissonsNomsPrix();
    List<Type> getAllTypes();

}
