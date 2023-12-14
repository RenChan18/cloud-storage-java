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


CREATE TYPE ItemType AS ENUM ('Folder', 'File');

CREATE TABLE FileSystem (
                            id SERIAL PRIMARY KEY,
                            parent_id INTEGER,
                            item_type ItemType,
                            title VARCHAR(255) NOT NULL,
                            icon VARCHAR(255),
                            user_id INTEGER REFERENCES users(id),
                            CONSTRAINT fk_parent_id FOREIGN KEY (parent_id) REFERENCES FileSystem (id) ON DELETE NO ACTION
);


