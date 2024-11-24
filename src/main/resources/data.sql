-- Desabilita integridade referencial
ALTER TABLE TB_USER SET REFERENTIAL_INTEGRITY FALSE;

-- Limpa a tabela
TRUNCATE TABLE TB_USER;

-- Habilita integridade referencial
ALTER TABLE TB_USER SET REFERENTIAL_INTEGRITY TRUE;

-- Insere usuários (incluindo o admin)
INSERT INTO TB_USER (ID_USER, NAME, EMAIL, REGISTRATION_DATE, PASSWORD, SECRET, USER_TYPE, USER_GENDER, IMAGE, IS_USING_2FA) 
VALUES 
('7fcd4158-771d-41cf-88fd-747b20834055', 'Admin', 'admin@test.com', NOW(), '$2y$10$8k8uewk5xuAS4UNi0tKn6.ZPRJ3PDHbWvz/gnzb/ki33Z1e2D2.om', NULL, 'ADMIN', 'OTHER', NULL, false),
('c09dc99d-81bb-49c6-ac1b-b10be133078a', 'Bob', 'bob@test.com', NOW(), '$2y$10$8k8uewk5xuAS4UNi0tKn6.ZPRJ3PDHbWvz/gnzb/ki33Z1e2D2.om', NULL, 'CLIENT', 'MALE', NULL, false),
('d577810e-a24c-4c3e-8387-87ee5cf9540b', 'Alice', 'alice@test.com', NOW(), '$2y$10$8k8uewk5xuAS4UNi0tKn6.ZPRJ3PDHbWvz/gnzb/ki33Z1e2D2.om', NULL, 'LIBRARIAN', 'FEMALE', NULL, false);

