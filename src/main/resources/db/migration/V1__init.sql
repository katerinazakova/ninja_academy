CREATE TABLE ninjaAcademyForm
(
    id IDENTITY,
    firstName    VARCHAR(50)                                                                            NOT NULL,
    secondName   VARCHAR(50)                                                                            NOT NULL,
    birthDay     DATE                                                                                   NOT NULL,
    nameCourse   VARCHAR(20) CHECK ( nameCourse IN ('TAEKWONDO', 'KICKBOX', 'GYMNASTIKA', 'KRAVMAGA') ) NOT NULL,
    timeCourse   VARCHAR(20)                                                                            NOT NULL,
    nameParent   VARCHAR(50)                                                                            NOT NULL,
    email        VARCHAR(50)                                                                            NOT NULL,
    phoneNumber  VARCHAR(15)                                                                            NOT NULL,
    parentEscort BOOLEAN                                                                                NOT NULL

);


