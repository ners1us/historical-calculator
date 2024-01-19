package com.example.historicalcalculator

import android.os.Bundle
import android.text.Html
import android.text.Html.FROM_HTML_MODE_COMPACT
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExtraInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extra_info)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = Html.fromHtml(getString(R.string.currency_info), FROM_HTML_MODE_COMPACT)
    }
}
