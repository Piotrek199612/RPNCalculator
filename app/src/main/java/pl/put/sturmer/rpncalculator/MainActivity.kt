package pl.put.sturmer.rpncalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var calc :RPNCalculator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calc = RPNCalculator(Edit)
    }

    private fun PrintStack()
    {
        val values = calc.StackToString()
        FirstStack.text = values[0]
        SecondStack.text = values[1]
        ThirdStack.text = values[2]
        FourthStack.text = values[3]
    }

    fun AddOnClick(v:View)
    {
        calc.Add()
        PrintStack()
    }

    fun SubtractOnClick(v:View)
    {
        calc.Subtract()
        PrintStack()
    }

    fun MultiplyOnClick(v:View)
    {
        calc.Multiply()
        PrintStack()
    }

    fun DivideOnClick(v:View)
    {
        calc.Divide()
        PrintStack()
    }

    fun ExponentialOnClick(v:View)
    {
        calc.Exponentiation()
        PrintStack()
    }
    fun SqrtOnClick(v:View)
    {
        calc.Sqrt()
        PrintStack()
    }

    fun DropOnClick(v:View)
    {
        calc.Drop()
        PrintStack()
    }

    fun SwapOnClick(v:View)
    {
        calc.Swap()
        PrintStack()
    }

    fun EnterOnClick(v:View)
    {
        calc.AddToStack()
        PrintStack()
    }

    fun BackOnClick(v:View)
    {
        calc.Back()
        PrintStack()
    }
    fun ACOnClick(v:View)
    {
        calc.AllClear()
        PrintStack()
    }

    fun ZeroOnClick(v:View)
    {
        calc.Zero()
        PrintStack()
    }

    fun OneOnClick(v:View)
    {
        calc.One()
        PrintStack()
    }
    fun TwoOnClick(v:View)
    {
        calc.Two()
        PrintStack()
    }
    fun ThreeOnClick(v:View)
    {
        calc.Three()
        PrintStack()
    }
    fun FourOnClick(v:View)
    {
        calc.Four()
        PrintStack()
    }
    fun FiveOnClick(v:View)
    {
        calc.Five()
        PrintStack()
    }
    fun SixOnClick(v:View)
    {
        calc.Six()
        PrintStack()
    }
    fun SevenOnClick(v:View)
    {
        calc.Seven()
        PrintStack()
    }
    fun EightOnClick(v:View)
    {
        calc.Eight()
        PrintStack()
    }
    fun NineOnClick(v:View)
    {
        calc.Nine()
        PrintStack()
    }
    fun DotOnClick(v:View)
    {
        calc.Dot()
        PrintStack()
    }

    fun SignOnClick(v:View)
    {
        calc.Sign()
    }
}
