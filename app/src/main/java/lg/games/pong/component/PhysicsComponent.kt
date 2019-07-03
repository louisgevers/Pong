package lg.games.pong.component

import lg.games.pong.entity.Board
import lg.games.pong.entity.GameObject
import lg.games.pong.entity.Paddle

/**
 * This class is responsible to compute the physics
 * of the [Ball] class. It detects collisions and updates
 * the coordinates and direction of the ball accordingly.
 */
class PhysicsComponent(private val radius: Int) {

    /**
     * Direction vector of the ball in a 2D space.
     */
    private val vector = Vector(10, 10)

    /**
     * Updates the position of the ball with the given direction vector.
     * Checks for collisions and updates the direction vector beforehand.
     */
    fun update(obj: GameObject, board: Board) {
        val x = obj.coordinate.x
        val y = obj.coordinate.y
        val dx = vector.dx
        val dy = vector.dy
        if (x - radius + dx < board.point0.x || x + radius + dx > board.point1.x) {
            vector.dx = -vector.dx
        }
        if (collidesWithPaddle(x, y, dx, dy, board.paddle) || collidesWithPaddle(x, y, dx, dy, board.ai)) {
            vector.dy = -vector.dy
        }
        obj.coordinate.x += vector.dx
        obj.coordinate.y += vector.dy
    }

    /**
     * Check whether the given position and direction collides with the given paddle. A ball
     * can only collide with a paddle on one side of the paddle (so depending whether it is on
     * top or bottom of the board.
     */
    private fun collidesWithPaddle(x: Int, y: Int, dx: Int, dy: Int, paddle: Paddle): Boolean {
        return x + dx - paddle.coordinate.x in -paddle.width/2-radius..paddle.width/2+radius &&
                y + dy - paddle.coordinate.y in -paddle.height/2-radius..paddle.height/2+radius &&
                ((paddle.position == Paddle.Position.TOP && dy < 0) ||
                        (paddle.position == Paddle.Position.BOTTOM && dy > 0))
    }
}