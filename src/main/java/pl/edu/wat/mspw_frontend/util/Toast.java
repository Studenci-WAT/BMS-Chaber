package pl.edu.wat.mspw_frontend.util;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Toast {
    public static void showToast(Stage ownerStage, String message, ToastType type) {
        Text text = new Text(message);
        text.setFont(Font.font("Verdana", 20));
        StackPane root = new StackPane(text);

        String backgroundColor;
        if (type == ToastType.SUCCESS) {
            backgroundColor = "rgba(0, 128, 0, 0.7)"; // Zielone tło dla komunikatu sukcesu
        } else if (type == ToastType.ERROR) {
            backgroundColor = "rgba(255, 0, 0, 0.7)"; // Czerwone tło dla komunikatu błędu
        } else {
            backgroundColor = "rgba(0, 0, 0, 0.5)"; // Domyślne tło (np. dla innych typów)
        }

        root.setStyle("-fx-background-color: " + backgroundColor + "; -fx-padding: 10px;");

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT); // Ustawienie przezroczystości sceny

        Stage toastStage = new Stage();
        toastStage.initOwner(ownerStage);
        toastStage.initStyle(StageStyle.TRANSPARENT); // Ustawienie przezroczystego stylu stage
        toastStage.setScene(scene);
        toastStage.setX(ownerStage.getX() + ownerStage.getWidth()/2 - root.getWidth()/2);
        toastStage.setY(ownerStage.getY() + ownerStage.getHeight()/2 - root.getHeight()/2);

        toastStage.show();

        Timeline fadeOutTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.5), new KeyValue (toastStage.opacityProperty(), 1)),
                new KeyFrame(Duration.seconds(2.5), new KeyValue (toastStage.opacityProperty(), 0))
        );
        fadeOutTimeline.setOnFinished((e) -> toastStage.close());
        fadeOutTimeline.play();
    }

    public enum ToastType {
        SUCCESS,
        ERROR,
        INFO
    }


}