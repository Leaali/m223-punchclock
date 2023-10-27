-- Generiert durch ChatCPT

-- Testdaten für Category
INSERT INTO category (title) VALUES
    ('Kategorie 1'),
    ('Kategorie 2'),
    ('Kategorie 3');

-- Testdaten für Entry
INSERT INTO applicationuser (email, password, nickname) VALUES
    ('test1@test.ch', 'secret', 'test1'),
    ('test2@test.ch', 'secret', 'test2'),
    ('test3@test.ch', 'secret', 'test3');

-- Testdaten für Entry
INSERT INTO entry (checkIn, checkOut, category_id, applicationuser_id) VALUES
    ('2023-10-26 09:00:00', '2023-10-26 17:00:00', 1, 1),
    ('2023-10-26 10:00:00', '2023-10-26 18:00:00', 2, 1),
    ('2023-10-26 11:00:00', '2023-10-26 19:00:00', 1, 2);

-- Testdaten für Tag
INSERT INTO tag (title) VALUES
    ('Tag 1'),
    ('Tag 2'),
    ('Tag 3');

-- Beziehungen zwischen Entry und Tag
INSERT INTO entry_tag (entry_id, tag_id) VALUES
    (1, 1),
    (2, 2),
    (3, 1),
    (3, 3); 
