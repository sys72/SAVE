# Sovereign Auto-Version Engine (S.A.V.E.)

> *"Do one thing, do it simply, and do it perfectly."*
> 
> The ultimate Zero-Friction, Zero-Dependency, Agnostic Auto-Version Engine rooted in the pure UNIX philosophy. No Node.js, no bloated configs, no bullshit. Just mathematical certainty.

## 1. The Manifesto (Agnosticism & Zero Friction)

The current software development market suffers from an epidemic of complexity. Modern versioning tools (like `semantic-release` or `bump2version`) have become bloated. They require installing entire ecosystems (like Node.js), dozens of complex dependencies, and rigid configuration files to execute a fundamental task: incrementing a version number.

The **Sovereign Auto-Version Engine** is born as the ultimate antidote to this bureaucracy.

**Our Principles:**
- **Zero Friction:** No dependencies, no package downloads, no SDKs required. If you have Git running natively, the system works.
- **Absolute Agnosticism:** It doesn't matter if your project is written in PHP, Python, Java, C++, or JS. The engine interacts exclusively with plain text files (`.txt`), making the final project language completely irrelevant.
- **Fail-Proof by Nature:** Versioning is not an external, forgettable script. It is organically tied to the only inevitable action a developer takes in the development cycle: saving history via `git commit`.

---

## 2. The Sovereign Architecture (The Deterministic Engine)

The primary flaw of classic versioning systems is relying on insecure logic: a script that reads an old number in a file, adds `+1` in memory, and saves. If process concurrency, a power outage, or a wrong manual edit occurs, the math gets corrupted (Race Condition). 

The Sovereign Engine abandona this fragile practice and implements a **History-Based Deterministic Engine**.

The math of the engine is absolute and irreversible:
```bash
LOCAL_COMMITS=$(git rev-list --count HEAD)
BUILD_COUNT=$((BASE_BUILD + LOCAL_COMMITS))
```
The project's `Build Number` stops being an abstract number in memory and physically represents the **volume and size of the Git tree**. 

**Practical Advantages:**
- **Indestructible Sync:** If 15 commits are pulled remotely via `git pull`, the system jumps 15 builds mathematically. If local commits are destroyed via `git reset`, the build regresses. The `.txt` file acts merely as an "immutable mirror" of the repository's real physics, guaranteeing 100% integrity at all times.

---

## 3. The Trigger (The Heart of the Machine)

The magic happens completely invisibly. The developer doesn't need to remember to invoke complex commands to bump the version. The orchestration resides in the repository's native internal trigger: the **Git Hook**.

By saving the executable `post-commit` file inside the hidden `.git/hooks/` folder, Git invokes our script autonomously after registering the history.

**Trigger Engineering (`post-commit`):**
```bash
#!/bin/bash
# Sovereign Auto-Version Engine

# Static offset to compensate for previous versions' continuity
BASE_BUILD=0

# Tree Deterministic Math
LOCAL_COMMITS=$(git rev-list --count HEAD)
BUILD_COUNT=$((BASE_BUILD + LOCAL_COMMITS))

# Forensic Identity Capture
GIT_HASH=$(git rev-parse --short HEAD)
GIT_TAG=$(git describe --tags --abbrev=0 2>/dev/null || echo "v1.0.0")

# Atomic Mirror Rendering (The TXTs)
TARGET_DIR="."
echo "$BUILD_COUNT" > "$TARGET_DIR/v_build.txt"
echo "$GIT_HASH"    > "$TARGET_DIR/v_hash.txt"
echo "$GIT_TAG"     > "$TARGET_DIR/v_tag.txt"
```
Upon hitting enter on the commit command, the system stamps the indelible fingerprints of that code block. The developer focuses on their art; the engine handles the mathematical bureaucracy.

---

## 4. Reading Modules (State Consumption)

With the Build state stored in isolation in harmless `.txt` files, the main application or project interface acts only as a "Reading Lens". 

Each language has its translator module (`wrapper`) in a purist and trivial way.

### Practical Example in PHP (`version.php`):
```php
<?php
$build = file_get_contents('v_build.txt');
$hash  = file_get_contents('v_hash.txt');
$tag   = file_get_contents('v_tag.txt');

$dpd_version = trim($tag) . " - Build " . trim($build);
$dpd_sub = "Hash: " . trim($hash);
?>
```

### Practical Example in Python (`version.py`):
```python
def get_sfb_version():
    with open('v_build.txt', 'r') as f:
        build = f.read().strip()
    with open('v_tag.txt', 'r') as f:
        tag = f.read().strip()
    return f"{tag} - Build {build}"
```

By brutally isolating the mathematical rule (the bash hook) from the superficial reading of data (the application), the final dashboard inherits a hyper-precise identity without the risk of systemic corruption. The code remains untouched, but governance becomes law.
