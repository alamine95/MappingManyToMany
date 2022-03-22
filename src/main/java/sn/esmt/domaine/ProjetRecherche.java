package sn.esmt.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name="projets")
public class ProjetRecherche implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idprojet;
	private String theme;
	@JoinTable(name="projets_prof",joinColumns = @JoinColumn(name="idprojet"),inverseJoinColumns= @JoinColumn(name="idprof"))
	private List<Professeur> professeurs;
	
	public ProjetRecherche() {
		professeurs = new ArrayList<Professeur>();
	}
	
	public void assignerProfesseurProjet(Professeur professeur)
	{
		professeurs.add(professeur);
	}

	public Integer getIdprojet() {
		return idprojet;
	}

	public void setIdprojet(Integer idprojet) {
		this.idprojet = idprojet;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public List<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(List<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
