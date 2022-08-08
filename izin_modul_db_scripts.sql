CREATE DATABASE `izin_modul_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE TABLE `tbl_employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_balance` decimal(2,0) DEFAULT NULL,
  `employee_name` varchar(45) NOT NULL,
  `employee_surname` varchar(45) NOT NULL,
  `employee_worked_year` int(11) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_leave_history` (
  `leavehistory_id` int(11) NOT NULL AUTO_INCREMENT,
  `approval_date` datetime DEFAULT NULL,
  `hours` decimal(2,0) DEFAULT NULL,
  `request_date` datetime NOT NULL,
  `start_date` datetime NOT NULL,
  `employee_id` int(11) NOT NULL,
  `manager_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `leave_cancelled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`leavehistory_id`),
  KEY `FK_9s5wv4u0schoe32vqiysr3nus` (`employee_id`),
  KEY `FK_q5ktxh3ccinnnkjls4oy057js` (`manager_id`),
  KEY `FK_ka9a3trmk0ig10nowp8n9gmoo` (`status_id`),
  CONSTRAINT `FK_9s5wv4u0schoe32vqiysr3nus` FOREIGN KEY (`employee_id`) REFERENCES `tbl_employee` (`employee_id`),
  CONSTRAINT `FK_q5ktxh3ccinnnkjls4oy057js` FOREIGN KEY (`manager_id`) REFERENCES `tbl_manager` (`manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tbl_manager` (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  PRIMARY KEY (`manager_id`),
  KEY `FK_2af7g3f2xjyow5od2rsetkeau` (`employee_id`),
  CONSTRAINT `FK_2af7g3f2xjyow5od2rsetkeau` FOREIGN KEY (`employee_id`) REFERENCES `tbl_employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tbl_status` (
  `status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status_name` varchar(45) NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
