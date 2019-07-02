package lg.games.pong.component

import android.graphics.Canvas

/**
 * This class represents an object in the game with a coordinate
 * and a [GraphicsComponent] used for drawing.
 */
abstract class GameObject(initialPoint: Point) {

    /**
     * Coordinate of the object in a 2D space.
     */
    val coordinate = initialPoint

    /**
     * Component responsible for rendering this object.
     */
    abstract val graphicsComponent: GraphicsComponent

    /**
     * Draws the component on the given [canvas].
     */
    fun updateGraphics(canvas: Canvas) {
        graphicsComponent.update(this, canvas)
    }

}