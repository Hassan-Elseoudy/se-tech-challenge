CREATE TABLE supplier
(
    id      INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name    VARCHAR(255),
    address VARCHAR(255),
    zip     VARCHAR(10),
    city    VARCHAR(50),
    country VARCHAR(50)
);

CREATE TABLE activity
(
    id            INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    title         VARCHAR(255),
    price         DECIMAL(10, 2),
    currency      VARCHAR(10),
    rating        DECIMAL(2, 1),
    special_offer BOOLEAN,
    supplier_id   INTEGER REFERENCES supplier (id)
);

-- Create index for full text search on title, using GIN index, which is optimized for full text search
CREATE INDEX title_gin_idx ON activity USING gin(to_tsvector('english', title));
