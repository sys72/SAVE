<?php
function get_save_version() {
    if (!file_exists('v_build.txt') || !file_exists('v_tag.txt')) {
        return "vX.X - Build 0 (SAVE não detectado)";
    }
    $build = trim(file_get_contents('v_build.txt'));
    $tag   = trim(file_get_contents('v_tag.txt'));
    return "$tag - Build $build";
}

echo get_save_version() . PHP_EOL;
?>
