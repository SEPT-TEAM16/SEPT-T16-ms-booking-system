CREATE VIEW `users` AS
SELECT *
FROM doctors
UNION ALL
SELECT *
FROM patients
UNION ALL
SELECT *
FROM admins;