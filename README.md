# Sistema Locação
Sistema de gestão de locações de filmes.

## Tecnologias utilizadas:
- ReactJS
- Java
- MySql

## Como executar?
- Clona este projeto.

### Database
- O arquivo `sql_sistema_locacao.txt` contém o SQL para gerar o banco de dados no MySQL. E o arquivo `sql_inserts.txt` contém Inserts SQL de dados fictícios utilizados durante o desenvolvimento do projeto.

### Backend
- O arquivo `DataBaseLocator.java` faz a conexão da API com o Banco de Dados MySQL.
- A API foi desenvolvida utilizando o [Netbeans](https://netbeans.apache.org/download/index.html) e o Maven. O arquivo `Insomnia_2022-04-16_Sistema_Locacao.json` contém as requisições REST desenvolvidas.

### Frontend
- Abra no terminal dentro da pasta `/frontend-sistema-locacao` e utilize o comando `yarn install` para instalar as dependências do projeto.
- Após isso utilize o comando `yarn start` para rodar a aplicação SPA.
- Abra no navegador com o link: [http://localhost:3000](http://localhost:3000).