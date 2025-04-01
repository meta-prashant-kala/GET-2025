USE storeFront;

-- Insert sample data in StoreFront tables by using SQL files.
INSERT INTO category (ParentCategoryID, CategoryID, CategoryName, CategoryDesc)
VALUES 
(NULL, 1, 'Electronics', 'Electronic items'),
(NULL, 2, 'Clothing', 'Fashionable apparel'),
(NULL, 3, 'Home', 'Home decor and essentials'),
(1, 4, 'Mobiles', 'Smartphones and accessories'),
(1, 5, 'Computers', 'Laptops and accessories'),
(3, 6, 'Furniture', 'Comfortable furniture'),
(3, 7, 'Kitchen', 'Kitchen appliances'),
(2, 8, 'Men', 'Men’s clothing and accessories'),
(2, 9, 'Women', 'Women’s clothing and accessories'),
(2, 10, 'Kids', 'Kids’ clothing and toys'),
(3, 11, 'Outdoor', 'Outdoor gear and essentials'),
(3, 12, 'Garden', 'Gardening tools and decor'),
(3, 13, 'Bedding', 'Bedsheets and mattresses'),
(NULL, 14, 'Books', 'Books and stationery'),
(1, 15, 'Gaming', 'Gaming consoles and accessories'),
(NULL, 16, 'Automotive', 'Car and bike accessories'),
(16, 17, 'Car Care', 'Car cleaning tools and materials'),
(16, 18, 'Bike Gear', 'Gear and accessories for bikers'),
(3, 19, 'Health', 'Health and wellness equipment'),
(3, 20, 'Beauty', 'Beauty and skincare products'),
(1, 21, 'Accessories', 'Phone and laptop accessories'),
(NULL, 22, 'Toys', 'Toys and games for all ages'),
(1, 23, 'Cameras', 'Photography gear and cameras'),
(6, 24, 'Office', 'Office supplies and furniture'),
(15, 25, 'PC Gaming', 'PC components for gaming'),
(5, 26, 'Storage', 'Hard drives and memory cards'),
(NULL, 27, 'Sports', 'Sports gear and fitness equipment'),
(27, 28, 'Football', 'Football gear and supplies'),
(27, 29, 'Cricket', 'Cricket kits and accessories'),
(27, 30, 'Swimming', 'Swimming equipment'),
(3, 31, 'Lighting', 'Home and decorative lighting'),
(15, 32, 'VR Gaming', 'Virtual reality headsets and games'),
(NULL, 33, 'Music', 'Musical instruments and gear'),
(33, 34, 'Guitars', 'Acoustic and electric guitars'),
(33, 35, 'Keyboards', 'Pianos and keyboards'),
(33, 36, 'Drums', 'Percussion instruments'),
(NULL, 37, 'Pets', 'Pet care and accessories'),
(NULL, 38, 'Groceries', 'Daily essentials and groceries'),
(NULL, 39, 'Beverages', 'Tea, coffee, and beverages'),
(38, 40, 'Snacks', 'Chips and confectionery'),
(38, 41, 'Bakery', 'Bread and baked goods'),
(NULL, 42, 'Travel', 'Luggage and travel essentials'),
(NULL, 43, 'Stationery', 'School and office stationery'),
(NULL, 44, 'Art', 'Art supplies and equipment'),
(NULL, 45, 'Tools', 'Hardware and tools'),
(NULL, 46, 'Baby', 'Baby care and essentials'),
(NULL, 47, 'DIY', 'DIY crafts and kits'),
(NULL, 48, 'Fitness', 'Exercise machines and weights'),
(NULL, 49, 'Cleaning', 'Cleaning supplies and equipment'),
(NULL, 50, 'Software', 'Software and licenses');

