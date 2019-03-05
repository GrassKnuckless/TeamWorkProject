package com.kn106.js_raisers.firstAttempt;

import javafx.animation.*;
import javafx.application.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javafx.scene.shape.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;


public class Graphics extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // Primary Stage

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Image to work with
        Image image = new Image("https://popugai.info/wp-content/uploads/2016/03/cute_love_bird_colorful_1920x1200.jpg");
        ImageView imageView = new ImageView(image);

        Group root = new Group();
        Scene scene = new Scene(root);

        // background
        Rectangle background = new Rectangle(0, 50,1920, 1080);
        background.setFill(Color.rgb(227,225,228));
        root.getChildren().add(background);

        // header
        Rectangle header = new Rectangle(0,0,1920, 50);
        header.setFill(Color.rgb(38,40,42));
        root.getChildren().add(header);

        // Settings
        Image setting_logo = new Image(new FileInputStream("pics/settings2.jpg"));
        ImageView setting_logoView = new ImageView(setting_logo);
        setting_logoView.setX(1860);
        setting_logoView.setY(12);
        root.getChildren().add(setting_logoView);

        // setting_logo onMouseIn
        setting_logoView.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // FAQ button cursor changer
                RotateTransition rt = new RotateTransition(Duration.millis(1000), setting_logoView);
                rt.setByAngle(360);
                rt.setCycleCount(1);
                //rt.setAutoReverse(true);

                rt.play();

            }
        });

        // setting_logo onMouseOut
        setting_logoView.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

            }
        });

        // setting_logo onMouseClicked
        setting_logoView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // popup menu for settings
            }
        });

        // Logo
        Text logo = new Text(10, 35, "Java Project");
        logo.setFill(Color.WHITE);
        logo.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 30));
        root.getChildren().add(logo);

        // FAQ
        Text faq = new Text(1550, 32, "FAQ");
        faq.setFill(Color.WHITE);
        faq.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 20));
        root.getChildren().add(faq);

        // Terms & Conditions
        Text TandC = new Text(1630, 32, "Terms & Conditions");
        TandC.setFill(Color.WHITE);
        TandC.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 20));
        root.getChildren().add(TandC);

        // FAQ onMouseIn
        faq.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // FAQ button cursor changer
                faq.setStyle("-fx-cursor: hand");
                faq.setStyle("-fx-shadow-highlight-color");
                FillTransition fillTransition = new FillTransition(Duration.seconds(0.3), faq);
                fillTransition.setFromValue(Color.WHITE);
                fillTransition.setToValue(Color.rgb(214, 96, 148));
                fillTransition.setAutoReverse(true);
                fillTransition.play();

            }
        });

        // FAQ onMouseOut
        faq.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                faq.setFill(Color.WHITE);
            }
        });

        // FAQ onMouseClicked
        faq.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ////////// FAQ popup field /////////////

                // FAQ popup top field
                Rectangle popup_top = new Rectangle(310,300,1200, 10);
                popup_top.setFill(Color.rgb(209,186,202));

                root.getChildren().add(popup_top);

                // FAQ popup main field
                Rectangle popup_main = new Rectangle(310,310,1200, 400);
                popup_main.setFill(Color.rgb(232,232,232));
                root.getChildren().add(popup_main);

                // FAQ popup borders
                Line popup_border1 = new Line(310,300,310,710);
                popup_border1.setStroke(Color.rgb(85,83,85));

                Line popup_border2 = new Line(1510,300,1510,710);
                popup_border2.setStroke(Color.rgb(85,83,85));

                Line popup_border3 = new Line(310,300,1510,300);
                popup_border3.setStroke(Color.rgb(85,83,85));

                Line popup_border4 = new Line(310,710,1510,710);
                popup_border4.setStroke(Color.rgb(85,83,85));

                root.getChildren().addAll(popup_border1, popup_border2, popup_border3, popup_border4);

                // Students who participated in this project
                Text inside_faq = new Text(500, 375, "Students who participated in this project:");
                inside_faq.setFill(Color.rgb(53,56,58));
                inside_faq.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 45));
                root.getChildren().add(inside_faq);

                // Students names
                Text inside_faq2 = new Text(780, 430, "Stadnytskyi Dmytro\nPotashnik Mykhailo\nMrglotskyi Markyian");
                inside_faq2.setFill(Color.rgb(115,108,120));
                inside_faq2.setFont(Font.font ("Proxima Nova", 30));
                root.getChildren().add(inside_faq2);

                // FAQ ❌(close) button
                Text FAQ_close_button = new Text(1470, 345, "❌");
                FAQ_close_button.setFont(Font.font ("Verdana", 28));
                FAQ_close_button.setFill(Color.rgb(38,40,42));
                root.getChildren().add(FAQ_close_button);

                        //FAQ close button onMouseEntered
                        FAQ_close_button.setOnMouseEntered(new EventHandler<MouseEvent>
                                () {

                            @Override
                            public void handle(MouseEvent t) {

                                // FAQ button cursor changer
                                FAQ_close_button.setStyle("-fx-cursor: hand");
                                FillTransition fillTransition = new FillTransition(Duration.seconds(0.3), FAQ_close_button);
                                fillTransition.setFromValue(Color.rgb(38,40,42));
                                fillTransition.setToValue(Color.rgb(214, 96, 148));
                                fillTransition.setAutoReverse(true);
                                fillTransition.play();

                            }
                        });

                        //FAQ close button onMouseExited
                        FAQ_close_button.setOnMouseExited(new EventHandler<MouseEvent>
                                () {

                            @Override
                            public void handle(MouseEvent t) {
                                FAQ_close_button.setFill(Color.rgb(38,40,42));
                            }
                        });

                        // FAQ_close_button onMouseClicked
                        FAQ_close_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                root.getChildren().removeAll(inside_faq, inside_faq2, popup_border1, popup_border2, popup_border3, popup_border4, popup_top, popup_main);
                                Rectangle deleteBut = new Rectangle(1450,310,50, 50);
                                deleteBut.setFill(Color.rgb(227,225,228));
                                root.getChildren().add(deleteBut);
                            }
                        });


            }
        });



        WritableImage wImage = new WritableImage((int)image.getWidth(), (int)image.getHeight());
        PixelWriter pixelWriter = wImage.getPixelWriter();


        PixelReader pixelReader = image.getPixelReader();
            for(int i = 0; i < image.getWidth(); i++){
                for(int j = 0; j < image.getHeight(); j++){
                    Color color = pixelReader.getColor(i, j);
//                       pixelWriter.setColor(i, j, Color.color(color.getBlue(), color.getRed(), color.getGreen()));
                }
            }
        ImageIO.write(SwingFXUtils.fromFXImage(wImage, null), "png", new FileOutputStream("test.png"));
//        Image image1 = new Image("test.png");
//        ImageView image1View = new ImageView(image1);
//        imageView.setFitHeight(773);
//        imageView.setFitWidth(1030);
//        root.getChildren().add(image1View);
        primaryStage.setMaximized(true);
        primaryStage.getIcons().add(new Image("file:pics/agreement.png"));
        primaryStage.setTitle("KN-106 Teamwork Project");
        primaryStage.setScene(scene);
        primaryStage.show();



    }

}
