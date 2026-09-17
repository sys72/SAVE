# Sovereign Auto-Version Engine (S.A.V.E.)

> *"Do one thing, do it simply, and do it perfectly."*
> 
> The ultimate Zero-Friction, Zero-Dependency, Agnostic Auto-Version Engine rooted in pure UNIX philosophy. No Node.js, no bloated configs, no bullshit. Just mathematical certainty.

## 1. The Manifesto (Agnosticism & Zero Friction)

The current software development market suffers from an epidemic of complexity. Modern versioning tools (like `semantic-release` or `bump2version`) have become bloated. They require installing entire ecosystems (like Node.js), dozens of complex dependencies, and rigid configuration files to execute a fundamental task: incrementing a version number.

The **Sovereign Auto-Version Engine** is born as the ultimate antidote to this bureaucracy.

**Our Principles:**
- **Zero Friction:** No dependencies, no package downloads, no SDKs required. If you have Git running natively, the system works.
- **Absolute Agnosticism:** It doesn't matter if your project is written in PHP, Python, Java, C++, Kotlin, or JS. The engine interacts exclusively with plain text files (`.txt`), making the final project language completely irrelevant.
- **Fail-Proof by Nature:** Versioning is not an external, forgettable script. It is organically tied to the only inevitable action a developer takes in the development cycle: saving history via `git commit`.

---

## 2. The Sovereign Architecture (The Deterministic Engine)

The primary flaw of classic versioning systems is relying on insecure logic: a script that reads an old number in a file, adds `+1` in memory, and saves. If process concurrency, a power outage, or a wrong manual edit occurs, the math gets corrupted (Race Condition). 

The Sovereign Engine abandons this fragile practice and implements a **History-Based Deterministic Engine**.

### The 10 / 100 Metric Odometer Law:
To eliminate any human friction or arbitrary guesswork in version bumping, S.A.V.E. establishes the **Decimal Metric Law** as the universal common denominator for software engineering:
- **PATCH** = `BUILD_COUNT % 10` (increments per individual commit from 0 to 9)
- **MINOR** = `(BUILD_COUNT % 100) / 10` (increments every 10 commits from 0 to 9)
- **MAJOR** = `BUILD_COUNT / 100` (increments every 100 commits)

The physics of the Git tree instantly derives both the semantic version (`MAJOR.MINOR.PATCH`) and the immutable build count:
```bash
LOCAL_COMMITS=$(git rev-list --count HEAD)
BUILD_COUNT=$((BASE_BUILD + LOCAL_COMMITS))

MAJOR=$(( BUILD_COUNT / 100 ))
MINOR=$(( (BUILD_COUNT % 100) / 10 ))
PATCH=$(( BUILD_COUNT % 10 ))
SEMVER="${MAJOR}.${MINOR}.${PATCH}"
```
The `Build Number` and the `Semantic Version` cease to be abstract numbers in memory and physically represent the **volume and maturity of the Git tree**.

**Practical Advantages:**
- **Universal Common Denominator:** Flawlessly fits focused micro-utilities (like 40 KB apps reaching production maturity in 50-100 commits) all the way to heavy infrastructure systems and containers (where each 100 commits marks a new software generation).
- **Indestructible Sync:** If 15 commits are pulled remotely via `git pull`, the system jumps 15 builds mathematically. If local commits are destroyed via `git reset`, the build regresses. The `.txt` files act merely as "immutable mirrors" of the repository's real physics, guaranteeing 100% integrity at all times.

---

## 3. 🚀 Quickstart & Installation (Zero Friction)

Forget manual configurations. Implementing the Sovereign Engine takes exactly 3 seconds.

### Step 1: Install the Engine
Run the 1-click installer at the root of your Git repository:
```bash
./install.sh
```
*(This automatically couples the deterministic hook into your hidden `.git/hooks/` folder).*

### Step 2: Choose your Wrapper
The S.A.V.E. is completely language-agnostic. Check the `wrappers/` folder for ready-to-use drop-in code for your tech stack:
- 🤖 **Kotlin/Android** (`android_build_gradle_snippet.kts` - Native Gradle KTS & Groovy injection)
- 💻 **Bash** (`version.sh`)
- 🧠 **Python** (`version.py`)
- 🐘 **PHP** (`version.php`)
- 🟡 **Node.js** (`version.js`)
- 🐹 **Golang** (`version.go`)

---

## 4. Under the Hood: The Trigger

The magic happens completely invisibly. The developer doesn't need to remember to invoke complex commands to bump the version. The orchestration resides in the repository's native internal trigger: the **Git Hook**.

By saving the executable `post-commit` file inside the hidden `.git/hooks/` folder, Git invokes our script autonomously after registering the history.

**Trigger Engineering (`post-commit`):**
```bash
#!/bin/bash
# Sovereign Auto-Version Engine (S.A.V.E.)

# Static offset to compensate for previous versions' continuity
BASE_BUILD=0

# Tree Deterministic Math
LOCAL_COMMITS=$(git rev-list --count HEAD 2>/dev/null || echo 0)
BUILD_COUNT=$((BASE_BUILD + LOCAL_COMMITS))

# Semantic Metric Engine (10 / 100)
MAJOR=$(( BUILD_COUNT / 100 ))
MINOR=$(( (BUILD_COUNT % 100) / 10 ))
PATCH=$(( BUILD_COUNT % 10 ))
SEMVER="${MAJOR}.${MINOR}.${PATCH}"

# Forensic Identity Capture
GIT_HASH=$(git rev-parse --short HEAD 2>/dev/null || echo "0000000")
GIT_TAG=$(git describe --tags --abbrev=0 2>/dev/null || echo "v${SEMVER}")

# Atomic Mirror Rendering (The TXTs)
TARGET_DIR="."
echo "$SEMVER"      > "$TARGET_DIR/v_version.txt"
echo "$BUILD_COUNT" > "$TARGET_DIR/v_build.txt"
echo "$GIT_HASH"    > "$TARGET_DIR/v_hash.txt"
echo "$GIT_TAG"     > "$TARGET_DIR/v_tag.txt"
```
Upon hitting enter on the commit command, the system stamps the indelible fingerprints of that code block. The developer focuses on their art; the engine handles the mathematical bureaucracy.

---

## 5. Reading Modules (State Consumption)

With the Build and Version state stored in isolation in harmless `.txt` files, the main application or project interface acts only as a "Reading Lens". 

Each language has its translator module (`wrapper`) in a purist and trivial way.

### Practical Example in PHP (`version.php`):
```php
<?php
$version = file_get_contents('v_version.txt');
$build   = file_get_contents('v_build.txt');
$hash    = file_get_contents('v_hash.txt');

$dpd_version = "v" . trim($version) . " - Build " . trim($build);
$dpd_sub = "Hash: " . trim($hash);
?>
```

### Practical Example in Python (`version.py`):
```python
def get_save_version():
    with open('v_version.txt', 'r') as f:
        version = f.read().strip()
    with open('v_build.txt', 'r') as f:
        build = f.read().strip()
    return f"v{version} (Build {build})"
```

By brutally isolating the mathematical rule (the bash hook) from the superficial reading of data (the application), the final dashboard inherits a hyper-precise identity without the risk of systemic corruption. The code remains untouched, but governance becomes law.
