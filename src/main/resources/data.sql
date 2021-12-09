insert IGNORE into actor (id, last_name, name) values
(1, 'Hamill', 'Mark'),
(2, 'Fisher', 'Carrie'),
(3, 'McGregor', 'Ewan'),
(4, 'Christensen', 'Hayden'),
(5, 'Strong', 'Mark');

insert IGNORE into movie (id, name, ranking) values
(1, 'Start Wars: Episode 4', 8),
(2, 'Start Wars: Episode 3', 9),
(3, '1917', 9);

insert IGNORE into movie_actor(movie_id, actor_id) values (1, 1);
insert IGNORE into movie_actor(movie_id, actor_id) values (1, 2);
insert IGNORE into movie_actor(movie_id, actor_id) values (2, 3);
insert IGNORE into movie_actor(movie_id, actor_id) values (2, 4);
insert IGNORE into movie_actor(movie_id, actor_id) values (3, 5);

insert IGNORE into review (id, comment, username, movie_id) VALUES
(1, 'Genial', 'uno', 1),
(2, 'Buenisima', 'dos', 1),
(3, 'Genial', 'uno', 2),
(4, 'Buenisima', 'dos', 2),
(5, 'Buenisima', 'dos', 3)
;