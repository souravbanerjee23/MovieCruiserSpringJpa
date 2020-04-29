create schema moviecruiser;
use moviecruiser;
CREATE TABLE IF NOT EXISTS `moviecruiser`.`movie`(
  `movie_id` INT NOT NULL AUTO_INCREMENT,
  `movie_title` VARCHAR(100) NULL,
  `movie_box_office` VARCHAR(100) NULL,
  `movie_active` BOOLEAN NULL,
  `movie_date_of_launch` DATE NULL,
  `movie_genre` VARCHAR(45) NULL,
  `movie_Teaser` BOOLEAN NULL,
  PRIMARY KEY (`movie_id`))
ENGINE = InnoDB;