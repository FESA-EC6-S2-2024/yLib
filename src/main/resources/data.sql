-- Desabilita integridade referencial
ALTER TABLE TB_USERS SET REFERENTIAL_INTEGRITY FALSE;
ALTER TABLE TB_AUTHORS SET REFERENTIAL_INTEGRITY FALSE;
ALTER TABLE TB_GENRES SET REFERENTIAL_INTEGRITY FALSE;
ALTER TABLE TB_EDITORS SET REFERENTIAL_INTEGRITY FALSE;
ALTER TABLE TB_BOOKS SET REFERENTIAL_INTEGRITY FALSE;
ALTER TABLE TB_LOANS SET REFERENTIAL_INTEGRITY FALSE;

-- Limpa a tabela
TRUNCATE TABLE TB_USERS;
TRUNCATE TABLE TB_AUTHORS;
TRUNCATE TABLE TB_GENRES;
TRUNCATE TABLE TB_EDITORS;
TRUNCATE TABLE TB_BOOKS;
TRUNCATE TABLE TB_LOANS;

ALTER TABLE TB_USERS ALTER COLUMN ID_USER RESTART WITH 1;

-- Habilita integridade referencial
ALTER TABLE TB_USERS SET REFERENTIAL_INTEGRITY TRUE;
ALTER TABLE TB_AUTHORS SET REFERENTIAL_INTEGRITY TRUE;
ALTER TABLE TB_GENRES SET REFERENTIAL_INTEGRITY TRUE;
ALTER TABLE TB_EDITORS SET REFERENTIAL_INTEGRITY TRUE;
ALTER TABLE TB_BOOKS SET REFERENTIAL_INTEGRITY TRUE;
ALTER TABLE TB_LOANS SET REFERENTIAL_INTEGRITY TRUE;

