-- Index for product table
CREATE INDEX productCategoryIdIndex
    ON product(CategoryId);

-- Index for orders table
CREATE INDEX ordersUserIdIndex
    ON orders(userId);