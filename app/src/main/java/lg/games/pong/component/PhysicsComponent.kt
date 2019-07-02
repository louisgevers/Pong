package lg.games.pong.component

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
        if (x + dx - board.paddle.coordinate.x in -board.paddle.width/2..board.paddle.width/2 &&
                y + dy - board.paddle.coordinate.y in -board.paddle.height/2..board.paddle.height/2) {
            vector.dy = -vector.dy
        }
        obj.coordinate.x += vector.dx
        obj.coordinate.y += vector.dy
    }
}