-- Insere usuários (incluindo o admin)
INSERT INTO TB_USER (ID_USER, NAME, EMAIL, REGISTRATION_DATE, PASSWORD, SECRET, USER_TYPE, USER_GENDER, IMAGE, IS_USING_2FA) 
VALUES 
('7fcd4158-771d-41cf-88fd-747b20834055', 'Admin', 'admin@test.com', NOW(), '$2y$10$8k8uewk5xuAS4UNi0tKn6.ZPRJ3PDHbWvz/gnzb/ki33Z1e2D2.om', NULL, 'ADMIN', 'OTHER', NULL, false),
('c09dc99d-81bb-49c6-ac1b-b10be133078a', 'Bob', 'bob@test.com', NOW(), '$2y$10$8k8uewk5xuAS4UNi0tKn6.ZPRJ3PDHbWvz/gnzb/ki33Z1e2D2.om', NULL, 'CLIENT', 'MALE', NULL, false),
('d577810e-a24c-4c3e-8387-87ee5cf9540b', 'Alice', 'alice@test.com', NOW(), '$2y$10$8k8uewk5xuAS4UNi0tKn6.ZPRJ3PDHbWvz/gnzb/ki33Z1e2D2.om', NULL, 'LIBRARIAN', 'FEMALE', NULL, false);
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Alan Garner','USA','2002-08-01',1),
	 ('Aldous Huxley','Mexico','1991-04-13',2),
	 ('Alison Uttley','France','1988-09-04',3),
	 ('Andrew Taylor','China','1975-12-29',4),
	 ('Archibald Lyall','Mexico','1993-02-11',5),
	 ('Arthur Irwin','USA','1993-03-05',6),
	 ('Barbara Gowdy','USA','1974-10-21',7),
	 ('Barns &amp; Budd','Germany','1976-03-13',8),
	 ('Bennett Cerf','Canada','1974-11-29',9),
	 ('Bill Bryson','Canada','1982-03-23',10);
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Bonnie Stern','France','2002-03-14',11),
	 ('Brian Wilks','India','1980-02-19',12),
	 ('C. S. Lewis','China','1970-02-18',13),
	 ('C. V. Wedgwood','China','1978-11-27',14),
	 ('David Attenborough','Mexico','1973-05-24',15),
	 ('David Cohen','Australia','1994-09-17',16),
	 ('David Cruise','Japan','1990-07-21',17),
	 ('David Lambert','France','1970-10-06',18),
	 ('Diane Wilmer','USA','1980-09-14',19),
	 ('Ellen Miller','Japan','1976-02-12',20);
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Ellis Peters','Mexico','1985-04-06',21),
	 ('Ernest G Neal','Brazil','1987-05-26',22),
	 ('Eva Innes','Canada','1975-04-07',23),
	 ('Fiona Pragoff','Brazil','1973-10-01',24),
	 ('Frances Itani','Mexico','1976-07-05',25),
	 ('Fynn','Japan','1991-08-01',26),
	 ('Geoffrey Wansell','France','1978-12-06',27),
	 ('Gerald Seymour','China','1970-11-05',28),
	 ('Harriet Hains','France','1995-03-29',29),
	 ('Helen Forrester','Mexico','1983-09-05',30);
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Huck Scarry','Japan','1990-07-11',31),
	 ('Ian Botham','Canada','1970-11-15',32),
	 ('Ian Ridpath','Germany','1999-01-14',33),
	 ('Ian Whybrow','Japan','1976-01-09',34),
	 ('Ian Wooldridge','India','1989-07-05',35),
	 ('Ian Wright','Mexico','1991-10-02',36),
	 ('J. R. R. Tolkien','Mexico','1979-02-09',37),
	 ('James King','China','1977-11-08',38),
	 ('Jane Goodall','Australia','1979-08-10',39),
	 ('Jean Ure','Germany','1996-06-13',40);
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Jeffrey Simpson','France','1971-10-02',41),
	 ('John D. Altringham','Mexico','1984-01-22',42),
	 ('John Fairley','Brazil','2001-05-22',43),
	 ('John G. Williams','USA','1990-06-03',44),
	 ('John Verney','France','1990-11-23',45),
	 ('John Wilson Murray','China','2004-07-09',46),
	 ('Jonathan Langley','Australia','1990-04-29',47),
	 ('Jung Chang','Australia','1978-04-04',48),
	 ('Kenneth Radu','Australia','1970-08-07',49),
	 ('L. A. Morse','Australia','1987-07-14',50);
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('L. Svensson','Brazil','1972-06-04',51),
	 ('Lawrence Hill','Germany','1973-03-31',52),
	 ('Louis Mountbatten Mountbatten of Burma','Germany','2002-10-22',53),
	 ('Lyn Hancock','India','1977-03-07',54),
	 ('Mandy Stanley','Mexico','1988-03-12',55),
	 ('Margaret Cannon','USA','2000-02-15',56),
	 ('Marilyn Sadler','Australia','1991-09-16',57),
	 ('Mark Brown','India','1990-02-16',58),
	 ('Mark Haddon','Japan','1998-08-15',59),
	 ('Mark Owens','India','1984-08-03',60);
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Martin Gilbert','Germany','1975-10-31',61),
	 ('Maude Barlow','Australia','1972-08-27',62),
	 ('Maureen Spurgeon','China','1996-04-25',63),
	 ('Merren Parker','Mexico','1994-07-29',64),
	 ('Michael Bond','India','1988-02-16',65),
	 ('Michael Dibdin','India','2001-03-28',66),
	 ('Michael E. N. Majerus','India','1985-11-23',67),
	 ('Mikhail Sergeevich Gorbachev','Australia','1977-01-18',68),
	 ('Muriel Spark','Japan','2000-12-05',69),
	 ('Nanette Newman','Australia','1995-10-10',70);
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Nick Butterworth','India','1995-11-04',71),
	 ('Nigel Mansell','Germany','1984-03-23',72),
	 ('Nigel Webb','China','1970-06-18',73),
	 ('Noel Streatfeild','Japan','1978-12-27',74),
	 ('Oliver Gilbert','Mexico','1984-08-25',75),
	 ('P. L Travers','Canada','1970-10-07',76),
	 ('Penina Spiegel','China','2001-04-16',77),
	 ('Peter Hayward','Canada','2001-07-07',78),
	 ('Richard Bell','Germany','1992-06-03',79),
	 ('Richard Bruce Wright','Canada','1972-01-05',80);
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Richard Sidney Richmond Fitter','Japan','1991-03-24',81),
	 ('Rick Smolan','Canada','1992-07-09',82),
	 ('Robert Leeson','Japan','1990-04-08',83),
	 ('Robert Lopshire','Canada','1992-11-12',84),
	 ('Roger Lancelyn Green','Australia','1985-02-11',85),
	 ('Roger Tory Peterson','France','2002-05-17',86),
	 ('Roseanne Barr','Mexico','1974-04-28',87),
	 ('Rosie Swale','Japan','2004-04-15',88),
	 ('Sandra Gwyn','Brazil','1970-06-07',89),
	 ('Sheila Cassidy','Canada','1996-03-08',90);
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Simon Schama','USA','2001-12-18',91),
	 ('Simon Welfare','USA','1974-10-15',92),
	 ('Stan Berenstein','Mexico','1981-04-30',93),
	 ('Stephen Fry','India','1987-03-22',94),
	 ('Stephen Potter','Mexico','2001-11-27',95),
	 ('Sue Dreamer','USA','1976-07-31',96),
	 ('T.S. Eliot','Canada','2001-12-22',97),
	 ('Timothy Findley','USA','2002-10-22',98),
	 ('Tom Harrisson','France','1990-09-29',99),
	 ('Trevor Beebee','France','1994-10-03',100);

