# Sovereign Auto-Version Engine (S.A.V.E.)

> *"Faça uma única coisa, faça de forma simples e faça com perfeição."*
> 
> O motor definitivo de auto-versionamento. Fricção Zero, Agnóstico e sem dependências, ancorado na pura filosofia UNIX. Sem necessidade de Node.js, sem arquivos de configuração obesos. Apenas certeza matemática.

## 1. O Manifesto (Agnosticismo & Fricção Zero)

O mercado atual de desenvolvimento de software sofre de uma epidemia de complexidade. Ferramentas de versionamento modernas (como `semantic-release` ou `bump2version`) tornaram-se obesas. Elas exigem a instalação de ecossistemas inteiros (como Node.js), dezenas de dependências complexas e arquivos de configuração engessados para executar uma tarefa fundamental: incrementar um número de versão.

O **Sovereign Auto-Version Engine** nasce como o antídoto definitivo a essa burocracia.

**Nossos Princípios:**
- **Fricção Zero:** Não há dependências, não requer downloads de pacotes ou SDKs. Se você tem o Git rodando nativamente, o sistema já funciona.
- **Agnosticismo Total:** Não importa se o seu projeto é escrito em PHP, Python, Java, C++, Kotlin ou JS. O motor interage exclusivamente com arquivos de texto puro (`.txt`), tornando a linguagem final do projeto irrelevante.
- **Anti-Falho por Natureza:** O versionamento não é um script externo e esquecível. Ele é atrelado organicamente à única ação inevitável do desenvolvedor no ciclo de desenvolvimento: o salvamento da história via `git commit`.

---

## 2. A Arquitetura Soberana (O Motor Determinístico)

A falha primária dos sistemas clássicos de versionamento é depender de uma lógica insegura: um script que lê um número velho num arquivo, soma `+1` na memória e salva. Se ocorrer concorrência de processos, interrupção de energia ou edição manual errada, a matemática se corrompe (Race Condition). 

O Sovereign Engine abandona essa prática frágil e implementa um **Motor Determinístico Baseado no Histórico**.

### A Lei Métrica do Odômetro (10 / 100):
Para eliminar qualquer necessidade de intervenção humana ou configuração arbitrária de versões, o S.A.V.E. adota a **Lei Métrica Decimal** como o denominador comum universal da engenharia de software:
- **PATCH** = `BUILD_COUNT % 10` (avança a cada commit individual de 0 a 9)
- **MINOR** = `(BUILD_COUNT % 100) / 10` (avança a cada 10 commits de 0 a 9)
- **MAJOR** = `BUILD_COUNT / 100` (avança a cada 100 commits)

A física da árvore do Git gera a versão semântica (`MAJOR.MINOR.PATCH`) e a build imutável de forma instantânea:
```bash
LOCAL_COMMITS=$(git rev-list --count HEAD)
BUILD_COUNT=$((BASE_BUILD + LOCAL_COMMITS))

MAJOR=$(( BUILD_COUNT / 100 ))
MINOR=$(( (BUILD_COUNT % 100) / 10 ))
PATCH=$(( BUILD_COUNT % 10 ))
SEMVER="${MAJOR}.${MINOR}.${PATCH}"
```
O `Build Number` e a `Versão Semântica` deixam de ser números abstratos na memória e passam a representar fisicamente o **volume e a maturidade da árvore do Git**.

**Vantagens Práticas:**
- **Denominador Comum Universal:** Atende perfeitamente desde micro-utilitários focados (como apps de 40 KB que atingem maturidade e vão para a loja na faixa dos 50-100 commits) até sistemas robustos de infraestrutura e containers (onde cada 100 commits consolida uma nova geração do software).
- **Sincronia Indestrutível:** Se 15 commits forem puxados remotamente via `git pull`, o sistema salta 15 builds matematicamente. Se commits locais forem destruídos via `git reset`, a build regride. Os arquivos `.txt` passam a atuar apenas como "espelhos imutáveis" da física real do repositório, garantindo integridade 100% do tempo.

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
- 🤖 **Kotlin/Android** (`android_build_gradle_snippet.kts` - Injeção nativa no Gradle KTS e Groovy)
- 💻 **Bash** (`version.sh`)
- 🧠 **Python** (`version.py`)
- 🐘 **PHP** (`version.php`)
- 🟡 **Node.js** (`version.js`)
- 🐹 **Golang** (`version.go`)

---

## 4. Por Trás das Cortinas: O Gatilho

A mágica ocorre de forma totalmente invisível. O desenvolvedor não precisa lembrar de invocar comandos complexos para fazer o "bump" de versão. A orquestração reside no gatilho interno nativo do próprio repositório: o **Git Hook**.

Ao gravar o arquivo executável `post-commit` dentro da pasta oculta `.git/hooks/`, o Git invoca o nosso script autonomamente após registrar o histórico.

**A Engenharia do Gatilho (`post-commit`):**
```bash
#!/bin/bash
# Sovereign Auto-Version Engine (S.A.V.E.)

# Offset estático para compensar a continuidade de versões anteriores
BASE_BUILD=0

# Matemática Determinística da Árvore
LOCAL_COMMITS=$(git rev-list --count HEAD 2>/dev/null || echo 0)
BUILD_COUNT=$((BASE_BUILD + LOCAL_COMMITS))

# Motor Métrico Semântico (10 / 100)
MAJOR=$(( BUILD_COUNT / 100 ))
MINOR=$(( (BUILD_COUNT % 100) / 10 ))
PATCH=$(( BUILD_COUNT % 10 ))
SEMVER="${MAJOR}.${MINOR}.${PATCH}"

# Captura de Identidade Forense
GIT_HASH=$(git rev-parse --short HEAD 2>/dev/null || echo "0000000")
GIT_TAG=$(git describe --tags --abbrev=0 2>/dev/null || echo "v${SEMVER}")

# Renderização do Espelho Atômico (Os TXTs)
TARGET_DIR="."
echo "$SEMVER"      > "$TARGET_DIR/v_version.txt"
echo "$BUILD_COUNT" > "$TARGET_DIR/v_build.txt"
echo "$GIT_HASH"    > "$TARGET_DIR/v_hash.txt"
echo "$GIT_TAG"     > "$TARGET_DIR/v_tag.txt"
```
A cada enter no comando de commit, o sistema crava as digitais indeléveis daquele bloco de código. O desenvolvedor foca na sua arte; o motor cuida da burocracia matemática.

---

## 5. Módulos de Leitura (O Consumo do Estado)

Com o estado da Build e da Versão armazenado de forma isolada nos arquivos `.txt` inofensivos, a aplicação principal ou interface do projeto atua apenas como uma "Lente de Leitura". 

Cada linguagem tem o seu módulo tradutor (`wrapper`) de forma purista e trivial.

### Exemplo Prático em PHP (`version.php`):
```php
<?php
$version = file_get_contents('v_version.txt');
$build   = file_get_contents('v_build.txt');
$hash    = file_get_contents('v_hash.txt');

$dpd_version = "v" . trim($version) . " - Build " . trim($build);
$dpd_sub = "Hash: " . trim($hash);
?>
```

### Exemplo Prático em Python (`version.py`):
```python
def get_save_version():
    with open('v_version.txt', 'r') as f:
        version = f.read().strip()
    with open('v_build.txt', 'r') as f:
        build = f.read().strip()
    return f"v{version} (Build {build})"
```

Ao isolar brutalmente a regra matemática (o bash hook) da leitura superficial dos dados (a aplicação), o painel final herda uma identidade hiper-precisa sem o risco de corrupção sistêmica. O código permanece intocado, mas a governança vira lei.
