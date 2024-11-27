-- Desabilita integridade referencial
ALTER TABLE TB_USERS SET REFERENTIAL_INTEGRITY   FALSE;
ALTER TABLE TB_AUTHORS SET REFERENTIAL_INTEGRITY FALSE;
ALTER TABLE TB_GENRES SET REFERENTIAL_INTEGRITY  FALSE;
ALTER TABLE TB_EDITORS SET REFERENTIAL_INTEGRITY FALSE;
ALTER TABLE TB_BOOKS SET REFERENTIAL_INTEGRITY   FALSE;
ALTER TABLE TB_LOANS SET REFERENTIAL_INTEGRITY   FALSE;

-- Limpa a tabela
TRUNCATE TABLE TB_USERS;
TRUNCATE TABLE TB_AUTHORS;
TRUNCATE TABLE TB_GENRES;
TRUNCATE TABLE TB_EDITORS;
TRUNCATE TABLE TB_BOOKS;
TRUNCATE TABLE TB_LOANS;

-- Habilita integridade referencial
ALTER TABLE TB_USERS SET REFERENTIAL_INTEGRITY   TRUE;
ALTER TABLE TB_AUTHORS SET REFERENTIAL_INTEGRITY TRUE;
ALTER TABLE TB_GENRES SET REFERENTIAL_INTEGRITY  TRUE;
ALTER TABLE TB_EDITORS SET REFERENTIAL_INTEGRITY TRUE;
ALTER TABLE TB_BOOKS SET REFERENTIAL_INTEGRITY   TRUE;
ALTER TABLE TB_LOANS SET REFERENTIAL_INTEGRITY   TRUE;

