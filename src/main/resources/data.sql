CREATE OR REPLACE
VIEW `doctors` AS
SELECT
    `users`.`user_id` AS `doctor_id`,
    `users`.`account_active` AS `account_active`,
    `users`.`address` AS `address`,
    `users`.`dob` AS `dob`,
    `users`.`email` AS `email`,
    `users`.`first_name` AS `first_name`,
    `users`.`last_name` AS `last_name`,
    `users`.`mobile_number` AS `mobile_number`,
    `users`.`password` AS `password`
FROM
    `users`
WHERE
    (`users`.`role` LIKE 'DOCTOR');

CREATE OR REPLACE
VIEW `patients` AS
SELECT
    `users`.`user_id` AS `patient_id`,
    `users`.`account_active` AS `account_active`,
    `users`.`address` AS `address`,
    `users`.`dob` AS `dob`,
    `users`.`email` AS `email`,
    `users`.`first_name` AS `first_name`,
    `users`.`last_name` AS `last_name`,
    `users`.`mobile_number` AS `mobile_number`,
    `users`.`password` AS `password`
FROM
    `users`
WHERE
    (`users`.`role` LIKE 'PATIENT');

