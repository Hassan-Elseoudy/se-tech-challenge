-- Insert supplier data
INSERT INTO supplier (id, name, address, zip, city, country)
VALUES (1, 'John Doe', '123 Main St', '12345', 'Anytown', 'USA'),
       (2, 'Jane Doe', '456 Main St', '12345', 'Anytown', 'USA'),
       (200, 'Jackie Chan', '789 Main St', '10000', 'Hong Kong', 'China'),
       (250, 'Ion Popescu', 'Str. Veseliei, Nr. 4', '253445', 'Bucharest', 'Romania');

-- Insert activity data
INSERT INTO activity (id, title, price, currency, rating, special_offer, supplier_id)
VALUES (25651, 'German Tour: Parliament Quarter & Reichstag glass dome', 14, '$', 4.8, false, 1),
       (6960, 'Skip the Line: Pergamon Museum Berlin Tickets', 21, '$', 4.8, false, 2),
       (80426, 'Berlin WelcomeCard: Transport, Discounts & Guide Book', 10, '$', 4.6, false, 2),
       (23113, 'Skip the Line: Berlin TV Tower Ticket', 143, '$', 4.6, false, 2),
       (26093, '1-Hour City Tour by Boat with Guaranteed Seating', 14, '$', 4.5, false, 1),
       (97470, 'Berlin Hop-on Hop-off Bus Tour: 1- or 2-Day Ticket', 210, '$', 4.3, false, 200),
       (15647, 'German Tour: Reichstag with Plenary Chamber & Cuppola', 59, '$', 4.8, false, 250),
       (26823, 'Berlin: 2.5-Hour Boat Tour Along the River Spree', 41, '$', 4.5, true, 1),
       (58351, 'Museum Pass Berlin: 3-Day Entry to Over 40 Top Museums', 14, '$', 4.5, false, 250),
       (75009, 'Reichstag: Rooftop Coffee Break at Käfer', 50, '$', 4.6, true, 2),
       (19340, 'Skip the Line: Neues Museum Berlin Tickets', 46, '$', 4.9, true, 250),
       (13399, 'German Tour: Reichstag with dome Chamber &', 87, '$', 4.8, false, 200),
       (86150, 'Berlin Hop-on Hop-off Bus Tour with Live Commentary', 8, '$', 4.3, false, 1),
       (40881, 'Skip the Line: TV Tower Early Bird Tickets', 140, '$', 4.5, false, 2);
