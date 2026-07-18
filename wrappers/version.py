def get_save_version():
    try:
        with open('v_build.txt', 'r') as f:
            build = f.read().strip()
        with open('v_tag.txt', 'r') as f:
            tag = f.read().strip()
        return f"{tag} - Build {build}"
    except FileNotFoundError:
        return "vX.X - Build 0 (SAVE not detected)"

if __name__ == "__main__":
    print(get_save_version())
