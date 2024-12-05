package lms_books

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket
import java.util.*

object PrimeClient {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        val serverAddress = "localhost" // Replace with server IP if needed
        val port = 12345 // The port number used by the server

        try {
            Socket(serverAddress, port).use { socket ->
                val out = PrintWriter(socket.getOutputStream(), true)
                val `in` = BufferedReader(InputStreamReader(socket.getInputStream()))

                print("Enter a number to evaluate: ")
                val number = scanner.nextInt()

                // Send number to the server
                out.println(number)

                // Read response from server
                val response = `in`.readLine()
                println("The response from the server is: $response")
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}