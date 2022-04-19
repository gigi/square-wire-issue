package com.gigi.wiredemo;

import com.squareup.wire.schema.Location;
import com.squareup.wire.schema.Schema;
import com.squareup.wire.schema.SchemaLoader;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.List;

@SpringBootApplication
public class WiredemoApplication {

    public static void main(String[] args) {

        System.out.printf("Loader initing...%n");

        SchemaLoader schemaLoader = new SchemaLoader(FileSystems.getDefault());

        List<Location> wireLocations = List.of(Location.get(new FileSystemResource("proto").getFile().getAbsolutePath()));

        System.out.printf("Initing roots %s...%n",  wireLocations);

        schemaLoader.initRoots(wireLocations, List.of());

        try {
            System.out.printf("Trying to load files from folder %s...%n",  wireLocations);
            Schema schema = schemaLoader.loadSchema();
            System.out.printf("LOADED %s!!!%n", schema.getProtoFiles());
        } catch (IOException e) {
            System.out.printf("ERROR HERE!!!%n");
            e.printStackTrace();
        }

    }

}
