--Product Categories(Self join tables with foreign key)
INSERT INTO product_category(category_name) VALUES ("Men");
INSERT INTO product_category(category_name) VALUES ("Women");
INSERT INTO product_category(category_name,fk_parent_cat) VALUES ("Shoes",1);
INSERT INTO product_category(category_name,fk_parent_cat) VALUES ("Shoes",2);

-- Variations for given categories
INSERT INTO variation(name,fk_category_id) VALUES('colours',3);
INSERT INTO variation(name,fk_category_id) VALUES('colours',4);
INSERT INTO variation(name,fk_category_id) VALUES('shoe_sizes',3);
INSERT INTO variation(name,fk_category_id) VALUES('shoe_sizes',4);

--Male shoe colours
INSERT INTO variation_option(value, fk_variation_id) VALUES("red",1);
INSERT INTO variation_option(value, fk_variation_id) VALUES("orange",1);
INSERT INTO variation_option(value, fk_variation_id) VALUES("yellow",1);
INSERT INTO variation_option(value, fk_variation_id) VALUES("green",1);
INSERT INTO variation_option(value, fk_variation_id) VALUES("blue",1);
INSERT INTO variation_option(value, fk_variation_id) VALUES("purple",1);
INSERT INTO variation_option(value, fk_variation_id) VALUES("black",1);
INSERT INTO variation_option(value, fk_variation_id) VALUES("white",1);
INSERT INTO variation_option(value, fk_variation_id) VALUES("grey",1);
INSERT INTO variation_option(value, fk_variation_id) VALUES("pink",1);
INSERT INTO variation_option(value, fk_variation_id) VALUES("brown",1);
INSERT INTO variation_option(value, fk_variation_id) VALUES("white",1);

--Male shoe sizes
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_7",3);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_7.5",3);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_8",3);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_8.5",3);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_9",3);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_9.5",3);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_10",3);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_10.5",3);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_11",3);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_11.5",3);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_12",3);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_13",3);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_14",3);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_15",3);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_16",3);

--Female shoe sizes
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_5",4);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_5.5",4);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_6",4);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_6.5",4);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_7",4);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_7.5",4);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_8",4);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_8.5",4);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_9",4);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_9.5",4);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_10",4);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_10.5",4);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_11",4);
INSERT INTO variation_option(value, fk_variation_id) VALUES("US_12",4);

--Female shoe colours
INSERT INTO variation_option(value, fk_variation_id) VALUES("red",2);
INSERT INTO variation_option(value, fk_variation_id) VALUES("orange",2);
INSERT INTO variation_option(value, fk_variation_id) VALUES("yellow",2);
INSERT INTO variation_option(value, fk_variation_id) VALUES("green",2);
INSERT INTO variation_option(value, fk_variation_id) VALUES("blue",2);
INSERT INTO variation_option(value, fk_variation_id) VALUES("purple",2);
INSERT INTO variation_option(value, fk_variation_id) VALUES("black",2);
INSERT INTO variation_option(value, fk_variation_id) VALUES("white",2);
INSERT INTO variation_option(value, fk_variation_id) VALUES("grey",2);
INSERT INTO variation_option(value, fk_variation_id) VALUES("pink",2);
INSERT INTO variation_option(value, fk_variation_id) VALUES("brown",2);
INSERT INTO variation_option(value, fk_variation_id) VALUES("white",2);



-- SELECT * FROM variation_option;
-- SELECT * 
-- FROM variation
-- RIGHT JOIN variation_option ON variation.id = variation_option.fk_variation_id;




