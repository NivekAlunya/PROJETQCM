USE PROJETQCM;

DROP TABLE Inscriptions;
DROP TABLE Candidats;
DROP TABLE Promotions;

CREATE TABLE Promotions(
    codePromotion CHAR(10) CONSTRAINT pk_promotion PRIMARY KEY,
    Libelle VARCHAR(150)
);


CREATE TABLE Candidats(
    idCandidat INTEGER IDENTITY CONSTRAINT pk_Candidats PRIMARY KEY,
    Nom VARCHAR(50),
    Prenom VARCHAR(20),
    MotDePasse VARCHAR(20),
    codePromotion CHAR(10) CONSTRAINT fk_candidats_promotions REFERENCES Promotions (codePromotion)
);


CREATE TABLE Inscriptions(
    idInscription INTEGER IDENTITY CONSTRAINT pk_Inscriptions PRIMARY KEY,
    idCandidat INTEGER CONSTRAINT fk_Inscriptions_Candidats REFERENCES Candidats (idCandidat),
    idTest INTEGER CONSTRAINT fk_Inscriptions_Tests REFERENCES Tests (idTest),
    rapport VARCHAR(4000),
    dateDebut DATETIME,
    dateFin DATETIME,
    eMail VARCHAR(128),
    typeInscription CHAR(3),
    tempsEcoule INTEGER
);