INSERT INTO House (id, version, address) VALUES (1, 0, 'ул.Цюрупы, 16');

INSERT INTO House (id, version, address) VALUES (2, 0, 'ул.Лунина, 7');

INSERT INTO Person (id, version, first_name, age) VALUES (1, 0, 'Пётр', 20);

INSERT INTO Person (id, version, first_name, age) VALUES (2, 0, 'John', 25);

INSERT INTO Person_House (person_id, house_id) VALUES (1, 1);

INSERT INTO Person_House (person_id, house_id) VALUES (1, 2);


INSERT INTO Country (version, country_name, country_code) VALUES (0, 'Россия', 643);

INSERT INTO Country (version, country_name, country_code) VALUES (0, 'США', 840);

INSERT INTO Country (version, country_name, country_code) VALUES (0, 'Украина', 804);

INSERT INTO Country (version, country_name, country_code) VALUES (0, 'Беларусь', 112);

INSERT INTO Country (version, country_name, country_code) VALUES (0, 'Германия', 276);

INSERT INTO Country (version, country_name, country_code) VALUES (0, 'Кипр', 196);

INSERT INTO Country (version, country_name, country_code) VALUES (0, 'Китай', 156);


INSERT INTO Doc_type (version, doc_name, doc_number) VALUES (0, 'Свидетельство о рождении', '03');

INSERT INTO Doc_type (version, doc_name, doc_number) VALUES (0, 'Военный билет', '07');

INSERT INTO Doc_type (version, doc_name, doc_number) VALUES (0, 'Временное удостоверение, выданное взамен военного билета', '08');

INSERT INTO Doc_type (version, doc_name, doc_number) VALUES (0, 'Паспорт иностранного гражданина', '10');

INSERT INTO Doc_type (version, doc_name, doc_number) VALUES (0, 'Свидетельство о рассмотрении ходатайства о признании лица
беженцем на территории Российской Федерации по существу', '11');

INSERT INTO Doc_type (version, doc_name, doc_number) VALUES (0, 'Вид на жительство в Российской Федерации', '12');

INSERT INTO Doc_type (version, doc_name, doc_number) VALUES (0, 'Удостоверение беженца', '13');

INSERT INTO Doc_type (version, doc_name, doc_number) VALUES (0, 'Разрешение на временное проживание в Российской Федерации', '15');

INSERT INTO Doc_type (version, doc_name, doc_number) VALUES (0, 'Свидетельство о предоставлении временного убежища на территории
Российской Федерации', '18');

INSERT INTO Doc_type (version, doc_name, doc_number) VALUES (0, 'Паспорт гражданина Российской Федерации', '21');

INSERT INTO Doc_type (version, doc_name, doc_number) VALUES (0, 'Свидетельство о рождении, выданное уполномоченным органом
иностранного государства', '23');

INSERT INTO Doc_type (version, doc_name, doc_number) VALUES (0, 'Удостоверение личности военнослужащего Российской Федерации', '24');

INSERT INTO Doc_type (version, doc_name, doc_number) VALUES (0, 'Иные документы', '91');