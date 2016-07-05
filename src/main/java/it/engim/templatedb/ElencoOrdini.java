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


import it.engim.teamplatedb.beans.Ordine;
import it.engim.teamplatedb.beans.TariffeCorriere;
import java.util.ArrayList;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 *
 * @author svilupposw
 */
public class ElencoOrdini extends WebPage{

    public ElencoOrdini() {
        
        ArrayList<IColumn<Ordine,String>>colonne=new ArrayList<IColumn<Ordine,String>>();
        
        colonne.add(new PropertyColumn<Ordine,String>
        (Model.of("Id"),"id"));
        colonne.add(new PropertyColumn<Ordine,String>
        (Model.of("Numero"),"numero"));
        colonne.add(new PropertyColumn<Ordine,String>
        (Model.of("Data"),"data"));
        colonne.add(new AbstractColumn<Ordine,String>
        (Model.of("Id Ordine")) {
            @Override
            public void populateItem(Item<ICellPopulator<Ordine>> item, String wicketId, IModel<Ordine> imodel) {
                Ordine o = imodel.getObject(); 
                item.add(new Label(wicketId, o.getId()));
                
            }
        });
        
        colonne.add(new AbstractColumn<Ordine,String>
        (Model.of("Tariffa migliore")) {
            @Override
            public void populateItem(Item<ICellPopulator<Ordine>> item, String wicketId, IModel<Ordine> imodel) {
                Ordine o = imodel.getObject(); 
                TariffeCorriere t = TariffeCorriereDAO.calcolaTariffaMigliore(o);
                item.add(new Label(wicketId, "€"+t.getCosto()));
                
            }
        });
        colonne.add(new AbstractColumn<Ordine,String>
        (Model.of("Nome corriere")) {
            @Override
            public void populateItem(Item<ICellPopulator<Ordine>> item, String wicketId, IModel<Ordine> imodel) {
                Ordine o = imodel.getObject(); 
                TariffeCorriere t = TariffeCorriereDAO.calcolaTariffaMigliore(o);
                item.add(new Label(wicketId, t.getNomeCorriere()));
                
            }
        });
        
        
        add(new DefaultDataTable<Ordine,String>(
                "ordine",colonne,
                new OrdineDataProvider(),10));//il 1o è il numero di righe per ogni pagina 
        
        add(new Menu("menu"));
        
    }
    
}