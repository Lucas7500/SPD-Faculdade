Implementar um programa WEB com as seguintes características:

Parte 1
Menu de acesso para as opções do sistema (index.html)
Incluir candidato: permite adicionar um candidato ao banco de dados, em seguida, redirecionar para a listagem.
Parte 2
Excluir candidato: criar botão excluir na listagem, ao clicar nesse botão deve excluir o candidato e recarregar a listagem.
Listar candidatos: uma tabela com a lista de candidatos. Com link para retornar ao index.html
Alterar dados do candidato

Candidato

codigo INT PK
nome varchar(60)
sexo char(1)
data_nasc DATE
cargo_pretendido varchar(25)
texto_curriculo varchar(800)

Utiliza o driver JDBC e banco de dados MariaDB/MySQL/Postgres.
