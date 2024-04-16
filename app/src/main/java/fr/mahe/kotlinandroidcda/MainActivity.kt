package fr.mahe.kotlinandroidcda

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
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nameText = findViewById<EditText>(R.id.nameText)
        val jobText = findViewById<EditText>(R.id.jobText)
        val companyText = findViewById<EditText>(R.id.companyText)

        val validateButton = findViewById<Button>(R.id.mainToSecondButton)
        validateButton.setOnClickListener {

            Log.i(this.localClassName,"Button clicked")

            val intent = Intent(this, SecondActivity::class.java)
            intent.action = Intent.ACTION_VIEW
            intent.putExtra("name", nameText.text.toString())
            intent.putExtra("job", jobText.text.toString())
            intent.putExtra("company", companyText.text.toString())

            Log.d(this.localClassName,"Data sent : ${intent.extras}")

            startActivity(intent)
        }
    }
}