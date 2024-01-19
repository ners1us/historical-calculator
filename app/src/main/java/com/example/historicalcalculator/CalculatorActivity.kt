package com.example.historicalcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonZero: TextView = findViewById(R.id.btn_0)
        val buttonOne: TextView = findViewById(R.id.btn_1)
        val buttonTwo: TextView = findViewById(R.id.btn_2)
        val buttonThree: TextView = findViewById(R.id.btn_3)
        val buttonFour: TextView = findViewById(R.id.btn_4)
        val buttonFive: TextView = findViewById(R.id.btn_5)
        val sixButton: TextView = findViewById(R.id.btn_6)
        val buttonSeven: TextView = findViewById(R.id.btn_7)
        val buttonEight: TextView = findViewById(R.id.btn_8)
        val buttonNine: TextView = findViewById(R.id.btn_9)
        val twentiethCenturyRubleButton: TextView = findViewById(R.id.btn_ruble_20)
        val venLiraButton: TextView = findViewById(R.id.btn_ven_lira)
        val dukatButton: TextView = findViewById(R.id.btn_dukat)
        val florinButton: TextView = findViewById(R.id.btn_florin)
        val acButton: TextView = findViewById(R.id.btn_AC)
        val backButton: TextView = findViewById(R.id.btn_back)
        val equalButton: TextView = findViewById(R.id.btn_equals)
        val dotButton: TextView = findViewById(R.id.btn_dot)
        val sixteenthCenturyRealButton: TextView = findViewById(R.id.btn_16c_real)
        val nineteenthCenturyDollarButton: TextView = findViewById(R.id.btn_19c_dollar)
        val questionMarkButton: TextView = findViewById(R.id.question_mark)
        val mathOperation: TextView = findViewById(R.id.math_operation)
        val resultText: TextView = findViewById(R.id.result_text)

        buttonZero.setOnClickListener{ setText("0") }
        buttonOne.setOnClickListener{ setText("1") }
        buttonTwo.setOnClickListener{ setText("2") }
        buttonThree.setOnClickListener{ setText("3") }
        buttonFour.setOnClickListener{ setText("4") }
        buttonFive.setOnClickListener{ setText("5") }
        sixButton.setOnClickListener{ setText("6") }
        buttonSeven.setOnClickListener{ setText("7") }
        buttonEight.setOnClickListener{ setText("8") }
        buttonNine.setOnClickListener{ setText("9") }

        questionMarkButton.setOnClickListener {
            val intent = Intent(this, ExtraInfoActivity::class.java)
            startActivity(intent)
        }

        florinButton.setOnClickListener {
            if (mathOperation.text.isNotEmpty()) {
                setText("*0.0000524")
            }
        }

        dukatButton.setOnClickListener {
            if (mathOperation.text.isNotEmpty()) {
                setText("*0.0000502")
            }
        }

        dotButton.setOnClickListener {
            setText(".")
        }

        venLiraButton.setOnClickListener {
            if (mathOperation.text.isNotEmpty()) {
                setText("*0.00289")
            }
        }

        twentiethCenturyRubleButton.setOnClickListener {
            if (mathOperation.text.isNotEmpty())   {
                setText("*0.01")
            }
        }

        sixteenthCenturyRealButton.setOnClickListener {
            if (mathOperation.text.isNotEmpty())   {
                setText("*0.2")
            }
        }

        acButton.setOnClickListener {
            mathOperation.text = ""
            resultText.text = ""
        }

        nineteenthCenturyDollarButton.setOnClickListener {
            if (mathOperation.text.isNotEmpty())   {
                setText("*0.00031")
            }
        }

        backButton.setOnClickListener {
            val str = mathOperation.text.toString()
            if (str.isNotEmpty()) {
                mathOperation.text = str.substring(0, str.length - 1)
            }
            resultText.text = ""
        }

        equalButton.setOnClickListener {
            try {
                val exception = ExpressionBuilder(mathOperation.text.toString()).build()
                val result = exception.evaluate()
                val intResult = result.toDouble()
                if (result == intResult) {
                    resultText.text = intResult.toString()
                } else {
                    resultText.text = intResult.toString()
                }
            } catch (e: Exception) {
                Log.d("Error", "${e.message}")
            }
        }
    }

    private fun setText(str: String) {
        val mathOperation: TextView = findViewById(R.id.math_operation)
        val resultText: TextView = findViewById(R.id.result_text)

        if (resultText.text != "") {
            mathOperation.text = resultText.text
            resultText.text = ""
        }

        mathOperation.append(str)
    }
}
