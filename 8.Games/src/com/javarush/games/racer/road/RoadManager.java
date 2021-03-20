package com.javarush.games.racer.road;

import com.javarush.engine.cell.Game;
import com.javarush.games.racer.PlayerCar;
import com.javarush.games.racer.RacerGame;

import java.util.ArrayList;
import java.util.List;

public class RoadManager {
    public final static int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
    public final static int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;
    private final static int FIRST_LANE_POSITION = 16;
    private final static int FOURTH_LANE_POSITION = 44;
    private List<RoadObject> items = new ArrayList<>();


    private RoadObject createRoadObject(RoadObjectType type, int x, int y) {

        if (type.equals(RoadObjectType.THORN)) {
            return new Thorn(x, y);
        }
        return null;
    }

    private void addRoadObject(RoadObjectType roadObjectType, Game game) {
        int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
        int y = -1 * RoadObject.getHeight(roadObjectType);
        RoadObject obj = createRoadObject(roadObjectType, x, y);
        if (obj != null) items.add(obj);
    }

    public void draw(Game game) {
        for (int i = 0; i < items.size(); i++) {
            items.get(i).draw(game);
        }
    }

    public void move(int boost) {
        for (int i = 0; i < items.size(); i++) {
            items.get(i).move(items.get(i).speed + boost);
        }
        deletePassedItems();
    }

    private boolean isThornExists() {
        boolean flag = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) instanceof Thorn) {
                return true;
            }
        }
        return false;
    }

    private void generateThorn(Game game) {
        int num = game.getRandomNumber(100);
        if (num < 10 && isThornExists() == false) addRoadObject(RoadObjectType.THORN, game);
    }

    public void generateNewRoadObjects(Game game) {
        generateThorn(game);

    }

    private void deletePassedItems() {
        List<RoadObject> itemsCopy = new ArrayList<>(items);
        for (RoadObject item :
                itemsCopy) {
            if (item.y >= RacerGame.HEIGHT) items.remove(item);
        }
    }

    public boolean checkCrush(PlayerCar playerCar) {
        boolean ret = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isCollision(playerCar)) {
                ret = true;
            }
        }

        return ret;
    }
}
