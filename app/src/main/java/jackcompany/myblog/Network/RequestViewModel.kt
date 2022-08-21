package jackcompany.myblog.Network

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jackcompany.myblog.modelclass.RetrivePost.Item
import jackcompany.myblog.modelclass.RetrivePost.RetriveAllPostRes
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RequestViewModel : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Resource.Error(throwable.message, null)
    }

    private val reutrnList = MutableLiveData<Resource<List<Item>>>()

    fun getAllPostfromBlog() {
        reutrnList.postValue(Resource.loading(null))

        try {
            viewModelScope.launch(exceptionHandler){
                withContext(Dispatchers.IO){
                    val response= MyApiClass().getAllPost()

                    if (response.isSuccessful){
                        reutrnList.postValue(Resource.Sucess(response.body()?.items!!))
                    }else{
                        reutrnList.postValue(Resource.Error(response.errorBody().toString(), null))
                    }

                }
            }

        } catch (e: Exception) {
            reutrnList.postValue(Resource.Error(e.message, null))
        }

    }

    fun getData(): LiveData<Resource<List<Item>>> {
        return reutrnList
    }

}

private fun <T> MutableLiveData<T>.postValue(loading: Resource<Nothing?>) {

}
