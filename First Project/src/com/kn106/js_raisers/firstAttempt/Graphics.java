package com.kn106.js_raisers.firstAttempt;

import javafx.animation.*;
import javafx.application.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javafx.scene.shape.*;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import static java.lang.Math.cos;
import static java.lang.Math.sin;


public class Graphics extends Application {
    public Desktop desktop = Desktop.getDesktop();

    public static void main(String[] args) {
        launch(args);
    }

    // Primary Stage

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root);

        // background
        Rectangle background = new Rectangle(0, 0,1920, 1080);

        // greetings menu
        background.setFill(Color.rgb(98,98,98));
        root.getChildren().add(background);

        // header of main
        Rectangle main_header = new Rectangle(0,0,1920, 50);
        main_header.setFill(Color.rgb(63,66,73));

        // header menu icon
        Rectangle header_menu_rect = new Rectangle(0,0,70, 50);
        header_menu_rect.setFill(Color.rgb(63,66,73));
        Image header_menu_icon = new Image(new FileInputStream("First Project/pics/menu_screen.jpg"));
        ImageView header_menu_iconView = new ImageView(header_menu_icon);
        header_menu_iconView.setX(20);
        header_menu_iconView.setY(10);
        Text header_icon_text = new Text(17, 40, "Menu");
        header_icon_text.setFont(Font.font ("Dubai", 13));
        header_icon_text.setFill(Color.WHITE);

        ///////////////////////////////  Start menu ///////////////////////////////////////////////
        // Welcome text
        Text welcome_text = new Text(510, 278, "Welcome");
        welcome_text.setFont(Font.font ("Dubai Light", 60));
        welcome_text.setFill(Color.WHITE);
        root.getChildren().add(welcome_text);

        // Greetings => Create button
        Rectangle create_button = new Rectangle(520,316,204, 144);
        create_button.setFill(Color.WHITE);
        root.getChildren().add(create_button);

        // Greetings => Open button
        Rectangle open_button = new Rectangle(520,486,204, 144);
        open_button.setFill(Color.WHITE);
        root.getChildren().add(open_button);

        // Greetings => Paste button
        Rectangle paste_button = new Rectangle(520,654,204, 144);
        paste_button.setFill(Color.WHITE);
        root.getChildren().add(paste_button);

        // Greetings => First adv
        Rectangle first_adv = new Rectangle(773,317,613, 243);
        Stop[] stops = new Stop[] { new Stop(0, Color.rgb(0, 100, 182)), new Stop(1, Color.rgb(102, 83, 230))};
        LinearGradient linearGradient1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        first_adv.setFill(linearGradient1);
        root.getChildren().add(first_adv);

        // Greetings => First adv => Text1
        Text greetings_firstAdv_header = new Text(788, 350, "Working with our project");
        greetings_firstAdv_header.setFont(Font.font ("Dubai Light", FontWeight.THIN, 30));
        greetings_firstAdv_header.setFill(Color.WHITE);
        root.getChildren().add(greetings_firstAdv_header);

        // Greetings => First adv => Text2
        Text greetings_firstAdv_main = new Text(785, 430, "Thanks to our latest technologies,\n" +
                "you can enjoy the fresh look of your photos\n" +
                "and share it with the rest of the world.");
        greetings_firstAdv_main.setFont(Font.font ("Dubai Light", FontWeight.THIN, 18));
        greetings_firstAdv_main.setFill(Color.WHITE);
        greetings_firstAdv_main.setLineSpacing(2);
        root.getChildren().add(greetings_firstAdv_main);

        // Greetings => First adv => tigerParrot
        Image tiger_parrot_image = new Image(new FileInputStream("First Project/pics/world_map.png"));
        ImageView tiger_parrot_imageView = new ImageView(tiger_parrot_image);
        tiger_parrot_imageView.setX(1050);
        tiger_parrot_imageView.setY(330);
        tiger_parrot_imageView.setFitWidth(400);
        tiger_parrot_imageView.setFitHeight(250);
        root.getChildren().add(tiger_parrot_imageView);

        // Greetings => first image with description
        Rectangle first_image_with_desc = new Rectangle(773,582,293, 216);
        first_image_with_desc.setFill(Color.WHITE);
        root.getChildren().add(first_image_with_desc);

        // Greetings => first image with description
        Rectangle second_image_with_desc = new Rectangle(1092,582,293, 216);
        second_image_with_desc.setFill(Color.WHITE);
        root.getChildren().add(second_image_with_desc);

        // Greetings => new file image
        Image new_file_image = new Image(new FileInputStream("First Project/pics/newFile.png"));
        ImageView new_file_imageView = new ImageView(new_file_image);
        new_file_imageView.setX(600);
        new_file_imageView.setY(358);
        new_file_imageView.setFitWidth(37);
        new_file_imageView.setFitHeight(37);
        root.getChildren().add(new_file_imageView);

        // Greetings => Open Folder icon
        Image open_folderImage = new Image(new FileInputStream("First Project/pics/open-folder.png"));
        ImageView open_folderImageView = new ImageView(open_folderImage);
        open_folderImageView.setX(600);
        open_folderImageView.setY(523);
        open_folderImageView.setFitWidth(45);
        open_folderImageView.setFitHeight(45);
        root.getChildren().add(open_folderImageView);

        // Greetings => Paste Folder icon
        Image paste_folderImage = new Image(new FileInputStream("First Project/pics/paste.png"));
        ImageView paste_folderImageView = new ImageView(paste_folderImage);
        paste_folderImageView.setX(600);
        paste_folderImageView.setY(688);
        paste_folderImageView.setFitWidth(45);
        paste_folderImageView.setFitHeight(45);
        root.getChildren().add(paste_folderImageView);

        // Create new file text
        Text new_file_Text = new Text(585, 425, "Create");
        new_file_Text.setFont(Font.font ("Dubai Light", FontWeight.THIN, 26));
        new_file_Text.setFill(Color.GREY);
        root.getChildren().add(new_file_Text);

        // open file text
        Text open_file_Text = new Text(591, 593, "Open");
        open_file_Text.setFont(Font.font ("Dubai Light", FontWeight.THIN, 26));
        open_file_Text.setFill(Color.GREY);
        root.getChildren().add(open_file_Text);

        // paste file text
        Text paste_file_Text = new Text(594, 761, "Paste");
        paste_file_Text.setFont(Font.font ("Dubai Light", FontWeight.THIN, 26));
        paste_file_Text.setFill(Color.GREY);
        root.getChildren().add(paste_file_Text);

        //work with image
        Text rgb_change_button = new Text(70, 150,"RGB changer");
        rgb_change_button.setFill(Color.rgb(53,56,58));
        rgb_change_button.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 40));

        // FileChooser
        FileChooser fileChooser = new FileChooser();

        Text old_pic_Text = new Text(500, 270,"Old");
        old_pic_Text.setFill(Color.rgb(53,56,58));
        old_pic_Text.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 30));

        Text new_pic_Text = new Text(1320, 270,"New");
        new_pic_Text.setFill(Color.rgb(53,56,58));
        new_pic_Text.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 30));

        // Save jpg
        Text save_jpg_Text = new Text(450, 850,"Save .jpg\n(will be moved to menu)");
        save_jpg_Text.setFill(Color.rgb(53,56,58));
        save_jpg_Text.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 30));

        // Save png
        Text save_png_Text = new Text(1300, 850,"Save .png\n(will be moved to menu)");
        save_png_Text.setFill(Color.rgb(53,56,58));
        save_png_Text.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 30));

        // 🡐 Back button
        Text back_button = new Text(30, 100,"\uD83E\uDC50 Back");
        back_button.setFill(Color.rgb(53,56,58));
        back_button.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 30));

        // Successfully saved popup main field
        Rectangle success_popup_main = new Rectangle(310,315,1200, 400);
        success_popup_main.setFill(Color.rgb(232,232,232));

        // Successfully saved popup borders
        Line success_popup_border1 = new Line(310,300,310,715);
        success_popup_border1.setStroke(Color.rgb(85,83,85));

        Line success_popup_border2 = new Line(1510,300,1510,715);
        success_popup_border2.setStroke(Color.rgb(85,83,85));

        Line success_popup_border3 = new Line(310,300,1510,300);
        success_popup_border3.setStroke(Color.rgb(85,83,85));

        Line success_popup_border4 = new Line(310,715,1510,715);
        success_popup_border4.setStroke(Color.rgb(85,83,85));

        // Successfully saved popup top field
        Rectangle success_popup_top = new Rectangle(310,300,1200, 15);
        success_popup_top.setFill(Color.rgb(209,186,202));

        // success ❌(close) button
        Text success_close_button = new Text(1470, 345, "❌");
        success_close_button.setFont(Font.font ("Verdana", 28));
        success_close_button.setFill(Color.rgb(38,40,42));

        Text inside_success_popup = new Text(750, 500, "Successfully saved");
        inside_success_popup.setFill(Color.rgb(53,56,58));
        inside_success_popup.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 45));

        // rgb change slider RED
        Text slider_redText = new Text(1760, 81, "Red: ");
        slider_redText.setFont(Font.font ("Dubai", FontWeight.THIN, 14));
        slider_redText.setFill(Color.rgb(38,40,42));

        Slider slider_red = new Slider();
        slider_red.setMin(0);
        slider_red.setMax(100);
        slider_red.setValue(100);
        //slider_red.setStyle("-fx-slider-track-color: red; ");
