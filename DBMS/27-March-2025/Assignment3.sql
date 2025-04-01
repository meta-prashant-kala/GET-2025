-- Identify the columns require indexing in order, product, category tables and create indexes.

-- Index for product table
CREATE INDEX productCategoryIdIndex
    ON product(CategoryId);

-- Index for orders table
CREATE INDEX ordersUserIdIndex
    ON orders(userId);