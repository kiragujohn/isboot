DROP Sequence is_sequence;
CREATE Sequence is_sequence START 1001;

-- =============================================================================

INSERT INTO country (id, name, country_code) 
VALUES (1, 'South Africa', 'ZA');

-- =============================================================================

INSERT INTO app_role (id, name) 
VALUES (1, 'USER');

INSERT INTO app_role (id, name) 
VALUES (2, 'ADMIN');

INSERT INTO app_role (id, name) 
VALUES (3, 'GUEST');

-- =============================================================================

-- non-encrypted password: jwtpass ADMIN
INSERT INTO app_user (id, first_name, last_name, email, phone, password, created_date) 
VALUES (1, 'Admin', 'Admin', 'kiragujohn_admin@gmail.com', '0612430204', '$2a$10$z2WJK9igxsciK9vEpFeefOobflY1pjCFBv3j1KM30NSXK3IKJvway', '2019-09-17 18:47:52.69');

-- non-encrypted password: jwtpass USER
INSERT INTO app_user (id, first_name, last_name, email, phone, password, created_date) 
VALUES (2, 'John', 'Njoroge', 'kiragujohn_user@gmail.com', '0612430204', '$2a$10$z2WJK9igxsciK9vEpFeefOobflY1pjCFBv3j1KM30NSXK3IKJvway', '2019-09-17 18:47:52.69');


-- non-encrypted password: jwtpass GUEST
INSERT INTO app_user (id, first_name, last_name, email, phone, password, created_date) 
VALUES (3, 'John', 'Njoroge', 'jd@43kare.de', '0612430204', '$2a$10$z2WJK9igxsciK9vEpFeefOobflY1pjCFBv3j1KM30NSXK3IKJvway', '2019-09-17 18:47:52.69');


-- =============================================================================

INSERT INTO address_type (id, name) VALUES (1, 'PHYSICAL');
INSERT INTO address_type (id, name) VALUES (2, 'POSTAL');

-- =============================================================================

INSERT INTO address (id, first_line, second_line, post_code, town_or_city, 
fk_country, fk_address_type, fk_user) 
VALUES (1, 'Blake House ', '32 Flanders Drive, Mount Edgecombie ' , '4300 ', 
'Durban', 1, 1, 1);

-- =============================================================================

INSERT INTO account_type (id, name) 
VALUES (1, 'CHEQUE');

INSERT INTO account_type (id, name) 
VALUES (2, 'SAVINGS');

-- =============================================================================

INSERT INTO account (id, account_number, fk_account_type, fk_user) 
VALUES (1, 1111111, 1, 2);

INSERT INTO account (id, account_number, fk_account_type, fk_user) 
VALUES (2, 2222222, 2, 2);

-- =============================================================================

INSERT INTO payment_method (id, name) 
VALUES (1, 'BANK');

INSERT INTO payment_method (id, name) 
VALUES (2, 'CASH');

INSERT INTO payment_method (id, name) 
VALUES (3, 'CHEQUE');

INSERT INTO payment_method (id, name) 
VALUES (4, 'CREDIT_CARD');

-- =============================================================================

INSERT INTO currency (id, name) 
VALUES (1, 'ZAR');

INSERT INTO currency (id, name) 
VALUES (2, 'EUR');

INSERT INTO currency (id, name) 
VALUES (3, 'USD');

-- =============================================================================

--INSERT INTO account_transaction (id, transaction_id, description, paid_date, amount, fk_account, fk_currency, fk_paymentMethod) 
--VALUES (1, 01010101, 'Jan Rent', '2018-12-17 18:47:52.69', 20000, 2, 1, 1);

--INSERT INTO account_transaction (id, transaction_id, description, paid_date, amount, fk_account, fk_currency, fk_paymentMethod) 
--VALUES (1, 01010101, 'Jan Rent', '2018-12-17 18:47:52.69', 20000, 1, 1, 2);


INSERT INTO user_role(id, fk_user, fk_role) VALUES (1, 3, 2);

INSERT INTO user_role(id, fk_user, fk_role) VALUES (2, 2, 3);

INSERT INTO user_role(id, fk_user, fk_role) VALUES (3, 1, 1);