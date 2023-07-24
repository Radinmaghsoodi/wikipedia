package ir.radindev.Wikipedia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import ir.radindev.Wikipedia.databinding.ActivityMainBinding
import ir.radindev.Wikipedia.fragments.FragmentExplore
import ir.radindev.Wikipedia.fragments.FragmentProfile
import ir.radindev.Wikipedia.fragments.FragmentTrend


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
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
                    binding.DrawerLayoutMain.closeDrawer(GravityCompat.START)
                    val dialog=SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                            dialog.titleText= "Alert!"
                            dialog.confirmText="confirm"
                            dialog.cancelText="Cancel"
                            dialog.contentText="Wanna be a Writer?"
                    dialog.setCancelClickListener {
                        dialog.dismiss()
                    }
                    dialog.setConfirmClickListener {
                        val url = "https://en.wikipedia.org/wiki/Main_Page"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        startActivity(intent)

                        dialog.dismiss()
                    }
                    dialog.show()
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


    fun replaceFragment(fragment : Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container,fragment)
        transaction.commit()
    }

    fun firstRun(){
        replaceFragment(FragmentExplore())
        binding.bottomNavigationMain.selectedItemId=R.id.menu_explore

    }
}