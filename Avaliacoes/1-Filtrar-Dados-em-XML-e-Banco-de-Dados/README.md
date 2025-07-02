Implemente um programa em Java com as seguintes características

Utilize o arquivo XML anexo para resolver as questões. 

Construa um menu com as seguintes opções:
Pesquisar por nome
Pesquisar por ano e nome
Listar todos os cursos
Exportar para um banco de dados
Sair
As opções do menu devem realizar as seguintes funcionalidades:
"opção 1": a pesquisa por nome deve avaliar tanto o nome do curso como o nome da disciplina. A pesquisa deve ser do tipo "contem", ou seja, listar todos que contenha o nome informado.
"opção 2": na pesquisa por ano e nome é preciso listar todos os cursos do ano informado e que contenham o nome como parte do nome do curso (elemento nome).
"opção 3": deve mostrar todos os cursos que estão no arquivo XML. Todos os campos devem aparecer.
"opção 4": deve transferir os dados para uma tabela no banco de dados (SGBD podem ser MySQL, MariaDB ou PostgreSQL).
Nome do banco: avaliacao1
Nome das tabelas: curso(iden, ano, nome) e disciplina (nome, ch e iden_curso) - sublinhado significa chave primária.
Ponto de atenção: se o arquivo XML possuir alguma inconsistência, você precisa adicionar uma explicação no arquivo LEIAME.TXT da falha encontrada e como você fez para trata-la/contorna-la.

Observações:

Utilize DOM e/ou XPath para manipular XML e JDBC para conexão com banco de dados.

O produto a ser entregue é um arquivo ZIP com as seguintes informações:
- script para criar o banco de dados (DDL)
- código-fonte do programa contendo somente os arquivos ".java" que foram criados para a implementação da solução. 
- se desejar, adicione um arquivo LEIAME.TXT com seus comentários e observações.
