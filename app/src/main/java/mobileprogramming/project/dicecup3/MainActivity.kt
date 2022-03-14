package mobileprogramming.project.dicecup3

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.allViews
import androidx.core.view.setMargins
import java.lang.StringBuilder
import kotlin.random.Random

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var rollButton: Button
    lateinit var numDicesSpinner: Spinner
    lateinit var diceGrid: GridLayout

    private val latestDiceRolls: MutableList<Dice> = mutableListOf()

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
        latestDiceRolls.clear()

        for(i in 1..numDicesSpinner.selectedItem.toString().toInt()) {
            val dice: Dice = Dice(this)
            dice.roll()
            addDiceToGrid(dice)
            latestDiceRolls.add(dice)
        }
    }

    private fun addDiceToGrid(dice: Dice) {
        diceGrid.addView(dice.getImage())
    }

    // Overrides
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        diceGrid.removeAllViews()
        latestDiceRolls.clear()

        for(i in 1..parent?.selectedItem.toString().toInt()) {
            val dice: Dice = Dice(this)
            dice.setImage(6)
            addDiceToGrid(dice)
            latestDiceRolls.add(dice)
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

        for(v in latestDiceRolls)
        {
            v.getImage().layoutParams = v.getLayoutParams()
            diceGrid.addView(v.getImage())
        }
    }


}