-- Insert data into the updated 'product' table with some products inactive
INSERT INTO product (ProductID, CategoryID, ProductName, ProductDesc, ProductPrice, ProductStock, isActive, CreatedAt)
VALUES
(101, 4, 'iPhone', 'Apple iPhone 13', 70000, 50, TRUE, '2025-03-20'),
(102, 5, 'Laptop', 'Gaming Laptop', 85000, 30, TRUE, '2025-03-21'),
(103, 7, 'Blender', 'High-speed blender', 4000, 90, TRUE, '2025-03-22'),
(104, 6, 'Chair', 'Ergonomic office chair', 15000, 35, FALSE, '2025-03-23'),
(105, 8, 'Sneakers', 'Running shoes', 3000, 180, TRUE, '2025-03-24'),
(106, 9, 'Dress', 'Evening gown', 2000, 150, TRUE, '2025-03-25'),
(107, 10, 'Toy Car', 'Remote-controlled car', 1200, 80, FALSE, '2025-03-26'),
(108, 1, 'SmartTV', '55-inch 4K Smart TV', 45000, 40, TRUE, '2025-03-27'),
(109, 3, 'Table', 'Wooden dining table set', 30000, 25, TRUE, '2025-03-28'),
(110, 15, 'Console', 'Gaming console', 50000, 60, FALSE, '2025-03-29'),
(111, 22, 'Game', 'Board game', 1500, 100, TRUE, '2025-03-30'),
(112, 16, 'CarCover', 'Waterproof car cover', 3000, 50, TRUE, '2025-03-31'),
(113, 17, 'Helmet', 'Safety helmet for bikes', 2000, 75, TRUE, '2025-04-01'),
(114, 2, 'Jeans', 'Denim jeans', 1200, 180, TRUE, '2025-04-02'),
(115, 6, 'Bookshelf', 'Wooden bookshelf', 8000, 20, FALSE, '2025-04-03'),
(116, 27, 'Racket', 'Professional tennis racket', 5000, 90, TRUE, '2025-04-04'),
(117, 28, 'Football', 'Official-size football', 1500, 120, FALSE, '2025-04-05'),
(118, 19, 'YogaMat', 'Non-slip yoga mat', 1000, 200, TRUE, '2025-04-06'),
(119, 20, 'Moisturizer', 'Hydrating moisturizer', 800, 300, TRUE, '2025-04-07'),
(120, 21, 'Mouse', 'Wireless mouse', 1500, 250, TRUE, '2025-04-08'),
(121, 1, 'Headphone', 'Noise-cancelling headphones', 7000, 100, TRUE, '2025-04-09'),
(122, 29, 'CricketBat', 'Lightweight cricket bat', 2500, 60, TRUE, '2025-04-10'),
(123, 30, 'SwimGoggles', 'Anti-fog swimming goggles', 800, 150, TRUE, '2025-04-11'),
(124, 7, 'Toaster', 'Automatic toaster', 3000, 100, FALSE, '2025-04-12'),
(125, 3, 'Sofa', 'Comfortable 3-seater sofa', 25000, 10, TRUE, '2025-04-13'),
(126, 8, 'TShirt', 'Cotton t-shirt', 500, 200, TRUE, '2025-04-14'),
(127, 31, 'Lamp', 'LED table lamp', 1200, 150, TRUE, '2025-04-15'),
(128, 32, 'VRHeadset', 'Virtual reality headset', 35000, 50, TRUE, '2025-04-16'),
(129, 33, 'Guitar', 'Acoustic guitar', 8000, 40, TRUE, '2025-04-17'),
(130, 35, 'Keyboard', 'Digital piano keyboard', 20000, 30, TRUE, '2025-04-18'),
(131, 38, 'RiceBag', '10kg rice bag', 500, 500, TRUE, '2025-04-19'),
(132, 40, 'Chocolate', 'Assorted chocolates', 400, 400, FALSE, '2025-04-20'),
(133, 39, 'Coffee', 'Premium coffee beans', 800, 300, TRUE, '2025-04-21'),
(134, 44, 'Paint', 'Professional paint set', 1500, 90, TRUE, '2025-04-22'),
(135, 37, 'PetFood', 'Dry dog food', 2000, 250, TRUE, '2025-04-23'),
(136, 46, 'Stroller', 'Lightweight baby stroller', 7000, 60, TRUE, '2025-04-24'),
(137, 45, 'ToolKit', 'Multipurpose tool kit', 1000, 120, TRUE, '2025-04-25'),
(138, 42, 'Backpack', 'Water-resistant travel backpack', 3000, 80, TRUE, '2025-04-26'),
(139, 18, 'BikeCover', 'All-weather bike cover', 1500, 100, TRUE, '2025-04-27'),
(140, 47, 'CraftKit', 'Art and craft kit', 800, 200, TRUE, '2025-04-28'),
(141, 48, 'Treadmill', 'Home-use treadmill', 40000, 15, TRUE, '2025-04-29'),
(142, 49, 'CleaningMop', 'Self-wringing mop', 1200, 200, TRUE, '2025-04-30'),
(143, 12, 'GardeningTool', 'Complete gardening kit', 2500, 150, TRUE, '2025-05-01'),
(144, 34, 'ElectricGuitar', 'Electric guitar with amp', 12000, 20, TRUE, '2025-05-02'),
(145, 50, 'Antivirus', '1-year license for antivirus', 1500, 300, TRUE, '2025-05-03'),
(146, 7, 'Mixer', 'Kitchen mixer grinder', 3500, 90, TRUE, '2025-05-04'),
(147, 3, 'Desk', 'Wooden study desk', 14000, 15, FALSE, '2025-05-05'),
(148, 9, 'Skirt', 'Summer skirt', 1500, 100, TRUE, '2025-05-06'),
(149, 8, 'Shorts', 'Comfortable shorts', 800, 150, TRUE, '2025-05-07'),
(150, 21, 'Keyboard', 'Mechanical keyboard', 7000, 120, TRUE, '2025-05-08');

