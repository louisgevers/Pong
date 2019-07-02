package lg.games.pong.component

import android.graphics.Canvas

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
    val ball = Ball(Point(width/2, height/2))

    /**
     * Update the components with input events.
     */
    fun updateInput() {
        // TODO update input of components
    }

    /**
     * Update the physics of the components.
     */
    fun updatePhysics() {
        ball.updatePhysics(this)
    }

    /**
     * Update the graphics of the components on the [canvas].
     */
    fun updateGraphics(canvas: Canvas) {
        ball.updateGraphics(canvas)
    }

}