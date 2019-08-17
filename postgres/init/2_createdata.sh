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
, title VARCHAR(255)
, tweet VARCHAR(1000)
, insert_user VARCHAR(255)
, insert_date timestamp
, update_user VARCHAR(255)
, update_date timestamp
);

INSERT INTO FOOD_ACTIVITY VALUES
 (1,1,'カレー','美味しいスパイスカレーを食べた。最高だった。','system', now(),'system', now())
 , (2,1,'牛丼','すき家の牛丼は結構美味しいのだ！','system', now(),'system', now())
 , (3,1,'ラーメン','鳥白湯ラーメンがお気に入り。','system', now(),'system', now())
 , (4,2,'プリン','子供の頃から大好き。','system', now(),'system', now())
 , (5,2,'ベビースターラーメン','3時のおやつに！','system', now(),'system', now())
 , (6,3,'タピオカドリンク','最近すごく流行っている。美味しい！','system', now(),'system', now())
 ;

SELECT setval('food_activity_id_seq', (SELECT MAX(ID) FROM FOOD_ACTIVITY));

EOSQL