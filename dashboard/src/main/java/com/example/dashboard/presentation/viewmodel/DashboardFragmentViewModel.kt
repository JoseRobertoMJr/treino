package com.example.dashboard.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import br.com.havan.common.domain.responses.ResultUseCase
import com.example.common.presentation.viewModel.SingleLiveEvent
import com.example.common.presentation.viewModel.ViewStates
import com.example.common.presentation.viewModel.base.BaseViewModel
import com.example.dashboard.domain.model.FrutaEntity
import com.example.dashboard.domain.usecase.absctraction.FrutasUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DashboardFragmentViewModel(val useCase: FrutasUseCase):BaseViewModel(){

    private val _viewStates = SingleLiveEvent<ViewStates>()
    val viewStates: LiveData<ViewStates> = _viewStates

    private val _inserirFruta = SingleLiveEvent<ViewStates>()
    val inserirFruta: LiveData<ViewStates> = _inserirFruta

    fun getListaFrutas(){
        _viewStates.value = ViewStates.Carregando
        viewModelScope.launch {
            val response = withContext(Dispatchers.Default){
                 useCase.listarFrutas()
            }

            val responseAbrirVenda = when (response) {
                is ResultUseCase.Model<*> -> {
                    ViewStates.Sucesso(response.modelo as List<FrutaEntity>)
                }
                is ResultUseCase.Aviso -> ViewStates.Aviso(response.aviso)
                is ResultUseCase.Error -> ViewStates.Error(response.erro)
                is ResultUseCase.Login -> ViewStates.Login(response.erro)
            }
            _viewStates.value = responseAbrirVenda
        }
    }

    fun insertFruta(modelo: FrutaEntity){
        viewModelScope.launch {
            val response =
                withContext(Dispatchers.Default) { useCase.inserirFruta(modelo) }

            val responseInserirVenda = when (response) {
                is ResultUseCase.Model<*> -> {
                    ViewStates.Sucesso(response.modelo as Boolean)
                }
                is ResultUseCase.Aviso -> ViewStates.Aviso(response.aviso)
                is ResultUseCase.Error -> ViewStates.Error(response.erro)
                is ResultUseCase.Login -> ViewStates.Login(response.erro)
            }

            _inserirFruta.value = responseInserirVenda
        }
    }

}
