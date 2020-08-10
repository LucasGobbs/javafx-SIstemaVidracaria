# javafx-SistemaVidraçaria
Trabalho da matéria de Projeto de Sistemas.

Grupo: 
 - Lucas Costa Gobbi
 - Joana Rozaes 
## Entendendo o Problema

### Contexto
O trabalho consiste na produção de um sistema para uma vidraçaria hipotética, nesta vidraçaria alguns produtos são cortados dentro da própria empresa e outros vem diretamente da fabrica. Este conceito dentro do sistema é apresentado como personalização.

### Anatomia do Sistema
O sistema tem 3 atores principais, cada um sendo um ator que pode acessar certos recursos do sistema e todos os 3 tem certos pontos em comum como poderem adicionar e dar baixa em items do estoque
#### 1. Vendedor
Atende aos pedidos do cliente, e classifica os produtos comprados como (Personalizados ou não). 
Quando um produto é personalizado o sistema faz uma requisição para o comprador, e quando não é a requisição é encaminhada para o funcionário de produção.
#### 2. Funcionário Comprador
Recebe requisições de pedidos com produtos que devem ser enviados para fabrica (pois são personalizados)
Compra produtos
#### 3. Funcionário de produção
Recebe requisições dos pedidos com produtos a serem cortados dentro da loja, e finaliza o pedido ao cliente

### Protótipo e Resultado
Os protótipos foram feitos no SceneBuilder e posteriormente utilizando javafx foram implementados.

#### Tela Principal
<img src="https://github.com/LucasGobbs/javafx-SistemaVidracaria/blob/master/git-images/tela_principal.PNG"  width="340" height="350">

#### Cadastro de Cliente
<img src="https://github.com/LucasGobbs/javafx-SistemaVidracaria/blob/master/git-images/cadastro_cliente.PNG"  width="340" height="350">

#### Cadastro de funcionário
<img src="https://github.com/LucasGobbs/javafx-SistemaVidracaria/blob/master/git-images/cadastro_funcionario.PNG"  width="340" height="350">

#### Manejamento de estoque
<img src="https://github.com/LucasGobbs/javafx-SistemaVidracaria/blob/master/git-images/estoque.PNG"  width="340" height="350">

#### Cadastro de venda
<img src="https://github.com/LucasGobbs/javafx-SistemaVidracaria/blob/master/git-images/cadastro_venda.PNG"  width="340" height="350">

#### Requisições Personalizadas
<img src="https://github.com/LucasGobbs/javafx-SistemaVidracaria/blob/master/git-images/encomendas_personalizadas.PNG"  width="340" height="350">

#### Requisições não Personalizadas (Fila de produção)
<img src="https://github.com/LucasGobbs/javafx-SistemaVidracaria/blob/master/git-images/fila_de_produ%C3%A7%C3%A3o.PNG"  width="340" height="350">
