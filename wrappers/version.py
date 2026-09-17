def get_save_version():
    try:
        if os.path.exists('v_version.txt') and os.path.exists('v_build.txt'):
            with open('v_version.txt', 'r') as f:
                version = f.read().strip()
            with open('v_build.txt', 'r') as f:
                build = f.read().strip()
            return f"v{version} (Build {build})"
        with open('v_build.txt', 'r') as f:
            build = f.read().strip()
        with open('v_tag.txt', 'r') as f:
            tag = f.read().strip()
        return f"{tag} - Build {build}"
    except FileNotFoundError:
        return "v0.0.0 - Build 0 (SAVE not detected)"

if __name__ == "__main__":
    import os
    print(get_save_version())
