INSERT INTO question (id, description, technology) VALUES
('-1', 'Como criar uma classe em Java?', 'JAVA'),
('-2', 'Explique o conceito de polimorfismo em Java?', 'JAVA'),
('-3', 'Como lidar com exceções em Java?', 'JAVA')
ON CONFLICT DO NOTHING;

INSERT INTO alternative (id, question_id, is_correct, description) VALUES
('-1', '-1', true, 'Usando a palavra-chave "class"'),
('-2', '-1', false, 'Definindo uma interface em Java'),
('-3', '-1', false, 'Utilizando métodos estáticos'),
('-4', '-1', false, 'Criando um construtor padrão')
ON CONFLICT DO NOTHING;

INSERT INTO alternative (id, question_id, is_correct, description) VALUES
('-5', '-2', false, 'Herança simples'),
('-6', '-2', false, 'Encapsulamento em Java'),
('-7', '-2', false, 'Sobrecarga métodos'),
('-8', '-2', true, 'Capacidade de um objeto de assumir várias formas')
ON CONFLICT DO NOTHING;

INSERT INTO alternative (id, question_id, is_correct, description) VALUES
('-9', '-3', false, 'Ignorando a exceção'),
('-10', '-3', true, 'Utilizando blocos try-catch'),
('-11', '-3', false, 'Declarando uma exceção sem tratamento'),
('-12', '-3', false, 'Usando a palavra-chave "finally"')
ON CONFLICT DO NOTHING;