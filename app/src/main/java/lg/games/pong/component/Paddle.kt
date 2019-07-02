package lg.games.pong.component

import android.view.MotionEvent

/**
 * This class represents the paddle object of the player. It follows the
 * touch of the user on the screen and collides with the [Ball].
 */
class Paddle(initialPoint: Point, val width: Int, val height: Int) : GameObject(initialPoint) {

    /**
     * Component responsible to process user input.
     */
    private val eventComponent = InputComponent()

    /**
     * Component responsible to render the paddle on the canvas.
     */
    override val graphicsComponent = PaddleGraphicsComponent(width, height)

    /**
     * Update the paddle with given event.
     */
    fun updateInput(event: MotionEvent) {
        eventComponent.update(this, event)
    }

}