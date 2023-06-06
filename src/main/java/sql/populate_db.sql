-- Вставка працівників
INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES
  ('John Doe', '1990-05-10', 'Trainee', 800),
  ('Jane Smith', '1985-08-15', 'Junior', 1200),
  ('Mark Johnson', '1982-03-20', 'Middle', 3000),
  ('Emily Williams', '1978-12-05', 'Senior', 7000),
  ('Michael Brown', '1992-06-25', 'Junior', 1500),
  ('Sarah Davis', '1991-09-30', 'Middle', 4000),
  ('Robert Taylor', '1989-02-12', 'Senior', 9000),
  ('Jennifer Anderson', '1987-07-18', 'Trainee', 900),
  ('David Wilson', '1984-11-23', 'Middle', 3500),
  ('Jessica Martinez', '1980-04-07', 'Junior', 1800);

-- Вставка клієнтів
INSERT INTO client (NAME)
VALUES
  ('Client A'),
  ('Client B'),
  ('Client C'),
  ('Client D'),
  ('Client E');

-- Вставка проєктів
INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE)
VALUES
  (1, '2022-01-01', '2022-04-30'),
  (2, '2022-03-15', '2022-06-30'),
  (3, '2022-05-10', '2022-08-15'),
  (4, '2022-07-01', '2022-12-31'),
  (5, '2022-09-15', '2023-02-28'),
  (1, '2022-11-01', '2023-04-30'),
  (3, '2023-01-10', '2023-06-30'),
  (3, '2023-03-15', '2023-09-30'),
  (4, '2023-05-01', '2023-11-30'),
  (5, '2023-07-15', '2024-01-31');

-- Вставка працівників на проєкти
INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES
  (1, 1),
  (1, 2),
  (2, 3),
  (2, 4),
  (2, 5),
  (3, 6),
  (3, 7),
  (4, 8),
  (4, 9),
  (4, 10),
  (5, 1),
  (5, 3),
  (6, 2),
  (6, 4),
  (7, 5),
  (7, 6),
  (8, 7),
  (9, 8),
  (9, 9),
  (9, 10),
  (10, 1),
  (10, 2),
  (10, 3);


