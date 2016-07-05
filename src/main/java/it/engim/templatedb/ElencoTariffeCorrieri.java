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


import it.engim.teamplatedb.beans.TariffeCorriere;
import java.util.ArrayList;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

/**
 *
 * @author svilupposw
 */
public class ElencoTariffeCorrieri extends WebPage{

    public ElencoTariffeCorrieri() {
        
        ArrayList<IColumn<TariffeCorriere,String>>colonne=new ArrayList<IColumn<TariffeCorriere,String>>();
        
        colonne.add(new PropertyColumn<TariffeCorriere,String>
        (Model.of("Nome Corriere"),"nomeCorriere"));
        colonne.add(new PropertyColumn<TariffeCorriere,String>
        (Model.of("Nome Tariffa"),"nomeTariffa"));
        colonne.add(new PropertyColumn<TariffeCorriere,String>
        (Model.of("Peso Massimo"),"pesoMassimo"));
        colonne.add(new PropertyColumn<TariffeCorriere,String>
        (Model.of("Costo"),"costo"));
        
        
        add(new DefaultDataTable<TariffeCorriere,String>(
                "tariffecorriere",colonne,
                new TariffeCorriereDataProvider(),10));//il 1o è il numero di righe per ogni pagina 
        
        add(new Menu("menu"));
        
    }
    
}