package com.rayen.boisson;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.rayen.boisson.entities.Boisson;
import com.rayen.boisson.entities.Type;
import com.rayen.boisson.repos.BoissonRepository;
import com.rayen.boisson.service.BoissonService;



@SpringBootTest
class BoissonSp3ApplicationTests {

	 @Autowired
	    private BoissonRepository boissonRepository;
	 private BoissonService boissonService ;
	 @Test
	 public void testCreateBoisson() {
		 Boisson prod = new Boisson("jus kiwi",6.0);
		 boissonRepository.save(prod);
	 }
	 
	 @Test
	 public void testFindByNomBoissonContains()
	 {
	 Page<Boisson>b =boissonService.getAllBoissonsParPage(0,2);
	 System.out.println(b.getSize());
	 System.out.println(b.getTotalElements());
	 System.out.println(b.getTotalPages());
	 b.getContent().forEach(p -> {System.out.println(p.toString());
	  });
	 
	 }
	    @Test
	    public void testFindBoisson() {
	        Boisson b = boissonRepository.findById(1L).get();
	        System.out.println(b);
	    }
	    @Test
	    public void testUpdateBoisson() {
	        Boisson b = boissonRepository.findById(1L).get();
	        b.setPrixBoisson(1.5);
	        boissonRepository.save(b);
	    }
	    @Test
	    public void testDeleteBoisson() {
	        boissonRepository.deleteById(1L);
	        ;
	    }

	    @Test
	    public void testListerTousBoisson() {
	        List<Boisson> bois = boissonRepository.findAll();
	        for (Boisson b : bois) {
	            System.out.println(b);
	        }
	        
	    }
	    @Test
	    public void testFindByNomProduitContains()
	    {
	    Page<Boisson> b = boissonService.getAllBoissonsParPage(0,2);
	    System.out.println(b.getSize());
	    System.out.println(b.getTotalElements());
	    System.out.println(b.getTotalPages());
	   b.getContent().forEach(bo -> {System.out.println(bo.toString());
	     });
	    
	    }
	    @Test
	    public void testfindByType()
	    {
	    Type cat = new Type();
	    cat.setIdType(1L);
	    List<Boisson> prods = boissonRepository.findByType(cat);
	    for (Boisson p : prods)
	    {
	    System.out.println(p);
	    }
	    }
	    
	    @Test
	    public void testFindByNomBoisson()
	    {
	    List<Boisson> prods = boissonRepository.findByNomBoisson("jus fraise");
	    for (Boisson p : prods)
	    {
	    System.out.println(p);
	    }
	    }
	    @Test
	    public void findByTypeIdType()
	    {
	    List<Boisson> prods = boissonRepository.findByTypeIdType(2L);
	    for (Boisson p : prods)
	    {
	    System.out.println(p);
	    }
	     }
}
