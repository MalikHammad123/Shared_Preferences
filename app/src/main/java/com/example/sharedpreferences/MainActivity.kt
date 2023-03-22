package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref =getSharedPreferences("shared preference ", Context.MODE_PRIVATE)
        var editor=sharedPref.edit()

        binding.apply {
            btnsave.setOnClickListener {
                val name=etname.text.toString()
                val email=etemail.text.toString()
                editor.apply{
                    putString("name",name)
                    putString("email",email)
                    apply()
                    Toast.makeText(this@MainActivity,"data saved",Toast.LENGTH_SHORT)
                }


            }

             btnload.setOnClickListener {
                 var name=sharedPref.getString("name",null)
                 var email=sharedPref.getString("email",null)
                 tvemail.text=email.toString()
                 tvname.text=name.toString()
                 Toast.makeText(this@MainActivity,"data displayed",Toast.LENGTH_SHORT)

             }



        }



    }
}