package lg.games.pong.component

import android.view.MotionEvent
import lg.games.pong.entity.GameObject

/**
 * This class is responsible to process user input and update the coordinates
 * of the given [GameObject]. Used to update the player's [Player].
 */
class InputComponent {

    /**
     * Update the players' position according to the input.
     */
    fun update(obj: GameObject, event: MotionEvent) {
        obj.coordinate.x = event.x.toInt()
    }

}