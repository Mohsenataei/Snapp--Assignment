package io.github.maa96.basearch.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.android.support.DaggerDialogFragment
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseBottomSheet<V : BaseViewModel, B : ViewDataBinding> :
    BottomSheetDialogFragment(),
    BaseView<V, B> {

    private var _binding: B? = null
    override val binding: B
        get() = _binding
            ?: throw IllegalStateException("access to binding should between onCreateView and onDestroyView")


    @Inject
    override lateinit var viewModelFactory: ViewModelProvider.Factory


    /**
     * Attempt to get viewModel lazily from [viewModelFactory] with the scope of given activity.
     *
     * @param scope given scope.
     * @return T an instance of requested ViewModel.
     */
    inline fun <reified T : BaseViewModel> getLazyViewModel(scope: ViewModelScope): Lazy<T> =
        lazy {
            when (scope) {
                ViewModelScope.ACTIVITY -> ViewModelProvider(
                    requireActivity(),
                    viewModelFactory
                )[T::class.java]
                ViewModelScope.FRAGMENT -> ViewModelProvider(this, viewModelFactory)[T::class.java]
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // initialize binding
        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        // set viewModel as an observer to this activity lifecycle events
        lifecycle.addObserver(viewModel)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // observe viewModel uiActions in order to pass parent activity as argument of uiAction
//        viewModel.activityAction.observe(viewLifecycleOwner {
//            it.invoke(requireActivity())
//        })

//        viewModel.fragmentAction.observe(viewLifecycleOwner) {
//            it?.invoke(this)
//        }
        onViewInitialized(binding)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding?.unbind()
        _binding = null
    }

}

