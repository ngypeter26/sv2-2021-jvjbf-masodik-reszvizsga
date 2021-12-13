package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private List<Human> humans = new ArrayList<>();

    public void readHumansFromFile(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            addHumansFromLines(lines);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        try {
            Files.write(path, createMaleLines());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write file!", ioe);
        }
    }

    public List<Human> getHumans() {
        return humans;
    }

    private void addHumansFromLines(List<String> lines) {
        String name;
        String id;
        for (String line : lines) {
            name = line.split(";")[0];
            id = line.split(";")[1];
            humans.add(new Human(name, id));
        }
    }

    private List<String> createMaleLines() {
        List<String> maleLines = new ArrayList<>();
        String str;
        for (Human human : humans) {
            if (human.getIdentityNumber().startsWith("1") || human.getIdentityNumber().startsWith("3")) {
                str = human.getName() + ";" + human.getIdentityNumber();
                maleLines.add(str);
            }
        }
        return maleLines;
    }
}
