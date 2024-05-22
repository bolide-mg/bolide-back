CREATE TABLE car(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(20),
    description TEXT,
    brand VARCHAR(20),
    price FLOAT,
    color VARCHAR(20),
    motor_type VARCHAR(20),
    power FLOAT,
    place_number INT,
    status VARCHAR(20) CHECK ( status IN ('available', 'waiting', 'sold') ),
    type VARCHAR(20)
);
