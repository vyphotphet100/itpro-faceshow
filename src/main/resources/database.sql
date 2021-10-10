INSERT INTO user(username, password, full_name, address, phone, status, token)
VALUES ('user1', '123456', 'Nguyen Van A', 'TPHCM', '0123456789', 'OFFLINE', 'adfasdfasdfasdfsdfabc123'),
       ('user2', '123456', 'Dinh Thi B', 'Quang Binh', '0123456789', 'ONLINE', 'adfasdfasdfasdfsdf123abc'),
       ('user3', '123456', 'Cao Van C', 'Can Tho', '0123456789', 'BUSY', 'adfasdfasdfasdfsdf345abc');

INSERT INTO room(`host_username`, `name`, `hidden_password`)
VALUES ('user1', 'Phòng 1', '12345678_1'),
       ('user1', 'Phòng 2', '12345678_2'),
       ('user2', 'Phòng 3', '12345678_3'),
       ('user2', 'Phòng 4', '12345678_4'),
       ('user3', 'Phòng 5', '12345678_5'),
       ('user3', 'Phòng 6', '12345678_6'),
       ('user3', 'Phòng 7', '12345678_7');

INSERT INTO join_user_room(`username`, `room_id`)
VALUES ('user2', 5),
       ('user2', 2),
       ('user3', 1),
       ('user3', 4);

INSERT INTO message(`username`, `room_id`, `content`)
VALUES ('user1', 1, 'xin chào, tôi là user1.'),
       ('user1', 2, 'xin chào phòng số 2'),
       ('user2', 5, 'xin chào phòng số 5'),
       ('user2', 2, 'xin chào phòng số 2'),
       ('user3', 5, 'xin chào phòng số 5'),
       ('user3', 1, 'rất vui được làm quen với user1'),
       ('user3', 4, 'xin chào phòng số 4');


