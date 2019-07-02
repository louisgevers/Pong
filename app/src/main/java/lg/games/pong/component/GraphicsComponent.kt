package lg.games.pong.component

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

/**
 * This interface is responsible for drawing a specified [GameObject]
 * on the canvas.
 */
abstract class GraphicsComponent {

    /**
     * Paint object to use to color the ball.
     */
    val paint: Paint = Paint()

    /**
     * Initialize the used paint object.
     */
    init {
        paint.color = Color.WHITE
    }

    /**
     * Draws the given game object on the canvas.
     */
    abstract fun update(obj: GameObject, canvas: Canvas)

}