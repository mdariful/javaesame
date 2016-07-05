DROP DATABASE IF EXISTS `arifulmd`;
CREATE DATABASE `arifulmd` DEFAULT CHARSET=utf8;
USE `arifulmd`;
CREATE TABLE `articolo`(
    `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `codice` VARCHAR(255) NOT NULL ,  
    `descrizione` varchar(255)NOT NULL ,
    `peso` double NOT NULL 
)ENGINE=InnoDB;

INSERT INTO `articolo` (`codice`,`descrizione`,`peso`)
    VALUES('PNDRV8','Pen drive USB 8G no brand ',0.1);
INSERT INTO `articolo` (`codice`,`descrizione`,`peso`)
    VALUES('DCP-J715E','Stampante Brother DCP J715 W',5.1);
INSERT INTO `articolo` (`codice`,`descrizione`,`peso`)
    VALUES('LNVCX1 ','Notebook Lenovo Carbon X1 ',  2.1);
INSERT INTO `articolo` (`codice`,`descrizione`,`peso`)
    VALUES('ALCPPC3','Smartphone Alcatel POP C3',0.6);
INSERT INTO `articolo` (`codice`,`descrizione`,`peso`)
    VALUES('BSHT1R','Ampli Combo valvolare BlackStar HT 1-R',5);

CREATE TABLE `ordine`(`id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `numero` INT NOT NULL ,  
    `data` DATE NOT NULL 
 
      
)ENGINE=InnoDB;


INSERT INTO `ordine` (`numero`,`data`)
    VALUES(55556,'2015-03-02');
INSERT INTO `ordine` (`numero`,`data`)
    VALUES(33315,'2015-04-12');
INSERT INTO `ordine` (`numero`,`data`)
    VALUES(56985,'2015-038-05');
INSERT INTO `ordine` (`numero`,`data`)
    VALUES(55546,'2015-03-02');
INSERT INTO `ordine` (`numero`,`data`)
    VALUES(53333,'2015-03-02');
INSERT INTO `ordine` (`numero`,`data`)
    VALUES(52345,'2015-03-02');
INSERT INTO `ordine` (`numero`,`data`)
    VALUES(55679,'2015-03-02');
INSERT INTO `ordine` (`numero`,`data`)
    VALUES(57788,'2015-03-02');
INSERT INTO `ordine` (`numero`,`data`)
    VALUES(55555,'2015-03-02');

CREATE TABLE `tariffe_corriere`(`id` INTEGER AUTO_INCREMENT PRIMARY KEY,
            `nome_corriere` VARCHAR(255) NOT NULL,
            `nome_tariffa`  VARCHAR(255) NOT NULL,
            `peso_massimo` double  NOT NULL,
            `costo` double NOT NULL 
       
    )ENGINE=InnoDB;


INSERT INTO `tariffe_corriere`(`nome_corriere`,`nome_tariffa`,`peso_massimo`,`costo`)
VALUES('SDA','Economy',1,6.10);

INSERT INTO `tariffe_corriere`(`nome_corriere`,`nome_tariffa`,`peso_massimo`,`costo`)
VALUES('SDA','Veloce ',5,7.80);

INSERT INTO `tariffe_corriere`(`nome_corriere`,`nome_tariffa`,`peso_massimo`,`costo`)
VALUES('SDA','Bigbox ',30,13.00);

INSERT INTO `tariffe_corriere`(`nome_corriere`,`nome_tariffa`,`peso_massimo`,`costo`)
VALUES('DHL','Veloce ',1.5,6.40);

INSERT INTO `tariffe_corriere`(`nome_corriere`,`nome_tariffa`,`peso_massimo`,`costo`)
VALUES('DHL ','Assicurata ',7.5,9.80);

INSERT INTO `tariffe_corriere`(`nome_corriere`,`nome_tariffa`,`peso_massimo`,`costo`)
VALUES('DHL','XXL ',40,13.80);

INSERT INTO `tariffe_corriere`(`nome_corriere`,`nome_tariffa`,`peso_massimo`,`costo`)
VALUES('UPS','Economy',0.7,5.15);

INSERT INTO `tariffe_corriere`(`nome_corriere`,`nome_tariffa`,`peso_massimo`,`costo`)
VALUES('UPS','Standard ',3,6.50);

INSERT INTO `tariffe_corriere`(`nome_corriere`,`nome_tariffa`,`peso_massimo`,`costo`)
VALUES('UPS','Jumbo ',25,11.40);


CREATE TABLE `voce`(`id` INTEGER AUTO_INCREMENT PRIMARY KEY,
            
            `id_ordini` INTEGER NOT NULL,
            `id_articoli` INTEGER NOT NULL,
            `quantità` double  NOT NULL,
             CONSTRAINT FOREIGN KEY (id_ordini) REFERENCES ordine(id) ,
             CONSTRAINT FOREIGN KEY (id_articoli) REFERENCES articolo(id) 
         
    )ENGINE=InnoDB;

    INSERT INTO `voce`(`id_ordini`,`id_articoli`,`quantità`)
    VALUES(1,2,3);


INSERT INTO `voce`(`id_ordini`,`id_articoli`,`quantità`)
VALUES(2,3,1);

INSERT INTO `voce`(`id_ordini`,`id_articoli`,`quantità`)
VALUES(2,4,1);

INSERT INTO `voce`(`id_ordini`,`id_articoli`,`quantità`)
VALUES(3,2,1);

INSERT INTO `voce`(`id_ordini`,`id_articoli`,`quantità`)
VALUES(3,3,1);

INSERT INTO `voce`(`id_ordini`,`id_articoli`,`quantità`)
VALUES(4,4,2);

INSERT INTO `voce`(`id_ordini`,`id_articoli`,`quantità`)
VALUES(4,1,1);

INSERT INTO `voce`(`id_ordini`,`id_articoli`,`quantità`)
VALUES(5,1,2);

INSERT INTO `voce`(`id_ordini`,`id_articoli`,`quantità`)
VALUES(5,4,1);

INSERT INTO `voce`(`id_ordini`,`id_articoli`,`quantità`)
VALUES(6,2,7);

INSERT INTO `voce`(`id_ordini`,`id_articoli`,`quantità`)
VALUES(7,1,3);

INSERT INTO `voce`(`id_ordini`,`id_articoli`,`quantità`)
VALUES(8,5,6);

INSERT INTO `voce`(`id_ordini`,`id_articoli`,`quantità`)
VALUES(9,5,1);

INSERT INTO `voce`(`id_ordini`,`id_articoli`,`quantità`)
VALUES(9,3,1);