CREATE TABLE IF NOT EXISTS organizations (
	id          INTEGER NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
	name        VARCHAR NOT NULL COMMENT 'Краткое название организации',
	inn         VARCHAR(10) NOT NULL COMMENT 'ИНН организации',
	isActive    BOOLEAN NOT NULL  COMMENT 'Статус организации: активна/ликвидирована' DEFAULT 'TRUE',
	fullName    VARCHAR NOT NULL COMMENT 'Полное название организации',
	kpp         VARCHAR(9) NOT NULL COMMENT 'КПП организации',
	address     VARCHAR NOT NULL COMMENT 'Официальный адрес юридического лица',
	phone       VARCHAR UNIQUE COMMENT 'Основной телефон организации',
	version     INTEGER NOT NULL COMMENT 'Служебная метка версионирования таблицы'
);
COMMENT ON TABLE organizations IS 'Список оранизаций';

CREATE TABLE IF NOT EXISTS offices (
	id          INTEGER NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
	name        VARCHAR COMMENT 'Краткое наименование офиса',
	phone       VARCHAR UNIQUE COMMENT 'Телефон приемной/секретаря',
	isActive    BOOLEAN NOT NULL COMMENT 'Статус офиса: функционирует/упразднен',
	address     VARCHAR NOT NULL COMMENT 'Адрес офиса',
	orgId       INTEGER NOT NULL COMMENT 'Идентификатор организации, которой принадлежит офис',
	version     INTEGER NOT NULL COMMENT 'Служебная метка версионирования таблицы'
);
COMMENT ON TABLE offices IS 'Офисы организации';

CREATE TABLE IF NOT EXISTS users (
	id          INTEGER NOT NULL  COMMENT 'Уникальный идентификатор сотрудника' PRIMARY KEY AUTO_INCREMENT,
	firstName   VARCHAR NOT NULL COMMENT 'Имя сотрудника',
	secondName  VARCHAR NOT NULL COMMENT 'Фамилия сотрудника',
	middleName  VARCHAR COMMENT 'Отчество сотрудника',
	phone       VARCHAR UNIQUE COMMENT 'Рабочий телефон сотрудника',
	citizenship INTEGER NOT NULL COMMENT 'Идентификатор гражданства сотрудника',
	position    INTEGER NOT NULL COMMENT 'Идентификатор должности сотрудника',
	version     INTEGER NOT NULL COMMENT 'Служебная метка версионирования таблицы'
);
COMMENT ON TABLE users IS 'Сотрудники организации';

CREATE TABLE IF NOT EXISTS user_offices (
	id          INTEGER NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
	user_id     INTEGER NOT NULL COMMENT 'Уникальный идентификатор сотрудника',
	office_id   INTEGER NOT NULL COMMENT 'Уникальный идентификатор офиса',
	primary_office BOOLEAN NOT NULL COMMENT 'Метка основного офиса сотрудника' DEFAULT 'FALSE'
);
COMMENT ON TABLE user_offices IS 'Таблица связи сотрудников и офисов';

CREATE TABLE IF NOT EXISTS user_docs (
	id          INTEGER NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
	doc_code    VARCHAR NOT NULL COMMENT 'Уникальный идентификатор типа документа',
	doc_number  VARCHAR NOT NULL COMMENT 'Номер документа',
	user_id     INTEGER NOT NULL COMMENT 'Уникальный идентификатор сотрудника',
	isIdentified BOOLEAN NOT NULL COMMENT 'Метка подтвержденного документа' DEFAULT 'FALSE',
	doc_date    DATE COMMENT 'Дата выдачи документа'
);
COMMENT ON TABLE user_docs IS 'Документы сотрудника';

CREATE TABLE IF NOT EXISTS documents (
	code        VARCHAR NOT NULL COMMENT 'Уникальный код типа документа' PRIMARY KEY,
	name        VARCHAR NOT NULL COMMENT 'Русскоязычное название документа'
);
COMMENT ON TABLE documents IS 'Справочников типов документов';

CREATE TABLE IF NOT EXISTS countries (
	code        VARCHAR NOT NULL COMMENT 'Уникальный код страны' PRIMARY KEY,
	name        VARCHAR NOT NULL COMMENT 'Официальное название страны'
);
COMMENT ON TABLE countries IS 'Справочников стран';

CREATE TABLE IF NOT EXISTS titles (
	id          INTEGER NOT NULL COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
	title_name  VARCHAR NOT NULL COMMENT 'Название должности'
);
COMMENT ON TABLE titles IS 'Справочников должностей';

ALTER TABLE offices ADD FOREIGN KEY     (orgId)         REFERENCES organizations(id);

ALTER TABLE users ADD FOREIGN KEY       (office)        REFERENCES offices(id);
ALTER TABLE users ADD FOREIGN KEY       (citizenship)   REFERENCES countries(code);
ALTER TABLE users ADD FOREIGN KEY       (position)      REFERENCES titles(id);

ALTER TABLE user_docs ADD FOREIGN KEY   (doc_code)      REFERENCES documents(name);
ALTER TABLE user_docs ADD FOREIGN KEY   (user_id)       REFERENCES users(id);

ALTER TABLE user_offices ADD FOREIGN KEY (user_id)      REFERENCES users(id);
ALTER TABLE user_offices ADD FOREIGN KEY (office_id)    REFERENCES offices(id);
