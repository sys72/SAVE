# Sovereign Auto-Version Engine (S.A.V.E.)

> *"Faça uma única coisa, faça de forma simples e faça com perfeição."*
> 
> O motor definitivo de auto-versionamento. Fricção Zero, Agnóstico e sem dependências, ancorado na pura filosofia UNIX. Sem necessidade de Node.js, sem arquivos de configuração obesos. Apenas certeza matemática.

## 1. O Manifesto (Agnosticismo & Fricção Zero)

O mercado atual de desenvolvimento de software sofre de uma epidemia de complexidade. Ferramentas de versionamento modernas (como `semantic-release` ou `bump2version`) tornaram-se obesas. Elas exigem a instalação de ecossistemas inteiros (como Node.js), dezenas de dependências complexas e arquivos de configuração engessados para executar uma tarefa fundamental: incrementar um número de versão.

O **Sovereign Auto-Version Engine** nasce como o antídoto definitivo a essa burocracia.

**Nossos Princípios:**
- **Fricção Zero:** Não há dependências, não requer downloads de pacotes ou SDKs. Se você tem o Git rodando nativamente, o sistema já funciona.
- **Agnosticismo Total:** Não importa se o seu projeto é escrito em PHP, Python, Java, C++ ou JS. O motor interage exclusivamente com arquivos de texto puro (`.txt`), tornando a linguagem final do projeto irrelevante.
- **Anti-Falho por Natureza:** O versionamento não é um script externo e esquecível. Ele é atrelado organicamente à única ação inevitável do desenvolvedor no ciclo de desenvolvimento: o salvamento da história via `git commit`.

---

## 2. A Arquitetura Soberana (O Motor Determinístico)

A falha primária dos sistemas clássicos de versionamento é depender de uma lógica insegura: um script que lê um número velho num arquivo, soma `+1` na memória e salva. Se ocorrer concorrência de processos, interrupção de energia ou edição manual errada, a matemática se corrompe (Race Condition). 

O Sovereign Engine abandona essa prática frágil e implementa um **Motor Determinístico Baseado no Histórico**.

A matemática do motor é absoluta e irreversível:
```bash
LOCAL_COMMITS=$(git rev-list --count HEAD)
BUILD_COUNT=$((BASE_BUILD + LOCAL_COMMITS))
```
O `Build Number` do projeto deixa de ser um número abstrato na memória e passa a representar fisicamente o **volume e o tamanho da árvore do Git**. 

**Vantagens Práticas:**
- **Sincronia Indestrutível:** Se 15 commits forem puxados remotamente via `git pull`, o sistema salta 15 builds matematicamente. Se commits locais forem destruídos via `git reset`, a build regride. O arquivo `.txt` passa a atuar apenas como um "espelho imutável" da física real do repositório, garantindo integridade 100% do tempo.

---

## 3. 🚀 Quickstart & Instalação (Fricção Zero)

Esqueça configurações manuais. Implementar o Motor Soberano leva exatamente 3 segundos.

### Passo 1: Instale o Motor
Rode o instalador de 1-clique na raiz do seu repositório Git:
```bash
./install.sh
```
*(Isso acopla automaticamente o hook determinístico dentro da sua pasta oculta `.git/hooks/`).*

### Passo 2: Escolha a sua Linguagem
O S.A.V.E. é completamente agnóstico. Acesse a pasta `wrappers/` e copie o código pronto correspondente ao seu ecossistema:
- 🧠 **Python** (`version.py`)
- 🐘 **PHP** (`version.php`)
- 🟡 **Node.js** (`version.js`)
- 🐹 **Golang** (`version.go`)
- 💻 **Bash** (`version.sh`)
- 🤖 **Kotlin/Android** (`android_build_gradle_snippet.kts` - Injeção nativa no Gradle)

---

## 4. Por Trás das Cortinas: O Gatilho

A mágica ocorre de forma totalmente invisível. O desenvolvedor não precisa lembrar de invocar comandos complexos para fazer o "bump" de versão. A orquestração reside no gatilho interno nativo do próprio repositório: o **Git Hook**.

Ao gravar o arquivo executável `post-commit` dentro da pasta oculta `.git/hooks/`, o Git invoca o nosso script autonomamente após registrar o histórico.

**A Engenharia do Gatilho (`post-commit`):**
```bash
#!/bin/bash
# Sovereign Auto-Version Engine

# Offset estático para compensar a continuidade de versões anteriores
BASE_BUILD=0

# Matemática Determinística da Árvore
LOCAL_COMMITS=$(git rev-list --count HEAD)
BUILD_COUNT=$((BASE_BUILD + LOCAL_COMMITS))

# Captura de Identidade Forense
GIT_HASH=$(git rev-parse --short HEAD)
GIT_TAG=$(git describe --tags --abbrev=0 2>/dev/null || echo "v1.0.0")

# Renderização do Espelho Atômico (Os TXTs)
TARGET_DIR="."
echo "$BUILD_COUNT" > "$TARGET_DIR/v_build.txt"
echo "$GIT_HASH"    > "$TARGET_DIR/v_hash.txt"
echo "$GIT_TAG"     > "$TARGET_DIR/v_tag.txt"
```
A cada enter no comando de commit, o sistema crava as digitais indeléveis daquele bloco de código. O desenvolvedor foca na sua arte; o motor cuida da burocracia matemática.

---

## 5. Módulos de Leitura (O Consumo do Estado)

Com o estado da Build armazenado de forma isolada nos arquivos `.txt` inofensivos, a aplicação principal ou interface do projeto atua apenas como uma "Lente de Leitura". 

Cada linguagem tem o seu módulo tradutor (`wrapper`) de forma purista e trivial.

### Exemplo Prático em PHP (`version.php`):
```php
<?php
$build = file_get_contents('v_build.txt');
$hash  = file_get_contents('v_hash.txt');
$tag   = file_get_contents('v_tag.txt');

$dpd_version = trim($tag) . " - Build " . trim($build);
$dpd_sub = "Hash: " . trim($hash);
?>
```

### Exemplo Prático em Python (`version.py`):
```python
def get_sfb_version():
    with open('v_build.txt', 'r') as f:
        build = f.read().strip()
    with open('v_tag.txt', 'r') as f:
        tag = f.read().strip()
    return f"{tag} - Build {build}"
```

Ao isolar brutalmente a regra matemática (o bash hook) da leitura superficial dos dados (a aplicação), o painel final herda uma identidade hiper-precisa sem o risco de corrupção sistêmica. O código permanece intocado, mas a governança vira lei.
