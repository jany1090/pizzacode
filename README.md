# PizzaCode

Projeto  de API RESTful em Java Spring

Uma Atividade do #Elastech, uma parceria do PagBank com a SoulCode
Bem-vindo ao repositório do projeto PizzaCode! Este é um projeto de API RESTful desenvolvido em Java com o framework Spring, focado no back-end para uma pizzaria fictícia chamada PizzaCode.

Sobre o Projeto
O objetivo deste projeto é criar uma API robusta para gerenciar as operações de uma pizzaria, desde o cadastro de clientes até o registro de pedidos e controle de ingredientes.

Entidades
O projeto foi construído com base em um modelo entidade-relacionamento (ER), resultando nas seguintes entidades:

Pizza: Representa os diferentes tipos de pizzas disponíveis.
PizzaPedida: Registro das pizzas que foram pedidas em um pedido.
Cliente: Informações dos clientes da pizzaria.
Pedido: Detalhes dos pedidos feitos pelos clientes.
Tamanho: Tamanhos disponíveis para as pizzas.
Bebida: Diversos tipos de bebidas oferecidas.
BebidaPedida: Bebidas incluídas em um pedido.
Fornada: Registra as fornadas de pizzas feitas.
PizzaPedida_has_Ingrediente: Relacionamento entre pizzas pedidas e ingredientes utilizados.
Ingrediente: Ingredientes que compõem as pizzas.
Práticas de Desenvolvimento
Para aprimorar as habilidades de codificação, optei por não utilizar as anotações automáticas fornecidas pelo Lombok, como @Getter, @Setter, @RequiredArgsConstructor, @NoArgsConstructor e @AllArgsConstructor. Em vez disso, todas as funcionalidades foram implementadas manualmente, proporcionando uma compreensão mais profunda sobre o funcionamento interno das classes e métodos.

Futuro do Projeto
Atualmente, o foco do projeto é exclusivamente no desenvolvimento do back-end da aplicação. No entanto, tenho planos de expandir este projeto para incluir uma interface de usuário amigável (front-end) no futuro, proporcionando uma experiência completa para os usuários da PizzaCode.

Criação e Manipulação de Dados
Os dados no banco de dados podem ser criados e manipulados de várias maneiras. Durante o desenvolvimento, utilizei principalmente a interface gráfica do Postman para criar e testar as requisições HTTP. Além disso, os dados também podem ser criados através do comando CURL na linha de comando, oferecendo flexibilidade no processo de desenvolvimento e teste.

Sinta-se à vontade para explorar o código-fonte e contribuir para tornar a PizzaCode ainda melhor! 😊🍕






