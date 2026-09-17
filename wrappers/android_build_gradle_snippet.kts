// ==============================================================================
// SOVEREIGN AUTO-VERSION ENGINE (S.A.V.E.) - 10/100 METRIC ENGINE
// Native beauty: computes and binds atomically on build from the Git tree.
// ==============================================================================

// --- FOR KOTLIN DSL (build.gradle.kts) ---
val gitCommits = try {
    providers.exec { commandLine("git", "rev-list", "--count", "HEAD") }.standardOutput.asText.get().trim().toInt()
} catch (e: Exception) {
    1
}

val saveMajor = gitCommits / 100
val saveMinor = (gitCommits % 100) / 10
val savePatch = gitCommits % 10
val saveSemVer = "$saveMajor.$saveMinor.$savePatch"

android {
    defaultConfig {
        versionCode = gitCommits
        versionName = saveSemVer
    }
}

/*
// --- FOR GROOVY DSL (build.gradle) ---
def getGitCommits() {
    try {
        def stdout = new ByteArrayOutputStream()
        exec {
            commandLine 'git', 'rev-list', '--count', 'HEAD'
            standardOutput = stdout
        }
        return stdout.toString().trim().toInteger()
    } catch (ignored) {
        return 1
    }
}

def gitCommits = getGitCommits()
def saveMajor = (int)(gitCommits / 100)
def saveMinor = (int)((gitCommits % 100) / 10)
def savePatch = (int)(gitCommits % 10)
def saveSemVer = "${saveMajor}.${saveMinor}.${savePatch}"

android {
    defaultConfig {
        versionCode gitCommits
        versionName saveSemVer
    }
}
*/
