package lg.games.pong.game

import android.content.Context
import android.graphics.Canvas
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import lg.games.pong.component.Board

/**
 * This class holds the view over the game.
 */
class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback {

    /**
     * Main thread running the game.
     */
    private val thread: GameThread

    /**
     * Board holding the components of the game.
     */
    private lateinit var board: Board

    /**
     * Add the class to the callback in order to intercept events.
     */
    init {
        holder.addCallback(this)
        thread = GameThread(holder, this)
    }

    /**
     * Called after any structural changes have been made to the view.
     */
    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

    }

    /**
     * Called before the view gets destroyed. Stops the [thread] from running.
     */
    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        var retry = true
        while (retry) {
            try {
                thread.running = false
                thread.join()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            retry = false
        }
    }

    /**
     * Called after the view is created. Starts the [thread].
     */
    override fun surfaceCreated(holder: SurfaceHolder?) {
        board = Board(width, height)
        thread.running = true
        thread.start()
    }

    /**
     * Updates the inputs and physics of the game.
     */
    fun update() {
        if (this::board.isInitialized) {
            board.updateInput()
            board.updatePhysics()
        }
    }

    /**
     * Draws the current game frame on the canvas.
     */
    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        if (this::board.isInitialized) {
            board.updateGraphics(canvas)
        }
    }

}
