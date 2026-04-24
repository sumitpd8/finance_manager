-- Add user display name
ALTER TABLE users
ADD COLUMN name VARCHAR(100);

-- Increase email length for better compatibility
ALTER TABLE users
ALTER COLUMN email TYPE VARCHAR(100);

-- Make password nullable for OAuth users
ALTER TABLE users
ALTER COLUMN password_hash DROP NOT NULL;

-- Track authentication provider
ALTER TABLE users
ADD COLUMN auth_provider VARCHAR(20) NOT NULL DEFAULT 'LOCAL';

-- Store external provider unique ID (Google OAuth)
ALTER TABLE users
ADD COLUMN provider_id VARCHAR(255);

-- Soft delete / account activation support
ALTER TABLE users
ADD COLUMN is_active BOOLEAN NOT NULL DEFAULT TRUE;

-- Track profile updates
ALTER TABLE users
ADD COLUMN updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;