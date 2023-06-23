package com.WorkshopJava.app;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.util.Map;

public class App extends GameApplication {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("WorkshopJava");
    }
    private Entity player;
    private Entity enemy;
    @Override
    protected void initGame() {
        int pos_x = 30;
        int pos_y = 20;
        player = FXGL.entityBuilder()
                .at(pos_x, pos_y)
                .view(new Rectangle(25, 25, Color.BLUE))
                .buildAndAttach();
        enemy = FXGL.entityBuilder()
                .at(200, 200)
                .view(new Rectangle(25, 25, Color.RED))
                .buildAndAttach();
        FXGL.getGameWorld().addEntityFactory(new Factory());
        FXGL.spawn("enemy");
    }

    @Override
    protected void initInput() {
        FXGL.onKey(KeyCode.D, () -> {
            player.translateX(5); // move right 5 pixels
        });

        FXGL.onKey(KeyCode.Q, () -> {
            player.translateX(-5); // move left 5 pixels
        });

        FXGL.onKey(KeyCode.Z, () -> {
            player.translateY(-5); // move up 5 pixels
        });

        FXGL.onKey(KeyCode.S, () -> {
            player.translateY(5); // move down 5 pixels
        });
    }
}

public class Factory implements EntityFactory {
    @Spawns("enemy")
    public Entity newEnemy(SpawnData data) {

        return FXGL.entityBuilder(data)
                .view("...")
                .build();
    }
}