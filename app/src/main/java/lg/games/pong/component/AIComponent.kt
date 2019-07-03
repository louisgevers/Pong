package lg.games.pong.component

import lg.games.pong.entity.Board
import lg.games.pong.entity.GameObject

/**
 * Component managing the AI of a [GameObject].
 */
class AIComponent {

    /**
     * Maximum speed of the AI.
     */
    private val maxSpeed = 8

    /**
     * Update the AI's position to follow the ball with its limited speed.
     */
    fun updateAI(obj: GameObject, board: Board) {
        val maxAiSpeed = aiSpeed(board)
        val target = board.ball.coordinate.x - obj.coordinate.x
        obj.coordinate.x += when (target) {
            in -maxAiSpeed..maxAiSpeed -> target
            else -> when {
                target >= 0 -> maxAiSpeed
                else -> -maxAiSpeed
            }
        }
    }

    /**
     * Adapt the speed of the AI depending on whether the ball is on its
     * side of the board or not.
     */
    private fun aiSpeed(board: Board): Int {
        return if (board.ball.coordinate.y < (board.point1.y - board.point0.y)/2) {
            maxSpeed
        } else {
            maxSpeed / 4
        }
    }

}