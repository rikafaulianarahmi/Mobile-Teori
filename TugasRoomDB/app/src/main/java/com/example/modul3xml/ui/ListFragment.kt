package com.example.modul3xml.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modul3xml.MyApplication
import com.example.modul3xml.R
import com.example.modul3xml.databinding.FragmentListBinding
import timber.log.Timber

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: LegoViewModel
    private lateinit var legoAdapter: LegoAdapter
    private lateinit var highlightAdapter: HighlightAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = (requireActivity().application as MyApplication).repository
        val factory = LegoViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[LegoViewModel::class.java]

        highlightAdapter = HighlightAdapter()
        binding.rvHighlight.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.HORIZONTAL, false
        )
        binding.rvHighlight.adapter = highlightAdapter

        legoAdapter = LegoAdapter(
            onDetailClick = { item ->
                Timber.d("Detail → ${item.legoSet.title}")
                val bundle = Bundle().apply {
                    putString("lego_title", item.legoSet.title)
                    putInt("lego_year", item.legoSet.year)
                    putInt("lego_pieces", item.legoSet.pieces)
                    putString("lego_description", item.legoSet.description)
                    putString("lego_url", item.legoSet.webUrl)
                    putInt("lego_image", item.legoSet.imageRes)
                    putString("lego_theme", item.theme.name)
                }
                findNavController().navigate(R.id.action_list_to_detail, bundle)
            },
            onWebClick = { item ->
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.legoSet.webUrl))
                startActivity(intent)
            }
        )
        binding.rvLego.layoutManager = LinearLayoutManager(requireContext())
        binding.rvLego.adapter = legoAdapter

        viewModel.allSetsWithTheme.observe(viewLifecycleOwner) { list ->
            legoAdapter.updateData(list)
            highlightAdapter.updateData(list)
        }

        binding.btnLanguage.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_languageFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}