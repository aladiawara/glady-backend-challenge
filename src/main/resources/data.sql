--Compagnies data
INSERT INTO compagny (compagny_name, siret, social_reason, balance) VALUES ('Opteven','IINTRDFHHGD', 'Opteven ASSURANCE', 600.00);
INSERT INTO compagny (compagny_name, siret, social_reason, balance) VALUES ('SFR','XXPP', 'SFR', 16600.00);
INSERT INTO compagny (compagny_name, siret, social_reason, balance) VALUES ('Conserto','CONSERGG', 'CONSERTO SERVICES', 00.00);
INSERT INTO compagny (compagny_name, siret, social_reason, balance) VALUES ('Coexy','IINTRDFRR', 'Coexy services', 600.00);

----Users data
INSERT INTO _users (firstname, lastname, date_of_birth, address, position, compagny_id)
VALUES ('Jean', 'CONTESSE', '1990-01-05', '76 Rue Léon Blum 69100', 'Developer', 1);
INSERT INTO _users (firstname, lastname, date_of_birth, address, position, compagny_id)
VALUES ('David', 'ZENI', '1940-01-06', '4 Rue Des Jardins, 69100', 'Manager', 3);
INSERT INTO _users (firstname, lastname, date_of_birth, address, position, compagny_id)
VALUES ('Freddy', 'MARCHAND', '1977-03-04', '50 impasse du bois, 01800', 'Head of office', 2);

----Deposits Data-----
INSERT INTO deposit(amount, type, start_date, end_date, user_id)
VALUES (200.00, 'Gift', '2022-05-30', '2023-05-30', 1);
INSERT INTO deposit(amount, type, start_date, end_date, user_id)
VALUES (70.00, 'Meal', '2022-03-30', '2023-03-01', 1);
INSERT INTO deposit(amount, type, start_date, end_date, user_id)
VALUES (400.00, 'Meal', '2022-08-01', '2023-03-01', 2);
INSERT INTO deposit(amount, type, start_date, end_date, user_id)
VALUES (150.00, 'Gift', '2022-06-06', '2023-06-06', 2);

--Transactions data--
INSERT INTO transactions(amount, transaction_date, transaction_type, user_id)
VALUES (45.00, '2022-05-05', 'Gift', 1);
INSERT INTO transactions(amount, transaction_date, transaction_type, user_id)
VALUES (50.00, '2022-05-10', 'Gift', 1);
INSERT INTO transactions(amount, transaction_date, transaction_type, user_id)
VALUES (15.00, '2022-05-10', 'Meal', 1);
INSERT INTO transactions(amount, transaction_date, transaction_type, user_id)
VALUES (10.00, '2022-05-20', 'Meal', 1);