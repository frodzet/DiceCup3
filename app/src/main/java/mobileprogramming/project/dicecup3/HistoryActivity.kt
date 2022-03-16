package mobileprogramming.project.dicecup3

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlin.text.StringBuilder


class HistoryActivity : AppCompatActivity() {

    private lateinit var dateTextView: TextView
    private lateinit var rollTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        createNavigationBar()
        initializeValues()
        addRollData()
    }

    private fun createNavigationBar() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.title = "History"
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initializeValues() {
        dateTextView = findViewById(R.id.dateTextView)
        rollTextView = findViewById(R.id.rollTextView)
    }



//    private fun addRollData() {
//        rollTextView.text = ""
//
//        for(str in DiceHistory.getAllRollsAsString()) {
//            rollTextView.append(str)
//        }
//
//    }

    private fun addRollData() {
        rollTextView.text = ""

        for(dices in DiceHistory.allDicesList) {
            for(dice in dices) {
                rollTextView.append(dice.rollResult.toString() + " ")
            }
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