package lg.games.pong.entity

import android.view.MotionEvent
import lg.games.pong.component.InputComponent
import lg.games.pong.component.Point

/**
 * This class represents the paddle object of the player. It follows the
 * touch of the user on the screen and collides with the [Ball].
 */
class Player(initialPoint: Point, width: Int, height: Int) : Paddle(initialPoint, width, height, Position.BOTTOM) {

    /**
     * Component responsible to process user input.
     */
    private val eventComponent = InputComponent()

    /**
     * Update the paddle with given event.
     */
    fun updateInput(event: MotionEvent) {
        eventComponent.update(this, event)
    }

}