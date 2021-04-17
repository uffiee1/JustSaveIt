package com.uda.justsaveit

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Back Button on ActionBar
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val txtCloth = findViewById<TextView>(R.id.txtClothing)
        txtCloth.text = "100"
        val str1 = txtCloth.text.toString()
        val amount1 = str1.toFloat()

        val txtHouse = findViewById<TextView>(R.id.txtHouse)
        txtHouse.text = "250"
        val str2 = txtHouse.text.toString()
        val amount2 = str2.toFloat()

        val txtPhone = findViewById<TextView>(R.id.txtPhone)
        txtPhone.text = "50"
        val str3 = txtPhone.text.toString()
        val amount3 = str3.toFloat()

        val txtVehicle = findViewById<TextView>(R.id.txtVehicle)
        txtVehicle.text = "200"
        val str4 = txtVehicle.text.toString()
        val amount4 = str4.toFloat()

        val txtGrocery = findViewById<TextView>(R.id.txtGrocery)
        txtGrocery.text = "50"
        val str5 = txtGrocery.text.toString()
        val amount5 = str5.toFloat()

        // PieChart
        val pieChart = findViewById<PieChart>(R.id.pieChart)
        val spend = ArrayList<PieEntry>()

        spend.add(PieEntry(amount1, "Clothing"))
        spend.add(PieEntry(amount2, "House"))
        spend.add(PieEntry(amount3, "Phone"))
        spend.add(PieEntry(amount4, "Vehicle"))
        spend.add(PieEntry(amount5, "Groceries"))

        val pieDataSet = PieDataSet(spend, "Total Spending: 650 €")
        pieDataSet.setColors(*ColorTemplate.COLORFUL_COLORS)
        pieDataSet.valueTextColor = Color.WHITE
        pieDataSet.valueTextSize = 12f

        val pieData = PieData(pieDataSet)

        pieChart.data = pieData
        pieChart.description.isEnabled = false
        pieChart.centerText = "Spends (€)"
        pieChart.setCenterTextColor(Color.DKGRAY)
        pieChart.animate()

        // Making Reference to the db
        val database = FirebaseDatabase.getInstance()
        var reference = database.getReference("Data Saved in db")

        // Read Data from db
        reference = FirebaseDatabase.getInstance().reference.child("Users").child("YrPyUQxrOSk5rm17LwFD").child("months").child("bNUPKIGZo8oYIXyvyJ2H")
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val s = snapshot.value as String?
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}