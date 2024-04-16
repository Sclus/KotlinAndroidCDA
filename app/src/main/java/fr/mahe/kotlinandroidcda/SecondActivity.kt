package fr.mahe.kotlinandroidcda

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nameText = findViewById<TextView>(R.id.nameVerificationText)
        val jobText = findViewById<TextView>(R.id.jobVerificationText)
        val companyText = findViewById<TextView>(R.id.companyVerificationText)

        val extras: Bundle? = intent.extras
        val name = extras?.getString("name")
        val job = extras?.getString("job")
        val company = extras?.getString("company")

        nameText.text = name
        jobText.text = job
        companyText.text = company

        val validateButton = findViewById<Button>(R.id.secondToThirdButton)
        validateButton.setOnClickListener {

            Log.i(this.localClassName,"Button clicked")

            val intent = Intent(this, ThirdActivity::class.java)

            intent.action = Intent.ACTION_VIEW
            intent.putExtra("name", nameText.text.toString())
            intent.putExtra("job", jobText.text.toString())
            intent.putExtra("company", companyText.text.toString())

            Log.d(this.localClassName,"Data sent : ${intent.extras}")

            startActivity(intent)
        }
    }
}