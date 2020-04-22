CREATE DATABASE estate;
USE estate;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phoneno` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ;

CREATE TABLE `admin` (
  `user_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phoneno` decimal(10,0) DEFAULT NULL,
  `tenurestart` date DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);
CREATE TABLE `auction` (
  `Auction_id` int(11) NOT NULL,
  `Property_id` int(11) DEFAULT NULL,
  `Ends_at` datetime DEFAULT NULL,
  `Owner_id` varchar(45) DEFAULT NULL,
  `Baseprice` int(11) DEFAULT NULL,
  `Winning_bid` int(11) DEFAULT '0',
  `Current_winner` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`Auction_id`)
) ;

CREATE TABLE `property` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `Type` varchar(45) DEFAULT NULL,
  `ownerid` int(11) DEFAULT NULL,
  `Area` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `estate`.`admin` (`user_id`, `name`, `username`, `password`, `email`, `phoneno`, `tenurestart`) VALUES ('1	', 'Hardik', 'hardik8464', 'agghardik', 'hardik8464@gmail.com', '7042952447', '2020-04-22');

