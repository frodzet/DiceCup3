package mobileprogramming.project.dicecup3

import java.util.*

class RollHistory {
    companion object {
        private val allDices: MutableList<Dice> = mutableListOf()

        fun addDice(dice: Dice) {
            allDices.add(dice)
        }

        fun getAllDices() : MutableList<Dice> {
            return allDices
        }
    }
}