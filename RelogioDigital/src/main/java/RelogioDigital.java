import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RelogioDigital extends Application {

    final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void start(Stage palco){
        Label rotuloTempo = new Label();
        rotuloTempo.setStyle("-fx-font-size: 30px; -fx-text-fill: yellow;");

        //Criação de um Keyframe
        KeyFrame KeyFrameAtualizar = new KeyFrame(Duration.ZERO, e -> {
            rotuloTempo.setText(LocalDateTime.now().format(FORMATADOR));
        });

        //Criação de outro KeyFrame que define o intervalo de atualização
        KeyFrame KeyFrameIntervalo = new KeyFrame(Duration.seconds(1));

        //Criação da TimeLine e adição dos KeyFrames
        Timeline relogio = new Timeline();
        relogio.getKeyFrames().addAll(KeyFrameAtualizar, KeyFrameIntervalo);

        //Definimos que a ação de atualizar o rotulo com a hora atual
        //Vai acontecer a cada segundo, para sempre.
        relogio.setCycleCount(Animation.INDEFINITE);
        relogio.play();  //Inica a Timeline

        VBox vboxLayoute = new VBox(rotuloTempo);
        vboxLayoute.setAlignment(Pos.CENTER);
        vboxLayoute.setStyle("-fx-background-color: black");

        Scene cena = new Scene(vboxLayoute, 300,100);

        palco.setTitle(("RelogioDigital"));
        palco.setScene(cena);
        palco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
