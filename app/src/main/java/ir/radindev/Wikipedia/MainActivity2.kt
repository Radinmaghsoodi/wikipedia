package ir.radindev.Wikipedia

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import ir.radindev.Wikipedia.data.ItemPost
import ir.radindev.Wikipedia.databinding.ActivityMain2Binding
import ir.radindev.Wikipedia.fragments.SEND_DATA_TO_SECOND_ACTIVITY

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarAsli)
        binding.collapsingMain.setExpandedTitleColor(
            ContextCompat.getColor(this, android.R.color.transparent)
        )
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        val dataPost = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_SECOND_ACTIVITY)
        if (dataPost != null) {
            showData(dataPost)

        }

    }

    private fun showData(itemPost: ItemPost) {

            Glide
            .with(this)
            .load(itemPost.imgUrl)
            .into(binding.imgDatail)
        binding.txtDetailTitle.text=itemPost.txtTitle
        binding.txtDetailSubtitle.text=itemPost.txtSubTitle
        binding.txtDetailText.text=itemPost.txtDetail

        binding.fabMain.setOnClickListener {
            val url = "https://en.wikipedia.org/wiki/Main_Page"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }

        return true
    }
}