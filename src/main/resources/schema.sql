CREATE TABLE company (
    id INTEGER NOT NULL PRIMARY KEY,
    company_name VARCHAR(40) NOT NULL
);

CREATE TABLE employee (
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    sur_name VARCHAR(40) NOT NULL,
    email VARCHAR(40),
    address VARCHAR(40),
    salary DECIMAL(13 , 2 ),
    company_id INTEGER(20),
    CONSTRAINT `fk_company_id` FOREIGN KEY (`company_id`)
        REFERENCES `company` (`id`)
);

INSERT INTO `company` (`id`, `company_name`) VALUES(1, 'EBS');

INSERT INTO `company` (`id`, `company_name`) VALUES(2, 'MICROSOFT');

INSERT INTO `employee` (`id`, `name`,`sur_name`,`email`,`address`,`salary`,`company_id`) VALUES(1, 'John','MAX','meetjibin@gmail.com','Ackerstrasse 19 40223 Dusseldorf',60000,1);