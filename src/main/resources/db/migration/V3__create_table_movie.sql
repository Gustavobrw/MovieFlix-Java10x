CREATE TABLE movie(
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    release_date DATE,
    rating NUMERIC,
    create_at TIMESTAMP,
    update_at TIMESTAMP
);