
package com.example.cupcake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cupcake.databinding.FragmentStartBinding
import com.example.cupcake.model.OrderViewModel

/**
 * merupakan tampilan awal atau halaman pertama dalam aplikasi cupcake, dimana pengguna akan mengakses
 * fitur yang disediakan untuk memesan cupcake.
 */
class StartFragment : Fragment() {

    private var binding: FragmentStartBinding? = null


    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.startFragment = this
    }

    /**
     * memesan orderan sesuai banyaknya yang dipesan oleh user dan selanjutnya akan diarahkan ke laman berikutnya
     * untuk menyelesaikan pesanan cupcake.
     */
    fun orderCupcake(quantity: Int) {

        sharedViewModel.setQuantity(quantity)


        if (sharedViewModel.hasNoFlavorSet()) {
            sharedViewModel.setFlavor(getString(R.string.vanilla))
        }


        findNavController().navigate(R.id.action_startFragment_to_flavorFragment)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}