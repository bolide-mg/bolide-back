CREATE TABLE car(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    description TEXT,
    brand VARCHAR(50),
    model VARCHAR(50),
    price FLOAT,
    color VARCHAR(70),
    motor_type VARCHAR(100),
    power FLOAT,
    place_number INT,
    status INT DEFAULT 0, --Default 0 means the car is not pinned (not highlighted on landing page, limited to 6 cars)
    type VARCHAR(70)
);
