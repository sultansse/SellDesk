package com.software1t.selldesk.data

import android.annotation.SuppressLint
import com.software1t.selldesk.R
import com.software1t.selldesk.data.model.CategoryDataModel
import com.software1t.selldesk.presentation.home_screen.model.CarUiModel
import com.software1t.selldesk.presentation.home_screen.model.CategoryUiModel
import java.text.SimpleDateFormat
import java.util.Date

class MyData {
    companion object {
        @SuppressLint("SimpleDateFormat")
        val formatter = SimpleDateFormat("dd MMMM")
        val currentDate = formatter.format(Date())

        val myData: List<CarUiModel> = listOf(
            CarUiModel(
                id = 1,
                name = "Lexus",
                price = "9 500 000 tenge",
                image = R.drawable.ic_launcher_foreground,
                description = "Luxurious Lexus with advanced features and superior performance. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                city = "Astana",
                isLiked = true,
                postDate = currentDate,
                postViewedCount = 1500,
                postLikedCount = 25,
            ), CarUiModel(
                id = 2,
                name = "Honda",
                price = "5 200 000 tenge",
                image = R.drawable.ic_launcher_foreground,
                description = "Efficient Honda model perfect for city commuting. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                city = "Almaty",
                isLiked = true,
                postDate = currentDate,
                postViewedCount = 1000,
                postLikedCount = 18,
            ), CarUiModel(
                id = 3,
                name = "BMW",
                price = "12 000 000 tenge",
                image = R.drawable.ic_launcher_foreground,
                description = "Sporty BMW with cutting-edge technology and dynamic performance. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                city = "Shymkent",
                isLiked = false,
                postDate = currentDate,
                postViewedCount = 2000,
                postLikedCount = 30,
            ), CarUiModel(
                id = 4,
                name = "Toyota",
                price = "7 800 000 tenge",
                image = R.drawable.ic_launcher_foreground,
                description = "Reliable Toyota known for durability and comfortable rides. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                city = "Karaganda",
                isLiked = false,
                postDate = currentDate,
                postViewedCount = 1700,
                postLikedCount = 22,
            ), CarUiModel(
                id = 5,
                name = "Audi",
                price = "10 500 000 tenge",
                image = R.drawable.ic_launcher_foreground,
                description = "Elegant Audi model with luxurious interiors and innovative technology. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                city = "Aktobe",
                isLiked = false,
                postDate = currentDate,
                postViewedCount = 1800,
                postLikedCount = 27,
            ), CarUiModel(
                id = 6,
                name = "Mercedes-Benz",
                price = "11 700 000 tenge",
                image = R.drawable.ic_launcher_foreground,
                description = "Classy Mercedes-Benz offering comfort, style, and cutting-edge features. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                city = "Pavlodar",
                isLiked = false,
                postDate = currentDate,
                postViewedCount = 1900,
                postLikedCount = 28,
            ), CarUiModel(
                id = 7,
                name = "Nissan",
                price = "6 500 000 tenge",
                image = R.drawable.ic_launcher_foreground,
                description = "Nissan model known for reliability and advanced technology. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                city = "Taraz",
                isLiked = true,
                postDate = currentDate,
                postViewedCount = 1600,
                postLikedCount = 20,
            ), CarUiModel(
                id = 8,
                name = "Chevrolet",
                price = "8 300 000 tenge",
                image = R.drawable.ic_launcher_foreground,
                description = "Chevrolet with a blend of performance and affordability. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                city = "Kostanay",
                isLiked = false,
                postDate = currentDate,
                postViewedCount = 1750,
                postLikedCount = 23,
            )
        )

        val categories: List<CategoryDataModel> = listOf(
            CategoryDataModel(
                title = "Машины",
                icon = R.drawable.ic_heart_filled,
            ),
            CategoryDataModel(
                title = "Страхование",
                icon = R.drawable.ic_heart_filled,
            ),
            CategoryDataModel(
                title = "Новые авто",
                icon = R.drawable.ic_heart_filled,
            ),
            CategoryDataModel(
                title = "Запчасти",
                icon = R.drawable.ic_heart_filled,
            ),
            CategoryDataModel(
                title = "Штрафы и сервисы",
                icon = R.drawable.ic_heart_filled,
            ),
            CategoryDataModel(
                title = "Ремонт и услуги",
                icon = R.drawable.ic_heart_filled,
            ),
        )
//
//        val categories: CategoryUiModel = CategoryUiModel(
//            id = 0,
//            title1 = "Машины",
//            title2 = "Страхование",
//            title3 = "Новые авто",
//            title4 = "Запчасти",
//            title5 = "Штрафы и сервисы",
//            title6 = "Ремонт и услуги",
//
//            image1 = R.drawable.ic_heart_filled,
//            image2 = R.drawable.ic_heart_filled,
//            image3 = R.drawable.ic_heart_filled,
//            image4 = R.drawable.ic_heart_filled,
//            image5 = R.drawable.ic_heart_filled,
//            image6 = R.drawable.ic_heart_filled,
//        )
    }
}