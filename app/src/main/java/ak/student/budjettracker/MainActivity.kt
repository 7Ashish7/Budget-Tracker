package ak.student.budjettracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.DeadObjectException
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.transactions_layout.*

class MainActivity : AppCompatActivity() {
    private lateinit var transactions: ArrayList<Transaction>
    private lateinit var transactionAdapter:TransactionAdapter
    private lateinit var linearlayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        transactions= arrayListOf(
            Transaction("Weekend Budget",400.00),
            Transaction("Bananas",-4.00),
            Transaction("Gasoline",-40.00),
            Transaction("Breakfast",-9.90),
            Transaction("Water Bottles",-4.00),
            Transaction("Suncream",-8.00),
            Transaction("Car Park",-15.00),
        )
          transactionAdapter=TransactionAdapter(transactions)
          linearlayoutManager= LinearLayoutManager(this)

          recycle_view.apply {
               adapter=transactionAdapter
               layoutManager=linearlayoutManager
        }
       updateDashboard()
        addBtn.setOnClickListener {
            val intent=Intent(this,AddTransactionActivity::class.java)
            startActivity(intent)

        }

    }
    private fun updateDashboard(){
        val totalAmount:Double=transactions.map{it.amount}.sum()
        val budgetAmount:Double =transactions.filter { it.amount>0}.map { it.amount }.sum()
        val expenseAmount:Double=totalAmount-budgetAmount
        balance.text="$ %.2f".format(totalAmount)
        budget.text="$ %.2f".format(budgetAmount)
        expense.text="$ %.2f".format(expenseAmount)

    }
}