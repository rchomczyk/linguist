package pl.auroramc.lobby.file

import org.bukkit.plugin.Plugin
import java.io.File
import java.net.JarURLConnection

class FileUtils {

    companion object {

        fun <T> saveResourcesFromClasspath(plugin: Plugin, pluginClass: Class<T>, directoryName: String) where T: Plugin {
            val resources = loadResourcesFromClasspath(pluginClass, directoryName)
                resources.forEach { resource ->
                    val expectedResourceFile = File(plugin.dataFolder, resource)
                    if (expectedResourceFile.exists()) {
                        return
                    }

                    plugin.saveResource(resource, REPLACE_RESOURCE_FILE_FROM_CLASSPATH)
                }
        }

        private fun <T> loadResourcesFromClasspath(pluginClass: Class<T>, directoryName: String): Set<String> where T: Plugin {
            val resources = HashSet<String>()

            val url = pluginClass.getResource("/${directoryName}/")
            val urlConnection = url?.openConnection() as JarURLConnection

            val directoryPath = "${directoryName}/"
            for (entry in urlConnection.jarFile.entries().asIterator()) {
                if (entry.name.startsWith(directoryPath)) {
                    val fileName = entry.name.removePrefix(directoryPath)
                    if (fileName.isBlank()) {
                        continue
                    }

                    resources.add(entry.name)
                }
            }

            return resources
        }
    }
}

private const val REPLACE_RESOURCE_FILE_FROM_CLASSPATH = false