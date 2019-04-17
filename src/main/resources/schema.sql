CREATE TABLE IF NOT EXISTS organizations (
	id          INTEGER NOT NULL                    COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
	name        VARCHAR NOT NULL                    COMMENT 'Краткое название организации',
	inn         VARCHAR(10) NOT NULL                COMMENT 'ИНН организации',
	isActive    BOOLEAN NOT NULL DEFAULT 'FALSE'    COMMENT 'Статус организации: активна/ликвидирована',
	fullName    VARCHAR NOT NULL                    COMMENT 'Полное название организации',
	kpp         VARCHAR(9) NOT NULL                 COMMENT 'КПП организации',
	address     VARCHAR NOT NULL                    COMMENT 'Официальный адрес юридического лица',
	phone       VARCHAR                             COMMENT 'Основной телефон организации' UNIQUE,
	version     INTEGER NOT NULL                    COMMENT 'Служебная метка версионирования таблицы'
);
COMMENT ON TABLE organizations IS 'Список организаций';

CREATE TABLE IF NOT EXISTS offices (
	id          INTEGER NOT NULL                    COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
	name        VARCHAR                             COMMENT 'Краткое наименование офиса',
	phone       VARCHAR                             COMMENT 'Телефон приемной/секретаря' UNIQUE,
	isActive    BOOLEAN NOT NULL                    COMMENT 'Статус офиса: функционирует/упразднен',
	address     VARCHAR NOT NULL                    COMMENT 'Адрес офиса',
	orgId       INTEGER NOT NULL                    COMMENT 'Идентификатор организации, которой принадлежит офис',
	version     INTEGER NOT NULL                    COMMENT 'Служебная метка версионирования таблицы'
);
COMMENT ON TABLE offices IS 'Офисы организации';

CREATE TABLE IF NOT EXISTS users (
	id          INTEGER NOT NULL                    COMMENT 'Уникальный идентификатор сотрудника' PRIMARY KEY AUTO_INCREMENT,
	firstName   VARCHAR NOT NULL                    COMMENT 'Имя сотрудника',
	secondName  VARCHAR NOT NULL                    COMMENT 'Фамилия сотрудника',
	middleName  VARCHAR                             COMMENT 'Отчество сотрудника',
	phone       VARCHAR                             COMMENT 'Рабочий телефон сотрудника' UNIQUE,
	citizenship INTEGER NOT NULL                    COMMENT 'Идентификатор гражданства сотрудника',
	position    INTEGER NOT NULL                    COMMENT 'Идентификатор должности сотрудника',
	version     INTEGER NOT NULL                    COMMENT 'Служебная метка версионирования таблицы'
);
COMMENT ON TABLE users IS 'Сотрудники организации';

CREATE TABLE IF NOT EXISTS user_offices (
	id          INTEGER NOT NULL                    COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
	user_id     INTEGER NOT NULL                    COMMENT 'Уникальный идентификатор сотрудника',
	office_id   INTEGER NOT NULL                    COMMENT 'Уникальный идентификатор офиса',
	primary_office BOOLEAN NOT NULL DEFAULT 'FALSE' COMMENT 'Метка основного офиса сотрудника'
);
COMMENT ON TABLE user_offices IS 'Таблица связи сотрудников и офисов';

CREATE TABLE IF NOT EXISTS user_docs (
	id          INTEGER NOT NULL                    COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
	doc_code    VARCHAR NOT NULL                    COMMENT 'Уникальный идентификатор типа документа',
	doc_number  VARCHAR NOT NULL                    COMMENT 'Номер документа',
	user_id     INTEGER NOT NULL                    COMMENT 'Уникальный идентификатор сотрудника',
	isIdentified BOOLEAN NOT NULL DEFAULT 'FALSE'   COMMENT 'Метка подтвержденного документа',
	doc_date    DATE COMMENT 'Дата выдачи документа'
);
COMMENT ON TABLE user_docs IS 'Документы сотрудника';

CREATE TABLE IF NOT EXISTS documents (
	code        VARCHAR NOT NULL                    COMMENT 'Уникальный код типа документа' PRIMARY KEY,
	name        VARCHAR NOT NULL                    COMMENT 'Русскоязычное название документа'
);
COMMENT ON TABLE documents IS 'Справочников типов документов';

CREATE TABLE IF NOT EXISTS countries (
	code        VARCHAR NOT NULL                    COMMENT 'Уникальный код страны' PRIMARY KEY,
	name        VARCHAR NOT NULL                    COMMENT 'Официальное название страны'
);
COMMENT ON TABLE countries IS 'Справочников стран';

CREATE TABLE IF NOT EXISTS titles (
	id          INTEGER NOT NULL                    COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
	title_name  VARCHAR NOT NULL                    COMMENT 'Название должности'
);
COMMENT ON TABLE titles IS 'Справочников должностей';


CREATE INDEX IX_offices_orgId ON offices (orgId);
ALTER TABLE offices ADD FOREIGN KEY     (orgId)         REFERENCES organizations(id);

ALTER TABLE users ADD FOREIGN KEY       (citizenship)   REFERENCES countries(code);
ALTER TABLE users ADD FOREIGN KEY       (position)      REFERENCES titles(id);
ALTER TABLE user_docs ADD FOREIGN KEY   (doc_code)      REFERENCES documents(name);

CREATE INDEX IX_user_docs_id ON user_docs (user_id);
ALTER TABLE user_docs ADD FOREIGN KEY   (user_id)       REFERENCES users(id);

CREATE INDEX IX_user_offices_userId ON user_offices (user_id);
ALTER TABLE user_offices ADD FOREIGN KEY (user_id)      REFERENCES users(id);

CREATE INDEX IX_user_offices_officeId ON user_offices (office_id);
ALTER TABLE user_offices ADD FOREIGN KEY (office_id)    REFERENCES offices(id);
