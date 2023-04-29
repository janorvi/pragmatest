package com.example.pragmatest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pragmatest.viewmodel.MainViewModel
import com.example.pragmatest.databinding.ActivityMainBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private var mainActivityBinding: ActivityMainBinding? = null

    var groupAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)

        mainActivityBinding?.catsRecyclerView?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)

        mainViewModel.catList.observe(this){ catList ->
            catList?.forEach { cat ->
                groupAdapter.add(CatItem(cat))
            }
            mainActivityBinding?.catsRecyclerView?.adapter = groupAdapter
        }

        mainViewModel.catListFailed.observe(this){ message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        mainActivityBinding?.getCatsButton?.setOnClickListener{
            mainViewModel.getCatList()
        }

        setContentView(mainActivityBinding?.root)
    }
}