#!/bin/bash
psql -U root -d food_activity_db << "EOSQL"

CREATE TABLE USERS (
user_id SERIAL PRIMARY KEY
, user_name VARCHAR(255)
, email VARCHAR(255)
, password VARCHAR(255)
, insert_user VARCHAR(255)
, insert_date timestamp
, update_user VARCHAR(255)
, update_date timestamp
);

INSERT INTO USERS VALUES
 (1,'test','test@gmail.com','password','system', now(),'system', now())
 , (2,'tadokoro','tadokoro@gmail.com','password','system', now(),'system', now())
 , (3,'hanako','hanako@gmail.com','password','system', now(),'system', now())
 ;

SELECT setval('users_user_id_seq', (SELECT MAX(USER_ID) FROM USERS));

CREATE TABLE FOOD_ACTIVITY (
id SERIAL PRIMARY KEY
, user_id SERIAL
, name VARCHAR(255)
, description VARCHAR(1000)
, insert_user VARCHAR(255)
, insert_date timestamp
, update_user VARCHAR(255)
, update_date timestamp
);

INSERT INTO FOOD_ACTIVITY VALUES
 (1,1,'test','test','system', now(),'system', now())
 , (2,1,'test','test','system', now(),'system', now())
 , (3,1,'test','test','system', now(),'system', now())
 ;

SELECT setval('food_activity_id_seq', (SELECT MAX(ID) FROM FOOD_ACTIVITY));

EOSQL