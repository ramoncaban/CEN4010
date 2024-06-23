--Andrew
CREATE SEQUENCE IF NOT EXISTS profiles_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;
CREATE TABLE IF NOT EXISTS profiles (
    id bigint DEFAULT nextval('profiles_id_seq') NOT NULL,
    username text NOT NULL,
    password text NOT NULL,
    name text NOT NULL,
    emailaddress text NOT NULL,
    homeaddress text NOT NULL,
    CONSTRAINT profiles_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS creditcards (
    id int8 NOT NULL,
    cardtype text NOT NULL,
    cardnumber text NOT NULL,
    expirationdate text NOT NULL,
    cvv int4 NOT NULL,
    cardowner text NOT NULL,
    profile_id bigint NOT NULL,
    CONSTRAINT creditcards_pkey PRIMARY KEY (id, profile_id),
    CONSTRAINT fk_profile_id FOREIGN KEY (profile_id) REFERENCES profiles(id)
);

-- INSERT INTO profiles (id, username, password, name, emailaddress, homeaddress) VALUES
-- (nextval('profiles_id_seq'::regclass), 'user1', 'password1', 'name1', 'email1@example.com', 'address1'),
-- (nextval('profiles_id_seq'::regclass), 'user2', 'password2', 'name2', 'email2@example.com', 'address2'),
-- (nextval('profiles_id_seq'::regclass), 'user3', 'password3', 'name3', 'email3@example.com', 'address3')
-- ON CONFLICT (username) DO NOTHING;

-- INSERT INTO creditcards (id, cardtype, cardnumber, expirationdate, cvv, cardowner, profile_id) VALUES
-- (1, 'Visa', '1111111111111111', '01/01', 123, 'name1', 1),
-- (2, 'MasterCard', '5555555555555555', '01/23', 456, 'name2', 2),
-- (3, 'American Express', '123456789123456', '06/25', 789, 'name3', 3)
-- ON CONFLICT (id) DO NOTHING;

--Avid
CREATE TABLE IF NOT EXISTS books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL,
    rating DECIMAL(2, 1) NOT NULL,
    price DECIMAL(5, 2) NOT NULL,
    isbn BIGINT UNIQUE NOT NULL,
    description TEXT,
    copies_sold INT NOT NULL,
    publisher VARCHAR(255) NOT NULL
);

-- INSERT INTO books (title, author, genre, rating, price, isbn, description, copies_sold, publisher) VALUES
-- ('The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction', 4.2, 10.99, 9780743273565, 'A portrait of the Jazz Age in all of its decadence and excess.', 5000000, 'Scribner'),
-- ('To Kill a Mockingbird', 'Harper Lee', 'Southern Gothic, Bildungsroman', 4.8, 7.99, 9780446310789, 'A gripping, heart-wrenching, and wholly remarkable tale of coming-of-age in a South poisoned by virulent prejudice.', 40000000, 'J. B. Lippincott & Co.'),
-- ('1984', 'George Orwell', 'Dystopian, political fiction, social science fiction', 4.7, 8.99, 9780451524935, 'A startling and haunting vision of the world, 1984 is so powerful that it is completely convincing from start to finish.', 25000000, 'Secker & Warburg'),
-- ('The Catcher in the Rye', 'J. D. Salinger', 'Realistic fiction, Coming-of-age fiction', 3.8, 6.99, 9780316769174, 'The story of Holden Caulfield with his idiosyncrasies, penetrating insight, confusion, sensitivity and negativism.', 65000000, 'Little, Brown and Company')
-- ON CONFLICT (isbn) DO NOTHING;

