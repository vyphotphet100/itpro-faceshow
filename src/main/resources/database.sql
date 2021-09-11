INSERT INTO user(username, password, full_name, address, phone, status)
VALUES ('user1', '123456', 'Nguyen Van A', 'TPHCM', '0123456789', 'OFFLINE'),
       ('user2', '123456', 'Dinh Thi B', 'Quang Binh', '0123456789', 'ONLINE'),
       ('user3', '123456', 'Cao Van C', 'Can Tho', '0123456789', 'BUSY');

INSERT INTO room(host_username)
VALUES ('user1'),
       ('user1'),
       ('user2'),
       ('user2'),
       ('user3'),
       ('user3'),
       ('user3');


