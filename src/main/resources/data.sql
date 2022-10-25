CREATE TABLE MIDIA (
	ID INT NOT NULL,
	TITLE VARCHAR(30) NOT NULL, 
	DESCRIPTION VARCHAR(150),
	URL VARCHAR(50) NOT NULL	
);

INSERT INTO `midia` (`id`, `title`, `description`, `url`) VALUES (1, 'galas_feios', 'live dos galas', 'you.be/galas');

INSERT INTO `midia` (`id`, `title`, `description`, `url`) VALUES (2, 'mikannn', 'live', 'you.be/mik');