package mobileprogramming.project.dicecup3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val actionbar = supportActionBar
        actionbar?.title = "History"
        actionbar?.setDisplayHomeAsUpEnabled(true)
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