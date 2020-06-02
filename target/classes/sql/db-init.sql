INSERT INTO public.customer(
    city, country, name, nip, postal_code, street_name)
VALUES ('Warszawa', 'Polska', 'SAP Polska sp. z o.o.', '9510061264', '02-675', 'Wołoska 5'),
       ('Warszawa', 'Polska', 'Bluesoft sp. z o.o.', '5262667699', '00-807', 'Aleje Jerozolimskie 96'),
       ('Gliwice', 'Polska', 'Future Processing sp. z o.o.', '6342532128', '44-100', 'Bojkowska 37 A'),
       ('Gliwice', 'Polska', 'Euvic sp. z o.o.', '9691411637', '44-100', 'Przewozowa 32'),
       ('Gliwice', 'Polska', 'Brainhub sp. z o.o.', '6312663239', '44-100', 'Generała Leona Berbeckiego 2/5'),
       ('Rzeszów', 'Polska', 'Asseco Poland S.A.', '5220003782', '35-322', 'Olchowa 14'),
       ('Kraków', 'Polska', 'Comarch S.A.', '6770065406', '31-864', 'Aleja Jana Pawła Ii 39 A'),
       ('Katowice', 'Polska', 'Kamsoft S.A.', '9542685559', '40-235', '1 Maja 133');

INSERT INTO public.system(
    description, name, technologies, customer_id)
VALUES ('Opis 1', 'SAP System 1', 'Java, Spring', 1),
       ('Opis 2', 'SAP System 2', 'Java, Spring', 1),
       ('Opis 3', 'SAP System 3', 'Java, Spring', 1),
       ('Opis 1', 'Bluesoft System 1', '.NET, Angular', 2),
       ('Opis 2', 'Bluesoft System 2', '.NET, Angular', 2);

INSERT INTO public.contract(
    active, amount, billing_period, contract_number, end_date, start_date, system_id)
VALUES (true, 100000.01, 'Miesiąc', 'SAP-S1-K1', '01/01/2021', '01/01/2020', 1);