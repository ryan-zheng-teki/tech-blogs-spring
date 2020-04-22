INSERT INTO BlogCategory (name,sequenceNumber) VALUES ('Algorithms',1);
INSERT INTO BlogCategory (name,sequenceNumber) VALUES ('ORM',2);

INSERT INTO BlogCategory (name,sequenceNumber) VALUES ('Frontend',3);
INSERT INTO BlogCategory (name,sequenceNumber,parentCategory) VALUES ('React',4, 'Frontend');
INSERT INTO BlogCategory (name,sequenceNumber,parentCategory) VALUES ('Angular',5,'Frontend');

INSERT INTO BlogCategory (name,sequenceNumber) VALUES ('Backend',6);
INSERT INTO BlogCategory (name,sequenceNumber,parentCategory) VALUES ('Spring Boot',7,'Backend');

INSERT INTO BlogCategory (name,sequenceNumber) VALUES ('Database',8);
INSERT INTO BlogCategory (name,sequenceNumber,parentCategory) VALUES ('Mysql',9,'Database');
INSERT INTO BlogCategory (name,sequenceNumber,parentCategory) VALUES ('Cassandra',10,'Database');
INSERT INTO BlogCategory (name,sequenceNumber,parentCategory) VALUES ('Redis',11,'Database');
INSERT INTO BlogCategory (name,sequenceNumber,parentCategory) VALUES ('RabbitMQ',12,'Database');


INSERT INTO BlogCategory (name,sequenceNumber) VALUES ('Programming Languages',13);
INSERT INTO BlogCategory (name,sequenceNumber,parentCategory) VALUES ('Java',14,'Programming Languages');
INSERT INTO BlogCategory (name,sequenceNumber,parentCategory) VALUES ('Javascript',15,'Programming Languages');
INSERT INTO BlogCategory (name,sequenceNumber,parentCategory) VALUES ('Python',16,'Programming Languages');


INSERT INTO BlogCategory (name,sequenceNumber) VALUES ('Machine Learning',17);
INSERT INTO BlogCategory (name,sequenceNumber,parentCategory) VALUES ('CV',18,'Machine Learning');
INSERT INTO BlogCategory (name,sequenceNumber,parentCategory) VALUES ('NLP',19,'Machine Learning');



