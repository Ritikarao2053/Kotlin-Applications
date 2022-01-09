package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var inputBox: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputBox = findViewById(R.id.inputBox)
    }

    var dot: Boolean = false
    var newOp: Boolean = true

    fun getNumbers(view: View){

        if(newOp){
            inputBox.text = ""
        }
        newOp = false

        var getText: String = inputBox.text.toString()
        val selectedBtn = view as Button

        when(selectedBtn.id){
            R.id.btn0->{
                getText+="0"
            }
            R.id.btn1->{
                getText+="1"
            }
            R.id.btn2->{
                getText+="2"
            }
            R.id.btn3->{
                getText+="3"
            }
            R.id.btn4->{
                getText+="4"
            }
            R.id.btn5->{
                getText+="5"
            }
            R.id.btn6->{
                getText+="6"
            }
            R.id.btn7->{
                getText+="7"
            }
            R.id.btn8->{
                getText+="8"
            }
            R.id.btn9->{
                getText+="9"
            }
            R.id.btndot->{
                if(!dot) {
                    getText += "."
                }
                dot = true
            }
        }

        inputBox.text = getText
    }


    var operator: String = "X"
    var oldNum:String=""

    fun getOperators(view: View){

        val selectedOp = view as Button

        when(selectedOp.id){
            R.id.btnplus->{
                operator = "+"
            }
            R.id.btnminus->{
                operator = "-"
            }
            R.id.btnmultiply->{
                operator = "x"
            }
            R.id.btndivide->{
                operator = "/"
            }
            R.id.btnpercent->{
                operator = "%"
            }
            R.id.btnpower->{
                operator = "^"
            }
        }

        oldNum = inputBox.text.toString()
        dot = false
        newOp = true
    }

    fun equalOperator(view: View){

        val newNum = inputBox.text.toString()
        var result: Double? = null
        var res: Int = 1

        var new: Int = newNum.toInt()
        var old: Int = oldNum.toInt()

        when(operator){
            "x"->{
                result = oldNum.toDouble() * newNum.toDouble()
            }
            "+"->{
                result = oldNum.toDouble() + newNum.toDouble()
            }
            "-"->{
                result = oldNum.toDouble() - newNum.toDouble()
            }
            "/"->{
                result = oldNum.toDouble() / newNum.toDouble()
            }
            "%"->{
                result = oldNum.toDouble() % newNum.toDouble()
            }
            "^"->{
                while(new != 0) {
                    res *= old
                    --new
                }
                result = res.toDouble()
            }
        }

        inputBox.text = result.toString()
    }

    fun cleanInput(view: View){
        inputBox.text = ""
        newOp = true
        dot = false
    }
}