//        settings_check_box.setStyle(
//                "-fx-border-color: rgb(209,186,202); "
//                        + "-fx-base: rgb(209,186,202);"
//                        + "-fx-border-insets: -5;"
//                        + "-fx-border-radius: 15;"
//                        + "-fx-border-style: dotted;"
//                        + "-fx-border-width: 2;"
//        );
        slider_red.setMaxWidth(100);
        slider_red.setLayoutX(1800);
        slider_red.setLayoutY(70);

        // rgb change slider Green
        Text slider_greenText = new Text(1760, 101, "Green: ");
        slider_greenText.setFont(Font.font ("Dubai", FontWeight.THIN, 14));
        slider_greenText.setFill(Color.rgb(38,40,42));

        Slider slider_green = new Slider();
        slider_green.setMin(0);
        slider_green.setMax(100);
        slider_green.setValue(100);
        slider_green.setMaxWidth(100);
        slider_green.setLayoutX(1800);
        slider_green.setLayoutY(90);

        // rgb change slider BLUE
        Text slider_blueText = new Text(1760, 121, "Blue: ");
        slider_blueText.setFont(Font.font ("Dubai", FontWeight.THIN, 14));
        slider_blueText.setFill(Color.rgb(38,40,42));

        Slider slider_blue = new Slider();
        slider_blue.setMin(0);
        slider_blue.setMax(100);
        slider_blue.setValue(100);
        slider_blue.setMaxWidth(100);
        slider_blue.setLayoutX(1800);
        slider_blue.setLayoutY(110);

        // slider for thickness
        Text slider_thicknessText = new Text(1710, 121, "Thickness: ");
        slider_thicknessText.setFont(Font.font ("Dubai", FontWeight.THIN, 15));
        slider_thicknessText.setFill(Color.rgb(38,40,42));

        Slider slider_thickness = new Slider();
        slider_thickness.setMin(0);
        slider_thickness.setMax(100);
        slider_thickness.setValue(100);
        slider_thickness.setMaxWidth(100);
        slider_thickness.setLayoutX(1785);
        slider_thickness.setLayoutY(110);

        Text thicknessText = new Text(1730, 150, "Value: 100 px");
        thicknessText.setFont(Font.font ("Dubai", FontWeight.BOLD, 20));
        thicknessText.setFill(Color.rgb(38,40,42));

        slider_thickness.valueProperty().addListener((observable, oldValue, newValue) -> {

            thicknessText.setText("Value: " + Double.toString(newValue.intValue()) + " px");

        });

        // top navbar1 : navbar_brushesRect, navbar_brushesIconView, navbar_brushesIconText
        Rectangle navbar_brushesRect = new Rectangle(760,0,70, 50);
        navbar_brushesRect.setFill(Color.rgb(63,66,73));
        Image navbar_brushesIcon = new Image(new FileInputStream("First Project/pics/brush.jpg"));
        ImageView navbar_brushesIconView = new ImageView(navbar_brushesIcon);
        navbar_brushesIconView.setX(760);
        navbar_brushesIconView.setY(10);
        Text navbar_brushesIconText = new Text(751, 43, "Brushes");
        navbar_brushesIconText.setFont(Font.font ("Dubai", 13));
        navbar_brushesIconText.setFill(Color.WHITE);

        // top navbar2 : navbar_shapesRect, navbar_shapesIconView, navbar_shapesIconText
        Rectangle navbar_shapesRect = new Rectangle(830,0,70, 50);
        navbar_shapesRect.setFill(Color.rgb(63,66,73));
        Image navbar_shapesIcon = new Image(new FileInputStream("First Project/pics/shapes.jpg"));
        ImageView navbar_shapesIconView = new ImageView(navbar_shapesIcon);
        navbar_shapesIconView.setX(830);
        navbar_shapesIconView.setY(10);
        Text navbar_shapesIconText = new Text(824, 43, "Shapes");
        navbar_shapesIconText.setFont(Font.font ("Dubai", 13));
        navbar_shapesIconText.setFill(Color.WHITE);

        // top navbar3 : navbar_stickersRect, navbar_stickersIconView, navbar_stickersIconText
        Rectangle navbar_stickersRect = new Rectangle(900,0,70, 50);
        navbar_stickersRect.setFill(Color.rgb(63,66,73));
        Image navbar_stickersIcon = new Image(new FileInputStream("First Project/pics/stickerss.jpg"));
        ImageView navbar_stickersIconView = new ImageView(navbar_stickersIcon);
        navbar_stickersIconView.setX(900);
        navbar_stickersIconView.setY(10);
        Text navbar_stickersIconText = new Text(891, 43, "Stickers");
        navbar_stickersIconText.setFont(Font.font ("Dubai", 13));
        navbar_stickersIconText.setFill(Color.WHITE);

        // top navbar4 : navbar_textRect, navbar_textIconView, navbar_textIconText
        Rectangle navbar_textRect = new Rectangle(970,0,70, 50);
        navbar_textRect.setFill(Color.rgb(63,66,73));
        Image navbar_textIcon = new Image(new FileInputStream("First Project/pics/text.jpg"));
        ImageView navbar_textIconView = new ImageView(navbar_textIcon);
        navbar_textIconView.setX(970);
        navbar_textIconView.setY(10);
        Text navbar_textIconText = new Text(968, 43, "Text");
        navbar_textIconText.setFont(Font.font ("Dubai", 13));
        navbar_textIconText.setFill(Color.WHITE);

        // field for features
        Rectangle field_for_features = new Rectangle(1675,50,245, 1030);
        field_for_features.setFill(Color.rgb(240,242,243));

        Button btn1 = new Button("Circles");
        Button btn2 = new Button("Squares");
        Button btn3 = new Button("Default");

        btn1.setLayoutY(200);
        btn1.setLayoutX(1750);
        btn2.setLayoutY(250);
        btn2.setLayoutX(1750);
        btn3.setLayoutY(300);
        btn3.setLayoutX(1750);

        final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.CORAL);

        colorPicker.setLayoutX(1730);
        colorPicker.setLayoutY(350);

        //success close button onMouseEntered
        success_close_button.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // success_close_button cursor changer
                success_close_button.setStyle("-fx-cursor: hand");
                FillTransition fillTransition = new FillTransition(Duration.seconds(0.01), success_close_button);
                fillTransition.setFromValue(Color.rgb(38,40,42));
                fillTransition.setToValue(Color.rgb(214, 96, 148));
                fillTransition.setAutoReverse(true);
                fillTransition.play();

            }
        });

        //success_close_button onMouseExited
        success_close_button.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                success_close_button.setFill(Color.rgb(38,40,42));
            }
        });

        // success_close_button onMouseClicked
        success_close_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                background.setFill(Color.rgb(197,199,197));
                root.getChildren().removeAll(success_close_button, inside_success_popup, success_popup_border1, success_popup_border2, success_popup_border3, success_popup_border4, success_popup_main, success_popup_top);
                root.getChildren().add(rgb_change_button);
            }
        });

        back_button.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // 🡐 Back button cursor changer
                back_button.setStyle("-fx-cursor: hand");
                FillTransition fillTransition = new FillTransition(Duration.seconds(0.01), back_button);
                fillTransition.setFromValue(Color.rgb(38,40,42));
                fillTransition.setToValue(Color.rgb(214, 96, 148));
                fillTransition.setAutoReverse(true);
                fillTransition.play();

            }
        });

        //back_button button onMouseExited
        back_button.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                back_button.setFill(Color.rgb(38,40,42));
            }
        });



        //save_jpg_Text button onMouseEntered
        save_jpg_Text.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // save_jpg_Text button cursor changer
                save_jpg_Text.setStyle("-fx-cursor: hand");
                FillTransition fillTransition = new FillTransition(Duration.seconds(0.01), save_jpg_Text);
                fillTransition.setFromValue(Color.rgb(38,40,42));
                fillTransition.setToValue(Color.rgb(214, 96, 148));
                fillTransition.setAutoReverse(true);
                fillTransition.play();

            }
        });

        //save_jpg_Text button onMouseExited
        save_jpg_Text.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                save_jpg_Text.setFill(Color.rgb(38,40,42));
            }
        });

        //save_png_Text button onMouseEntered
        save_png_Text.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // save_png_Text button cursor changer
                save_png_Text.setStyle("-fx-cursor: hand");
                FillTransition fillTransition = new FillTransition(Duration.seconds(0.01), save_png_Text);
                fillTransition.setFromValue(Color.rgb(38,40,42));
                fillTransition.setToValue(Color.rgb(214, 96, 148));
                fillTransition.setAutoReverse(true);
                fillTransition.play();

            }
        });

        //save_png_Text button onMouseExited
        save_png_Text.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                save_png_Text.setFill(Color.rgb(38,40,42));
            }
        });

        //////////////////////////////  End of Start menu ///////////////////////////////////////////

        // header
        Rectangle header = new Rectangle(0,0,1920, 50);
        header.setFill(Color.rgb(38,40,42));

        // Settings
        Image setting_logo = new Image(new FileInputStream("First Project/pics/settings_logo.png"));
        ImageView setting_logoView = new ImageView(setting_logo);
        setting_logoView.setFitWidth(30);
        setting_logoView.setFitHeight(30);
        setting_logoView.setX(1860);
        setting_logoView.setY(10);

        // setting_logo onMouseIn
        setting_logoView.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // FAQ button cursor changer
                setting_logoView.setFitWidth(33);
                setting_logoView.setFitHeight(33);
                RotateTransition rt = new RotateTransition(Duration.millis(1000), setting_logoView);
                rt.setByAngle(360);
                rt.setCycleCount(1);
                rt.setAutoReverse(true);
                rt.play();

            }
        });

        // setting_logo onMouseOut
        setting_logoView.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                setting_logoView.setFitWidth(30);
                setting_logoView.setFitHeight(30);
            }
        });

        // setting_logo onMouseClicked
        setting_logoView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // popup menu for settings
                Rectangle settings_popup_top_background = new Rectangle(0,0,1920, 1080);
                settings_popup_top_background.setFill(Color.rgb(63,66,73));
                root.getChildren().add(settings_popup_top_background);

                Rectangle settings_popup_top = new Rectangle(310,100,1200, 15);
                settings_popup_top.setFill(Color.BLACK);

                root.getChildren().add(settings_popup_top);

                // settings popup main field
                Rectangle settings_popup_main = new Rectangle(310,115,1200, 600);
                settings_popup_main.setFill(Color.rgb(232,232,232));
                root.getChildren().add(settings_popup_main);

                // settings popup borders
                Line settings_border1 = new Line(310,100,310,715);
                settings_border1.setStroke(Color.rgb(85,83,85));

                Line settings_border2 = new Line(1510,100,1510,715);
                settings_border2.setStroke(Color.rgb(85,83,85));

                Line settings_border3 = new Line(310,100,1510,100);
                settings_border3.setStroke(Color.rgb(85,83,85));

                Line settings_border4 = new Line(310,715,1510,715);
                settings_border4.setStroke(Color.rgb(85,83,85));

                root.getChildren().addAll(settings_border1, settings_border2, settings_border3, settings_border4);

                // settings Text
                Text text_inside_settings = new Text(800, 175, "Settings:");
                text_inside_settings.setFill(Color.rgb(53,56,58));
                text_inside_settings.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 45));
                root.getChildren().add(text_inside_settings);

                CheckBox settings_check_box = new CheckBox();
                settings_check_box.setText("Use black/blue theme");
                //settings_check_box.setMaxWidth(15);
                settings_check_box.setLayoutX(400);
                settings_check_box.setLayoutY(250);
                settings_check_box.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 25));
                settings_check_box.setPadding(new Insets(7, 7, 7, 7));
                settings_check_box.setStyle(
                        "-fx-border-color: rgb(209,186,202); "
                                + "-fx-base: rgb(209,186,202);"
                                + "-fx-border-insets: -5;"
                                + "-fx-border-radius: 15;"
                                + "-fx-border-style: dotted;"
                                + "-fx-border-width: 2;"
                );




                root.getChildren().add(settings_check_box);

                // Settings ❌(close) button
                Text settings_close_but = new Text(1470, 145, "❌");
                settings_close_but.setFont(Font.font ("Verdana", 28));
                settings_close_but.setFill(Color.rgb(38,40,42));
                root.getChildren().add(settings_close_but);

                //Settings close button onMouseEntered
                settings_close_but.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {

                        // Settings button cursor changer
                        settings_close_but.setStyle("-fx-cursor: hand");
                        FillTransition fillTransition = new FillTransition(Duration.seconds(0.01), settings_close_but);
                        fillTransition.setFromValue(Color.rgb(38,40,42));
                        fillTransition.setToValue(Color.rgb(214, 96, 148));
                        fillTransition.setAutoReverse(true);
                        fillTransition.play();

                    }
                });

                //Terms and Conditions close button onMouseExited
                settings_close_but.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        settings_close_but.setFill(Color.rgb(38,40,42));
                    }
                });

                // Terms and Conditions close button onMouseClicked
                settings_close_but.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        root.getChildren().removeAll( settings_check_box,settings_popup_top_background, settings_close_but, settings_border1, settings_border2, settings_border3, settings_border4, settings_popup_top, settings_popup_main, text_inside_settings);
                        background.setFill(Color.rgb(227,225,228));
                    }
                });
            }
        });



        // Logo
        Text logo = new Text(10, 35, "Java Project");
        logo.setFill(Color.WHITE);
        logo.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 30));

        // FAQ
        Text faq = new Text(1550, 32, "FAQ");
        faq.setFill(Color.WHITE);
        faq.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 20));

        // Terms & Conditions
        Text TC_text = new Text(1630, 32, "Terms & Conditions");
        TC_text.setFill(Color.WHITE);
        TC_text.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 20));

        // Terms & Conditions events
        //Terms & Conditions onMouseEntered
        TC_text.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // Terms & Conditions button cursor changer
                TC_text.setStyle("-fx-cursor: hand");
                FillTransition fillTransition = new FillTransition(Duration.seconds(0.01), TC_text);
                fillTransition.setFromValue(Color.WHITE);
                fillTransition.setToValue(Color.rgb(214, 96, 148));
                fillTransition.setAutoReverse(true);
                fillTransition.play();

            }
        });

        //Terms & Conditions onMouseExited
        TC_text.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                TC_text.setFill(Color.WHITE);
            }
        });

        // Terms & Conditions onMouseClicked
        TC_text.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                background.setFill(Color.rgb(98,98,98));
                // Terms & Conditions popup top field
                Rectangle popup_top = new Rectangle(310,100,1200, 15);
                popup_top.setFill(Color.rgb(209,186,202));

                root.getChildren().add(popup_top);

                // Terms & Conditions popup main field
                Rectangle popup_main = new Rectangle(310,115,1200, 600);
                popup_main.setFill(Color.rgb(232,232,232));
                root.getChildren().add(popup_main);

                // Terms & Conditions popup borders
                Line TC_border1 = new Line(310,100,310,715);
                TC_border1.setStroke(Color.rgb(85,83,85));

                Line TC_border2 = new Line(1510,100,1510,715);
                TC_border2.setStroke(Color.rgb(85,83,85));

                Line TC_border3 = new Line(310,100,1510,100);
                TC_border3.setStroke(Color.rgb(85,83,85));

                Line TC_border4 = new Line(310,715,1510,715);
                TC_border4.setStroke(Color.rgb(85,83,85));

                root.getChildren().addAll(TC_border1, TC_border2, TC_border3, TC_border4);

                // Terms & Conditions Text
                Text Text_inside_TC = new Text(700, 175, "Terms & Conditions:");
                Text_inside_TC.setFill(Color.rgb(53,56,58));
                Text_inside_TC.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 45));
                root.getChildren().add(Text_inside_TC);

                Text Text2_inside_TC = new Text(350, 235, "Please read carefully these terms before using this application." +
                        " By continuing using this application, you confirm that the terms\nare acceptable for you and you agree to be bound by them." +
                        " If you do not agree to all of the terms set forth herein, please do not\nuse the application.");
                Text2_inside_TC.setFill(Color.rgb(53,56,58));
                Text2_inside_TC.setFont(Font.font ("Proxima Nova", 20));
                root.getChildren().add(Text2_inside_TC);

                // Terms and Conditions ❌(close) button
                Text TC_close_but = new Text(1470, 145, "❌");
                TC_close_but.setFont(Font.font ("Verdana", 28));
                TC_close_but.setFill(Color.rgb(38,40,42));
                root.getChildren().add(TC_close_but);



                //Terms and Conditions close button onMouseEntered
                TC_close_but.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {

                        // Terms and Conditions button cursor changer
                        TC_close_but.setStyle("-fx-cursor: hand");
                        FillTransition fillTransition = new FillTransition(Duration.seconds(0.01), TC_close_but);
                        fillTransition.setFromValue(Color.rgb(38,40,42));
                        fillTransition.setToValue(Color.rgb(214, 96, 148));
                        fillTransition.setAutoReverse(true);
                        fillTransition.play();

                    }
                });

                //Terms and Conditions close button onMouseExited
                TC_close_but.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        TC_close_but.setFill(Color.rgb(38,40,42));
                    }
                });

                // Terms and Conditions close button onMouseClicked
                TC_close_but.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        root.getChildren().removeAll(TC_close_but, TC_border1, TC_border2, TC_border3, TC_border4, popup_top, popup_main, Text_inside_TC, Text2_inside_TC);
                        background.setFill(Color.rgb(227,225,228));
                    }
                });
            }
        });

