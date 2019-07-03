package lg.games.pong.entity

import android.graphics.Canvas
import android.view.MotionEvent
import lg.games.pong.component.Point
import java.util.*

class Board(width: Int, height: Int) {

    /**
     * Represents the first corner of the board.
     */
    val point0 = Point(0, 0)

    /**
     * Represents the second corner of the board.
     */
    val point1 = Point(width, height)

    /**
     * Represents the ball object on the board.
     */
    val ball = Ball(Point(width / 2, height / 2))

    /**
     * Represents the player's paddle object on the board.
     */
    val paddle = Player(
        Point(width / 2, 9 * height / 10),
        width / 8,
        height / 128
    )

    /**
     * Represents the ai's paddle object on the board.
     */
    val ai = AI(
        Point(width / 2, height / 10),
        width / 8,
        height / 128)

    /**
     * Update the components with input events.
     */
    fun updateInput(events: LinkedList<MotionEvent>) {
        for (event in events) {
            paddle.updateInput(event)
        }
    }

    /**
     * Update the physics of the components.
     */
    fun updatePhysics() {
        ball.updatePhysics(this)
        ai.updateAI(this)
    }

    /**
     * Update the graphics of the components on the [canvas].
     */
    fun updateGraphics(canvas: Canvas) {
        ball.updateGraphics(canvas)
        paddle.updateGraphics(canvas)
        ai.updateGraphics(canvas)
    }

}