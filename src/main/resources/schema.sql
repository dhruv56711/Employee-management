CREATE TABLE IF NOT EXISTS Employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    department VARCHAR(255) NOT NULL,
    startDate DATE NOT NULL,
    endDate DATE,
    age INT NOT NULL
);
