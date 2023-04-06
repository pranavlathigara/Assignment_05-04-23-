package com.example.assignment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.assignment.adapter.ImagePagerAdapter
import com.example.assignment.adapter.LabelsAdapter
import com.example.assignment.databinding.ActivityMainBinding
import com.example.assignment.viewmodels.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(), TextWatcher {

    var viewModel: MainViewModel? = null
    private lateinit var _binding: ActivityMainBinding
    private lateinit var labelAdapter: LabelsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel?.loadImages()
        viewModel?.loadList()

        initRv()
        observeImages()
        observeLabelsData()
        shuffleLabelList()
        _binding.etSearch.addTextChangedListener(this)
    }

    // Observe slider image data
    fun observeImages() {
        viewModel?.getImages()?.observe(this, Observer {
            _binding.viewPager.apply {
                adapter = ImagePagerAdapter(context).apply {
                    items = it
                    notifyDataSetChanged()
                }
            }
            TabLayoutMediator(_binding.indicator, _binding.viewPager) { _, _ -> }.attach()
        })
    }

    // Shuffle list on carousel image changed
    private fun shuffleLabelList() {
        _binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                labelAdapter.shuffleData()
                super.onPageSelected(position)
            }
        })
    }

    // Observe Label data
    fun observeLabelsData() {
        viewModel?.getLabels()?.observe(this, Observer {
            labelAdapter.setData(it)
        })
    }

    // Init Recyclerview
    fun initRv() {
        _binding.rvLabels.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        labelAdapter = LabelsAdapter()
        _binding.rvLabels.adapter = labelAdapter
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        labelAdapter.filter.filter(s.toString())
    }

    override fun afterTextChanged(s: Editable?) {

    }
}



