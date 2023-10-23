package com.example.pdf_assignment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.pdf_assignment.databinding.FragmentPdfDescriptionBinding
import com.example.pdf_assignment.model.PdfModel


class PdfDescriptionFragment : Fragment() {

    private lateinit var binding: FragmentPdfDescriptionBinding
    private var pdfModel: PdfModel? = null
    var isExpanded = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentPdfDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pdfModel = requireArguments().getParcelable("pdfModel", PdfModel::class.java)

        setUpViews()

        // Tried to fit the image as shown in figma but the aspect ratio of image is too small
        binding.imgOne.apply {
            scaleType = ImageView.ScaleType.FIT_CENTER
            adjustViewBounds = true
        }

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_pdfDescriptionFragment_to_homeFragment)
        }
    }

    // setting up the views
    private fun setUpViews() {
        binding.apply {
            pdfName.text = pdfModel?.pdfName
            // Show read more text only of the description length is more than 200 words
            if (pdfModel?.description?.length!! > 200) {
                pdfDescription.text = pdfModel?.description?.substring(0, 200)
            } else {
                pdfDescription.text = pdfModel?.description?.substring(
                    0,
                    pdfModel?.description?.length!!
                )
            }
            pdfPrice.text = pdfModel?.price.toString()
            imgOne.setImageDrawable(pdfModel?.image)
            imgTwo.setImageDrawable(pdfModel?.image)
            imgThree.setImageDrawable(pdfModel?.image)
            imgFour.setImageDrawable(pdfModel?.image)
            imgFive.setImageDrawable(pdfModel?.image)
        }

        // handling the show more or less logic
        binding.readMore.setOnClickListener {
            if (isExpanded) {
                if (pdfModel?.description?.length!! > 200) {
                    binding.pdfDescription.text = pdfModel?.description?.substring(0, 200)
                } else {
                    binding.pdfDescription.text = pdfModel?.description?.substring(
                        0,
                        pdfModel?.description?.length!!
                    )
                }
                binding.readMore.text = "Show More"
                isExpanded = false
            } else {
                binding.pdfDescription.text = pdfModel?.description
                binding.readMore.text = "Show Less"
                isExpanded = true
            }
        }
    }

}