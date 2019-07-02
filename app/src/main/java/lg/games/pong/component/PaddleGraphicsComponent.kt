package lg.games.pong.component

import android.graphics.Canvas

/**
 * This class is responsible to draw a paddle on the canvas. It does so by drawing
 * a white rectangle of given width and height at the coordinates of the specified
 * [GameObject].
 */
class PaddleGraphicsComponent(private val width: Int, private val height: Int) : GraphicsComponent() {

    /**
     * Draw a rectangle for the given [GameObject] on the given [Canvas].
     */
    override fun update(obj: GameObject, canvas: Canvas) {
        val left = (obj.coordinate.x - width/2).toFloat()
        val top = (obj.coordinate.y - height/2).toFloat()
        val right = (obj.coordinate.x + width/2).toFloat()
        val bottom = (obj.coordinate.y + height/2).toFloat()
        canvas.drawRect(left, top, right, bottom, paint)
    }

}