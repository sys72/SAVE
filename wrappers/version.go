package main

import (
	"fmt"
	"os"
	"strings"
)

func GetSaveVersion() string {
	versionData, errVer := os.ReadFile("v_version.txt")
	buildData, errBuild := os.ReadFile("v_build.txt")

	if errVer == nil && errBuild == nil {
		version := strings.TrimSpace(string(versionData))
		build := strings.TrimSpace(string(buildData))
		return fmt.Sprintf("v%s (Build %s)", version, build)
	}

	tagData, errTag := os.ReadFile("v_tag.txt")
	if errBuild == nil && errTag == nil {
		build := strings.TrimSpace(string(buildData))
		tag := strings.TrimSpace(string(tagData))
		return fmt.Sprintf("%s - Build %s", tag, build)
	}

	return "v0.0.0 - Build 0 (SAVE not detected)"
}

func main() {
	fmt.Println(GetSaveVersion())
}
