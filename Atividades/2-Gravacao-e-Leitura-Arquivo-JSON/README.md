Parte A: Crie, em Java, a classe Funcionario, com os seguintes atributos:
cpf - String
nome - String
idade - int
salario - double
cargo - String
habilidades - Lista de Strings (ArrayList)
Parte B: Gravação e Pesquisa de funcionários em arquivos JSON.

Em um programa Java faça a leitura dos dados citado na Parte A  (dados acima) e instancie um objeto Funcionario com esses dados. Em seguida, utilizando a API Gson para converter o objeto funcionario em JSON e grave os dados em um arquivo chamado cpf.json (onde cpf é o número do cpf do funcionário - ou seja, cada pessoa será gravada em um arquivo diferente).

Crie uma nova funcionalidade para ler o cpf do funcionário, e então "abra o arquivo json" com este cpf e instancie um objeto funcionário com os dados lidos. Em eguida, escreva os dados do funcionário - se não existir o cpf informado, dê uma mensagem adequada.
