package ir.radindev.Wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import ir.radindev.Wikipedia.databinding.ActivityMainBinding
import ir.radindev.Wikipedia.fragments.FragmentExplore
import ir.radindev.Wikipedia.fragments.FragmentProfile
import ir.radindev.Wikipedia.fragments.FragmentTrend

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMain)

        val actionBarDrawerToggle= ActionBarDrawerToggle(
            this,
            binding.DrawerLayoutMain,
            binding.toolbarMain,
            R.string.openDrawer,
            R.string.closeDrawer
        )

binding.DrawerLayoutMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        binding.NavigationViewMain.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_writer->
                {
                    Toast.makeText(this, "click menu_writer", Toast.LENGTH_SHORT).show()
                    binding.DrawerLayoutMain.closeDrawer(GravityCompat.START)
                }

                R.id.photographer->{}
                R.id.menu_video_maker->{}
                R.id.translate->{}
                // ---------------------------------------
                R.id.menu_open_wikipedia->{}
                R.id.openWikimedia->{}
            }
            true
        }

        firstRun()
        binding.bottomNavigationMain.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_explore->{
                replaceFragment(FragmentExplore())
                }
                R.id.menu_trend->{
                    replaceFragment(FragmentTrend())
                }
                R.id.menu_profile->{
                    replaceFragment(FragmentProfile())
                }
            }
            true

        }
        binding.bottomNavigationMain.setOnItemReselectedListener {  }

    }


    fun replaceFragment(fragment :Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container,fragment)
        transaction.commit()
    }

    fun firstRun(){
        replaceFragment(FragmentExplore())
        binding.bottomNavigationMain.selectedItemId=R.id.menu_explore

    }
}