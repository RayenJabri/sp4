package com.rayen.boisson.service;


import com.rayen.boisson.entities.Boisson;
import com.rayen.boisson.entities.Type;
import com.rayen.boisson.repos.BoissonRepository;
import com.rayen.boisson.repos.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoissonServiceImpl implements BoissonService{

	@Autowired
	TypeRepository typeRepository;

    @Autowired
    BoissonRepository boissonRepository;
    @Override
    public Boisson saveBoisson(Boisson b) {
        return boissonRepository.save(b);
    }

    @Override
    public Boisson updateBoisson(Boisson b) {
        return boissonRepository.save(b);
    }

    @Override
    public void deleteBoisson(Boisson b) {
        boissonRepository.delete(b);
    }

    @Override
    public void deleteBoissonById(Long id) {
        boissonRepository.deleteById(id);

    }

    @Override
    public Boisson getBoisson(Long id) {
        return boissonRepository.findById(id).get();
    }

    @Override
    public List<Boisson> getAllBoisson() {
        return boissonRepository.findAll();
    }

	@Override
	public Page<Boisson> getAllBoissonsParPage(int page, int size) {
		return boissonRepository.findAll(PageRequest.of(page,size));
	}

	@Override
	public List<Boisson> findByNomBoisson(String nom) {
		return boissonRepository.findByNomBoisson(nom);
	}

	@Override
	public List<Boisson> findByNomBoissonContains(String nom) {
		return boissonRepository.findByNomBoissonContains(nom);
	}

	@Override
	public List<Boisson> findByNomPrix(String nom, Double prix) {
		return boissonRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Boisson> findByType(Type type) {
		return boissonRepository.findByType(type);
	}

	@Override
	public List<Boisson> findByTypeIdType(Long id) {
		 return boissonRepository.findByTypeIdType(id);
	}

	@Override
	public List<Boisson> findByOrderByNomBoissonAsc() {
		 return boissonRepository.findByOrderByNomBoissonAsc();
	}

	@Override
	public List<Boisson> trierBoissonsNomsPrix() {
		 return boissonRepository.trierBoissonsNomsPrix();
	}

	@Override
	public List<Type> getAllTypes() {
	
		return typeRepository.findAll();
	}

   
}
