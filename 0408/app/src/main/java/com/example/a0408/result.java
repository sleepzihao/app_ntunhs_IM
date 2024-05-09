package com.example.a0408;



        import android.os.Bundle
        import android.widget.Button
        import android.widget.TextView
        import android.widget.Toast
        import androidx.activity.enableEdgeToEdge
        import androidx.appcompat.app.AppCompatActivity
        import androidx.core.view.ViewCompat
        import androidx.core.view.WindowInsetsCompat

class result : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        insets
        }
        /* ID */
        val id = findViewById<TextView>(R.id.ID)
        val id_text = intent.getBundleExtra("key_id")?.getString("id").toString()
        id.setText("ID: " + id_text)

        /* pwd */
        val pwd = findViewById<TextView>(R.id.pwd)
        val pwd_text = intent.getBundleExtra("key_pwd")?.getString("pwd").toString()
        pwd.setText("pwd: " + pwd_text)

        /* name */
        val name = findViewById<TextView>(R.id.name)
        val name_text = intent.getBundleExtra("key_name")?.getString("name").toString()
        name.setText("Name: " + name_text)

        /* name */
        val birthdate = findViewById<TextView>(R.id.Birthdate)
        val birthdate_text = intent.getBundleExtra("key_birthdate")?.getString("birthdate").toString()
        birthdate.setText("Birthdate: " + birthdate_text)

        /* gender */
        val gender = findViewById<TextView>(R.id.Gender)
        val gender_text = intent.getBundleExtra("key_gender")?.getString("gender").toString()
        gender.setText("Gender: " + gender_text)

        /* vehide */
        val vehide = findViewById<TextView>(R.id.Vehide)
        val vehide_text = intent.getBundleExtra("key_vehide")?.getString("vehide").toString()
        vehide.setText("Vehide: " + vehide_text)

        val back = findViewById<Button>(R.id.btnback)
        back.setOnClickListener {
        finish()
        }
        }
        var lastTime: Long = 0
        override fun finish(){
        val time = System.currentTimeMillis()
        if (time - lastTime > 3 * 1000){
        lastTime = time
        Toast.makeText(this,"在案一次離開", Toast.LENGTH_LONG).show()
        }else {
        super.finish()
        }
        }
        }