////////////////////////////////////////////////////////////////////////////////////////////////////////
        // FAQ onMouseIn
        faq.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // FAQ button cursor changer
                faq.setStyle("-fx-cursor: hand");
                FillTransition fillTransition = new FillTransition(Duration.seconds(0.01), faq);
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
                background.setFill(Color.rgb(98,98,98));
                ////////// FAQ popup field /////////////

                // FAQ popup top field
                Rectangle popup_top = new Rectangle(310,300,1200, 15);
                popup_top.setFill(Color.rgb(209,186,202));

                root.getChildren().add(popup_top);

                // FAQ popup main field
                Rectangle popup_main = new Rectangle(310,315,1200, 400);
                popup_main.setFill(Color.rgb(232,232,232));
                root.getChildren().add(popup_main);

                // FAQ popup borders
                Line popup_border1 = new Line(310,300,310,715);
                popup_border1.setStroke(Color.rgb(85,83,85));

                Line popup_border2 = new Line(1510,300,1510,715);
                popup_border2.setStroke(Color.rgb(85,83,85));

                Line popup_border3 = new Line(310,300,1510,300);
                popup_border3.setStroke(Color.rgb(85,83,85));

                Line popup_border4 = new Line(310,715,1510,715);
                popup_border4.setStroke(Color.rgb(85,83,85));

                root.getChildren().addAll(popup_border1, popup_border2, popup_border3, popup_border4);

                // Students who participated in this project
                Text inside_faq = new Text(500, 375, "Students who participated in this project:");
                inside_faq.setFill(Color.rgb(53,56,58));
                inside_faq.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 45));
                root.getChildren().add(inside_faq);

                // Students names
                Text inside_faq2 = new Text(780, 430, "Stadnytskyi Dmytro\nPotashnik Mykhailo\nMrglotskyi Markyian\nPashynina Alyona\nKazan Artur");
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
                        FillTransition fillTransition = new FillTransition(Duration.seconds(0.01), FAQ_close_button);
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
                        background.setFill(Color.rgb(227,225,228));
                        root.getChildren().removeAll(FAQ_close_button,inside_faq, inside_faq2, popup_border1, popup_border2, popup_border3, popup_border4, popup_top, popup_main);
                    }
                });



            }
        });

        ///////////////////////// icons onHover listeners /////////////////////////
        new_file_imageView.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // create button cursor changer
                new_file_imageView.setCursor(Cursor.HAND);
                create_button.setStroke(linearGradient1);
                create_button.setStrokeWidth(2);
                new_file_Text.setFill(Color.BLUE);
            }
        });

        open_folderImageView.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // create button cursor changer
                open_folderImageView.setCursor(Cursor.HAND);
                open_button.setStroke(linearGradient1);
                open_button.setStrokeWidth(2);
                open_file_Text.setFill(Color.BLUE);
            }
        });

        open_folderImageView.setOnMouseClicked(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // create button cursor changer
                root.getChildren().removeAll(new_file_Text, new_file_imageView, open_file_Text, open_folderImageView, paste_file_Text, paste_folderImageView,
                        first_adv, greetings_firstAdv_header, greetings_firstAdv_main, first_image_with_desc,second_image_with_desc, welcome_text,
                        create_button, open_button, paste_button, tiger_parrot_imageView);
                background.setFill(Color.rgb(197,199,197));

                File start_file = fileChooser.showOpenDialog(primaryStage);

                // Image to work with
                Image start_image = new Image(start_file.toURI().toString()); // to URI is full path
                ImageView start_imageView = new ImageView(start_image);

                start_imageView.setFitWidth(1280);
                start_imageView.setFitHeight(720);
                start_imageView.setX(200);
                start_imageView.setY(100);

                ImageView finish_imageView = new ImageView();


                root.getChildren().addAll(start_imageView, rgb_change_button);

                // rgb_change_button onMouseClicked
                rgb_change_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        // Working with image
                        WritableImage wImage = new WritableImage((int)start_image.getWidth(), (int)start_image.getHeight());
                        PixelWriter pixelWriter = wImage.getPixelWriter();


                        PixelReader pixelReader = start_image.getPixelReader();
                        //start_imageView.setVisible(false);



                        for(int i = 0; i < start_image.getWidth(); i++){
                            for(int j = 0; j < start_image.getHeight(); j++){
                                Color color = pixelReader.getColor(i, j);
                                pixelWriter.setColor(i, j, Color.color(color.getBlue(), color.getRed(), color.getGreen()));
                                //finish_imageView.setImage(wImage);
                            }
                        }

                        finish_imageView.setFitWidth(1280);
                        finish_imageView.setFitHeight(720);
                        finish_imageView.setX(200);
                        finish_imageView.setY(100);
                        //root.getChildren().add(finish_imageView);

                        root.getChildren().remove(rgb_change_button);
                        root.getChildren().addAll(old_pic_Text, new_pic_Text, save_jpg_Text, save_jpg_Text, save_png_Text, back_button);

                        // Back button listeners
                        //back_button button onMouseEntered

                        // back_button onMouseClicked
                        back_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                root.getChildren().removeAll(back_button, save_jpg_Text, save_png_Text, start_imageView,
                                        finish_imageView, new_pic_Text, old_pic_Text, slider_red, slider_green, slider_blue,
                                        slider_redText, slider_greenText, slider_blueText);
                                //root.getChildren().addAll(rgb_change_button);
                            }
                        });

                        // save_jpg_Text button onMouseClicked
                        save_jpg_Text.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                try{
                                    ImageIO.write(SwingFXUtils.fromFXImage(wImage, null), "png", new FileOutputStream("image.jpg"));
                                    root.getChildren().removeAll(back_button, save_jpg_Text, save_png_Text, start_imageView, finish_imageView, new_pic_Text, old_pic_Text);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                root.getChildren().addAll(success_popup_top,success_popup_border1, success_popup_border2, success_popup_border3, success_popup_border4);
                                background.setFill(Color.rgb(98,98,98));
                                root.getChildren().addAll(inside_success_popup, success_close_button);

                            }
                        });

                        // save_png_Text button onMouseClicked
                        save_png_Text.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                try{
                                    ImageIO.write(SwingFXUtils.fromFXImage(wImage, null), "png", new FileOutputStream("image.png"));
                                    root.getChildren().removeAll(back_button, save_jpg_Text, save_png_Text, start_imageView, finish_imageView, new_pic_Text, old_pic_Text);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                root.getChildren().addAll(success_popup_top, success_popup_main, success_popup_border1, success_popup_border2, success_popup_border3, success_popup_border4);
                                background.setFill(Color.rgb(98,98,98));
                                root.getChildren().addAll(inside_success_popup, success_close_button);
                            }
                        });

                        /////////////// Mb for future //////////////////////////
                        //try {                                          @@@   With this try
                        //desktop.open(file);                            @@@   catch thing we can
