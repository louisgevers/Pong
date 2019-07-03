package lg.games.pong.entity

import lg.games.pong.component.*

/**
 * This class represents the ball object of the game.
 */
class Ball(initialPoint: Point) : GameObject(initialPoint) {

    /**
     * The radius of the ball.
     */
    private val radius = 20

    /**
     * The component responsible for computing the physics of the
     * ball.
     */
    private val physicsComponent = PhysicsComponent(radius)

    /**
     * The component responsible for rendering the graphics of the
     * ball.
     */
    override val graphicsComponent = BallGraphicsComponent(radius)

    /**
     * Updates the physics component of the ball.
     */
    fun updatePhysics(board: Board) {
        physicsComponent.update(this, board)
    }
}