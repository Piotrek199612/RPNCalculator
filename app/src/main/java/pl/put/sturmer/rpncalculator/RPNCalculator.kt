package pl.put.sturmer.rpncalculator
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.sqrt
import java.lang.Math.pow
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Piotrek on 24.03.2018.
 */

class RPNCalculator() {
    private val _stack = Stack<Double>()
    private lateinit var _edit :TextView
    private var _isResult = false
    constructor (edit: TextView) : this() {
        _stack.clear()
        Log.e("error",edit.toString())
        _edit = edit
        _edit.text = ""
    }

    public fun Back()
    {
        if (_edit.length() > 0)
            _edit.text = _edit.text.subSequence(0,_edit.text.length-1)
    }
    private fun GetValueFromEdit():Double
    {
        val input : Double
        try {
            input = _edit.text.toString().toDouble()
        }
        catch (e: NumberFormatException)
        {
            //ToDo MAKE TOAST
            Log.e("Cannot Parse","ERROR")
            return 0.0
        }
        return input
    }

    public fun AddToStack()
    {
        _stack.push(GetValueFromEdit())
        _edit.text = ""
        _isResult = false
    }

    public fun StackToString():ArrayList<String>
    {
        val list = ArrayList<String>()
        list.add("0")
        list.add("0")
        list.add("0")
        list.add("0")
        if (_stack.size > 0)
            list[0] = _stack[_stack.size-1].toString()
        if (_stack.size > 1)
            list[1] = _stack[_stack.size-2].toString()
        if (_stack.size > 2)
            list[2] = _stack[_stack.size-3].toString()
        if (_stack.size > 3)
            list[3] = _stack[_stack.size-4].toString()
        return list
    }

    public fun Swap()
    {
        if (_stack.isNotEmpty()) {
            val first = _stack.pop()
            _stack.push(GetValueFromEdit())
            _edit.text = first.toString()
        }
    }


    public fun Drop()
    {
        if (_stack.isNotEmpty())
        {
            _stack.pop()
        }
    }

    public fun Enter(value:Double?)
    {
        if (value != null)
        {
            _stack.push(value)
        }
        else
        {
            val tmp = _stack.elementAt(0)
            _stack.push(tmp)
        }
    }

    public fun AllClear()
    {
        _stack.clear()
        _edit.text = "0"
    }

    public fun ChangeSign()
    {
        val tmp = _stack.pop()
        _stack.push(-tmp)
    }

    public fun Add()
    {
        if (_stack.isNotEmpty()) {
            val first = _stack.pop()
            val second = GetValueFromEdit()
            _edit.text = (first+second).toString()
            _isResult = true
        }
    }

    private fun IfIsResult()
    {
        if (_isResult)
        {
            _stack.push(GetValueFromEdit())
            _edit.text = ""
            _isResult = false
        }
    }

    public fun Subtract()
    {
        if (_stack.isNotEmpty()) {
            val first = _stack.pop()
            val second = GetValueFromEdit()
            _edit.text = (first-second).toString()
            _isResult = true
        }
    }

    public fun Multiply()
    {
        if (_stack.isNotEmpty()) {
            val first = _stack.pop()
            val second = GetValueFromEdit()
            _edit.text = (first*second).toString()
            _isResult = true
        }
    }

    public fun Divide()
    {
        if (_stack.isNotEmpty()) {
            val first = _stack.pop()
            val second = GetValueFromEdit()
            _edit.text = (first/second).toString()
            _isResult = true
        }
    }

    public fun Sqrt()
    {
        val first = GetValueFromEdit()
        _edit.text = (sqrt(first)).toString()
        _isResult = true
    }

    public fun Exponentiation()
    {
        if (_stack.isNotEmpty()) {
            val first = _stack.pop()
            val second = GetValueFromEdit()
            _edit.text = (pow(first,second)).toString()
            _isResult = true
        }
    }

    public fun Zero()
    {
        IfIsResult()
        _edit.append("0")
    }

    public fun One()
    {
        IfIsResult()
        _edit.append("1")
    }

    public fun Two()
    {
        IfIsResult()
        _edit.append("2")
    }

    public fun Three()
    {
        IfIsResult()
        _edit.append("3")
    }

    public fun Four()
    {
        IfIsResult()
        _edit.append("4")
    }

    public fun Five()
    {
        IfIsResult()
        _edit.append("5")
    }

    public fun Six()
    {
        IfIsResult()
        _edit.append("6")
    }

    public fun Seven()
    {
        IfIsResult()
        _edit.append("7")
    }

    public fun Eight()
    {
        IfIsResult()
        _edit.append("8")
    }

    public fun Nine()
    {
        IfIsResult()
        _edit.append("9")
    }

    public fun Dot(){
        IfIsResult()
        if (_edit.text.isEmpty())
            _edit.append("0")
        if (!_edit.text.contains('.'))
            _edit.append(".")
    }

    public fun Sign()
    {
        if (_edit.text.startsWith('-'))
            _edit.text = _edit.text.subSequence(1,_edit.text.length)
        else
            _edit.text = "-" + _edit.text
    }
}
