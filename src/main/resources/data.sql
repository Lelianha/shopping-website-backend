
DROP TABLE IF EXISTS poll;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS answers;



CREATE TABLE poll (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    title varchar(300)  ,
   first_option varchar(300)  ,
   second_option varchar(300)  ,
   third_option varchar(300)  ,
   fourth_option varchar(300)  ,
    PRIMARY KEY (id)
);


CREATE TABLE user (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(300) ,
    last_name varchar(300) ,
    email varchar(300) ,
    age int(11)  ,
    address varchar(300)  ,
   joining_date date NOT NULL ,
    PRIMARY KEY (id)
);



 CREATE TABLE answers (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
       user_id int (11),
      question_id int (11)  NOT NULL  ,
         answer  varchar (300)  NOT NULL DEFAULT 'NO',
        PRIMARY KEY (id),
          FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE ,
                FOREIGN KEY (question_id) REFERENCES poll(id) ON DELETE CASCADE

);



INSERT INTO poll (title , first_option , second_option , third_option , fourth_option ) VALUES

('If you could live anywhere, where would it be?','America','Russia','France','Germany'),
('What really makes you angry?','Screaming children','People that talk during eat','Being ignored',' Not feeling heard'  ),
('If you could choose to do anything for a day, what would it be?','Studying','Spending time with friends','Watching movies','Preparing sweets' ),
('In the evening, would you rather to :' ,'Play a game','Visit a relative','Watch a movie',' Read' ),
('If you could go back in time, what year would you travel to?','2019','2018','2016',' 2013' ),
('What are your hobbies?','Sing','Swim','Play football', 'Dance' ),
('If you were a super-hero, what power would you have?','Read thoughts','The ability to disappear','Prediction','The ability to fly' ),
('What form of public transportation do you prefer?','Boat','Train','Bus','Airplane'),
('What is your favorite animal?','Penguin','Dolphin','Butterfly','Flamingo'),
('What is your favorite fast food chain?','McDonals','Burger king','KFC',' MAX');





