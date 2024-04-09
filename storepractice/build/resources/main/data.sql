--INSERCION DE CATEGORIAS
INSERT INTO categories(id, name, description, created_at, updated_at, created_by, updated_by) VALUES('69975a16-0e4f-4088-a2ab-2d2d22843e7f', 'OF WOOD', ' product that was made with high quality recicled wood...', '2024-04-05T15:05:25.763-04:00', '2024-04-05 15:05:25.763','user@gmail.com','user@gmail.com');
INSERT INTO categories(id, name, description, created_at, updated_at, created_by, updated_by) VALUES('34a3dd57-e3c7-4406-8e0c-f3c541e12eba', 'OF CRISTAL', ' product that was made with high quality recicled CRISTAL...', '2024-04-05T15:05:25.763-04:00', '2024-04-05 15:05:25.763','user1@gmail.com','user1@gmail.com');
INSERT INTO categories(id, name, description, created_at, updated_at, created_by, updated_by) VALUES('11fb7e1e-b9e9-461f-9a68-17d5f3e7d213', 'OF ROCK', ' product that was made with high quality recicled ROCKS...', '2024-04-05T15:05:25.763-04:00', '2024-04-05 15:05:25.763','user2@gmail.com','user2@gmail.com');
INSERT INTO categories(id, name, description, created_at, updated_at, created_by, updated_by) VALUES('30706c36-a29b-46a6-80ab-5683b447f981', 'OF PLASTIC', ' product that was made with high quality recicled PLASTICS...', '2024-04-05T15:05:25.763-04:00', '2024-04-05 15:05:25.763','user3@gmail.com','user3@gmail.com');



--INSERT INTO products(id, name, description, stock, price, active, created_at, updated_at, created_by, updated_by) VALUES

--INSERCION DE PRODUCTOS
INSERT INTO products(id, name, description, stock, price, active, created_at, updated_at, created_by, updated_by, category_id)
VALUES
    ('f527b1dc-6d79-4eae-85d3-49174f754bb1', 'Producto 1', 'Descripción del producto 1', 100, 25.99, true, '2024-04-05 10:00:00', '2024-04-05 10:00:00', 'User1', 'User1','69975a16-0e4f-4088-a2ab-2d2d22843e7f'),
    ('a13bf89c-7d94-4b0d-b267-2c1e5972e46e', 'Producto 2', 'Descripción del producto 2', 50, 39.99, true, '2024-04-05 10:00:00', '2024-04-05 10:00:00', 'User2', 'User2', '69975a16-0e4f-4088-a2ab-2d2d22843e7f'),
    ('d6f2d47d-ef84-4f1c-bc6e-6d87a5403f52', 'Producto 3', 'Descripción del producto 3', 200, 19.99, true, '2024-04-05 10:00:00', '2024-04-05 10:00:00', 'User3', 'User3', '69975a16-0e4f-4088-a2ab-2d2d22843e7f');


--INSERCION STORE
INSERT INTO stores(id, name, address, city, opening_hours, created_at, updated_at, created_by, updated_by)
VALUES
    ('2a7f5041-39ee-4a6d-8c7b-95e5f8940e34', 'Tienda 1', 'Direccion de la tienda 1', 'Ciudad 1', 'Horario de apertura 1', '2024-04-05 10:00:00', '2024-04-05 10:00:00', 'User1', 'User1'),
    ('847c2d67-4780-4a6e-b33d-8f5d21e5f8c1', 'Tienda 2', 'Direccion de la tienda 2', 'Ciudad 2', 'Horario de apertura 2', '2024-04-06 10:00:00', '2024-04-06 10:00:00', 'User2', 'User2'),
    ('fe8c6b34-b1a7-4c8f-8923-7b8475d4b2f5', 'Tienda 3', 'Direccion de la tienda 3', 'Ciudad 3', 'Horario de apertura 3', '2024-04-07 10:00:00', '2024-04-07 10:00:00', 'User3', 'User3');

--INSERCION ORDERS
INSERT INTO orders(id, name, date, shipping_address, delivery, created_at, updated_at, created_by, updated_by, store_id)
VALUES
    ('3c7f240b-8039-4d8c-944b-f59f8fe75052', 'Pedido 1', '2024-04-05', 'Direccion de envio 1', true, '2024-04-05 10:00:00', '2024-04-05 10:00:00', 'User1', 'User1', '2a7f5041-39ee-4a6d-8c7b-95e5f8940e34'),
    ('3c7f240b-8039-4d8c-944b-f59f8fe75053', 'Pedido 2', '2024-04-06', 'Direccion de envio 2', false, '2024-04-06 10:00:00', '2024-04-06 10:00:00', 'User2', 'User2','847c2d67-4780-4a6e-b33d-8f5d21e5f8c1'),
    ('f527b1dc-6d79-4eae-85d3-49174f754bb2', 'Pedido 3', '2024-04-07', 'Direccion de envio 3', true, '2024-04-07 10:00:00', '2024-04-07 10:00:00', 'User3', 'User3','fe8c6b34-b1a7-4c8f-8923-7b8475d4b2f5');



--INSERCION ORDERDETAILS
INSERT INTO order_details(id, quantity, product_id, order_id)
VALUES
    ('f527b1dc-6d79-4eae-85d3-49174f754bb1', 2, 'f527b1dc-6d79-4eae-85d3-49174f754bb1', '3c7f240b-8039-4d8c-944b-f59f8fe75052'),
    ('a13bf89c-7d94-4b0d-b267-2c1e5972e46e', 1, 'a13bf89c-7d94-4b0d-b267-2c1e5972e46e', '3c7f240b-8039-4d8c-944b-f59f8fe75052'),
    ('d6f2d47d-ef84-4f1c-bc6e-6d87a5403f52', 3, 'd6f2d47d-ef84-4f1c-bc6e-6d87a5403f52', 'f527b1dc-6d79-4eae-85d3-49174f754bb2'),
    ('f527b1dc-6d79-4eae-85d3-49174f754bb2', 1, 'f527b1dc-6d79-4eae-85d3-49174f754bb1', '3c7f240b-8039-4d8c-944b-f59f8fe75052'),
    ('a13bf89c-7d94-4b0d-b267-2c1e5972e46f', 2, 'a13bf89c-7d94-4b0d-b267-2c1e5972e46e', '3c7f240b-8039-4d8c-944b-f59f8fe75053'),
    ('d6f2d47d-ef84-4f1c-bc6e-6d87a5403f53', 1, 'd6f2d47d-ef84-4f1c-bc6e-6d87a5403f52', 'f527b1dc-6d79-4eae-85d3-49174f754bb2');



