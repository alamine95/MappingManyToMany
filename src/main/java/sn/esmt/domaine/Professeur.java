package sn.esmt.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="professeurs")
public class Professeur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idprof;
	private String nom;
	private String prenom;
	@ManyToMany(mappedBy="professeurs",cascade=CascadeType.ALL)
	private List<ProjetRecherche> listeProjet;
	
	
	public Professeur() {
		listeProjet = new ArrayList<ProjetRecherche>();
	}
	
	public void assignerProjetProfesseur(ProjetRecherche projet)
	{
		listeProjet.add(projet);
	}

	public Integer getIdprof() {
		return idprof;
	}

	public void setIdprof(Integer idprof) {
		this.idprof = idprof;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<ProjetRecherche> getListeProjet() {
		return listeProjet;
	}

	public void setListeProjet(List<ProjetRecherche> listeProjet) {
		this.listeProjet = listeProjet;
	}
	
}
