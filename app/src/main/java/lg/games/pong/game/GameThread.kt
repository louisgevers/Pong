package lg.games.pong.game

import android.graphics.Canvas
import android.view.SurfaceHolder

/**
 * This class represents the main thread of the game. It updates the physics
 * and canvas with a frame rate specified by [targetFPS]. It only performs
 * these updates if [run] is true.
 */
class GameThread(private val holder: SurfaceHolder, private val view: GameView) : Thread() {

    /**
     * The canvas to display the graphics on.
     */
    private var canvas: Canvas? = null

    /**
     * Whether the thread should continue running.
     */
    var running: Boolean = false

    /**
     * Desired frame rate of the game.
     */
    private val targetFPS = 60

    /**
     * For the given frame rate specified by [targetFPS], updates
     * the canvas and physics of the game. Stops running when
     * [running] is set to false.
     */
    override fun run() {
        var startTime: Long
        var timeMillis: Long
        var waitTime: Long
        val targetTime = (1000 / targetFPS).toLong()

        while (running) {
            startTime = System.nanoTime()
            canvas = null

            try {
                canvas = holder.lockCanvas()
                synchronized(holder) {
                    view.update()
                    view.draw(canvas!!)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                if (canvas != null) {
                    try {
                        holder.unlockCanvasAndPost(canvas)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }

            timeMillis = (System.nanoTime() - startTime) / 1000000
            waitTime = targetTime - timeMillis
            if (waitTime > 0) {
                sleep(waitTime)
            }

        }
    }

}