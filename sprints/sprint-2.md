## 19/09/2022 a 09/10/2022

<span id="topo">

<h1 align="center">:bookmark: Segunda Entrega - SPRINT 2</h1>

<p align="center">
    <a href="#objetivos">Objetivos da sprint</a> &nbsp |&nbsp &nbsp
    <a href="#entregas">Entregas</a> &nbsp |&nbsp &nbsp
    <a href="#burndown">Burndown</a> &nbsp |&nbsp &nbsp
    <a href="#backlogs">Backlogs</a>
</p>

Temos um desafio de sincronização dos dados administrativos, financeiros e operacionais referentes aos serviços prestados pela empresa. A falta de organização dos dados acarreta lentidão para atender chamados, e confusão na interpretação dos indicadores comerciais e financeiros.

 <br>

<span id="objetivos">
    
## :dart: Objetivos da Sprint
Os requisitos (tanto do cliente como da instituição de ensino) abrangidos para segunda sprint são:
- **RF 06:** Modelagem do Banco de Dados
- **RF 07:** Front-end para entrada e interpretação de dados
- **RF 14:** Registro de Chamados
- **RF 15:** Status dos Chamados
- **RF 16:** Listagem dos Chamados
- **RF 17:** Níveis de Acesso (Cliente, Suporte, Admin)
- **RF 18:** Vue.js (FrontEnd)
- **RF 19:** Melhorias e Correção de Bugs
- **RNF 11:** GIT (Requisito Exigido Fatec)
- **RNF 13:** Oracle Cloud (Requisito Exigido Fatec)
  
<br>
 
**:link: Clique no link abaixo para visualizar o *Kanban* de atividades da equipe:** 
> [Kanban Projects GitHub](https://github.com/orgs/Doc-Docker/projects/16)
  
<br>
    
<span id="entregas">
  
## :heavy_check_mark: Entregas
    
### :heavy_check_mark: RF 06: Modelagem do Banco de Dados
 
Atualizamos a modelagem do banco de dados para relacionamento das tabelas de "CHAMADO" e "AGENDAMENTO_CHAMADO" conforme abaixo. Nas próximas sprints iremos vincular os dados da aplicação na nuvem, pois no momento estamos utilizando o H2 (sistema de gerenciamento de banco de dados relacional escrito em Java) para armazenamento dos dados.
    
<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/Modelo%20Subiter_sprint2-1.png" /></h1>  

### :heavy_check_mark: RF 14: Registro de Chamados

Nessa tela o cliente conseguirá abrir um novo chamado para prestação de serviço ou suporte, com as seguintes opções:
    
Conforme alinhado com a empresa, implementamos um sistema de "Criticidade do Chamado" onde o cliente pode colocar o nível de urgência daquele pedido, podendo optar por "Baixo, Médio, Alto". Também temos o campo com o "Tipo de Chamado" que irá especificar qual serviço o suporte deverá prestar nesse caso.
 
<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/telaCadChamado.png" /></h1>  
    
### :heavy_check_mark: RF 15: Status dos Chamados (Listagem Cliente)
    
O cliente poderá visualizar e acompanhar suas solicitações, sendo possível verificar os status de cada chamado (Aberto, Em Andamento, Encerrado).
    
Também temos os campos abaixo que exibem mais informações dos chamados:
    
- Tipo de Chamado (Serviços)
- Criticidade
- Data de Abertura do Chamado
- Situação (Status)
- Solução (enviada pelo acesso do Suporte)
- Data de encerramento do chamado
- Opção de editar seu próprio chamado

<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/telaChamadoCliente.png" /></h1>  
    
### :heavy_check_mark: RF 16: Listagem dos Chamados (Suporte)

O usuário do tipo Suporte conseguirá acompanhar as solicitações abertas pelo cliente e retornar com uma solução (nas próximas sprints iremos implementar um sistema de agendamento para os serviços).
    
É possível acompanhar os status dos chamados e escolher entre a opção de aceitar ou não, o suporte pode retornar com a solução do problema preenchendo o campo texto, conforme abaixo:

<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/telaChamadoSuporte.png" /></h1>  

→ [Voltar ao topo](#topo)
    
<br>
    
<span id="burndown">
    
## :chart_with_upwards_trend: Burndown

Em prol de um melhor aproveitamento das habilidades de cada integrante, o time foi separado em duas frentes: frontend e backend, onde, na primeira sprint, o time de frontend ficou responsável pela confecção do protótipo, projeto frontend e integração de funcionalidades enquanto o time de backend ficou responsável pela criação dos serviços necessários e pesquisas sobre o tema do desafio. 

- O acompanhamento de atividades, de responsabilidade do Scrum Master, se encontra na imagem adiante, que contém o gráfico Burndown gerado pela equipe (onde o eixo X são os dias trabalhados na sprint e os valores do eixo Y representam as entregas e esforços realizados com o passar do tempo), incluindo as atividades desenvolvidas e seus responsáveis.
    
<div align="center">
    
![Burndown Chart](https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/burndown-2.png)
</div>

<br>
  
<span id="backlogs">

## 📦 Backlogs & User Stories

<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/Backlog_Produto_2.png" /></h1>

<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/user_stories.png" /></h1>
    
<br>

## :dart: Backlog das Sprints

<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/Backlog_Sprints2.png" /></h1>
    
<br>
  
→ [Voltar ao topo](#topo)
