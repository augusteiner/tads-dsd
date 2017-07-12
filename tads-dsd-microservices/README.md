
<header>

# INSTITUTO FEDERAL DE EDUCAÇÃO, CIÊNCIA E TECNOLOGIA DO RIO GRANDE DO NORTE
# DIRETORIA ACADÊMICA DE GESTÃO E TECNOLOGIA DA INFORMAÇÃO
# TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS
# DESENVOLVIMENTO DE SISTEMAS DISTRIBUIDOS

</header>

## Padrões, infraestrutura e aplicação de Microserviços

20152014040014 - José Augusto de Araújo Nascimento

<footer>

# NATAL - RN
# 2017

</footer>
____

# Arquitetura Monolítica

  A arquitetura monolítica possui raízes históricas, sendo originária de uma época da computação onde a solidez/robustez da solução era o objetivo maior - muitas vezes em detrimento da performance ou usabilidade.

  Como principais características, a arquitetura monolítica traz o software como unidade única de solução - produto compilado e montado como um só. Embora consigo tal proposta arquitetural traga vantagens, em um mundo cada vez mais interconexo a arquitetura monolítica foi perdendo espaço para alternativas onde a reutilização fosse maior.

# Arquitetura de Microserviços

  A arquitetura de microserviços surge como alternativa de solução aos principais problemas encontrados na arquitetura monolítica, porém não soluciona todos os possíveis problemas, assim como adiciona complexidade ao fluxo de desenvolvimento de soluções.

  A arquitetura de microserviços propõem sub-dividir sistemas grandes em pequenas partes (microserviços) de forma a aumentar a coesão e diminuir o acoplamento de soluções de software de larga escala.

## Infraestrutura

  A arquitetura de microserviços embora possa ser empregada no desenvolvimento de soluções/aplicações simples orientadas a serviços, requer um nível tecnológico que só pode ser alcançado ao se utilizar de serviços de gerenciamento de recursos informacionais de alto nível, como é o caso de serviços de nuvem.

### Cloud

  O *cloud computing* dá a arquitetura de microserviços poder amplo, o que a torna uma alternativa viável e de baixo custo comparada a soluções anteriores.

### Escalabilidade

  A escalabilidade em microserviços é uma área ampla e pode ser resumida - de maneira menos complexa - em três vertentes:

<figure>
  <img src="https://cdn.infoq.com/statics_s1_20170711-0402/resource/articles/microservices-intro/pt/resources/9image00.png">
  <figcaption>
    Figura 1. cubo de escalabilidade
  </figcaption>
</figure>


  Ponderando-se o peso de cada eixo no desenvolvimento, implantação e manutenção da solução é possível reduzir custos e complexidade, realizando por exemplo troca de tempo de desenvolvimento por maior número de instâncias com o intuito de se reduzir o tempo de resposta da aplicação como um todo.

#### A escalabilidade no eixo X

  A escalabilidade no eixo X trata da quantidade de cópias de um microserviço que podem ser criadas para aumentar o nível de resiliência e atendimento da demanda.

#### A escalabilidade no eixo Z

  A escalabilidade no eixo Z trata da fragmentação dos dados da aplicação como um todo a fim de suprir as necessidades de armazenamento e leitura de dados para os microserviços. Propondo como ponto central a fragmentação para alta disponibilidade dos dados da aplicação geral.

#### A escalabilidade no eixo Y

  A escalabilidade no eixo Y trata da separação das atribuições/responsabilidades de cada microserviço

## Aplicação

  A proposta arquitetural dos microserviços possui amplas oportunidades de aplicação. Sendo seu principal apelo direcionado a sistemas complexos a arquitetura fornece melhor custo-benefício do que alternativas monolíticas.

## Vantagens x Desvantagens

  As principais vantagens da arquitetura de microserviços são:
  - Maior divisão de responsabilidades;
  - Maior tolerância a falhas;
  - Maior performance;
  - Possibilidade de migração de serviços legados gradativamente;

  As principais desvantagens são:
  - Maior complexidade de sistemas;
  - Maior necessidade de ferramentas de monitoramento;

# Referências

_____. http://www.infoq.com/br/articles/microservices-intro (Acesso em 12/07/2017).

_____. http://akfpartners.com/growth-blog/splitting-applications-or-services-for-scale (Acesso em 12/07/2017).
