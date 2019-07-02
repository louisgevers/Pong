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
     * Update the components with input events.
     */
    fun updateInput() {
        // TODO update input of components
    }

    /**
     * Update the physics of the components.
     */
    fun updatePhysics() {
        // TODO update physics of components
    }

    /**
     * Update the graphics of the components on the [canvas].
     */
    fun updateGraphics(canvas: Canvas) {
        // TODO update graphics of components
    }

}