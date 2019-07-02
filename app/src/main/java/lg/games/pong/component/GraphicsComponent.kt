package lg.games.pong.component

import android.graphics.Canvas

/**
 * This interface is responsible for drawing a specified [GameObject]
 * on the canvas.
 */
interface GraphicsComponent {

    /**
     * Draws the given game object on the canvas.
     */
    fun update(obj: GameObject, canvas: Canvas)

}