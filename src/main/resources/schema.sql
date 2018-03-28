CREATE TABLE IF NOT EXISTS Person (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version    INTEGER NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    age        INTEGER  NOT NULL
);

CREATE TABLE IF NOT EXISTS House (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version    INTEGER NOT NULL,
    address    VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Person_House (
    person_id   INTEGER  NOT NULL,
    house_id    INTEGER  NOT NULL
);

CREATE INDEX IX_Person_House_Id ON Person_House (house_id);
ALTER TABLE Person_House ADD FOREIGN KEY (house_id) REFERENCES House(id);

CREATE INDEX IX_House_Person_Id ON Person_House (person_id);
ALTER TABLE Person_House ADD FOREIGN KEY (person_id) REFERENCES Person(id);

CREATE TABLE IF NOT EXISTS Organization (
    org_id  INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    org_name VARCHAR(50) NOT NULL,
    org_full_name VARCHAR(50) NOT NULL,
    org_inn VARCHAR(12) NOT NULL,
    kpp VARCHAR(9) NOT NULL,
    org_address VARCHAR(50) NOT NULL,
    org_phone VARCHAR(50),
    is_active BOOLEAN
);

CREATE TABLE IF NOT EXISTS Office (
    office_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    org_id INTEGER,
    office_address VARCHAR(50) NOT NULL,
    office_name VARCHAR(50) NOT NULL,
    office_phone VARCHAR(50),
    is_office_Active BOOLEAN
);

CREATE INDEX IX_Organization_Office_Id ON Office (org_id);
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization(org_id);

CREATE TABLE IF NOT EXISTS Doc_type (
    doc_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    doc_name VARCHAR(200) NOT NULL UNIQUE,
    doc_number VARCHAR(2) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS Country (
    country_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    country_name VARCHAR(50) NOT NULL UNIQUE,
    country_code INTEGER NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS User (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    login VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    user_name VARCHAR(50) NOT NULL,
    is_user_active BOOLEAN NOT NULL,
    activation_hash VARCHAR(50) UNIQUE
);

CREATE TABLE IF NOT EXISTS Worker (
    user_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    office_id INTEGER NOT NULL,
    doc_id INTEGER NOT NULL,
    country_id INTEGER NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50),
    position VARCHAR(50),
    phone VARCHAR(50) NOT NULL,
    doc_date DATE NOT NULL,
    is_identified BOOLEAN NOT NULL
);

CREATE INDEX IX_Doc_User_Id  ON Worker(doc_id);
ALTER TABLE Worker ADD FOREIGN KEY (doc_id) REFERENCES Doc_type(doc_id);