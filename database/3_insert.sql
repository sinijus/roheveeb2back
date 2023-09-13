INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'company');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'customer');

INSERT INTO public."user" (id, role_id, email, password, status) VALUES (DEFAULT, 1, 'admin', '123', 'A');
INSERT INTO public."user" (id, role_id, email, password, status) VALUES (DEFAULT, 3, 'klient', '123', 'A');
INSERT INTO public."user" (id, role_id, email, password, status) VALUES (DEFAULT, 2, 'talu', '123', 'A');
INSERT INTO public."user" (id, role_id, email, password, status) VALUES (DEFAULT, 2, 'hiiu@talu.ee', '123', 'A');

INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Harjumaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Läänemaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Raplamaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Järvamaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Jõgevamaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Lääne-Virumaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Ida-Virumaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Hiiumaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Saaremaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Pärnumaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Viljandimaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Tartumaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Valgamaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Põlvamaa');
INSERT INTO public.county (id, name) VALUES (DEFAULT, 'Võrumaa');


INSERT INTO public.location (id, county_id, address, postal_code) VALUES (DEFAULT, 8, 'Keskväljak 5A, Kärdla', '92414');
INSERT INTO public.location (id, county_id, address, postal_code) VALUES (DEFAULT, 11, 'Posti 27, Mustla', '69701');
INSERT INTO public.location (id, county_id, address, postal_code) VALUES (DEFAULT, 1, 'Lühike jalg 9, Tallinn', '10130');
INSERT INTO public.location (id, county_id, address, postal_code) VALUES (DEFAULT, 8, 'Keskväljak 5A, Kärdla', '92414');

INSERT INTO public.company (id, user_id, location_id, logo_image_id, name, phone_number, register_code, iban)
VALUES (DEFAULT, 4, 1, null, 'Hiiu mahetalu', '55666777',  '10125090', 'EE909999665544335567');
INSERT INTO public.company (id, user_id, location_id, logo_image_id, name, phone_number, register_code, iban)
VALUES (DEFAULT, 2, 2, null, 'Mulgi mahetalu', '52000111',  '10127340', 'EE909999665000005567');


INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Juurviljad ja köögiviljad');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Puuviljad');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Marjad');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Rohelised salatid');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Maitsetaimed');

INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 1, 'kartul');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 1, 'porgand');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 1, 'lillkapsas');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 1, 'kõrvits');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 1, 'sibul');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 1, 'küüslauk');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 1, 'tomat');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 1, 'kurk');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 2, 'pirn');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 2, 'õun');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 2, 'ploom');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 3, 'vaarikas');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 3, 'maasikas');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 3, 'kultuurmustikas');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 4, 'rucola');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 4, 'võisalat');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 4, 'jääsalat');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 5, 'tüümian');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 5, 'rosmariin');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 5, 'till');

INSERT INTO public.measure_unit (id, name) VALUES (DEFAULT, 'g');
INSERT INTO public.measure_unit (id, name) VALUES (DEFAULT, 'kg');
INSERT INTO public.measure_unit (id, name) VALUES (DEFAULT, 'tk');

INSERT INTO public.product (id, company_id, type_id, image_id, name, price, stock_balance, measure_unit_id, status)
VALUES (DEFAULT, 2, 1, null, 'Kartul Gala 20 kg', 15, 4, 3, 'A');
INSERT INTO public.product (id, company_id, type_id, image_id, name, price, stock_balance, measure_unit_id, status)
VALUES (DEFAULT, 1, 3, null,'Lilla lillkapsas "Di Violetto"', 3.90, 3000, 1, 'A');
INSERT INTO public.product (id, company_id, type_id, image_id, name, price, stock_balance, measure_unit_id, status)
VALUES (DEFAULT, 2, 2, null, 'Hiline porgand "Berlicum 2', 1.50, 10, 2, 'A');

INSERT INTO public.transport (id, method, fee) VALUES (DEFAULT, 'DPD pakiautomaat', 3.50);
INSERT INTO public.transport (id, method, fee) VALUES (DEFAULT, 'Omniva pakiautomaat', 3.20);

INSERT INTO public.payment (id, method, bank_logo_id) VALUES (DEFAULT, 'LHV', NULL)