--Dylan
CREATE TABLE IF NOT EXISTS shopping_cart (
    id SERIAL PRIMARY KEY,
    user_id INT UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS cart_items (
    id SERIAL PRIMARY KEY,
    cart_id INT NOT NULL,
    book_id INT NOT NULL,
    quantity INT NOT NULL DEFAULT 1,
    UNIQUE(cart_id, book_id),
    FOREIGN KEY (cart_id) REFERENCES shopping_cart(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);


-- INSERT INTO shopping_cart (user_id) VALUES
-- (1),
-- (2),
-- (3),
-- (4)
-- ON CONFLICT (user_id) DO NOTHING;

-- INSERT INTO cart_items (cart_id, book_id, quantity) VALUES
-- (1, 1, 2),
-- (1, 2, 1),
-- (2, 2, 3),
-- (3, 3, 1),
-- (4, 4, 1)
-- ON CONFLICT (cart_id, book_id) DO NOTHING;

--Ros
CREATE TABLE IF NOT EXISTS book_ratings (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    rating INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    comment TEXT,
    UNIQUE(user_id, book_id)
);


CREATE TABLE IF NOT EXISTS book_comments (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    comment TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- INSERT INTO book_ratings (user_id, book_id, rating, comment) VALUES
-- (1, 1, 5, 'Great book!'),
-- (2, 1, 4, 'Enjoyed reading this book.'),
-- (3, 2, 5, 'A must read!'),
-- (4, 3, 4, 'Interesting book.')
-- ON CONFLICT (user_id, book_id) DO NOTHING;

-- INSERT INTO book_comments (user_id, book_id, comment) VALUES
-- (1, 1, 'I loved the character development in this book.'),
-- (2, 2, 'The plot was captivating.'),
-- (3, 3, 'Highly recommend this book to all readers.'),
-- (4, 4, 'A well-written book.')
-- ON CONFLICT (user_id, book_id) DO NOTHING;

--Ramon
-- Users Table
CREATE TABLE IF NOT EXISTS Users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(100),
    email VARCHAR(100),
    address TEXT
);

-- Wishlists Table
CREATE TABLE IF NOT EXISTS Wishlists (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    name VARCHAR(100) NOT NULL,
    UNIQUE(user_id, name),
    FOREIGN KEY (user_id) REFERENCES Users(id)
);

-- Books Table
CREATE TABLE IF NOT EXISTS Books (
    id SERIAL PRIMARY KEY,
    isbn BIGINT UNIQUE NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    author VARCHAR(100) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    publisher VARCHAR(100) NOT NULL,
    year_published INTEGER NOT NULL,
    copies_sold INTEGER DEFAULT 0
);

-- WishlistItems Table
CREATE TABLE IF NOT EXISTS WishlistItems (
    id SERIAL PRIMARY KEY,
    wishlist_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    FOREIGN KEY (wishlist_id) REFERENCES Wishlists(id),
    FOREIGN KEY (book_id) REFERENCES Books(id)
);

-- Insert into Users
-- INSERT INTO Users (username, password, name, email, address) VALUES
-- ('user1', 'password1', 'User One', 'user1@example.com', 'Address 1'),
-- ('user2', 'password2', 'User Two', 'user2@example.com', 'Address 2')
-- ON CONFLICT (username) DO NOTHING;

-- -- Insert into Wishlists
-- INSERT INTO Wishlists (user_id, name) VALUES
-- (1, 'Wishlist 1'),
-- (2, 'Wishlist 2')
-- ON CONFLICT (user_id, name) DO NOTHING;

-- -- Insert into Books
-- INSERT INTO Books (isbn, title, description, price, author, genre, publisher, year_published, copies_sold) VALUES
-- (9780743273565, 'The Great Gatsby', 'A portrait of the Jazz Age in all of its decadence and excess.', 10.99, 'F. Scott Fitzgerald', 'Fiction', 'Scribner', 1925, 5000000),
-- (9780446310789, 'To Kill a Mockingbird', 'A gripping, heart-wrenching, and wholly remarkable tale of coming-of-age in a South poisoned by virulent prejudice.', 7.99, 'Harper Lee', 'Southern Gothic, Bildungsroman', 'J. B. Lippincott & Co.', 1960, 40000000)
-- ON CONFLICT (isbn) DO NOTHING;

-- -- Insert into WishlistItems
-- INSERT INTO WishlistItems (wishlist_id, book_id) VALUES
-- (1, 1),
-- (2, 2)
-- ON CONFLICT (wishlist_id, book_id) DO NOTHING;


--Luis
CREATE TABLE IF NOT EXISTS author (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    biography TEXT,
    publisher VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    isbn BIGINT UNIQUE NOT NULL,
    author_id INTEGER REFERENCES author(id)
);

-- INSERT INTO author (first_name, last_name, biography, publisher) VALUES
-- ('F. Scott', 'Fitzgerald', 'F. Scott Fitzgerald was an American novelist, essayist, screenwriter, and short-story writer.', 'Scribner'),
-- ('Harper', 'Lee', 'Harper Lee was an American novelist widely known for To Kill a Mockingbird, published in 1960.', 'J. B. Lippincott & Co.')
-- ON CONFLICT (first_name, last_name) DO NOTHING;

-- INSERT INTO book (title, isbn, author_id) VALUES
-- ('The Great Gatsby', 9780743273565, 1),
-- ('To Kill a Mockingbird', 9780446310789, 2)
-- ON CONFLICT (isbn) DO NOTHING;