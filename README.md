# roupa_de_sapo
Squad 1 Aceleradev Java Florianópolis

## Fluxo de trabalho
Todas as novas *branches* devem ser criadas a partir da `staging`, para isso execute os seguintes comandos no seu terminal:
- ```git checkout staging``` -> entra na branch staging  <br />
- ```git pull origin staging``` -> atualiza seu repositório local com as modificações da staging <br />
- ```git checkout -b nome_da_sua_branch_de_trabalho``` -> cria e entra na sua branch de trabalho, (*é aqui onde você irá realizar todas as suas modificaçes, irá fazer commits e push*). <br />
Ao finalizar seu trabalho em sua branch local você pode fazer o merge dela com a staging. <br />
## Merge com staging
Entre em: https://github.com/Guiarrd/roupa_de_sapo/branches. <br /> <br />
Na seção *Active branches* procure a sua branch e aperte no botão **New pull request**. <br /> <br />
Você será redirecionado para uma nova página. Logo abaixo do título **Open a pull request** tem dois botões de spinner com uma seta **<-** entre eles. O da direita deve estar selecionado com a sua branch de trabalho e o da esquerda deve estar com a branch staging selecionada, caso não esteja assim selecione estas opções no *spinner*. Escreva uma mensagem sobre este *pull request* e aperte no botão **Create pull request**. Caso sua branch de trabalho possua algum conflito com a *staging* você não poderá dar o *merge* automaticamente, mas ainda poderá criar o *pull request*.<br /> <br />
Com o *pull request* criado caso não haja conflitos aperte no botão de **merge** na página do *pull request* criado e fim. Se houver conflitos você precisará resolvê-los localmente.
## Resolução de conflitos com IntelliJ
Abra o intelliJ, execute os comandos: <br />
- ```git checkout staging``` -> entra na branch staging  <br />
- ```git pull origin staging``` -> atualiza seu repositório local com as modificações da staging <br />
- ```git checkout nome_da_sua_branch_de_trabalho``` -> cria e entra na sua branch de trabalho <br />
No canto inferior direito na barra de navegação click em Git: nome_da_sua_branch, no menu que abrir selecione a branch staging e aperte em *Merge into current*. Resolva os conflitos que surgirem e faça um **push**.
