package core;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class ResourcesUtils {

    private static String getPathToResourceFolder() {
        return System.getProperty("resourceFolderPath", "/Users/mac/Documents/resource/");
    }

    public static File getResourceFile(String resourcePath) {
        String finalPath = getPathToResourceFolder().concat(resourcePath);

        File file = new File(finalPath);

        if (file.exists()) return file;
        throw new IllegalArgumentException("File with path: " + resourcePath + " doesn't exist");
    }

    public static File getRandomResourceFile() {
        Path finalPath = Path.of(getPathToResourceFolder());
        List<Path> collect = new ArrayList<Path>();
        try {
            collect = Files.list(finalPath).collect(Collectors.toList());
            Collections.shuffle(collect);
        } catch (IOException e) {
            log.error("Resource directory not found");
        }
        if (Files.exists(collect.get(0))) return collect.get(0).toFile();
        throw new IllegalArgumentException("Directory with path: " + getPathToResourceFolder() + " doesn't exist");
    }

    public static List<File> getTestResourceAsFiles(String... resourcePaths) {
        return Stream.of(resourcePaths).map(ResourcesUtils::getResourceFile).collect(Collectors.toList());
    }
}
