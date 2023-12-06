create table users(
    id  BIGSERIAL PRIMARY KEY,
    firstname character varying(128) NOT NULL,
    lastname character varying(128),
    email character varying(128) NOT NULL UNIQUE CHECK(email ~* '^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$'),
    hashpassword character varying(128) NOT NULL
);

CREATE OR REPLACE FUNCTION tolowercase_email() 
RETURNS trigger AS $tolowercase_email$
    BEGIN        
        NEW.email = LOWER(NEW.email);
        RETURN NEW;
    END;
$tolowercase_email$ LANGUAGE plpgsql;

CREATE TRIGGER tolowercase_email BEFORE INSERT OR UPDATE ON users
    FOR EACH ROW EXECUTE PROCEDURE tolowercase_email();

CREATE TABLE directories (
                             id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
                             name VARCHAR(255) NOT NULL,
                             directory_id INTEGER REFERENCES directories(directory_id) DEFAULT NULL,
                             created_at TIMESTAMPTZ DEFAULT current_timestamp,
                             edited_at TIMESTAMPTZ DEFAULT current_timestamp
);
CREATE TABLE files (
                       id UUID PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       user_id INTEGER REFERENCES users(id),
                       directory_id INTEGER REFERENCES directories(directory_id) DEFAULT NULL,
                       size INTEGER,
                       data TEXT,
                       upload_at TIMESTAMPTZ DEFAULT current_timestamp,
                       CONSTRAINT file_extension CHECK (position('.' in name) > 0)
);