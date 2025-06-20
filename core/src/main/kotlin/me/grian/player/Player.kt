package me.grian.player

import com.badlogic.gdx.Gdx
import me.grian.Main
import me.grian.network.NetworkManager
import me.grian.network.packets.c2s.C2SMovePacket

class Player(
    var x: Float,
    var y: Float,
    var realX: Float,
    var realY: Float,
    var name: String
) {
    fun move(x: Float, y: Float) {
        this.x = x.coerceIn(0.0f, (Gdx.graphics.width / Main.tileSize) - 1)
        this.y = y.coerceIn(0.0f, (Gdx.graphics.height / Main.tileSize) - 1)

        NetworkManager.sendPacket(
            C2SMovePacket(x.toInt(), y.toInt())
        )

        realX = this.x * Main.tileSize
        realY = this.y * Main.tileSize
    }
}
