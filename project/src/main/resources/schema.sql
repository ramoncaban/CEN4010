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
    cardowner text NOT NULL
);

--Avid
CREATE TABLE IF NOT EXISTS books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    genre VARCHAR(50) NOT NULL,
    rating DECIMAL(2, 1) NOT NULL,
    price DECIMAL(5, 2) NOT NULL,
    isbn BIGINT UNIQUE NOT NULL,
    description TEXT,
    copies_sold INT NOT NULL,
    publisher VARCHAR(255) NOT NULL
);

--Dylan
CREATE TABLE IF NOT EXISTS shopping_cart (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS cart_items (
    id SERIAL PRIMARY KEY,
    cart_id INT NOT NULL,
    book_id INT NOT NULL,
    quantity INT NOT NULL DEFAULT 1
);

--Ros
CREATE TABLE IF NOT EXISTS book_ratings (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    rating INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    comment TEXT
);

CREATE TABLE IF NOT EXISTS book_comments (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    comment TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

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
