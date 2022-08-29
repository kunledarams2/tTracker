package com.e.ttracker

sealed class NavigationItem (var title:String, var icon:Int, var route:String){
    object Home: NavigationItem("Home", R.drawable.ic_vector, "home")
    object Search: NavigationItem("Search", R.drawable.ic_baseline_search_24, "search")
    object Notification : NavigationItem("Notification", R.drawable.ic_group_1029,"notification")
    object Setting : NavigationItem("Setting", R.drawable.ic_outline_settings_24,"setting")


}
