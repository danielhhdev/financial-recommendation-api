CREATE TABLE users (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    age INTEGER,
    occupation VARCHAR(255),
    income DOUBLE PRECISION,
    marital_status VARCHAR(20),
    number_of_dependents INTEGER,
    risk_profile VARCHAR(20)
);

CREATE TABLE user_financial_goals (
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    financial_goals VARCHAR(255),
    PRIMARY KEY (user_id, financial_goals)
);

-- Tabla existing_products de usuarios (colección)
CREATE TABLE user_existing_products (
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    existing_products VARCHAR(255),
    PRIMARY KEY (user_id, existing_products)
);

CREATE TABLE products (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(2000),
    type VARCHAR(30),
    interest_rate DOUBLE PRECISION,
    fees DOUBLE PRECISION,
    min_amount DOUBLE PRECISION,
    max_amount DOUBLE PRECISION,
    eligibility_criteria VARCHAR(1000),
    risk_level VARCHAR(20),
    embedding TEXT
);

CREATE TABLE product_features (
    product_id UUID NOT NULL REFERENCES products(id) ON DELETE CASCADE,
    features VARCHAR(255),
    PRIMARY KEY (product_id, features)
);

CREATE TABLE financial_profiles (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL UNIQUE REFERENCES users(id),
    embedding TEXT
);

CREATE TABLE recommendations (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL REFERENCES users(id),
    product_id UUID NOT NULL REFERENCES products(id),
    score DOUBLE PRECISION
);