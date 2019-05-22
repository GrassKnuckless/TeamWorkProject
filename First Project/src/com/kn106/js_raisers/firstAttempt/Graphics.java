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
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import static java.lang.Integer.parseInt;
import static java.lang.Math.cos;
import static java.lang.Math.sin;


public class Graphics extends Application {
    public Desktop desktop = Desktop.getDesktop();

    boolean fill = true;

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
        background.setFill(Color.web("#B4B7B5"));
        root.getChildren().add(background);

        // header of main
        Rectangle main_header = new Rectangle(0,0,1920, 50);
        main_header.setFill(Color.rgb(63,66,73));


        ///////////////////////////////  Start menu ///////////////////////////////////////////////
        // Welcome text
        Text welcome_text = new Text(510, 278, "Welcome");
        welcome_text.setFont(Font.font ("Dubai Light", 60));
        welcome_text.setFill(Color.WHITE);
        root.getChildren().add(welcome_text);

        // start functionality panel


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
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        Text old_pic_Text = new Text(500, 270,"Old");
        old_pic_Text.setFill(Color.rgb(53,56,58));
        old_pic_Text.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 30));

        Text new_pic_Text = new Text(1320, 270,"New");
        new_pic_Text.setFill(Color.rgb(53,56,58));
        new_pic_Text.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 30));

        // Save jpg
        Text save_jpg_Text = new Text(1759, 900,"Save .jpg");
        save_jpg_Text.setFill(Color.web("#78797A"));
        save_jpg_Text.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 20));

        // Save png
        Text save_png_Text = new Text(1756, 930,"Save .png");
        save_png_Text.setFill(Color.web("#78797A"));
        save_png_Text.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 20));

        // 🡐 Back button
        Text back_button = new Text(10, 35,"\uD83E\uDC50 Back");
        back_button.setFill(Color.WHITE);
        back_button.setFont(Font.font ("Arial", FontWeight.THIN, 25));

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
        success_close_button.setFill(Color.web("#78797A"));

        Text inside_success_popup = new Text(750, 500, "Successfully saved");
        inside_success_popup.setFill(Color.web("#78797A"));
        inside_success_popup.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 45));

        // rgb change slider RED
        Text slider_redText = new Text(1730, 81, "Red: ");
        slider_redText.setFont(Font.font ("Dubai", FontWeight.BOLD, 14));
        slider_redText.setFill(Color.web("#78797A"));

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
        slider_red.setLayoutX(1770);
        slider_red.setLayoutY(70);

        // rgb change slider Green
        Text slider_greenText = new Text(1730, 101, "Green: ");
        slider_greenText.setFont(Font.font ("Dubai", FontWeight.BOLD, 14));
        slider_greenText.setFill(Color.web("#78797A"));

        Slider slider_green = new Slider();
        slider_green.setMin(0);
        slider_green.setMax(100);
        slider_green.setValue(100);
        slider_green.setMaxWidth(100);
        slider_green.setLayoutX(1770);
        slider_green.setLayoutY(90);

        // rgb change slider BLUE
        Text slider_blueText = new Text(1730, 121, "Blue: ");
        slider_blueText.setFont(Font.font ("Dubai", FontWeight.BOLD, 14));
        slider_blueText.setFill(Color.web("#78797A"));

        Slider slider_blue = new Slider();
        slider_blue.setMin(0);
        slider_blue.setMax(100);
        slider_blue.setValue(100);
        slider_blue.setMaxWidth(100);
        slider_blue.setLayoutX(1770);
        slider_blue.setLayoutY(110);

        // slider for thickness
        Text slider_thicknessText = new Text(1720, 85, "Thickness: ");
        slider_thicknessText.setFont(Font.font ("Dubai", FontWeight.BOLD, 15));
        slider_thicknessText.setFill(Color.web("#78797A"));

        Slider slider_thickness = new Slider();
        slider_thickness.setMin(0);
        slider_thickness.setMax(100);
        slider_thickness.setValue(100);
        slider_thickness.setMaxWidth(100);
        slider_thickness.setLayoutX(1785);
        slider_thickness.setLayoutY(75);

        Text thicknessText = new Text(1745, 115, "Value: 100px");
        thicknessText.setFont(Font.font ("Dubai", FontWeight.BOLD, 20));
        thicknessText.setFill(Color.web("#78797A"));

        Text brightnessText = new Text(1745, 200, "Value: 100%");
        brightnessText.setFont(Font.font ("Dubai", FontWeight.BOLD, 20));
        brightnessText.setFill(Color.web("#78797A"));

        // slider for thickness
        Text slider_brightnessText = new Text(1710, 170, "Brightness: ");
        slider_brightnessText.setFont(Font.font ("Dubai", FontWeight.BOLD, 15));
        slider_brightnessText.setFill(Color.web("#78797A"));

        Line line_on_top_of_brightness = new Line(1676, 140, 1920, 140);
        line_on_top_of_brightness.setStrokeWidth(1);
        line_on_top_of_brightness.setStroke(Color.BLACK);

        Line line_under_brightness = new Line(1676, 225, 1920, 225);
        line_under_brightness.setStrokeWidth(1);
        line_under_brightness.setStroke(Color.BLACK);

        Line line_shapes_1 = new Line(1676, 138, 1920, 138);
        line_shapes_1.setStrokeWidth(1);
        line_shapes_1.setStroke(Color.BLACK);

        Line line_shapes_2 = new Line(1676, 202, 1920, 202);
        line_shapes_2.setStrokeWidth(1);
        line_shapes_2.setStroke(Color.BLACK);

        Line line_shapes_3 = new Line(1676, 352, 1920, 352);
        line_shapes_3.setStrokeWidth(1);
        line_shapes_3.setStroke(Color.BLACK);

        Line line_shapes_4 = new Line(1676, 409, 1920, 409);
        line_shapes_4.setStrokeWidth(1);
        line_shapes_4.setStroke(Color.BLACK);

        Line line_shapes_5 = new Line(1676, 466, 1920, 466);
        line_shapes_5.setStrokeWidth(1);
        line_shapes_5.setStroke(Color.BLACK);

        Line line_shapes_new1 = new Line(1676, 473, 1920, 473);
        line_shapes_new1.setStrokeWidth(1);
        line_shapes_new1.setStroke(Color.BLACK);



        Line line3 = new Line(1676, 550, 1920, 550);
        line3.setStrokeWidth(1);
        line3.setStroke(Color.BLACK);

        Line line4 = new Line(1676, 609, 1920, 609);
        line4.setStrokeWidth(1);
        line4.setStroke(Color.BLACK);

        Line line10 = new Line(1676, 530, 1920, 530);
        line10.setStrokeWidth(1);
        line10.setStroke(Color.BLACK);


        Slider slider_brightness = new Slider();
        slider_brightness.setMin(0);
        slider_brightness.setMax(100);
        slider_brightness.setValue(100);
        slider_brightness.setMaxWidth(100);
        slider_brightness.setLayoutX(1785);
        slider_brightness.setLayoutY(160);

        slider_thickness.valueProperty().addListener((observable, oldValue, newValue) -> {

            thicknessText.setText("Value: " + Integer.toString(newValue.intValue()) + "px");

        });

        slider_brightness.valueProperty().addListener((observable, oldValue, newValue) -> {

            brightnessText.setText("Value: " + Integer.toString(newValue.intValue()) + "%");

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

        Text text_hint = new Text(1705, 100,"Choose function from\n         navigation bar");
        text_hint.setFont(Font.font ("Dubai", FontWeight.BOLD, 20));
        text_hint.setFill(Color.web("#78797A"));

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
        Text navbar_stickersIconText = new Text(894, 43, "Effects");
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
        field_for_features.setFill(Color.web("#F0F2F3"));

        Button btn1 = new Button("Circle");
        Button btn_star = new Button("Star");
        Button btn_def = new Button("Default");
        Button btn2 = new Button("Square");
        Button btn3 = new Button("Sort Pixels By Hue");
        Button btn4 = new Button("Sort Pixels By Saturation");
        Button btn_red = new Button("Sort Pixels By Red");
        Button btn_green = new Button("Sort Pixels By Green");
        Button btn_blue = new Button("Sort Pixels By Blue");
        Button btn_brith = new Button("Sort Pixels By Brightness");
        Button btn_fill = new Button("Fill / Stroke");
        btn_fill.setLayoutY(156);
        btn_fill.setLayoutX(1756);

        btn1.setStyle(
                "-fx-border-color: #78797A; "
                        + "-fx-text-fill: #78797A;"
                        + "-fx-background-color: white;"
                        + "-fx-font-weight: 700;"
                        + "-fx-font-size: 12px;"
                        + "-fx-border-radius: 2;"
                        + "-fx-border-style: solid;"
                        + "-fx-border-width: 2;"
        );

        btn_star.setStyle(
                "-fx-border-color: #78797A; "
                        + "-fx-text-fill: #78797A;"
                        + "-fx-background-color: white;"
                        + "-fx-font-weight: 700;"
                        + "-fx-font-size: 12px;"
                        + "-fx-border-radius: 2;"
                        + "-fx-border-style: solid;"
                        + "-fx-border-width: 2;"
        );

        btn_def.setStyle(
                "-fx-border-color: #78797A; "
                        + "-fx-text-fill: #78797A;"
                        + "-fx-background-color: white;"
                        + "-fx-font-weight: 700;"
                        + "-fx-font-size: 12px;"
                        + "-fx-border-radius: 2;"
                        + "-fx-border-style: solid;"
                        + "-fx-border-width: 2;"
        );

        btn2.setStyle(
                "-fx-border-color: #78797A; "
                        + "-fx-text-fill: #78797A;"
                        + "-fx-background-color: white;"
                        + "-fx-font-weight: 700;"
                        + "-fx-font-size: 12px;"
                        + "-fx-border-radius: 2;"
                        + "-fx-border-style: solid;"
                        + "-fx-border-width: 2;"
        );

        btn_fill.setStyle(
                "-fx-border-color: #78797A; "
                        + "-fx-text-fill: #78797A;"
                        + "-fx-background-color: white;"
                        + "-fx-font-weight: 700;"
                        + "-fx-font-size: 12px;"
                        + "-fx-border-radius: 2;"
                        + "-fx-border-style: solid;"
                        + "-fx-border-width: 2;"
        );

        Button btn4_clear = new Button("Clear");

        btn1.setLayoutY(220);
        btn1.setLayoutX(1773);

        btn_star.setLayoutY(306);
        btn_star.setLayoutX(1777);

        btn_def.setLayoutY(366);
        btn_def.setLayoutX(1768);


        btn1.setStyle(
                "-fx-border-color: #78797A; "
                        + "-fx-text-fill: #78797A;"
                        + "-fx-background-color: white;"
                        + "-fx-font-weight: 700;"
                        + "-fx-font-size: 12px;"
                        + "-fx-border-radius: 2;"
                        + "-fx-border-style: solid;"
                        + "-fx-border-width: 2;"
        );

        btn2.setLayoutY(262);
        btn2.setLayoutX(1769);

        btn2.setStyle(
                "-fx-border-color: #78797A; "
                        + "-fx-text-fill: #78797A;"
                        + "-fx-background-color: white;"
                        + "-fx-font-weight: 700;"
                        + "-fx-font-size: 12px;"
                        + "-fx-border-radius: 2;"
                        + "-fx-border-style: solid;"
                        + "-fx-border-width: 2;"
        );

        btn3.setLayoutY(250);
        btn3.setLayoutX(1738);

        btn3.setStyle(
                "-fx-border-color: #78797A; "
                        + "-fx-text-fill: #78797A;"
                        + "-fx-background-color: white;"
                        + "-fx-font-weight: 700;"
                        + "-fx-font-size: 12px;"
                        + "-fx-border-radius: 2;"
                        + "-fx-border-style: solid;"
                        + "-fx-border-width: 2;"
        );

        btn4.setLayoutY(300);
        btn4.setLayoutX(1723);

        btn4.setStyle(
                "-fx-border-color: #78797A; "
                        + "-fx-text-fill: #78797A;"
                        + "-fx-background-color: white;"
                        + "-fx-font-weight: 700;"
                        + "-fx-font-size: 12px;"
                        + "-fx-border-radius: 2;"
                        + "-fx-border-style: solid;"
                        + "-fx-border-width: 2;"
        );

        btn_red.setLayoutY(350);
        btn_red.setLayoutX(1738);

        btn_red.setStyle(
                "-fx-border-color: #78797A; "
                        + "-fx-text-fill: #78797A;"
                        + "-fx-background-color: white;"
                        + "-fx-font-weight: 700;"
                        + "-fx-font-size: 12px;"
                        + "-fx-border-radius: 2;"
                        + "-fx-border-style: solid;"
                        + "-fx-border-width: 2;"
        );

        btn_green.setLayoutY(400);
        btn_green.setLayoutX(1734);

        btn_green.setStyle(
                "-fx-border-color: #78797A; "
                        + "-fx-text-fill: #78797A;"
                        + "-fx-background-color: white;"
                        + "-fx-font-weight: 700;"
                        + "-fx-font-size: 12px;"
                        + "-fx-border-radius: 2;"
                        + "-fx-border-style: solid;"
                        + "-fx-border-width: 2;"
        );

        btn_blue.setLayoutY(450);
        btn_blue.setLayoutX(1738);

        btn_blue.setStyle(
                "-fx-border-color: #78797A; "
                        + "-fx-text-fill: #78797A;"
                        + "-fx-background-color: white;"
                        + "-fx-font-weight: 700;"
                        + "-fx-font-size: 12px;"
                        + "-fx-border-radius: 2;"
                        + "-fx-border-style: solid;"
                        + "-fx-border-width: 2;"
        );

        btn_brith.setLayoutY(500);
        btn_brith.setLayoutX(1723);

        btn_brith.setStyle(
                "-fx-border-color: #78797A; "
                        + "-fx-text-fill: #78797A;"
                        + "-fx-background-color: white;"
                        + "-fx-font-weight: 700;"
                        + "-fx-font-size: 12px;"
                        + "-fx-border-radius: 2;"
                        + "-fx-border-style: solid;"
                        + "-fx-border-width: 2;"
        );

        btn4_clear.setLayoutY(421);
        btn4_clear.setLayoutX(1776);

        btn4_clear.setStyle(
                "-fx-border-color: #78797A; "
                        + "-fx-text-fill: #78797A;"
                        + "-fx-background-color: white;"
                        + "-fx-font-weight: 700;"
                        + "-fx-font-size: 12px;"
                        + "-fx-border-radius: 2;"
                        + "-fx-border-style: solid;"
                        + "-fx-border-width: 2;"
        );

        Canvas canvas = new Canvas(1500, 844);
        canvas.setLayoutX(87);
        canvas.setLayoutY(110);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.CORAL);

        colorPicker.setLayoutX(1738);
        colorPicker.setLayoutY(650);

        colorPicker.setStyle(
                "-fx-border-color: #78797A; "
                        + "-fx-text-fill: #78797A;"
                        + "-fx-background-color: white;"
                        + "-fx-font-weight: 700;"
                        + "-fx-font-size: 12px;"
                        + "-fx-border-radius: 2;"
                        + "-fx-border-style: solid;"
                        + "-fx-border-width: 2;"
        );

        navbar_stickersIconView.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                navbar_stickersIconView.setCursor(Cursor.HAND);
                navbar_stickersIconText.setFill(Color.web("#0064B6"));
            }
        });

        navbar_stickersIconView.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                navbar_stickersIconText.setFill(Color.WHITE);
            }
        });

        navbar_textIconView.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                navbar_textIconView.setCursor(Cursor.HAND);
                navbar_textIconText.setFill(Color.web("#0064B6"));
            }
        });

        navbar_textIconView.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                navbar_textIconText.setFill(Color.WHITE);
            }
        });


        // one
        navbar_brushesIconView.setOnMouseClicked(new EventHandler<MouseEvent>
                () {


            @Override
            public void handle(MouseEvent t) {

                colorPicker.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_5.setStroke(Color.web("#0064B6"));
                        line10.setStroke(Color.web("#0064B6"));
                        colorPicker.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                colorPicker.setOnMouseExited(new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_5.setStroke(Color.BLACK);
                        line10.setStroke(Color.BLACK);
                        colorPicker.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                btn4_clear.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_4.setStroke(Color.web("#0064B6"));
                        line_shapes_5.setStroke(Color.web("#0064B6"));
                        btn4_clear.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                btn4_clear.setOnMouseExited(new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_4.setStroke(Color.BLACK);
                        line_shapes_5.setStroke(Color.BLACK);
                        btn4_clear.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                btn4_clear.setLayoutY(423);
                colorPicker.setLayoutY(485);

                field_for_features.setVisible(true);
                line_on_top_of_brightness.setVisible(false);
                line_under_brightness.setVisible(false);
                line_shapes_1.setVisible(true);
                line_shapes_2.setVisible(true);
                line_shapes_3.setVisible(true);
                line_shapes_4.setVisible(true);
                line_shapes_5.setVisible(true);
                line_shapes_new1.setVisible(false);
                line3.setVisible(false);
                line4.setVisible(false);
                line10.setVisible(true);
                btn_fill.setVisible(true);
                brightnessText.setVisible(false);
                slider_brightness.setVisible(false);
                slider_brightnessText.setVisible(false);
                slider_red.setVisible(false);
                slider_redText.setVisible(false);
                slider_green.setVisible(false);
                slider_greenText.setVisible(false);
                slider_blue.setVisible(false);
                slider_blueText.setVisible(false);
                btn1.setVisible(true);
                btn_star.setVisible(true);
                btn_def.setVisible(true);
                btn2.setVisible(true);
                btn3.setVisible(false);
                btn4.setVisible(false);
                btn4_clear.setVisible(true);
                text_hint.setVisible(false);
                btn_red.setVisible(false);
                btn_green.setVisible(false);
                btn_blue.setVisible(false);
                btn_brith.setVisible(false);
                thicknessText.setVisible(true);
                slider_thickness.setVisible(true);
                slider_thicknessText.setVisible(true);
                colorPicker.setVisible(true);
                save_png_Text.setVisible(true);
                save_jpg_Text.setVisible(true);
            }
        });


        // two
        navbar_shapesIconView.setOnMouseClicked(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                colorPicker.setLayoutY(426);

                colorPicker.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_4.setStroke(Color.web("#0064B6"));
                        line_shapes_new1.setStroke(Color.web("#0064B6"));
                        colorPicker.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                colorPicker.setOnMouseExited(new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_4.setStroke(Color.BLACK);
                        line_shapes_new1.setStroke(Color.BLACK);
                        colorPicker.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                btn4_clear.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_3.setStroke(Color.web("#0064B6"));
                        line_shapes_4.setStroke(Color.web("#0064B6"));
                        btn4_clear.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                btn4_clear.setOnMouseExited(new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_3.setStroke(Color.BLACK);
                        line_shapes_4.setStroke(Color.BLACK);
                        btn4_clear.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                btn4_clear.setLayoutY(367);

                field_for_features.setVisible(true);
                line_on_top_of_brightness.setVisible(false);
                line_under_brightness.setVisible(false);
                line_shapes_1.setVisible(true);
                line_shapes_2.setVisible(true);
                line_shapes_3.setVisible(true);
                line_shapes_4.setVisible(true);
                line_shapes_5.setVisible(false);
                line_shapes_new1.setVisible(true);
                line3.setVisible(false);
                line4.setVisible(false);
                line10.setVisible(false);
                btn_fill.setVisible(true);
                brightnessText.setVisible(false);
                slider_brightness.setVisible(false);
                slider_brightnessText.setVisible(false);
                slider_redText.setVisible(false);
                slider_greenText.setVisible(false);
                slider_blueText.setVisible(false);
                slider_red.setVisible(false);
                slider_green.setVisible(false);
                slider_blue.setVisible(false);
                btn_red.setVisible(false);
                btn_green.setVisible(false);
                btn_blue.setVisible(false);
                btn_brith.setVisible(false);
                btn1.setVisible(true);
                btn_star.setVisible(true);
                btn_def.setVisible(false);
                btn2.setVisible(true);
                btn3.setVisible(false);
                btn4.setVisible(false);
                btn4_clear.setVisible(true);
                text_hint.setVisible(false);
                thicknessText.setVisible(true);
                slider_thickness.setVisible(true);
                slider_thicknessText.setVisible(true);
                colorPicker.setVisible(true);
                save_png_Text.setVisible(true);
                save_jpg_Text.setVisible(true);

            }
        });


        // three
        navbar_stickersIconView.setOnMouseClicked(new EventHandler<MouseEvent>
                () {
            @Override
            public void handle(MouseEvent t) {

                btn4_clear.setLayoutY(565);

                btn4_clear.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line3.setStroke(Color.web("#0064B6"));
                        line4.setStroke(Color.web("#0064B6"));
                        btn4_clear.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                btn4_clear.setOnMouseExited(new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent t) {
                        line3.setStroke(Color.BLACK);
                        line4.setStroke(Color.BLACK);
                        btn4_clear.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                field_for_features.setVisible(true);
                line_on_top_of_brightness.setVisible(true);
                line_under_brightness.setVisible(true);
                line_shapes_1.setVisible(false);
                line_shapes_2.setVisible(false);
                line_shapes_3.setVisible(false);
                line_shapes_4.setVisible(false);
                line_shapes_5.setVisible(false);
                line_shapes_new1.setVisible(false);
                line3.setVisible(true);
                line4.setVisible(true);
                line10.setVisible(false);
                btn_fill.setVisible(false);
                brightnessText.setVisible(true);
                slider_brightness.setVisible(true);
                slider_brightnessText.setVisible(true);
                slider_thickness.setVisible(true);
                slider_thicknessText.setVisible(true);
                slider_redText.setVisible(true);
                slider_greenText.setVisible(true);
                slider_blueText.setVisible(true);
                slider_red.setVisible(true);
                slider_green.setVisible(true);
                slider_blue.setVisible(true);
                btn_red.setVisible(true);
                btn_green.setVisible(true);
                btn_blue.setVisible(true);
                btn_brith.setVisible(true);
                btn1.setVisible(false);
                btn_star.setVisible(false);
                btn_def.setVisible(false);
                btn2.setVisible(false);
                btn3.setVisible(true);
                btn4.setVisible(true);
                btn4_clear.setVisible(true);
                thicknessText.setVisible(false);
                slider_thickness.setVisible(false);
                slider_thicknessText.setVisible(false);
                colorPicker.setVisible(false);
                save_png_Text.setVisible(true);
                save_jpg_Text.setVisible(true);
                text_hint.setVisible(false);

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
                back_button.setLayoutY(1);
                back_button.setFont(Font.font ("Arial", FontWeight.THIN, 27));
                back_button.setFill(Color.web("#0064B6"));
            }
        });

        //back_button button onMouseExited
        back_button.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                back_button.setLayoutY(0);
                back_button.setFont(Font.font ("Arial", FontWeight.THIN, 25));
                back_button.setFill(Color.WHITE);
            }
        });



        //save_jpg_Text button onMouseEntered
        save_jpg_Text.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                save_jpg_Text.setFill(Color.web("#659bf2"));
                save_jpg_Text.setStyle(
                        "-fx-cursor: hand;"
                );
            }
        });

        //save_png_Text button onMouseExited
        save_jpg_Text.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                save_jpg_Text.setFill(Color.web("#78797A"));
            }
        });

        //save_png_Text button onMouseEntered
        save_png_Text.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                save_png_Text.setFill(Color.web("#659bf2"));
                save_png_Text.setStyle(
                                "-fx-cursor: hand;"
                );
            }
        });

        //save_png_Text button onMouseExited
        save_png_Text.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                save_png_Text.setFill(Color.web("#78797A"));
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

                start_imageView.setFitWidth(1366);
                start_imageView.setFitHeight(768);
                start_imageView.setX(100);
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

                        finish_imageView.setFitWidth(1368);
                        finish_imageView.setFitHeight(768);
                        finish_imageView.setX(100);
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
                                root.getChildren().removeAll(canvas, back_button, save_jpg_Text, save_png_Text, start_imageView,
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
                                    root.getChildren().removeAll(canvas, back_button, save_jpg_Text, save_png_Text, start_imageView, finish_imageView, new_pic_Text, old_pic_Text);
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
                                    root.getChildren().removeAll(canvas, back_button, save_jpg_Text, save_png_Text, start_imageView, finish_imageView, new_pic_Text, old_pic_Text);
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

                start_imageView.setFitWidth(1366);
                start_imageView.setFitHeight(768);
                start_imageView.setX(100);
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

                        root.getChildren().remove(rgb_change_button);
                        root.getChildren().addAll(old_pic_Text, new_pic_Text, save_jpg_Text, save_jpg_Text, save_png_Text, back_button);

                        // Back button listeners
                        //back_button button onMouseEntered

                        // back_button onMouseClicked
                        back_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                root.getChildren().removeAll(canvas, back_button, save_jpg_Text, save_png_Text, start_imageView, finish_imageView, new_pic_Text, old_pic_Text);
                                root.getChildren().addAll(rgb_change_button);
                            }
                        });

                        // save_jpg_Text button onMouseClicked
                        save_jpg_Text.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                try{
                                    ImageIO.write(SwingFXUtils.fromFXImage(wImage, null), "png", new FileOutputStream("image.jpg"));
                                    root.getChildren().removeAll(canvas, back_button, save_jpg_Text, save_png_Text, start_imageView, finish_imageView, new_pic_Text, old_pic_Text);
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
                                    root.getChildren().removeAll(canvas, back_button, save_jpg_Text, save_png_Text, start_imageView, finish_imageView, new_pic_Text, old_pic_Text,
                                     btn1, btn_star, btn_def, btn3, btn3, btn4, btn4_clear, btn_blue, btn_red, btn_green, btn_brith, setting_logoView);
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
                gc.drawImage(start_image, 0,0, 1500, 844);


                root.getChildren().addAll(canvas, main_header, field_for_features, setting_logoView,
                        navbar_brushesRect, navbar_brushesIconView, navbar_brushesIconText,
                        navbar_shapesRect, navbar_shapesIconView, navbar_shapesIconText,
                        navbar_stickersRect, navbar_stickersIconView, navbar_stickersIconText,
                        navbar_textRect, navbar_textIconView, navbar_textIconText,
                        slider_brightness, slider_brightnessText, brightnessText, btn_fill);

                root.getChildren().addAll(slider_redText, slider_greenText, slider_blueText, slider_red, slider_green, slider_blue,
                        btn1, btn_star, btn_def, btn2,btn3, btn4,btn4_clear, thicknessText, slider_thickness, slider_thicknessText, btn_red, btn_green,
                        btn_blue, btn_brith, colorPicker, line_on_top_of_brightness, line_under_brightness, line3, line4, line10, line_shapes_1, line_shapes_2,
                        line_shapes_3, line_shapes_4, line_shapes_5, line_shapes_new1, text_hint);

                text_hint.setVisible(true);
                line_shapes_1.setVisible(false);
                line_shapes_2.setVisible(false);
                line_shapes_3.setVisible(false);
                line_shapes_4.setVisible(false);
                line_shapes_5.setVisible(false);
                line_shapes_new1.setVisible(false);
                line3.setVisible(false);
                line4.setVisible(false);
                line4.setVisible(false);
                line10.setVisible(false);
                line_under_brightness.setVisible(false);
                line_on_top_of_brightness.setVisible(false);
                slider_redText.setVisible(false);
                slider_greenText.setVisible(false);
                slider_blueText.setVisible(false);
                slider_red.setVisible(false);
                slider_green.setVisible(false);
                slider_blue.setVisible(false);
                btn_red.setVisible(false);
                btn_green.setVisible(false);
                btn_blue.setVisible(false);
                btn_brith.setVisible(false);
                btn1.setVisible(false);
                btn_star.setVisible(false);
                btn_def.setVisible(false);
                btn2.setVisible(false);
                btn3.setVisible(false);
                btn4.setVisible(false);
                btn4_clear.setVisible(false);
                thicknessText.setVisible(false);
                slider_thickness.setVisible(false);
                slider_thicknessText.setVisible(false);
                slider_brightness.setVisible(false);
                slider_brightnessText.setVisible(false);
                field_for_features.setVisible(true);
                colorPicker.setVisible(false);
                save_jpg_Text.setVisible(false);
                save_png_Text.setVisible(false);
                brightnessText.setVisible(false);
                btn_fill.setVisible(false);
                // Working with image
                WritableImage wImage = new WritableImage((int)start_image.getWidth(), (int)start_image.getHeight());
                PixelWriter pixelWriter = wImage.getPixelWriter();


                PixelReader pixelReader = start_image.getPixelReader();


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
                        gc.drawImage(wImage, 0, 0, 1500, 844);
                    }
                }));
                oneSecTimer.setCycleCount(Timeline.INDEFINITE);

                Timeline oneSecTimer2 = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {

                        for(int i = 0; i < start_image.getWidth(); i++){
                            for(int j = 0; j < start_image.getHeight(); j++){
                                Color color = pixelReader.getColor(i, j);
                                pixelWriter.setColor(i, j, Color.color(color.getRed() * slider_red.valueProperty().doubleValue() / 100 * slider_brightness.valueProperty().doubleValue() / 100,
                                        color.getGreen() * slider_green.valueProperty().doubleValue() / 100 * slider_brightness.valueProperty().doubleValue() / 100,
                                        color.getBlue() * slider_blue.valueProperty().doubleValue() / 100 * slider_brightness.valueProperty().doubleValue() / 100));
                            }
                        }
                        gc.drawImage(wImage, 0, 0, 1500, 844);
                    }
                }));
                oneSecTimer2.setCycleCount(Timeline.INDEFINITE);


                navbar_brushesIconView.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        navbar_brushesIconView.setCursor(Cursor.HAND);
                        navbar_brushesIconText.setFill(Color.web("#0064B6"));
                    }
                });

                navbar_brushesIconView.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        navbar_brushesIconText.setFill(Color.WHITE);
                    }
                });


                btn4_clear.setOnMouseClicked(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {

                        gc.drawImage(start_image, 0,0, 1500, 844);

                    }
                });

                btn1.setOnMouseClicked(new EventHandler<MouseEvent>
                        () {


                    @Override
                    public void handle(MouseEvent t) {



                        canvas.setCursor(Cursor.CROSSHAIR);

                        canvas.setOnMouseReleased(new EventHandler<MouseEvent>
                                () {
                            @Override
                            public void handle(MouseEvent t) {

                                System.out.println(true);

                                canvas.setCursor(Cursor.DEFAULT);

                                canvas.setOnMouseMoved(new EventHandler<MouseEvent>
                                        () {


                                    @Override
                                    public void handle(MouseEvent t) {
                                        canvas.setCursor(Cursor.CROSSHAIR);

                                        gc.setLineWidth(2);
                                        gc.setFill(colorPicker.getValue());
                                        gc.setStroke(colorPicker.getValue());
                                        if(fill)
                                            gc.fillOval(t.getX() - slider_thickness.getValue()/2, t.getY() - slider_thickness.getValue()/2, slider_thickness.getValue(), slider_thickness.getValue());
                                        else
                                            gc.strokeOval(t.getX() - slider_thickness.getValue()/2, t.getY() - slider_thickness.getValue()/2, slider_thickness.getValue(), slider_thickness.getValue());

                                    }
                                });

                                canvas.setOnMouseClicked(new EventHandler<MouseEvent>
                                        () {


                                    @Override
                                    public void handle(MouseEvent t) {
                                        canvas.setCursor(Cursor.CROSSHAIR);

                                        gc.setLineWidth(2);
                                        gc.setFill(colorPicker.getValue());
                                        gc.setStroke(colorPicker.getValue());
                                        if(fill)
                                            gc.fillOval(t.getX() - slider_thickness.getValue()/2, t.getY() - slider_thickness.getValue()/2, slider_thickness.getValue(), slider_thickness.getValue());
                                        else
                                            gc.strokeOval(t.getX() - slider_thickness.getValue()/2, t.getY() - slider_thickness.getValue()/2, slider_thickness.getValue(), slider_thickness.getValue());

                                    }
                                });



                            }
                        });

                        canvas.setOnMousePressed(new EventHandler<MouseEvent>
                                () {


                            @Override
                            public void handle(MouseEvent t) {
                                System.out.println(false);
                                canvas.setCursor(Cursor.DEFAULT);

                            }
                        });


                    }
                });

                btn_def.setOnMouseClicked(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {

                        canvas.setCursor(Cursor.CROSSHAIR);
                        gc.setLineWidth(slider_thickness.getValue());

                        canvas.setOnMousePressed(new EventHandler<MouseEvent>
                                () {
                            @Override
                            public void handle(MouseEvent t) {

                                gc.beginPath();

                                System.out.println(true);

                                canvas.setCursor(Cursor.DEFAULT);

                                canvas.setOnMouseMoved(new EventHandler<MouseEvent>
                                        () {


                                    @Override
                                    public void handle(MouseEvent t) {
                                        canvas.setCursor(Cursor.CROSSHAIR);

                                        gc.setLineWidth(slider_thickness.getValue());
                                        gc.setFill(colorPicker.getValue());
                                        gc.setStroke(colorPicker.getValue());

                                        gc.lineTo(t.getX(), t.getY());
                                        gc.stroke();


                                        gc.fillArc(t.getX() - slider_thickness.getValue()/1.6, t.getY() - slider_thickness.getValue()/1.6,
                                                slider_thickness.getValue() * 1.5, slider_thickness.getValue() * 1.5,
                                                0, 360, ArcType.ROUND);

                                        gc.beginPath();
                                        gc.moveTo(t.getX(), t.getY());

                                    }
                                });



                            }
                        });

                        canvas.setOnMouseReleased(new EventHandler<MouseEvent>
                                () {


                            @Override
                            public void handle(MouseEvent t) {
                                gc.beginPath();

                            }
                        });

                    }

                });

                btn_star.setOnMouseClicked(new EventHandler<MouseEvent>
                        () {


                    @Override
                    public void handle(MouseEvent t) {



                        canvas.setCursor(Cursor.CROSSHAIR);

                        canvas.setOnMouseReleased(new EventHandler<MouseEvent>
                                () {
                            @Override
                            public void handle(MouseEvent t) {

                                System.out.println(true);

                                canvas.setCursor(Cursor.DEFAULT);

                                canvas.setOnMouseMoved(new EventHandler<MouseEvent>
                                        () {


                                    @Override
                                    public void handle(MouseEvent t) {
                                        canvas.setCursor(Cursor.CROSSHAIR);

                                        gc.setLineWidth(2);
                                        gc.setFill(colorPicker.getValue());
                                        gc.setStroke(colorPicker.getValue());
                                        double xpoints[] = {10 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                85 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                110 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                135 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                210 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                160 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                170 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                110 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                50 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                60 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue()};
                                        double ypoints[] = {85 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                75 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                10 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                75 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                85 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                125 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                190 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                150 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                190 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                125 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue()};
                                        if(fill)
                                            gc.fillPolygon(xpoints, ypoints, xpoints.length);
                                        else
                                            gc.strokePolygon(xpoints, ypoints, xpoints.length);
                                    }
                                });

                                canvas.setOnMouseClicked(new EventHandler<MouseEvent>
                                        () {


                                    @Override
                                    public void handle(MouseEvent t) {
                                        System.out.println(false);
                                        canvas.setCursor(Cursor.DEFAULT);
                                        gc.setLineWidth(2);
                                        gc.setFill(colorPicker.getValue());
                                        gc.setStroke(colorPicker.getValue());
                                        double xpoints[] = {10 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                85 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                110 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                135 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                210 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                160 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                170 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                110 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                50 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue(),
                                                60 * slider_thickness.getValue()/100 + t.getX() - slider_thickness.getValue()};
                                        double ypoints[] = {85 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                75 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                10 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                75 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                85 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                125 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                190 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                150 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                190 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue(),
                                                125 * slider_thickness.getValue()/100 + t.getY() - slider_thickness.getValue()};
                                        if(fill)
                                            gc.fillPolygon(xpoints, ypoints, xpoints.length);
                                        else
                                            gc.strokePolygon(xpoints, ypoints, xpoints.length);

                                    }
                                });



                            }
                        });

                        canvas.setOnMousePressed(new EventHandler<MouseEvent>
                                () {


                            @Override
                            public void handle(MouseEvent t) {
                                System.out.println(false);
                                canvas.setCursor(Cursor.DEFAULT);

                            }
                        });


                    }
                });

                btn2.setOnMouseClicked(new EventHandler<MouseEvent>
                        () {


                    @Override
                    public void handle(MouseEvent t) {



                        canvas.setCursor(Cursor.CROSSHAIR);

                        canvas.setOnMouseReleased(new EventHandler<MouseEvent>
                                () {
                            @Override
                            public void handle(MouseEvent t) {

                                System.out.println(true);

                                canvas.setCursor(Cursor.DEFAULT);

                                canvas.setOnMouseMoved(new EventHandler<MouseEvent>
                                        () {


                                    @Override
                                    public void handle(MouseEvent t) {
                                        canvas.setCursor(Cursor.CROSSHAIR);

                                        gc.setLineWidth(2);
                                        gc.setFill(colorPicker.getValue());
                                        gc.setStroke(colorPicker.getValue());
                                        if(fill)
                                            gc.fillRect(t.getX() - slider_thickness.getValue()/2, t.getY() - slider_thickness.getValue()/2, slider_thickness.getValue(), slider_thickness.getValue());
                                        else
                                            gc.strokeRect(t.getX() - slider_thickness.getValue()/2, t.getY() - slider_thickness.getValue()/2, slider_thickness.getValue(), slider_thickness.getValue());


                                    }
                                });



                            }
                        });

                        canvas.setOnMouseClicked(new EventHandler<MouseEvent>
                                () {


                            @Override
                            public void handle(MouseEvent t) {
                                canvas.setCursor(Cursor.DEFAULT);
                                gc.setLineWidth(2);
                                gc.setFill(colorPicker.getValue());
                                gc.setStroke(colorPicker.getValue());
                                if(fill)
                                    gc.fillRect(t.getX() - slider_thickness.getValue()/2, t.getY() - slider_thickness.getValue()/2, slider_thickness.getValue(), slider_thickness.getValue());
                                else
                                    gc.strokeRect(t.getX() - slider_thickness.getValue()/2, t.getY() - slider_thickness.getValue()/2, slider_thickness.getValue(), slider_thickness.getValue());
                            }
                        });

                        canvas.setOnMousePressed(new EventHandler<MouseEvent>
                                () {


                            @Override
                            public void handle(MouseEvent t) {
                                canvas.setCursor(Cursor.DEFAULT);

                            }
                        });


                    }
                });



                btn3.setOnMouseClicked(new EventHandler<MouseEvent>
                        () {


                    @Override
                    public void handle(MouseEvent t) {

                        PixelReader pixelReader = wImage.getPixelReader();

                        Color tmp_color[] = new Color[(int)start_image.getWidth() * (int)start_image.getHeight()];

                        int tmp1 = 0;

                        for(int i = 0; i < (int)start_image.getWidth(); i++){
                            for(int j = 0; j < (int)start_image.getHeight(); j++){
                                tmp_color[tmp1++] = pixelReader.getColor(i, j);
                            }
                        }


                        Arrays.sort(tmp_color, (a, b) -> Double.compare(a.getHue(), b.getHue()));

                        int tmp = 0;

                        for(int i = 0; i < (int)start_image.getWidth(); i++){
                            for(int j = 0; j < (int)start_image.getHeight(); j++){
                                pixelWriter.setColor(i, j, tmp_color[tmp++]);
                            }
                            gc.drawImage(wImage, 0, 0, 1500, 844);
                        }

                    }
                });

                btn_fill.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_1.setStroke(Color.web("#0064B6"));
                        line_shapes_2.setStroke(Color.web("#0064B6"));
                        btn_fill.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                btn_fill.setOnMouseExited(new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_1.setStroke(Color.BLACK);
                        line_shapes_2.setStroke(Color.BLACK);
                        btn_fill.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                btn2.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_2.setStroke(Color.web("#0064B6"));
                        line_shapes_3.setStroke(Color.web("#0064B6"));
                        btn2.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                btn2.setOnMouseExited(new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_2.setStroke(Color.BLACK);
                        line_shapes_3.setStroke(Color.BLACK);
                        btn2.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                btn_star.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_2.setStroke(Color.web("#0064B6"));
                        line_shapes_3.setStroke(Color.web("#0064B6"));
                        btn_star.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                btn_def.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_3.setStroke(Color.web("#0064B6"));
                        line_shapes_4.setStroke(Color.web("#0064B6"));
                        btn_def.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                btn_def.setOnMouseExited(new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_3.setStroke(Color.BLACK);
                        line_shapes_4.setStroke(Color.BLACK);
                        btn_def.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                btn_star.setOnMouseExited(new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_2.setStroke(Color.BLACK);
                        line_shapes_3.setStroke(Color.BLACK);
                        btn_star.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                btn1.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_2.setStroke(Color.web("#0064B6"));
                        line_shapes_3.setStroke(Color.web("#0064B6"));
                        btn1.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                btn1.setOnMouseExited(new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_2.setStroke(Color.BLACK);
                        line_shapes_3.setStroke(Color.BLACK);
                        btn1.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                btn4_clear.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line3.setStroke(Color.web("#0064B6"));
                        line4.setStroke(Color.web("#0064B6"));
                        btn4_clear.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                btn4_clear.setOnMouseExited(new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent t) {
                        line3.setStroke(Color.BLACK);
                        line4.setStroke(Color.BLACK);
                        btn4_clear.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                colorPicker.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line4.setStroke(Color.web("#0064B6"));
                        line10.setStroke(Color.web("#0064B6"));
                        colorPicker.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                colorPicker.setOnMouseExited(new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent t) {
                        line4.setStroke(Color.BLACK);
                        line10.setStroke(Color.BLACK);
                        colorPicker.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                slider_thickness.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_1.setStroke(Color.web("#0064B6"));
                    }
                });

                slider_thickness.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_shapes_1.setStroke(Color.BLACK);
                    }
                });

                btn4.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_under_brightness.setStroke(Color.web("#0064B6"));
                        line3.setStroke(Color.web("#0064B6"));
                        btn4.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                btn4.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_under_brightness.setStroke(Color.BLACK);
                        line3.setStroke(Color.BLACK);
                        btn4.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                btn3.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_under_brightness.setStroke(Color.web("#0064B6"));
                        line3.setStroke(Color.web("#0064B6"));
                        btn3.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                btn3.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_under_brightness.setStroke(Color.BLACK);
                        line3.setStroke(Color.BLACK);
                        btn3.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                btn_red.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_under_brightness.setStroke(Color.web("#0064B6"));
                        line3.setStroke(Color.web("#0064B6"));
                        btn_red.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                btn_red.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_under_brightness.setStroke(Color.BLACK);
                        line3.setStroke(Color.BLACK);
                        btn_red.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                btn_green.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_under_brightness.setStroke(Color.web("#0064B6"));
                        line3.setStroke(Color.web("#0064B6"));
                        btn_green.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                btn_green.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_under_brightness.setStroke(Color.BLACK);
                        line3.setStroke(Color.BLACK);
                        btn_green.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                btn_blue.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_under_brightness.setStroke(Color.web("#0064B6"));
                        line3.setStroke(Color.web("#0064B6"));
                        btn_blue.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                btn_blue.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_under_brightness.setStroke(Color.BLACK);
                        line3.setStroke(Color.BLACK);
                        btn_blue.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                btn_brith.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_under_brightness.setStroke(Color.web("#0064B6"));
                        line3.setStroke(Color.web("#0064B6"));
                        btn_brith.setStyle(
                                "-fx-border-color: #659bf2; "
                                        + "-fx-text-fill: white;"
                                        + "-fx-background-color: #659bf2;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                                        + "-fx-cursor: hand;"
                        );
                    }
                });

                btn_brith.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        line_under_brightness.setStroke(Color.BLACK);
                        line3.setStroke(Color.BLACK);
                        btn_brith.setStyle(
                                "-fx-border-color: #78797A; "
                                        + "-fx-text-fill: #78797A;"
                                        + "-fx-background-color: white;"
                                        + "-fx-font-weight: 700;"
                                        + "-fx-font-size: 12px;"
                                        + "-fx-border-radius: 2;"
                                        + "-fx-border-style: solid;"
                                        + "-fx-border-width: 2;"
                        );
                    }
                });

                btn4.setOnMouseClicked(new EventHandler<MouseEvent>
                        () {


                    @Override
                    public void handle(MouseEvent t) {

                        PixelReader pixelReader = wImage.getPixelReader();

                        Color tmp_color[] = new Color[(int)start_image.getWidth() * (int)start_image.getHeight()];

                        for(int i = 0; i < (int)start_image.getWidth(); i++){
                            for(int j = 0; j < (int)start_image.getHeight(); j++){
                                tmp_color[i * (int)start_image.getHeight() + j] = pixelReader.getColor(i, j);
                            }
                        }

                        Arrays.sort(tmp_color, (a, b) -> Double.compare(a.getSaturation(), b.getSaturation()));

                        for(int i = 0; i < (int)start_image.getWidth(); i++){
                            for(int j = 0; j < (int)start_image.getHeight(); j++){
                                pixelWriter.setColor(i, j, tmp_color[i * (int)start_image.getHeight() + j]);
                            }
                            gc.drawImage(wImage, 0, 0, 1500, 844);
                        }

                    }
                });

                btn_red.setOnMouseClicked(new EventHandler<MouseEvent>
                        () {


                    @Override
                    public void handle(MouseEvent t) {

                        int tmp1 = 0;
                        int tmp = 0;

                        Color tmp_color[] = new Color[(int)start_image.getWidth() * (int)start_image.getHeight()];

                        PixelReader pixelReader = wImage.getPixelReader();

                        for(int i = 0; i < (int)start_image.getWidth(); i++){
                            for(int j = 0; j < (int)start_image.getHeight(); j++){
                                tmp_color[tmp1++] = pixelReader.getColor(i, j);
                            }
                        }

                        Arrays.sort(tmp_color, (a, b) -> Double.compare(a.getRed(), b.getRed()));

                        for(int i = 0; i < (int)start_image.getWidth(); i++){
                            for(int j = 0; j < (int)start_image.getHeight(); j++){
                                pixelWriter.setColor(i, j, tmp_color[tmp++]);
                            }
                        }
                        gc.drawImage(wImage, 0, 0, 1500, 844);

                        System.out.println(tmp1 + " " + tmp);


                    }
                });

                btn_green.setOnMouseClicked(new EventHandler<MouseEvent>
                        () {


                    @Override
                    public void handle(MouseEvent t) {

                        Color tmp_color[] = new Color[(int)start_image.getWidth() * (int)start_image.getHeight()];

                        PixelReader pixelReader = wImage.getPixelReader();

                        for(int i = 0; i < (int)start_image.getWidth(); i++){
                            for(int j = 0; j < (int)start_image.getHeight(); j++){
                                tmp_color[i * (int)start_image.getHeight() + j] = pixelReader.getColor(i, j);
                            }
                        }

                        Arrays.sort(tmp_color, (a, b) -> Double.compare(a.getGreen(), b.getGreen()));

                        for(int i = 0; i < (int)start_image.getWidth(); i++){
                            for(int j = 0; j < (int)start_image.getHeight(); j++){
                                pixelWriter.setColor(i, j, tmp_color[i * (int)start_image.getHeight() + j]);
                            }
                        }
                        gc.drawImage(wImage, 0, 0, 1500, 844);


                    }
                });

                btn_blue.setOnMouseClicked(new EventHandler<MouseEvent>
                        () {


                    @Override
                    public void handle(MouseEvent t) {

                        System.out.println((int)start_image.getWidth());

                        PixelReader pixelReader = wImage.getPixelReader();

                        Color tmp_color[] = new Color[(int)start_image.getWidth() * (int)start_image.getHeight()];

                        for(int i = 0; i < (int)start_image.getWidth(); i++){
                            for(int j = 0; j < (int)start_image.getHeight(); j++){
                                tmp_color[i * (int)start_image.getHeight() + j] = pixelReader.getColor(i, j);
                            }
                        }

                        Arrays.sort(tmp_color, (a, b) -> Double.compare(a.getBlue(), b.getBlue()));

                        for(int i = 0; i < (int)start_image.getWidth(); i++){
                            for(int j = 0; j < (int)start_image.getHeight(); j++){
                                pixelWriter.setColor(i, j, tmp_color[i * (int)start_image.getHeight() + j]);
                            }
                        }
                        gc.drawImage(wImage, 0, 0, 1500, 844);


                    }
                });

                btn_brith.setOnMouseClicked(new EventHandler<MouseEvent>
                        () {


                    @Override
                    public void handle(MouseEvent t) {

                        int tmp1 = 0;
                        int tmp = 0;

                        Color tmp_color[] = new Color[(int)start_image.getWidth() * (int)start_image.getHeight()];

                        PixelReader pixelReader = wImage.getPixelReader();

                        for(int i = 0; i < (int)start_image.getWidth(); i++){
                            for(int j = 0; j < (int)start_image.getHeight(); j++){
                                tmp_color[tmp1++] = pixelReader.getColor(i, j);
                            }
                        }

                        Arrays.sort(tmp_color, (a, b) -> Double.compare(a.getBrightness(), b.getBrightness()));

                        for(int i = 0; i < (int)start_image.getWidth(); i++){
                            for(int j = 0; j < (int)start_image.getHeight(); j++){
                                pixelWriter.setColor(i, j, tmp_color[tmp++]);
                            }
                        }
                        gc.drawImage(wImage, 0, 0, 1500, 844);
                        System.out.println("Drawed");


                    }
                });

                btn_fill.setOnMouseClicked(new EventHandler<MouseEvent>
                        () {


                    @Override
                    public void handle(MouseEvent t) {

                        fill = !fill;

                    }
                });

                navbar_shapesIconView.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        navbar_shapesIconView.setCursor(Cursor.HAND);
                        navbar_shapesIconText.setFill(Color.web("#0064B6"));
                    }
                });

                navbar_shapesIconView.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        navbar_shapesIconText.setFill(Color.WHITE);
                    }
                });

                slider_brightness.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        oneSecTimer2.play();
                        line_on_top_of_brightness.setStroke(Color.web("#0064B6"));
                        line_under_brightness.setStroke(Color.web("#0064B6"));
                    }
                });

                slider_brightness.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        oneSecTimer2.stop();
                        line_on_top_of_brightness.setStroke(Color.web("#78797A"));
                        line_under_brightness.setStroke(Color.web("#78797A"));
                    }
                });

                slider_red.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        oneSecTimer.play();
                        line_on_top_of_brightness.setStroke(Color.web("#0064B6"));
                    }
                });
                slider_red.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        oneSecTimer.stop();
                        line_on_top_of_brightness.setStroke(Color.web("#78797A"));
                    }
                });

                slider_green.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        oneSecTimer.play();
                        line_on_top_of_brightness.setStroke(Color.web("#0064B6"));
                    }
                });
                slider_green.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        oneSecTimer.stop();
                        line_on_top_of_brightness.setStroke(Color.web("#78797A"));
                    }
                });

                slider_blue.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        oneSecTimer.play();
                        line_on_top_of_brightness.setStroke(Color.web("#0064B6"));
                    }
                });
                slider_blue.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        oneSecTimer.stop();
                        line_on_top_of_brightness.setStroke(Color.web("#78797A"));
                    }
                });
