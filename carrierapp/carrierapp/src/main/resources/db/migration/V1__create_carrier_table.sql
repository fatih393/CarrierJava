CREATE TABLE carrier (
    id SERIAL PRIMARY KEY,
    carrier_name VARCHAR(255) NOT NULL,
    carriers_active BOOLEAN NOT NULL,
    carrier_plus_desi_cost INT NOT NULL
);