-- Insert data into 'image' table
INSERT INTO image (ImageID, ProductID, ImageData, ImageUrl)
VALUES
(201, 101, 'Image data for iPhone 13', 'http://example.com/iphone13.jpg'),
(202, 101, 'Image data for Gaming Laptop', 'http://example.com/gaminglaptop.jpg'),
(203, 103, 'Image data for Toaster', 'http://example.com/toaster.jpg'),
(204, 101, 'Image data for Sofa', 'http://example.com/sofa.jpg'),
(205, 105, 'Image data for T-shirt', 'http://example.com/tshirt.jpg'),
(206, 106, 'Image data for Dress', 'http://example.com/dress.jpg'),
(207, 107, 'Image data for Toy Car', 'http://example.com/toycar.jpg'),
(208, 108, 'Image data for Smart TV', 'http://example.com/smarttv.jpg'),
(209, 109, 'Image data for Dining Table', 'http://example.com/diningtable.jpg'),
(210, 110, 'Image data for Gaming Console', 'http://example.com/console.jpg'),
(211, 111, 'Image data for Board Game', 'http://example.com/boardgame.jpg'),
(212, 112, 'Image data for Car Cover', 'http://example.com/carcover.jpg'),
(213, 113, 'Image data for Bike Helmet', 'http://example.com/bikehelmet.jpg'),
(214, 114, 'Image data for Jeans', 'http://example.com/jeans.jpg'),
(215, 115, 'Image data for Bookshelf', 'http://example.com/bookshelf.jpg'),
(216, 116, 'Image data for Tennis Racket', 'http://example.com/tennisracket.jpg'),
(217, 117, 'Image data for Football', 'http://example.com/football.jpg'),
(218, 118, 'Image data for Yoga Mat', 'http://example.com/yogamat.jpg'),
(219, 119, 'Image data for Moisturizer', 'http://example.com/moisturizer.jpg'),
(220, 120, 'Image data for Wireless Mouse', 'http://example.com/wirelessmouse.jpg'),
(221, 121, 'Image data for Headphones', 'http://example.com/headphones.jpg'),
(222, 122, 'Image data for Cricket Bat', 'http://example.com/cricketbat.jpg'),
(223, 123, 'Image data for Swim Goggles', 'http://example.com/swimgoggles.jpg'),
(224, 124, 'Image data for Blender', 'http://example.com/blender.jpg'),
(225, 125, 'Image data for Office Chair', 'http://example.com/officechair.jpg'),
(226, 126, 'Image data for Sneakers', 'http://example.com/sneakers.jpg'),
(227, 127, 'Image data for Table Lamp', 'http://example.com/tablelamp.jpg'),
(228, 128, 'Image data for VR Headset', 'http://example.com/vrheadset.jpg'),
(229, 129, 'Image data for Guitar', 'http://example.com/guitar.jpg'),
(230, 130, 'Image data for Keyboard', 'http://example.com/keyboard.jpg'),
(231, 131, 'Image data for Rice Bag', 'http://example.com/ricebag.jpg'),
(232, 132, 'Image data for Chocolates', 'http://example.com/chocolates.jpg'),
(233, 133, 'Image data for Coffee Beans', 'http://example.com/coffeebeans.jpg'),
(234, 134, 'Image data for Paint Set', 'http://example.com/paintset.jpg'),
(235, 135, 'Image data for Pet Food', 'http://example.com/petfood.jpg'),
(236, 136, 'Image data for Baby Stroller', 'http://example.com/babystroller.jpg'),
(237, 137, 'Image data for Screwdriver Set', 'http://example.com/screwdriverset.jpg'),
(238, 138, 'Image data for Travel Backpack', 'http://example.com/travelbackpack.jpg'),
(239, 139, 'Image data for Bike Cover', 'http://example.com/bikecover.jpg'),
(240, 140, 'Image data for DIY Craft Kit', 'http://example.com/diycraftkit.jpg'),
(241, 141, 'Image data for Treadmill', 'http://example.com/treadmill.jpg'),
(242, 142, 'Image data for Cleaning Mop', 'http://example.com/cleaningmop.jpg'),
(243, 143, 'Image data for Gardening Tool Set', 'http://example.com/gardeningtools.jpg'),
(244, 144, 'Image data for Electric Guitar', 'http://example.com/electricguitar.jpg'),
(245, 145, 'Image data for Antivirus Software', 'http://example.com/antivirus.jpg'),
(246, 107, 'Image data for Toy Robot', 'http://example.com/toyrobot.jpg'),
(247, 102, 'Image data for Gaming Mouse', 'http://example.com/gamingmouse.jpg'),
(248, 131, 'Image data for Organic Rice', 'http://example.com/organicrice.jpg'),
(249, 118, 'Image data for Foldable Mat', 'http://example.com/foldablemat.jpg'),
(250, 110, 'Image data for Gamepad', 'http://example.com/gamepad.jpg');

