package kr.ac.kumoh.ce.s20200694.s23termproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class GameViewModel: ViewModel() {
    private val SERVER_URL = "https://port-0-s23w10backend-1igmo82clookyw7l.sel5.cloudtype.app/"
    private val gameApi: GameApi
    private val _gameList = MutableLiveData<List<Game>>()
    val gamelist: LiveData<List<Game>>
        get() = _gameList

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        gameApi = retrofit.create(GameApi::class.java)
        fetchData()
    }

    private fun fetchData(){
        viewModelScope.launch{
            try{
                val response = gameApi.getGames()
                _gameList.value = response
            }catch (e: Exception){
                Log.e("fetchData()", e.toString())
            }
        }
    }
}