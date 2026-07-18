// COLE ESTE BLOCO NO SEU app/build.gradle.kts
// A beleza nativa: não exige o post-commit hook. O próprio Gradle calcula e atrela atômicamente no build.

val gitVersion = providers.exec { commandLine("git", "rev-list", "--count", "HEAD") }.standardOutput.asText.get().trim()
val semVerCode = gitVersion.toInt()
val semVerName = "1.0.$gitVersion" // Altere o prefixo "1.0" conforme a sua Major/Minor Tag atual

android {
    defaultConfig {
        versionCode = semVerCode
        versionName = semVerName
    }
}