-- Insert data into 'users' table
INSERT INTO users (UserID, RoleID, UserName, Password, Email, PhoneNumber, Gender)
VALUES
(601, 1, 'John Doe', 'password123', 'john.doe@example.com', '9876543210', 'M'),
(602, 2, 'Jane Smith', 'securePass456', 'jane.smith@example.com', '9123456789', 'F'),
(603, 1, 'Charlie Brown', 'charliePass789', 'charlie.brown@example.com', '9988776655', 'M'),
(604, 2, 'Alice Wonderland', 'aliceSecure@99', 'alice.w@example.com', '8765432109', 'F'),
(605, 2, 'Bob Builder', 'builderPass@11', 'bob.builder@example.com', '9988123456', 'M'),
(606, 1, 'Eve Adams', 'eveStrong12', 'eve.adams@example.com', '9876541230', 'F'),
(607, 2, 'Tom Hanks', 'tomActor@88', 'tom.hanks@example.com', '7654321890', 'M'),
(608, 1, 'Mary Jane', 'marySecret#33', 'mary.jane@example.com', '9123467580', 'F'),
(609, 2, 'Bruce Wayne', 'batman!pass', 'bruce.wayne@example.com', '9812345678', 'M'),
(610, 1, 'Clark Kent', 'superman@pass', 'clark.kent@example.com', '9823456789', 'M'),
(611, 1, 'Diana Prince', 'wonder!woman', 'diana.prince@example.com', '9132467890', 'F'),
(612, 2, 'Steve Rogers', 'captain$america', 'steve.rogers@example.com', '9234567891', 'M'),
(613, 1, 'Natasha Romanoff', 'black.widow99', 'natasha.romanoff@example.com', '9345678912', 'F'),
(614, 1, 'Tony Stark', 'ironman#3000', 'tony.stark@example.com', '9456789123', 'M'),
(615, 2, 'Peter Parker', 'spiderman#pass', 'peter.parker@example.com', '9567891234', 'M'),
(616, 1, 'Wanda Maximoff', 'scarletW!tch', 'wanda.maximoff@example.com', '9678912345', 'F'),
(617, 3, 'Thor Odinson', 'asgard#god', 'thor.odinson@example.com', '9789123456', 'M'),
(618, 1, 'Bruce Banner', 'hulk!smash', 'bruce.banner@example.com', '9891234567', 'M'),
(619, 2, 'Loki Laufeyson', 'trickster@99', 'loki.laufeyson@example.com', '9812345098', 'M'),
(620, 1, 'Carol Danvers', 'captain@marvel', 'carol.danvers@example.com', '9823456012', 'F'),
(621, 2, 'Scott Lang', 'antman#tiny', 'scott.lang@example.com', '9834567123', 'M'),
(622, 2, 'Hope Van Dyne', 'wasp@secure', 'hope.dyne@example.com', '9845678234', 'F'),
(623, 1, 'T\'Challa', 'wakanda#forever', 'tchalla@example.com', '9856789345', 'M'),
(624, 1, 'Shuri', 'shuri@tech', 'shuri@example.com', '9867890456', 'F'),
(625, 1, 'Doctor Strange', 'strange!magic', 'doctor.strange@example.com', '9878901567', 'M'),
(626, 2, 'Bucky Barnes', 'winter@99', 'bucky.barnes@example.com', '9889012678', 'M'),
(627, 1, 'Sam Wilson', 'falcon@fly', 'sam.wilson@example.com', '9890123789', 'M'),
(628, 1, 'Pepper Potts', 'pepper@secure', 'pepper.potts@example.com', '9801234890', 'F'),
(629, 1, 'James Rhodes', 'war.machine', 'james.rhodes@example.com', '9812345671', 'M'),
(630, 2, 'Wong', 'wong!magic', 'wong@example.com', '9923456782', 'M'),
(631, 1, 'Vision', 'vision@ai', 'vision@example.com', '9934567893', 'M'),
(632, 2, 'Gamora', 'gamora@secure', 'gamora@example.com', '9945678904', 'F'),
(633, 2, 'Nebula', 'nebula@cyber', 'nebula@example.com', '9956789015', 'F'),
(634, 1, 'Star-Lord', 'star#lord', 'starlord@example.com', '9967890126', 'M'),
(635, 1, 'Rocket Raccoon', 'rocket@blast', 'rocket@example.com', '9978901237', 'M'),
(636, 1, 'Groot', 'iamgroot99', 'groot@example.com', '9989012348', 'M'),
(637, 2, 'Drax', 'destroyer@secure', 'drax@example.com', '9990123459', 'M'),
(638, 1, 'Mantis', 'mantis@empath', 'mantis@example.com', '9101234560', 'F'),
(639, 2, 'Yondu', 'yondu@arrow', 'yondu@example.com', '9112345671', 'M'),
(640, 1, 'Nick Fury', 'fury@shield', 'nick.fury@example.com', '9123456782', 'M'),
(641, 2, 'Maria Hill', 'hill@shield', 'maria.hill@example.com', '9134567893', 'F'),
(642, 1, 'Phil Coulson', 'coulson@shield', 'phil.coulson@example.com', '9145678904', 'M'),
(643, 1, 'Hank Pym', 'hank@antman', 'hank.pym@example.com', '9156789015', 'M'),
(644, 2, 'Janet Van Dyne', 'janet@wasp', 'janet.dyne@example.com', '9167890126', 'F'),
(645, 1, 'Happy Hogan', 'happy@ironman', 'happy.hogan@example.com', '9178901237', 'M'),
(646, 1, 'MJ Watson', 'mj@spidey', 'mj.watson@example.com', '9189012348', 'F'),
(647, 1, 'Ned Leeds', 'ned@friend', 'ned.leeds@example.com', '9190123459', 'M'),
(648, 2, 'Aunt May', 'may@spidey', 'aunt.may@example.com', '9201234560', 'F'),
(649, 1, 'Harley Keener', 'harley@tech', 'harley.keener@example.com', '9212345671', 'M'),
(650, 2, 'Korg', 'korg@rocks', 'korg@example.com', '9223456782', 'M');


