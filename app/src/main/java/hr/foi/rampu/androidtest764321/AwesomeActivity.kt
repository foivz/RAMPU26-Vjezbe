package hr.foi.rampu.androidtest764321

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AwesomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_awesome)

        val tvPozdrav = findViewById<TextView>(R.id.tvPozdrav)
        val ime = intent.getStringExtra("ime")

        tvPozdrav.text = "dobar dan $ime"
    }
}