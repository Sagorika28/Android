package com.sagorika.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_avengers.*

class AvengersActivity : AppCompatActivity() {
    var titleName: String? = "Avengers"
    lateinit var etMessage: EditText
    lateinit var btnSend: Button
    lateinit var btnLogout: Button

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avengers)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
       titleName = sharedPreferences.getString("Title","The Avengers")

        title = titleName

        etMessage = findViewById(R.id.etMessage)
        btnSend = findViewById(R.id.btnSend)
        btnLogout = findViewById(R.id.btnLogout)

        btnSend.setOnClickListener {
            val msg = etMessage.text.toString()
            val intentToMsg = Intent(this@AvengersActivity,MessageActivity::class.java)
            intentToMsg.putExtra("MessageSent", msg)
            startActivity(intentToMsg)
        }

        btnLogout.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            Toast.makeText(this@AvengersActivity, "You've been logged out successfully", Toast.LENGTH_SHORT).show()
            val intentToLogin = Intent(this@AvengersActivity, LoginActivity::class.java)
            startActivity(intentToLogin)
            finish()
        }

    }
}
