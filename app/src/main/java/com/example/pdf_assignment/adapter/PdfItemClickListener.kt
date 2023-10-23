package com.example.pdf_assignment.adapter

import com.example.pdf_assignment.model.PdfModel

interface PdfItemClickListener {
    fun pdfItemOnClickListener(pdfModel: PdfModel, itemPosition: Int)
}