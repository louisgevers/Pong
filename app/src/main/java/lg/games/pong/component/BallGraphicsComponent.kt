package lg.games.pong.component

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

/**
 * This class is a [GraphicsComponent] for the [Ball] object. It is responsible
 * to draw the ball on the canvas.
 */
class BallGraphicsComponent(private val radius: Int) : GraphicsComponent {

    /**
     * Paint object to use to color the ball.
     */
    private val paint: Paint = Paint()

    /**
     * Initialize the used paint object.
     */
    init {
        paint.color = Color.WHITE
    }

    /**
     * Draw a circle for the given game object on the canvas.
     */
    override fun update(obj: GameObject, canvas: Canvas) {
        canvas.drawCircle(
            obj.coordinate.x.toFloat(),
            obj.coordinate.y.toFloat(),
            radius.toFloat(),
            paint)
    }

}