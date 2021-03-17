package com.javarush.games.racer.road;

import com.javarush.engine.cell.Game;
import com.javarush.games.racer.RacerGame;

import java.util.ArrayList;
import java.util.List;

public class RoadManager {
    public final static int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
    public final static int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;
    private final static int FIRST_LANE_POSITION = 16;
    private final static int FOURTH_LANE_POSITION = 44;
    private List<RoadObject> items = new ArrayList<>();


    private RoadObject createRoadObject(RoadObjectType type, int x, int y){

        if (type.equals(RoadObjectType.THORN)) {
            return new Thorn(x,y);
        }
        return  null;
    }

    private void addRoadObject(RoadObjectType roadObjectType, Game game){
        int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
        int y = -1 * RoadObject.getHeight(roadObjectType);
        RoadObject obj   = createRoadObject(roadObjectType, x, y);
        if (obj != null) items.add(obj);
    }
}
