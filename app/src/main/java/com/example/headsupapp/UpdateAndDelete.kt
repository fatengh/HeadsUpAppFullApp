package com.example.headsupapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class UpdateAndDelete : AppCompatActivity() {
    lateinit var dbHlpr: DBHlpr
    private lateinit var btnDelete:Button
    private lateinit var btnUpdate:Button
    private lateinit var edIDDelete:EditText
    private lateinit var edIDUpdate: EditText
    private lateinit var edNameUpdate: EditText
    private lateinit var edTaboo1Update: EditText
    private lateinit var edTaboo2Update: EditText
    private lateinit var edTaboo3Update: EditText
    private lateinit var tvCleb: TextView
    private  var list=ArrayList<Celebrity>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_and_delete)

        tvCleb = findViewById(R.id.tvCleb)
        fetchData()
        edIDDelete = findViewById(R.id.edIDel)
        btnDelete = findViewById(R.id.btnDelete)
        btnUpdate= findViewById(R.id.btnUp)
        edIDUpdate = findViewById(R.id.edUp)
        edNameUpdate = findViewById(R.id.edNameUp)
        edTaboo1Update = findViewById(R.id.edTa1Up)
        edTaboo2Update = findViewById(R.id.edTa2Up)
        edTaboo3Update = findViewById(R.id.edTa3Up)



        btnDelete.setOnClickListener {

                val id = edIDDelete.text.toString().toInt()
                dbHlpr.delete(id)
                fetchData()
                edIDDelete.text.clear()

        }
        btnUpdate.setOnClickListener {

                val id= edIDUpdate.text.toString().toInt()
                val name= edNameUpdate.text.toString()
                val t1=edTaboo1Update.text.toString()
                val t2=edTaboo2Update.text.toString()
                val t3=edTaboo3Update.text.toString()
                dbHlpr.update(id,name,t1,t2,t3)
                fetchData()

                edIDUpdate.text.clear()
                edNameUpdate.text.clear()
                edTaboo1Update.text.clear()
                edTaboo2Update.text.clear()
                edTaboo3Update.text.clear()

        }

    }
    fun fetchData(){
        dbHlpr=DBHlpr(applicationContext)
        list = dbHlpr.retrive()
        dbHlpr= DBHlpr(applicationContext)
        var text=""
        for (i in list){
            text+="\nid: ${i.pk}\n name: ${i.name}\ntaboo1: ${i.taboo1}\n taboo2: ${i.taboo2}\ntaboo3: ${i.taboo3}\n\n\n"
        }
        tvCleb.text = text

    }
}