INSERT INTO variation(name) VALUES('colours');
INSERT INTO variation(name) VALUES('shoe_sizes');
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


-- SELECT * FROM variation_option;
-- SELECT * 
-- FROM variation
-- RIGHT JOIN variation_option ON variation.id = variation_option.fk_variation_id;

INSERT INTO product_category(category_name) VALUES ("Men");
INSERT INTO product_category(category_name) VALUES ("Women");
INSERT INTO product_category(category_name,fk_parent_cat) VALUES ("Shoes",1);
INSERT INTO product_category(category_name,fk_parent_cat) VALUES ("Shoes",2);


