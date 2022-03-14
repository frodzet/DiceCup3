package mobileprogramming.project.dicecup3

class DiceHistory {
    companion object {
        private val allDices: MutableList<Dice> = mutableListOf()
        private val latestDiceRolls: MutableList<Dice> = mutableListOf()

        fun addDice(dice: Dice) {
            allDices.add(dice)
        }

        fun getAllDices() : MutableList<Dice> {
            return allDices
        }

        fun getLatestRolls() : MutableList<Dice> {
            return latestDiceRolls
        }
    }
}