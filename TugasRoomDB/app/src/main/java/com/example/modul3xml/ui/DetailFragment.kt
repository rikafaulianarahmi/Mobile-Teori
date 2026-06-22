package com.example.modul3xml.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.modul3xml.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments ?: return

        val title = args.getString("lego_title") ?: "-"
        val year = args.getInt("lego_year")
        val pieces = args.getInt("lego_pieces")
        val description = args.getString("lego_description") ?: "-"
        val imageRes = args.getInt("lego_image")
        val theme = args.getString("lego_theme") ?: "-"

        binding.ivDetail.setImageResource(imageRes)
        binding.tvTitleDetail.text = title
        binding.tvDescDetail.text =
            "Tema: $theme\n" +
                    "Tahun Rilis: $year\n" +
                    "Jumlah Kepingan: $pieces\n\n" +
                    "Deskripsi:\n$description"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}