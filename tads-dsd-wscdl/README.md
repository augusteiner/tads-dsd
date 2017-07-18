
<link rel="stylesheet" href="github.css">
<link rel="stylesheet" href="main.css">

<section class="capa">

  <header>
INSTITUTO FEDERAL DE EDUCAÇÃO, CIÊNCIA E TECNOLOGIA DO RIO GRANDE DO NORTE
<br>
DIRETORIA ACADÊMICA DE GESTÃO E TECNOLOGIA DA INFORMAÇÃO
<br>
TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
<br>
DESENVOLVIMENTO DE SISTEMAS DISTRIBUIDOS
  </header>

  <main>
Coreografia de Serviços Web &there4; WS-CDL
  </main>

  <aside>
20152014040014 - José Augusto de Araújo Nascimento
  </asige>

  <footer>
NATAL - RN
<br>
2017
  </footer>

</section>

<p class="quebra-pagina"></p>

# WS-CDL

**WS-CDL**: *Web Services Choreography Description Language*

Linguagem de Descrição de Coreografia de Serviços Web

Padrão W3C de linguagem para descrição de coreografias entre serviços web. O termo *coreografia* se refere a descrição de interações coordenadas entre duas ou mais partes.

## Objetivo

  Forma padrão de definição de interações entre serviços web, propiciando documentação não ambigua dos participantes e suas responsabilidades (contrato).

  Ao documentar o papel que cada parte da coreografia realiza, o padrão proporciona às partes envolvidas realizar o *mocking* das outras partes com o intuito de testar se suas atribuições estão de acordo com a coreografia descrita.

  Apesar do padrão ter sido liberado sem uma implementação de referência, há algumas implementações porém a maioria se limita a simular o ambiente da coreografia, outras se utilizam de parte da especificação definindo padrões próprios em algumas situações.

  A coreografia, principalmente se caracteriza por troca de mensagens diretamente entre os seus participantes, cabendo a cada um responder de acordo e informar à outra parte quando do erro ao se realizar determinada operação em uma espécie de *callback*, onde uma requisição é feita por uma parte e a resposta é enviada diretamente pela outra parte de volta em outro envio de mensagem.

## Problemas

  Ao contrário da orquestração a coreografia não centraliza o fluxo em um único agente o que a torna mais tolerante a falhas, porém caso um dos participantes não esteja funcional toda a coreografia pode ficar comprometida.

