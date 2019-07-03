package lg.games.pong.entity

import lg.games.pong.component.*

/**
 * This class represents the AI paddle the player plays against.
 */
class AI(initialPoint: Point, width: Int, height: Int) : Paddle(initialPoint, width, height, Position.TOP) {

    /**
     * Component responsible to manage the AI.
     */
    private val aiComponent = AIComponent()

    /**
     * Update the AI on the given board.
     */
    fun updateAI(board: Board) {
        aiComponent.updateAI(this, board)
    }

}