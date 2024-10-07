
CREATE TABLE "users" (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    first_name_kana VARCHAR(50),
    last_name_kana VARCHAR(50),
    birth_date DATE,
    gender VARCHAR(10),
    phone_number VARCHAR(15),
    is_active BOOLEAN DEFAULT TRUE,
    last_login_at TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE prefectures (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    kana VARCHAR(50) NOT NULL,
    region VARCHAR(50)
);

CREATE TABLE addresses (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    address_type VARCHAR(10),
    postal_code CHAR(7) NOT NULL,
    prefecture_id INT REFERENCES prefectures(id),
    city VARCHAR(100) NOT NULL,
    town VARCHAR(100) NOT NULL,
    block VARCHAR(50) NOT NULL,
    building VARCHAR(100),
    is_default BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ブランドテーブルの作成
CREATE TABLE brands (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    logo VARCHAR(255),
    is_deleted INTEGER DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- カテゴリーテーブルの作成
CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    parent_category_id INT REFERENCES categories(id),
    description TEXT,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 商品テーブルの作成
CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    description TEXT,
    sku VARCHAR(50) UNIQUE,
    brand_id INT REFERENCES brands(id),
    category_id INT REFERENCES categories(id),
    base_price DECIMAL(10, 2) NOT NULL,
    tax_rate DECIMAL(5, 2) DEFAULT 0.10,
    is_active BOOLEAN DEFAULT TRUE,
    is_featured BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    published_at TIMESTAMP
);

-- パスワード test = $2a$10$wr/WSn.aUj0z./d9SpkVM.LrxiYmHjWhbyV0WCgvIO49IMzcO3x9y
INSERT INTO users (username, email, password_hash, first_name, last_name, first_name_kana, last_name_kana, birth_date, gender, phone_number)
VALUES 
('tanaka', 'tanaka@example.com', '$2a$10$wr/WSn.aUj0z./d9SpkVM.LrxiYmHjWhbyV0WCgvIO49IMzcO3x9y', '太郎', '田中', 'タロウ', 'タナカ', '1980-01-01', 'male', '090-1234-5678'),
('yoshida', 'yoshida@example.com', '$2a$10$wr/WSn.aUj0z./d9SpkVM.LrxiYmHjWhbyV0WCgvIO49IMzcO3x9y', '花子', '吉田', 'ハナコ', 'ヨシダ', '1990-02-02', 'female', '080-2345-6789'),
('kato', 'kato@example.com', '$2a$10$wr/WSn.aUj0z./d9SpkVM.LrxiYmHjWhbyV0WCgvIO49IMzcO3x9y', '一郎', '加藤', 'イチロウ', 'カトウ', '1985-03-03', 'male', '070-3456-7890'),
('inoue', 'inoue@example.com', '$2a$10$wr/WSn.aUj0z./d9SpkVM.LrxiYmHjWhbyV0WCgvIO49IMzcO3x9y', '次郎', '井上', 'ジロウ', 'イノウエ', '1995-04-04', 'male', '060-4567-8901');


INSERT INTO prefectures (name, kana, region)
VALUES 
('東京都', 'とうきょうと', '関東'),
('大阪府', 'おおさかふ', '近畿'),
('北海道', 'ほっかいどう', '北海道');

-- ブランドデータの挿入
INSERT INTO brands (name, description, logo) VALUES
('自社ブランド', '当社のメインブランド', 'http://example.com/logos/own_brand.png'),
('パートナーブランドA', '高品質な商品を提供するパートナー', 'http://example.com/logos/partner_a.png');

-- カテゴリーデータの挿入
INSERT INTO categories (name, parent_category_id, description) VALUES
('衣類', NULL, '全ての衣類商品'),
('トップス', 1, 'シャツ、Tシャツなど'),
('ボトムス', 1, 'パンツ、スカートなど');

-- 商品データの挿入
INSERT INTO products (name, description, sku, brand_id, category_id, base_price, tax_rate, is_active, is_featured) VALUES
('シンプルTシャツ', '柔らかな肌触りの定番Tシャツ', 'SKU001', 1, 2, 2000.00, 0.10, TRUE, FALSE),
('デザインジーンズ', 'スタイリッシュなデザインジーンズ', 'SKU002', 2, 3, 8000.00, 0.10, TRUE, TRUE);


CREATE TABLE notices (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    is_deleted INTEGER DEFAULT 0,
    priority INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO notices (title, content, is_deleted, priority)
VALUES
    ('夏季セール開始のお知らせ', 
     '7月1日から夏季セールを開始します。全商品最大50%オフ！この機会をお見逃しなく。',
     0,
     10),

    ('システムメンテナンスのお知らせ', 
     '7月15日午前2時から4時まで、システムメンテナンスを実施いたします。この間はサービスをご利用いただけません。ご不便をおかけして申し訳ございません。',
     0,
     20),

    ('新商品入荷のお知らせ', 
     '人気ブランドの秋冬新作が入荷しました！最新のファッショントレンドをチェックしてください。',
     0,
     5),

    ('ポイント2倍キャンペーン', 
     '8月5日から8月20日まで、全商品購入でポイントが通常の2倍になります！この機会にぜひお買い物をお楽しみください。',
     0,
     15),

    ('お客様感謝デー開催', 
     '日頃の感謝を込めて、9月1日に特別セールを開催いたします。会員様限定で追加割引も！',
     0,
     10);