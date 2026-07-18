package main

import (
	"fmt"
	"os"
	"strings"
)

func GetSaveVersion() string {
	buildData, err1 := os.ReadFile("v_build.txt")
	tagData, err2 := os.ReadFile("v_tag.txt")
	
	if err1 != nil || err2 != nil {
		return "vX.X - Build 0 (SAVE not detected)"
	}
	
	build := strings.TrimSpace(string(buildData))
	tag := strings.TrimSpace(string(tagData))
	
	return fmt.Sprintf("%s - Build %s", tag, build)
}

func main() {
	fmt.Println(GetSaveVersion())
}
