CREATE TABLE insumo_item (
id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
category VARCHAR(50),
quantity INTEGER,
validity DATE
);