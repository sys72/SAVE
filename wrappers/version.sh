#!/bin/bash
if [ -f "v_build.txt" ] && [ -f "v_tag.txt" ]; then
    BUILD=$(cat v_build.txt)
    TAG=$(cat v_tag.txt)
    echo "$TAG - Build $BUILD"
else
    echo "vX.X - Build 0 (SAVE não detectado)"
fi
