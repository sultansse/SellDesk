package com.software1t.selldesk.data

import android.annotation.SuppressLint
import com.software1t.selldesk.R
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import java.text.SimpleDateFormat
import java.util.Date

class MyData {
    companion object {
        @SuppressLint("SimpleDateFormat")
        val formatter = SimpleDateFormat("dd MMMM")
        val currentDate = formatter.format(Date())

        val myData: List<CarUiModel> = listOf(
            CarUiModel(
                id = 0,
                name = "Toyota",
                price = "7 000 000 tenge",
                image = R.drawable.ic_launcher_foreground,
                description = "some car description and lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
                city = "Almaty",
                isLiked = false,
                postDate = currentDate,
                postViewedCount = 1212,
                postLikedCount = 15,
            ),
            CarUiModel(
                id = 0,
                name = "Toyota",
                price = "7 000 000 tenge",
                image = R.drawable.ic_launcher_foreground,
                description = "some car description and lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
                city = "Almaty",
                isLiked = false,
                postDate = currentDate,
                postViewedCount = 1212,
                postLikedCount = 15,
            ),
            CarUiModel(
                id = 0,
                name = "Toyota",
                price = "7 000 000 tenge",
                image = R.drawable.ic_launcher_foreground,
                description = "some car description and lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
                city = "Almaty",
                isLiked = false,
                postDate = currentDate,
                postViewedCount = 1212,
                postLikedCount = 15,
            ),
            CarUiModel(
                id = 0,
                name = "Toyota",
                price = "7 000 000 tenge",
                image = R.drawable.ic_launcher_foreground,
                description = "some car description and lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
                city = "Almaty",
                isLiked = false,
                postDate = currentDate,
                postViewedCount = 1212,
                postLikedCount = 15,
            ),
            CarUiModel(
                id = 0,
                name = "Toyota",
                price = "7 000 000 tenge",
                image = R.drawable.ic_launcher_foreground,
                description = "some car description and lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
                city = "Almaty",
                isLiked = false,
                postDate = currentDate,
                postViewedCount = 1212,
                postLikedCount = 15,
            ),
            CarUiModel(
                id = 0,
                name = "Toyota",
                price = "7 000 000 tenge",
                image = R.drawable.ic_launcher_foreground,
                description = "some car description and lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
                city = "Almaty",
                isLiked = false,
                postDate = currentDate,
                postViewedCount = 1212,
                postLikedCount = 15,
            ),
            CarUiModel(
                id = 0,
                name = "Toyota",
                price = "7 000 000 tenge",
                image = R.drawable.ic_launcher_foreground,
                description = "some car description and lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
                city = "Almaty",
                isLiked = false,
                postDate = currentDate,
                postViewedCount = 1212,
                postLikedCount = 15,
            ),
            CarUiModel(
                id = 0,
                name = "Toyota",
                price = "7 000 000 tenge",
                image = R.drawable.ic_launcher_foreground,
                description = "some car description and lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
                city = "Almaty",
                isLiked = false,
                postDate = currentDate,
                postViewedCount = 1212,
                postLikedCount = 15,
            ),

            )

    }
}