import groovy.util.Node
import groovy.util.NodeList

plugins {
    `maven-publish`
    `java-library`
    id("net.kyori.indra")
    id("net.kyori.indra.publishing")
    id("cl.franciscosolis.sonatype-central-upload")
}

indra {
    github("SNWCreations", "JKook") {
        ci(true)
    }
    apache2License()

    javaVersions {
        target(8)
        minimumToolchain(17)
    }

    configurePublications {
        pom {
            url = "https://github.com/SNWCreations/JKook"
            description = "The Kook (https://kookapp.cn) Bot's Plugin framework for Java."
            developers {
                developer {
                    id = "SNWCreations"
                    name = "SNWCreations"
                    email = "snwcreations@qq.com"
                    roles = listOf("contributor")
                }
                developer {
                    id = "huanmeng-qwq"
                    name = "huanmeng_qwq"
                    email = "huanmeng@huanmeng-qwq.com"
                    roles = listOf("contributor")
                }
                developer {
                    id = "xiaoACE6716"
                    name = "xiaoACE"
                    roles = listOf("contributor")
                }
                developer {
                    id = "RealSeek"
                    name = "RealSeek"
                    roles = listOf("contributor")
                }
                developer {
                    id = "gehongyan"
                    name = "Ge"
                    roles = listOf("contributor")
                }
                developer {
                    id = "DeeChael"
                    name = "Deerio Chaelingo"
                    roles = listOf("contributor")
                }
                developer {
                    id = "natholdallas"
                    name = "natholdallas"
                    roles = listOf("contributor")
                }
            }
            withXml {
                project.configurations.compileOnly.get().allDependencies.forEach { dep ->
                    ((asNode().get("dependencies") as NodeList)[0] as Node).appendNode("dependency").apply {
                        appendNode("groupId", dep.group)
                        appendNode("artifactId", dep.name)
                        appendNode("version", dep.version)
                        appendNode("scope", "provided")
                    }
                }
            }
        }
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs = mutableListOf("-Xlint:-deprecation,-unchecked")
}

fun read(str: String?): String? {
    if (str == null) {
        return null
    }
    try {
        val file = File(str).let {
            if (!it.exists()) {
                return@let File(uri(str))
            }
            it
        }
        if (file.exists()) {
            return file.readText(Charsets.UTF_8)
        }
    } catch (_: Exception) {
    }
    return str
}

val cleanUpload by tasks.creating(Delete::class) {
    setDelete(project.files(project.layout.buildDirectory.dir("sonatype-central-upload")))
}

tasks.sonatypeCentralUpload {
    // gradle sonatypeCentralUpload -PCENTRAL_USERNAME=<username> -PCENTRAL_PASSWORD=<password> -PCENTRAL_PRIVATE_KEY=<privateKey> -PCENTRAL_PRIVATE_KEY_PWD=<privateKeyPwd> -PCENTRAL_PUBLIC_KEY=<publicKey>
    val centralUsername = read(System.getenv("CENTRAL_USERNAME") ?: findProperty("CENTRAL_USERNAME")?.toString())
    val centralPassword = read(System.getenv("CENTRAL_PASSWORD") ?: findProperty("CENTRAL_PASSWORD")?.toString())
    val privateKey = read(System.getenv("CENTRAL_PRIVATE_KEY") ?: findProperty("CENTRAL_PRIVATE_KEY")?.toString())
    val privateKeyPwd = read(System.getenv("CENTRAL_PRIVATE_KEY_PWD") ?: findProperty("CENTRAL_PRIVATE_KEY_PWD")?.toString())
    val publicKey = read(System.getenv("CENTRAL_PUBLIC_KEY") ?: findProperty("CENTRAL_PUBLIC_KEY")?.toString())
    dependsOn(tasks.build, tasks.generatePomFileForMavenPublication, cleanUpload)
    this.username = centralUsername
    this.password = centralPassword
    this.publishingType = "AUTOMATIC" // MANUAL
    this.signingKey = privateKey
    this.signingKeyPassphrase = privateKeyPwd
    this.publicKey = publicKey
    archives = project.layout.buildDirectory.dir("libs").get().asFileTree
    pom = file(project.layout.buildDirectory.file("publications/maven/pom-default.xml"))
}

tasks.test {
    onlyIf { !gradle.startParameter.taskNames.contains("sonatypeCentralUpload") }
}

project.afterEvaluate {
    tasks.findByName("shadowJar")?.apply {
        onlyIf { !gradle.startParameter.taskNames.contains("sonatypeCentralUpload") }
    }
}