//                    } catch (IOException ex) {                     @@@   open image directly from
//                        Logger.getLogger(                          @@@   explorer with appointed
//                                Graphics.class.getName()).log(     @@@   file type opener
//                                Level.SEVERE, null, ex             @@@   !Don't delete please
//                        );
//                    }
                        ////////////////////////////////////////////////////////

                    }
                });
            }
        });

        paste_folderImageView.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // create button cursor changer
                paste_folderImageView.setCursor(Cursor.HAND);
                paste_button.setStroke(linearGradient1);
                paste_button.setStrokeWidth(2);
                paste_file_Text.setFill(Color.BLUE);
            }
        });
        ///////////////////////// end of icons onHover listeners /////////////////

        ///////////////////////// text onHover listeners /////////////////////////
        new_file_Text.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // create button cursor changer
                new_file_Text.setCursor(Cursor.HAND);
                create_button.setStroke(linearGradient1);
                create_button.setStrokeWidth(2);
                new_file_Text.setFill(Color.BLUE);
            }
        });

        open_file_Text.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // create button cursor changer
                open_file_Text.setCursor(Cursor.HAND);
                open_button.setStroke(linearGradient1);
                open_button.setStrokeWidth(2);
                open_file_Text.setFill(Color.BLUE);
            }
        });

        open_file_Text.setOnMouseClicked(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // create button cursor changer
                root.getChildren().removeAll(new_file_Text, new_file_imageView, open_file_Text, open_folderImageView, paste_file_Text, paste_folderImageView,
                        first_adv, greetings_firstAdv_header, greetings_firstAdv_main, first_image_with_desc,second_image_with_desc, welcome_text,
                        create_button, open_button, paste_button, tiger_parrot_imageView);
                background.setFill(Color.rgb(180, 183, 181));

                File start_file = fileChooser.showOpenDialog(primaryStage);

                // Image to work with
                Image start_image = new Image(start_file.toURI().toString()); // to URI is full path
                ImageView start_imageView = new ImageView(start_image);

                start_imageView.setFitWidth(1280);
                start_imageView.setFitHeight(720);
                start_imageView.setX(200);
                start_imageView.setY(100);

                ImageView finish_imageView = new ImageView();


                root.getChildren().addAll(start_imageView);

                // rgb_change_button onMouseClicked
                rgb_change_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        // Working with image
                        WritableImage wImage = new WritableImage((int)start_image.getWidth(), (int)start_image.getHeight());
                        PixelWriter pixelWriter = wImage.getPixelWriter();


                        PixelReader pixelReader = start_image.getPixelReader();
                        //start_imageView.setVisible(false);



                        for(int i = 0; i < start_image.getWidth(); i++){
                            for(int j = 0; j < start_image.getHeight(); j++){
                                Color color = pixelReader.getColor(i, j);
                                pixelWriter.setColor(i, j, Color.color(color.getBlue(), color.getRed(), color.getGreen()));
                                //finish_imageView.setImage(wImage);
                            }
                        }

                        finish_imageView.setFitWidth(1280);
                        finish_imageView.setFitHeight(720);
                        finish_imageView.setX(200);
                        finish_imageView.setY(100);
                        root.getChildren().add(finish_imageView);

                        root.getChildren().remove(rgb_change_button);
                        root.getChildren().addAll(old_pic_Text, new_pic_Text, save_jpg_Text, save_jpg_Text, save_png_Text, back_button);

                        // Back button listeners
                        //back_button button onMouseEntered

                        // back_button onMouseClicked
                        back_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                root.getChildren().removeAll(back_button, save_jpg_Text, save_png_Text, start_imageView, finish_imageView, new_pic_Text, old_pic_Text);
                                root.getChildren().addAll(rgb_change_button);
                            }
                        });

                        // save_jpg_Text button onMouseClicked
                        save_jpg_Text.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                try{
                                    ImageIO.write(SwingFXUtils.fromFXImage(wImage, null), "png", new FileOutputStream("image.jpg"));
                                    root.getChildren().removeAll(back_button, save_jpg_Text, save_png_Text, start_imageView, finish_imageView, new_pic_Text, old_pic_Text);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                root.getChildren().addAll(success_popup_top,success_popup_border1, success_popup_border2, success_popup_border3, success_popup_border4);
                                background.setFill(Color.rgb(98,98,98));
                                root.getChildren().addAll(inside_success_popup, success_close_button);

                            }
                        });

                        // save_png_Text button onMouseClicked
                        save_png_Text.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                try{
                                    ImageIO.write(SwingFXUtils.fromFXImage(wImage, null), "png", new FileOutputStream("image.png"));
                                    root.getChildren().removeAll(back_button, save_jpg_Text, save_png_Text, start_imageView, finish_imageView, new_pic_Text, old_pic_Text);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                root.getChildren().addAll(success_popup_top, success_popup_main, success_popup_border1, success_popup_border2, success_popup_border3, success_popup_border4);
                                background.setFill(Color.rgb(98,98,98));
                                root.getChildren().addAll(inside_success_popup, success_close_button);
                            }
                        });

                        /////////////// Mb for future //////////////////////////
                        //try {                                          @@@   With this try
                        //desktop.open(file);                            @@@   catch thing we can
