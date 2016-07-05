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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author svilupposw
 */
@Entity
@Table(name = "tariffe_corriere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TariffeCorriere.findAll", query = "SELECT t FROM TariffeCorriere t"),
    @NamedQuery(name = "TariffeCorriere.findById", query = "SELECT t FROM TariffeCorriere t WHERE t.id = :id"),
    @NamedQuery(name = "TariffeCorriere.findByNomeCorriere", query = "SELECT t FROM TariffeCorriere t WHERE t.nomeCorriere = :nomeCorriere"),
    @NamedQuery(name = "TariffeCorriere.findByNomeTariffa", query = "SELECT t FROM TariffeCorriere t WHERE t.nomeTariffa = :nomeTariffa"),
    @NamedQuery(name = "TariffeCorriere.findByPesoMassimo", query = "SELECT t FROM TariffeCorriere t WHERE t.pesoMassimo = :pesoMassimo"),
    @NamedQuery(name = "TariffeCorriere.findByCosto", query = "SELECT t FROM TariffeCorriere t WHERE t.costo = :costo"),
    @NamedQuery(name = "TariffeCorriere.findBest", query = "SELECT t FROM TariffeCorriere t WHERE t.pesoMassimo >= :peso order by t.costo")
})
public class TariffeCorriere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome_corriere")
    private String nomeCorriere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome_tariffa")
    private String nomeTariffa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso_massimo")
    private double pesoMassimo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private double costo;

    public TariffeCorriere() {
    }

    public TariffeCorriere(Integer id) {
        this.id = id;
    }

    public TariffeCorriere(Integer id, String nomeCorriere, String nomeTariffa, double pesoMassimo, double costo) {
        this.id = id;
        this.nomeCorriere = nomeCorriere;
        this.nomeTariffa = nomeTariffa;
        this.pesoMassimo = pesoMassimo;
        this.costo = costo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCorriere() {
        return nomeCorriere;
    }

    public void setNomeCorriere(String nomeCorriere) {
        this.nomeCorriere = nomeCorriere;
    }

    public String getNomeTariffa() {
        return nomeTariffa;
    }

    public void setNomeTariffa(String nomeTariffa) {
        this.nomeTariffa = nomeTariffa;
    }

    public double getPesoMassimo() {
        return pesoMassimo;
    }

    public void setPesoMassimo(double pesoMassimo) {
        this.pesoMassimo = pesoMassimo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
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
        if (!(object instanceof TariffeCorriere)) {
            return false;
        }
        TariffeCorriere other = (TariffeCorriere) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.engim.teamplatedb.beans.TariffeCorriere[ id=" + id + " ]";
    }
    
}
