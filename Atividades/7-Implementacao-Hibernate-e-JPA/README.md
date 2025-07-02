Parte A: Criar um banco de dados chamado "vacinacao" com a tabela "Usuarios" e os seguintes campos:
id - numeric(10), primary key, auto_increment
nome - varchar(60), not null
dt_nasc - DATE, not null
sexo - varchar(10) - valores Masculino ou Feminino, not null
logradouro varchar(60), not null
numero - numeric, null
setor - varchar(40)
cidade - varchar(40)
uf - varchar(25)
Parte B: Fazer um programa (em Java) que utilize um Framework de persistência (Hibernate com JPA) para permitir as seguintes operações no banco de dados (não precisa ser Web):

Criar um menu para acesso as opções de "Consulta por ID", "Inserção", "Exclusão" e "Sair".
Implemente as funcionalidades do item 1.
Crie uma opção para listar todos os usuários.
