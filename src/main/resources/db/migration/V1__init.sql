
CREATE TABLE course
(
    id             INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name_Course    VARCHAR(20) CHECK ( name_Course IN ('TAEKWONDO', 'KICKBOX', 'GYMNASTIKA', 'KRAVMAGA') ) NOT NULL,
    characteristic TEXT,
    coach          VARCHAR(50),
    day_Of_Course  VARCHAR(2) CHECK (day_Of_Course IN ('PO', 'UT', 'ST', 'CT', 'PA', 'SO', 'NE'))          NOT NULL,
    time_Of_Course TIME

);


CREATE TABLE cadet
(
    id             INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_Name     VARCHAR(50)                                                                             NOT NULL,
    second_Name    VARCHAR(50)                                                                             NOT NULL,
    birth_Day      DATE                                                                                    NOT NULL,
    name_Course    VARCHAR(20) CHECK (name_Course IN ('TAEKWONDO', 'KICKBOX', 'GYMNASTIKA', 'KRAVMAGA') ) NOT NULL,
    day_Of_Course  VARCHAR(2) CHECK (day_Of_Course IN ('PO', 'UT', 'ST', 'CT', 'PA', 'SO', 'NE'))          NOT NULL,
    time_Of_Course TIME                                                                                    NOT NULL,
    name_Parent    VARCHAR(50)                                                                             NOT NULL,
    email          VARCHAR(50)                                                                             NOT NULL,
    phone_Number   VARCHAR(15)                                                                             NOT NULL,
    parent_Escort  BOOLEAN                                                                                 NOT NULL,
    id_course      INT                                                                                 NOT NULL,
    FOREIGN KEY (id_course) REFERENCES course (id)

);




