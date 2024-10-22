package com.rasya.a9_24_latihan4_recyclerview

import android.animation.ObjectAnimator
import android.content.ContentValues.TAG
import android.nfc.Tag
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.DataSource
import com.rasya.a9_24_latihan4_recyclerview.databinding.ActivityMainBinding
import kotlin.math.log

private lateinit var binding : ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showRecyclerView()
    }

    private fun showRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        val dataList = ObjectData.getDataList()
        val adapter = Adapter(dataList)
        recyclerView.adapter = adapter
    }

    private fun showRecyclerGrid() {
        val recyclerGrid = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerGrid.layoutManager = GridLayoutManager(this, 2)
        recyclerGrid.setHasFixedSize(true)
        val dataList = ObjectData.getDataList()
        val adapter = GridAdapter(dataList)
        recyclerGrid.adapter = adapter
    }

    private fun showRecyclerCardView() {
        val recyclerGrid = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerGrid.layoutManager = LinearLayoutManager(this)
        recyclerGrid.setHasFixedSize(true)
        val dataList = ObjectData.getDataList()
        val adapter = CardViewAdapter(dataList)
        recyclerGrid.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode : Int){
        when(selectedMode){
            R.id.action_list ->{
                showRecyclerView()
            }
            R.id.action_grid -> {
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
                showRecyclerCardView()
            }
        }
    }

}