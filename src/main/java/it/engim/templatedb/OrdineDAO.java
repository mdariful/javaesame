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
package it.engim.templatedb;



import it.engim.teamplatedb.beans.Articolo;
import it.engim.teamplatedb.beans.Ordine;
import it.engim.teamplatedb.beans.Voce;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author svilupposw
 */
public class OrdineDAO {

    public static void salva(Ordine c) {
        EntityManager em
                = PM.getEM();
        EntityTransaction et
                = em.getTransaction();
        try {
            et.begin();
            em.merge(c);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }
    }

    public static List<Ordine> elenco() {
        EntityManager em = PM.getEM();
        try {
            Query q = em.createNamedQuery("Ordine.findAll");
            List<Ordine> res = q.getResultList();
            return res;
        } finally {
            em.close();
        }
    }

    public static void elimina(Ordine c) {
        EntityManager em = PM.getEM();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            c = em.find(Ordine.class, c.getId());
            em.remove(c);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }
    }
    public static double calcolaPeso(Ordine o, EntityManager em){
        o = em.find(o.getClass(), o.getId());
        Collection<Voce> olist = o.getVoceCollection();
        double pesoTotale = 0;
        for (Voce v: olist){
            Articolo a = v.getIdArticoli();
        pesoTotale += a.getPeso()*
                        v.getQuantità();
        }
        return pesoTotale;
    }
}

