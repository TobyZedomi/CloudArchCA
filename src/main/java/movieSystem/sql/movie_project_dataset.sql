INSERT INTO `users` (`username`, `displayName`, `email`, `password`, `dateOfBirth`, `isAdmin`, `createdAt`, `user_image`)
VALUES ('admin', 'adminUser123', 'tobyzedo7@gmail.com', '$2a$12$x4EwpUD5VU.vJW1.xICz1OnEJqEMfdYx/ttl/Gi/JxljZAsguzqbi', '2003-02-16', true, '2025-01-30 00:00:00','DefaultUserImage.jpg'),
       ('Andrew', 'andrewGamer123', 'andrew@gmail.com', '$2a$12$x4EwpUD5VU.vJW1.xICz1OnEJqEMfdYx/ttl/Gi/JxljZAsguzqbi', '2000-12-10', false, '2025-01-30 00:00:00','DefaultUserImage.jpg'),
       ('Toby', 'toby123', 'toby@gmail.com', '$2a$12$x4EwpUD5VU.vJW1.xICz1OnEJqEMfdYx/ttl/Gi/JxljZAsguzqbi',  '2001-12-08', false, '2025-01-30 00:00:00','DefaultUserImage.jpg'),
       ('Kate', 'kate123', 'kate@gmail.com', '$2a$12$x4EwpUD5VU.vJW1.xICz1OnEJqEMfdYx/ttl/Gi/JxljZAsguzqbi',  '2001-12-08', false, '2025-01-30 00:00:00','DefaultUserImage.jpg'),
       ('James', 'james123', 'james@gmail.com', '$2a$12$x4EwpUD5VU.vJW1.xICz1OnEJqEMfdYx/ttl/Gi/JxljZAsguzqbi', '1999-11-18', false, '2025-01-30 00:00:00','DefaultUserImage.jpg'),
       ('Alice','Alice','alicecunninghammorgan@hotmail.com','$2a$12$x4EwpUD5VU.vJW1.xICz1OnEJqEMfdYx/ttl/Gi/JxljZAsguzqbi','200-11-13',false,'2025-03-03 23:24:22','DefaultUserImage.jpg'),
       ('Kevin','Kevin','Kevin@gmail.com','$2a$12$x4EwpUD5VU.vJW1.xICz1OnEJqEMfdYx/ttl/Gi/JxljZAsguzqbi','2003-11-13',true,'2025-03-03 18:26:25','DefaultUserImage.jpg');


INSERT INTO `genre` (`id`, `name`)
VALUES (28, 'Action'),
       (12, 'Adventure'),
       (16, 'Animation'),
       (35, 'Comedy'),
       (80, 'Crime'),
       (99, 'Documentary'),
       (18, 'Drama'),
       (10751, 'Family'),
       (14, 'Fantasy'),
       (36, 'History'),
       (27, 'Horror'),
       (10402, 'Music'),
       (9648, 'Mystery'),
       (10749, 'Romance'),
       (878, 'Science Fiction'),
       (10770, 'TV Movie'),
       (53, 'Thriller'),
       (10752, 'War'),
       (37, 'Western');