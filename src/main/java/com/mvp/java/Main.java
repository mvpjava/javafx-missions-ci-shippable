package com.mvp.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class Main extends Application {

    protected ConfigurableApplicationContext springContext;
    private Parent rootNode;

    public static void main(final String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        springContext = bootstrapSpringApplicationContext();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
        rootNode = fxmlLoader.load();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(rootNode));
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        springContext.close();
    }
    
        /////////////////////////// PRIVATE ///////////////////////////////////////
    private ConfigurableApplicationContext bootstrapSpringApplicationContext() {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
        String[] args = getParameters().getRaw().stream().toArray(String[]::new);
        builder.headless(false); //needed for TestFX integration testing or eles will get a java.awt.HeadlessException during tests
        return builder.run(args);
    }

}
