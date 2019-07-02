package lg.games.pong.game

import android.app.Activity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager

/**
 * This class is the main activity used by the application. It contains
 * the [GameView] to display the game.
 */
class MainActivity : Activity() {

    /**
     * Creates the activity by making it full screen and hiding the
     * notifications bar.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(GameView(this))
    }
}
