[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/nOVrYi30)
# Atividade 2

## Identificação do aluno

Altere o arquivo *pom.xml* editando a seção *developers*, substituindo seu RA, nome e e-mail dentro do elemento *developer* nos elementos *id*, *name* e *email*, respectivamente. Por exemplo,

```XML
<developers>
        <developer>
            <id>a1234567</id>
            <name>João da Silva</name>
            <organization>UTFPR</organization>
            <email>jsilva@alunos.utfpr.edu.br</email>
        </developer>
</developers>
```

## Tarefas

### Banco de dados de estados e cidades

Tome por base o que foi implementado nesta aplicação:

https://github.com/CSM41-WEB/csm41-exemplos-demo-cidades

Crie uma tabela de banco de dados para armazenar os registros de estados,
da mesma forma como aparecem no arquivo *estados.csv*, exceto que ao invés
de armazenar o texto literal que consta do arquivo, substitua pela sigla
da região (CO, N, NE, S e SE). Note que o mapeamento de estado deve conter uma
referência à capital (município).

Crie uma tabela de banco de dados para armazenar os registros de municípios,
da mesma forma como aparecem no arquivo *municipios.csv*.

Especifique chaves primárias e estrangeiras compatíveis com o relacionamento
entre estados e municípios.

Popule as tabelas com os dados dos respectivos arquivos.

Crie classes de mapeamento objeto-relacionais para representar estados e municípios,
devendo incluir os relacionamentos um-para-muitos e muitos-para-um existentes
entre as tabelas.

Implemente *endpoints* (URLs) para as seguintes operações:

* Obter a relação de todos os estados
* Obter as informações de um estado específico
* Obter a relação de todos os municípios, com a possibilidade de paginação
* Obter a relação de todos os municípios de um determinado estado
* Obter as informações de um município específico


### Operações de cadastro e edição de jogador

Implemente *endpoints* (URLs) para as seguintes operações:

* Inserir o cadastro de um novo jogador
* Atualizar os dados de um jogador existente
* Excluir um registro de jogador juntamente com todos os seus jogos
* Excluir um jogo específico de um jogador
* Excluir todos os jogos de um jogador específico
* Atualizar os dados de um jogo específico de um jogador

Implementar todas as validações necessárias para impedir que registros
inconsistentes sejam inseridos.


## Implantação da aplicação (Webservice REST)

A aplicação deve ser implantada em um contêiner no servidor remoto dentro
da infraestrutura da AWS (Learner Lab). Utilizar um contêiner nativo.

O banco de dados deve obrigatoriamente estar em um contêiner separado da
aplicação.

## Avaliação

Após completar a atividade, usando o Git, faça *commit* e *push* para este repositório. Você pode fazer o *push* quantas vezes quiser,
será considerado para avaliação o último *commit*.

Esta atividade deve ser entregue PRESENCIALMENTE e impreterivelmente até **14/06/2023 às 17h50min** e contará **4 pontos da nota final**.

Nos dias dias 14/06/2023 e 15/06/2023, no horário da aula, os alunos serão convocados individualmente a, apresentar o código fonte implementado
e demonstrar as funcionalidades implementadas no servidor remoto.

**As operações aqui implementadas serão usadas na atividade 03, portanto, poderá
ter impactos sobre a próxima avaliação.**
