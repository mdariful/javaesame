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


import it.engim.templatedb.ElencoArticoli;
import it.engim.templatedb.HomePage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;

/**
 *
 * @author svilupposw
 */
public class Menu extends Panel{
    
    public Menu(String id) {
        super(id);
        BookmarkablePageLink home= new BookmarkablePageLink("home",HomePage.class);
        BookmarkablePageLink articoli= new BookmarkablePageLink("articoli",ElencoArticoli.class);
        BookmarkablePageLink ordini= new BookmarkablePageLink("ordini",ElencoOrdini.class);
        BookmarkablePageLink tariffe= new BookmarkablePageLink("tariffe",ElencoTariffeCorrieri.class);
    add(home);
    add(articoli);
    add(ordini);
    add(tariffe);
    }
    
}