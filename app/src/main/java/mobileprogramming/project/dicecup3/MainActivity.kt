package mobileprogramming.project.dicecup3

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var rollButton: Button
    lateinit var numDicesSpinner: Spinner
    lateinit var diceGrid: GridLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
    }

    private fun initializeViews() {
        this.rollButton = findViewById(R.id.rollButton)
        this.rollButton.setOnClickListener {
            roll()
        }

        this.numDicesSpinner = findViewById(R.id.dicesSpinner)
        this.numDicesSpinner.onItemSelectedListener = this

        this.diceGrid = findViewById(R.id.diceGridLayout)
    }

    private fun roll() {
        diceGrid.removeAllViews()
        DiceHistory.getLatestRolls().clear()

        val diceList: ArrayList<Dice> = arrayListOf()

        for(i in 1..numDicesSpinner.selectedItem.toString().toInt()) {
            val dice: Dice = Dice(this)
            dice.roll()
            DiceHistory.addDice(dice)
            DiceHistory.getLatestRolls().add(dice)
            diceList.add(dice)

            addDiceToGrid(dice)
        }

        DiceHistory.allDicesList.add(diceList)
    }

    private fun addDiceToGrid(dice: Dice) {
        diceGrid.addView(dice.getImage())
    }

    // Overrides
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        diceGrid.removeAllViews()
        DiceHistory.getLatestRolls().clear()

        for(i in 1..parent?.selectedItem.toString().toInt()) {
            val dice: Dice = Dice(this)
            dice.setImage(6)
            DiceHistory.getLatestRolls().add(dice)
            addDiceToGrid(dice)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        return
    }

    override fun onConfigurationChanged(cfg: Configuration) {
        super.onConfigurationChanged(cfg)

        diceGrid.removeAllViews()

        if (cfg.orientation.equals(Configuration.ORIENTATION_LANDSCAPE)) {
            diceGrid.columnCount = 6
        }
        else if(cfg.orientation.equals(Configuration.ORIENTATION_PORTRAIT)) {
            diceGrid.columnCount = 3
        }

        for(dice in DiceHistory.getLatestRolls())
        {
            dice.getImage().layoutParams = dice.getLayoutParams()
            diceGrid.addView(dice.getImage())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.navigation_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.menuItemHistory -> {
                startActivity(Intent(this@MainActivity, HistoryActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}