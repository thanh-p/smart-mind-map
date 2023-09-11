insert into role(id, name)
values(1,'ROLE_USER');
insert into role(id, name)
values(2,'ROLE_ADMIN');

insert into user_detail
(id, email, password, username)
values(1,'bhm.rb27@gmail.com', '$2a$10$13jwXkm5XMZBZM3rh9IoROU1sgVtS5FgdkLwuKr6UwFy48o57PQ2e', 'bhm27');
insert into user_detail
(id, email, password, username)
values(2,'thanhphamsn@gmail.com', '$2a$10$13jwXkm5XMZBZM3rh9IoROU1sgVtS5FgdkLwuKr6UwFy48o57PQ2e', 'thanh');

insert into user_role
(user_id, role_id)
values(1, 1);

insert into user_role
(user_id, role_id)
values(2, 2);