-- Desabilita integridade referencial
ALTER TABLE TB_USER SET REFERENTIAL_INTEGRITY FALSE;

-- Limpa a tabela
TRUNCATE TABLE TB_USER;

-- Habilita integridade referencial
ALTER TABLE TB_USER SET REFERENTIAL_INTEGRITY TRUE;

-- Insere usuários (incluindo o admin)
INSERT INTO TB_USER (NAME, EMAIL, REGISTRATION_DATE, PASSWORD, SECRET, USER_TYPE, USER_GENDER, IMAGE, IS_USING_2FA) 
VALUES 
('Admin', 'admin@test.com', NOW(), '$2y$10$8k8uewk5xuAS4UNi0tKn6.ZPRJ3PDHbWvz/gnzb/ki33Z1e2D2.om', NULL, 'ADMIN', 'OTHER', NULL, false),
('Bob', 'bob@test.com', NOW(), '$2y$10$8k8uewk5xuAS4UNi0tKn6.ZPRJ3PDHbWvz/gnzb/ki33Z1e2D2.om', NULL, 'CLIENT', 'MALE', NULL, false),
('Alice', 'alice@test.com', NOW(), '$2b$12$ieYk9tpZA45fd/tnosOeZ.t3zkVkNrXwm2ehNyr6QU0Afck73J9Sy', NULL, 'LIBRARIAN', 'FEMALE', NULL, false);

