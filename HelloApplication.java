package com.example.demo6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    private List<Image> imageGallary;
    private int currentIndex = 0;
        @Override
        public void start(Stage stage) throws IOException {
            BorderPane root = new BorderPane();
            root.setStyle("-fx-background-color: #f0f0f0;");

            imageGallary = loadImageGallary();

            GridPane galleryGrid = createGalleryGrid(stage);
        ScrollPane scrollPane = new ScrollPane(galleryGrid);
        scrollPane.setFitToWidth(true);

        root.setCenter(scrollPane);

        Button previousButton = new Button("Previous");
        previousButton.setStyle("-fx-font-size: 16px;");
        previousButton.setOnAction(event -> showPreviousImage(stage));

        Button nextButton = new Button("Next");
        nextButton.setStyle("-fx-font-size: 16px;");
        nextButton.setOnAction(event -> showNextImage(stage));

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(previousButton, nextButton);

        root.setBottom(buttonBox);


        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Image Gallary!");
        stage.setScene(scene);
        stage.show();

        showImageDetails(stage, imageGallary.get(0));
    }

   // private void showImageDetails(Stage primaryStage, Image image) {
 //       System.out.println("Displaying details for: " + image.getUrl());
   // }

    private GridPane createGalleryGrid(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        int col = 0;
        int row = 0;
        for (Image image : imageGallary) {
            ImageView thumbnail = createThumbnail(image); // Use image directly

            thumbnail.setOnMouseClicked(event -> {
                showImageDetails(primaryStage, image);
            });

            gridPane.add(thumbnail, col, row);
            col++;
            if (col == 3) {
                col = 0;
                row++;
            }
        }

        return gridPane;
    }

    private ImageView createThumbnail(Image image) {
        ImageView thumbnail = new ImageView(image);
        thumbnail.setFitWidth(150);
        thumbnail.setFitHeight(150);
        thumbnail.getStyleClass().add("thumbnail");
        return thumbnail;
    }
    private List<Image> loadImageGallary() {
        List<Image> imageList = new ArrayList<>();
        //load image infor
        try {
            imageGallary.add(new Image("image1.jpg"));
            imageGallary.add(new Image("image2.jpg"));
            imageGallary.add(new Image("image3.jpg"));
            imageGallary.add(new Image("image4.jpg"));
            imageGallary.add(new Image("image5.jpg"));
            imageGallary.add(new Image("image6.jpg"));
            imageGallary.add(new Image("image7.jpg"));

        } catch (Exception e) {
            System.out.println("Image loading err: " + e.getMessage());
            e.printStackTrace();
        }
        return imageList;
    }
    private void showImageDetails(Stage primaryStage, Image image) {
        // Create a new BorderPane (optional, consider reusing existing root)
        BorderPane detailsPane = new BorderPane();

        // Set image view
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(primaryStage.getWidth());
        imageView.setFitHeight(primaryStage.getHeight());
        detailsPane.setCenter(imageView);

        // Add additional details (replace with your desired implementation)
//        HBox detailsBox = new HBox();
//        detailsBox.setAlignment(Pos.CENTER);
//
//
//        // Example: Add image caption (assuming a caption field exists)
//       if (image.getUserData() != null && image.getUserData() instanceof String) {
//            String caption = (String) image.getUserData();
//            Text captionText = new Text(caption);
//            captionText.setFont(Font.font("Arial", 14));
//            captionText.setFill(Color.BLACK);
//            detailsBox.getChildren().add(captionText);
//        }
//
//        // ... Add other details as needed (e.g., filename)
//
//        detailsPane.setBottom(detailsBox);

        // Replace the scene content with the details pane (consider alternative approaches)
        Scene scene = primaryStage.getScene();
        scene.setRoot(detailsPane);
    }

    private void showPreviousImage(Stage primaryStage) {
        if (currentIndex > 0) {
            currentIndex--;
            showImageDetails(primaryStage, imageGallary.get(currentIndex));
        }
    }

    private void showNextImage(Stage primaryStage) {
        if (currentIndex < imageGallary.size() - 1) {
            currentIndex++;
            // Call showImageDetails with the updated currentIndex
            showImageDetails(primaryStage, imageGallary.get(currentIndex));
        }
    }


    public static void main(String[] args) {
        launch();
    }
}


