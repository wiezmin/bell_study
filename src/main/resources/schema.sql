CREATE TABLE IF NOT EXISTS organizations (
	id          INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT ,
	name        VARCHAR NOT NULL,
	inn         VARCHAR(10) NOT NULL UNIQUE,
	isActive    BOOLEAN NOT NULL DEFAULT 'TRUE',
	fullName    VARCHAR NOT NULL,
	kpp         VARCHAR(9) NOT NULL,
	address     VARCHAR NOT NULL,
	phone       VARCHAR UNIQUE,
	version     INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS office (
	id serial NOT NULL,
	name VARCHAR NOT NULL,
	phone VARCHAR UNIQUE,
	isActive BOOLEAN NOT NULL,
	address VARCHAR NOT NULL,
	orgId INTEGER NOT NULL,
	version INTEGER NOT NULL,
	CONSTRAINT offices_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS staff (
	id serial NOT NULL,
	firstName VARCHAR NOT NULL,
	secondName VARCHAR,
	middleName VARCHAR,
	phone VARCHAR,
	office INTEGER NOT NULL,
	citizenship INTEGER NOT NULL,
	position INTEGER NOT NULL,
	version INTEGER NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS documents (
	code VARCHAR NOT NULL,
	name VARCHAR NOT NULL,
	CONSTRAINT documents_pk PRIMARY KEY (code)
);

CREATE TABLE IF NOT EXISTS countries (
	code VARCHAR NOT NULL UNIQUE,
	name VARCHAR NOT NULL UNIQUE,
	CONSTRAINT countries_pk PRIMARY KEY (code)
);

CREATE TABLE IF NOT EXISTS user_docs (
	id serial NOT NULL,
	doc_code VARCHAR NOT NULL,
	user_id INTEGER NOT NULL,
	isIdentified BOOLEAN NOT NULL,
	doc_date DATE NOT NULL,
	CONSTRAINT user_docs_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS titles (
	title_name VARCHAR NOT NULL,
	id serial NOT NULL,
	CONSTRAINT titles_pk PRIMARY KEY (id)
);

ALTER TABLE offices ADD FOREIGN KEY offices_fk0 FOREIGN KEY (orgId) REFERENCES organizations(id);
ALTER TABLE users ADD FOREIGN KEY users_fk0 FOREIGN KEY (office) REFERENCES offices(id);
ALTER TABLE users ADD FOREIGN KEY users_fk1 FOREIGN KEY (citizenship) REFERENCES countries(code);
ALTER TABLE users ADD FOREIGN KEY users_fk2 FOREIGN KEY (position) REFERENCES titles(id);
ALTER TABLE user_docs ADD FOREIGN KEY user_docs_fk0 FOREIGN KEY (doc_code) REFERENCES documents(name);
ALTER TABLE user_docs ADD FOREIGN KEY user_docs_fk1 FOREIGN KEY (user_id) REFERENCES users(id);

