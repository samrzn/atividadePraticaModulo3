Algoritmo "Sistema de Cadastro - Agência de Turismo Trip"
// Disciplina   : [Linguagem e Lógica de Programação]
// Descrição   : Usando conceitos de programação estruturada (Vetor),
// criar em pseudocódigo um menu para simular um cadastro para uma agência
// de viagens com as seguintes funções: cadastro de cliente e cadastro de
// destino, criar também uma consulta para cada estrutura de dados.
// Autor(a)    : Samuel Reazende dos Santos
// Data atual  : 01/07/2022

Var
   // Seção de Declarações das variáveis

   cliente: vetor[0..4] de caractere
   a, b, salvar: inteiro
   idInfo: vetor[0..5] de caractere
   opcao: vetor[0..2] de caractere

Inicio
   // Seção de Comandos, procedimento, funções, operadores, etc...

   idInfo[0] <- "Nome completo: "
   idInfo[1] <- "Telefone: "
   idInfo[2] <- "E-mail: "
   idInfo[3] <- "Destino: "
   idInfo[4] <- "Data prevista: "

   escreval ("Bem-vindes a Trip Turismo.")
   escreval ("Informe os dados do cliente:")

   para a de 0 ate 4 faca
      escreva(idInfo[a])
      leia (cliente[a])
   fimpara
   escreval ("Registrando dados...")
   limpatela

   escreval ("Confirmação dos dados cadastrados:")
   para a de 0 ate 4 faca
      escreva(idInfo[a])
      escreval (cliente[a])
   fimpara

   escreval ("Deseja salvar cadastro?")
   opcao[0] <- "0 - Não"
   opcao[1] <- "1 - Sim"
   opcao[2] <- "2 - Editar"
   para b de 0 ate 2 faca
      escreval(opcao[b])
   fimpara

   leia (salvar)
   b <- salvar

   se (b = 0) entao
      limpatela
      escreval ("Registro de cadastro cancelado pelo usuário.")
   fimse

   se (b = 1) entao
      limpatela
      para a de 0 ate 4 faca
         escreva(idInfo[a])
         escreval (cliente[a])
      fimpara
      escreval ("Cadastro realizado com sucesso.")
   fimse

   enquanto b > 1 faca
      limpatela

      escreval ("Informe os dados do cliente:")
      para a de 0 ate 4 faca
         escreva(idInfo[a])
         leia (cliente[a])
      fimpara
      escreval ("Registrando dados...")
      limpatela

      escreval ("Confirmação dos dados cadastrados:")
      para a de 0 ate 4 faca
         escreva(idInfo[a])
         escreval (cliente[a])
      fimpara

      escreval ("Deseja salvar cadastro?")
      para b de 0 ate 2 faca
         escreval(opcao[b])
      fimpara

      leia (salvar)
      b <- salvar

      se (b = 0) entao
         limpatela
         escreval ("Registro de cadastro cancelado pelo usuário.")
      fimse

      se (b = 1) entao
         limpatela
         para a de 0 ate 4 faca
            escreva(idInfo[a])
            escreval (cliente[a])
         fimpara
         escreval ("Cadastro realizado com sucesso.")
      fimse

   fimenquanto

Fimalgoritmo