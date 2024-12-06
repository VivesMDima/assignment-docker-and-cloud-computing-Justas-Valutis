-- Create the database "subscription" only if it does not already exist
DO $$
BEGIN
    IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'subscription') THEN
        CREATE DATABASE subscription;
    END IF;
END $$;

-- Create the user "justas" only if it does not already exist
DO $$
BEGIN
    IF NOT EXISTS (SELECT FROM pg_roles WHERE rolname = 'justas') THEN
        CREATE USER justas WITH ENCRYPTED PASSWORD 'justas';
    END IF;
END $$;

-- Grant all privileges on the database "subscription" to the user "justas"
GRANT ALL PRIVILEGES ON DATABASE subscription TO justas;

-- Connect to the "subscription" database
\c subscription;

-- Create the "app_subscription_type" table if it does not already exist
DO $$
BEGIN
    IF NOT EXISTS (
        SELECT FROM information_schema.tables 
        WHERE table_schema = 'public' AND table_name = 'app_subscription_type'
    ) THEN
        CREATE TABLE app_subscription_type (
            id SERIAL PRIMARY KEY,
            subscription_type VARCHAR(255) NOT NULL,
            subscription_duration_in_months INT NOT NULL,
            subscription_price_per_month DOUBLE PRECISION NOT NULL
        );
    END IF;
END $$;

-- Insert data into "app_subscription_type" only if it's not already populated
DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM app_subscription_type) THEN
        INSERT INTO app_subscription_type (subscription_type, subscription_duration_in_months, subscription_price_per_month)
        VALUES
            ('BJJ', 1, 50),
            ('BJJ', 3, 40),
            ('BJJ', 12, 35),
            ('GRAPLING', 1, 50),
            ('GRAPLING', 3, 40),
            ('GRAPLING', 12, 35),
            ('MMA', 1, 50),
            ('MMA', 3, 40),
            ('MMA', 12, 35),
            ('ALL_IN', 1, 100),
            ('ALL_IN', 3, 60),
            ('ALL_IN', 12, 50);
    END IF;
END $$;

