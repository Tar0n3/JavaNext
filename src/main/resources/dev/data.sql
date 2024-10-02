-- パスワード test = $2a$10$wr/WSn.aUj0z./d9SpkVM.LrxiYmHjWhbyV0WCgvIO49IMzcO3x9y
-- usersテーブルにデータを挿入
INSERT INTO `users` (name, email, password) VALUES('abc', 'yamada@example.com', '$2a$10$wr/WSn.aUj0z./d9SpkVM.LrxiYmHjWhbyV0WCgvIO49IMzcO3x9y');

-- INSERT INTO `users` (name, email, password) VALUES
-- ('山田 太郎', 'taro.yamada@example.com', '$2a$10$wr/WSn.aUj0z./d9SpkVM.LrxiYmHjWhbyV0WCgvIO49IMzcO3x9y'),
-- ('鈴木 次郎', 'jiro.suzuki@example.com', '$2a$10$wr/WSn.aUj0z./d9SpkVM.LrxiYmHjWhbyV0WCgvIO49IMzcO3x9y'),
-- ('佐藤 花子', 'hanako.sato@example.com', '$2a$10$wr/WSn.aUj0z./d9SpkVM.LrxiYmHjWhbyV0WCgvIO49IMzcO3x9y'),
-- ('高橋 一郎', 'ichiro.takahashi@example.com', '$2a$10$wr/WSn.aUj0z./d9SpkVM.LrxiYmHjWhbyV0WCgvIO49IMzcO3x9y'),
-- ('伊藤 美咲', 'misaki.ito@example.com', '$2a$10$wr/WSn.aUj0z./d9SpkVM.LrxiYmHjWhbyV0WCgvIO49IMzcO3x9y');

-- -- brandsテーブルにデータを挿入
-- INSERT INTO `brands` (name) VALUES
-- ('ブランドA'),
-- ('ブランドB'),
-- ('ブランドC'),
-- ('ブランドD'),
-- ('ブランドE');

-- -- noticeテーブルにデータを挿入
-- INSERT INTO `notice` (title, content, created_at) VALUES
-- ('メンテナンスのお知らせ', 'システムは土曜日にメンテナンスのためダウンします。', '2023-10-01 10:00:00'),
-- ('新機能リリース', '来週、新機能のリリースを発表します。', '2023-10-02 12:00:00'),
-- ('休日スケジュール', '当社のオフィスは休日中は閉鎖されます。', '2023-10-03 09:00:00');