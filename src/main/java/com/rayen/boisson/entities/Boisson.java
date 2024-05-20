package com.rayen.boisson.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


	@Entity
	public class Boisson {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idBoisson;
	    @NotNull
	    @Size (min = 4,max = 15)
	    private String nomBoisson;
	    @Min(value = 1)
	    @Max(value = 30)
	    private Double prixBoisson;
	    @ManyToOne
	    private Type type;

	    public Boisson() {
	        super();
	    }


		public Type getType() {
			return type;
		}


		public void setType(Type type) {
			this.type = type;
		}


		public Long getIdBoisson() {
			return idBoisson;
		}


		public void setIdBoisson(Long idBoisson) {
			this.idBoisson = idBoisson;
		}


		public String getNomBoisson() {
			return nomBoisson;
		}


		public void setNomBoisson(String nomBoisson) {
			this.nomBoisson = nomBoisson;
		}


		public Double getPrixBoisson() {
			return prixBoisson;
		}


		public void setPrixBoisson(Double prixBoisson) {
			this.prixBoisson = prixBoisson;
		}


		public Boisson(String nomBoisson, Double prixBoisson) {
			super();
		
			this.nomBoisson = nomBoisson;
			this.prixBoisson = prixBoisson;
		}


		@Override
		public String toString() {
			return "Boisson [idBoisson=" + idBoisson + ", nomBoisson=" + nomBoisson + ", prixBoisson=" + prixBoisson
					+ "]";
		}

	    
	}
