-- Ensure the 'pet' table exists
CREATE TABLE IF NOT EXISTS pet
(
    id              UUID PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    type            VARCHAR(255) NOT NULL,
    breed           VARCHAR(255) NOT NULL,
    date_of_birth   DATE NOT NULL,
    registered_date DATE NOT NULL
    );

-- Insert well-known UUIDs for specific pets
INSERT INTO pet (id, name, type, breed, date_of_birth, registered_date)
SELECT '323e4567-e89b-12d3-a456-426614174000',
       'Buddy',
       'Dog',
       'Golden Retriever',
       '2018-04-12',
       '2024-01-05'
    WHERE NOT EXISTS (SELECT 1 FROM pet WHERE id = '323e4567-e89b-12d3-a456-426614174000');

INSERT INTO pet (id, name, type, breed, date_of_birth, registered_date)
SELECT '323e4567-e89b-12d3-a456-426614174001',
       'Mittens',
       'Cat',
       'Siamese',
       '2020-09-01',
       '2023-11-20'
    WHERE NOT EXISTS (SELECT 1 FROM pet WHERE id = '323e4567-e89b-12d3-a456-426614174001');

INSERT INTO pet (id, name, type, breed, date_of_birth, registered_date)
SELECT '323e4567-e89b-12d3-a456-426614174002',
       'Charlie',
       'Dog',
       'Beagle',
       '2017-06-22',
       '2022-08-15'
    WHERE NOT EXISTS (SELECT 1 FROM pet WHERE id = '323e4567-e89b-12d3-a456-426614174002');

INSERT INTO pet (id, name, type, breed, date_of_birth, registered_date)
SELECT '323e4567-e89b-12d3-a456-426614174003',
       'Luna',
       'Cat',
       'Maine Coon',
       '2019-11-03',
       '2023-02-10'
    WHERE NOT EXISTS (SELECT 1 FROM pet WHERE id = '323e4567-e89b-12d3-a456-426614174003');

INSERT INTO pet (id, name, type, breed, date_of_birth, registered_date)
SELECT '323e4567-e89b-12d3-a456-426614174004',
       'Max',
       'Dog',
       'German Shepherd',
       '2016-01-15',
       '2024-03-08'
    WHERE NOT EXISTS (SELECT 1 FROM pet WHERE id = '323e4567-e89b-12d3-a456-426614174004');

INSERT INTO pet (id, name, type, breed, date_of_birth, registered_date)
SELECT '323e4567-e89b-12d3-a456-426614174005',
       'Coco',
       'Bird',
       'Parrot',
       '2021-05-30',
       '2024-04-18'
    WHERE NOT EXISTS (SELECT 1 FROM pet WHERE id = '323e4567-e89b-12d3-a456-426614174005');

INSERT INTO pet (id, name, type, breed, date_of_birth, registered_date)
SELECT '323e4567-e89b-12d3-a456-426614174006',
       'Bella',
       'Dog',
       'Bulldog',
       '2015-12-20',
       '2023-07-25'
    WHERE NOT EXISTS (SELECT 1 FROM pet WHERE id = '323e4567-e89b-12d3-a456-426614174006');

INSERT INTO pet (id, name, type, breed, date_of_birth, registered_date)
SELECT '323e4567-e89b-12d3-a456-426614174007',
       'Oliver',
       'Cat',
       'Persian',
       '2018-08-11',
       '2022-09-30'
    WHERE NOT EXISTS (SELECT 1 FROM pet WHERE id = '323e4567-e89b-12d3-a456-426614174007');

INSERT INTO pet (id, name, type, breed, date_of_birth, registered_date)
SELECT '323e4567-e89b-12d3-a456-426614174008',
       'Rocky',
       'Dog',
       'Labrador',
       '2014-03-05',
       '2023-05-12'
    WHERE NOT EXISTS (SELECT 1 FROM pet WHERE id = '323e4567-e89b-12d3-a456-426614174008');

INSERT INTO pet (id, name, type, breed, date_of_birth, registered_date)
SELECT '323e4567-e89b-12d3-a456-426614174009',
       'Nala',
       'Cat',
       'Ragdoll',
       '2019-07-18',
       '2024-02-22'
    WHERE NOT EXISTS (SELECT 1 FROM pet WHERE id = '323e4567-e89b-12d3-a456-426614174009');
