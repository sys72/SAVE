#!/bin/bash
# Sovereign Auto-Version Engine - Zero Friction Installer

if [ ! -d ".git" ]; then
    echo "❌ Error: Execute this script at the root of a project containing a .git directory"
    exit 1
fi

echo "🚀 Installing S.A.V.E. in the local repository..."
mkdir -p .git/hooks
cp hooks/post-commit .git/hooks/post-commit
chmod +x .git/hooks/post-commit

echo "✅ Success! Autonomous engine attached. Your next 'git commit' will be immortalized."
