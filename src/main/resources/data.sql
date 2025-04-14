insert into user_details (id, name, birth_date) values (10001, 'Ronald Pieterse', current_date());
insert into user_details (id, name, birth_date) values (10002, 'Alexandra Verlaan', current_date());
insert into user_details (id, name, birth_date) values (10003, 'Jonne Pieterse', current_date());
insert into user_details (id, name, birth_date) values (10004, 'Morris de Vlas', current_date());

insert into posts (id, description, user_id) 
values (20001, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a diam lectus, congue varius', 10001);
insert into posts (id, description, user_id) 
values (20002, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a diam lectus, congue varius', 10001);
insert into posts (id, description, user_id) 
values (20003, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a diam lectus, congue varius', 10002);
insert into posts (id, description, user_id) 
values (20004, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a diam lectus, congue varius', 10002);
insert into posts (id, description, user_id) 
values (20005, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a diam lectus, congue varius', 10003);