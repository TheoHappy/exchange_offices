CREATE TABLE exchange_office
(
    id   serial      NOT NULL,
    name varchar(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE currency_dictionary
(
    currency_code varchar(3)  NOT NULL,
    name varchar(50) NOT NULL,
    PRIMARY KEY (currency_code)
);

CREATE TABLE exchange_rate
(
    id                 serial     NOT NULL,
    currency_code               varchar(3) NOT NULL,
    rate               float      NOT NULL,
    course             float      NOT NULL,
    date_curs          date       NOT NULL,
    exchange_office_id int        NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (currency_code) REFERENCES currency_dictionary (currency_code),
    FOREIGN KEY (exchange_office_id) REFERENCES exchange_office (id)
);

CREATE TABLE transaction
(
    id                 serial      NOT NULL,
    currency_code      varchar(3)  NOT NULL,
    exchange_rate_id   int         NOT NULL,
    received_amount    float       NOT NULL,
    released_amount    float       NOT NULL,
    consumer           varchar(50) NOT NULL,
    date_trans         date        NOT NULL,
    exchange_office_id int         NOT NULL,
    PRIMARY KEY (id, currency_code, exchange_office_id),
    FOREIGN KEY (exchange_rate_id) REFERENCES exchange_rate (id),
    FOREIGN KEY (currency_code) REFERENCES currency_dictionary (currency_code),
    FOREIGN KEY (exchange_office_id) REFERENCES exchange_office (id)
);

CREATE TABLE cash
(
    id                 serial      NOT NULL,
    consumer           varchar(50) NOT NULL,
    currency_code               varchar(3)  NOT NULL,
    amount             float       NOT NULL,
    date               date        NOT NULL,
    exchange_office_id int         NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (currency_code) REFERENCES currency_dictionary (currency_code),
    FOREIGN KEY (exchange_office_id) REFERENCES exchange_office (id)
);

CREATE TABLE employees
(
    id                 serial      NOT NULL,
    name               varchar(50) NOT NULL,
    position           varchar(50) NOT NULL,
    exchange_office_id int         NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (exchange_office_id) REFERENCES exchange_office (id)
);



