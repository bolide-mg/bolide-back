CREATE TABLE images(
    id SERIAL PRIMARY KEY,
    file_name VARCHAR,
    car_id INT REFERENCES car(id),
    url VARCHAR
)