-- Insere usuários (incluindo o admin)
INSERT INTO TB_USERS (ID_USER,NAME,EMAIL,REGISTRATION_DATE,PASSWORD,SECRET,USER_TYPE,USER_GENDER,IMAGE,IS_USING_2FA) VALUES 
	('624cd788-b328-444c-b741-a0e21e7e5459', 'Admin', 'admin@test.com', NOW(), '$2y$10$8k8uewk5xuAS4UNi0tKn6.ZPRJ3PDHbWvz/gnzb/ki33Z1e2D2.om', NULL, 'ADMIN', 'OTHER', NULL, false),
	('624cd788-b328-444c-b741-a0e21e7e5460', 'Bob', 'bob@test.com', NOW(), '$2y$10$8k8uewk5xuAS4UNi0tKn6.ZPRJ3PDHbWvz/gnzb/ki33Z1e2D2.om', NULL, 'CLIENT', 'MALE', NULL, false),
	('624cd788-b328-444c-b741-a0e21e7e5461','Alice', 'alice@test.com', NOW(), '$2y$10$8k8uewk5xuAS4UNi0tKn6.ZPRJ3PDHbWvz/gnzb/ki33Z1e2D2.om', NULL, 'LIBRARIAN', 'FEMALE', NULL, false);
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Alan Garner','USA','2002-08-01','624cd788-b328-444c-b741-a0e21e7e5257'),
	 ('Aldous Huxley','Mexico','1991-04-13','624cd788-b328-444c-b741-a0e21e7e5256'),
	 ('Alison Uttley','France','1988-09-04','624cd788-b328-444c-b741-a0e21e7e5255'),
	 ('Andrew Taylor','China','1975-12-29','624cd788-b328-444c-b741-a0e21e7e5254'),
	 ('Archibald Lyall','Mexico','1993-02-11','624cd788-b328-444c-b741-a0e21e7e5253'),
	 ('Arthur Irwin','USA','1993-03-05','624cd788-b328-444c-b741-a0e21e7e5252'),
	 ('Barbara Gowdy','USA','1974-10-21','624cd788-b328-444c-b741-a0e21e7e5251'),
	 ('Barns &amp; Budd','Germany','1976-03-13','624cd788-b328-444c-b741-a0e21e7e5250'),
	 ('Bennett Cerf','Canada','1974-11-29','624cd788-b328-444c-b741-a0e21e7e5249'),
	 ('Bill Bryson','Canada','1982-03-23','624cd788-b328-444c-b741-a0e21e7e5248');
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Bonnie Stern','France','2002-03-14','624cd788-b328-444c-b741-a0e21e7e5247'),
	 ('Brian Wilks','India','1980-02-19','624cd788-b328-444c-b741-a0e21e7e5246'),
	 ('C. S. Lewis','China','1970-02-18','624cd788-b328-444c-b741-a0e21e7e5245'),
	 ('C. V. Wedgwood','China','1978-11-27','624cd788-b328-444c-b741-a0e21e7e5244'),
	 ('David Attenborough','Mexico','1973-05-24','624cd788-b328-444c-b741-a0e21e7e5243'),
	 ('David Cohen','Australia','1994-09-17','624cd788-b328-444c-b741-a0e21e7e5242'),
	 ('David Cruise','Japan','1990-07-21','624cd788-b328-444c-b741-a0e21e7e5241'),
	 ('David Lambert','France','1970-10-06','624cd788-b328-444c-b741-a0e21e7e5240'),
	 ('Diane Wilmer','USA','1980-09-14','624cd788-b328-444c-b741-a0e21e7e5239'),
	 ('Ellen Miller','Japan','1976-02-12','624cd788-b328-444c-b741-a0e21e7e5238');
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Ellis Peters','Mexico','1985-04-06','624cd788-b328-444c-b741-a0e21e7e5237'),
	 ('Ernest G Neal','Brazil','1987-05-26','624cd788-b328-444c-b741-a0e21e7e5236'),
	 ('Eva Innes','Canada','1975-04-07','624cd788-b328-444c-b741-a0e21e7e5235'),
	 ('Fiona Pragoff','Brazil','1973-10-01','624cd788-b328-444c-b741-a0e21e7e5234'),
	 ('Frances Itani','Mexico','1976-07-05','624cd788-b328-444c-b741-a0e21e7e5233'),
	 ('Fynn','Japan','1991-08-01','624cd788-b328-444c-b741-a0e21e7e5232'),
	 ('Geoffrey Wansell','France','1978-12-06','624cd788-b328-444c-b741-a0e21e7e5231'),
	 ('Gerald Seymour','China','1970-11-05','624cd788-b328-444c-b741-a0e21e7e5230'),
	 ('Harriet Hains','France','1995-03-29','624cd788-b328-444c-b741-a0e21e7e5229'),
	 ('Helen Forrester','Mexico','1983-09-05','624cd788-b328-444c-b741-a0e21e7e5228');
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Huck Scarry','Japan','1990-07-11','624cd788-b328-444c-b741-a0e21e7e5227'),
	 ('Ian Botham','Canada','1970-11-15','624cd788-b328-444c-b741-a0e21e7e5226'),
	 ('Ian Ridpath','Germany','1999-01-14','624cd788-b328-444c-b741-a0e21e7e5225'),
	 ('Ian Whybrow','Japan','1976-01-09','624cd788-b328-444c-b741-a0e21e7e5224'),
	 ('Ian Wooldridge','India','1989-07-05','624cd788-b328-444c-b741-a0e21e7e5223'),
	 ('Ian Wright','Mexico','1991-10-02','624cd788-b328-444c-b741-a0e21e7e5222'),
	 ('J. R. R. Tolkien','Mexico','1979-02-09','624cd788-b328-444c-b741-a0e21e7e5221'),
	 ('James King','China','1977-11-08','624cd788-b328-444c-b741-a0e21e7e5220'),
	 ('Jane Goodall','Australia','1979-08-10','624cd788-b328-444c-b741-a0e21e7e5219'),
	 ('Jean Ure','Germany','1996-06-13','624cd788-b328-444c-b741-a0e21e7e5218');
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Jeffrey Simpson','France','1971-10-02','624cd788-b328-444c-b741-a0e21e7e5217'),
	 ('John D. Altringham','Mexico','1984-01-22','624cd788-b328-444c-b741-a0e21e7e5216'),
	 ('John Fairley','Brazil','2001-05-22','624cd788-b328-444c-b741-a0e21e7e5215'),
	 ('John G. Williams','USA','1990-06-03','624cd788-b328-444c-b741-a0e21e7e5214'),
	 ('John Verney','France','1990-11-23','624cd788-b328-444c-b741-a0e21e7e5213'),
	 ('John Wilson Murray','China','2004-07-09','624cd788-b328-444c-b741-a0e21e7e5212'),
	 ('Jonathan Langley','Australia','1990-04-29','624cd788-b328-444c-b741-a0e21e7e5211'),
	 ('Jung Chang','Australia','1978-04-04','624cd788-b328-444c-b741-a0e21e7e5210'),
	 ('Kenneth Radu','Australia','1970-08-07','624cd788-b328-444c-b741-a0e21e7e5209'),
	 ('L. A. Morse','Australia','1987-07-14','624cd788-b328-444c-b741-a0e21e7e5208');
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('L. Svensson','Brazil','1972-06-04','624cd788-b328-444c-b741-a0e21e7e5207'),
	 ('Lawrence Hill','Germany','1973-03-31','624cd788-b328-444c-b741-a0e21e7e5206'),
	 ('Louis Mountbatten Mountbatten of Burma','Germany','2002-10-22','624cd788-b328-444c-b741-a0e21e7e5205'),
	 ('Lyn Hancock','India','1977-03-07','624cd788-b328-444c-b741-a0e21e7e5204'),
	 ('Mandy Stanley','Mexico','1988-03-12','624cd788-b328-444c-b741-a0e21e7e5203'),
	 ('Margaret Cannon','USA','2000-02-15','624cd788-b328-444c-b741-a0e21e7e5202'),
	 ('Marilyn Sadler','Australia','1991-09-16','624cd788-b328-444c-b741-a0e21e7e5201'),
	 ('Mark Brown','India','1990-02-16','624cd788-b328-444c-b741-a0e21e7e5200'),
	 ('Mark Haddon','Japan','1998-08-15','624cd788-b328-444c-b741-a0e21e7e5199'),
	 ('Mark Owens','India','1984-08-03','624cd788-b328-444c-b741-a0e21e7e5198');
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Martin Gilbert','Germany','1975-10-31','624cd788-b328-444c-b741-a0e21e7e5197'),
	 ('Maude Barlow','Australia','1972-08-27','624cd788-b328-444c-b741-a0e21e7e5196'),
	 ('Maureen Spurgeon','China','1996-04-25','624cd788-b328-444c-b741-a0e21e7e5195'),
	 ('Merren Parker','Mexico','1994-07-29','624cd788-b328-444c-b741-a0e21e7e5194'),
	 ('Michael Bond','India','1988-02-16','624cd788-b328-444c-b741-a0e21e7e5193'),
	 ('Michael Dibdin','India','2001-03-28','624cd788-b328-444c-b741-a0e21e7e5192'),
	 ('Michael E. N. Majerus','India','1985-11-23','624cd788-b328-444c-b741-a0e21e7e5191'),
	 ('Mikhail Sergeevich Gorbachev','Australia','1977-01-18','624cd788-b328-444c-b741-a0e21e7e5190'),
	 ('Muriel Spark','Japan','2000-12-05','624cd788-b328-444c-b741-a0e21e7e5189'),
	 ('Nanette Newman','Australia','1995-10-10','624cd788-b328-444c-b741-a0e21e7e5188');
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Nick Butterworth','India','1995-11-04','624cd788-b328-444c-b741-a0e21e7e5187'),
	 ('Nigel Mansell','Germany','1984-03-23','624cd788-b328-444c-b741-a0e21e7e5186'),
	 ('Nigel Webb','China','1970-06-18','624cd788-b328-444c-b741-a0e21e7e5185'),
	 ('Noel Streatfeild','Japan','1978-12-27','624cd788-b328-444c-b741-a0e21e7e5184'),
	 ('Oliver Gilbert','Mexico','1984-08-25','624cd788-b328-444c-b741-a0e21e7e5183'),
	 ('P. L Travers','Canada','1970-10-07','624cd788-b328-444c-b741-a0e21e7e5182'),
	 ('Penina Spiegel','China','2001-04-16','624cd788-b328-444c-b741-a0e21e7e5181'),
	 ('Peter Hayward','Canada','2001-07-07','624cd788-b328-444c-b741-a0e21e7e5180'),
	 ('Richard Bell','Germany','1992-06-03','624cd788-b328-444c-b741-a0e21e7e5179'),
	 ('Richard Bruce Wright','Canada','1972-01-05','624cd788-b328-444c-b741-a0e21e7e5178');
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Richard Sidney Richmond Fitter','Japan','1991-03-24','624cd788-b328-444c-b741-a0e21e7e5177'),
	 ('Rick Smolan','Canada','1992-07-09','624cd788-b328-444c-b741-a0e21e7e5176'),
	 ('Robert Leeson','Japan','1990-04-08','624cd788-b328-444c-b741-a0e21e7e5175'),
	 ('Robert Lopshire','Canada','1992-11-12','624cd788-b328-444c-b741-a0e21e7e5174'),
	 ('Roger Lancelyn Green','Australia','1985-02-11','624cd788-b328-444c-b741-a0e21e7e5173'),
	 ('Roger Tory Peterson','France','2002-05-17','624cd788-b328-444c-b741-a0e21e7e5172'),
	 ('Roseanne Barr','Mexico','1974-04-28','624cd788-b328-444c-b741-a0e21e7e5171'),
	 ('Rosie Swale','Japan','2004-04-15','624cd788-b328-444c-b741-a0e21e7e5170'),
	 ('Sandra Gwyn','Brazil','1970-06-07','624cd788-b328-444c-b741-a0e21e7e5169'),
	 ('Sheila Cassidy','Canada','1996-03-08','624cd788-b328-444c-b741-a0e21e7e5168');
