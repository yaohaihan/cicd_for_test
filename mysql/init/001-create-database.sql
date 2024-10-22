-- 创建名为 cicd_for_test 的数据库
CREATE DATABASE IF NOT EXISTS cicd_for_test
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

-- 切换到 cicd_for_test 数据库
USE cicd_for_test;


CREATE TABLE tb_user (
                         userId INT AUTO_INCREMENT PRIMARY KEY,
                         Username VARCHAR(50) NOT NULL,
                         Password VARCHAR(255) NOT NULL,
                         gender ENUM('male', 'female') NOT NULL,
                         email VARCHAR(100) NOT NULL UNIQUE,
                         status ENUM('Public', 'Protected') NOT NULL,
                         createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Record (
                        recordId INT AUTO_INCREMENT PRIMARY KEY,
                        userId INT,
                        Title VARCHAR(100) NOT NULL,
                        Content TEXT NOT NULL,
                        Mood INT,
                        createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        FOREIGN KEY (userId) REFERENCES tb_user(userId) ON DELETE CASCADE
);

CREATE TABLE Post (
                      postId INT AUTO_INCREMENT PRIMARY KEY,
                      recordId INT,
                      userId INT,
                      createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      FOREIGN KEY (recordId) REFERENCES Record(recordId) ON DELETE CASCADE,
                      FOREIGN KEY (userId) REFERENCES tb_user(userId) ON DELETE CASCADE
);

CREATE TABLE Likes (
                       likeId INT AUTO_INCREMENT PRIMARY KEY,
                       postId INT,
                       userId INT,
                       createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (postId) REFERENCES Post(postId) ON DELETE CASCADE,
                       FOREIGN KEY (userId) REFERENCES tb_user(userId) ON DELETE CASCADE,
                       UNIQUE (postId, userId)
);

CREATE TABLE Friendship (
                            friendshipId INT AUTO_INCREMENT PRIMARY KEY,
                            userId1 INT,
                            userId2 INT,
                            createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            FOREIGN KEY (userId1) REFERENCES tb_user(userId) ON DELETE CASCADE,
                            FOREIGN KEY (userId2) REFERENCES tb_user(userId) ON DELETE CASCADE,
                            UNIQUE (userId1, userId2)
);

CREATE TABLE MoodHistory (
                             moodHistoryId INT AUTO_INCREMENT PRIMARY KEY,
                             userId INT,
                             mood INT,
                             createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             FOREIGN KEY (userId) REFERENCES tb_user(userId) ON DELETE CASCADE
);


CREATE TABLE photo (
                       photo_id INT PRIMARY KEY AUTO_INCREMENT,
                       record_id INT,
                       photo_data BLOB,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (record_id) REFERENCES Record(recordId)
);


ALTER TABLE tb_user ADD COLUMN avator BLOB;


ALTER TABLE tb_user MODIFY COLUMN avator LONGBLOB;

ALTER TABLE photo MODIFY COLUMN photo_data LONGBLOB;
