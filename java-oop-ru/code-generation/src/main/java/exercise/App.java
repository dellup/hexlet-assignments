package exercise;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static exercise.Car.deserialize;

public class App {
    public static Path save(Path path, Car car) throws IOException {
        return Files.writeString(path, car.serialize());
    }
    public static Car extract(Path path) throws IOException {
        return deserialize(Files.readString(path));
    }
}