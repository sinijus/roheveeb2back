INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'company');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'customer');

INSERT INTO public."user" (id, role_id, email, password, status) VALUES (DEFAULT, 1, 'admin', '123', 'A');
INSERT INTO public."user" (id, role_id, email, password, status) VALUES (DEFAULT, 3, 'rain', '123', 'A');
INSERT INTO public."user" (id, role_id, email, password, status) VALUES (DEFAULT, 2, 'Mulgi mahetalu', '123', 'A');

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

INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Juurviljad ja köögiviljad');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Puubiljad');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Marjad');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Rohelised salatid');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Maitsetaimed');

INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 1, 'kartul');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 1, 'porgand');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 1, 'brokoli');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 1, 'kõrvits');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 1, 'sibul');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 1, 'küüslauk');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 1, 'tomat');
INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, 1, 'kurk');
-- INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, DEFAULT, 'pirn');
-- INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, DEFAULT, 'õun');
-- INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, DEFAULT, 'ploom');
-- INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, DEFAULT, 'vaarikas');
-- INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, DEFAULT, 'maasikas');
-- INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, DEFAULT, 'kultuurmustikas');
-- INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, DEFAULT, 'rucola');
-- INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, DEFAULT, 'võisalat');
-- INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, DEFAULT, 'jääsalat');
-- INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, DEFAULT, 'tüümian');
-- INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, DEFAULT, 'rosmariin');
-- INSERT INTO public.type (id,category_id, name) VALUES (DEFAULT, DEFAULT, 'till');

INSERT INTO public.measure_unit (id, name) VALUES (DEFAULT, 'g');
INSERT INTO public.measure_unit (id, name) VALUES (DEFAULT, 'kg');
INSERT INTO public.measure_unit (id, name) VALUES (DEFAULT, 'tk');






