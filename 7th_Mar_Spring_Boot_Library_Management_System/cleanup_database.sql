-- Cleanup script for Library Management System
-- Run this in pgAdmin or PostgreSQL client if you still face issues

-- Drop all tables in correct order (respecting foreign key constraints)
DROP TABLE IF EXISTS borrow_records CASCADE;
DROP TABLE IF EXISTS books CASCADE;
DROP TABLE IF EXISTS users CASCADE;

-- Verify tables are dropped
SELECT tablename FROM pg_tables WHERE schemaname = 'public';

