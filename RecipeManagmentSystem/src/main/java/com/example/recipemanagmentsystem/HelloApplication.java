package com.example.recipemanagmentsystem;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class HelloApplication extends Application {
    Statement myStatement;
    ObservableList<recipeDatabase> data;
    @Override
    public void start(Stage stage)  {
        ;

        Button btnconnect =new Button("connect to database");
        data = FXCollections.observableArrayList();
        TableView<recipeDatabase> table = new TableView<>();

        TableColumn<recipeDatabase,String> name = new TableColumn<>("Title");
        name.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<recipeDatabase,String> ingredients = new TableColumn<>("ingredients");
        ingredients.setCellValueFactory(new PropertyValueFactory<>("Ingredients"));

        TableColumn<recipeDatabase,String> instructions = new TableColumn<>("Instructions");
        instructions.setCellValueFactory(new PropertyValueFactory<>("instructions"));

        TableColumn<recipeDatabase,Integer> cooking_time = new TableColumn<>("cooking time");
        cooking_time.setCellValueFactory(new PropertyValueFactory<>("cooking_time"));

        TableColumn<recipeDatabase,String> serving_size = new TableColumn<>("Serving Size");
        serving_size.setCellValueFactory(new PropertyValueFactory<>("serving_size"));

        TableColumn<recipeDatabase,String> notes = new TableColumn<>("Notes");
        notes.setCellValueFactory(new PropertyValueFactory<>("notes"));

        TableColumn<recipeDatabase,String> category = new TableColumn<>("Category");
        category.setCellValueFactory(new PropertyValueFactory<>("category"));

        table.getColumns().add(name);
        table.getColumns().add(ingredients);
        table.getColumns().add(instructions);
        table.getColumns().add(cooking_time);
        table.getColumns().add(serving_size);
        table.getColumns().add(notes);
        table.getColumns().add(category);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        //scene add
        GridPane gridPane=new GridPane();
        gridPane.setPrefSize(500,500);
        gridPane.setPadding(new Insets(30));
        gridPane.setHgap(50);
        gridPane.setVgap(50);

        Label title=new Label("title");
        TextField title_field=new TextField();
        // set the color of the label
        title.setStyle("-fx-font-family: arial;-fx-font-size: 20; ");
        gridPane.add(title,0,0);
        gridPane.add(title_field,1,0);

        Label ingredients1=new Label("ingredients");
        TextField ingredients_field=new TextField();
        ingredients1.setStyle("-fx-font-family: arial;-fx-font-size: 20; ");
        gridPane.add(ingredients1,0,1);
        gridPane.add(ingredients_field,1,1);

        Label instructions1=new Label("instructions");
        TextField instructions_field=new TextField();
        instructions1.setStyle("-fx-font-family: arial;-fx-font-size: 20; ");
        gridPane.add(instructions1,0,2);
        gridPane.add(instructions_field,1,2);

        Label cookingtime=new Label("cookingtime");
        TextField cookingtime_field=new TextField();
        cookingtime.setStyle("-fx-font-family: arial;-fx-font-size: 20; ");
        gridPane.add(cookingtime,0,3);
        gridPane.add(cookingtime_field,1,3);

        Label servingsize=new Label("servingsize");
        TextField servingsize_field=new TextField();
        servingsize.setStyle("-fx-font-family: arial;-fx-font-size: 20; ");
        gridPane.add(servingsize,0,4);
        gridPane.add(servingsize_field,1,4);

        Label notes1=new Label("notes");
        TextField notes_field=new TextField();
        notes1.setStyle("-fx-font-family: arial;-fx-font-size: 20; ");
        gridPane.add(notes1,0,5);
        gridPane.add(notes_field,1,5);
        Label category1=new Label("category");
        TextField category_field=new TextField();
        category1.setStyle("-fx-font-family: arial;-fx-font-size: 20; ");
        gridPane.add(category1,0,6);
        gridPane.add(category_field,1,6);
        Button add=new Button("add");
        Button back2=new Button("back");
        gridPane.add(back2,0,7);
        gridPane.add(add,1,7);
        TextField textField=new TextField();
        Button btnupdate=new Button("update");
        Button btndelete=new Button("delete");


        gridPane.setStyle("-fx-background-color: lightblue;");


        //scene4
        GridPane gridpane3=new GridPane();
        Label search=new Label("enter title to search");
        TextField search_field =new TextField();
        Button btnsearch=new Button("search");

        gridpane3.add(search,0,0);
        gridpane3.add(search_field,1,0);
        gridpane3.add(btnsearch,0,1);
        gridpane3.add(table,0,2);

        //scene update or delete
        GridPane gridpane2=new GridPane();
        gridpane2.setStyle("-fx-background-color: lightblue;");
        gridpane2.setPrefSize(500,500);
        gridpane2.setPadding(new Insets(30));
        gridpane2.setHgap(50);
        gridpane2.setVgap(50);

        Label change=new Label("tile_change");
        TextField change_field=new TextField();
        change.setStyle("-fx-font-family: arial;-fx-font-size: 20; ");
        gridpane2.add(change,0,0);
        gridpane2.add(change_field,1,0);
        Label title2=new Label("title");
        TextField title_field2=new TextField();
        gridpane2.add(title2,0,1);
        gridpane2.add(title_field2,1,1);
        title2.setStyle("-fx-font-family: arial;-fx-font-size: 20; ");

        Label ingredients2=new Label("ingredients");
        TextField ingredients_field2=new TextField();
        gridpane2.add(ingredients2,0,2);
        gridpane2.add(ingredients_field2,1,2);
        ingredients2.setStyle("-fx-font-family: arial;-fx-font-size: 20; ");

        Label instructions2=new Label("instructions");
        TextField instructions_field2=new TextField();
        gridpane2.add(instructions2,0,3);
        gridpane2.add(instructions_field2,1,3);
        instructions2.setStyle("-fx-font-family: arial;-fx-font-size: 20; ");

        Label cookingtime2=new Label("cookingtime");
        TextField cookingtime_field2=new TextField();
        gridpane2.add(cookingtime2,0,4);
        gridpane2.add(cookingtime_field2,1,4);
        cookingtime2.setStyle("-fx-font-family: arial;-fx-font-size: 20; ");

        Label servingsize2=new Label("servingsize");
        TextField servingsize_field2=new TextField();
        gridpane2.add(servingsize2,0,5);
        gridpane2.add(servingsize_field2,1,5);
        servingsize2.setStyle("-fx-font-family: arial;-fx-font-size: 20; ");

        Label notes2=new Label("notes");
        TextField notes_field2=new TextField();
        notes2.setStyle("-fx-font-family: arial;-fx-font-size: 20; ");
        gridpane2.add(notes2,0,6);
        gridpane2.add(notes_field2,1,6);
        Button btnback=new Button("back");
        HBox hbomod=new HBox(btnupdate,btndelete,btnback);
        hbomod.setSpacing(10);
        gridpane2.add(hbomod,0,7);


        //scene view

        VBox vBoxview=new VBox();

        Label search1=new Label("name of recipe");
        TextField search_field1=new TextField();
        HBox hBox_1=new HBox(search1,search_field1);
        hBox_1.setSpacing(30);


        Label categoryl=new Label("category of recipe");
        TextField category_field1=new TextField();
        HBox hBox_2=new HBox(categoryl,category_field1);
        hBox_2.setSpacing(30);
        vBoxview.setAlignment(Pos.TOP_CENTER);
        vBoxview.setSpacing(30);


        Button displayall=new Button("view ALl");
        Button search_category=new Button("search category");
        Button btnfavourites=new Button("display favourites");
        Button back=new Button("back");
        HBox hbox_3=new HBox(btnsearch,displayall,search_category,btnfavourites,back);
        hbox_3.setSpacing(30);
        vBoxview.getChildren().addAll(hBox_1,hBox_2,hbox_3);

        vBoxview.getChildren().add(table);

        Scene scene3=new Scene(vBoxview);
        //scene 5 new scene
        Button favourite=new Button("add to favourites");
        HBox hBox3=new HBox();
        Label name_recipe=new Label("recipe name:");
        Button back1=new Button("back");
        TextField recipe_field=new TextField();
        hBox3.setPadding(new Insets(40));
        hBox3.setSpacing(20);
        hBox3.getChildren().addAll(name_recipe,recipe_field,favourite,back1);
        Scene scene5=new Scene(hBox3);
        //scenemainpage
        VBox vbox =new VBox();
        vbox.setSpacing(30);
        vbox.setAlignment(Pos.TOP_CENTER);
        GridPane gridPanemain =new GridPane();
        Button b1=new Button("add new recipe");
        Button b2=new Button("recipe modification");
        Button b3=new Button("view recipes");
        Button b5 =new Button("add recipe to favourites");
        Button b6=new Button("export recipes");

        gridPanemain.add(b1,0,0);
        gridPanemain.add(b2,1,0);
        gridPanemain.add(b3,0,1);
        gridPanemain.add(b5,1,1);
        b1.setPadding(new Insets(20));

        Scene scene2 = new Scene(gridPane);

        vbox.getChildren().addAll(btnconnect,gridPanemain,b6);
        btnconnect.setPrefSize(150,50);
        b1.setPrefSize(150,50);
        b2.setPrefSize(150,50);
        b3.setPrefSize(150,50);
        b5.setPrefSize(150,50);
        b6.setPrefSize(150,50);
        gridPanemain.setHgap(40);
        gridPanemain.setVgap(55);
        gridPanemain.setAlignment(Pos.TOP_CENTER);
        Scene scene1=new Scene(vbox);
        Scene scenec=new Scene(gridpane2);


        vbox.setPrefSize(500,450);
        btnconnect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {

                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "12345");
                    myStatement = connect.createStatement();
                    JOptionPane.showMessageDialog(null,"connection successful");
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null,"Unable to Connect");

                }
            }
        });
        btnback.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(scene1);
            }
        });
        favourite.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String favouriteval=recipe_field.getText();
                String favouritequery="UPDATE recipe_managment_system.recipe SET favourites= '" + 1 +  "' WHERE title like '%" + favouriteval+ "%'";
                int rowsUpdated = 0;
                try {
                    rowsUpdated = myStatement.executeUpdate(favouritequery);
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(null, "Recipe updated successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Recipe not found");
                    }
                    // Clear the text fields
                    textField.clear();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                stage.setScene(scenec);
            }
        });
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                b3.getScene();
                stage.setScene(scene3);
            }
        });
        search_category.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data.clear();
                String categoryval=category_field1.getText();

                String displayQuery = "SELECT * FROM recipe_managment_system.recipe  WHERE category LIKE '%" + categoryval+ "%'";
                try {
                    ResultSet myResult = myStatement.executeQuery(displayQuery);
                    while (myResult.next()) {
                        String rName = myResult.getString("title");
                        String ringredients = myResult.getString("ingredients");
                        String rinstructions = myResult.getString("instructions");
                        int rtime=myResult.getInt("cooking_time");
                        String rservingsize = myResult.getString("serving_size");
                        String rnotes = myResult.getString("notes");
                        String rcategory = myResult.getString("category");
                        data.add(new recipeDatabase(rName,ringredients,rinstructions,rtime,rservingsize,rnotes,rcategory));
                        table.setItems(data);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Cannot query Server\n" + e);

            }
        }});
        back2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(scene1);
            }
        });
        btnfavourites.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data.clear();

                String displayQuery = "SELECT * FROM recipe_managment_system.recipe where favourites = '" + 1 + "'";
                try {
                    ResultSet myResult = myStatement.executeQuery(displayQuery);
                    while (myResult.next()) {
                        String rName = myResult.getString("title");
                        String ringredients = myResult.getString("ingredients");
                        String rinstructions = myResult.getString("instructions");
                        int rtime=myResult.getInt("cooking_time");
                        String rservingsize = myResult.getString("serving_size");
                        String rnotes = myResult.getString("notes");
                        String rcategory = myResult.getString("category");
                        data.add(new recipeDatabase(rName,ringredients,rinstructions,rtime,rservingsize,rnotes));
                        table.setItems(data);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Cannot query Server\n" + e);
                }

            }
        });
        displayall.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data.clear();

                String displayQuery = "select * from recipe_managment_system.recipe";
                try {
                    ResultSet myResult = myStatement.executeQuery(displayQuery);
                    while (myResult.next()) {
                        String rName = myResult.getString("title");
                        String ringredients = myResult.getString("ingredients");
                        String rinstructions = myResult.getString("instructions");
                        int rtime=myResult.getInt("cooking_time");
                        String rservingsize = myResult.getString("serving_size");
                        String rnotes = myResult.getString("notes");
                        String rcategory = myResult.getString("category");
                        data.add(new recipeDatabase(rName,ringredients,rinstructions,rtime,rservingsize,rnotes,rcategory));
                        table.setItems(data);

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Cannot query Server\n" + e);
                }
            }
        });

        btnsearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data.clear();
                String searchval=search_field1.getText();
                String searchQuery = "SELECT * FROM recipe_managment_system.recipe WHERE title LIKE '%" + searchval+ "%'";
                try {
                    ResultSet myResult = myStatement.executeQuery(searchQuery);
                    while (myResult.next()) {
                        String rName = myResult.getString("title");
                        String ringredients = myResult.getString("ingredients");
                        String rinstructions = myResult.getString("instructions");
                        int rtime=myResult.getInt("cooking_time");
                        String rservingsize = myResult.getString("serving_size");
                        String rnotes = myResult.getString("notes");
                        String rcategory = myResult.getString("category");
                        data.add(new recipeDatabase(rName,ringredients,rinstructions,rtime,rservingsize,rnotes,rcategory));
                        table.setItems(data);
                       }
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Cannot query Server\n" + e);
                }
            }
        });
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                String title = title_field.getText();
                String ingredients = ingredients_field.getText();
                String instructions = instructions_field.getText();
                int cooking_time = Integer.parseInt(cookingtime_field.getText());
                String servingsize = servingsize_field.getText();
                String notes = notes_field.getText();
                String category=category_field.getText();
                String insertQuery= "INSERT INTO recipe_managment_system.recipe (title, ingredients, instructions, cooking_time, serving_size, notes,category) VALUES ('" + title + "', '" + ingredients + "', '" + instructions + "', " + cooking_time + ", '" + servingsize + "', '" + notes +"', '"+ category+"')";
                myStatement.executeUpdate(insertQuery);

                // Display a success message

                JOptionPane.showMessageDialog(null, "recipe record added to database");

                // Clear the text fields

                title_field.clear();
                ingredients_field.clear();
                ingredients_field.clear();
                cookingtime_field.clear();
                servingsize_field.clear();
                notes_field.clear();
                category_field.clear();

            }
                catch (Exception e)
            {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null,"Unable to add into database");
            }
            }
        });
        btndelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String title_delete=change_field.getText();
                try {
                    String deleteQuery = "DELETE FROM recipe_managment_system.recipe WHERE title = '" + title_delete + "'";
                    int rows=myStatement.executeUpdate(deleteQuery);
                    if(rows>0)
                    {
                        JOptionPane.showMessageDialog(null, "Recipe deleted successfully");
                    }
                    else JOptionPane.showMessageDialog(null, "Recipe not found");
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null,"Unable to delete");
                }
            }
        });
        b5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                b5.getScene();
                stage.setScene(scene5);
                stage.setTitle("");
            }
        });
        btnupdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String titlechange =change_field.getText();
                String title = title_field.getText();
                String ingredients = ingredients_field.getText();
                String instructions = instructions_field.getText();
                int cooking_time = Integer.parseInt(cookingtime_field.getText());
                String serving_size = servingsize_field.getText();
                String notes = notes_field.getText();
                String category=category_field.getText();

                try {
                    String updateQuery = "UPDATE recipe_managment_system.recipe SET title = '" + title + "', ingredients = '" + ingredients + "', instructions = '" + instructions + "', cooking_time = " + cooking_time + ", serving_size = '" + serving_size + "', notes = '" + notes + "', category = '"+category+ "' WHERE title = '" + titlechange + "'";
                    int rowsUpdated = myStatement.executeUpdate(updateQuery);

                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(null, "Recipe updated successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Recipe not found");
                    }
                    // Clear the text fields
                    textField.clear();
                    title_field.clear();
                    ingredients_field.clear();
                    instructions_field.clear();
                    cookingtime_field.clear();
                    servingsize_field.clear();
                    notes_field.clear();
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Unable to update recipe");
                }
            }

        });
        back1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(scene1);
            }
        });
        b6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    PrintWriter printWriter= new PrintWriter(new File("C:\\Users\\User\\Desktop\\csv files\\recipe_table.csv"));
                    StringBuilder stringBuilder=new StringBuilder();
                    String query="select * from recipe_managment_system.recipe";
                    ResultSet rs=null;
                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "12345");
                    PreparedStatement preparedStatement=connect.prepareStatement(query);
                    rs=preparedStatement.executeQuery();
                    while(rs.next())
                    {
                        stringBuilder.append(rs.getString("title"));
                        stringBuilder.append(",");
                        stringBuilder.append(rs.getString("ingredients"));
                        stringBuilder.append(",");
                        stringBuilder.append(rs.getString("instructions"));
                        stringBuilder.append(",");
                        stringBuilder.append(rs.getString("cooking_time"));
                        stringBuilder.append(",");
                        stringBuilder.append(rs.getString("serving_size"));
                        stringBuilder.append(",");
                        stringBuilder.append(rs.getString("notes"));
                        stringBuilder.append(",");
                        stringBuilder.append(rs.getString("category"));
                        stringBuilder.append("\r\n");
                    }
                    printWriter.write(stringBuilder.toString());
                    printWriter.close();
                    JOptionPane.showMessageDialog(null,"finished");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(scene1);

            }
        });
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                    stage.setScene(scene2);
                    stage.setTitle("adding recipe");
            }
        });

        stage.setScene(scene1);
        scene1.getStylesheets().add("background.css");
        stage.setTitle("Recipe System");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
