-- Insert sample data into the product table
-- This file will be automatically executed by Spring Boot on application startup

INSERT INTO product (name, description, brand, price, category, release_date, product_available, stock_quantity) VALUES
('iPhone 15 Pro', 'Latest Apple smartphone with advanced camera system', 'Apple', 999.99, 'Smartphones', '2024-09-15', true, 50),
('Samsung Galaxy S24', 'Flagship Android phone with AI features', 'Samsung', 899.99, 'Smartphones', '2024-01-17', true, 75),
('MacBook Pro 16"', 'Powerful laptop for professionals', 'Apple', 2499.99, 'Laptops', '2023-10-30', true, 25),
('Dell XPS 13', 'Ultra-portable laptop with premium build', 'Dell', 1299.99, 'Laptops', '2024-02-15', true, 40),
('Sony WH-1000XM5', 'Industry-leading noise canceling headphones', 'Sony', 349.99, 'Headphones', '2023-11-20', true, 100),
('AirPods Pro', 'Wireless earbuds with active noise cancellation', 'Apple', 249.99, 'Headphones', '2022-09-23', true, 150),
('iPad Air', 'Versatile tablet for work and creativity', 'iPad', 599.99, 'Tablets', '2024-05-15', true, 60),
('Samsung Galaxy Tab S9', 'Premium Android tablet with S Pen', 'Samsung', 799.99, 'Tablets', '2024-08-11', true, 35),
('Nintendo Switch OLED', 'Handheld gaming console with OLED display', 'Nintendo', 349.99, 'Gaming', '2023-10-08', true, 80),
('PlayStation 5', 'Next-generation gaming console', 'Sony', 499.99, 'Gaming', '2020-11-12', false, 0),
('Canon EOS R5', 'Professional mirrorless camera', 'Canon', 3899.99, 'Cameras', '2020-07-09', true, 15),
('GoPro HERO11', 'Action camera for adventure sports', 'GoPro', 399.99, 'Cameras', '2023-09-22', true, 45),
('Apple Watch Series 9', 'Advanced smartwatch with health features', 'Apple', 399.99, 'Wearables', '2023-09-12', true, 90),
('Fitbit Charge 6', 'Fitness tracker with heart rate monitoring', 'Fitbit', 149.99, 'Wearables', '2023-09-28', true, 120),
('Amazon Echo Dot', 'Smart speaker with Alexa', 'Amazon', 49.99, 'Smart Home', '2022-10-14', true, 200),
('Google Nest Hub', 'Smart display for home control', 'Google', 129.99, 'Smart Home', '2022-06-22', true, 85);