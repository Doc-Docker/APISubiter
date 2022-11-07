## 13/10/2022 a 06/11/2022

<span id="topo">

<h1 align="center">:bookmark: Terceira Entrega - SPRINT 3</h1>

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
Os requisitos (tanto do cliente como da instituição de ensino) abrangidos para terceira sprint são:
- **RF 06:** Modelagem do Banco de Dados
- **RF 07:** Front-end para entrada e interpretação de dados
- **RNF 11:** GIT (Requisito Exigido Fatec)
- **RF 17:** Níveis de Acesso (Cliente, Suporte, Admin)
- **RF 19:** Melhorias e Correção de Bugs
- **RF 20:** Melhoria no layout das telas
  
<br>
 
**:link: Clique no link abaixo para visualizar o *Kanban* de atividades da equipe:** 
> [Kanban Projects GitHub](https://github.com/orgs/Doc-Docker/projects/16)
  
<br>
    
<span id="entregas">
  
## :heavy_check_mark: Entrega

### :heavy_check_mark: RF 20: Tela de Login (Melhoria no layout)

Foi implementado a tela de login com um layout interativo com as cores da empresa Subiter. Agora o usuário consegue acessar com seu e-mail e senha de forma segura no sistema.
    
<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/tela_de_login.jpeg" /></h1>
 
    
### :heavy_check_mark: RF 20: Tela Abertura de Chamado (Melhoria no layout)
    
Na tela de abertura de chamado, o usuário tem uma experiência melhor com o novo visual implementado nessa sprint.
    
<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/tela_abrir_chamado.jpeg" /></h1>

    
### :heavy_check_mark: Apresentação Sprint-3 (Acessos)
    
Nessa sprint, fizemos a implementação do spring security para os níveis de acesso (Cliente, Suporte e Admin), sendo assim, agora é possível visualizar as telas com as permissões abaixo:

#### Cliente:
- Consegue abrir um chamado na tela de cadastro de chamado.
- Tem acesso a listagem dos chamados abertos (listagem cliente).
 
#### Suporte:
- Tem acesso a todas as listagens.
- Consegue retornar com uma solução para os chamados abertos.
- O suporte não consegue cadastrar nada, apenas visualizar as informações. 
    
#### Admin:
- Tem acesso a todas as telas de cadastro (Equipamento, Usuário, Empresa, Serviço)
- Pode visualizar e editar todas as listagens.
- O admin não consegue abrir um chamado (única tela que ele não terá acesso, apenas o cliente)

**:link: Para visualizar a apresentação da Sprint 3 [clique aqui](https://www.youtube.com/watch?v=yi-ClRo_RMg)** 

[![](https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/youtubelogo.png)](https://www.youtube.com/watch?v=yi-ClRo_RMg)

→ [Voltar ao topo](#topo)
    
### :heavy_check_mark: RF 06: Modelagem do Banco de Dados
    
Atualizamos a modelagem do banco de dados nas tabelas de "Serviço" e "Chamado", pois agora temos apenas 1 tipo de serviço "Inspeção", conforme acordado com o cliente. Adicionamos a tabela "Serviço_Equipamento" que liga todos os equipamentos que serão utilizados no chamado, iremos implementar esse sistema de equipamentos no estoque na próxima sprint.
    
<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/modelagem_sprint3.jpg" /></h1>  
    
<br>
    
<span id="burndown">
    
## :chart_with_upwards_trend: Burndown

Em prol de um melhor aproveitamento das habilidades de cada integrante, o time foi separado em duas frentes: frontend e backend, onde, na primeira sprint, o time de frontend ficou responsável pela confecção do protótipo, projeto frontend e integração de funcionalidades enquanto o time de backend ficou responsável pela criação dos serviços necessários e pesquisas sobre o tema do desafio. 

- O acompanhamento de atividades, de responsabilidade do Scrum Master, se encontra na imagem adiante, que contém o gráfico Burndown gerado pela equipe (onde o eixo X são os dias trabalhados na sprint e os valores do eixo Y representam as entregas e esforços realizados com o passar do tempo), incluindo as atividades desenvolvidas e seus responsáveis.
    
<div align="center">
    
![Burndown Chart](https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/burndown3.png)
</div>

<br>
  
<span id="backlogs">

## 📦 Backlogs & User Stories

<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/Backlog_Produto_3.png" /></h1>

<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/userstoriesprint3.png" /></h1>
    
<br>

## :dart: Backlog das Sprints

<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/Backlog_Sprints3.PNG" /></h1>
    
<br>
  
→ [Voltar ao topo](#topo)
