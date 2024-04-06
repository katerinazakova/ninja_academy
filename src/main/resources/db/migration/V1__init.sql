CREATE TABLE course
(
    id             INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name_Course    VARCHAR(20) CHECK (name_Course IN ('TAEKWONDO', 'KICKBOX', 'GYMNASTIKA', 'KRAVMAGA') ) NOT NULL,
    characteristic TEXT,
    coach          VARCHAR(50)                                                                            NOT NULL
);

CREATE TABLE dates
(
    id               INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name_Course      VARCHAR(20) CHECK (name_Course IN ('TAEKWONDO', 'KICKBOX', 'GYMNASTIKA', 'KRAVMAGA') ) NOT NULL,
    day_Course       VARCHAR(2) CHECK (day_Course IN ('PO', 'UT', 'ST', 'CT', 'PA', 'SO', 'NE'))            NOT NULL,
    time_Course_From TIME                                                                                   NOT NULL,
    time_Course_To   TIME                                                                                   NOT NULL,
    age_From         INT                                                                                    NOT NULL,
    age_To           INT                                                                                    NOT NULL,
    course_id        INT                                                                                    NOT NULL,
    FOREIGN KEY (course_id) REFERENCES course (id)
);


CREATE TABLE cadet
(
    id                INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_Name        VARCHAR(50)                                                                            NOT NULL,
    second_Name       VARCHAR(50)                                                                            NOT NULL,
    birth_Day         DATE                                                                                   NOT NULL,
    name_Course       VARCHAR(20) CHECK (name_Course IN ('TAEKWONDO', 'KICKBOX', 'GYMNASTIKA', 'KRAVMAGA') ) NOT NULL,
    day_Course        VARCHAR(2) CHECK (day_Course IN ('PO', 'UT', 'ST', 'CT', 'PA', 'SO', 'NE'))            NOT NULL,
    start_Time_Course TIME                                                                                   NOT NULL,
    name_Parent       VARCHAR(50)                                                                            NOT NULL,
    email             VARCHAR(50)                                                                            NOT NULL,
    phone_Number      VARCHAR(15)                                                                            NOT NULL,
    parent_Escort     BOOLEAN                                                                                NOT NULL,
    date_id           INT                                                                                    NOT NULL,
    FOREIGN KEY (date_id) REFERENCES dates (id)

);





