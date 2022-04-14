INSERT INTO public.keyword (id, name) VALUES (DEFAULT, 'zombi');
INSERT INTO public.keyword (id, name) VALUES (DEFAULT, 'erotica');
INSERT INTO public.keyword (id, name) VALUES (DEFAULT, 'sci-fi');
INSERT INTO public.keyword (id, name) VALUES (DEFAULT, 'travel');
INSERT INTO public.author (id, first_name, last_name) VALUES (DEFAULT, 'Antoni Horatio', 'Banderas');
INSERT INTO public.author (id, first_name, last_name) VALUES (DEFAULT, 'Maizi', 'Pulk');
INSERT INTO public.book (id, title, year) VALUES (DEFAULT, 'Code Smell', 2008);
INSERT INTO public.book (id, title, year) VALUES (DEFAULT, 'Harry Potter', 2005);
INSERT INTO public.book_author (id, book_id, author_id) VALUES (DEFAULT, 1, 2);
INSERT INTO public.book_author (id, book_id, author_id) VALUES (DEFAULT, 1, 1);
INSERT INTO public.book_author (id, book_id, author_id) VALUES (DEFAULT, 2, 2);
INSERT INTO public.book_keyword (id, book_id, keyword_id) VALUES (DEFAULT, 2, 1);
INSERT INTO public.book_keyword (id, book_id, keyword_id) VALUES (DEFAULT, 2, 2);