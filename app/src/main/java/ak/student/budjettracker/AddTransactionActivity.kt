package ak.student.budjettracker

import android.content.pm.LabeledIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_add_transaction.*

class AddTransactionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_transaction)

        labelInput.addTextChangedListener {
            if(it!!.count()>0)
                labelLayout.error=null
        }
        amountInput.addTextChangedListener {
            if(it!!.count()>0)
                amountLayout.error=null
        }

        addTransactionBtn.setOnClickListener {
            val label:String=labelInput.text.toString()
            val amount:Double?=amountInput.text.toString().toDoubleOrNull()
            if(label.isEmpty())
                labelLayout.error="Please Enter A Valid Label"
            if(amount==null)
                amountLayout.error="Please Enter A valid Amount"

        }
        closeBtn.setOnClickListener {
            finish()
        }
    }
}