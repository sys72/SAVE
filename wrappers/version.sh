#!/bin/bash
if [ -f "v_version.txt" ] && [ -f "v_build.txt" ]; then
    VERSION=$(cat v_version.txt)
    BUILD=$(cat v_build.txt)
    HASH=$(cat v_hash.txt 2>/dev/null || echo "")
    echo "v$VERSION (Build $BUILD - $HASH)"
elif [ -f "v_build.txt" ] && [ -f "v_tag.txt" ]; then
    BUILD=$(cat v_build.txt)
    TAG=$(cat v_tag.txt)
    echo "$TAG - Build $BUILD"
else
    echo "v0.0.0 - Build 0 (SAVE not detected)"
fi
