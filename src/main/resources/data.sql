INSERT INTO `doctors` (`user_id`, `email`, `dob`, `account_active`, `address`,  `first_name`, `last_name`, `mobile_number`, `password`, `role`)
VALUES ('1', 'wd@gmail.com', 19960101, TRUE, '35 Oxford St', 'Wayne', 'Dang', '0412345678', 'abc123', 'DOCTOR');

INSERT INTO `doctors` (`user_id`, `email`, `dob`, `account_active`, `address`,  `first_name`, `last_name`, `mobile_number`, `password`, `role`)
VALUES ('2', 'ed@gmail.com', 19950101, FALSE, '123 Evelyn St', 'Eveline', 'Dang', '0412345678', 'abc123', 'DOCTOR');

INSERT INTO `admins` (`user_id`, `email`, `dob`, `account_active`, `address`, `first_name`, `last_name`, `mobile_number`, `password`, `role`)
VALUES ('1', 'rw@gmail.com', 19970101, TRUE, 'Not_Ur_Business', 'Rico', 'Wu', '0412345678', 'abc123', 'ADMIN');

INSERT INTO `patients` (`user_id`, `email`, `dob`, `account_active`, `address`, `first_name`, `last_name`, `mobile_number`, `password`, `role`)
VALUES ('1', 'dg@gmail.com', 20010101, TRUE, 'Esshay Village', 'Daniel', 'Gao', '0412345678', 'abc123', 'PATIENT');

INSERT INTO `patients` (`user_id`, `email`, `dob`, `account_active`, `address`, `first_name`, `last_name`, `mobile_number`, `password`, `role`)
VALUES ('2', 'wj@gmail.com', 19950101, FALSE, 'Saddle Club Village', 'Wyatt', 'Jenkins', '0412345678', 'abc123', 'PATIENT');

INSERT INTO `doctor_availability` (`doctor_availability_id`, `doctor_id`,`start_time`, `end_time`)
VALUES ('1', '1', '2022-10-03 09:00:00','2022-10-03 17:00:00');

INSERT INTO `doctor_availability` (`doctor_availability_id`, `doctor_id`,`start_time`, `end_time`)
VALUES ('2', '1', '2022-10-04 09:00:00','2022-10-04 17:00:00');

INSERT INTO `doctor_availability` (`doctor_availability_id`, `doctor_id`,`start_time`, `end_time`)
VALUES ('3', '1', '2022-10-05 09:00:00','2022-10-05 17:00:00');

INSERT INTO `doctor_availability` (`doctor_availability_id`, `doctor_id`,`start_time`, `end_time`)
VALUES ('4', '1', '2022-10-06 09:00:00','2022-10-06 17:00:00');

INSERT INTO `doctor_availability` (`doctor_availability_id`, `doctor_id`,`start_time`, `end_time`)
VALUES ('5', '1', '2022-10-07 09:00:00','2022-10-07 17:00:00');

INSERT INTO `appointments` (`appt_id`, `doctor_id`, `patient_id`, `appt_start_date`, `appt_end_date`, `appt_status`)
VALUES ('1', '1','1', '2022-10-03 10:00:00','2022-10-03 10:30:00' , 'ACTIVE');

INSERT INTO `appointments` (`appt_id`, `doctor_id`, `patient_id`, `appt_start_date`, `appt_end_date`, `appt_status`)
VALUES ('2', '1','1', '2022-10-03 13:00:00','2022-10-03 13:30:00', 'ACTIVE');

