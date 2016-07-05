/*
 * Copyright 2016 svilupposw.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.engim.teamplatedb.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author svilupposw
 */
@Entity
@Table(name = "articolo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articolo.findAll", query = "SELECT a FROM Articolo a"),
    @NamedQuery(name = "Articolo.findById", query = "SELECT a FROM Articolo a WHERE a.id = :id"),
    @NamedQuery(name = "Articolo.findByCodice", query = "SELECT a FROM Articolo a WHERE a.codice = :codice"),
    @NamedQuery(name = "Articolo.findByDescrizione", query = "SELECT a FROM Articolo a WHERE a.descrizione = :descrizione"),
    @NamedQuery(name = "Articolo.findByPeso", query = "SELECT a FROM Articolo a WHERE a.peso = :peso")})
public class Articolo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "codice")
    private String codice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descrizione")
    private String descrizione;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private double peso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticoli")
    private Collection<Voce> voceCollection;

    public Articolo() {
    }

    public Articolo(Integer id) {
        this.id = id;
    }

    public Articolo(Integer id, String codice, String descrizione, double peso) {
        this.id = id;
        this.codice = codice;
        this.descrizione = descrizione;
        this.peso = peso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @XmlTransient
    public Collection<Voce> getVoceCollection() {
        return voceCollection;
    }

    public void setVoceCollection(Collection<Voce> voceCollection) {
        this.voceCollection = voceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articolo)) {
            return false;
        }
        Articolo other = (Articolo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.engim.teamplatedb.beans.Articolo[ id=" + id + " ]";
    }
    
}