//                    } catch (IOException ex) {                     @@@   open image directly from
//                        Logger.getLogger(                          @@@   explorer with appointed
//                                Graphics.class.getName()).log(     @@@   file type opener
//                                Level.SEVERE, null, ex             @@@   !Don't delete please
//                        );
//                    }
                        ////////////////////////////////////////////////////////

                    }
                });
            }
        });

        paste_file_Text.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // create button cursor changer
                paste_file_Text.setCursor(Cursor.HAND);
                paste_button.setStroke(linearGradient1);
                paste_button.setStrokeWidth(2);
                paste_file_Text.setFill(Color.BLUE);
            }
        });
        ///////////////////////// end of Text onHover /////////////////////////////

        ///////////////////////// create button listeners /////////////////////////
        // create_button onMouseIn
        create_button.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // create button cursor changer
                create_button.setCursor(Cursor.HAND);
                create_button.setStroke(linearGradient1);
                create_button.setStrokeWidth(2);
                new_file_Text.setFill(Color.BLUE);
            }
        });

        // create_button onMouseOut
        create_button.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                create_button.setStroke(Color.WHITE);
                new_file_Text.setFill(Color.GREY);
            }
        });

        // create_button onMouseClicked
        create_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //background.setFill(Color.rgb(98, 98, 98));
                //root.getChildren().add(rgb_change_button);
            }
        });
        ///////////////////////// create button listeners /////////////////////////

        ////////////////////////////// open button listeners ///////////////////////////
        // open_button onMouseIn
        open_button.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // open_button cursor changer
                open_button.setCursor(Cursor.HAND);
                open_button.setStroke(linearGradient1);
                open_button.setStrokeWidth(2);
                open_file_Text.setFill(Color.BLUE);
            }
        });

        // open_button onMouseOut
        open_button.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                open_button.setStroke(Color.WHITE);
                open_file_Text.setFill(Color.GREY);
            }
        });

        // open_button onMouseClicked
        open_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {

                Integer red = 255;
                Integer green = 255;
                Integer blue = 255;

                // create button cursor changer
                root.getChildren().removeAll(new_file_Text, new_file_imageView, open_file_Text, open_folderImageView, paste_file_Text, paste_folderImageView,
                        first_adv, greetings_firstAdv_header, greetings_firstAdv_main, first_image_with_desc, second_image_with_desc, welcome_text,
                        create_button, open_button, paste_button, tiger_parrot_imageView);

                background.setFill(Color.rgb(180, 183, 181));

                File start_file = fileChooser.showOpenDialog(primaryStage);

                // Image to work with
                Image start_image = new Image(start_file.toURI().toString()); // to URI is full path
                ImageView start_imageView = new ImageView(start_image);

                start_imageView.setFitWidth(1280);
                start_imageView.setFitHeight(720);
                start_imageView.setX(200);
                start_imageView.setY(100);

                ImageView finish_imageView = new ImageView();


                root.getChildren().addAll(start_imageView, main_header, header_menu_rect, field_for_features,
                        header_menu_iconView, header_icon_text, setting_logoView,
                        navbar_brushesRect, navbar_brushesIconView, navbar_brushesIconText,
                        navbar_shapesRect, navbar_shapesIconView, navbar_shapesIconText,
                        navbar_stickersRect, navbar_stickersIconView, navbar_stickersIconText,
                        navbar_textRect, navbar_textIconView, navbar_textIconText);


                root.getChildren().addAll(slider_redText, slider_greenText, slider_blueText, slider_red, slider_green, slider_blue);
                // Working with image
                WritableImage wImage = new WritableImage((int)start_image.getWidth(), (int)start_image.getHeight());
                PixelWriter pixelWriter = wImage.getPixelWriter();


                PixelReader pixelReader = start_image.getPixelReader();


                finish_imageView.setFitWidth(1280);
                finish_imageView.setFitHeight(720);
                finish_imageView.setX(200);
                finish_imageView.setY(100);
//                        root.getChildren().add(finish_imageView);
//
//                        for(int i = 0; i < start_image.getWidth(); i++){
//                            for(int j = 0; j < start_image.getHeight(); j++){
//                                Color color = pixelReader.getColor(i, j);
//                                pixelWriter.setColor(i, j, Color.color(color.getRed(), 0, 0));
//                            }
//                        }
//
//                        finish_imageView.setImage(wImage);

                root.getChildren().addAll(save_jpg_Text, save_png_Text, back_button);

                Timeline oneSecTimer = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        for(int i = 0; i < start_image.getWidth(); i++){
                            for(int j = 0; j < start_image.getHeight(); j++){
                                Color color = pixelReader.getColor(i, j);
                                pixelWriter.setColor(i, j, Color.color(color.getRed() * slider_red.valueProperty().doubleValue() / 100,
                                        color.getGreen() * slider_green.valueProperty().doubleValue() / 100,
                                        color.getBlue() * slider_blue.valueProperty().doubleValue() / 100));
                            }
                        }
                        start_imageView.setImage(wImage);
                    }
                }));
                oneSecTimer.setCycleCount(Timeline.INDEFINITE);

                navbar_brushesIconView.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        navbar_brushesIconView.setCursor(Cursor.HAND);
                    }
                });

                navbar_brushesIconView.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {

                    }
                });

                navbar_brushesIconView.setOnMouseClicked(new EventHandler<MouseEvent>
                        () {


                    @Override
                    public void handle(MouseEvent t) {

                        root.getChildren().removeAll(slider_blue,slider_blueText,slider_green,slider_greenText, slider_red, slider_redText);
                        root.getChildren().addAll(btn1, btn2, slider_thicknessText, slider_thickness, thicknessText, btn3, colorPicker);


                    }
                });

                btn1.setOnMouseClicked(new EventHandler<MouseEvent>
                        () {


                    @Override
                    public void handle(MouseEvent t) {

                        start_imageView.setCursor(Cursor.CROSSHAIR);

                        start_imageView.setOnMouseReleased(new EventHandler<MouseEvent>
                                () {
                            @Override
                            public void handle(MouseEvent t) {

                                System.out.println(true);

                                start_imageView.setCursor(Cursor.DEFAULT);

                                start_imageView.setOnMouseMoved(new EventHandler<MouseEvent>
                                        () {


                                    @Override
                                    public void handle(MouseEvent t) {
                                        start_imageView.setCursor(Cursor.CROSSHAIR);


                                        double PI = 3.1415926535;
                                        double i, angle, x1, y1;

                                        for(i = 0; i < 360; i += 1)
                                        {
                                            angle = i;
                                            x1 = slider_thickness.valueProperty().intValue() * cos(angle * PI / 180);
                                            y1 = slider_thickness.valueProperty().intValue() * sin(angle * PI / 180);
                                            pixelWriter.setColor((int)((int)(((int) t.getX() - 200) * 1.5) + x1),
                                                    (int)((int)(((int) t.getY() - 100) * 1.5) + y1),
                                                    colorPicker.getValue());
                                        }

//                                        for(int i = -5; i < 5; i++){
//                                            for(int j = -5; j < 5; j++) {
//                                                pixelWriter.setColor((int)(((int) t.getX() - 200) * 1.5)  + i,
//                                                        (int)(((int) t.getY() - 100) * 1.5) + j,
//                                                        Color.BLUE);
//                                            }
//                                        }
                                        start_imageView.setImage(wImage);

                                    }
                                });

                                double PI = 3.1415926535;
                                double i, angle, x1, y1;

                                for(i = 0; i < 360; i += 1.0001)
                                {
                                    angle = i;
                                    x1 = slider_thickness.valueProperty().intValue() * cos(angle * PI / 180);
                                    y1 = slider_thickness.valueProperty().intValue() * sin(angle * PI / 180);
                                    pixelWriter.setColor((int)((( t.getX() - 200) * 1.5) + x1),
                                            (int)((( t.getY() - 100) * 1.5) + y1),
                                            colorPicker.getValue());
                                }
                                start_imageView.setImage(wImage);

                            }
                        });

                        start_imageView.setOnMousePressed(new EventHandler<MouseEvent>
                                () {


                            @Override
                            public void handle(MouseEvent t) {
                                System.out.println(false);
                                start_imageView.setCursor(Cursor.DEFAULT);

                            }
                        });


                    }
                });

                btn2.setOnMouseClicked(new EventHandler<MouseEvent>
                        () {


                    @Override
                    public void handle(MouseEvent t) {

                        start_imageView.setCursor(Cursor.CROSSHAIR);

                        start_imageView.setOnMouseReleased(new EventHandler<MouseEvent>
                                () {
                            @Override
                            public void handle(MouseEvent t) {

                                System.out.println(true);

                                start_imageView.setCursor(Cursor.DEFAULT);

                                start_imageView.setOnMouseMoved(new EventHandler<MouseEvent>
                                        () {


                                    @Override
                                    public void handle(MouseEvent t) {
                                        start_imageView.setCursor(Cursor.CROSSHAIR);



                                        for(int i = -slider_thickness.valueProperty().intValue(); i < slider_thickness.valueProperty().intValue(); i++){
                                            for(int j = -slider_thickness.valueProperty().intValue(); j < slider_thickness.valueProperty().intValue(); j++) {
                                                pixelWriter.setColor((int)(((int) t.getX() - 200) * 1.5)  + i,
                                                        (int)(((int) t.getY() - 100) * 1.5) + j,
                                                        colorPicker.getValue());
                                            }
                                        }
                                        start_imageView.setImage(wImage);

                                    }
                                });

                                for(int i = -slider_thickness.valueProperty().intValue(); i < slider_thickness.valueProperty().intValue(); i++){
                                    for(int j = -slider_thickness.valueProperty().intValue(); j < slider_thickness.valueProperty().intValue(); j++) {
                                        pixelWriter.setColor((int)(((int) t.getX() - 200) * 1.5)  + i,
                                                (int)(((int) t.getY() - 100) * 1.5) + j,
                                                colorPicker.getValue());
                                    }
                                }
                                start_imageView.setImage(wImage);

                            }
                        });

                        start_imageView.setOnMousePressed(new EventHandler<MouseEvent>
                                () {


                            @Override
                            public void handle(MouseEvent t) {
                                System.out.println(false);
                                start_imageView.setCursor(Cursor.DEFAULT);

                            }
                        });


                    }
                });

                navbar_shapesIconView.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        navbar_shapesIconView.setCursor(Cursor.HAND);
                    }
                });

                navbar_shapesIconView.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {

                    }
                });

                navbar_shapesIconView.setOnMouseClicked(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        root.getChildren().removeAll(btn1, btn2);
                        root.getChildren().addAll(slider_blue,slider_blueText,slider_green,slider_greenText, slider_red, slider_redText);
                    }
                });

                slider_red.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        oneSecTimer.play();
                    }
                });
                slider_red.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        oneSecTimer.stop();
                    }
                });

                slider_green.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        oneSecTimer.play();
                    }
                });
                slider_green.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        oneSecTimer.stop();
                    }
                });

                slider_blue.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        oneSecTimer.play();
                    }
                });
                slider_blue.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        oneSecTimer.stop();
                    }
                });
