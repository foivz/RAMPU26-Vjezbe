package hr.foi.rampu.androidtest764321

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gumb = findViewById<Button>(R.id.btnKlikni)
        val etIme = findViewById<EditText>(R.id.etIme)

        gumb.setOnClickListener {
            val intent = Intent(this, AwesomeActivity::class.java)
            intent.putExtra("ime", etIme.text.toString())

            startActivity(intent)
        }
    }
}