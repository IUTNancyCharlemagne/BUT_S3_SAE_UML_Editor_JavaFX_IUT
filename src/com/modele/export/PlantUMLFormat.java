package com.modele.export;

import com.modele.Modele;
import com.modele.Sujet;
import com.modele.composite.FileComposite;
import com.modele.elements.Attribut;
import com.modele.elements.ClasseInterface;
import javafx.embed.swing.SwingFXUtils;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PlantUMLFormat implements Format
{
    private static PlantUMLFormat instance;

    private PlantUMLFormat()
    {

    }

    public void exporter(List<FileComposite> fichiers)
    {

    }

    public static Format getInstance() {
        if (instance == null)
            instance = new PlantUMLFormat();
        return instance;
    }

    public void exporter(Sujet modele, Stage stage)
    {
        StringBuilder plantUML = new StringBuilder("@startuml\n");
        List<ClasseInterface> classes = modele.getClasses();
        for (ClasseInterface classe : classes) {
            plantUML.append(classe.getNom()).append(" {\n");
            for (Attribut attribut : classe.getAttributs()) {
                plantUML.append("\t").append(getVisibiliteUml(attribut)).append(" ").append(attribut.getNom()).append("\n");
            }
            plantUML.append(classe.getAttributs()).append("\n");
            //plantUML.append(classe.getOperations()).append("\n");
            plantUML.append("}\n");
        }
        plantUML.append("@enduml");



        //--------------------
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "PlantUML files (*.plantuml)", "*.plantuml");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            String fileName = file.getName();

            if (!fileName.toUpperCase().endsWith(".PLANTUML")) {
                file = new File(file.getAbsolutePath() + ".plantuml");
            }

            try {
                Files.writeString(Path.of(file.getAbsolutePath() + ".plantuml"), plantUML.toString(), StandardCharsets.UTF_8);
            }
            catch (IOException ex) {
                System.err.println("Chemin invalide");
            }
        }
        //--------------------------------------------------------------------------------
    }


    public static String getVisibiliteUml(Attribut attribut) {
        return switch (attribut.getVisibilite()) {
            case "public" -> "+";
            case "private" -> "-";
            case "protected" -> "#";
            default -> "";
        };
    }
}
