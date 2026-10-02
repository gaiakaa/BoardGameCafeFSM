# Board Game Cafe - Simulação FSM (Finite State Machine)

Projeto académico desenvolvido para a disciplina de Inteligência Artificial e Ilusão de Inteligência em Jogos.

## Agentes e os seus Estados

A simulação conta com 3 agentes autónomos que gerem os seus atributos (energia e progresso) e interagem entre si através de um sistema de comunicação global:

*   **Barista:** Funcionário responsável por atender os pedidos no balcão.
    *   *Estados:* LimpandoBalcao, PreparandoCafe, DescansandoBarista.
*   **Monitor:** Funcionário responsável por esclarecer as dúvidas.
    *   *Estados:* OrganizandoPrateleira, ExplicandoRegras, DescansandoMonitor.
*   **Cliente:** Tenta jogar e divertir-se, mas perde energia e precisa de aprender regras novas.
    *   *Estados:* EscolhendoJogo, AprendendoRegras, Jogando, EsperandoCafe, BebendoCafe.

## Como Compilar e Rodar

**Usando o Visual Studio Code (Recomendado):**
1. Abra a pasta raiz do projeto no VS Code.
2. Navegue até o ficheiro `src/core/Main.java`.
3. Clique no botão **Run** (Executar) localizado no canto superior direito do editor.

**Usando o Terminal:**
1. Abra o terminal na raiz do projeto e compile os ficheiros com: `javac -d bin src/**/*.java`
2. Execute o programa principal com: `java -cp bin core.Main`

## Como observar as transições nos Logs

A máquina de estados corre num loop infinito, processando um novo ciclo (`tick`) a cada 2 segundos. 

Para observar as transições, basta acompanhar a consola (terminal). Os dados são apresentados da seguinte forma:
*   **Separação de Ciclos:** Cada rodada é iniciada com a marcação `================= Nova Rodada =================`.
*   **Motivo da Transição:** Sempre que um agente muda de estado, uma frase é impressa (ex: *"O cliente está exausto e precisa de um café."*). Esta mensagem é engatilhada pelos métodos `leave()` das classes de estado.
*   **Status Atualizado:** Em cada rodada, a função `printState()` exibe os atributos (`Energia` e `Progresso`) e o estado atualizado que o agente se encontra no momento.
