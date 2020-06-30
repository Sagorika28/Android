package com.sagorika.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {

    lateinit var txtMessage: TextView
    var msgSent:String? = "No message given"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        txtMessage = findViewById(R.id.txtMessage)

        if(intent != null)
            msgSent = intent.getStringExtra("MessageSent")

        txtMessage.text = msgSent

        title = "Received Message"
    }
}
