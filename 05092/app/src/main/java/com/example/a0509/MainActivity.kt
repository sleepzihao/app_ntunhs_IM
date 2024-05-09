package com.example.a0509

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a0509.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    private lateinit var binding:ActivityMainBinding
    private lateinit var mAdapter: RecordAdapter
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.toolbarMain.inflateMenu(R.menu.menu)


            binding.toolbarMain.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.menu_add ->{
                        Log.e(TAG,"Menu_add")

                        true

                    }
                }
     true
                }
        }
            }



