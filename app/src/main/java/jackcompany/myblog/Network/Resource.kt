package jackcompany.myblog.Network

import java.sql.ClientInfoStatus

data class Resource<out T>(val status: Status,val message: String?, val data : T){
    companion object{
        fun <T> Sucess(data : T): Resource<T>{
            return Resource(Status.SUCESS,null,data)
        }

        fun <T> Error(message: String?, data : T): Resource<T>{
            return Resource(Status.ERROR, message,data)
        }

        fun <T> loading(data : T) : Resource<T>{
            return Resource(Status.LOADING,null,data)
        }
    }
}


