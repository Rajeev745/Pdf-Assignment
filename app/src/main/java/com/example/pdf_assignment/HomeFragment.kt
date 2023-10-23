package com.example.pdf_assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pdf_assignment.adapter.PdfItemClickListener
import com.example.pdf_assignment.adapter.PdfRecyclerViewAdapter
import com.example.pdf_assignment.databinding.FragmentHomeBinding
import com.example.pdf_assignment.model.PdfModel

class HomeFragment : Fragment(), PdfItemClickListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerViewAdapter: PdfRecyclerViewAdapter
    private lateinit var pdfViewmodel: PdfViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initializing the viewmodel
        pdfViewmodel = ViewModelProvider(requireActivity()).get(PdfViewmodel::class.java)
        pdfViewmodel.setData(requireContext())

        // Initializing adapter
        recyclerViewAdapter = PdfRecyclerViewAdapter()
        recyclerViewAdapter.setOnItemClickListener(this)

        // Observing pdf list from viewmodel
        pdfViewmodel.pdfList.observe(viewLifecycleOwner, Observer {
            recyclerViewAdapter.submitList(it)
            recyclerViewAdapter.notifyDataSetChanged()
        })

        setUpRecyclerView()

        // Navogate to the pdf Page
        binding.continueReadingBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_pdfReaderFragment)
        }

        binding.progressBar.progress = 50
    }

    private fun setUpRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = recyclerViewAdapter
        }
    }

    // On click of pdf item list navigate to description page of that fragment
    override fun pdfItemOnClickListener(pdfModel: PdfModel, itemPosition: Int) {
        val bundle = Bundle()
        bundle.putParcelable("pdfModel", pdfModel)

        findNavController().navigate(R.id.action_homeFragment_to_pdfDescriptionFragment, bundle)
    }

}