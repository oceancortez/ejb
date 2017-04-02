CREATE SCHEMA `jsf_primefaces` DEFAULT CHARACTER SET utf8;


CREATE TABLE `jsf_primefaces`.`mra` (
  `mracod` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `mranam` VARCHAR(45) NOT NULL,
  `mradat` VARCHAR(45) NULL,
  PRIMARY KEY (`mracod`),
  UNIQUE INDEX `mranam_UNIQUE` (`mranam` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE `jsf_primefaces`.`mdo` (
  `mdocod` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `mdonam` VARCHAR(45) NOT NULL,
  `mdodat` VARCHAR(45) NULL,
  `vrscod` BIGINT(11) NOT NULL,
  PRIMARY KEY (`mdocod`));


CREATE TABLE `jsf_primefaces`.`vrs` (
  `vrscod` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `vrsnam` VARCHAR(45) NOT NULL,
  `vrsano` VARCHAR(45) NOT NULL,
  `vrsdat` DATETIME NULL,
  PRIMARY KEY (`vrscod`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- --------------------------------------------------------------------------------


CREATE TABLE `jsf_primefaces`.`cro` (
  `crocod` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `mdocod` BIGINT(11) NOT NULL,
  `usrcod` BIGINT(11) NOT NULL,
  `crodat` DATETIME NULL,
  PRIMARY KEY (`crocod`),
  INDEX `mdocod_fk_idx` (`mdocod` ASC),
  CONSTRAINT `mdocod_fk`
    FOREIGN KEY (`mdocod`)
    REFERENCES `jsf_primefaces`.`mdo` (`mdocod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



ALTER TABLE `jsf_primefaces`.`mdo` 
ADD COLUMN `mracod` BIGINT(11) NOT NULL AFTER `vrscod`,
ADD INDEX `vrscod_fk_idx` (`vrscod` ASC),
ADD INDEX `mracod_fk_idx` (`mracod` ASC);
ALTER TABLE `jsf_primefaces`.`mdo` 
ADD CONSTRAINT `vrscod_fk`
  FOREIGN KEY (`vrscod`)
  REFERENCES `jsf_primefaces`.`vrs` (`vrscod`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `mracod_fk`
  FOREIGN KEY (`mracod`)
  REFERENCES `jsf_primefaces`.`mra` (`mracod`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;