-- Insert data into 'payment' table
INSERT INTO payment (PaymentID, OrderID, PaymentMode, PaymentTime, PaymentAmount)
VALUES
(301, 401, 'CreditCard', '2025-03-20', 70000),
(302, 402, 'NetBanking', '2025-03-21', 85000),
(303, 403, 'UPI', '2025-03-22', 3000),
(304, 404, 'CreditCard', '2025-03-23', 25000),
(305, 405, 'Cash', '2025-03-24', 500),
(306, 406, 'DebitCard', '2025-03-25', 45000),
(307, 407, 'NetBanking', '2025-03-26', 12000),
(308, 408, 'UPI', '2025-03-27', 800),
(309, 409, 'CreditCard', '2025-03-28', 150000),
(310, 410, 'Cash', '2025-03-29', 2500),
(311, 411, 'DebitCard', '2025-03-30', 6000),
(312, 412, 'UPI', '2025-03-31', 4200),
(313, 413, 'NetBanking', '2025-04-01', 77000),
(314, 414, 'CreditCard', '2025-04-02', 9000),
(315, 415, 'Cash', '2025-04-03', 1800),
(316, 416, 'DebitCard', '2025-04-04', 34000),
(317, 417, 'UPI', '2025-04-05', 300),
(318, 418, 'NetBanking', '2025-04-06', 110000),
(319, 419, 'CreditCard', '2025-04-07', 59000),
(320, 420, 'DebitCard', '2025-04-08', 27000),
(321, 421, 'Cash', '2025-04-09', 15000),
(322, 422, 'UPI', '2025-04-10', 5000),
(323, 423, 'NetBanking', '2025-04-11', 78000),
(324, 424, 'CreditCard', '2025-04-12', 9600),
(325, 425, 'DebitCard', '2025-04-13', 4300),
(326, 426, 'Cash', '2025-04-14', 1200),
(327, 427, 'UPI', '2025-04-15', 62000),
(328, 428, 'NetBanking', '2025-04-16', 57000),
(329, 429, 'CreditCard', '2025-04-17', 8500),
(330, 430, 'Cash', '2025-04-18', 2900),
(331, 431, 'DebitCard', '2025-04-19', 19000),
(332, 432, 'UPI', '2025-04-20', 750),
(333, 433, 'NetBanking', '2025-04-21', 102000),
(334, 434, 'CreditCard', '2025-04-22', 8800),
(335, 435, 'Cash', '2025-04-23', 3100),
(336, 436, 'DebitCard', '2025-04-24', 32000),
(337, 437, 'UPI', '2025-04-25', 450),
(338, 438, 'NetBanking', '2025-04-26', 98000),
(339, 439, 'CreditCard', '2025-04-27', 7400),
(340, 440, 'DebitCard', '2025-04-28', 4900),
(341, 441, 'Cash', '2025-04-29', 1700),
(342, 442, 'UPI', '2025-04-30', 34000),
(343, 443, 'NetBanking', '2025-05-01', 45000),
(344, 444, 'CreditCard', '2025-05-02', 6800),
(345, 445, 'DebitCard', '2025-05-03', 2900),
(346, 446, 'Cash', '2025-05-04', 800),
(347, 447, 'UPI', '2025-05-05', 6200),
(348, 448, 'NetBanking', '2025-05-06', 87000),
(349, 449, 'CreditCard', '2025-05-07', 9100),
(350, 450, 'Cash', '2025-05-08', 2400);

