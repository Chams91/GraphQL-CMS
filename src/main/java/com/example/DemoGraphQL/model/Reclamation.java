package com.example.DemoGraphQL.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reclamation {

	@Id
    @Column( nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String matricule;

    @Column(nullable = false)
    private String nomClient;
    
    @Column(nullable = false)
    private String adresseExp;
    
    @Column(nullable = false)
    private String adresseDest;

	public Reclamation() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAddresseExp() {
		return adresseExp;
	}

	public void setAddresseExp(String addresseExp) {
		this.adresseExp = addresseExp;
	}

	public String getAdresseDest() {
		return adresseDest;
	}

	public void setAdresseDest(String adresseDest) {
		this.adresseDest = adresseDest;
	}

	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", matricule=" + matricule + ", nomClient=" + nomClient + ", addresseExp="
				+ adresseExp + ", adresseDest=" + adresseDest + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresseExp == null) ? 0 : adresseExp.hashCode());
		result = prime * result + ((adresseDest == null) ? 0 : adresseDest.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
		result = prime * result + ((nomClient == null) ? 0 : nomClient.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reclamation other = (Reclamation) obj;
		if (adresseExp == null) {
			if (other.adresseExp != null)
				return false;
		} else if (!adresseExp.equals(other.adresseExp))
			return false;
		if (adresseDest == null) {
			if (other.adresseDest != null)
				return false;
		} else if (!adresseDest.equals(other.adresseDest))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matricule == null) {
			if (other.matricule != null)
				return false;
		} else if (!matricule.equals(other.matricule))
			return false;
		if (nomClient == null) {
			if (other.nomClient != null)
				return false;
		} else if (!nomClient.equals(other.nomClient))
			return false;
		return true;
	}


	

	
    
    
}
