-- Criação da tabela 'Skills' para armazenar as habilidades
CREATE TABLE Skills (
    id SERIAL PRIMARY KEY,              -- 'id' é a chave primária única para cada skill, gerada automaticamente (SERIAL)
    nome VARCHAR(255) NOT NULL,         -- 'nome' é o nome da skill, obrigatório (NOT NULL) e limitado a 255 caracteres
    descricao TEXT,                     -- 'descricao' é uma descrição opcional da skill, de tamanho variável (TEXT)
    imagem_url VARCHAR(255)             -- 'imagem_url' é o link opcional para uma imagem associada à skill, limitado a 255 caracteres
);

-- Criação da tabela 'Usuarios' para armazenar informações dos usuários
CREATE TABLE Usuarios (
    id SERIAL PRIMARY KEY,              -- 'id' é a chave primária única para cada usuário, gerada automaticamente (SERIAL)
    login VARCHAR(255) UNIQUE NOT NULL, -- 'login' é o nome de usuário, deve ser único (UNIQUE) e obrigatório (NOT NULL), limitado a 255 caracteres
    senha VARCHAR(255) NOT NULL,        -- 'senha' é a senha do usuário, obrigatória (NOT NULL) e limitada a 255 caracteres
    role VARCHAR(50) NOT NULL           -- 'role' é o papel/função do usuário no sistema, obrigatório (NOT NULL) e limitado a 50 caracteres
);

-- Criação da tabela 'Usuarios_Skills' para relacionar usuários com suas habilidades
CREATE TABLE Usuarios_Skills (
    id SERIAL PRIMARY KEY,              -- 'id' é a chave primária única para cada relação, gerada automaticamente (SERIAL)
    usuario_id INTEGER NOT NULL,        -- 'usuario_id' é uma chave estrangeira que referencia a tabela 'Usuarios', obrigatório (NOT NULL)
    skill_id INTEGER NOT NULL,          -- 'skill_id' é uma chave estrangeira que referencia a tabela 'Skills', obrigatório (NOT NULL)
    level VARCHAR(50),                  -- 'level' indica o nível de habilidade do usuário, opcional e limitado a 50 caracteres
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES Usuarios(id) ON DELETE CASCADE, -- Criação de uma chave estrangeira que referencia o 'id' da tabela 'Usuarios'. Se um usuário for excluído, todas as suas habilidades associadas também serão excluídas (ON DELETE CASCADE)
    CONSTRAINT fk_skill FOREIGN KEY (skill_id) REFERENCES Skills(id) ON DELETE CASCADE,       -- Criação de uma chave estrangeira que referencia o 'id' da tabela 'Skills'. Se uma skill for excluída, todas as suas associações com usuários também serão excluídas (ON DELETE CASCADE)
    UNIQUE (usuario_id, skill_id)       -- Criação de uma restrição que garante que cada usuário pode ter uma associação única com cada skill (não pode haver duplicação)
);