-- Insert data into 'orders' table
INSERT INTO orders (OrderID, UserID, OrderDate, DeleiverDate, orderStatus, ShippingAddress)
VALUES
(401, 601, '2024-11-26', '2024-12-01', 'Shipped', '123, ABC Street, Hyderabad'),
(402, 602, '2024-11-27', '2024-12-02', 'Delivered', '456, XYZ Avenue, Mumbai'),
(403, 603, '2024-11-28', '2024-12-03', 'Cancelled', '789, LMN Lane, Chennai'),
(404, 604, '2024-11-29', '2024-12-04', 'Pending', '321, OPQ Road, Bengaluru'),
(405, 605, '2024-11-30', '2024-12-05', 'Delivered', '654, GHI Colony, Kolkata'),
(406, 606, '2024-12-01', '2024-12-06', 'Shipped', '876, TUV Street, Pune'),
(407, 607, '2024-12-02', '2024-12-07', 'Cancelled', '987, DEF Avenue, Ahmedabad'),
(408, 608, '2024-12-03', '2024-12-08', 'Pending', '543, JKL Lane, Jaipur'),
(409, 609, '2024-12-04', '2024-12-09', 'Delivered', '210, RST Road, Lucknow'),
(410, 610,  '2024-12-05', '2024-12-10', 'Shipped', '111, UVW Street, Chandigarh'),
(411, 611, '2024-12-06', '2024-12-11', 'Delivered', '222, XYZ Lane, Patna'),
(412, 612, '2024-12-07', '2024-12-12', 'Pending', '333, GHI Avenue, Surat'),
(413, 613, '2024-12-08', '2024-12-13', 'Cancelled', '444, DEF Street, Nagpur'),
(414, 614, '2024-12-09', '2024-12-14', 'Delivered', '555, JKL Road, Bhopal'),
(415, 615, '2024-12-10', '2024-12-15', 'Shipped', '666, MNO Avenue, Ludhiana'),
(416, 616, '2024-12-11', '2024-12-16', 'Pending', '777, ABC Lane, Agra'),
(417, 617, '2024-12-12', '2024-12-17', 'Cancelled', '888, PQR Road, Varanasi'),
(418, 618, '2024-12-13', '2024-12-18', 'Delivered', '999, STU Avenue, Thiruvananthapuram'),
(419, 619, '2024-12-14', '2024-12-19', 'Shipped', '123, OPQ Street, Coimbatore'),
(420, 620, '2024-12-15', '2024-12-20', 'Pending', '456, UVW Road, Guwahati'),
(421, 621, '2024-12-16', '2024-12-21', 'Delivered', '789, XYZ Lane, Ranchi'),
(422, 622, '2024-12-17', '2024-12-22', 'Cancelled', '321, GHI Street, Bhubaneswar'),
(423, 623, '2024-12-18', '2024-12-23', 'Pending', '654, DEF Avenue, Goa'),
(424, 624, '2024-12-19', '2024-12-24', 'Shipped', '876, JKL Lane, Mysuru'),
(425, 625, '2024-12-20', '2024-12-25', 'Delivered', '987, MNO Road, Madurai'),
(426, 626, '2024-12-21', '2024-12-26', 'Cancelled', '543, OPQ Street, Nashik'),
(427, 627, '2024-12-22', '2024-12-27', 'Shipped', '210, UVW Avenue, Kanpur'),
(428, 628, '2024-12-23', '2024-12-28', 'Pending', '111, XYZ Lane, Amritsar'),
(429, 629, '2024-12-24', '2024-12-29', 'Delivered', '222, GHI Road, Vijayawada'),
(430, 630, '2024-12-25', '2024-12-30', 'Shipped', '333, DEF Street, Kota'),
(431, 631, '2024-12-26', '2024-12-31', 'Cancelled', '444, JKL Avenue, Udaipur'),
(432, 632, '2024-12-27', '2025-01-01', 'Pending', '555, ABC Lane, Jodhpur'),
(433, 633, '2024-12-28', '2025-01-02', 'Delivered', '666, PQR Road, Tirupati'),
(434, 634, '2024-12-29', '2025-01-03', 'Shipped', '777, STU Street, Kozhikode'),
(435, 635, '2024-12-30', '2025-01-04', 'Cancelled', '888, UVW Avenue, Meerut'),
(436, 636, '2024-12-31', '2025-01-05', 'Pending', '999, XYZ Lane, Noida'),
(437, 637, '2025-01-01', '2025-01-06', 'Shipped', '123, GHI Street, Vellore'),
(438, 638, '2025-01-02', '2025-01-07', 'Delivered', '456, DEF Road, Salem'),
(439, 639, '2025-01-03', '2025-01-08', 'Shipped', '789, JKL Avenue, Guntur'),
(440, 640, '2025-01-04', '2025-01-09', 'Cancelled', '321, OPQ Lane, Warangal'),
(441, 641, '2025-01-05', '2025-01-10', 'Delivered', '654, UVW Road, Durgapur'),
(442, 642, '2025-01-06', '2025-01-11', 'Pending', '876, XYZ Avenue, Jamnagar'),
(443, 643, '2025-01-07', '2025-01-12', 'Cancelled', '987, GHI Street, Siliguri'),
(444, 644, '2025-01-08', '2025-01-13', 'Delivered', '543, DEF Lane, Aligarh'),
(445, 645, '2025-01-09', '2025-01-14', 'Pending', '210, JKL Avenue, Jhansi'),
(446, 646, '2025-01-10', '2025-01-15', 'Cancelled', '111, MNO Street, Gorakhpur'),
(447, 647, '2025-01-11', '2025-01-16', 'Shipped', '222, OPQ Lane, Moradabad'),
(448, 648, '2025-01-12', '2025-01-17', 'Pending', '333, UVW Road, Raipur'),
(449, 649, '2025-01-13', '2025-01-18', 'Delivered', '444, XYZ Avenue, Jabalpur'),
(450, 650, '2025-01-14', '2025-01-19', 'Cancelled', '555, ABC Street, Bareilly');

