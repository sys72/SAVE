<?php
function get_save_version() {
    if (file_exists('v_version.txt') && file_exists('v_build.txt')) {
        $version = trim(file_get_contents('v_version.txt'));
        $build   = trim(file_get_contents('v_build.txt'));
        return "v$version (Build $build)";
    }
    if (file_exists('v_build.txt') && file_exists('v_tag.txt')) {
        $build = trim(file_get_contents('v_build.txt'));
        $tag   = trim(file_get_contents('v_tag.txt'));
        return "$tag - Build $build";
    }
    return "v0.0.0 - Build 0 (SAVE not detected)";
}

echo get_save_version() . PHP_EOL;
?>
