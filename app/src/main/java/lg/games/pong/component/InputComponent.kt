package lg.games.pong.component

import android.view.MotionEvent

/**
 * This class is responsible to process user input and update the coordinates
 * of the given [GameObject]. Used to update the player's [Paddle].
 */
class InputComponent {

    fun update(obj: GameObject, event: MotionEvent) {
        obj.coordinate.x = event.x.toInt()
    }

}