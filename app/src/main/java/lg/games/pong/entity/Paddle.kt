package lg.games.pong.entity

import lg.games.pong.component.PaddleGraphicsComponent
import lg.games.pong.component.Point

/**
 * This class represents a single paddle on the board. This can be then used to implement
 * a [Player] or an [AI].
 */
abstract class Paddle(initialPoint: Point, val width: Int, val height: Int, val position: Position) : GameObject(initialPoint) {

    /**
     * Component responsible to render the paddle.
     */
    override val graphicsComponent = PaddleGraphicsComponent(width, height)

    /**
     * Relative position of the paddle on the board.
     */
    enum class Position {
        TOP,
        BOTTOM
    }

}