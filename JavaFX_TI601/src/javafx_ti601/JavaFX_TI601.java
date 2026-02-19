package javafx_ti601;

import javafx.scene.control.Alert;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.input.MouseButton;

public class JavaFX_TI601 extends Application {

   @Override
public void start(Stage stage) {

    Pane root = new Pane();

    double width = 600;
    double height = 600;

    
// poligono
    // Eje X
    javafx.scene.shape.Line ejeX = new javafx.scene.shape.Line(0, height / 2, width, height / 2);
    ejeX.setStroke(Color.GRAY);

    // Eje Y
    javafx.scene.shape.Line ejeY = new javafx.scene.shape.Line(width / 2, 0, width / 2, height);
    ejeY.setStroke(Color.GRAY);

    root.getChildren().addAll(ejeX, ejeY);

    // plano cartesiano
    for (int i = 0; i <= width; i += 50) {
        javafx.scene.shape.Line vertical = new javafx.scene.shape.Line(i, 0, i, height);
        vertical.setStroke(Color.LIGHTGRAY);
        root.getChildren().add(vertical);
    }

    for (int i = 0; i <= height; i += 50) {
        javafx.scene.shape.Line horizontal = new javafx.scene.shape.Line(0, i, width, i);
        horizontal.setStroke(Color.LIGHTGRAY);
        root.getChildren().add(horizontal);
    }

    // poligono

    List<Point> points = Arrays.asList(
            new Point(150, 150),
            new Point(400, 150),
            new Point(450, 300),
            new Point(300, 450),
            new Point(150, 350)
    );

    ConvexPolygon polygonLogic = new ConvexPolygon(points);

    javafx.scene.shape.Polygon polygonFX = new javafx.scene.shape.Polygon();

    for (Point p : points) {
        polygonFX.getPoints().addAll(p.x, p.y);

        // Mostrar coordenadas del vértice
        javafx.scene.text.Text label = new javafx.scene.text.Text(
                p.x + 5,
                p.y - 5,
                "(" + p.x + ", " + p.y + ")"
        );
        root.getChildren().add(label);
    }

    polygonFX.setFill(Color.LIGHTBLUE);
    polygonFX.setStroke(Color.BLACK);

    // punto de prueba 
    Point testPoint = new Point(200, 300);

    Circle circle = new Circle(testPoint.x, testPoint.y, 6);

    if (polygonLogic.isInside(testPoint)) {
        circle.setFill(Color.GREEN);
    } else {
        circle.setFill(Color.RED);
    }

    // Mostrar coordenada del punto
    javafx.scene.text.Text testLabel = new javafx.scene.text.Text(
            testPoint.x + 5,
            testPoint.y - 5,
            "P" + "(" + testPoint.x + ", " + testPoint.y + ")"
    );

    root.getChildren().addAll(polygonFX, circle, testLabel);

    Scene scene = new Scene(root, width, height);
    stage.setScene(scene);
    stage.setTitle("Plano Cartesiano - Punto en Polígono");
    stage.show();
}


    public static void main(String[] args) {
        launch();
    }
}
