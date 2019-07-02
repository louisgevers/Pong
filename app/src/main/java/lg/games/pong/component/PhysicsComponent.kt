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
        if (collideWall(obj.coordinate.x, vector.dx, board.point0.x, board.point1.x)) {
            vector.dx = -vector.dx
        }
        if (collideWall(obj.coordinate.y, vector.dy, board.point0.y, board.point1.y)) {
            vector.dy = -vector.dy
        }
        obj.coordinate.x += vector.dx
        obj.coordinate.y += vector.dy
    }

    /**
     * Checks whether the given position and speed collides with the borders.
     */
    private fun collideWall(x: Int, dx: Int, x0: Int, x1: Int): Boolean {
        return (x - radius + dx < x0 || x + radius + dx > x1)
    }

}