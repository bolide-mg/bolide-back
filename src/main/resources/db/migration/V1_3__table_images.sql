CREATE TABLE images(
    id SERIAL PRIMARY KEY,
    car_id INT REFERENCES car(id),
    url VARCHAR
)