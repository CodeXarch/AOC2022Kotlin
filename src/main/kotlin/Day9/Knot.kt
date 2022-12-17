package Day9

import kotlin.math.abs

class Knot {
	var historyHash: MutableMap<Pair<Long,Long>,Boolean> = mutableMapOf(Pair(0L,0L) to true)
	private var position: Pair<Long,Long> = Pair(0,0)
	var child: Knot? = null
	fun move(direction: Direction) {
		position = when(direction) {
			Direction.U -> position.copy(second = position.second+1)
			Direction.D -> position.copy(second = position.second-1)
			Direction.L -> position.copy(position.first-1)
			Direction.R -> position.copy(position.first+1)
		}
		child?.follow(this)
	}
	fun follow(knot: Knot) {
		if(isTouching(knot.position,this.position)) {
			return
		}
		if(knot.position.second == this.position.second) {
			if(knot.position.first > this.position.first) {
				this.position = this.position.copy(this.position.first+1)
			}
			else {
				this.position = this.position.copy(this.position.first-1)
			}
		}
		else if(knot.position.first == this.position.first) {
			if(knot.position.second > this.position.second) {
				this.position = this.position.copy(second = this.position.second+1)
			}
			else {
				this.position = this.position.copy(second = this.position.second-1)
			}
		}
		else {
			if(knot.position.first > this.position.first) {
				this.position = this.position.copy(this.position.first+1)
			}
			else {
				this.position = this.position.copy(this.position.first-1)
			}
			if(knot.position.second > this.position.second) {
				this.position = this.position.copy(second = this.position.second+1)
			}
			else {
				this.position = this.position.copy(second = this.position.second-1)
			}
		}
		historyHash[position] = true
		child?.follow(this)
	}

	private fun isTouching(headCoordinates: Pair<Long,Long>, tailCoordinates: Pair<Long,Long>): Boolean {
		if(abs(tailCoordinates.first-headCoordinates.first) > 1) {
			return false
		}
		if(abs(tailCoordinates.second-headCoordinates.second) > 1) {
			return false
		}
		return true
	}
}