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
    org_name VARCHAR(50) NOT NULL,
    org_full_name VARCHAR(50) NOT NULL,
    inn INTEGER NOT NULL,
    kpp INTEGER NOT NULL,
    address VARCHAR(50) NOT NULL,
    org_phone VARCHAR(50) NOT NULL,
    is_Active BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS Office (
    office_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    org_id INTEGER NOT NULL,
    office_name VARCHAR(50) NOT NULL,
    office_phone VARCHAR(50) NOT NULL,
    is_office_Active BOOLEAN NOT NULL
);

CREATE INDEX IX_Organization_Office_Id ON Office (org_id);
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization(org_id);

CREATE TABLE IF NOT EXISTS Doc (
    doc_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    doc_name VARCHAR(50) NOT NULL UNIQUE,
    doc_number INTEGER NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS Country (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    country_name VARCHAR(50) NOT NULL UNIQUE,
    code INTEGER NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS User (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    user_name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS Worker (
    user_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    office_id INTEGER NOT NULL,
    doc_id INTEGER NOT NULL,
    citizenship_code INTEGER NOT NULL,

    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50),
    position VARCHAR(50),
    phone VARCHAR(50) NOT NULL,
    doc_date DATE NOT NULL,
    is_identified BOOLEAN NOT NULL
);

CREATE INDEX IX_Doc_User_Id  ON User(doc_id);
ALTER TABLE User ADD FOREIGN KEY (doc_id) REFERENCES Doc(doc_id);