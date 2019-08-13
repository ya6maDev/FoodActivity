#!/bin/bash
psql -U root -d food_activity_db << "EOSQL"

CREATE TABLE person (
id SERIAL PRIMARY KEY
, name VARCHAR(255)
, email VARCHAR(255)
, password VARCHAR(255)
);

INSERT INTO person VALUES
 (1,'taro','taro@gmail.com','password')
 , (2,'tadokoro','tadokoro@gmail.com','password')
 , (3,'hanako','hanako@gmail.com','password');

EOSQL