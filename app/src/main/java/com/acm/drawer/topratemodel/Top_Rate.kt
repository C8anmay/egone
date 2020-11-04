package com.acm.drawer.topratemodel

data class Top_Rate(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)