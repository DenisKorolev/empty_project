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


INSERT INTO Organization (org_id, version, org_name, org_full_name, org_inn, kpp, org_address, org_phone, is_active)
  VALUES (1, 0, 'Гугл', 'ООО Гугл', '12345', '57821', 'ул. Пушкина, д. К.', '+791294343', TRUE);

INSERT INTO Organization VALUES (2, 0, 'Майки', 'ООО Майки', '1235745', '5067521', 'ул. Новомостовая, 5', '+791434343', TRUE);

INSERT INTO Organization VALUES (3, 0, 'Яблоко', 'ООО Яблоко', '143435745', '565767521', 'ул. Центральная, 109', '+7915321743', TRUE);

INSERT INTO Organization VALUES (4, 0, 'РиК', 'Рога и копыта', '141745745', '137756752', 'ул. Тёмная, 1', '+79156548743', FALSE);


INSERT INTO Office (office_id, version, org_id, office_address, office_name, office_phone, is_office_active)
  VALUES (1, 0, 2, 'ул. Новая, 45', 'Единственный офис', '+793461375', TRUE);

INSERT INTO Office VALUES (2, 0, 3, 'ул. Большая, 67', 'Первый яблочный офис', '+7935878715', TRUE);

INSERT INTO Office VALUES (3, 0, 3, 'ул. Ахметова, 300', 'Второй яблочный офис', '+7934587215', TRUE);

INSERT INTO Office VALUES (4, 0, 3, 'ул. Камская, 75', 'Закрытый яблочный офис', '+7934874115', FALSE);

INSERT INTO Office VALUES (5, 0, 4, 'ул. Тёмная, 666', 'РиК', '+7934874115', FALSE);