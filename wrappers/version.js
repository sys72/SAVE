const fs = require('fs');

function getSaveVersion() {
    try {
        const build = fs.readFileSync('v_build.txt', 'utf8').trim();
        const tag = fs.readFileSync('v_tag.txt', 'utf8').trim();
        return `${tag} - Build ${build}`;
    } catch (err) {
        return "vX.X - Build 0 (SAVE not detected)";
    }
}

console.log(getSaveVersion());