//
//                // end of canvas
                // Back button listeners
                //back_button button onMouseEntered

                // back_button onMouseClicked
                back_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        oneSecTimer.stop();
                        oneSecTimer2.stop();
                        root.getChildren().removeAll( canvas, back_button, save_jpg_Text, save_png_Text,slider_red, slider_green, slider_blue, slider_redText, slider_greenText,
                                slider_blueText, main_header, slider_brightness, slider_brightnessText,
                                navbar_brushesRect, navbar_brushesIconView, navbar_brushesIconText, brightnessText,
                                navbar_shapesRect, navbar_shapesIconView, navbar_shapesIconText,
                                navbar_stickersRect, navbar_stickersIconView, navbar_stickersIconText,
                                navbar_textRect, navbar_textIconView, navbar_textIconText, field_for_features,
                                btn1, btn_star, btn_def, btn2, btn3, btn3, btn4, btn4_clear, btn_blue, btn_red, btn_green, btn_brith, setting_logoView,
                                colorPicker, slider_thicknessText, thicknessText, slider_thickness, btn_fill, line3, line4, line10, line_on_top_of_brightness,
                                line_shapes_1, line_shapes_2, line_shapes_3, line_shapes_4, line_shapes_5, line_shapes_new1, line_under_brightness, text_hint);
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
                        try {
                            Robot robot = new Robot();
                            String fileName = "First Project/saved images/image.jpg";

                            BufferedImage screenFullImage = robot.createScreenCapture(new java.awt.Rectangle(100, 100, 1366, 768));
                            ImageIO.write(screenFullImage, "jpg", new File(fileName));

                        } catch (AWTException | IOException ex) {
                            System.err.println(ex);
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
                            //Set extension filter
                            FileChooser.ExtensionFilter extFilter =
                                    new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
                            fileChooser.getExtensionFilters().add(extFilter);

                            //Show save file dialog
                            File file = fileChooser.showSaveDialog(primaryStage);
                            WritableImage writableImage = new WritableImage(1500, 844);
                            canvas.snapshot(null, writableImage);
                            RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                            ImageIO.write(renderedImage, "png", file);
                            root.getChildren().removeAll(canvas,  back_button, save_jpg_Text, save_png_Text, slider_red, slider_green, slider_blue, slider_redText, slider_greenText,
                                    slider_blueText, main_header,
                                    navbar_brushesRect, navbar_brushesIconView, navbar_brushesIconText,
                                    navbar_shapesRect, navbar_shapesIconView, navbar_shapesIconText,
                                    navbar_stickersRect, navbar_stickersIconView, navbar_stickersIconText,
                                    navbar_textRect, navbar_textIconView, navbar_textIconText, field_for_features,
                                    btn1, btn_star, btn_def, btn2, btn3, btn3, btn4, btn4_clear, btn_blue, btn_red, btn_green, btn_brith, setting_logoView,
                                    colorPicker, slider_thicknessText, thicknessText, slider_thickness, text_hint, btn_fill, line3,line4,line10,
                                    line_on_top_of_brightness,line_shapes_1,line_shapes_2,line_shapes_3,line_shapes_4,line_shapes_5,line_shapes_new1,
                                    line_under_brightness);
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

        // Transparent scene and stage
        primaryStage.setMaximized(true);
        primaryStage.getIcons().add(new Image("file:First Project/pics/agreement.png"));
        primaryStage.setTitle("KN-106 Teamwork Project");
        primaryStage.setScene(scene);
        primaryStage.show();



    }

}