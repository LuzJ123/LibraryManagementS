package lms_books

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import kotlin.math.sqrt

object PrimeServer {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            ServerSocket(12345).use { serverSocket ->  // Listening on port 12345
                println("Server started, waiting for client connections...")
                while (true) {
                    val clientSocket = serverSocket.accept()
                    println("Client connected")

                    // Set up input and output streams for communication
                    val `in` = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
                    val out = PrintWriter(clientSocket.getOutputStream(), true)

                    // Read the number from the client
                    val line = `in`.readLine()
                    val number = line.toInt()
                    val isPrime = checkPrime(number)

                    // Send the response back to the client
                    out.println(if (isPrime) "The number is a prime number" else "The number is NOT a prime number")

                    clientSocket.close()
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun checkPrime(number: Int): Boolean {
        if (number <= 1) return false
        var i = 2
        while (i <= sqrt(number.toDouble())) {
            if (number % i == 0) return false
            i++
        }
        return true
    }
}