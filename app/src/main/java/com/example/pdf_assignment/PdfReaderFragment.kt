package com.example.pdf_assignment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pdf_assignment.databinding.FragmentPdfReaderBinding
import com.pspdfkit.configuration.PdfConfiguration
import com.pspdfkit.configuration.page.PageScrollDirection
import com.pspdfkit.ui.PdfFragment

class PdfReaderFragment : Fragment() {

    private lateinit var binding: FragmentPdfReaderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPdfReaderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadPdf()
    }

    /**
     * Tried to load the pdf in that fragment itself but was unable to do so
     * therefore opening a new fragment and also tried to perform operation like cut copy search
     * on pdf  but unable to do so.
     * Therefore only opening a fragment with the PDF.*/
    private fun loadPdf() {
        val uri = Uri.parse("file:///android_asset/coding-interview.pdf")
        val configuration = PdfConfiguration.Builder()
            .scrollDirection(PageScrollDirection.VERTICAL)
            .enableMagnifier(true)
            .build()
        val fragment = PdfFragment.newInstance(uri, configuration)

        childFragmentManager.beginTransaction()
            .replace(R.id.pdf_reader_fragment_container, fragment)
            .commit()
    }


}