INSERT INTO TB_GENRES (ID_GENRE, DESCRIPTION)
VALUES
    (1, 'Science Fiction'),
    (2, 'Fantasy'),
    (3, 'Mystery'),
    (4, 'Romance'),
    (5, 'Thriller'),
    (6, 'Historical Fiction'),
    (7, 'Non-Fiction'),
    (8, 'Biography'),
    (9, 'Horror'),
    (10, 'Young Adult');

INSERT INTO TB_EDITORS (ID_EDITOR,NAME) VALUES
	 (1,'Atlantic'),
	 (2,'BBC Books'),
	 (3,'Collins'),
	 (4,'Collins Pub San Francisco'),
	 (5,'Harper Collins'),
	 (6,'Harper Collins Canada'),
	 (7,'Harpercollins Publisher'),
	 (8,'HarperCollins Publishers'),
	 (9,'Harpercollins Uk'),
	 (10,'HarperCollinsPublishers'),
	 (11,'HarperFlamingo Canada'),
	 (12,'Trafalgar Square Publishing');

INSERT INTO TB_BOOKS (ISBN,TITLE,ID_AUTHOR,PUBLISHED_YEAR,ID_EDITOR,IMAGE,ID_GENRE,AVAILABLE_UNITS,TOTAL_UNITS,SYNOPSIS,ID_BOOK) VALUES
	 (N'0002005018',N'Clara Callan',N'80',2001,N'11',N'http://images.amazon.com/images/P/0002005018.01.LZZZZZZZ.jpg',4,14,94,N'Lorem ipsum dolor sit amet',1),
	 (N'0002160595',N'C. S. Lewis: A biography',N'85',1974,N'3',N'http://images.amazon.com/images/P/0002160595.01.LZZZZZZZ.jpg',2,81,84,N'Lorem ipsum dolor sit amet',2),
	 (N'0001374869',N'Baby Plays (Collins Baby and Toddler Series)',N'24',1994,N'8',N'http://images.amazon.com/images/P/0001374869.01.LZZZZZZZ.jpg',10,32,66,N'Lorem ipsum dolor sit amet',3),
	 (N'0001048082',N'Made in America',N'10',1995,N'8',N'http://images.amazon.com/images/P/0001048082.01.LZZZZZZZ.jpg',2,54,73,N'Lorem ipsum dolor sit amet',4),
	 (N'0002159767',N'China Tide',N'56',0,N'7',N'http://images.amazon.com/images/P/0002159767.01.LZZZZZZZ.jpg',10,13,78,N'Lorem ipsum dolor sit amet',5),
	 (N'0002165368',N'Arthur C. Clarke''s mysterious world',N'92',1980,N'3',N'http://images.amazon.com/images/P/0002165368.01.LZZZZZZZ.jpg',9,60,9,N'Lorem ipsum dolor sit amet',6),
	 (N'0002198274',N'The first Eden: The Mediterranean world and man',N'15',1987,N'2',N'http://images.amazon.com/images/P/0002198274.01.LZZZZZZZ.jpg',7,23,87,N'Lorem ipsum dolor sit amet',7),
	 (N'0001372564',N'Which Colour?',N'96',1989,N'8',N'http://images.amazon.com/images/P/0001372564.01.LZZZZZZZ.jpg',8,12,43,N'Lorem ipsum dolor sit amet',8),
	 (N'0002116286',N'There''s A Seal in my Sleeping Bag',N'54',1992,N'6',N'http://images.amazon.com/images/P/0002116286.01.LZZZZZZZ.jpg',4,8,79,N'Lorem ipsum dolor sit amet',9),
	 (N'0001382608',N'On the Road',N'31',1981,N'8',N'http://images.amazon.com/images/P/0001382608.01.LZZZZZZZ.jpg',9,12,92,N'Lorem ipsum dolor sit amet',10),
	 (N'000104799X',N'Monk''s-hood',N'21',1994,N'8',N'http://images.amazon.com/images/P/000104799X.01.LZZZZZZZ.jpg',4,34,41,N'Lorem ipsum dolor sit amet',11),
	 (N'000171421X',N'It''s Not Easy Being a Bunny (A Beginner Book)',N'57',1984,N'8',N'http://images.amazon.com/images/P/000171421X.01.LZZZZZZZ.jpg',3,25,45,N'Lorem ipsum dolor sit amet',12),
	 (N'0001842749',N'The Growing Summer',N'74',1984,N'8',N'http://images.amazon.com/images/P/0001842749.01.LZZZZZZZ.jpg',8,6,80,N'Lorem ipsum dolor sit amet',13),
	 (N'0001714600',N'I Want to Be Somebody New! (I Can Read It All by Myself)',N'84',1986,N'8',N'http://images.amazon.com/images/P/0001714600.01.LZZZZZZZ.jpg',4,33,80,N'Lorem ipsum dolor sit amet',14),
	 (N'0001047213',N'The Fighting Man',N'28',1993,N'8',N'http://images.amazon.com/images/P/0001047213.01.LZZZZZZZ.jpg',1,24,27,N'Lorem ipsum dolor sit amet',15),
	 (N'0001048473',N'Nothing Can Be Better',N'8',1996,N'1',N'http://images.amazon.com/images/P/0001048473.01.LZZZZZZZ.jpg',4,1,80,N'Lorem ipsum dolor sit amet',16),
	 (N'0001046438',N'Liar',N'94',0,N'9',N'http://images.amazon.com/images/P/0001046438.01.LZZZZZZZ.jpg',9,53,58,N'Lorem ipsum dolor sit amet',17),
	 (N'0002153572',N'Wild swans: Three daughters of China',N'48',1991,N'5',N'http://images.amazon.com/images/P/0002153572.01.LZZZZZZZ.jpg',8,36,64,N'Lorem ipsum dolor sit amet',18),
	 (N'0001714236',N'Spooky Riddles',N'58',1984,N'8',N'http://images.amazon.com/images/P/0001714236.01.LZZZZZZZ.jpg',2,7,67,N'Lorem ipsum dolor sit amet',19),
	 (N'0002166828',N'Memoirs of a great Canadian detective: Incidents in the life of John Wilson Murray',N'46',1977,N'3',N'http://images.amazon.com/images/P/0002166828.01.LZZZZZZZ.jpg',3,8,35,N'Lorem ipsum dolor sit amet',20),
	 (N'0002005050',N'The Romantic',N'7',2003,N'11',N'http://images.amazon.com/images/P/0002005050.01.LZZZZZZZ.jpg',9,10,73,N'Lorem ipsum dolor sit amet',21),
	 (N'0002176084',N'The diaries of Lord Louis Mountbatten, 1920-1922: Tours with the Prince of Wales',N'53',1987,N'3',N'http://images.amazon.com/images/P/0002176084.01.LZZZZZZZ.jpg',4,59,80,N'Lorem ipsum dolor sit amet',22),
	 (N'0002174154',N'Back to Cape Horn',N'88',1986,N'3',N'http://images.amazon.com/images/P/0002174154.01.LZZZZZZZ.jpg',2,56,99,N'Lorem ipsum dolor sit amet',23),
	 (N'0002158973',N'Landscape and Memory',N'91',0,N'7',N'http://images.amazon.com/images/P/0002158973.01.LZZZZZZZ.jpg',2,62,9,N'Lorem ipsum dolor sit amet',24),
	 (N'0001711105',N'The Book of Riddles (Beginner Books)',N'9',1983,N'8',N'http://images.amazon.com/images/P/0001711105.01.LZZZZZZZ.jpg',4,6,23,N'Lorem ipsum dolor sit amet',25),
	 (N'0002169290',N'For Goodness Sake',N'64',0,N'7',N'http://images.amazon.com/images/P/0002169290.01.LZZZZZZZ.jpg',3,57,78,N'Lorem ipsum dolor sit amet',26),
	 (N'000217622X',N'STEVE MCQUEEN',N'77',1986,N'8',N'http://images.amazon.com/images/P/000217622X.01.LZZZZZZZ.jpg',3,18,63,N'Lorem ipsum dolor sit amet',27),
	 (N'0001360469',N'Babe Dressing',N'55',1997,N'8',N'http://images.amazon.com/images/P/0001360469.01.LZZZZZZZ.jpg',2,1,70,N'Lorem ipsum dolor sit amet',28),
	 (N'0001047973',N'Brave New World',N'2',1999,N'12',N'http://images.amazon.com/images/P/0001047973.01.LZZZZZZZ.jpg',4,64,94,N'Lorem ipsum dolor sit amet',29),
	 (N'0002005395',N'Deafening',N'25',2003,N'11',N'http://images.amazon.com/images/P/0002005395.01.LZZZZZZZ.jpg',5,48,40,N'Lorem ipsum dolor sit amet',30),
	 (N'0002179687',N'Christmas in America: Images of the Holiday Season by 100 of America''s Leading Photographers',N'16',1988,N'4',N'http://images.amazon.com/images/P/0002179687.01.LZZZZZZZ.jpg',9,3,73,N'Lorem ipsum dolor sit amet',31),
	 (N'0002156970',N'Inside memory: Pages from a writer''s workbook',N'98',1990,N'10',N'http://images.amazon.com/images/P/0002156970.01.LZZZZZZZ.jpg',1,15,42,N'Lorem ipsum dolor sit amet',32),
	 (N'0001939203',N'The Collins Book of Nursery Tales',N'47',1993,N'8',N'http://images.amazon.com/images/P/0001939203.01.LZZZZZZZ.jpg',7,24,87,N'Lorem ipsum dolor sit amet',33),
	 (N'0002163713',N'Cary Grant, haunted idol',N'27',1983,N'3',N'http://images.amazon.com/images/P/0002163713.01.LZZZZZZZ.jpg',8,12,68,N'Lorem ipsum dolor sit amet',34),
	 (N'000104687X',N'T.S. Eliot Reading The Wasteland" and Other Poems"',N'97',1993,N'8',N'http://images.amazon.com/images/P/000104687X.01.LZZZZZZZ.jpg',2,1,27,N'Lorem ipsum dolor sit amet',35),
	 (N'0001382381',N'Huck Scarry''s Steam Train Journey',N'31',1979,N'8',N'http://images.amazon.com/images/P/0001382381.01.LZZZZZZZ.jpg',6,12,35,N'Lorem ipsum dolor sit amet',36),
	 (N'0002006588',N'Vancouver',N'17',2003,N'11',N'http://images.amazon.com/images/P/0002006588.01.LZZZZZZZ.jpg',10,40,65,N'Lorem ipsum dolor sit amet',37);

ALTER TABLE TB_LOANS SET REFERENTIAL_INTEGRITY FALSE;
INSERT INTO TB_LOANS(STATUS, DUE_DATE, RETURN_DATE, LOAN_DATE, ID_USER, ID_BOOK) VALUES (0, DATEADD('DAY',7, CURRENT_DATE), null, now(), 2, 1);

