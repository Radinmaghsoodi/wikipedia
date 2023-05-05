package ir.radindev.Wikipedia.fragments

import android.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.radindev.Wikipedia.databinding.FragmentProfileBinding


class FragmentProfile : Fragment() {
lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
binding=FragmentProfileBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.instagram.setOnClickListener {
            val url = "https://instagram.com/radin.dev" // آدرس لینک مورد نظر را وارد کنید
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        binding.github.setOnClickListener {
            val url = "https://github.com/radinmaghsoodi" // آدرس لینک مورد نظر را وارد کنید
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        binding.linkdin.setOnClickListener {
            val url = "https://google.com" // آدرس لینک مورد نظر را وارد کنید
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        binding.radin.setOnClickListener {
            val url = "https://radindev.ir" // آدرس لینک مورد نظر را وارد کنید
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

    }
}