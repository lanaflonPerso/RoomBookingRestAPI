
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

INSERT INTO user (login,name,surname,password) VALUES('jsmith','John','Smith','qwerty'),('jdoe','Jane','Doe','mySecret');
INSERT INTO room (name,location,phone,projector,seats) VALUES('Large Room','1st floor','22-22-22-22',true,10),('Medium Room','1st floor','',true,6),('Small Room','2nd floor','',false,4);

