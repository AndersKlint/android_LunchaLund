package com.cd.lunchalund

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        addCard("Edison", "Green (Veg): Citronbakade morötter med vete, svamp & blomkål\n" +
                "Local: Stekt sill, potatispure, smör & lingon\n" +
                "World Wide: Chiliglacead kalkonstek med jordnötssås, ris & lime")
        addCard("Inspira", "Inspira of the day: Parsley patty with red cabbage salad, cream sauce and roasted potatoes" +
                "\nVegetarian: Indian chickpea casserole with sweat potatoes, curry, cauli flower and basmati rice\n" +
                "Forskarmålet:  North African flavored salmon with hummus-crème, blueberry marinated red cabbage and Bulgur salad")


        fab.setOnClickListener { view ->
          //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
           //     .setAction("Action", null).show()
            addCard("Edison", "Green (Veg): Citronbakade morötter med vete, svamp & blomkål\n" +
                    "Local: Stekt sill, potatispure, smör & lingon\n" +
                    "World Wide: Chiliglacead kalkonstek med jordnötssås, ris & lime")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun addCard(title: String, content: String) {
        val mainLinearLayout = findViewById<LinearLayout>(R.id.menuCardLayout)
        val cardLinearLayout = LinearLayout(this)
        cardLinearLayout.orientation = LinearLayout.VERTICAL
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(16, 16, 16, 16)
        val cardView = CardView(this)
        cardView.radius = 15f
        val rnd = Random()
        val colorDifference = 50
        val colorBrightness = 175
        var color =
            Color.argb(255, rnd.nextInt(colorDifference)+colorBrightness, rnd.nextInt(colorDifference)+colorBrightness, rnd.nextInt(colorDifference)+colorBrightness)
        cardView.setCardBackgroundColor(color)
        cardView.setContentPadding(32, 0, 32, 32)
        cardView.layoutParams = params
        cardView.cardElevation = 6f

        val titleText = TextView(this)
        titleText.text = title
        titleText.textSize = 24f
        titleText.setShadowLayer(5f,2f,2f, Color.BLACK)
        titleText.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD)
        titleText.setTextColor(Color.WHITE)

        val contentText = TextView(this)
        contentText.text = content
        contentText.textSize = 16f
        contentText.setShadowLayer(8f,1.8f,1.5f, Color.BLACK)
        contentText.setTextColor(Color.WHITE)
        contentText.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL)

        cardLinearLayout.addView(titleText)
        cardLinearLayout.addView(contentText)
        cardView.addView(cardLinearLayout)
        mainLinearLayout.addView(cardView)
    }
}
