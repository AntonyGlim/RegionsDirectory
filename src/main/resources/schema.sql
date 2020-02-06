create table regions
(
   id IDENTITY NOT NULL PRIMARY KEY,
   code INTEGER NOT NULL UNIQUE,
   title VARCHAR (32) NOT NULL,
   iso VARCHAR (8) NOT NULL
);