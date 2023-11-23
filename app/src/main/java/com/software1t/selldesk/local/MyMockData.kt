package com.software1t.selldesk.local

import com.software1t.selldesk.R
import com.software1t.selldesk.data.model.CategoryDataModel
import com.software1t.selldesk.local.model.CarLocalModel


class MyMockData {
    companion object {

        val myMockCars: List<CarLocalModel> = listOf(

            CarLocalModel(
                id = 1,
                name = "Lexus",
                price = 9500000,
                image = R.drawable.ic_launcher_app,
                description = "Luxurious Lexus with advanced features and superior performance. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                city = "Astana",
                isLiked = true,
                postDate = "2023-12-31",
                postViewedCount = 1500,
                postLikedCount = 25,
            ), CarLocalModel(
                id = 2,
                name = "Honda",
                price = 5200000,
                image = R.drawable.ic_launcher_app,
                description = "Efficient Honda model perfect for city commuting. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                city = "Almaty",
                isLiked = true,
                postDate = "2023-12-31",
                postViewedCount = 1000,
                postLikedCount = 18,
            ), CarLocalModel(
                id = 3,
                name = "BMW",
                price = 1200000,
                image = R.drawable.ic_launcher_app,
                description = "Sporty BMW with cutting-edge technology and dynamic performance. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                city = "Shymkent",
                isLiked = false,
                postDate = "2023-12-31",
                postViewedCount = 2000,
                postLikedCount = 30,
            ), CarLocalModel(
                id = 4,
                name = "Toyota",
                price = 7800000,
                image = R.drawable.ic_launcher_app,
                description = "Reliable Toyota known for durability and comfortable rides. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                city = "Karaganda",
                isLiked = false,
                postDate = "2023-12-31",
                postViewedCount = 1700,
                postLikedCount = 22,
            ), CarLocalModel(
                id = 5,
                name = "Audi",
                price = 10500000,
                image = R.drawable.ic_launcher_app,
                description = "Elegant Audi model with luxurious interiors and innovative technology. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                city = "Aktobe",
                isLiked = false,
                postDate = "2023-12-31",
                postViewedCount = 1800,
                postLikedCount = 27,
            ), CarLocalModel(
                id = 6,
                name = "Mercedes-Benz",
                price = 11700000,
                image = R.drawable.ic_launcher_app,
                description = "Classy Mercedes-Benz offering comfort, style, and cutting-edge features. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                city = "Pavlodar",
                isLiked = false,
                postDate = "2023-12-31",
                postViewedCount = 1900,
                postLikedCount = 28,
            ), CarLocalModel(
                id = 7,
                name = "Nissan",
                price = 6500000,
                image = R.drawable.ic_launcher_app,
                description = "Nissan model known for reliability and advanced technology. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                city = "Taraz",
                isLiked = true,
                postDate = "2023-12-31",
                postViewedCount = 1600,
                postLikedCount = 20,
            ), CarLocalModel(
                id = 8,
                name = "Chevrolet",
                price = 8300000,
                image = R.drawable.ic_launcher_app,
                description = "Chevrolet with a blend of performance and affordability. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                city = "Kostanay",
                isLiked = false,
                postDate = "2023-12-31",
                postViewedCount = 1750,
                postLikedCount = 23,
            )
        )

        val categories: List<CategoryDataModel> = listOf(
            CategoryDataModel(
                title = "Машины",
                icon = R.drawable.ic_favorite_filled,
            ),
            CategoryDataModel(
                title = "Страхование",
                icon = R.drawable.ic_favorite_filled,
            ),
            CategoryDataModel(
                title = "Новые авто",
                icon = R.drawable.ic_favorite_filled,
            ),
            CategoryDataModel(
                title = "Запчасти",
                icon = R.drawable.ic_favorite_filled,
            ),
            CategoryDataModel(
                title = "Штрафы и сервисы",
                icon = R.drawable.ic_favorite_filled,
            ),
            CategoryDataModel(
                title = "Ремонт и услуги",
                icon = R.drawable.ic_favorite_filled,
            ),
            CategoryDataModel(
                title = "Авто от SellDesk",
                icon = R.drawable.ic_favorite_filled,
            ),
            CategoryDataModel(
                title = "Sell Desk Гид",
                icon = R.drawable.ic_favorite_filled,
            ),
        )
    }
}