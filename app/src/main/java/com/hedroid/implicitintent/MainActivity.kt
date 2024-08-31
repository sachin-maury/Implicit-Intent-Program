package com.hedroid.implicitintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.hedroid.implicitintent.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        binding.OpenWebPage.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/sachin-maury"))
            startActivity(intent)

        }
        binding.OpenPhoneCall.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: +1234567890")
            startActivity(intent)

        }
        binding.OpenCamera.setOnClickListener{
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)

        }
       binding.TextShareButton.setOnClickListener{
           val text:String = binding.TextShareButton.toString()
           val intent = Intent(Intent.ACTION_SEND)
           intent.type= "text/plain"
           intent.putExtra(Intent.EXTRA_TEXT,text)
           startActivity(Intent.createChooser(intent,"Share Via"))

       }

    }
}