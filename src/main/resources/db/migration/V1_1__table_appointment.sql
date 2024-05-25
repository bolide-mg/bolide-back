CREATE TABLE appointment(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    first_name VARCHAR(50),
    email VARCHAR(50),
    message TEXT,
    contact VARCHAR(20),
    appointment_date TIMESTAMP WITH TIME ZONE DEFAULT NOW() + interval '14 days',
    status VARCHAR(20) CHECK ( status IN ('pending', 'validated', 'rejected', 'archived') ),
    id_car INT REFERENCES car(id)
);
