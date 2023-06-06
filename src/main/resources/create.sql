CREATE TABLE `roadbuddies_db`.`user` (
   `id` BIGINT NOT NULL AUTO_INCREMENT,
   `firstname` VARCHAR(100) NOT NULL,
   `lastname` VARCHAR(100) NOT NULL,
   `username` VARCHAR(100) NOT NULL,
   `password` VARCHAR(100) NOT NULL,
   `email` VARCHAR(100) NOT NULL,
   `birthday` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `phone_number` INT NOT NULL,
   PRIMARY KEY (`id`));
     
CREATE TABLE `roadbuddies_db`.`message` (
   `id` BIGINT NOT NULL AUTO_INCREMENT,
   `content` LONGTEXT NOT NULL,
   `date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `sender_fk` BIGINT NOT NULL,
   `recipient_fk` BIGINT NOT NULL,
   PRIMARY KEY (`id`),
   CONSTRAINT `fk_user_message_sender`
     FOREIGN KEY (`sender_fk`)
     REFERENCES `roadbuddies_db`.`user` (`id`)
     ON DELETE NO ACTION
     ON UPDATE NO ACTION,
   CONSTRAINT `fk_user_message_recipient`
     FOREIGN KEY (`recipient_fk`)
     REFERENCES `roadbuddies_db`.`user` (`id`)
     ON DELETE NO ACTION
     ON UPDATE NO ACTION
);

CREATE TABLE `roadbuddies_db`.`car` (
   `id` BIGINT NOT NULL AUTO_INCREMENT,
   `make` VARCHAR(100) NOT NULL,
   `model` VARCHAR(100) NOT NULL,
   `year` INT NULL,
   `license` VARCHAR(100) NOT NULL,
   `plate` VARCHAR(100) NULL,
   `color` VARCHAR(100) NULL,
   `user_fk` BIGINT NOT NULL,
   PRIMARY KEY (`id`),
      CONSTRAINT `fk_user_car`
     FOREIGN KEY (`user_fk`)
     REFERENCES `roadbuddies_db`.`user` (`id`)
     ON DELETE NO ACTION
     ON UPDATE NO ACTION
   );
   
CREATE TABLE `roadbuddies_db`.`trip` (
   `id` BIGINT NOT NULL AUTO_INCREMENT,
   `departure_city` VARCHAR(255) NOT NULL,
   `destination_city` VARCHAR(255) NOT NULL,
   `departure_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `arrival_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `available_seats` INT NOT NULL,
   `price` INT NOT NULL,
   `user_fk` BIGINT NOT NULL,
   PRIMARY KEY (`id`),
      CONSTRAINT `fk_user_trip`
     FOREIGN KEY (`user_fk`)
     REFERENCES `roadbuddies_db`.`user` (`id`)
     ON DELETE NO ACTION
     ON UPDATE NO ACTION
   );
   
CREATE TABLE `roadbuddies_db`.`booking` (
   `id` BIGINT NOT NULL AUTO_INCREMENT,
   `content` LONGTEXT NULL,
   `booking_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `num_of_pax` INT NOT NULL,
   `user_fk` BIGINT NOT NULL,
   `trip_fk` BIGINT NOT NULL,
   PRIMARY KEY (`id`),
	CONSTRAINT `fk_booking_user`
     FOREIGN KEY (`user_fk`)
     REFERENCES `roadbuddies_db`.`user` (`id`)
     ON DELETE NO ACTION
     ON UPDATE NO ACTION,
	CONSTRAINT `fk_booking_trip`
     FOREIGN KEY (`trip_fk`)
     REFERENCES `roadbuddies_db`.`trip` (`id`)
     ON DELETE NO ACTION
     ON UPDATE NO ACTION
   );
   
CREATE TABLE `roadbuddies_db`.`review` (
   `id` BIGINT NOT NULL AUTO_INCREMENT,
   `rating` SMALLINT NOT NULL,
   `content` LONGTEXT NULL,
   `date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `user_fk` BIGINT NOT NULL,
   `trip_fk` BIGINT NOT NULL,
   PRIMARY KEY (`id`),
	CONSTRAINT `fk_review_user`
     FOREIGN KEY (`user_fk`)
     REFERENCES `roadbuddies_db`.`user` (`id`)
     ON DELETE NO ACTION
     ON UPDATE NO ACTION,
	CONSTRAINT `fk_review_trip`
     FOREIGN KEY (`trip_fk`)
     REFERENCES `roadbuddies_db`.`trip` (`id`)
     ON DELETE NO ACTION
     ON UPDATE NO ACTION
   );
   
   
   INSERT INTO `account`(`id`, `firstname`, `lastname`, `username`, `password`, `email`, `birthday`, `phone_number`) VALUES (1, 'first', 'user', 'abdel', 'abdel', 'abdel@gmail.com', '1990-01-01', '0712365478');