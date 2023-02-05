-- ExchangeOffice
INSERT INTO exchange_office (Name)
VALUES ('Armetis-Grup'),
       ('Orion'),
       ('Deghest'),
       ('Vandis-Schimb'),
       ('Avada Invest');

-- CurrencyDictionary
INSERT INTO currency_dictionary
VALUES ('USD', 'United States Dollar'),
       ('EUR', 'Euro'),
       ('GBP', 'British Pound'),
       ('CHF', 'Swiss Franc'),
       ('CAD', 'Canadian Dollar');

-- ExchangeRate
INSERT INTO exchange_rate (currency_code, rate, course, date_curs, exchange_office_id)
VALUES ('USD', 1, 1.21, '2022-01-01', 1),
       ('EUR', 1, 1.06, '2022-01-01', 1),
       ('GBP', 1, 1.31, '2022-01-01', 1),
       ('CHF', 1, 1.11, '2022-01-01', 1),
       ('CAD', 1, 0.99, '2022-01-01', 1);

-- Transactions
INSERT INTO Transaction (currency_code, exchange_rate_id,received_amount,released_amount,consumer,date_trans,exchange_office_id)
VALUES ('USD', 1, 100, 121, 'Leonid', '2022-01-01', 1),
       ('EUR', 2, 100, 106, 'Andrei', '2022-01-01', 1),
       ('GBP', 3, 100, 131, 'Sergiu', '2022-01-01', 1),
       ('CHF', 4, 100, 111, 'Stefan', '2022-01-01', 1),
       ('CAD', 5, 100, 99, 'Zinaida', '2022-01-01', 1);


-- Cash
INSERT INTO Cash (consumer, currency_code, amount, date, exchange_office_id)
VALUES ('Leonid', 'USD', 100.0, '2023-02-01', 1),
       ('Andrei', 'EUR', 200.0, '2023-02-01', 2),
       ('Sergiu', 'GBP', 300.0, '2023-02-01', 1),
       ('Stefan', 'USD', 400.0, '2023-02-01', 2),
       ('Zinaida', 'EUR', 500.0, '2023-02-01', 3);

--Employees
INSERT INTO Employees (name, position, exchange_office_id)
VALUES ('Alexandru', 'Operator', 1),
       ('Andrei', 'Manager', 2),
       ('Petru', 'Operator', 1),
       ('Alexei', 'Manager', 3),
       ('Alina', 'Operator', 2);