//                Button tmp_button = new Button("Rect");
//                root.getChildren().add(tmp_button);
//                // draw smth on photo using canvas
                javafx.scene.canvas.Canvas canvas = new Canvas(1580, 820); // 300 + 1280 and 100 + 720 !!!
//                GraphicsContext gc = canvas.getGraphicsContext2D();
//                gc.setLineWidth(2.0);
//                // Set fill color
//                gc.setFill(Color.RED);
//                // Draw a rounded Rectangle
//                gc.fillRoundRect(310, 110, 200, 200, 10, 10);
//
//                canvas.snapshot(null, wImage);
//                //root.getChildren().add(canvas);
//
//                tmp_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
//                    @Override
//                    public void handle(MouseEvent event) {
//                        root.getChildren().add(canvas);
//                    }
//                });
//
//
//                // end of canvas
                // Back button listeners
                //back_button button onMouseEntered

                // back_button onMouseClicked
                back_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        oneSecTimer.stop();
                        root.getChildren().removeAll(canvas, back_button, save_jpg_Text, save_png_Text,start_imageView,
                                finish_imageView, slider_red, slider_green, slider_blue, slider_redText, slider_greenText,
                                slider_blueText, header_menu_iconView, header_menu_rect, header_icon_text, main_header,
                                navbar_brushesRect, navbar_brushesIconView, navbar_brushesIconText,
                                navbar_shapesRect, navbar_shapesIconView, navbar_shapesIconText,
                                navbar_stickersRect, navbar_stickersIconView, navbar_stickersIconText,
                                navbar_textRect, navbar_textIconView, navbar_textIconText, field_for_features);
                        root.getChildren().addAll(welcome_text, create_button, open_button, paste_button, new_file_imageView,
                                new_file_Text, open_file_Text, paste_file_Text, open_folderImageView, paste_folderImageView,
                                first_adv, second_image_with_desc, greetings_firstAdv_header, greetings_firstAdv_main,
                                tiger_parrot_imageView, first_image_with_desc);
                    }
                });

                // save_jpg_Text button onMouseClicked
                save_jpg_Text.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        try{
                            ImageIO.write(SwingFXUtils.fromFXImage(wImage, null), "png", new FileOutputStream("image.jpg"));
                            root.getChildren().removeAll(canvas, back_button, save_jpg_Text, save_png_Text,start_imageView,
                                    finish_imageView, slider_red, slider_green, slider_blue, slider_redText, slider_greenText,
                                    slider_blueText, header_menu_iconView, header_menu_rect, header_icon_text, main_header,
                                    navbar_brushesRect, navbar_brushesIconView, navbar_brushesIconText,
                                    navbar_shapesRect, navbar_shapesIconView, navbar_shapesIconText,
                                    navbar_stickersRect, navbar_stickersIconView, navbar_stickersIconText,
                                    navbar_textRect, navbar_textIconView, navbar_textIconText, field_for_features);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        oneSecTimer.stop();
                        root.getChildren().addAll(success_popup_top,success_popup_border1, success_popup_border2, success_popup_border3, success_popup_border4);
                        background.setFill(Color.rgb(98,98,98));
                        root.getChildren().addAll(inside_success_popup, success_close_button);

                    }
                });

                // save_png_Text button onMouseClicked
                save_png_Text.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        try{
                            ImageIO.write(SwingFXUtils.fromFXImage(wImage, null), "png", new FileOutputStream("image.png"));
                            root.getChildren().removeAll(canvas, back_button, save_jpg_Text, save_png_Text,start_imageView,
                                    finish_imageView, slider_red, slider_green, slider_blue, slider_redText, slider_greenText,
                                    slider_blueText, header_menu_iconView, header_menu_rect, header_icon_text, main_header,
                                    navbar_brushesRect, navbar_brushesIconView, navbar_brushesIconText,
                                    navbar_shapesRect, navbar_shapesIconView, navbar_shapesIconText,
                                    navbar_stickersRect, navbar_stickersIconView, navbar_stickersIconText,
                                    navbar_textRect, navbar_textIconView, navbar_textIconText, field_for_features);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        oneSecTimer.stop();
                        root.getChildren().addAll(success_popup_top, success_popup_main, success_popup_border1, success_popup_border2, success_popup_border3, success_popup_border4);
                        background.setFill(Color.rgb(98,98,98));
                        root.getChildren().addAll(inside_success_popup, success_close_button);
                    }
                });

                /////////////// Mb for future //////////////////////////
                //try {                                          @@@   With this try
                //desktop.open(file);                            @@@   catch thing we can
