package mobileprogramming.project.dicecup3

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.setMargins
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

class Dice(var context: Context) {

    var rollResult: Int = 0
    private val image: ImageView = ImageView(context)
    private lateinit var timeOfRoll: String

    val diceImageId = intArrayOf(
        0,
        R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6
    )

    fun roll() : Int {
        val randomRoll: Int = Random.nextInt(1, 7)

        rollResult = randomRoll
        setImage(randomRoll)
        timeOfRoll = LocalDateTime.now().format(DateTimeFormatter.ofPattern("d/M/y H:m:ss"))

        return randomRoll
    }

    fun setImage(numEyes: Int) {
        image.layoutParams = getLayoutParams()
        image.setImageResource(diceImageId[numEyes])
    }

    fun getImage() : ImageView {
        return image
    }

    fun getDateTimeOfRoll() : String {
        return timeOfRoll
    }

    fun getLayoutParams(): LinearLayout.LayoutParams {
        val layout = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layout.setMargins(50)
        layout.width = 300
        layout.height = 300

        return layout
    }
}

