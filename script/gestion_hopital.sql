-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 01 sep. 2022 à 06:23
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_hopital`
--

-- --------------------------------------------------------

--
-- Structure de la table `hopital`
--

DROP TABLE IF EXISTS `hopital`;
CREATE TABLE IF NOT EXISTS `hopital` (
  `code_hopital` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresse` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code_hopital`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hopital`
--

INSERT INTO `hopital` (`code_hopital`, `adresse`, `nom`) VALUES
(1, '23 rue andré reinson,33300 Bordeaux', 'CHU Bordeaux'),
(2, 'rue lucien faure,33000 Bordeaux', 'Bordeaux Nord'),
(3, '23 rue andré reinson,33300 Bordeaux', 'CHU Bordeaux'),
(4, 'rue lucien faure,33000 Bordeaux', 'Bordeaux Nord');

-- --------------------------------------------------------

--
-- Structure de la table `hopital_specialisation`
--

DROP TABLE IF EXISTS `hopital_specialisation`;
CREATE TABLE IF NOT EXISTS `hopital_specialisation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre_lit_disponible` bigint(20) DEFAULT NULL,
  `hopital_code_hopital` bigint(20) NOT NULL,
  `specialisation_code_specialite` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK29otht3f38gl5vyrw1o928i4d` (`hopital_code_hopital`),
  KEY `FKiasojri5rdulck344y0mmd2tr` (`specialisation_code_specialite`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hopital_specialisation`
--

INSERT INTO `hopital_specialisation` (`id`, `nombre_lit_disponible`, `hopital_code_hopital`, `specialisation_code_specialite`) VALUES
(1, 25, 1, 1),
(2, 20, 1, 2),
(3, 20, 1, 3),
(4, 15, 2, 2),
(5, 10, 2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `specialisation`
--

DROP TABLE IF EXISTS `specialisation`;
CREATE TABLE IF NOT EXISTS `specialisation` (
  `code_specialite` bigint(20) NOT NULL AUTO_INCREMENT,
  `libelle_specialite` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`code_specialite`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `specialisation`
--

INSERT INTO `specialisation` (`code_specialite`, `libelle_specialite`) VALUES
(1, 'Anesthésie'),
(2, 'Soins intensifs'),
(3, 'Oncologie clinique'),
(4, 'Spécialités dentaires supplémentaires'),
(5, 'Anesthésie'),
(6, 'Soins intensifs'),
(7, 'Oncologie clinique'),
(8, 'Spécialités dentaires supplémentaires');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