//                    } catch (IOException ex) {                     @@@   open image directly from
//                        Logger.getLogger(                          @@@   explorer with appointed
//                                Graphics.class.getName()).log(     @@@   file type opener
//                                Level.SEVERE, null, ex             @@@   !Don't delete please
//                        );
//                    }
                ////////////////////////////////////////////////////////

            }
        });
        ////////////////////////////// open button listeners end ///////////////////////////

        ////////////////////////////// paste button listeners start ////////////////////////

        // paste_button onMouseIn
        paste_button.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // paste_button cursor changer
                paste_button.setCursor(Cursor.HAND);
                paste_button.setStroke(linearGradient1);
                paste_button.setStrokeWidth(2);
                paste_file_Text.setFill(Color.BLUE);
            }
        });

        // paste_button onMouseOut
        paste_button.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                paste_button.setStroke(Color.WHITE);
                paste_file_Text.setFill(Color.GREY);
            }
        });

        // paste_button onMouseClicked
        paste_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //background.setFill(Color.rgb(98, 98, 98));
            }
        });

        //success_close_button onMouseExited
        success_close_button.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                success_close_button.setFill(Color.rgb(38,40,42));
            }
        });

        // success_close_button onMouseClicked
        success_close_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                background.setFill(Color.rgb(227,225,228));
                root.getChildren().removeAll(success_close_button, inside_success_popup, success_popup_border1, success_popup_border2,
                        success_popup_border3, success_popup_border4, success_popup_main, success_popup_top);
                root.getChildren().addAll(welcome_text, create_button, open_button, paste_button, new_file_imageView,
                        new_file_Text, open_file_Text, paste_file_Text, open_folderImageView, paste_folderImageView,
                        first_adv, second_image_with_desc, greetings_firstAdv_header, greetings_firstAdv_main,
                        tiger_parrot_imageView, first_image_with_desc);
            }
        });

        //success close button onMouseEntered
        success_close_button.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // success_close_button cursor changer
                success_close_button.setStyle("-fx-cursor: hand");
                FillTransition fillTransition = new FillTransition(Duration.seconds(0.01), success_close_button);
                fillTransition.setFromValue(Color.rgb(38,40,42));
                fillTransition.setToValue(Color.rgb(214, 96, 148));
                fillTransition.setAutoReverse(true);
                fillTransition.play();

            }
        });

        primaryStage.setMaximized(true);
        primaryStage.getIcons().add(new Image("file:First Project/pics/agreement.png"));
        primaryStage.setTitle("KN-106 Teamwork Project");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