INSERT INTO TB_AUTHORS (NAME,COUNTRY,BIRTH_DATE,ID_AUTHOR) VALUES
	 ('Simon Schama','USA','2001-12-18','624cd788-b328-444c-b741-a0e21e7e5167'),
	 ('Simon Welfare','USA','1974-10-15','624cd788-b328-444c-b741-a0e21e7e5166'),
	 ('Stan Berenstein','Mexico','1981-04-30','624cd788-b328-444c-b741-a0e21e7e5165'),
	 ('Stephen Fry','India','1987-03-22','624cd788-b328-444c-b741-a0e21e7e5164'),
	 ('Stephen Potter','Mexico','2001-11-27','624cd788-b328-444c-b741-a0e21e7e5163'),
	 ('Sue Dreamer','USA','1976-07-31','624cd788-b328-444c-b741-a0e21e7e5162'),
	 ('T.S. Eliot','Canada','2001-12-22','624cd788-b328-444c-b741-a0e21e7e5161'),
	 ('Timothy Findley','USA','2002-10-22','624cd788-b328-444c-b741-a0e21e7e5160'),
	 ('Tom Harrisson','France','1990-09-29','624cd788-b328-444c-b741-a0e21e7e5159'),
	 ('Trevor Beebee','France','1994-10-03','624cd788-b328-444c-b741-a0e21e7e5158');

