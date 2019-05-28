-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 28 mai 2019 à 16:41
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `anneescolaire`
--

DROP TABLE IF EXISTS `anneescolaire`;
CREATE TABLE IF NOT EXISTS `anneescolaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `annee` varchar(10) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `anneescolaire`
--

INSERT INTO `anneescolaire` (`id`, `annee`) VALUES
(1, '2012/2013'),
(2, '2013/2014'),
(3, '2014/2015'),
(4, '2015/2016'),
(5, '2016/2017'),
(6, '2017/2018'),
(7, '2018/2019'),
(8, '2019/2020'),
(9, '2020/2021'),
(10, '2021/2022');

-- --------------------------------------------------------

--
-- Structure de la table `bulletin`
--

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE IF NOT EXISTS `bulletin` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `id_inscription` int(50) NOT NULL,
  `id_trimestre` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `bulletin`
--

INSERT INTO `bulletin` (`id`, `id_inscription`, `id_trimestre`) VALUES
(1, 2, 55),
(2, 3, 60),
(3, 1, 58),
(4, 2, 56),
(5, 1, 58),
(6, 3, 58);

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `id_niveau` int(11) NOT NULL,
  `id_annee` varchar(20) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`id`, `nom`, `id_niveau`, `id_annee`) VALUES
(1, 'TD1', 2, '5'),
(2, 'TD5', 4, '7'),
(3, 'TD10', 2, '6'),
(4, 'TD8', 5, '7'),
(5, 'TD2', 1, '3'),
(6, 'TD7', 3, '4'),
(7, 'TD8', 4, '4'),
(8, 'TD3', 2, '6'),
(9, 'TD12', 1, '7'),
(10, 'TD8', 2, '6');

-- --------------------------------------------------------

--
-- Structure de la table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `discipline`
--

INSERT INTO `discipline` (`id`, `nom`) VALUES
(1, 'Base de données'),
(2, 'Probabilités'),
(3, 'Electromagnétisme'),
(4, 'POO Java'),
(5, 'Théories des graphes'),
(6, 'Anglais'),
(7, 'Analyse de Fourier');

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

DROP TABLE IF EXISTS `eleve`;
CREATE TABLE IF NOT EXISTS `eleve` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `prenom` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `eleve`
--

INSERT INTO `eleve` (`id`, `nom`, `prenom`) VALUES
(1, 'Emprin', 'Arnaud'),
(2, 'Compoint', 'Zoé'),
(3, 'Symchowicz', 'Dan');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `prenom` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`id`, `nom`, `prenom`) VALUES
(1, 'Segado', 'Jean Pierre'),
(2, 'Le Cor', 'Jean Luc'),
(3, 'Amrhein', 'Sebastien'),
(4, 'Leonard', 'Marie des Neiges'),
(5, 'Fercoq', 'Robin'),
(6, 'Mouhali', 'Waleed'),
(7, 'Coudray', 'Fabienne');

-- --------------------------------------------------------

--
-- Structure de la table `enseignement`
--

DROP TABLE IF EXISTS `enseignement`;
CREATE TABLE IF NOT EXISTS `enseignement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_classe` int(11) NOT NULL,
  `id_enseignant` int(11) NOT NULL,
  `id_discipline` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `enseignement`
--

INSERT INTO `enseignement` (`id`, `id_classe`, `id_enseignant`, `id_discipline`) VALUES
(1, 5, 5, 1),
(2, 6, 2, 2),
(3, 2, 1, 4),
(4, 9, 4, 6),
(5, 8, 7, 7),
(6, 10, 3, 1),
(7, 3, 6, 3),
(8, 4, 4, 6),
(9, 2, 1, 5),
(10, 3, 7, 2);

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `note` int(11) NOT NULL,
  `appreciation` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `id_bulletin` int(11) NOT NULL,
  `id_enseignant` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `evaluation`
--

INSERT INTO `evaluation` (`id`, `note`, `appreciation`, `id_bulletin`, `id_enseignant`) VALUES
(1, 15, 'Un très bon trimestre, félicitations', 1, 1),
(2, 8, 'Notions mal comprises', 1, 2),
(3, 10, 'Vraiment moyen dans l\'ensemble', 1, 4),
(4, 12, 'Correct sauf aux interros', 2, 5),
(5, 19, 'Major de promo : du haut niveau !', 2, 7);

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `id_eleve` int(20) NOT NULL,
  `id_classe` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`id`, `id_eleve`, `id_classe`) VALUES
(1, 1, 8),
(2, 2, 2),
(3, 3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `nom` set('ING1','ING2','ING3','ING4','ING5') COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `niveau`
--

INSERT INTO `niveau` (`id`, `nom`) VALUES
(1, 'ING1'),
(2, 'ING2'),
(3, 'ING3'),
(4, 'ING4'),
(5, 'ING5');

-- --------------------------------------------------------

--
-- Structure de la table `trimestre`
--

DROP TABLE IF EXISTS `trimestre`;
CREATE TABLE IF NOT EXISTS `trimestre` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `numero` set('1','2','3') COLLATE utf8mb4_bin NOT NULL,
  `debut` date NOT NULL,
  `fin` date NOT NULL,
  `id_annee` varchar(11) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Déchargement des données de la table `trimestre`
--

INSERT INTO `trimestre` (`id`, `numero`, `debut`, `fin`, `id_annee`) VALUES
(35, '1', '2012-09-01', '2012-12-01', '1'),
(36, '2', '2012-12-01', '2013-02-01', '1'),
(37, '3', '2013-02-01', '2013-05-01', '1'),
(38, '1', '2013-09-01', '2013-12-01', '2'),
(39, '2', '2013-12-01', '2014-02-01', '2'),
(40, '3', '2014-02-01', '2014-05-01', '2'),
(41, '1', '2014-09-01', '2014-12-01', '3'),
(42, '2', '2014-12-01', '2015-02-01', '3'),
(43, '3', '2015-02-01', '2015-05-01', '3'),
(44, '1', '2015-09-01', '2015-12-01', '4'),
(45, '2', '2015-12-01', '2016-02-01', '4'),
(46, '3', '2016-02-01', '2016-05-01', '4'),
(47, '1', '2016-09-01', '2016-12-01', '5'),
(48, '2', '2016-12-01', '2017-02-01', '5'),
(49, '3', '2017-02-01', '2017-05-01', '5'),
(50, '1', '2017-09-01', '2017-12-01', '6'),
(51, '2', '2017-12-01', '2018-02-01', '6'),
(52, '3', '2018-02-01', '2018-05-01', '6'),
(53, '1', '2018-09-01', '2018-12-01', '7'),
(54, '2', '2018-12-01', '2019-02-01', '7'),
(55, '3', '2019-02-01', '2019-05-01', '7'),
(56, '1', '2019-09-01', '2019-12-01', '8'),
(57, '2', '2019-12-01', '2020-02-01', '8'),
(58, '3', '2020-02-01', '2020-05-01', '8'),
(59, '1', '2020-09-01', '2020-12-01', '9'),
(60, '2', '2020-12-01', '2021-02-01', '9'),
(61, '3', '2021-02-01', '2021-05-01', '9'),
(62, '1', '2021-09-01', '2021-12-01', '10'),
(63, '2', '2021-12-01', '2022-02-01', '10'),
(64, '3', '2022-02-01', '2022-05-01', '10');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
