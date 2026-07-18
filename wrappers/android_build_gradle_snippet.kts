// PASTE THIS BLOCK IN YOUR app/build.gradle.kts
// Native beauty: does not require the post-commit hook. Gradle itself computes and binds atomically on build.

val gitVersion = providers.exec { commandLine("git", "rev-list", "--count", "HEAD") }.standardOutput.asText.get().trim()
val semVerCode = gitVersion.toInt()
val semVerName = "1.0.$gitVersion" // Change the "1.0" prefix according to your current Major/Minor Tag

android {
    defaultConfig {
        versionCode = semVerCode
        versionName = semVerName
    }
}
