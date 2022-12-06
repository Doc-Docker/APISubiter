## 07/11/2022 a 27/11/2022

<span id="topo">

<h1 align="center">:bookmark: Quarta Entrega - SPRINT 4</h1>

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
- **RF 07:** Front-end para entrada e interpretação de dados
- **RNF 11:** GIT (Requisito Exigido Fatec)
- **RF 21:** Equipamentos no estoque
- **RF 22:** Agendamento dos Chamados
- **RF 23:** Aparência e design
- **RF 24:** Melhorias e Correções de bugs
- **RF 25:** Mapeamento (Bônus)  
    
<br>
 
**:link: Clique no link abaixo para visualizar o *Kanban* de atividades da equipe:** 
> [Kanban Projects GitHub](https://github.com/orgs/Doc-Docker/projects/16)
  
<br>
    
<span id="entregas">
  
## :heavy_check_mark: Entrega

### :heavy_check_mark: RF 25: Mapeamento (Bônus)
    
Foi implementado um sistema de Mapeamento através de um "Painter Web", onde o suporte consegue desenhar e indicar com várias formas onde está o defeito do barco após a análise da visita.
    
O usuário consegue fazer o upload de um arquivo (png) e acessar diversas ferramentas de edição, por exemplo, lápis, formas, borracha, linhas, cadeado para travar o desenho, entre outras funcionaliades que o sistema entrega. Vale ressaltar que esse mapeamento foi uma entrega "bônus" para o cliente, conforme alinhado nos requisitos opcionais.
 
<br>    
    
### :heavy_check_mark: RF 21: Equipamentos no Estoque 
    
Agora o usuário "Suporte" consegue visualizar se o equipamento que será utilizado no serviço do chamado, está disponível para o agendamento. Após a finalização do chamado, o número de série é retornado para o estoque, ficando apto para a escolha novamente.
    
<br>    
    
### :heavy_check_mark: RF 23: Melhorias em todas as telas (Aparência e Design)

Fizemos melhorias no layout de todas as telas do sistema, utilizando UX/UI design com as cores da Subiter, conforme alinhado com o cliente. Dessa forma o usuário pode ter uma experiência visual melhor na utilização do site, com os cadastros e listagens que foram implementados nas outras sprints.
    
#### 🚀 RF 23: Tela de Chamados
    
<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/1chamado.jpeg" /></h1>
    
#### 🚀 RF 23: Tela de Empresas
    
<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/2empresa.jpeg" /></h1>    
    
#### 🚀 RF 23: Tela de Equipamentos
    
<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/3equipamento.jpeg" /></h1>
    
#### 🚀 RF 23: Tela de Usuários
    
<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/4usu%C3%A1rio.jpeg" /></h1>
    
#### 🚀 RF 23: Tela de Serviço (Inspeção) 
   
<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/5servi%C3%A7o.jpeg" /></h1>    
    
<br>
    
## 🐳 Requisitos para instalação do projeto no Docker

Pré requisitos para rodar o serviço localmente:

- Docker installed (https://docs.docker.com/get-docker/) – Guia de como instalar o docker.

Utilizando docker podemos subir o serviço utilizando linha de comando ou o docker desktop, nosso serviço tem duas imagens dockers que devem ser subidos em containers separados, de acordo com a recomendação da ferramenta.

“Don't make monolithic containers.”

Portanto vamos trabalhar nessa ideia. Para cada sprint temos uma versão de front-end e uma versão de back-end, para utilização completa do serviço, devemos obrigatoriamente utilizar os dois microservices, com as versões corretas.

<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/dockertutorial.png" /></h1>

Na imagem acima vemos quais versões atualmente temos, em ambos os serviços temos lançado até o momento 3 versões, se o desejado é utilizar a versão 2.0.0, por exemplo, ambos os serviços devem ser utilizados na versão 2.0.0, tanto do front-end quanto do back-end.

**Fazer pull das images:**

```
docker pull apidocdocker/<service-name>:<tagname>
```

**Subir o Container:**

```
docker run -p <image-port>:<local-port> <service-name>:<tag-name>
```

**Exemplo: Fazer pull e rodar o container do back-end**
```
docker pull apidocdocker/subter-backend:4.0.0
```

```
docker run -p 8080:8080 apidocdocker/subter-backend:4.0.0
```
A aplicação do backend por padrão, dentro do container, roda na porta 8080, quando colocamos "-p 8080:8080" estamos dizendo que queremos que o que esteja rodando na porta 8080 do container reflita para a porta 8080 local, ou qualquer porta desejada.

O mesmo é feito para o front-end, a porta padrão da aplicação é 4200, o que significa que teríamos que utilizar o "-p 4200:4200" ou a porta desejada.    
   
<br>
    
## 🚀 Apresentação SPRINT 4

**:link: Para visualizar a apresentação da Sprint 4 [clique aqui](https://www.youtube.com/watch?v=yVF6tg5Zu9Q&ab_channel=DocDocker)** 

[![](https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/youtubelogo.png)](https://www.youtube.com/watch?v=yVF6tg5Zu9Q&ab_channel=DocDocker)    
    
<br>    
    
<span id="burndown">
    
## :chart_with_upwards_trend: Burndown

Em prol de um melhor aproveitamento das habilidades de cada integrante, o time foi separado em duas frentes: frontend e backend, onde, na primeira sprint, o time de frontend ficou responsável pela confecção do protótipo, projeto frontend e integração de funcionalidades enquanto o time de backend ficou responsável pela criação dos serviços necessários e pesquisas sobre o tema do desafio. 

- O acompanhamento de atividades, de responsabilidade do Scrum Master, se encontra na imagem adiante, que contém o gráfico Burndown gerado pela equipe (onde o eixo X são os dias trabalhados na sprint e os valores do eixo Y representam as entregas e esforços realizados com o passar do tempo), incluindo as atividades desenvolvidas e seus responsáveis.
    
<div align="center">
    
![Burndown Chart](https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/burndown4.png)
</div>

<br>
  
<span id="backlogs">

## 📦 Backlog de Produto

<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/Backlog_Produto_4.png" /></h1>
    
<br>

## :dart: Backlog das Sprints

<h1 align="center"> <img src = "https://github.com/Doc-Docker/APISubiter/blob/main/docs/Imagens/Backlog_Sprints3.PNG" /></h1>
    
<br>
  
→ [Voltar ao topo](#topo)
