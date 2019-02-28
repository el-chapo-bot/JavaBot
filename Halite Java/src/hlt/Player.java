package hlt;

import java.util.LinkedHashMap;
import java.util.Map;

public class Player {
    public final PlayerId id;
    public final Shipyard shipyard;
    public int halite;
    public final Map<EntityId, Ship> ships = new LinkedHashMap<>();
    public final Map<EntityId, Dropoff> dropoffs = new LinkedHashMap<>();

    public Map<EntityId, ShipAction> shipsAction = new LinkedHashMap<>();
    
    /**
     * shipsTarget trebuie sa aiba valori unice pentru fiecare vapor in afara
     * de cele care merg la un dropoff, de aceea trebuie sters la fiecare inceput de tura
     * si refacut cu functia shipBestTarget in functie si de shipsAction.
     */
    public Map<EntityId, Position> shipsTarget = new LinkedHashMap<>();
    
    private Player(final PlayerId id, final Shipyard shipyard) {
        this.id = id;
        this.shipyard = shipyard;
    }

    /**
     * TODO
     * 
     * functia calculeaza in functie de harta cu halite si pozitia pe harta a vaporului cu
     * id-ul shipId noile valori pentru shipsTarget.
     * 
     * @param shipId
     * @param cells
     */
    public void shipBestTarget(EntityId shipId, MapCell[][] cells) {
		
    }
    
    void _update(final int numShips, final int numDropoffs, final int halite) {
        this.halite = halite;

        ships.clear();
        for (int i = 0; i < numShips; ++i) {
            final Ship ship = Ship._generate(id);
            ships.put(ship.id, ship);
        }

        dropoffs.clear();
        for (int i = 0; i < numDropoffs; ++i) {
            final Dropoff dropoff = Dropoff._generate(id);
            dropoffs.put(dropoff.id, dropoff);
        }
    }

    static Player _generate() {
        final Input input = Input.readInput();

        final PlayerId playerId = new PlayerId(input.getInt());
        final int shipyard_x = input.getInt();
        final int shipyard_y = input.getInt();

        return new Player(playerId, new Shipyard(playerId, new Position(shipyard_x, shipyard_y)));
    }
}
