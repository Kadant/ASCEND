package Battlefield.Terrains;

import Battlefield.Gatherables.VelvenRoot;
import Battlefield.Gatherables.Wood;
import Battlefield.Terrain;

import java.util.List;

public class DenseForest extends Terrain {

    /**
               *   *   *         28
             *   G   *   *       25
           *   T   G   *   T     19
         *   T   T   *   *   T   13
           *   G   G   T   *     8
             *   *   G   *       4
               *   *   *         1
     */

    public DenseForest() {
        super("Dense Forest", Formation.HEXAGON);
        tiles = List.of(plain, plain, plain,
                        plain, bush, plain, plain,
                        plain, tree, bush, plain, tree,
                        plain, tree, tree, plain, plain, tree,
                        plain, bush, bush, tree, plain,
                        plain, plain, bush, plain,
                        plain, plain, plain);
        giveTilesPosition(form);
        gatherable = List.of(new Wood(), new VelvenRoot());
    }

    /*
    @Override
    public boolean isAmbush(){
        if(ambush()) {
            return true;
        } else{
            Random random = new Random();
            return random.nextInt(0, 20) > 2;
        }
    }
     */
}