INSERT INTO TB_GENRES (ID_GENRE, DESCRIPTION)
VALUES
    ('624cd788-b328-444c-b741-a0e21e7e5157', 'Science Fiction'),
    ('624cd788-b328-444c-b741-a0e21e7e5156', 'Fantasy'),
    ('624cd788-b328-444c-b741-a0e21e7e5155', 'Mystery'),
    ('624cd788-b328-444c-b741-a0e21e7e5154', 'Romance'),
    ('624cd788-b328-444c-b741-a0e21e7e5153', 'Thriller'),
    ('624cd788-b328-444c-b741-a0e21e7e5152', 'Historical Fiction'),
    ('624cd788-b328-444c-b741-a0e21e7e5151', 'Non-Fiction'),
    ('624cd788-b328-444c-b741-a0e21e7e5150', 'Biography'),
    ('624cd788-b328-444c-b741-a0e21e7e5149', 'Horror'),
    ('624cd788-b328-444c-b741-a0e21e7e5148', 'Young Adult');

INSERT INTO TB_EDITORS (ID_EDITOR,NAME) VALUES
	 ('624cd788-b328-444c-b741-a0e21e7e5147','Atlantic'),
	 ('624cd788-b328-444c-b741-a0e21e7e5146','BBC Books'),
	 ('624cd788-b328-444c-b741-a0e21e7e5145','Collins'),
	 ('624cd788-b328-444c-b741-a0e21e7e5144','Collins Pub San Francisco'),
	 ('624cd788-b328-444c-b741-a0e21e7e5143','Harper Collins'),
	 ('624cd788-b328-444c-b741-a0e21e7e5142','Harper Collins Canada'),
	 ('624cd788-b328-444c-b741-a0e21e7e5141','Harpercollins Publisher'),
	 ('624cd788-b328-444c-b741-a0e21e7e5140','HarperCollins Publishers'),
	 ('624cd788-b328-444c-b741-a0e21e7e5139','Harpercollins Uk'),
	 ('624cd788-b328-444c-b741-a0e21e7e5138','HarperCollinsPublishers'),
	 ('624cd788-b328-444c-b741-a0e21e7e5137','HarperFlamingo Canada'),
	 ('624cd788-b328-444c-b741-a0e21e7e5136','Trafalgar Square Publishing');