-- Insert data into 'orderItem' table
INSERT INTO orderItem (OrderItemID, OrderId, ProductID, OrderItemName, OrderItemQuantity, OrderItemStatus, OrderItemPrice)
VALUES
(501, 401, 101, 'iPhone', 1, 'Delivered', 70000),
(502, 402, 102, 'Laptop', 1, 'Shipped', 85000),
(503, 403, 103, 'Blender', 2, 'Pending', 4000),
(504, 404, 104, 'Chair', 1, 'Delivered', 15000),
(505, 405, 105, 'Sneakers', 3, 'Cancelled', 3000),
(506, 406, 106, 'Dress', 2, 'Shipped', 2000),
(507, 407, 107, 'Toy Car', 1, 'Delivered', 1200),
(508, 408, 108, 'SmartTV', 1, 'Shipped', 45000),
(509, 409, 109, 'Table', 1, 'Pending', 30000),
(510, 410, 110, 'Console', 1, 'Shipped', 50000),
(511, 411, 111, 'Game', 2, 'Cancelled', 1500),
(512, 412, 112, 'CarCover', 1, 'Delivered', 3000),
(513, 413, 113, 'Helmet', 2, 'Shipped', 2000),
(514, 414, 114, 'Jeans', 3, 'Delivered', 1200),
(515, 415, 115, 'Bookshelf', 1, 'Pending', 8000),
(516, 416, 116, 'Racket', 1, 'Shipped', 5000),
(517, 417, 117, 'Football', 2, 'Cancelled', 1500),
(518, 418, 118, 'YogaMat', 4, 'Delivered', 1000),
(519, 419, 119, 'Moisturizer', 3, 'Shipped', 800),
(520, 420, 120, 'Mouse', 2, 'Delivered', 1500),
(521, 421, 121, 'Headphone', 1, 'Cancelled', 7000),
(522, 422, 122, 'CricketBat', 2, 'Shipped', 2500),
(523, 423, 123, 'SwimGoggles', 1, 'Pending', 800),
(524, 424, 124, 'Toaster', 1, 'Delivered', 3000),
(525, 425, 125, 'Sofa', 1, 'Shipped', 25000),
(526, 426, 126, 'TShirt', 2, 'Delivered', 500),
(527, 427, 127, 'Lamp', 1, 'Pending', 1200),
(528, 428, 128, 'VRHeadset', 1, 'Shipped', 35000),
(529, 429, 129, 'Guitar', 1, 'Delivered', 8000),
(530, 430, 130, 'Keyboard', 1, 'Cancelled', 20000),
(531, 431, 131, 'RiceBag', 2, 'Delivered', 500),
(532, 432, 132, 'Chocolate', 5, 'Pending', 400),
(533, 433, 133, 'Coffee', 3, 'Shipped', 800),
(534, 434, 134, 'Paint', 1, 'Delivered', 1500),
(535, 435, 135, 'PetFood', 2, 'Cancelled', 2000),
(536, 436, 136, 'Stroller', 1, 'Delivered', 7000),
(537, 437, 137, 'ToolKit', 1, 'Pending', 1000),
(538, 438, 138, 'Backpack', 1, 'Shipped', 3000),
(539, 439, 139, 'BikeCover', 2, 'Delivered', 1500),
(540, 440, 140, 'CraftKit', 3, 'Pending', 800),
(541, 441, 141, 'Treadmill', 1, 'Shipped', 40000),
(542, 442, 142, 'CleaningMop', 1, 'Delivered', 1200),
(543, 443, 143, 'GardeningTool', 1, 'Pending', 2500),
(544, 444, 144, 'ElectricGuitar', 1, 'Delivered', 12000),
(545, 445, 145, 'Antivirus', 1, 'Shipped', 1500),
(546, 446, 146, 'Mixer', 3, 'Cancelled', 3500),
(547, 447, 147, 'Desk', 2, 'Delivered', 14000),
(548, 448, 148, 'Skirt', 2, 'Pending', 1500),
(549, 449, 149, 'Shorts', 3, 'Shipped', 800),
(550, 450, 150, 'Keyboard', 1, 'Delivered', 7000);
-- Insert data into 'shippingAdrress' table
INSERT INTO shippingAdrress (AddressID, UserID, City, State, Pincode, Country, Address)
VALUES
(701, 601, 'Hyderabad', 'Telangana', 500001, 'India', '123, ABC Street'),
(702, 602, 'Mumbai', 'Maharashtra', 400001, 'India', '456, XYZ Avenue'),
(703, 603, 'Chennai', 'Tamil Nadu', 600001, 'India', '789, LMN Lane'),
(704, 604, 'Bengaluru', 'Karnataka', 560001, 'India', '321, OPQ Road'),
(705, 605, 'Kolkata', 'West Bengal', 700001, 'India', '654, GHI Colony'),
(706, 606, 'Pune', 'Maharashtra', 411001, 'India', '876, TUV Street'),
(707, 607, 'Ahmedabad', 'Gujarat', 380001, 'India', '987, DEF Avenue'),
(708, 608, 'Jaipur', 'Rajasthan', 302001, 'India', '543, JKL Lane'),
(709, 609, 'Lucknow', 'Uttar Pradesh', 226001, 'India', '210, RST Road'),
(710, 610, 'Chandigarh', 'Chandigarh', 160001, 'India', '111, UVW Street'),
(711, 611, 'Patna', 'Bihar', 800001, 'India', '222, XYZ Lane'),
(712, 612, 'Surat', 'Gujarat', 395001, 'India', '333, GHI Avenue'),
(713, 613, 'Nagpur', 'Maharashtra', 440001, 'India', '444, DEF Street'),
(714, 614, 'Bhopal', 'Madhya Pradesh', 462001, 'India', '555, JKL Road'),
(715, 615, 'Ludhiana', 'Punjab', 141001, 'India', '666, MNO Avenue'),
(716, 616, 'Agra', 'Uttar Pradesh', 282001, 'India', '777, ABC Lane'),
(717, 617, 'Varanasi', 'Uttar Pradesh', 221001, 'India', '888, PQR Road'),
(718, 618, 'Thiruvananthapuram', 'Kerala', 695001, 'India', '999, STU Avenue'),
(719, 619, 'Coimbatore', 'Tamil Nadu', 641001, 'India', '123, OPQ Street'),
(720, 620, 'Guwahati', 'Assam', 781001, 'India', '456, UVW Road'),
(721, 621, 'Ranchi', 'Jharkhand', 834001, 'India', '789, XYZ Lane'),
(722, 622, 'Bhubaneswar', 'Odisha', 751001, 'India', '321, GHI Street'),
(723, 623, 'Goa', 'Goa', 403001, 'India', '654, DEF Avenue'),
(724, 624, 'Mysuru', 'Karnataka', 570001, 'India', '876, JKL Lane'),
(725, 625, 'Madurai', 'Tamil Nadu', 625001, 'India', '987, MNO Road'),
(726, 626, 'Nashik', 'Maharashtra', 422001, 'India', '543, OPQ Street'),
(727, 627, 'Kanpur', 'Uttar Pradesh', 208001, 'India', '210, UVW Avenue'),
(728, 628, 'Amritsar', 'Punjab', 143001, 'India', '111, XYZ Lane'),
(729, 629, 'Vijayawada', 'Andhra Pradesh', 520001, 'India', '222, GHI Road'),
(730, 630, 'Kota', 'Rajasthan', 324001, 'India', '333, DEF Street'),
(731, 631, 'Udaipur', 'Rajasthan', 313001, 'India', '444, JKL Avenue'),
(732, 632, 'Jodhpur', 'Rajasthan', 342001, 'India', '555, ABC Lane'),
(733, 633, 'Tirupati', 'Andhra Pradesh', 517001, 'India', '666, PQR Road'),
(734, 634, 'Kozhikode', 'Kerala', 673001, 'India', '777, STU Street'),
(735, 635, 'Meerut', 'Uttar Pradesh', 250001, 'India', '888, UVW Avenue'),
(736, 636, 'Noida', 'Uttar Pradesh', 201001, 'India', '999, XYZ Lane'),
(737, 637, 'Vellore', 'Tamil Nadu', 632001, 'India', '123, GHI Street'),
(738, 638, 'Salem', 'Tamil Nadu', 636001, 'India', '456, DEF Road'),
(739, 639, 'Guntur', 'Andhra Pradesh', 522001, 'India', '789, JKL Avenue'),
(740, 640, 'Warangal', 'Telangana', 506001, 'India', '321, OPQ Lane'),
(741, 641, 'Durgapur', 'West Bengal', 713001, 'India', '654, UVW Road'),
(742, 642, 'Jamnagar', 'Gujarat', 361001, 'India', '876, XYZ Avenue'),
(743, 643, 'Siliguri', 'West Bengal', 734001, 'India', '987, GHI Street'),
(744, 644, 'Aligarh', 'Uttar Pradesh', 202001, 'India', '543, DEF Lane'),
(745, 645, 'Jhansi', 'Uttar Pradesh', 284001, 'India', '210, JKL Avenue'),
(746, 646, 'Gorakhpur', 'Uttar Pradesh', 273001, 'India', '111, MNO Street'),
(747, 647, 'Moradabad', 'Uttar Pradesh', 244001, 'India', '222, OPQ Lane'),
(748, 648, 'Raipur', 'Chhattisgarh', 492001, 'India', '333, UVW Road'),
(749, 649, 'Jabalpur', 'Madhya Pradesh', 482001, 'India', '444, XYZ Avenue'),
(750, 650, 'Bareilly', 'Uttar Pradesh', 243001, 'India', '555, ABC Street');


    

