package com.example.assignment.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment.R
import com.example.assignment.models.LabelData

class MainViewModel : ViewModel() {

    var mMutableLiveDataImages =
        MutableLiveData<List<Int>>()
    var mMutableLiveDataLabels =
        MutableLiveData<List<LabelData>>()


    fun getImages() = mMutableLiveDataImages
    fun getLabels() = mMutableLiveDataLabels

    fun loadImages() {
        mMutableLiveDataImages.value = listOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6
        )
    }

    fun loadList() {
        mMutableLiveDataLabels.value = listOf(
            LabelData(R.drawable.image1, "Lois Lane"),
            LabelData(R.drawable.image2, "Clark Kent"),
            LabelData(R.drawable.image3, "Ralph and Alice Kramden"),
            LabelData(R.drawable.image4, "Holly Golightly"),
            LabelData(R.drawable.image5, "Liza Doolittle"),
            LabelData(R.drawable.image6, "Henry Higgins"),
            LabelData(R.drawable.image1, "Joseph Arimathea"),
            LabelData(R.drawable.image2, "Mary Magdalene"),
            LabelData(R.drawable.image3, "Simon Cyrene"),
            LabelData(R.drawable.image4, "Melody Sunshine"),
            LabelData(R.drawable.image5, "Di Allysis"),
            LabelData(R.drawable.image6, "Marge Areen"),
            LabelData(R.drawable.image1, "Tiger Prawn"),
            LabelData(R.drawable.image2, "John Dory"),
            LabelData(R.drawable.image3, "Murray Cod"),
            LabelData(R.drawable.image4, "Barry Cuda"),
            LabelData(R.drawable.image5, "Coral Trout"),
            LabelData(R.drawable.image6, "Rock Lobster"),
            LabelData(R.drawable.image6, "John"),
            LabelData(R.drawable.image1, "Android"),
            LabelData(R.drawable.image2, "Apple"),
            LabelData(R.drawable.image3, "Samsung"),
            LabelData(R.drawable.image4, "Vivo"),
            LabelData(R.drawable.image5, "Oppo"),
            LabelData(R.drawable.image6, "Nokia")

        )
    }

}