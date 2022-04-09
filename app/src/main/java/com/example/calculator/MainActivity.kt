package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        Numbers
         */

        buttonOne.setOnClickListener{
            evaluateExpression("1", clear = true)
        }

        buttonTwo.setOnClickListener{
            evaluateExpression("2", clear = true)
        }

        buttonThree.setOnClickListener {
            evaluateExpression("3", clear = true)
        }

        buttonFour.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        buttonFive.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        buttonSix.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        buttonSeven.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        buttonEight.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        buttonNine.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        buttonZero.setOnClickListener {
            evaluateExpression("0", clear = true)
        }

        buttonDot.setOnClickListener {
            evaluateExpression(".", clear = true)
        }

        /*
        Operations
         */

        buttonAdd.setOnClickListener {
            evaluateExpression("+", clear = false)
        }

        buttonMinus.setOnClickListener {
            evaluateExpression("-", clear = false)
        }

        buttonMultiply.setOnClickListener {
            evaluateExpression("*", clear = false)
        }

        buttonDivide.setOnClickListener {
            evaluateExpression("/", clear = false)
        }

        buttonOpenningBracket.setOnClickListener {
            evaluateExpression("(", clear = false)
        }

        buttonClosingBracket.setOnClickListener {
            evaluateExpression(")", clear = false)
        }

        buttonClear.setOnClickListener {
            viewExpression.text = ""
            viewResult.text = ""
        }
        
        buttonEqual.setOnClickListener {
            try {
                val text = viewExpression.text.toString()
                val expression = ExpressionBuilder(text).build()
                val result = expression.evaluate()
                val longResult = result.toLong()

                if(result == longResult.toDouble()){
                    viewResult.text = longResult.toString()
                }
                else{
                    viewResult.text = result.toString()
                }
            }
            catch(e : Exception){
                Log.d("Exception","message : "+ e.message)
            }
        }
        
        buttonBack.setOnClickListener { 
            val text = viewExpression.text.toString()
            if (text.isNotEmpty()){
                viewExpression.text = text.substring(0, text.length-1)
            }
            viewResult.text = ""
        }

    }

    private fun evaluateExpression(string: String, clear: Boolean) {

        if(viewResult.text.isNotEmpty()){
            viewExpression.text = ""
        }
        if(clear) {
            viewResult.text = ""
            viewExpression.append(string)
        } else {
            viewExpression.append(viewResult.text)
            viewExpression.append(string)
            viewResult.text = ""
        }
    }
}