--DROP TABLE IF EXISTS item;
--DROP TABLE IF EXISTS user;
--DROP TABLE IF EXISTS orders;
--DROP TABLE IF EXISTS registered;
----DROP TABLE IF EXISTS try;
--
----CREATE TABLE item (
----    id int(11) unsigned NOT NULL AUTO_INCREMENT,
----    title varchar(300) NOT NULL ,
----    price DOUBLE  NOT NULL ,
----    quantity int(11) NOT NULL ,
----   picture_url varchar(max) NOT NULL,
----   liked BIT(1) NOT NULL,
----   cart BIT(1) NOT NULL ,
----    PRIMARY KEY (id)
----);
--
--CREATE TABLE item (
--    id int(11) unsigned NOT NULL AUTO_INCREMENT,
--    title varchar(300) DEFAULT '' ,
--    price DOUBLE DEFAULT ''  ,
--    in_stock int(11) DEFAULT '' ,
--    quantity int(11) DEFAULT '' ,
--   picture_url varchar(max) DEFAULT '',
--   liked BIT(1) DEFAULT '' ,
--   cart BIT(1) DEFAULT '' ,
--    PRIMARY KEY (id)
--);
--
--
--CREATE TABLE user (
--    id int(11) unsigned NOT NULL AUTO_INCREMENT,
--    first_name varchar(300)  DEFAULT '',
--    last_name varchar(300)  DEFAULT '',
--    email varchar(300)  DEFAULT '',
--     username varchar(20)  DEFAULT '' UNIQUE,
----    password int(11) NOT NULL ,
--    password varchar(30)  ,
----    phone int(11) NOT NULL,
--    phone varchar(30) ,
--    address varchar(300)  ,
----    active tinyint(1) NOT NULL DEFAULT '1',
--    active BIT(1)  DEFAULT '',
--         roles varchar(200)  DEFAULT '',
--         permissions varchar(200)  DEFAULT '',
--    PRIMARY KEY (username)
--);
--
--
----
----CREATE TABLE registered (
----    id int(11) unsigned NOT NULL AUTO_INCREMENT,
----     username varchar(20)  DEFAULT '',
------    password int(11) NOT NULL ,
----    password varchar(30)  ,
------    phone int(11) NOT NULL,
----
------    active tinyint(1) NOT NULL DEFAULT '1',
----    active BIT(1)  DEFAULT '',
----    PRIMARY KEY (id)
----);
--
----CREATE TABLE orders (
----    id int(11) unsigned NOT NULL AUTO_INCREMENT,
----    user_id int(11) NOT NULL ,
----    order_date date NOT NULL DEFAULT '',
----    shipping_address varchar(300) NOT NULL DEFAULT '' ,
----    total_price int(11) NOT NULL ,
----    status varchar(300) NOT NULL ,
----    item_id int(11) NOT NULL DEFAULT '',
----    PRIMARY KEY (id),
----     FOREIGN KEY (user_id) REFERENCES user(id),
----        FOREIGN KEY (item_id) REFERENCES item(id)
----
----);
--
--
----CREATE TABLE orders (
----    id int(11) unsigned NOT NULL AUTO_INCREMENT,
----    user_id int(11)  DEFAULT'1'  ,
----    order_date date NOT NULL DEFAULT '',
----    shipping_address varchar(300) NOT NULL  DEFAULT '' ,
----    total_price int(11)  DEFAULT'' ,
----    status varchar(300)  DEFAULT 'TEMP' ,
----    item_id  int(11)  DEFAULT'1',
----    PRIMARY KEY (id),
----     FOREIGN KEY (user_id) REFERENCES user(id),
----        FOREIGN KEY (item_id) REFERENCES item(id)
----);
--
--CREATE TABLE orders (
--    id int(11) unsigned NOT NULL AUTO_INCREMENT,
--    user_id int(11) DEFAULT '',
--    order_date date NOT NULL DEFAULT '',
--    shipping_address varchar(300) NOT NULL DEFAULT '' ,
--    total_price int(11) NOT NULL DEFAULT '',
--    status varchar(300) DEFAULT '',
----    item_id int(11) DEFAULT '',
--    items varchar(2000) NOT NULL,
----    item_id long NOT NULL DEFAULT '',
--
--    PRIMARY KEY (id),
--        FOREIGN KEY (user_id) REFERENCES user(id)
----           FOREIGN KEY (item_id) REFERENCES item(id)
--);
--
--
--INSERT INTO item (title , price , in_stock, quantity , picture_url , liked , cart ) VALUES
--('Oversized Check Detail Geometric Frame Sunglasses',235.59 , 10,10 ,'https://assets.burberry.com/is/image/Burberryltd/25AFC121-C9BB-4E61-907B-E84AC4DD7BB4?$BBY_V2_ML_1x1$&wid=2500&hei=2500',0 , 0),
--('Monogram Motif Oversized Round Frame Lola Sunglasses',321.92 , 10,10 , 'https://assets.burberry.com/is/image/Burberryltd/DF899DEE-DCB7-4613-98B7-736262E12BA9?$BBY_V2_ML_1x1$&wid=2500&hei=2500' ,0, 0),
--('Cat-eye Frame Sunglasses',261.93, 10 ,10, 'https://assets.burberry.com/is/image/Burberryltd/A9531EAC-A872-4D09-BD80-E11C4B38E696?$BBY_V2_ML_1x1$&wid=1500&hei=1500' , 0, 0),
--('Monogram Motif Oversized Square Frame Lola Sunglasses',288.27 , 10,10 , 'https://assets.burberry.com/is/image/Burberryltd/2D19261A-3DA3-4805-91B2-F821B03E954C?$BBY_V2_ML_1x1$&wid=2500&hei=2500',0, 0),
--('Logo Detail Cat-eye Frame Sunglasses',321.92, 10,10 , 'https://assets.burberry.com/is/image/Burberryltd/C357BB30-A4A8-4BDB-A40D-3D2399514B93?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0, 0 ),
--('Check Square Frame Sunglasses',261.93, 10,10 , 'https://assets.burberry.com/is/image/Burberryltd/67587F1D-2DBA-44DB-83DB-4C8A83F3DD3E?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0 , 0),
--('B Motif Square Frame Sunglasses',351.19, 10,10 , 'https://assets.burberry.com/is/image/Burberryltd/12822736-2D81-44D4-A30C-B05BD548FEA7?$BBY_V2_ML_1x1$&wid=2500&hei=2500' , 0, 0),
--('Vintage Check Detail Pilot Sunglasses',261.93, 10 ,10, 'https://assets.burberry.com/is/image/Burberryltd/c2ba9184d9c58a3de4409f3c1aaaea7b73a5ab02?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0, 0 ),
--('Logo Lens D-frame Sunglasses',261.93, 10 ,10, 'https://assets.burberry.com/is/image/Burberryltd/25640660-F83A-441E-ACE5-497D5E52151D?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0 , 0),
--('B Lens Detail Rectangular Frame Sunglasses',321.92, 10,10 , 'https://assets.burberry.com/is/image/Burberryltd/46a5a94d88131384bc0f594a81b2902f326a856e?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0 , 0),
--('Vintage Check Detail Butterfly Frame Sunglasses',235.59, 10 ,10, 'https://assets.burberry.com/is/image/Burberryltd/680e0ef168727a1be1deb616aed64c5fc866448c?$BBY_V2_ML_1x1$&wid=2500&hei=2500',0, 0 ),
--('B Motif Rectangular Frame Sunglasses',351.19, 10,10 , 'https://assets.burberry.com/is/image/Burberryltd/76BD3C41-FFD1-4D72-B7D9-3CD110B83F91?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0, 0 );
--
--INSERT INTO user (first_name , last_name , email ,username, password , phone , address, active, roles, permissions ) VALUES
--('lelian','hasan' , 'lelian@gmail.com' , 'lole','Lole123!','0983903444' , 'nazareth' , 0, '', ''),
--('lelian','hasan' , 'lelian@gmail.com' , 'lole3','Lole123!','0983903444' , 'nazareth' , 0, '', ''),
--('lelian','hasan' , 'lelian@gmail.com' , 'lole2','Lole123!','0983903444' , 'nazareth' , 0, '', '');
-- ******************
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS userItems;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS orderItems;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS registered;

--DROP TABLE IF EXISTS try;

--CREATE TABLE item (
--    id int(11) unsigned NOT NULL AUTO_INCREMENT,
--    title varchar(300) NOT NULL ,
--    price DOUBLE  NOT NULL ,
--    quantity int(11) NOT NULL ,
--   picture_url varchar(max) NOT NULL,
--   liked BIT(1) NOT NULL,
--   cart BIT(1) NOT NULL ,
--    PRIMARY KEY (id)
--);

CREATE TABLE item (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    title varchar(300) DEFAULT '' ,
    price DOUBLE DEFAULT ''  ,
    in_stock int(11) DEFAULT '' ,
--    quantity int(11) DEFAULT '' ,
   picture_url varchar(max) DEFAULT '',

    PRIMARY KEY (id)
);


CREATE TABLE user (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(300)  DEFAULT '',
    last_name varchar(300)  DEFAULT '',
    email varchar(300)  DEFAULT '',
     username varchar(20)  DEFAULT '',
--    password int(11) NOT NULL ,
    password varchar(30)  ,
--    phone int(11) NOT NULL,
    phone varchar(30) ,
--    address varchar(300)  ,
    country varchar(300)  ,
    city varchar(300)  ,
--    active tinyint(1) NOT NULL DEFAULT '1',
    active BIT(1)  DEFAULT '',
    roles varchar(200)  DEFAULT '',
    permissions varchar(200)  DEFAULT '',
    PRIMARY KEY (id)
);


--
--CREATE TABLE registered (
--    id int(11) unsigned NOT NULL AUTO_INCREMENT,
--     username varchar(20)  DEFAULT '',
----    password int(11) NOT NULL ,
--    password varchar(30)  ,
----    phone int(11) NOT NULL,
--
----    active tinyint(1) NOT NULL DEFAULT '1',
--    active BIT(1)  DEFAULT '',
--    PRIMARY KEY (id)
--);

--CREATE TABLE orders (
--    id int(11) unsigned NOT NULL AUTO_INCREMENT,
--    user_id int(11) NOT NULL ,
--    order_date date NOT NULL DEFAULT '',
--    shipping_address varchar(300) NOT NULL DEFAULT '' ,
--    total_price int(11) NOT NULL ,
--    status varchar(300) NOT NULL ,
--    item_id int(11) NOT NULL DEFAULT '',
--    PRIMARY KEY (id),
--     FOREIGN KEY (user_id) REFERENCES user(id),
--        FOREIGN KEY (item_id) REFERENCES item(id)
--
--);


--CREATE TABLE orders (
--    id int(11) unsigned NOT NULL AUTO_INCREMENT,
--    user_id int(11)  DEFAULT'1'  ,
--    order_date date NOT NULL DEFAULT '',
--    shipping_address varchar(300) NOT NULL  DEFAULT '' ,
--    total_price int(11)  DEFAULT'' ,
--    status varchar(300)  DEFAULT 'TEMP' ,
--    item_id  int(11)  DEFAULT'1',
--    PRIMARY KEY (id),
--     FOREIGN KEY (user_id) REFERENCES user(id),
--        FOREIGN KEY (item_id) REFERENCES item(id)
--);

--CREATE TABLE orders (
--    id int(11) unsigned NOT NULL AUTO_INCREMENT,
--    user_id int(11) DEFAULT '',
--    order_date date NOT NULL DEFAULT '',
--    shipping_address varchar(300) NOT NULL DEFAULT '' ,
--    total_price int(11) NOT NULL DEFAULT '',
--    status varchar(300) DEFAULT '',
----    item_id int(11) DEFAULT '',
--    item_id int (11) NOT NULL DEFAULT '',
----    item_id  long NOT NULL DEFAULT ''
--    PRIMARY KEY (id),
--        FOREIGN KEY (user_id) REFERENCES user(id)
----           FOREIGN KEY (item_id) REFERENCES item(id)
--);




CREATE TABLE orders (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    user_id int(11) DEFAULT '',
    order_date date NOT NULL DEFAULT '',
    shipping_address varchar(300) NOT NULL DEFAULT '',
    total_price DOUBLE NOT NULL DEFAULT '',
    status varchar(300) DEFAULT '',
    Number_of_items int(11) DEFAULT '',
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id),
);



CREATE TABLE orderItems (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    item_id int(11) DEFAULT '',
    quantity int(11) DEFAULT '' ,
    user_id int(11) DEFAULT '' NOT NULL,
    order_id int(11) DEFAULT '',
    PRIMARY KEY (id),
    FOREIGN KEY (item_id) REFERENCES item(id)  ,
    FOREIGN KEY (user_id) REFERENCES user(id)  ,
    FOREIGN KEY (order_id) REFERENCES orders(id)
);



CREATE TABLE userItems (
    id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
    item_id INT(11) NOT NULL,
    user_id INT(11) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (item_id) REFERENCES item(id),
    FOREIGN KEY (user_id) REFERENCES user(id),
    UNIQUE KEY unique_user_item (user_id, item_id)
);




--INSERT INTO item (title , price , in_stock, quantity , picture_url , liked , cart ) VALUES
--('Oversized Check Detail Geometric Frame Sunglasses',235.59 , 10,1 ,'https://assets.burberry.com/is/image/Burberryltd/25AFC121-C9BB-4E61-907B-E84AC4DD7BB4?$BBY_V2_ML_1x1$&wid=2500&hei=2500',0 , 0),
--('Monogram Motif Oversized Round Frame Lola Sunglasses',321.92 , 10,1 , 'https://assets.burberry.com/is/image/Burberryltd/DF899DEE-DCB7-4613-98B7-736262E12BA9?$BBY_V2_ML_1x1$&wid=2500&hei=2500' ,0, 0),
--('Cat-eye Frame Sunglasses',261.93, 10 ,1, 'https://assets.burberry.com/is/image/Burberryltd/A9531EAC-A872-4D09-BD80-E11C4B38E696?$BBY_V2_ML_1x1$&wid=1500&hei=1500' , 0, 0),
--('Monogram Motif Oversized Square Frame Lola Sunglasses',288.27 , 10,1 , 'https://assets.burberry.com/is/image/Burberryltd/2D19261A-3DA3-4805-91B2-F821B03E954C?$BBY_V2_ML_1x1$&wid=2500&hei=2500',0, 0),
--('Logo Detail Cat-eye Frame Sunglasses',321.92, 10,1 , 'https://assets.burberry.com/is/image/Burberryltd/C357BB30-A4A8-4BDB-A40D-3D2399514B93?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0, 0 ),
--('Check Square Frame Sunglasses',261.93, 10,1 , 'https://assets.burberry.com/is/image/Burberryltd/67587F1D-2DBA-44DB-83DB-4C8A83F3DD3E?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0 , 0),
--('B Motif Square Frame Sunglasses',351.19, 10,1 , 'https://assets.burberry.com/is/image/Burberryltd/12822736-2D81-44D4-A30C-B05BD548FEA7?$BBY_V2_ML_1x1$&wid=2500&hei=2500' , 0, 0),
--('Vintage Check Detail Pilot Sunglasses',261.93, 10 ,1, 'https://assets.burberry.com/is/image/Burberryltd/c2ba9184d9c58a3de4409f3c1aaaea7b73a5ab02?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0, 0 ),
--('Logo Lens D-frame Sunglasses',261.93, 10 ,1, 'https://assets.burberry.com/is/image/Burberryltd/25640660-F83A-441E-ACE5-497D5E52151D?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0 , 0),
--('B Lens Detail Rectangular Frame Sunglasses',321.92, 10,1 , 'https://assets.burberry.com/is/image/Burberryltd/46a5a94d88131384bc0f594a81b2902f326a856e?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0 , 0),
--('Vintage Check Detail Butterfly Frame Sunglasses',235.59, 10 ,1, 'https://assets.burberry.com/is/image/Burberryltd/680e0ef168727a1be1deb616aed64c5fc866448c?$BBY_V2_ML_1x1$&wid=2500&hei=2500',0, 0 ),
--('B Motif Rectangular Frame Sunglasses',351.19, 10,1 , 'https://assets.burberry.com/is/image/Burberryltd/76BD3C41-FFD1-4D72-B7D9-3CD110B83F91?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0, 0 );


--INSERT INTO item (title , price , in_stock , picture_url , liked , cart ) VALUES
--('Oversized Check Detail Geometric Frame Sunglasses',235.59 , 10,'https://assets.burberry.com/is/image/Burberryltd/25AFC121-C9BB-4E61-907B-E84AC4DD7BB4?$BBY_V2_ML_1x1$&wid=2500&hei=2500',0 , 0),
--('Monogram Motif Oversized Round Frame Lola Sunglasses',321.92 , 10 , 'https://assets.burberry.com/is/image/Burberryltd/DF899DEE-DCB7-4613-98B7-736262E12BA9?$BBY_V2_ML_1x1$&wid=2500&hei=2500' ,0, 0),
--('Cat-eye Frame Sunglasses',261.93, 10 , 'https://assets.burberry.com/is/image/Burberryltd/A9531EAC-A872-4D09-BD80-E11C4B38E696?$BBY_V2_ML_1x1$&wid=1500&hei=1500' , 0, 0),
--('Monogram Motif Oversized Square Frame Lola Sunglasses',288.27 , 10 , 'https://assets.burberry.com/is/image/Burberryltd/2D19261A-3DA3-4805-91B2-F821B03E954C?$BBY_V2_ML_1x1$&wid=2500&hei=2500',0, 0),
--('Logo Detail Cat-eye Frame Sunglasses',321.92, 10 , 'https://assets.burberry.com/is/image/Burberryltd/C357BB30-A4A8-4BDB-A40D-3D2399514B93?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0, 0 ),
--('Check Square Frame Sunglasses',261.93, 10 , 'https://assets.burberry.com/is/image/Burberryltd/67587F1D-2DBA-44DB-83DB-4C8A83F3DD3E?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0 , 0),
--('B Motif Square Frame Sunglasses',351.19, 10 , 'https://assets.burberry.com/is/image/Burberryltd/12822736-2D81-44D4-A30C-B05BD548FEA7?$BBY_V2_ML_1x1$&wid=2500&hei=2500' , 0, 0),
--('Vintage Check Detail Pilot Sunglasses',261.93, 10 , 'https://assets.burberry.com/is/image/Burberryltd/c2ba9184d9c58a3de4409f3c1aaaea7b73a5ab02?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0, 0 ),
--('Logo Lens D-frame Sunglasses',261.93, 10 , 'https://assets.burberry.com/is/image/Burberryltd/25640660-F83A-441E-ACE5-497D5E52151D?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0 , 0),
--('B Lens Detail Rectangular Frame Sunglasses',321.92, 10 , 'https://assets.burberry.com/is/image/Burberryltd/46a5a94d88131384bc0f594a81b2902f326a856e?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0 , 0),
--('Vintage Check Detail Butterfly Frame Sunglasses',235.59, 10 , 'https://assets.burberry.com/is/image/Burberryltd/680e0ef168727a1be1deb616aed64c5fc866448c?$BBY_V2_ML_1x1$&wid=2500&hei=2500',0, 0 ),
--('B Motif Rectangular Frame Sunglasses',351.19, 10 , 'https://assets.burberry.com/is/image/Burberryltd/76BD3C41-FFD1-4D72-B7D9-3CD110B83F91?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0, 0 );

--INSERT INTO user (first_name , last_name , email ,username, password , phone , address, active, roles, permissions ) VALUES
--('lelian','hasan' , 'lelian@gmail.com' , 'lole','Lole123!','0983903444' , 'nazareth' , 0, '', ''),
--('lelian','hasan' , 'lelian@gmail.com' , 'adan','Lole123!','0983903444' , 'nazareth' , 0, '', ''),
--('lelian','hasan' , 'lelian@gmail.com' , 'ali','Lole123!','0983903444' , 'nazareth' , 0, '', ''),
--('lelian','hasan' , 'lelian@gmail.com' , 'zozo','Lole123!','0983903444' , 'nazareth' , 0, '', ''),
--('lelian','hasan' , 'lelian@gmail.com' , 'Lelian','Lole123!','0983903444' , 'nazareth' , 0, '', '');

INSERT INTO user (first_name , last_name , email ,username, password , phone , country,city, active, roles, permissions ) VALUES
('lelian','hasan' , 'lelian@gmail.com' , 'lole','Lole123!','0983903444' ,'Israel', 'nazareth' , 0, '', ''),
('lelian','hasan' , 'lelian@gmail.com' , 'adan','Lole123!','0983903444','Israel' , 'nazareth' , 0, '', ''),
('lelian','hasan' , 'lelian@gmail.com' , 'ali','Lole123!','0983903444' ,'Israel', 'nazareth' , 0, '', ''),
('lelian','hasan' , 'lelian@gmail.com' , 'zozo','Lole123!','0983903444' ,'Israel', 'nazareth' , 0, '', ''),
('lelian','hasan' , 'lelian@gmail.com' , 'Lelian','Lole123!','0983903444' ,'Israel', 'nazareth' , 0, '', '');


--INSERT INTO user (first_name , last_name , email ,username, password , phone , country,city, active) VALUES
--('lelian','hasan' , 'lelian@gmail.com' , 'lole','Lole123!','0983903444' ,'Israel', 'nazareth' , 0),
--('lelian','hasan' , 'lelian@gmail.com' , 'adan','Lole123!','0983903444','Israel' , 'nazareth' , 1),
--('lelian','hasan' , 'lelian@gmail.com' , 'ali','Lole123!','0983903444' ,'Israel', 'nazareth' , 0),
--('lelian','hasan' , 'lelian@gmail.com' , 'zozo','Lole123!','0983903444' ,'Israel', 'nazareth' , 0),
--('lelian','hasan' , 'lelian@gmail.com' , 'Lelian','Lole123!','0983903444' ,'Israel', 'nazareth' , 0);

--INSERT INTO orders (user_name , order_date , shipping_address ,total_price, status  ) VALUES
--('adan','2004-04-25' , 'lelian@gmail.com' , 1,'TRMP');

--INSERT INTO userItems (item_id , user_name  ) VALUES
--(5,'adan'),
--(1,'adan' ),
--(3,'zozo' );


--INSERT INTO item (title , price , quantity , picture_url,show_details,is_liked,in_cart  ) VALUES
--('Chloe Marcie Medium Saddle Bag',1956.44 , 10 ,'https://www.chloe.com/product_image/45711449hx/f/w1080.jpg',0,0,0),
--('Dolcegabbana Small Sicily bag in Dauphine calfskin',1437.78 , 10 , 'https://www.dolcegabbana.com/dw/image/v2/AAGA_PRD/on/demandware.static/-/Sites-15/default/dwfca0000e/images/zoom/BB6003A1001_87192_0.jpg?sw=742&sh=944&sm=fit' ,0,0,0),
--('Chanel Wool Jersey & Gold-Tone Metal Light Orange',4814.00, 10 , 'https://www.chanel.com/images//t_one///q_auto:good,f_auto,fl_lossy,dpr_1.2/w_620/hobo-handbag-light-orange-wool-jersey-gold-tone-metal-wool-jersey-gold-tone-metal-packshot-artistique-vue1-as3690b09748nl302-9516407521310.jpg' ,0,0,0),
--('Celine TEEN SOFT 16 IN SUPPLE GRAINED CALFSKIN PEBBLE',2887.91 , 10 , 'https://twicpics.celine.com/product-prd/images/large/196853CR8.10BL_1_SPR23.jpg?twic=v1/cover=1:1/resize-max=720' ,0,0,0),
--('Balenciaga WOMEN`S HOURGLASS SMALL HANDBAG CROCODILE EMBOSSED IN PINK', 3000, 10 , 'https://balenciaga.dam.kering.com/m/52e250f3352a8ba5/eCom-5935461LR6Y5812_F.jpg?v=2',0,0,0 ),
--('Dolcegabbana Patent leather DG Logo Bag crossbody bag',1011.77, 10 , 'https://www.dolcegabbana.com/dw/image/v2/AAGA_PRD/on/demandware.static/-/Sites-15/default/dw78a9b694/images/zoom/BB7287A1471_80315_0.jpg?sw=742&sh=944&sm=fit',0,0 ,0),
--('Louis Vuitton Coussin PM',4999.00, 10 , 'https://eu.louisvuitton.com/images/is/image/lv/1/PP_VP_L/louis-vuitton-coussin-pm-h27-handbags--M21439_PM2_Front%20view.png?wid=2048&hei=2048' ,0,0,0),
--('Chanel Lambskin & Shiny Light Gold Metal Pink',4814.00, 10 , 'https://www.chanel.com/images//t_one///q_auto:good,f_auto,fl_lossy,dpr_1.2/w_620/small-hobo-bag-pink-lambskin-shiny-light-gold-metal-lambskin-shiny-light-gold-metal--packshot-artistique-vue1-as3917b10551nm373-9517681868830.jpg' ,0,0,0),
--('Ethereal Gray Box Calfskin',3500.00, 10 , 'https://wwws.dior.com/couture/ecommerce/media/catalog/product/cache/1/cover_image_1/870x580/17f82f742ffe127f42dca9de82fb58b1/v/f/1675443600_M9260UMOA_M47G_E01_ZHC.jpg?imwidth=870',0,0 ,0),
--('Calvin Klein Archive Large Square Flap Crossbody Bag',129.50, 10 , 'https://calvinklein.scene7.com/is/image/CalvinKlein/36200645_411_main?wid=720&hei=948&fmt=pjpeg&qlt=85%2C0&resMode=sharp2&op_usm=0.9%2C1.0%2C8%2C0&iccEmbed=0',0,0,0 ),
--('Chanel Shiny Calfskin & Gold-Tone Metal White',5500.00, 10 , 'https://www.chanel.com/images//t_one///q_auto:good,f_auto,fl_lossy,dpr_1.2/w_620/vanity-case-white-shiny-calfskin-gold-tone-metal-shiny-calfskin-gold-tone-metal--packshot-artistique-vue1-as3899b1037710601-9517680787486.jpg',0,0 ,0),
--('Gucci Ophidia mini bucket bag with Double G',1600.00, 10 , 'https://media.gucci.com/style/HEXF1E9FB_Center_0_0_2400x2400/1673894709/550620_DJ20G_3803_001_050_0016_Light-Ophidia-mini-bucket-bag-with-Double-G.jpg',0,0,0 ),
--('Michael Kors Adele Woven Leather Smartphone Wristlet',296.96, 10 , 'https://michaelkors.scene7.com/is/image/MichaelKors/34S3GJ6W4L-2998_1?wid=558&hei=748&op_sharpen=1&resMode=sharp2&qlt=90' ,0,0,0),
--('Fendi Black leather charm',1043.72, 10 , 'https://static.fendi.com/dam/is/image/fendi/7AS089A5DYF1HEJ_01?wid=88&hei=88&hash=d906e5efaf57d7acc52d8551b5e5dd88-17ee0b82703&sw=88&sh=88' ,0,0,0),
--('Valentino Rockstud flip-clasp leather pouch',451.31, 10 , 'https://assetsprx.matchesfashion.com/img/1428151/1/1300.jpg',0,0,0 ),
--('Prada Triangle leather mini-bag',1863.78, 10 , 'https://www.prada.com/content/dam/pradabkg_products/1/1BC/1BC543/2BYAF0377/1BC543_2BYA_F0377_V_YRO_SLF.jpg/jcr:content/renditions/cq5dam.web.hebebed.1500.1500.crop.jpg',0,0,0 );

INSERT INTO item (title , price , in_stock , picture_url  ) VALUES
('Chloe Marcie Medium Saddle Bag',1956.44 , 10 ,'https://www.chloe.com/product_image/45711449hx/f/w1080.jpg'),
('Dolcegabbana Logo Bag box handbag',4395.73 , 10 , 'https://www.dolcegabbana.com/dw/image/v2/BKDB_PRD/on/demandware.static/-/Sites-15/default/dw363e75cf/images/zoom/BB7544AY828_89869_0.jpg' ),
('Chanel Wool Jersey & Gold-Tone Metal Light Orange',4814.00, 10 , 'https://www.chanel.com/images//t_one///q_auto:good,f_auto,fl_lossy,dpr_1.2/w_620/hobo-handbag-light-orange-wool-jersey-gold-tone-metal-wool-jersey-gold-tone-metal-packshot-artistique-vue1-as3690b09748nl302-9516407521310.jpg' ),
('Celine TEEN SOFT 16 IN SUPPLE GRAINED CALFSKIN PEBBLE',2887.91 , 10 , 'https://twicpics.celine.com/product-prd/images/large/196853CR8.10BL_1_SPR23.jpg?twic=v1/cover=1:1/resize-max=720' ),
('Balenciaga WOMEN`S HOURGLASS SMALL HANDBAG CROCODILE EMBOSSED IN PINK', 3000, 10 , 'https://balenciaga.dam.kering.com/m/52e250f3352a8ba5/eCom-5935461LR6Y5812_F.jpg?v=2' ),
('Dolcegabbana Calfskin DG Logo crossbody bag',1279.77, 10 , 'https://www.dolcegabbana.com/dw/image/v2/BKDB_PRD/on/demandware.static/-/Sites-15/default/dw4b287817/images/zoom/BB7287AW576_80402_0.jpg'),
('Louis Vuitton Coussin PM',4999.00, 10 , 'https://eu.louisvuitton.com/images/is/image/lv/1/PP_VP_L/louis-vuitton-coussin-pm-h27-handbags--M21439_PM2_Front%20view.png?wid=2048&hei=2048'),
('Chanel Lambskin & Shiny Light Gold Metal Pink',4814.00, 10 , 'https://www.chanel.com/images//t_one///q_auto:good,f_auto,fl_lossy,dpr_1.2/w_620/small-hobo-bag-pink-lambskin-shiny-light-gold-metal-lambskin-shiny-light-gold-metal--packshot-artistique-vue1-as3917b10551nm373-9517681868830.jpg' ),
('Ethereal Gray Box Calfskin',3500.00, 10 , 'https://wwws.dior.com/couture/ecommerce/media/catalog/product/cache/1/cover_image_1/870x580/17f82f742ffe127f42dca9de82fb58b1/v/f/1675443600_M9260UMOA_M47G_E01_ZHC.jpg?imwidth=870'),
('Calvin Klein Archive Large Square Flap Crossbody Bag',129.50, 10 , 'https://calvinklein.scene7.com/is/image/CalvinKlein/36200645_411_main?wid=720&hei=948&fmt=pjpeg&qlt=85%2C0&resMode=sharp2&op_usm=0.9%2C1.0%2C8%2C0&iccEmbed=0'),
('Chanel Shiny Calfskin & Gold-Tone Metal White',5500.00, 10 , 'https://www.chanel.com/images//t_one///q_auto:good,f_auto,fl_lossy,dpr_1.2/w_620/vanity-case-white-shiny-calfskin-gold-tone-metal-shiny-calfskin-gold-tone-metal--packshot-artistique-vue1-as3899b1037710601-9517680787486.jpg'),
('Gucci Ophidia mini bucket bag with Double G',1600.00, 10 , 'https://media.gucci.com/style/HEXF1E9FB_Center_0_0_2400x2400/1673894709/550620_DJ20G_3803_001_050_0016_Light-Ophidia-mini-bucket-bag-with-Double-G.jpg'),
('Michael Kors Adele Woven Leather Smartphone Wristlet',296.96, 10 , 'https://michaelkors.scene7.com/is/image/MichaelKors/34S3GJ6W4L-2998_1?wid=558&hei=748&op_sharpen=1&resMode=sharp2&qlt=90' ),
('Fendi Black leather charm',1043.72, 10 , 'https://static.fendi.com/dam/is/image/fendi/7AS089A5DYF1HEJ_01?wid=88&hei=88&hash=d906e5efaf57d7acc52d8551b5e5dd88-17ee0b82703&sw=88&sh=88' ),
('Valentino Rockstud flip-clasp leather pouch',451.31, 10 , 'https://cdn.endource.com/image/3a9ec93803d9ce83f98faf97fb379a29/detail/rockstud-flip-clasp-leather-pouch.jpg?optimizer=image&class=400' ),
('Prada Triangle leather mini-bag',1863.78, 10 , 'https://www.prada.com/content/dam/pradabkg_products/1/1BC/1BC543/2BYAF0377/1BC543_2BYA_F0377_V_YRO_SLF.jpg/jcr:content/renditions/cq5dam.web.hebebed.1500.1500.crop.jpg');


