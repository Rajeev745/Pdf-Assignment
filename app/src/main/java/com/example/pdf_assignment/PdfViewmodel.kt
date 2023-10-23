package com.example.pdf_assignment

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pdf_assignment.model.PdfModel
import com.example.pdf_assignment.model.getList

class PdfViewmodel : ViewModel() {

    private val _pdfList = MutableLiveData<List<PdfModel>>()
    val pdfList: LiveData<List<PdfModel>>
        get() = _pdfList

    fun setData(context: Context) {
        val list = getList(context)
        _pdfList.postValue(list)
    }
}