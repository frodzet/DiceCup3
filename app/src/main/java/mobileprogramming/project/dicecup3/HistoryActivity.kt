package mobileprogramming.project.dicecup3

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.*
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.allViews


class HistoryActivity : AppCompatActivity() {

    private lateinit var dateTextView: TextView
    private lateinit var rollTextView: TextView
    private lateinit var resultsLinearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        createNavigationBar()
        initializeValues()
        addRollData()

        val clearButton: Button = findViewById(R.id.clearButton)
        clearButton.setOnClickListener {
            clearResults()
        }
    }

    private fun clearResults() {
        resultsLinearLayout.allViews.forEach {
                v ->  if(v is TextView)
                    v.text = null
        }
        DiceHistory.allDicesList.clear()
    }

    private fun createNavigationBar() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.title = "History"
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initializeValues() {
        dateTextView = findViewById(R.id.dateTextView)
        rollTextView = findViewById(R.id.rollTextView)
        resultsLinearLayout = findViewById(R.id.resultsLinearLayout)
    }

    private fun addRollData() {
        dateTextView.text = ""
        rollTextView.text = ""

        for(dices in DiceHistory.allDicesList) {
            var str: String = String()
            for(dice in dices) {
                str = dice.getDateTimeOfRoll()
                rollTextView.append(dice.rollResult.toString() + " ")
            }
            dateTextView.append(str + "\n")
            rollTextView.append("\n")
        }
    }



    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        if(hasFocus) {

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}