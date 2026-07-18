#!/bin/bash
# Sovereign Auto-Version Engine - Instalador Fricção Zero

if [ ! -d ".git" ]; then
    echo "❌ Erro: Execute este script na raiz de um projeto que possua a pasta oculta .git"
    exit 1
fi

echo "🚀 Instalando o S.A.V.E. no repositório local..."
mkdir -p .git/hooks
cp hooks/post-commit .git/hooks/post-commit
chmod +x .git/hooks/post-commit

echo "✅ Sucesso! Motor autônomo acoplado. Seu próximo 'git commit' já será imortalizado."
