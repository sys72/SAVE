const fs = require('fs');

function getSaveVersion() {
    try {
        if (fs.existsSync('v_version.txt') && fs.existsSync('v_build.txt')) {
            const version = fs.readFileSync('v_version.txt', 'utf8').trim();
            const build = fs.readFileSync('v_build.txt', 'utf8').trim();
            return `v${version} (Build ${build})`;
        }
        const build = fs.readFileSync('v_build.txt', 'utf8').trim();
        const tag = fs.readFileSync('v_tag.txt', 'utf8').trim();
        return `${tag} - Build ${build}`;
    } catch (err) {
        return "v0.0.0 - Build 0 (SAVE not detected)";
    }
}

console.log(getSaveVersion());
