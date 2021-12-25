package com.example.navigationpractise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var toggle :ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       toggle=ActionBarDrawerToggle(this,drawyer_l,R.string.open,R.string.close)
        drawyer_l.addDrawerListener(toggle)
        toggle.syncState()


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

       bottom_nav_menu.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> Toast.makeText(applicationContext,"home is clicked", Toast.LENGTH_SHORT).show()
                R.id.settings -> startActivity(Intent(this,SettingsActivity::class.java))

                R.id.files -> Toast.makeText(applicationContext,"files is clicked", Toast.LENGTH_SHORT).show()
            }
           true
        }


     nav_view.setNavigationItemSelectedListener {

                drawyer_l.closeDrawer(GravityCompat.START)
                when(it.itemId){
                    R.id.profile -> {startActivity(Intent(this,SettingsActivity::class.java)) }
                    R.id.contact -> Toast.makeText(applicationContext,"contact is clicked",Toast.LENGTH_SHORT).show()
                    R.id.about -> Toast.makeText(applicationContext,"about is clicked",Toast.LENGTH_SHORT).show()
                }

         true
        }

    }


  override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
                 return true}
      when(item.itemId){
          R.id.item_delete-> Toast.makeText(applicationContext,"delete is clicked",Toast.LENGTH_SHORT).show()
          R.id.item2 -> Toast.makeText(applicationContext,"item 2 is clicked",Toast.LENGTH_SHORT).show()
      }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu,menu)
        return true
    }

}