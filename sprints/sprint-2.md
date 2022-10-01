## 29/08/2022 a 18/09/2022

<span id="topo">

<h1 align="center">:bookmark: Primeira Entrega - SPRINT 1</h1>

<p align="center">
    <a href="#objetivos">Objetivos da sprint</a> &nbsp |&nbsp &nbsp
    <a href="#entregas">Entregas</a> &nbsp |&nbsp &nbsp
    <a href="#apresentacao">Vídeo</a> &nbsp |&nbsp &nbsp
    <a href="#burndown">Burndown</a> &nbsp |&nbsp &nbsp
    <a href="#backlogs">Backlogs</a>
</p>

Temos um desafio de sincronização dos dados administrativos, financeiros e operacionais referentes aos serviços prestados pela empresa. A falta de organização dos dados acarreta lentidão para atender chamados, e confusão na interpretação dos indicadores comerciais e financeiros.

 <br>

<span id="objetivos">
    
## :dart: Objetivos da Sprint
Os requisitos (tanto do cliente como da instituição de ensino) abrangidos para primeira sprint são:
- **RF 01:** Cadastro de Usuário
- **RF 02:** Cadastro de Equipamento
- **RF 03:** Cadastro de Serviço
- **RF 04:** Cadastro da Empresa
- **RF 05:** Listagem dos Cadastros
- **RF 06:** Modelagem do Banco de Dados
- **RF 07:** Front-end para entrada e interpretação de dados
- **RF 08:** Wireframe (Protótipo no Figma)
- **RNF 09:** Linguagem Java Web Server-Side (Requisito Exigido Fatec)
- **RNF 10:** PL / SQL (Requisito Exigido Fatec)
- **RNF 11:** GIT (Requisito Exigido Fatec)
- **RNF 12:** Vue.js (FrontEnd)
- **RNF 13:** Oracle Cloud (Requisito Exigido Fatec)
    
<br>
 
**:link: Clique no link abaixo para visualizar o *Kanban* de atividades da equipe:** 
> [Kanban Projects GitHub](https://github.com/orgs/Doc-Docker/projects/16)
  
<br>
    
<span id="entregas">
  
## :heavy_check_mark: Entregas
  
    
### :heavy_check_mark: RF 01: Cadastro de Usuário

Nessa tela o admin poderá cadastrar novos usuários (Cliente, Suporte, Administrador) com as seguintes opções:
<img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/tela4.jpeg" width="900" height="600"/></h1>
    
Segue listagem dos usuários cadastrados, foi implementado as opções de editar/excluir as informações, conforme abaixo:
<img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/tela8.jpeg" width="900" height="600"/></h1>
    
### :heavy_check_mark: RF 02: Cadastro de Equipamento

Nessa tela o admin poderá cadastrar equipamentos (Câmeras, Notebooks, Ferramentas) com as seguintes opções:
<img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/tela1.jpeg" width="900" height="600"/></h1>

Segue listagem dos equipamentos cadastrados, foi implementado as opções de editar/excluir as informações, conforme abaixo:
<img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/tela6.jpeg" width="900" height="600"/></h1>
    
    
### :heavy_check_mark: RF 03: Cadastro de Serviço

Nessas telas o admin poderá cadastrar novos serviços, com as seguintes opções:

Lembrando que temos 2 tipos de serviço (Instalação e Manutenção).

<img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/tela2.jpeg" width="900" height="600"/></h1>
<img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/tela3.jpeg" width="900" height="600"/></h1>

Segue listagem dos serviços cadastrados, foi implementado as opções de editar/excluir as informações, conforme abaixo:
<img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/tela7.jpeg" width="900" height="600"/></h1>
    
    
### :heavy_check_mark: RF 04: Cadastro da Empresa

Nessa tela o admin poderá cadastrar novas empresas (Subiter, Clientes) com as seguintes opções:
<img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/tela5.jpeg" width="900" height="600"/></h1>
    
    
### :heavy_check_mark: RF 06: Modelagem do Banco de Dados
    
Fizemos a modelagem do banco de dados para relacionamento das tabelas de cadastro conforme abaixo. Nas próximas sprints iremos vincular os dados da aplicação na nuvem, pois no momento estamos utilizando o H2 (sistema de gerenciamento de banco de dados relacional escrito em Java) para armazenamento dos dados.
 
<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/Modelo_Banco_Subiter.png" /></h1>  

    
### :heavy_check_mark: RF 08: Wireframe (Protótipo no Figma)
    
Para extrair e entender os desejos do cliente, foi construído um protótipo inicial no Figma, criando a identidade visual e design do sistema e apresentando para validação com o cliente. 
    
:link: **[Clique aqui](https://www.figma.com/community/file/1151916443098739750)** para visualizar o Wireframe do projeto.
   
    
### :heavy_check_mark: RNF 13: Oracle Cloud (Requisito Exigido Fatec)
    
Utilizando o serviço da Oracle Cloud, criamos a conta e as tabelas relacionais para utilização do Banco de Dados no projeto:
  
<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/banco2.png" /></h1>  

<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/banco1.png" /></h1>

→ [Voltar ao topo](#topo)    
    
<br>

<span id="apresentacao">
    
## 🚀 Apresentação SPRINT 1

**:link: Para visualizar a apresentação da Sprint 1 [clique aqui](https://www.youtube.com/watch?v=_yQc6W3zIGs)** 

[![](https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/youtubelogo.png)](https://www.youtube.com/watch?v=_yQc6W3zIGs) 

<br>
    
<span id="burndown">
    
## :chart_with_upwards_trend: Burndown

Em prol de um melhor aproveitamento das habilidades de cada integrante, o time foi separado em duas frentes: frontend e backend, onde, na primeira sprint, o time de frontend ficou responsável pela confecção do protótipo, projeto frontend e integração de funcionalidades enquanto o time de backend ficou responsável pela criação dos serviços necessários e pesquisas sobre o tema do desafio. 

- O acompanhamento de atividades, de responsabilidade do Scrum Master, se encontra na imagem adiante, que contém o gráfico Burndown gerado pela equipe (onde o eixo X são os dias trabalhados na sprint e os valores do eixo Y representam as entregas e esforços realizados com o passar do tempo), incluindo as atividades desenvolvidas e seus responsáveis.
    
<div align="center">
    
![Burndown Chart](https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/burndown1.png)
</div>

<br>
  
<span id="backlogs">

## 📦 Backlogs & User Stories

<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/Backlog_Produto.png" /></h1>

<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/User_Stories1.png" /></h1>

<br>

## :dart: Backlog das Sprints

<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/Backlog_Sprints1.png" /></h1>
    
<br>
  
→ [Voltar ao topo](#topo)