INSERT INTO TB_BOOKS (ISBN,TITLE,ID_AUTHOR,PUBLISHED_YEAR,ID_EDITOR,IMAGE,ID_GENRE,AVAILABLE_UNITS,TOTAL_UNITS,SYNOPSIS,ID_BOOK) VALUES
	 (N'0002005018',N'Clara Callan','624cd788-b328-444c-b741-a0e21e7e5178',2001,'624cd788-b328-444c-b741-a0e21e7e5147',N'http://images.amazon.com/images/P/0002005018.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5154',94,94,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5135'),
	 (N'0002160595',N'C. S. Lewis: A biography','624cd788-b328-444c-b741-a0e21e7e5173',1974,'624cd788-b328-444c-b741-a0e21e7e5145',N'http://images.amazon.com/images/P/0002160595.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5156',84,84,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5134'),
	 (N'0001374869',N'Baby Plays (Collins Baby and Toddler Series)','624cd788-b328-444c-b741-a0e21e7e5234',1994,'624cd788-b328-444c-b741-a0e21e7e5140',N'http://images.amazon.com/images/P/0001374869.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5148',65,66,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5133'),
	 (N'0001048082',N'Made in America','624cd788-b328-444c-b741-a0e21e7e5248',1995,'624cd788-b328-444c-b741-a0e21e7e5140',N'http://images.amazon.com/images/P/0001048082.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5156',73,73,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5132'),
	 (N'0002159767',N'China Tide','624cd788-b328-444c-b741-a0e21e7e5202',0,'624cd788-b328-444c-b741-a0e21e7e5141',N'http://images.amazon.com/images/P/0002159767.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5148',78,78,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5131'),
	 (N'0002165368',N'Arthur C. Clarke''s mysterious world','624cd788-b328-444c-b741-a0e21e7e5166',1980,'624cd788-b328-444c-b741-a0e21e7e5145',N'http://images.amazon.com/images/P/0002165368.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5149',9,9,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5130'),
	 (N'0002198274',N'The first Eden: The Mediterranean world and man','624cd788-b328-444c-b741-a0e21e7e5243',1987,'624cd788-b328-444c-b741-a0e21e7e5146',N'http://images.amazon.com/images/P/0002198274.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5151',87,87,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5129'),
	 (N'0001372564',N'Which Colour?','624cd788-b328-444c-b741-a0e21e7e5162',1989,'624cd788-b328-444c-b741-a0e21e7e5140',N'http://images.amazon.com/images/P/0001372564.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5150',43,43,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5128'),
	 (N'0002116286',N'There''s A Seal in my Sleeping Bag','624cd788-b328-444c-b741-a0e21e7e5204',1992,'624cd788-b328-444c-b741-a0e21e7e5142',N'http://images.amazon.com/images/P/0002116286.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5154',79,79,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5127'),
	 (N'0001382608',N'On the Road','624cd788-b328-444c-b741-a0e21e7e5227',1981,'624cd788-b328-444c-b741-a0e21e7e5140',N'http://images.amazon.com/images/P/0001382608.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5149',92,92,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5126'),
	 (N'000104799X',N'Monk''s-hood','624cd788-b328-444c-b741-a0e21e7e5237',1994,'624cd788-b328-444c-b741-a0e21e7e5140',N'http://images.amazon.com/images/P/000104799X.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5154',41,41,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5125'),
	 (N'000171421X',N'It''s Not Easy Being a Bunny (A Beginner Book)','624cd788-b328-444c-b741-a0e21e7e5201',1984,'624cd788-b328-444c-b741-a0e21e7e5140',N'http://images.amazon.com/images/P/000171421X.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5155',45,45,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5124'),
	 (N'0001842749',N'The Growing Summer','624cd788-b328-444c-b741-a0e21e7e5184',1984,'624cd788-b328-444c-b741-a0e21e7e5140',N'http://images.amazon.com/images/P/0001842749.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5150',80,80,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5123'),
	 (N'0001714600',N'I Want to Be Somebody New! (I Can Read It All by Myself)','624cd788-b328-444c-b741-a0e21e7e5174',1986,'624cd788-b328-444c-b741-a0e21e7e5140',N'http://images.amazon.com/images/P/0001714600.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5154',80,80,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5122'),
	 (N'0001047213',N'The Fighting Man','624cd788-b328-444c-b741-a0e21e7e5230',1993,'624cd788-b328-444c-b741-a0e21e7e5140',N'http://images.amazon.com/images/P/0001047213.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5157',27,27,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5121'),
	 (N'0001048473',N'Nothing Can Be Better','624cd788-b328-444c-b741-a0e21e7e5250',1996,'624cd788-b328-444c-b741-a0e21e7e5147',N'http://images.amazon.com/images/P/0001048473.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5154',80,80,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5120'),
	 (N'0001046438',N'Liar','624cd788-b328-444c-b741-a0e21e7e5164',0,'624cd788-b328-444c-b741-a0e21e7e5139',N'http://images.amazon.com/images/P/0001046438.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5149',58,58,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5119'),
	 (N'0002153572',N'Wild swans: Three daughters of China','624cd788-b328-444c-b741-a0e21e7e5210',1991,'624cd788-b328-444c-b741-a0e21e7e5143',N'http://images.amazon.com/images/P/0002153572.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5150',64,64,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5118'),
	 (N'0001714236',N'Spooky Riddles','624cd788-b328-444c-b741-a0e21e7e5200',1984,'624cd788-b328-444c-b741-a0e21e7e5140',N'http://images.amazon.com/images/P/0001714236.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5156',67,67,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5098'),
	 (N'0002166828',N'Memoirs of a great Canadian detective: Incidents in the life of John Wilson Murray','624cd788-b328-444c-b741-a0e21e7e5212',1977,'624cd788-b328-444c-b741-a0e21e7e5145',N'http://images.amazon.com/images/P/0002166828.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5155',35,35,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5116'),
	 (N'0002005050',N'The Romantic','624cd788-b328-444c-b741-a0e21e7e5251',2003,'624cd788-b328-444c-b741-a0e21e7e5137',N'http://images.amazon.com/images/P/0002005050.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5149',73,73,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5117'),
	 (N'0002176084',N'The diaries of Lord Louis Mountbatten, 1920-1922: Tours with the Prince of Wales','624cd788-b328-444c-b741-a0e21e7e5205',1987,'624cd788-b328-444c-b741-a0e21e7e5145',N'http://images.amazon.com/images/P/0002176084.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5154',80,80,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5099'),
	 (N'0002174154',N'Back to Cape Horn','624cd788-b328-444c-b741-a0e21e7e5170',1986,'624cd788-b328-444c-b741-a0e21e7e5145',N'http://images.amazon.com/images/P/0002174154.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5156',99,99,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5115'),
	 (N'0002158973',N'Landscape and Memory','624cd788-b328-444c-b741-a0e21e7e5167',0,'624cd788-b328-444c-b741-a0e21e7e5141',N'http://images.amazon.com/images/P/0002158973.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5156',9,9,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5114'),
	 (N'0001711105',N'The Book of Riddles (Beginner Books)','624cd788-b328-444c-b741-a0e21e7e5249',1983,'624cd788-b328-444c-b741-a0e21e7e5140',N'http://images.amazon.com/images/P/0001711105.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5154',23,23,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5113'),
	 (N'0002169290',N'For Goodness Sake','624cd788-b328-444c-b741-a0e21e7e5194',0,'624cd788-b328-444c-b741-a0e21e7e5141',N'http://images.amazon.com/images/P/0002169290.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5155',78,78,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5112'),
	 (N'000217622X',N'STEVE MCQUEEN','624cd788-b328-444c-b741-a0e21e7e5181',1986,'624cd788-b328-444c-b741-a0e21e7e5140',N'http://images.amazon.com/images/P/000217622X.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5155',63,63,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5111'),
	 (N'0001360469',N'Babe Dressing','624cd788-b328-444c-b741-a0e21e7e5203',1997,'624cd788-b328-444c-b741-a0e21e7e5140',N'http://images.amazon.com/images/P/0001360469.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5156',70,70,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5110'),
	 (N'0001047973',N'Brave New World','624cd788-b328-444c-b741-a0e21e7e5256',1999,'624cd788-b328-444c-b741-a0e21e7e5136',N'http://images.amazon.com/images/P/0001047973.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5154',94,94,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5109'),
	 (N'0002005395',N'Deafening','624cd788-b328-444c-b741-a0e21e7e5233',2003,'624cd788-b328-444c-b741-a0e21e7e5137',N'http://images.amazon.com/images/P/0002005395.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5153',40,40,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5108'),
	 (N'0002179687',N'Christmas in America: Images of the Holiday Season by 100 of America''s Leading Photographers','624cd788-b328-444c-b741-a0e21e7e5242',1988,'624cd788-b328-444c-b741-a0e21e7e5144',N'http://images.amazon.com/images/P/0002179687.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5149',73,73,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5107'),
	 (N'0002156970',N'Inside memory: Pages from a writer''s workbook','624cd788-b328-444c-b741-a0e21e7e5160',1990,'624cd788-b328-444c-b741-a0e21e7e5138',N'http://images.amazon.com/images/P/0002156970.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5157',42,42,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5106'),
	 (N'0001939203',N'The Collins Book of Nursery Tales','624cd788-b328-444c-b741-a0e21e7e5211',1993,'624cd788-b328-444c-b741-a0e21e7e5140',N'http://images.amazon.com/images/P/0001939203.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5151',87,87,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5105'),
	 (N'0002163713',N'Cary Grant, haunted idol','624cd788-b328-444c-b741-a0e21e7e5231',1983,'624cd788-b328-444c-b741-a0e21e7e5145',N'http://images.amazon.com/images/P/0002163713.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5150',68,68,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5104'),
	 (N'000104687X',N'T.S. Eliot Reading The Wasteland" and Other Poems"','624cd788-b328-444c-b741-a0e21e7e5161',1993,'624cd788-b328-444c-b741-a0e21e7e5140',N'http://images.amazon.com/images/P/000104687X.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5156',27,27,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5103'),
	 (N'0001382381',N'Huck Scarry''s Steam Train Journey','624cd788-b328-444c-b741-a0e21e7e5227',1979,'624cd788-b328-444c-b741-a0e21e7e5140',N'http://images.amazon.com/images/P/0001382381.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5152',35,35,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5102'),
	 (N'0002006588',N'Vancouver','624cd788-b328-444c-b741-a0e21e7e5241',2003,'624cd788-b328-444c-b741-a0e21e7e5137',N'http://images.amazon.com/images/P/0002006588.01.LZZZZZZZ.jpg','624cd788-b328-444c-b741-a0e21e7e5148',65,65,N'Lorem ipsum dolor sit amet','624cd788-b328-444c-b741-a0e21e7e5101');

ALTER TABLE TB_LOANS SET REFERENTIAL_INTEGRITY FALSE;
INSERT INTO TB_LOANS(ID_LOAN, STATUS, DUE_DATE, RETURN_DATE, LOAN_DATE, ID_USER, ID_BOOK) VALUES ('624cd788-b328-444c-b741-a0e21e7e5100',0, DATEADD('DAY',7, CURRENT_DATE), null, now(), '624cd788-b328-444c-b741-a0e21e7e5460', '624cd788-b328-444c-b741-a0e21e7e5101');
INSERT INTO TB_LOANS(ID_LOAN, STATUS, DUE_DATE, RETURN_DATE, LOAN_DATE, ID_USER, ID_BOOK) VALUES ('624cd788-b328-444c-b741-a0e21e7e5101',0, DATEADD('DAY',7, CURRENT_DATE), null, now(), '624cd788-b328-444c-b741-a0e21e7e5460', '624cd788-b328-444c-b741-a0e21e7e5102');
INSERT INTO TB_LOANS(ID_LOAN, STATUS, DUE_DATE, RETURN_DATE, LOAN_DATE, ID_USER, ID_BOOK) VALUES ('624cd788-b328-444c-b741-a0e21e7e5102',1, DATEADD('DAY',7, CURRENT_DATE), null, now(), '624cd788-b328-444c-b741-a0e21e7e5460', '624cd788-b328-444c-b741-a0e21e7e5103');
INSERT INTO TB_LOANS(ID_LOAN, STATUS, DUE_DATE, RETURN_DATE, LOAN_DATE, ID_USER, ID_BOOK) VALUES ('624cd788-b328-444c-b741-a0e21e7e5103',2, DATEADD('DAY',7, CURRENT_DATE), null, now(), '624cd788-b328-444c-b741-a0e21e7e5460', '624cd788-b328-444c-b741-a0e21e7e5134');
INSERT INTO TB_LOANS(ID_LOAN, STATUS, DUE_DATE, RETURN_DATE, LOAN_DATE, ID_USER, ID_BOOK) VALUES ('624cd788-b328-444c-b741-a0e21e7e5104',2, DATEADD('DAY',7, CURRENT_DATE), null, now(), '624cd788-b328-444c-b741-a0e21e7e5460', '624cd788-b328-444c-b741-a0e21e7e5134');
