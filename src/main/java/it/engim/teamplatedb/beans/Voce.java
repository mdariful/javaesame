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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author svilupposw
 */
@Entity
@Table(name = "voce")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voce.findAll", query = "SELECT v FROM Voce v"),
    @NamedQuery(name = "Voce.findById", query = "SELECT v FROM Voce v WHERE v.id = :id"),
    @NamedQuery(name = "Voce.findByQuantit\u00e0", query = "SELECT v FROM Voce v WHERE v.quantit\u00e0 = :quantit\u00e0")})
public class Voce implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantit\u00e0")
    private double quantità;
    @JoinColumn(name = "id_articoli", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Articolo idArticoli;
    @JoinColumn(name = "id_ordini", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ordine idOrdini;

    public Voce() {
    }

    public Voce(Integer id) {
        this.id = id;
    }

    public Voce(Integer id, double quantità) {
        this.id = id;
        this.quantità = quantità;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getQuantità() {
        return quantità;
    }

    public void setQuantità(double quantità) {
        this.quantità = quantità;
    }

    public Articolo getIdArticoli() {
        return idArticoli;
    }

    public void setIdArticoli(Articolo idArticoli) {
        this.idArticoli = idArticoli;
    }

    public Ordine getIdOrdini() {
        return idOrdini;
    }

    public void setIdOrdini(Ordine idOrdini) {
        this.idOrdini = idOrdini;
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
        if (!(object instanceof Voce)) {
            return false;
        }
        Voce other = (Voce) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.engim.teamplatedb.beans.Voce[ id=" + id + " ]";
    }
    
}
