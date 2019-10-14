
CREATE TABLE reservation (
                             reservation_id int NOT NULL AUTO_INCREMENT,
                             starts timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                             ends timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                             room_name varchar(100) NOT NULL,
                             user_login varchar(100) NOT NULL,
                             CONSTRAINT reservation_pk PRIMARY KEY (reservation_id)
);


CREATE TABLE room (
                      id int NOT NULL AUTO_INCREMENT,
                      name varchar(50) NOT NULL,
                      location varchar(256) NULL,
                      seats int(100) NOT NULL,
                      projector boolean NULL DEFAULT false,
                      phone varchar(100) NULL,
                      CONSTRAINT room_name UNIQUE (name),
                      CONSTRAINT room_pk PRIMARY KEY (id)
);

CREATE TABLE user (
                      id int NOT NULL AUTO_INCREMENT,
                      login varchar(100) NOT NULL,
                      name varchar(50) NOT NULL,
                      surname varchar(100) NOT NULL,
                      password varchar(100) NOT NULL,
                      CONSTRAINT user_login UNIQUE (login),
                      CONSTRAINT user_pk PRIMARY KEY (id)
);


ALTER TABLE reservation ADD CONSTRAINT reservation_room FOREIGN KEY reservation_room (room_name)
    REFERENCES room (name);


ALTER TABLE reservation ADD CONSTRAINT reservation_user FOREIGN KEY reservation_user (user_login)
    REFERENCES user (login);

INSERT INTO user (login,name,surname,password) VALUES('MaciejM','Maciej','Mitura','password'),('UlaP','Ula','Pieta','password'),('PatrykG','Patrykk','Gorka','password');
INSERT INTO room (name,location,phone,projector,seats) VALUES('salka1','1st floor','123123123',true,100),('salka2','1st floor','123123123',true,100),('salka3',null,null,true,100);
INSERT INTO room (name,location,seats) VALUES('salka4','2st floor',30);
INSERT INTO reservation (user_login,room_name,starts,ends) VALUES('MaciejM','salka1','2019-10-13 12:30:0','2019-10-13 13:30:0');