package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        StringBuilder log = new StringBuilder();

        // 1. В папке Games создайте несколько директорий: src, res, savegames, temp
        File dirGames = new File("D://Games");
        File dirSrc = makeDir(dirGames, "src", log);
        File dirRes = makeDir(dirGames, "res", log);
        File dirSavegames = makeDir(dirGames, "savegames", log);
        File dirTemp = makeDir(dirGames, "temp", log);

        // 2. В каталоге src создайте две директории: main, test
        File dirMain = makeDir(dirSrc, "main", log);
        File dirTest = makeDir(dirSrc, "test", log);

        // 3. В подкаталоге main создайте два файла: Main.java, Utils.java
        File fileMain = makeFile(dirMain, "Main.java", log);
        File fileUtils = makeFile(dirMain, "Utils.java", log);

        // 4. В каталог res создайте три директории: drawables, vectors, icons
        File dirDrawables = makeDir(dirRes, "drawables", log);
        File dirVectors = makeDir(dirRes, "vectors", log);
        File dirIcons = makeDir(dirRes, "icons", log);

        // 5. В директории temp создайте файл temp.txt
        File temp = new File(dirTemp, "temp.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(temp, false))) {
            bw.write(log.toString());
            log.append("Создан файл " + temp.getName() + "\n");
        } catch (IOException ex) {
            log.append("Не удалось записать файл temp.txt по причине " + ex.getMessage() + "\n");
        }

        System.out.println("Программа завершена");
    }

    public static File makeDir(File parentDir, String dirName, StringBuilder log) {

        File dir = new File(parentDir, dirName);
        if (dir.mkdir()) {
            log.append("Создан каталог " + dir.getName() + "\n");
        } else {
            log.append("Не удалось создать каталог " + dir.getName() + "\n");
        }
        return dir;
    }

    public static File makeFile(File parentDir, String fileName, StringBuilder log) {

        File file = new File(parentDir, fileName);

        try {
            if (file.createNewFile()) {
                log.append("Создан файл " + file.getName() + "\n");
            }
        } catch (IOException ex) {
            log.append("Не удалось создать файл " + file.getName() + " по причине " + ex.getMessage() + "\n");
        }
        return file;
    }
}
