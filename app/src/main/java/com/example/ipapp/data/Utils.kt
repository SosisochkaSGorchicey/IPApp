package com.example.ipapp.data

import com.example.ipapp.R
import java.io.EOFException
import java.io.IOException
import java.net.SocketException
import java.net.UnknownHostException

fun Int.httpCodeToErrorMessage() = when (this) {
    400 -> R.string.http_400
    403 -> R.string.http_403
    404 -> R.string.http_404
    500 -> R.string.http_500
    502 -> R.string.http_502
    504 -> R.string.http_504
    else -> R.string.error
}

fun IOException.ioExceptionToNetworkResult() = when (this) {
    is EOFException -> R.string.io_eof
    is SocketException -> R.string.io_socket
    is UnknownHostException -> R.string.io_unknown
    else -> R.string.bad_connection
}